package org.com.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import org.com.bens.rol;

/**
 *
 * @author Jherson
 */
public class rol_db {
    ResultSet res;
    Conexion con;
    
    
    public rol_db() {
        con = Conexion.getInstancia();
    }
    
    public List<rol> retornarLista(){
        List<rol> lista = new LinkedList<>();
        try {
            con.setPreparado(con.getConn().prepareStatement("select * from rol  order by  nombre_rol ASC"));
            res=con.getPreparado().executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
     
        try {
            while(res.next()){
                rol au= new rol(res.getInt(1),  res.getString(2));
                lista.add(au);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la lista de ROLES: "+ex.getLocalizedMessage());
        }
        return lista;
    }
    
}
