package org.com.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import org.com.bens.turno;

/**
 *
 * @author Jherson
 */
public class turno_db {
    ResultSet res;
    Conexion con;
    
    
    public turno_db() {
        con = Conexion.getInstancia();
    }
    
    public turno aperturar_turno(int usuario,int parqueo){
        try {
            con.setPreparado(con.getConn().prepareStatement("call aperturar_turno(?,?)"));
            con.getPreparado().setInt(1, usuario);
            con.getPreparado().setInt(2, parqueo);
            
            res=con.getPreparado().executeQuery();

            if(res.next()){
                turno tr = new turno(res.getInt(1),res.getTimestamp(2),res.getTimestamp(3),res.getInt(4),res.getInt(5));
                return tr ;
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al aperturar el turno"+ex.getLocalizedMessage());
            return null;
        }
        return null;
    }
    
    
    public turno ultimo_turno(int usuario){
        LinkedList<turno>lista = new LinkedList<>();
        try {
            con.setPreparado(con.getConn().prepareStatement("select * from turno where fusuario =?"));
            con.getPreparado().setInt(1, usuario);
            
            res=con.getPreparado().executeQuery();

            while(res.next()){
                turno tr = new turno(res.getInt(1),res.getTimestamp(2),res.getTimestamp(3),res.getInt(4),res.getInt(5));
                lista.add(tr);
            }            

            if(lista.getLast().getHora_cierre()==null){
                return lista.get(lista.size()-2);
            }else{
                return lista.getLast();
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al consultar el ultimo turno"+ex.getLocalizedMessage());
            return null;
        }
    }
    
    public turno consultar_turno(int parqueo){
        try {
            con.setPreparado(con.getConn().prepareStatement("call consultar_turno(?)"));
            con.getPreparado().setInt(1, parqueo);
            
            res=con.getPreparado().executeQuery();

            if(res.next()){
                turno tr = new turno(res.getInt(1),res.getTimestamp(2),res.getTimestamp(3),res.getInt(4),res.getInt(5));
                return tr ;
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al aperturar el turno"+ex.getLocalizedMessage());
            return null;
        }
        return null;
    }
    //select sum(total) as total from ticket where fturno = turno;
    
    public double cerrar_turno(int turno,int parqueo){
        try {
            con.setPreparado(con.getConn().prepareStatement("call cerrar_turno(?,?)"));
            con.getPreparado().setInt(1, parqueo);
            con.getPreparado().setInt(2, turno);
            
            res=con.getPreparado().executeQuery();

            if(res.next()){
                return res.getDouble(1);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al cerrar el turno"+ex.getLocalizedMessage());
        }
        return -1.0;
    }
    
    
    public double saldo_ultimo_turno(int turno){
        try {
            con.setPreparado(con.getConn().prepareStatement("select sum(total) as total from ticket where fturno = ?"));
            con.getPreparado().setInt(1, turno);
            
            res=con.getPreparado().executeQuery();

            if(res.next()){
                return res.getDouble(1);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al consultar saldo del ultimo turno"+ex.getLocalizedMessage());
        }
        return -1.0;
    }
    
}
