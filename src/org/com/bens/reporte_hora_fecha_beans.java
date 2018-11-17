package org.com.bens;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Jherson
 */
public class reporte_hora_fecha_beans {
    int hora;
    double total;
    Timestamp fecha;
    int numero;

    public reporte_hora_fecha_beans() {
    }

    public reporte_hora_fecha_beans(int hora, double total, Timestamp fecha) {
        this.hora = hora;
        this.total = total;
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
 
    
}
