package org.com.logica;

import java.util.LinkedList;
import org.com.bens.ticket;

/**
 *
 * @author Jherson
 */
public class monto_cobro {
    public LinkedList<String> detalles;
    ticket ticket;
    double costo;
    double tarifa;
    double costo_media_hora;

    public monto_cobro() {
        detalles = new  LinkedList<>();
        costo=0;
    }

    public monto_cobro(LinkedList<String> detalles, ticket ticket) {
        this.detalles = detalles;
        this.ticket = ticket;
    }

    
    public LinkedList<String> getDetalles() {
        return detalles;
    }

    public void setDetalles(LinkedList<String> detalles) {
        this.detalles = detalles;
    }

    public ticket getTicket() {
        return ticket;
    }

    public void setTicket(ticket ticket) {
        this.ticket = ticket;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public double getCosto_media_hora() {
        return costo_media_hora;
    }

    public void setCosto_media_hora(double costo_media_hora) {
        this.costo_media_hora = costo_media_hora;
    }
    
    
    
}
