package org.com.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.com.bens.reporte_estadistica;
import org.com.bens.reporte_hora_fecha_beans;

/**
 *
 * @author Jherson
 */
public class reportes_db {
    ResultSet res;
    Conexion con;
    
     public reportes_db() {
        con = Conexion.getInstancia();
    }
    
    public List<reporte_hora_fecha_beans> retornar_reporte_hora_fecha(Date date){
        List<reporte_hora_fecha_beans> lista = new LinkedList<>();
        
        String query ="select  hour(hora_salida) as 'Hora  Salida', sum(total) as total,hora_ingreso  \n" +
                        "as fecha from ticket where CAST(hora_ingreso as date) = ? \n" +
                        "group by hour(hora_salida), day(hora_salida)";
        
        try {
            con.setPreparado(con.getConn().prepareStatement(query));
            con.getPreparado().setDate(1, new java.sql.Date(date.getTime()));
            
            res=con.getPreparado().executeQuery();
            while(res.next()){
                reporte_hora_fecha_beans par= new reporte_hora_fecha_beans(res.getInt(1),  res.getDouble(2),res.getTimestamp(3));
                lista.add(par);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
     
        return lista;
    }
    
    
    public List<reporte_hora_fecha_beans> retornar_por_fechas(Date desde,Date hasta){
        List<reporte_hora_fecha_beans> lista = new LinkedList<>();
        
            
        String query ="select sum(total) as TOTAL, hora_ingreso as FECHA from ticket WHERE \n" +
                       "hora_ingreso between  ? and ? group by day(hora_ingreso)";
        try {
            con.setPreparado(con.getConn().prepareStatement(query));
            con.getPreparado().setDate(1, new java.sql.Date(desde.getTime()));
            con.getPreparado().setDate(2, new java.sql.Date(hasta.getTime()));
            
            res=con.getPreparado().executeQuery();
            while(res.next()){
                reporte_hora_fecha_beans par= new reporte_hora_fecha_beans(0,  res.getDouble(1),res.getTimestamp(2));
                lista.add(par);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
     
        return lista;
    }
    
    
    public List<reporte_estadistica> retornar_reporte_estadistica_vehiculos(Date date,Date hasta){
        List<reporte_estadistica> lista = new LinkedList<>();
        
        String query="select hora_salida  as fecha, count(1) as 'Total de Vehiculos', count(1)/24 as 'Promedio por Hora'   from ticket\n" +
        "  WHERE  hora_salida between  ? and ? group by   day(hora_salida) ";
        
        try {
            
            con.setPreparado(con.getConn().prepareStatement(query));
            con.getPreparado().setDate(1, new java.sql.Date(date.getTime()));
            con.getPreparado().setDate(2, new java.sql.Date(hasta.getTime()));
            
            res=con.getPreparado().executeQuery();
            int cont =1;
            while(res.next()){
                reporte_estadistica par= new reporte_estadistica(res.getTimestamp(1),res.getInt(2),  res.getFloat(3),cont++);
                lista.add(par);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
     
        return lista;
    }
    
}
