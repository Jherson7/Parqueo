package org.com.bens;

import java.util.Date;

/**
 *
 * @author Jherson
 */
public class descuento {
    int id_descuento;
    String nombre_descuento;
    int tipo;
    double valor;
    Date fecha;

    public descuento() {
    }

    public descuento(int id_descuento, String nombre_descuento, int tipo, double valor, Date fecha) {
        this.id_descuento = id_descuento;
        this.nombre_descuento = nombre_descuento;
        this.tipo = tipo;
        this.valor = valor;
        this.fecha = fecha;
    }

    public int getId_descuento() {
        return id_descuento;
    }

    public void setId_descuento(int id_descuento) {
        this.id_descuento = id_descuento;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
