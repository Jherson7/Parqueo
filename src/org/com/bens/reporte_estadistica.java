package org.com.bens;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Jherson
 */
public class reporte_estadistica {
    int total_vehiculos;
    float promedio;
    Timestamp fecha;
    int numero;

    public reporte_estadistica() {
    }

    public reporte_estadistica(Timestamp fecha, int total_vehiculos, float promedio,  int numero) {
        this.total_vehiculos = total_vehiculos;
        this.promedio = promedio;
        this.fecha = fecha;
        this.numero = numero;
    }

    public int getTotal_vehiculos() {
        return total_vehiculos;
    }

    public void setTotal_vehiculos(int total_vehiculos) {
        this.total_vehiculos = total_vehiculos;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
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
