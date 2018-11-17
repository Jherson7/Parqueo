package org.com.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import org.com.bens.tarifa;

/**
 *
 * @author Jherson
 */
public class tarifa_db {
    ResultSet res;
    Conexion con;
    
    
    public tarifa_db() {
        con = Conexion.getInstancia();
    }
    
    
    public List<tarifa> retornarLista(){
        List<tarifa> lista = new LinkedList<>();
        try {
            con.setPreparado(con.getConn().prepareStatement("select t.idTARIFA,  t.Precio,t.hora_inicio_tarifa, t.hora_fin_tarifa,t.fPARQUEO, p.nombre_parqueo " +
            "from tarifa t inner join parqueo p on t.fPARQUEO = p.idparqueo;"));
            res=con.getPreparado().executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
     
        try {
            while(res.next()){
                tarifa au= new tarifa(res.getInt(1), res.getDouble(2), res.getTime(3), res.getTime(4), res.getInt(5), res.getString(6));
                lista.add(au);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de Tarifas: "+ex.getLocalizedMessage());
        }
        return lista;
    }
    
    public Integer agregar_tarifa(tarifa tar){
         try {
            con.setPreparado(con.getConn().prepareStatement("insert into tarifa(precio,hora_inicio_tarifa,hora_fin_tarifa,fparqueo) values(?,?,?,?)"));
            con.getPreparado().setDouble(1, tar.getPrecio());
            con.getPreparado().setTime(2, tar.getHora_inicio_tarifa());
            con.getPreparado().setTime(3, tar.getHora_fin_tarifa());
            con.getPreparado().setInt(4,tar.getfPARQUEO());
            
            con.getPreparado().executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar tarifa a DB"+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
     }
    
    public int modificar_tarifa(tarifa tar){
         try {
            con.setPreparado(con.getConn().prepareStatement("update tarifa set precio=?,hora_inicio_tarifa=?,hora_fin_tarifa=?,fparqueo=? where idtarifa= ?"));
            con.getPreparado().setDouble(1, tar.getPrecio());
            con.getPreparado().setTime(2, tar.getHora_inicio_tarifa());
            con.getPreparado().setTime(3, tar.getHora_fin_tarifa());
            con.getPreparado().setInt(4,tar.getfPARQUEO());
            con.getPreparado().setInt(5, tar.getIdTARIFA());
            
            con.getPreparado().executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println("Error al modificar tarifa a DB"+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
    }
    
    
     public int eliminar_tarifa(tarifa tar){
         try {
            con.setPreparado(con.getConn().prepareStatement("delete from tarifa where idtarifa= ?"));
            con.getPreparado().setInt(1, tar.getIdTARIFA());
            
            con.getPreparado().executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar tarifa a DB"+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
    }
     
    public int get_max_id(){
        try {
            con.setPreparado(con.getConn().prepareStatement("select max(idtarifa) from tarifa"));
            res=con.getPreparado().executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
     
        try {
            if(res.next()){
               return res.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el maxID de Tarifas: "+ex.getLocalizedMessage());
        }
        return -1;
    }
    
    
}
