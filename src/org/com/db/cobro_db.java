package org.com.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import org.com.Serial.impresion_de_ticket;
import org.com.bens.descuento;
import org.com.bens.reporte_turno_detallado;
import org.com.bens.tarifa;
import org.com.bens.ticket;
import org.com.logica.Controlador;

/**
 *
 * @author Jherson
 */
public class cobro_db {
    ResultSet res;
    Conexion con;
    
    
    public cobro_db() {
        con = Conexion.getInstancia();
    }
    
    public ticket get_ticket_por_codigo(String codigo){
        ticket tick=null;
        try {
            con.setPreparado(con.getConn().prepareStatement("select * from ticket where codigo= ?"));
            con.getPreparado().setString(1, codigo);
            res=con.getPreparado().executeQuery();
      
            if(res.next()){
                //Date date = res.getTimestamp(3);
                tick= new ticket(res.getInt(1),  res.getString(2),res.getTimestamp(3),res.getTimestamp(4),res.getDouble(5),res.getDouble(6),res.getDouble(7),res.getInt(8),res.getInt(9),res.getString(10));
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el ticket: "+ex.getLocalizedMessage());
        }
        return tick;
    }
    
    
    
    public Integer actualizar_ticket(ticket ticki){
          try {
            con.setPreparado(con.getConn().prepareStatement("call actualizar_ticket(?,?,?,?,?)"));
            con.getPreparado().setInt(1,ticki.getId_ticket());
            con.getPreparado().setDouble(2,ticki.getSubtotal());
            con.getPreparado().setDouble(3, ticki.getDescuento());
            con.getPreparado().setString(4, ticki.getFactura());
            con.getPreparado().setInt(5, Controlador.getTurno_actual().getId_turno());
            
            con.getPreparado().executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el ticket  a DB"+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
     }
    
    public Double get_tarifa_por_parqueo_y_horario(int id_parqueo){
        //select precio from tarifa where CURRENT_TIME() >= hora_fin_tarifa and CURRENT_TIME() <= hora_fin_tarifa and fPARQUEO = 2
        try {
            con.setPreparado(con.getConn().prepareStatement("call seleccionar_tarifa(?)"));
            con.getPreparado().setInt(1, id_parqueo);
            res=con.getPreparado().executeQuery();
            
            if(res.next()){
                return res.getDouble(1);
                //Integer idTARIFA, Double Precio, Time hora_inicio_tarifa, Time hora_fin_tarifa, Integer fPARQUEO,String parqueo) {
            }
        } catch (SQLException ex) {
            System.out.println("ERROR al obtener la tarifa del parqueo: "+ex.getLocalizedMessage());
        } 
        return -1.0;
    }
    
    public LinkedList<tarifa>get_tarifas_de_parqueo(int id_parqueo){
        
        Calendar now = Calendar.getInstance();
        int dia = (now.get(Calendar.DAY_OF_WEEK)-1);
        
        LinkedList<tarifa> lista = new LinkedList<>();
        try {
            String query ="select * from tarifa t inner join dias_tarifa dt "
                    + "on dt.fk_tarifa = t.idtarifa where t.fparqueo= "+id_parqueo+" and dt.dia_cod = "+dia;
            
            con.setPreparado(con.getConn().prepareStatement(query));
            res=con.getPreparado().executeQuery();
        
            while(res.next()){
                //(Integer idTARIFA, Double Precio, Double media_hora, int tarifa_unica, Time hora_inicio_tarifa, Time hora_fin_tarifa, Integer fPARQUEO, String parqueo) 
                tarifa par= new tarifa(res.getInt(1),res.getDouble(2), res.getDouble(3),res.getInt(4),res.getTime(5),res.getTime(6), id_parqueo, "");
                lista.add(par);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de tarifas del parqueo: "+ex.getLocalizedMessage());
        }
        return lista;
    }
    
    public descuento get_descuento_por_id(int id){
         descuento des=null;
        try {
            con.setPreparado(con.getConn().prepareStatement("select * from descuento where iddescuento =?"));
            con.getPreparado().setInt(1, id);
            res=con.getPreparado().executeQuery();
            
            if(res.next()){
                des= new descuento(res.getInt(1), res.getString(2),res.getInt(3), res.getDouble(4), res.getDate(5));
                //Integer idTARIFA, Double Precio, Time hora_inicio_tarifa, Time hora_fin_tarifa, Integer fPARQUEO,String parqueo) {
            }
        } catch (SQLException ex) {
            System.out.println("ERROR al obtener el descuento:"+ex.getLocalizedMessage());
        } 
        return des;
    }
    
    public int insertar_ticket(ticket ticki){
         try {
            con.setPreparado(con.getConn().prepareStatement("insert into ticket(codigo,hora_ingreso,fturno)values(?,?,?)"));
            con.getPreparado().setString(1,ticki.getCodigo());
            con.getPreparado().setTimestamp(2,ticki.getHora_ingreso());
            con.getPreparado().setInt(3, ticki.getTurno());
            
            con.getPreparado().executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar el ticket  a DB"+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
    }

    
    public int insertar_ticket_extraviado(ticket ticki){
         try {
            con.setPreparado(con.getConn().prepareStatement("insert into ticket(codigo,hora_ingreso,hora_salida,subtotal,descuento,total,fturno)values(?,?,?,?,?,?,?)"));
            con.getPreparado().setString(1,"EXT_"+ticki.getCodigo());
            con.getPreparado().setTimestamp(2,ticki.getHora_ingreso());
            con.getPreparado().setTimestamp(3,ticki.getHora_salida());
            con.getPreparado().setDouble(4, ticki.getSubtotal());
            con.getPreparado().setDouble(5, ticki.getDescuento());
            con.getPreparado().setDouble(6, ticki.getTotal());
            con.getPreparado().setInt(7, ticki.getTurno());
            
            con.getPreparado().executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar el ticket extraviado  a DB"+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
    }

    public int get_max_id_ticket(){
        try {
            con.setPreparado(con.getConn().prepareStatement("select max(idticket) from ticket"));
            res=con.getPreparado().executeQuery();
     
            if(res.next()){
                return res.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el max IDticket: "+ex.getLocalizedMessage());
        }
        return -1;
    }
    
    public int insertar_y_obtener_ticket(int id_parqueo){
         try {
            con.setPreparado(con.getConn().prepareStatement("insert into indice_ticket(idparqueo) values (?)",Statement.RETURN_GENERATED_KEYS));
            con.getPreparado().setInt(1, id_parqueo);
            
            con.getPreparado().executeUpdate();
            res=con.getPreparado().getGeneratedKeys();
            
            if(res.next())
                return res.getInt(1);
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar el ticket y obtener su ID  a DB"+ex.getLocalizedMessage());
            return -1;
        }
        return 0;
    }
    
    //dias_de_diferncia
    public int diferencia_entre_dias(String fecha,String fecha2){
        
        String query ="call dias_de_diferncia('"+fecha+"','"+fecha2+"')";
         try {
            con.setPreparado(con.getConn().prepareStatement(query));

            res=con.getPreparado().executeQuery();
            
            if(res.next())
                return Math.abs(res.getInt(1));
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener la diferencia en dias"+ex.getLocalizedMessage());
            return -1;
        }
        return 0;
    }
    
    
    // seccion de tickets 
    
    public void get_tickets_por_turno_dia(List<ticket>lista, String codigo){
       // LinkedList<ticket> lista = new LinkedList<>();
        ticket tick=null;
        String query ="select * from ticket where fturno_cierre is not null\n" +
                      "and hour(hora_salida) <=18 and fturno_cierre = "+codigo+" and fdescuento is null";
        try {
            con.setPreparado(con.getConn().prepareStatement(query));
           // con.getPreparado().setString(1, codigo);
            res=con.getPreparado().executeQuery();
      
            while(res.next()){
                //Date date = res.getTimestamp(3);
                tick= new ticket(res.getInt(1),  res.getString(2),res.getTimestamp(3),
                        res.getTimestamp(4),res.getDouble(5),res.getDouble(6),
                        res.getDouble(7),res.getInt(8),res.getInt(9),res.getString(10));
                
                lista.add(tick);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de tickets: "+ex.getLocalizedMessage());
        }
        //return lista;
    }

    public void get_ticket_por_turno_noche(List<ticket>lista,String codigo){
        ticket tick=null;
        String query ="select * from ticket where fturno_cierre is not null\n" +
                      "and hour(hora_salida) > 18 and fturno_cierre = "+codigo+" and fdescuento is null";
        try {
            con.setPreparado(con.getConn().prepareStatement(query));
           // con.getPreparado().setString(1, codigo);
            res=con.getPreparado().executeQuery();
      
            while(res.next()){
                //Date date = res.getTimestamp(3);
                tick= new ticket(res.getInt(1),  res.getString(2),res.getTimestamp(3),
                        res.getTimestamp(4),res.getDouble(5),res.getDouble(6),
                        res.getDouble(7),res.getInt(8),res.getInt(9),res.getString(10));
                
                lista.add(tick);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de tickets noche: "+ex.getLocalizedMessage());
        }
    }

    public LinkedList<ticket> get_ticket_por_turno_descuento(String codigo){
        LinkedList<ticket> lista = new LinkedList<>();
        ticket tick=null;
        String query ="select d.nombre_descuento, t.codigo,t.hora_ingreso,t.hora_salida,"
                    + "t.descuento,t.total,t.factura\n" +
                    "from ticket t inner join descuento d on t.fdescuento = d.iddescuento\n" +
                    "where fturno_cierre is not null and fturno_cierre = "+codigo;
        try {
            con.setPreparado(con.getConn().prepareStatement(query));
           // con.getPreparado().setString(1, codigo);
            res=con.getPreparado().executeQuery();
      
            while(res.next()){
                //Date date = res.getTimestamp(3);
                tick= new ticket(res.getInt(1),  res.getString(2),res.getTimestamp(3),
                        res.getTimestamp(4),res.getDouble(5),res.getDouble(6),
                        res.getDouble(7),res.getInt(8),res.getInt(9),res.getString(10));
                
                lista.add(tick);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de tickets: "+ex.getLocalizedMessage());
        }
        return lista;
    }

    public void get_ticket_por_turno_dia_descuento(List<reporte_turno_detallado>lista,String codigo){
        reporte_turno_detallado tick=null;
        String query ="select d.nombre_descuento, t.codigo,t.hora_ingreso,t.hora_salida,t.descuento,t.total,t.factura\n" +
                        "from ticket t inner join descuento d on t.fdescuento = d.iddescuento\n" +
                        "where fturno_cierre is not null AND hour(hora_salida) <= 18 and fturno_cierre = "+codigo;
        try {
            con.setPreparado(con.getConn().prepareStatement(query));
           // con.getPreparado().setString(1, codigo);
            res=con.getPreparado().executeQuery();
      
            while(res.next()){
                //Date date = res.getTimestamp(3);
                tick= new reporte_turno_detallado(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7) );
                
                lista.add(tick);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de tickets descuento dia: "+ex.getLocalizedMessage());
        }
    }
   
    public void get_ticket_por_turno_noche_descuento(List<reporte_turno_detallado>lista,String codigo){
        reporte_turno_detallado tick=null;
        String query ="select d.nombre_descuento, t.codigo,t.hora_ingreso,t.hora_salida,t.descuento,t.total,t.factura\n" +
                        "from ticket t inner join descuento d on t.fdescuento = d.iddescuento\n" +
                        "where fturno_cierre is not null AND hour(hora_salida) > 18 and fturno_cierre = "+codigo;
        try {
            con.setPreparado(con.getConn().prepareStatement(query));
           // con.getPreparado().setString(1, codigo);
            res=con.getPreparado().executeQuery();
      
            while(res.next()){
                //Date date = res.getTimestamp(3);
                tick= new reporte_turno_detallado(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7) );
                
                lista.add(tick);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de tickets descuento dia: "+ex.getLocalizedMessage());
        }
    }

}
