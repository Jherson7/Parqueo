package org.com.bens;

import java.util.Date;

/**
 *
 * @author Jherson
 */
public class descuento {
    int id_descuento;
    String nombre_descuento;
    int porcetaje;
    Date fecha;
    int minutos_descuento;

    public descuento() {
    }

    public descuento(int id_descuento, String nombre_descuento, int porcetaje, Date fecha, int minutos_descuento) {
        this.id_descuento = id_descuento;
        this.nombre_descuento = nombre_descuento;
        this.porcetaje = porcetaje;
        this.fecha = fecha;
        this.minutos_descuento = minutos_descuento;
    }

    

    public int getId_descuento() {
        return id_descuento;
    }

    public void setId_descuento(int id_descuento) {
        this.id_descuento = id_descuento;
    }

    public int getPorcetaje() {
        return porcetaje;
    }

    public void setPorcetaje(int porcetaje) {
        this.porcetaje = porcetaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getMinutos_descuento() {
        return minutos_descuento;
    }

    public void setMinutos_descuento(int minutos_descuento) {
        this.minutos_descuento = minutos_descuento;
    }

    @Override
    public String toString() {
        return nombre_descuento;
    }

    public String getNombre_descuento() {
        return nombre_descuento;
    }

    public void setNombre_descuento(String nombre_descuento) {
        this.nombre_descuento = nombre_descuento;
    }
    
    
    
    
    
    
}
