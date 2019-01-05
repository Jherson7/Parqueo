
package org.com.bens;

import java.sql.Time;

/**
 *
 * @author Jherson
 */
public class parqueo {
    private Integer id_parqueo;
    private String nombre_parqueo;
    private String direccion;
    
    public Time hora_inicio;
    public Time hora_fin;

    public String encabezado;
    public String pie;
    
    public parqueo() {
    }

    public parqueo(Integer id_parqueo, String nombre_parqueo, String direccion) {
        this.id_parqueo = id_parqueo;
        this.nombre_parqueo = nombre_parqueo;
        this.direccion = direccion;
        this.encabezado="";
        this.pie="";
    }

    public Integer getId_parqueo() {
        return id_parqueo;
    }

    public void setId_parqueo(Integer id_parqueo) {
        this.id_parqueo = id_parqueo;
    }

    public String getNombre_parqueo() {
        return nombre_parqueo;
    }

    public void setNombre_parqueo(String nombre_parqueo) {
        this.nombre_parqueo = nombre_parqueo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return nombre_parqueo ;
    }

    public int getHora_inicio() {
        return hora_inicio.getHours();
    }

    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public int getHora_fin() {
        return hora_fin.getHours();
    }

    public void setHora_fin(Time hora_fin) {
        this.hora_fin = hora_fin;
    }
    
    
    
            
}
