package org.com.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Jherson
 */
public class Conexion {
    
    private static Connection conexion;
    private PreparedStatement preparado;
    private static Conexion instancia;
     
    public static Conexion getInstancia(){
        if(instancia==null)
            instancia=new Conexion();
        return instancia;
    }

    public Conexion() {
        try {
            Properties prop = new Properties();
            //InputStream input = Conexion.class.getResourceAsStream("src/db_properties.properties");
            InputStream input = new FileInputStream("src/db_properties.properties");
            prop.load(input);
            
            
            String driver   = prop.getProperty(("driver"));
            String user     = prop.getProperty("user");
            String url      = prop.getProperty("url");
            String pass     = prop.getProperty(("pass"));
            
            conexion = DriverManager.getConnection(url,user,pass);
            
            Class.forName(driver);
       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public static Connection getConnection(){
        if(conexion!=null)
                return conexion;
        
        try {
            Properties prop = new Properties();
            InputStream input = Conexion.class.getResourceAsStream("/org/com/db/db_properties.properties");
            prop.load(input);
            
            String driver   = prop.getProperty(("driver"));
            String user     = prop.getProperty("user");
            String url      = prop.getProperty("url");
            String pass     = prop.getProperty(("pass"));
            
            conexion = DriverManager.getConnection(url,user,pass);
            
            Class.forName(driver);
       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conexion;
    }
    
    
    public PreparedStatement getPreparado() {
        return preparado;
    }

    public void setPreparado(PreparedStatement preparado) {
        this.preparado = preparado;
    }

    public Connection getConn() {
        return conexion;
    }


}
