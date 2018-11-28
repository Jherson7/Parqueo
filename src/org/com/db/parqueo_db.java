package org.com.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
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
                lista.add(par);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de PARQUEOS: "+ex.getLocalizedMessage());
        }
        return lista;
    }
    
    
    public int agregar_parqueo(parqueo par){
        
        try {
            con.setPreparado(con.getConn().prepareStatement("insert into parqueo(nombre_parqueo,direccion) values(?,?)"));
            con.getPreparado().setString(1, par.getNombre_parqueo());
            con.getPreparado().setString(2, par.getDireccion());
            con.getPreparado().executeUpdate();
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
        } catch (SQLException ex) {
            System.out.println("Error al modificar el Parqueo a DB"+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
    }
    
    public int eliminar_parqueo(parqueo par){
          try {
            con.setPreparado(con.getConn().prepareStatement("delete from  parqueo where idparqueo = ?"));
            con.getPreparado().setInt(1, par.getId_parqueo());
            con.getPreparado().executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el Parqueo a DB"+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
    }
    
    public int get_max_id(){
        try {
            con.setPreparado(con.getConn().prepareStatement("select max(idPARQUEO) from parqueo"));
            res=con.getPreparado().executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
     
        try {
            if(res.next()){
               return res.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el maxID de PARQUEOS: "+ex.getLocalizedMessage());
        }
        return -1;
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
                par.setHora_inicio(resy.getTime(2).getHours());
                par.setHora_fin(resy.getTime(3).getHours());
            }
        } catch (SQLException ex) {
            System.out.println("Error al setear el horario del parqueo "+ ex.getMessage());
        }
    }


}
