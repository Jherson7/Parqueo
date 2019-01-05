package org.com.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.com.bens.horario_parqueo;
import org.com.bens.parqueo;

/**
 *
 * @author Jherson
 */
public class parqueo_db {
    ResultSet res;
    Conexion con;
    
    
    public parqueo_db() {
        con = Conexion.getInstancia();
    }
    
    public List<parqueo> retornarLista(){
        List<parqueo> lista = new LinkedList<>();
        try {
            con.setPreparado(con.getConn().prepareStatement("select * from parqueo  order by  Nombre_parqueo ASC"));
            res=con.getPreparado().executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
     
        try {
            while(res.next()){
                parqueo par= new parqueo(res.getInt(1),  res.getString(2),res.getString(3));
                agregar_horario_parqueo(par);
                select_header_footer(par);
                lista.add(par);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de PARQUEOS: "+ex.getLocalizedMessage());
        }
        return lista;
    }
    
    
    public int agregar_parqueo(parqueo par){
        
        try {
            con.setPreparado(con.getConn().prepareStatement("insert into parqueo(nombre_parqueo,direccion) values(?,?)",Statement.RETURN_GENERATED_KEYS));
            con.getPreparado().setString(1, par.getNombre_parqueo());
            con.getPreparado().setString(2, par.getDireccion());
            con.getPreparado().executeUpdate();
            
            res=con.getPreparado().getGeneratedKeys();
            if(res.next())
                par.setId_parqueo(res.getInt(1));
            
            
            horario_db horario = new horario_db();
            horario_parqueo nuevo = new horario_parqueo(0, par.hora_inicio, par.hora_fin, par.getId_parqueo());
            horario.guardar_horario_parqueo(nuevo);
            
            agregar_header_footer(par);
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar el Parqueo a DB"+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
    }
    
    
    public int editar_parqueo(parqueo par){
         try {
            con.setPreparado(con.getConn().prepareStatement("update parqueo set nombre_parqueo=?,direccion=? where idparqueo = ?"));
            con.getPreparado().setString(1, par.getNombre_parqueo());
            con.getPreparado().setString(2, par.getDireccion());
            con.getPreparado().setInt(3, par.getId_parqueo());
            con.getPreparado().executeUpdate();
            
           
            horario_db horario = new horario_db();
            horario_parqueo nuevo = new horario_parqueo(0, par.hora_inicio, par.hora_fin, par.getId_parqueo());
            horario.modificar_horario_parqueo(nuevo);
            
            modificar_detalle_parqueo(par);
            
        } catch (SQLException ex) {
            System.out.println("Error al modificar el Parqueo a DB"+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
    }
    
    public int eliminar_parqueo(parqueo par){
          try {
            horario_db horario = new horario_db();
            horario_parqueo nuevo = new horario_parqueo(0, par.hora_inicio, par.hora_fin, par.getId_parqueo());
            horario.eliminar_horario_parqueo(nuevo);
              
            con.setPreparado(con.getConn().prepareStatement("delete from  parqueo where idparqueo = ?"));
            con.getPreparado().setInt(1, par.getId_parqueo());
            con.getPreparado().executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el Parqueo a DB"+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
    }
    
    public parqueo get_parqueo_id(int id){
        parqueo par =null;
        try {
            String query = "select * from parqueo where idparqueo = "+id;
            con.setPreparado(con.getConn().prepareStatement(query));
            res = con.getPreparado().executeQuery();
            if(res.next()){
                par= new parqueo(res.getInt(1),  res.getString(2),res.getString(3));
                agregar_horario_parqueo(par);//le seteamos su horario
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return par;
    }

    private void agregar_horario_parqueo(parqueo par){
        try {
            String query = "select * from horario_parqueo where idparqueo = "+par.getId_parqueo();
            con.setPreparado(con.getConn().prepareStatement(query));
            ResultSet resy = con.getPreparado().executeQuery();
            if(resy.next()){
                par.setHora_inicio(resy.getTime(2));
                par.setHora_fin(resy.getTime(3));
            }
        } catch (SQLException ex) {
            System.out.println("Error al setear el horario del parqueo "+ ex.getMessage());
        }
    }

    private void agregar_header_footer(parqueo par) {
        try {
            con.setPreparado(con.getConn().prepareStatement("insert into DETALLE_PARQUEO(idparqueo,header,footer) values(?,?,?)"));
            con.getPreparado().setInt(1, par.getId_parqueo());
            con.getPreparado().setString(2, par.encabezado);
            con.getPreparado().setString(3, par.pie);
            con.getPreparado().executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(parqueo_db.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al insertar los detalles del parqueo: "+par.getNombre_parqueo());
        }
    }
    
    private void modificar_detalle_parqueo(parqueo par) {
        try {
            con.setPreparado(con.getConn().prepareStatement("update DETALLE_PARQUEO set header=?,footer=? where idparqueo=?"));
            con.getPreparado().setInt(3, par.getId_parqueo());
            con.getPreparado().setString(1, par.encabezado);
            con.getPreparado().setString(2, par.pie);
            con.getPreparado().executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(parqueo_db.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al insertar los detalles del parqueo: "+par.getNombre_parqueo());
        }
    }

    private void select_header_footer(parqueo par) {
          try {
            String query = "select * from detalle_parqueo where idparqueo = "+par.getId_parqueo();
            con.setPreparado(con.getConn().prepareStatement(query));
            ResultSet resy = con.getPreparado().executeQuery();
            if(resy.next()){
                par.encabezado=resy.getString(3);
                par.pie=resy.getString(4);
            }
        } catch (SQLException ex) {
            System.out.println("Error al setear los detalles del parqueo "+ ex.getMessage());
        }
    }


}
