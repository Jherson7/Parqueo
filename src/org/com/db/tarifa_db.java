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
            String query ="select t.idTARIFA,  "
                    + "t.Precio,t.precio_media_hora,t.tarifa_unica,t.hora_inicio_tarifa,"
                    + " t.hora_fin_tarifa,t.fPARQUEO, p.nombre_parqueo " +
            "from tarifa t inner join parqueo p on t.fPARQUEO = p.idparqueo";
            con.setPreparado(con.getConn().prepareStatement(query));
            res=con.getPreparado().executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
     
        try {
            while(res.next()){
                tarifa au= new tarifa(res.getInt(1), res.getDouble(2),res.getDouble(3),res.getInt(4), res.getTime(5), res.getTime(6), res.getInt(7), res.getString(8));
                au.setDias(get_dias_tarifa(au.getIdTARIFA()));
                lista.add(au);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de Tarifas: "+ex.getLocalizedMessage());
        }
        return lista;
    }
    
    public Integer agregar_tarifa(tarifa tar){
         try {
            con.setPreparado(con.getConn().prepareStatement("insert into tarifa(precio,"
                    + "hora_inicio_tarifa,hora_fin_tarifa,fparqueo,precio_media_hora,tarifa_unica) values(?,?,?,?,?,?)"));
            con.getPreparado().setDouble(1, tar.getPrecio());
            con.getPreparado().setTime(2, tar.getHora_inicio_tarifa());
            con.getPreparado().setTime(3, tar.getHora_fin_tarifa());
            con.getPreparado().setInt(4,tar.getfPARQUEO());
            con.getPreparado().setDouble(5,tar.getMedia_hora());
            con.getPreparado().setInt(6,tar.getTarifa_unica());
            
            con.getPreparado().executeUpdate();
            
            insertar_dias_tarifa(tar);
            
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar tarifa a DB"+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
     }
    
    public int modificar_tarifa(tarifa tar){
         try {
            con.setPreparado(con.getConn().prepareStatement("update tarifa set precio=?,"
                    + "hora_inicio_tarifa=?,hora_fin_tarifa=?,"
                    + "fparqueo=?, precio_media_hora=?,tarifa_unica=? where idtarifa= ?"));
            con.getPreparado().setDouble(1, tar.getPrecio());
            con.getPreparado().setTime(2, tar.getHora_inicio_tarifa());
            con.getPreparado().setTime(3, tar.getHora_fin_tarifa());
            con.getPreparado().setInt(4,tar.getfPARQUEO());
            con.getPreparado().setDouble(5,tar.getMedia_hora());
            con.getPreparado().setInt(6,tar.getTarifa_unica());
            con.getPreparado().setInt(7, tar.getIdTARIFA());
            
            con.getPreparado().executeUpdate();
            
             eliminar_dias_tarifa(tar.getIdTARIFA());
             insertar_dias_tarifa(tar);
            
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

    LinkedList<Integer> get_dias_tarifa(int id){
        LinkedList<Integer> aux = new LinkedList<>();
        try {
            con.setPreparado(con.getConn().prepareStatement("select * from dias_tarifa where fk_tarifa = "+id));
            res=con.getPreparado().executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
     
        try {
            while(res.next()){
               aux.add(res.getInt(2));
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener los dias de Tarifas: "+ex.getLocalizedMessage());
        }
        return aux;
    }
    
    
    private void insertar_dias_tarifa(tarifa tar) {
        for (int x : tar.getDias()) {
            String dia = "";
            switch (x) {
                case 1:
                    dia = "Lunes";
                    break;
                case 2:
                    dia = "Martes";
                    break;
                case 3:
                    dia = "Miercoles";
                    break;
                case 4:
                    dia = "Jueves";
                    break;
                case 5:
                    dia = "Viernes";
                    break;
                case 6:
                    dia = "Sabado";
                    break;
                default:
                    dia = "Domingo";
                    break;
            }
            try {
                
                con.setPreparado(con.getConn().prepareStatement("insert into dias_tarifa(dia_cod,dia_nombre,fk_tarifa) values(?,?,?)"));
                con.getPreparado().setInt(1, x);
                con.getPreparado().setString(2, dia);
                con.getPreparado().setInt(3, tar.getIdTARIFA());

                con.getPreparado().executeUpdate();

            } catch (SQLException ex) {
                System.out.println("Error al insertar dias de tarifa a DB" + ex.getLocalizedMessage());
            }
        }
    }
    
    void eliminar_dias_tarifa(int id){
        try {
                con.setPreparado(con.getConn().prepareStatement("delete from dias_tarifa where fk_tarifa = "+id));
                con.getPreparado().executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Error al eliminar dias de tarifa a DB" + ex.getLocalizedMessage());
            }
    }
    
}
