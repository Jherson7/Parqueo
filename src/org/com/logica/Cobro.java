package org.com.logica;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import org.com.bens.ticket;
import org.com.db.cobro_db;
//import java.util.Date;
import javax.swing.JOptionPane;
import org.com.bens.descuento;
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
            JOptionPane.showMessageDialog(null, "No se puede ingresar el codigo porque no ha iniciado turno porfavor aperture turno, y vuelva a generar ticket!","ERROR",0);
            return;
        }
        //select max_turno
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        
        ticket ticki = new ticket();
        
        ticki.setCodigo(codigo);
        ticki.setTurno(Controlador.getTurno_actual().getId_turno());
        ticki.setHora_ingreso(timestamp);
        
        System.out.println(codigo);
       /* cobro = new cobro_db();
        int a =cobro.insertar_ticket(ticki);
        
        if (a != 1) {
            JOptionPane.showMessageDialog(null, "Se inserto correctamente el ticket: " + codigo, "Panel de Cobro", 1);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR al insertar el ticket: " + codigo, "Panel de Cobro", 0);
        }
        //si se comparte el */
    }
    
    private static monto_cobro get_tarifa_por_parqueo_y_horario(int idparqueo,ticket tick){
        
        LinkedList<tarifa> lista = cobro.get_tarifas_de_parqueo(idparqueo);
        Timestamp actual = new Timestamp(System.currentTimeMillis());

        monto_cobro mon = new monto_cobro();
        mon.detalles.add("Detalle de cobro por horario:");
        //fecha actual
        int dias = actual.getDate();
        
        int dia_inicio_parqueo = tick.getHora_ingreso().getDate();
        int hora_actual = actual.getHours();
        
        if (Math.abs(dias - dia_inicio_parqueo) >= 1) {//tarifa de dias
            mon.detalles.add("Total dias: " + Math.abs(dias - dia_inicio_parqueo));
            mon.costo = Math.abs(dias - dia_inicio_parqueo) * 100.0;
            return mon;
        } else {
            //verifico en tarifas nocturas
            for (tarifa f : lista) {
                int hora_inicio = f.getHora_inicio_tarifa().getHours();
                int hora_fin = f.getHora_fin_tarifa().getHours();
                String men = "";
                float total_horas = 0;

                if (tick.getHora_ingreso().getHours()>= hora_inicio && hora_actual <=hora_fin) {//tarifa noctura
                    men = new SimpleDateFormat("HH:mm").format(f.getHora_inicio_tarifa()) + " - " + new SimpleDateFormat("HH:mm").format(f.getHora_fin_tarifa());
                    total_horas = hora_fin - tick.getHora_ingreso().getHours();
                    total_horas += tick.getHora_ingreso().getMinutes()/60;//se suman los minutos
                    total_horas+=actual.getMinutes()/60;//se suman los minutos
                    men += ": Q." + total_horas * f.getPrecio();
                    mon.costo = total_horas * f.getPrecio();
                    mon.detalles.add(men);
                    mon.setTarifa(f.getPrecio());//seteo el precio de la tarifa para descuentos
                    return mon;
                }
            }
            //no encontro tarifa tiene mas de un horario
            return calculo_varias_tarifas(lista,tick, actual);
        }
    }
    
    private static monto_cobro calculo_varias_tarifas(LinkedList<tarifa> lista_actual, ticket tick,Timestamp actual){
        
        monto_cobro mon = new monto_cobro();
        double costo=0;
        
        LinkedList<tarifa> lista = new LinkedList<>();
        
        for (tarifa f : lista_actual) {
            if(f.getHora_fin_tarifa().getHours()<actual.getHours())
                lista.add(f);
            else{
                lista.add(f);
                break;
            }
        }
        
        mon.detalles.add("Detalle de cobro por horario:");
        
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
                total_horas += tick.getHora_ingreso().getMinutes()/60;//se suman los minutos
               
            } else if (i == lista.size()-1) {
                total_horas = actual.getHours() - hora_inicio;
                total_horas += actual.getMinutes()/60;//se suman los minutos
            }else{
                total_horas=actual.getHours()-tick.getHora_ingreso().getHours();
            }
            
            men += ": Q." + total_horas * f.getPrecio();
            costo += total_horas * f.getPrecio();
            mon.detalles.add(men);
        }
        mon.setCosto(costo);
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
     
    /*private static Double get_costo_horas_en_parqueo(Timestamp fecha_ticket,int idparqueo){
        
        Timestamp actual = new Timestamp(System.currentTimeMillis());
        
        //fecha actual
        int dias  = actual.getDate();
        int horas = actual.getHours();
        int min   = actual.getMinutes();
        
        int dia_inicio_parqueo = fecha_ticket.getDate();
        int hora_inicio_parqueo = fecha_ticket.getHours();
        int min_inicio_parqueo = fecha_ticket.getMinutes();
        
        Double total_horas =0.0;
        
        if(Math.abs(dias - dia_inicio_parqueo)>=1){//tarifa de dias
            return Math.abs(dias - dia_inicio_parqueo)*100.0;
        }else{//tarifas dependiendo el horario
            
            total_horas+= Math.abs(horas - hora_inicio_parqueo);
            total_horas+= Math.abs(min-min_inicio_parqueo)/60;//revisar si da bien el resultado
            
            return total_horas* tarifa;
        }
    }*/

    public static int  realizar_cobro_extraviado(ticket ticket) {
        cobro = new cobro_db();
        int codigo = cobro.get_max_id_ticket();
        ticket.setCodigo(""+codigo);
        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        
        ticket.setHora_ingreso(timestamp);
        ticket.setHora_salida(timestamp);
        
        return cobro.insertar_ticket_extraviado(ticket);
        
        
        
    }
    
}
