
package org.com.bens;

/**
 *
 * @author Jherson
 */
public class parqueo {
    private Integer id_parqueo;
    private String nombre_parqueo;
    private String direccion;

    public parqueo() {
    }

    public parqueo(Integer id_parqueo, String nombre_parqueo, String direccion) {
        this.id_parqueo = id_parqueo;
        this.nombre_parqueo = nombre_parqueo;
        this.direccion = direccion;
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
    
    
    
            
}
