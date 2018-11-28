package org.com.logica;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import org.com.bens.ticket;
import org.com.db.cobro_db;
//import java.util.Date;
import javax.swing.JOptionPane;
import org.com.bens.descuento;
import org.com.bens.parqueo;
import org.com.bens.tarifa;


/**
 *
 * @author Jherson
 */
public class Cobro {
    
    static cobro_db cobro;
    
    
    public static monto_cobro calcular_costo(String codigo,int id_descuento){
        
        cobro = new cobro_db();
        
        ticket tick = cobro.get_ticket_por_codigo(codigo);
        
        monto_cobro monto = get_tarifa_por_parqueo_y_horario(Controlador.getParqueo().getId_parqueo(),tick);
        
        Double subtotal = monto.costo;
        /*
        if(id_descuento>0){
            desc=cobro.get_descuento_por_id(id_descuento);
        }
        
        if(desc!=null&&monto.tarifa>0){
            if(desc.getPorcetaje()>0){
                descuento = (desc.getPorcetaje()/100)*subtotal;//descuento por porcentaje
            }else{
                float calculo = desc.getMinutos_descuento();
                calculo = calculo/60;
                descuento = calculo*monto.tarifa;//descuento por minutos
            }
        }*/
        
        tick.setSubtotal(subtotal);
        tick.setDescuento(0);
        tick.setTotal(subtotal);
        
        monto.setTicket(tick);
        // realizar el cobro
        // si es correcto abrir perciana
        // esperar que pase el carro
        // cerrar la perciana
        return monto;
    }
    
    public static void insertar_ticket(String codigo){
        if(Controlador.getTurno_actual()==null){
         Controlador.agregarTicketPendiente(codigo);
            //JOptionPane.showMessageDialog(null, "No se puede ingresar el codigo porque no ha iniciado turno porfavor aperture turno, y vuelva a generar ticket!","ERROR",0);
            return;
        }
        //select max_turno
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        
        ticket ticki = new ticket();
        
        ticki.setCodigo(codigo);
        ticki.setTurno(Controlador.getTurno_actual().getId_turno());
        ticki.setHora_ingreso(timestamp);
        
        System.out.println(codigo);
        
        //descomentar esta linea para insertar el ticket
       /* cobro = new cobro_db();
        int a =cobro.insertar_ticket(ticki);
        
        if (a != 1) {
            JOptionPane.showMessageDialog(null, "Se inserto correctamente el ticket: " + codigo, "Panel de Cobro", 1);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR al insertar el ticket: " + codigo, "Panel de Cobro", 0);
        }
        //si se comparte el */
    }
    
    private static monto_cobro get_tarifa_por_parqueo_y_horario(int idparqueo, ticket tick) {

        parqueo parqueo_actual = Controlador.getParqueo();
        LinkedList<tarifa> lista = cobro.get_tarifas_de_parqueo(idparqueo);
        Timestamp actual = new Timestamp(System.currentTimeMillis());

        monto_cobro mon = new monto_cobro();
        mon.detalles.add("Detalle de cobro por horario:");
        //fecha actual
        int dias = actual.getDate();

        int dia_inicio_parqueo = tick.getHora_ingreso().getDate();

        if (Math.abs(dias - dia_inicio_parqueo) >= 1) {//tarifa de dias
            mon.detalles.add("Total dias: " + Math.abs(dias - dia_inicio_parqueo));
            return retonar_cobro_por_dias(tick, lista, actual, Math.abs(dias - dia_inicio_parqueo));
            //return mon;
        } else {    
            return realizar_cobro_normal(parqueo_actual, lista, tick, actual, mon);
        }
    }
    
    
    private static monto_cobro realizar_cobro_normal(parqueo parqueo_actual,LinkedList<tarifa> lista,ticket tick,Timestamp actual,monto_cobro mon){
            int t_hora_ingreso = tick.getHora_ingreso().getHours();
            int t_hora_salida = actual.getHours();
            int t_min_ingreso = tick.getHora_ingreso().getMinutes();
            int t_min_salida = actual.getMinutes();

            NumberFormat formatter = new DecimalFormat("#0.00");    
            
            double total_horas = 0;

            if (t_hora_salida <= parqueo_actual.getHora_fin()) {
                //es porque ingreso despues de media noche
                //y salio antes del horario de finalizacion
                total_horas=  (float) ((double)(t_min_salida) / 60.0);
                total_horas+= ((double)(60-t_min_ingreso) )/ 60;
                total_horas += (t_hora_salida - t_hora_ingreso);
                mon.costo += total_horas * lista.getLast().getPrecio();//se multiplica por el costo de la ultima tarifa
                return mon;
            } else {
                //es porque salio antes que comenzara el horario de apertura y se cobran 100 
                if (t_hora_ingreso <= parqueo_actual.getHora_fin() && t_hora_salida <= parqueo_actual.getHora_inicio()) {
                    total_horas =  (float) ((double)(t_min_salida) / 60.0);
                    total_horas += ((double)(60-t_min_ingreso) )/ 60;
                    total_horas += (parqueo_actual.getHora_fin() - t_hora_ingreso);
                    
                    mon.costo += total_horas * lista.getLast().getPrecio();//se multiplica por el costo de la ultima tarifa
                    mon.costo += 100;
                    
                    mon.costo = Double.parseDouble(formatter.format(mon.costo));
                    return mon;
                }

                //esta condicion es porque salio despues del horario de apertura
                //por tanto debe realizarse el cobro de los demas horarios
                if (t_hora_ingreso <= parqueo_actual.getHora_fin() && t_hora_salida >= parqueo_actual.getHora_inicio()) {
                    total_horas =  (float) ((double)((60-t_min_ingreso)) / 60.0);
                    total_horas = (parqueo_actual.getHora_fin() - t_hora_ingreso);
                    mon.costo += total_horas * lista.getLast().getPrecio();//se multiplica por el costo de la ultima tarifa
                    mon.costo += 100;
                    
                    tick.getHora_ingreso().setHours(parqueo_actual.getHora_inicio());//seteo el horario para que 
                    tick.getHora_ingreso().setMinutes(0);//cobre con las demas tarifas normales
                    t_hora_ingreso=parqueo_actual.getHora_inicio();
                    t_min_ingreso=0;
                }

                for (tarifa f : lista) {
                    int hora_inicio = f.getHora_inicio_tarifa().getHours();
                    int hora_fin = f.getHora_fin_tarifa().getHours();
                    String men = "";

                    if (t_hora_ingreso   >= hora_inicio && t_hora_salida <= hora_fin) {//tarifa noctura
                        men = new SimpleDateFormat("HH:mm").format(f.getHora_inicio_tarifa()) + " - " + new SimpleDateFormat("HH:mm").format(f.getHora_fin_tarifa());
                        total_horas = t_hora_salida - t_hora_ingreso;
                        
                        if(t_min_ingreso>0)
                            total_horas +=(float) ((double)((60-t_min_ingreso)) / 60.0);//se suman los minutos
                        total_horas += (double)actual.getMinutes() / 60;//se suman los minutos
                        men += ": Q." + formatter.format(total_horas * f.getPrecio());
                        mon.costo += total_horas * f.getPrecio();
                        mon.detalles.add(men);
                        mon.setTarifa(f.getPrecio());//seteo el precio de la tarifa para descuentos
                        mon.costo = Double.parseDouble(formatter.format(mon.costo));
                        return mon;
                    }
                }
                //no encontro tarifa tiene mas de un horario
                return calculo_varias_tarifas(lista, tick, actual,mon);
            }
    }
    
    
    
    private static monto_cobro calculo_varias_tarifas(LinkedList<tarifa> lista_actual, ticket tick,Timestamp actual,monto_cobro mon){
        
        double costo=0;
        NumberFormat formatter = new DecimalFormat("#0.00");    
        LinkedList<tarifa> lista = new LinkedList<>();
        
        for (tarifa f : lista_actual) {
            if(f.getHora_fin_tarifa().getHours()<actual.getHours())
                lista.add(f);
            else{
                lista.add(f);
                break;
            }
        }
        
        for (int i = 0; i < lista.size(); i++) {
            tarifa f = lista.get(i);
            int hora_inicio = f.getHora_inicio_tarifa().getHours();
            int hora_fin = f.getHora_fin_tarifa().getHours();
            float total_horas = 0;
            String men = "";
            men = new SimpleDateFormat("HH:mm").format(f.getHora_inicio_tarifa()) + " - " + new SimpleDateFormat("HH:mm").format(f.getHora_fin_tarifa());
            if (i == 0) {//primer horario 
                mon.setTarifa(f.getPrecio());//seteo la primer tarifa para descuentos
                //se resta la hora de ingreso del vehiculo - la 
                total_horas = hora_fin - tick.getHora_ingreso().getHours();
                total_horas += (double)(60-tick.getHora_ingreso().getMinutes())/60;//se suman los minutos
               
            } else if (i == lista.size()-1) {
                total_horas = actual.getHours() - hora_inicio;
                total_horas += (double)actual.getMinutes()/60;//se suman los minutos
            }else{
                total_horas=actual.getHours()-tick.getHora_ingreso().getHours();
            }
            
            men += ": Q." +formatter.format(total_horas * f.getPrecio()) ;
            costo += total_horas * f.getPrecio();
            mon.detalles.add(men);
        }
        mon.costo+=(costo);
        mon.costo = Double.parseDouble(formatter.format(mon.costo));
        return mon;
    }
   
    public static descuento get_descuento(int id){
        if(cobro==null){
            cobro=new cobro_db();
        }
        
        return cobro.get_descuento_por_id(id);
    }
    
    public static int realizar_cobro(ticket tick){
        cobro = new cobro_db();
        
        return cobro.actualizar_ticket(tick);
//        String estado = "Exitoso...";
      
        
    }
     
    public static int  realizar_cobro_extraviado(ticket ticket) {
        cobro = new cobro_db();
        int codigo = cobro.get_max_id_ticket();
        ticket.setCodigo(""+codigo);
        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        
        ticket.setHora_ingreso(timestamp);
        ticket.setHora_salida(timestamp);
        
        return cobro.insertar_ticket_extraviado(ticket);
    }

    private static monto_cobro retonar_cobro_por_dias(ticket tick, LinkedList<tarifa> lista, Timestamp actual,int dias) {
        
        if(dias==1){
            
        }
        
        return null;
        
    }
    
}
