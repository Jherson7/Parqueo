package org.com.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.com.bens.horario_parqueo;
import org.com.bens.parqueo;
import org.com.logica.Controlador;

/**
 *
 * @author Jherson
 */
public class horario_db {

    ResultSet res;
    Conexion con;
    
    
    public horario_db() {
        con = Conexion.getInstancia();
    }
    
    
    public horario_parqueo get_horario_parqueo(){
        parqueo par = Controlador.getParqueo();
        horario_parqueo horario = null;
        
        try {
            con.setPreparado(con.getConn().prepareStatement("select* from horario_parqueo where idparqueo = "+par.getId_parqueo()));

            res = con.getPreparado().executeQuery();
            
            if(res.next()){
                horario = new horario_parqueo(res.getInt(1), res.getTime(2), res.getTime(3), res.getInt(4));
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el horario del Parqueo:"+ex.getLocalizedMessage());
        }
        return horario;
    }
    
    
    
    public int guardar_horario_parqueo(horario_parqueo horario){
        try {
            con.setPreparado(con.getConn().prepareStatement("insert into horario_parqueo (hora_inicio,hora_fin,idparqueo) values(?,?,?)"));
            con.getPreparado().setTime(1, horario.getHora_inicio());
            con.getPreparado().setTime(2, horario.getHora_fin());
            con.getPreparado().setInt(3, horario.getFparqueo());
            con.getPreparado().executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al guardar el horario Parqueo a DB"+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
    }
    
    public int modificar_horario_parqueo(horario_parqueo horario){
        try {
            con.setPreparado(con.getConn().prepareStatement("update horario_parqueo set hora_inicio = ?, hora_fin=? where id_horario =?"));
            con.getPreparado().setTime(1, horario.getHora_inicio());
            con.getPreparado().setTime(2, horario.getHora_fin());
            con.getPreparado().setInt(3, horario.getId_horario());
            con.getPreparado().executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al modificar el horario Parqueo a DB"+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
    }
}
