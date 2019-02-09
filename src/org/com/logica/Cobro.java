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
import org.com.vistas.cobrar_ticket;


/**
 *
 * @author Jherson
 */
public class Cobro {
    
    static cobro_db cobro;
    
    
    public static monto_cobro calcular_costo(String codigo,int id_descuento){
        
        cobro = new cobro_db();
        
        codigo = codigo.substring(codigo.indexOf("+")+1);
        int i =0;
        for(; i< codigo.length();i++)
        {
            char x = codigo.charAt(i);
            if(x!='0')
                break;
        }
        codigo = codigo.substring(i);
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
        
        //descomentar estas lineas para insertar el ticket
        cobro = new cobro_db();
        int a =cobro.insertar_ticket(ticki);
        
        if (a != 1) {
            //JOptionPane.showMessageDialog(null, "Se inserto correctamente el ticket: " + codigo, "Panel de Cobro", 1);
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
       
        String fecha = new SimpleDateFormat("yyyy/MM/dd").format(tick.getHora_ingreso());
        int diferencia = cobro.diferencia_entre_dias(fecha,get_fecha());
        
        //if (Math.abs(dias - dia_inicio_parqueo) >= 1) {//tarifa de dias
        if (diferencia >= 1) {//tarifa de dias
            return retonar_cobro_por_dias(tick, lista, actual, diferencia);
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
               /* total_horas=  (float) ((double)(t_min_salida) / 60.0);
                total_horas+= ((double)(60-t_min_ingreso))/ 60;
                total_horas += (t_hora_salida - t_hora_ingreso);
                
                mon.costo += total_horas * lista.getLast().getPrecio();//se multiplica por el costo de la ultima tarifa
                mon.costo = Double.parseDouble(formatter.format(mon.costo));//formateamos el costo
                */
               
                String men = t_hora_ingreso+":"+t_min_ingreso + " - " + new SimpleDateFormat("HH:mm").format(actual);
               // men+=" Q."+ Double.parseDouble(formatter.format(total_horas * lista.getLast().getPrecio()));
              // mon.costo=lista.getLast().getPrecio(); 
               //men+=" Q."+ Double.parseDouble(formatter.format(lista.getLast().getPrecio()));
                men+=" Q.0.00";//+ Double.parseDouble(formatter.format(lista.getLast().getPrecio()));
                mon.detalles.add(men);
                return mon;
            } else {
                //es porque salio antes que comenzara el horario de apertura y se cobran 100 
                if (t_hora_ingreso <= parqueo_actual.getHora_fin() && t_hora_salida < parqueo_actual.getHora_inicio()) {
                   /* total_horas =  (float) ((double)(t_min_salida) / 60.0);
                    if(t_min_ingreso>0)
                        total_horas += ((double)(60-t_min_ingreso) )/ 60;
                    
                    total_horas += (parqueo_actual.getHora_fin() - t_hora_ingreso);
                    
                    mon.costo += total_horas * lista.getLast().getPrecio();//se multiplica por el costo de la ultima tarifa
                    
                    mon.costo = Double.parseDouble(formatter.format(mon.costo));
                    */
                    //mon.costo = lista.getLast().getPrecio();
                    String men = new SimpleDateFormat("HH:mm").format(tick.getHora_ingreso())+" - " +parqueo_actual.getHora_fin()+":00";
                    //men+=" Q."+ Double.parseDouble(formatter.format(total_horas * lista.getLast().getPrecio()));
                    men+=" Q.0.00";//+ Double.parseDouble(formatter.format(lista.getLast().getPrecio()));
                    
                    mon.detalles.add(men);

                    mon.costo += 100;
                    men = parqueo_actual.getHora_fin()+":00  - " + new SimpleDateFormat("HH:mm").format(actual);
                    men+=" Q.100.00";
                    mon.detalles.add(men);

                    return mon;
                }

                //esta condicion es porque salio despues del horario de apertura
                //por tanto debe realizarse el cobro de los demas horarios
                if (t_hora_ingreso <= parqueo_actual.getHora_fin() && t_hora_salida >= parqueo_actual.getHora_inicio()) {
                   
                    /*if(t_min_ingreso>0)
                        total_horas =  (float) ((double)((60-t_min_ingreso)) / 60.0);
                    total_horas += (parqueo_actual.getHora_fin() - t_hora_ingreso);
                    mon.costo += total_horas * lista.getLast().getPrecio();//se multiplica por el costo de la ultima tarifa
                    */
                    //mon.costo+=lista.getLast().getPrecio();
                    String men = new SimpleDateFormat("HH:mm").format(tick.getHora_ingreso())+" - " +parqueo_actual.getHora_fin()+":00";
                    men+=" Q.0.00";//+ Double.parseDouble(formatter.format(lista.getLast().getPrecio()));
                    mon.detalles.add(men);
                    
                    mon.costo += 100;
                    
                    men = parqueo_actual.getHora_fin()+":00  - " + parqueo_actual.getHora_inicio()+":00";
                    men+=" Q.100.00";
                    mon.detalles.add(men);
                    
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
                        
                        //aqui preguntar si es tarifa unica....
                        
                        if(t_min_ingreso>0)
                            total_horas = t_hora_salida - t_hora_ingreso-1;//se resta - 1 porque ahi van los minutos
                        else 
                            total_horas = t_hora_salida - t_hora_ingreso;
                               
                        
                        boolean menos_de_la_hora=false;
                        if(total_horas<0){
                            total_horas=0;
                            menos_de_la_hora=true;
                            
                        }
                        if(t_min_ingreso>0){//minutos de ingreso
                            if((60-t_min_ingreso)<=30)
                                total_horas +=.5;//se suman los minutos
                            else
                                total_horas+=1;
                        }
                        
                        if (!menos_de_la_hora) {
                            //minutos de salida
                            if (actual.getMinutes() <= 30) {
                                total_horas += .5;//se suman los minutos
                            } else {
                                total_horas += 1;
                            }
                        }
                          
                        // total_horas += (double)actual.getMinutes() / 60;//se suman los minutos
                                                    
                        //total_horas= roundToHalf(total_horas);
                        //se agrega una nueva condicion si es la ultima tarifa
                        //es decir la ultima solo se cobra el precio, no se multiplica por las horas
                        
                        if (f == lista.getLast()) {
                            mon.costo+=f.getPrecio();
                            men += ": Q." + formatter.format(f.getPrecio());
                        } else {
                            double aux = ((total_horas - (int)total_horas)>0)?1:0;//se cobra lo que se haya generado de media hora
                            mon.costo+= aux*f.getMedia_hora();
                            mon.costo += ((int)total_horas) * f.getPrecio();
                            mon.setTarifa(f.getPrecio());//seteo el precio de la tarifa para descuentos
                            mon.setCosto_media_hora(f.getMedia_hora());
                            men += ": Q." + formatter.format(mon.costo);
                        }

                        mon.detalles.add(men);
                        //mon.costo = Double.parseDouble(formatter.format(mon.costo));
                       
                        return mon;
                    }
                }
                //no encontro tarifa tiene mas de un horario
                return calculo_varias_tarifas(lista, tick, actual,mon);
            }
    }
    
    private static double roundToHalf(double d) {
        System.out.println(Math.round(d));
        return Math.round(d * 2) / 2.0;
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
            int t_min_ingreso=tick.getHora_ingreso().getMinutes();
            double total_horas = 0;
            String men = "";
            men = new SimpleDateFormat("HH:mm").format(f.getHora_inicio_tarifa()) + " - " + new SimpleDateFormat("HH:mm").format(f.getHora_fin_tarifa());
            if (i == 0) {//primer horario 
                mon.setTarifa(f.getPrecio());//seteo la primer tarifa para descuentos
                //se resta la hora de ingreso del vehiculo - la 
                if(t_min_ingreso>0)
                            total_horas = hora_fin - tick.getHora_ingreso().getHours()-1;//se resta - 1 porque ahi van los minutos
                        else 
                            total_horas = hora_fin - tick.getHora_ingreso().getHours();
                //total_horas = hora_fin - tick.getHora_ingreso().getHours()-1;
                if(total_horas<0)
                            total_horas=0;
                
                if (t_min_ingreso > 0) {//minutos de ingreso
                    if ((60 - t_min_ingreso) <= 30) {
                        total_horas += .5;//se suman los minutos
                    } else {
                        total_horas += 1;
                    }
                }
               // total_horas += (double)(60-tick.getHora_ingreso().getMinutes())/60;//se suman los minutos
              //  total_horas = roundToHalf(total_horas);
            } else if (i == lista.size()-1) {//es la ultima tarifa
                /*total_horas = actual.getHours() - hora_inicio;
                total_horas += (double)actual.getMinutes()/60;//se suman los minutos*/
                total_horas=1;
            }else{
                total_horas=actual.getHours()-tick.getHora_ingreso().getHours();
            }
            
            
            /*----------------------*/
            double aux = ((total_horas - (int)total_horas)>0)?1:0;//se cobra lo que se haya generado de media hora
            costo+= aux*f.getMedia_hora();
            costo += ((int)total_horas) * f.getPrecio();
            mon.setTarifa(f.getPrecio());//seteo el precio de la tarifa para descuentos
            mon.setCosto_media_hora(f.getMedia_hora());
            /*----------------------*/
            men += ": Q." +formatter.format(costo) ;
            //costo += total_horas * f.getPrecio();
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
        parqueo par = Controlador.getParqueo();
        monto_cobro nuevo = new monto_cobro();
        
        nuevo.detalles.add("Total dias: " + dias);
        nuevo.detalles.add("--------------------------");

        nuevo.detalles.add("Detalle de cobro por horario:");
        nuevo.detalles.add("--------------------------");
        Timestamp auxiliar = new Timestamp(System.currentTimeMillis());
        
        if (dias == 1) {
            
            auxiliar.setHours(23);
            auxiliar.setMinutes(59);
            
            nuevo = realizar_cobro_normal(par, lista, tick, auxiliar, nuevo);
            
            tick.getHora_ingreso().setHours(0);
            tick.getHora_ingreso().setMinutes(0);
            
            nuevo = realizar_cobro_normal(par, lista, tick, actual, nuevo);
            
            return nuevo;
        }else{
            //retonar cobro por mas de un dia
            for(int i=0; i<=dias;i++){
                if(i==0){//primer dia
                    auxiliar.setHours(23);
                    auxiliar.setMinutes(59);
                    nuevo = realizar_cobro_normal(par, lista, tick, auxiliar, nuevo);
                    
                }else if(i==dias){//ultimo dia
                    tick.getHora_ingreso().setHours(0);
                    tick.getHora_ingreso().setMinutes(0);
            
                    nuevo = realizar_cobro_normal(par, lista, tick, actual, nuevo);
                    
                }else{//dia intermedio
                     double costo = retornar_dia_completo(lista, par);
                     nuevo.detalles.add("Costo por dia completo: "+costo);
                     nuevo.costo+=costo;
                }
            }return nuevo;
        }
    }
    
    private static double retornar_dia_completo(LinkedList<tarifa> lista,parqueo par){
        double costo =0;
        
        for(tarifa t: lista){
            if(t==lista.getLast())
                costo+= t.getPrecio();
            else
                costo+= Math.abs(t.getHora_fin_tarifa().getHours()-t.getHora_inicio_tarifa().getHours())*t.getPrecio();
        }
        costo+=100;//por quedarse en el parqueo cuando cerro
        //costo+= par.getHora_fin()*lista.getLast().getPrecio();//las horas de media noche hasta que cierra el parqueo
        
        return costo;
    }

     private static  String get_fecha() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String fecha = new SimpleDateFormat("yyyy/MM/dd").format(timestamp);

        return fecha;

    }
    
}
