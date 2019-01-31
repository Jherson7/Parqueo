package org.com.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import org.com.bens.horario;
import org.com.bens.usuario;

/**
 *
 * @author Jherson
 */
public class usuario_db {
    ResultSet res;
    Conexion con;
    
    
    public usuario_db() {
        con = Conexion.getInstancia();
    }
    
    
    
    public List<usuario> retornarLista(){
        List<usuario> lista = new LinkedList<>();
        try {
            con.setPreparado(con.getConn().prepareStatement("select u.idusuario,u.usuario,u.dpi,u.nombres,u.apellidos,u.password,u.fparqueo,u.frol,r.nombre_rol,p.nombre_parqueo " +
            "from usuario u inner join parqueo p on u.fPARQUEO = p.idPARQUEO " +
            "inner join rol r on r.idROL = u.fRol order by  apellidos ASC"));
            res=con.getPreparado().executeQuery();

            while(res.next()){
                usuario au= new usuario(res.getInt(1), res.getString(2),res.getLong(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7), res.getInt(8),res.getString(9),res.getString(10));
                get_horario_laboral(au);
                lista.add(au);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de USUARIOS: "+ex.getLocalizedMessage());
        }
        return lista;
    }
     
     
    public Integer agregar_usuario(usuario usu){
         try {
            con.setPreparado(con.getConn().prepareStatement("insert into usuario(dpi,usuario,nombres,apellidos,password,fparqueo,frol) values(?,?,?,?,?,?,?)"));
            con.getPreparado().setLong(1, usu.getDPI());
            con.getPreparado().setString(2, usu.getUsuario());
            con.getPreparado().setString(3, usu.getNombre());
            con.getPreparado().setString(4, usu.getApellidos());
            con.getPreparado().setString(5,usu.getPassword());
            con.getPreparado().setInt(6,usu.getfPARQUEO());
            con.getPreparado().setInt(7,usu.getfRol());
            
            con.getPreparado().executeUpdate();
            
            
            //insertamos su horario laboral
             insertar_horario_laboral(usu);
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar USUARIO a DB"+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
     }
     
    public Integer modifica_usuario(usuario usu){
          try {
            con.setPreparado(con.getConn().prepareStatement("update usuario set dpi=?,nombres=?,apellidos=?,password=?,fparqueo=?,frol=? ,usuario=? where idusuario=?"));
            con.getPreparado().setLong(1, usu.getDPI());
            con.getPreparado().setString(2, usu.getNombre());
            con.getPreparado().setString(3, usu.getApellidos());
            con.getPreparado().setString(4,usu.getPassword());
            con.getPreparado().setInt(5,usu.getfPARQUEO());
            con.getPreparado().setInt(6,usu.getfRol());
            con.getPreparado().setString(7,usu.getUsuario());
            con.getPreparado().setInt(8, usu.getIdUSUARIO());
            
            con.getPreparado().executeUpdate();
            
            update_horario_laboral(usu);
        } catch (SQLException ex) {
            System.out.println("Error al modificar USUARIO a DB"+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
     }
    
    public Integer eliminar_usuario(usuario usu){
          try {
            con.setPreparado(con.getConn().prepareStatement("delete from usuario where idusuario=?"));
            con.getPreparado().setInt(1, usu.getIdUSUARIO());
            
            con.getPreparado().executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar USUARIO a DB"+ex.getLocalizedMessage());
            return 1;
        }
        return 0;
     }
    
    private void insertar_horario_laboral(usuario usu){
         try {
            con.setPreparado(con.getConn().prepareStatement("insert into horario(hora_inicio,hora_fin,fusuario) values(?,?,?)"));
            con.getPreparado().setTime(1, usu.getHorario_laboral().getHora_inicio());
            con.getPreparado().setTime(2, usu.getHorario_laboral().getHora_fin());
            con.getPreparado().setInt(3, usu.getIdUSUARIO());
                 
            con.getPreparado().executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar el horario laboral al USUARIO a DB"+ex.getLocalizedMessage());
            //return 1;
        }
        //return 0;
     }
     
    private void update_horario_laboral(usuario usu){
         try {
            con.setPreparado(con.getConn().prepareStatement("update horario set hora_inicio=?,hora_fin=?  where fusuario=?"));
            con.getPreparado().setTime(1, usu.getHorario_laboral().getHora_inicio());
            con.getPreparado().setTime(2, usu.getHorario_laboral().getHora_fin());
            con.getPreparado().setInt(3, usu.getIdUSUARIO());
                 
            con.getPreparado().executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar el modificar laboral al USUARIO a DB"+ex.getLocalizedMessage());
            //return 1;
        }
        //return 0;
     }
     
     
    private void get_horario_laboral(usuario usu){
        try {
            con.setPreparado(con.getConn().prepareStatement("select * from horario where fusuario = "+usu.getIdUSUARIO()));
            ResultSet aux_res=con.getPreparado().executeQuery();

            if(aux_res.next()){
                horario au= new horario(aux_res.getInt(1), aux_res.getTime(2), aux_res.getTime(3), aux_res.getInt(4));
                usu.setHorario_laboral(au);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la el horario del Usuario: "+ex.getLocalizedMessage());
        }
     }
     
    public int get_max_id(){
        try {
            con.setPreparado(con.getConn().prepareStatement("select max(idUsuario) from usuario"));
            res=con.getPreparado().executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
     
        try {
            if(res.next()){
               return res.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el maxID de Usuarios: "+ex.getLocalizedMessage());
        }
        return -1;
    }
      
    public usuario login(String user,String contrasenia,String parqueo){
        usuario usu = null;
        try {
            con.setPreparado(con.getConn().prepareStatement("select * from usuario where usuario=? and password=? and fparqueo = ? "));
            con.getPreparado().setString(1, user);
            con.getPreparado().setString(2, contrasenia);
            con.getPreparado().setString(3, parqueo);
            
            res=con.getPreparado().executeQuery();

            if(res.next()){
                usu= new usuario(res.getInt(1), res.getString(2),res.getLong(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7), res.getInt(8));
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el Usuario en login: "+ex.getLocalizedMessage());
        }
        return usu;
    }
 }
