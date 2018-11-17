package org.com.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import org.com.bens.descuento;
import org.com.bens.parqueo;

/**
 *
 * @author Jherson
 */
public class descuento_db {
    ResultSet res;
    Conexion con;
    
    
    public descuento_db() {
        con = Conexion.getInstancia();
    }
    
    public List<descuento> retornarLista(){
        List<descuento> lista = new LinkedList<>();
        try {
            con.setPreparado(con.getConn().prepareStatement("select * from descuento  order by  nombre_descuento ASC"));
            res=con.getPreparado().executeQuery();
        } catch (SQLException ex) {
            System.out.println("ERROR en la lista de Descuentos: "+ex.getLocalizedMessage());
        }
     
        try {
            while(res.next()){
                descuento des= new descuento(res.getInt(1),  res.getString(2),res.getInt(3),res.getDate(4),res.getInt(5));
                lista.add(des);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de Descuentos: "+ex.getLocalizedMessage());
        }
        return lista;
    }
    
    
    public int agregar_descuento(descuento des){
        
        try {
            con.setPreparado(con.getConn().prepareStatement("insert into descuento(nombre_descuento,porcentaje,fecha,minutos_de_descuento)values(?,?,?,?)"));
            con.getPreparado().setString(1, des.getNombre_descuento());
            con.getPreparado().setInt(2, des.getPorcetaje());
            con.getPreparado().setDate(3, new java.sql.Date(des.getFecha().getTime()));
            con.getPreparado().setInt(4, des.getMinutos_descuento());
            con.getPreparado().executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al insertar el DESCUENTO a DB"+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
    }
    
    
    public int editar_descuento(descuento par){
         try {
            con.setPreparado(con.getConn().prepareStatement("update descuento set nombre_descuento=?,porcentaje=?,fecha=?,minutos_de_descuento=? where iddescuento = ?"));
            con.getPreparado().setString(1, par.getNombre_descuento());
            con.getPreparado().setInt(2, par.getPorcetaje());
            con.getPreparado().setDate(3, new java.sql.Date(par.getFecha().getTime()));
            con.getPreparado().setInt(4, par.getMinutos_descuento());
            con.getPreparado().setInt(5, par.getId_descuento());
            
            con.getPreparado().executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al modificar el DESCUENTO a DB"+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
    }
    
    public int eliminar_descuento(descuento par){
          try {
            con.setPreparado(con.getConn().prepareStatement("delete from  descuento where idDescuento = ?"));
            con.getPreparado().setInt(1, par.getId_descuento());
            con.getPreparado().executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el DESCUENTO a DB"+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
    }
    
    public int get_max_id(){
        try {
            con.setPreparado(con.getConn().prepareStatement("select max(idDESCUENTO) from descuento"));
            res=con.getPreparado().executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
     
        try {
            if(res.next()){
               return res.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el maxID de DESCUENTOS: "+ex.getLocalizedMessage());
        }
        return -1;
    }
}
