package org.com.bens;

import java.sql.Date;
import java.sql.Timestamp;

//import java.util.Date;


/**
 *
 * @author Jherson
 */
public class ticket {
    int     id_ticket;
    String  codigo;
    Timestamp    hora_ingreso;
    Timestamp    hora_salida;
    Double  subtotal;
    Double  descuento;
    Double  total;
    int     turno;
    int     fdescuento;

    public ticket() {
    }

    public ticket(int id_ticket, String codigo, Timestamp hora_ingreso, Timestamp hora_salida, Double subtotal, Double descuento, Double total, int turno, int fdescuento) {
        this.id_ticket = id_ticket;
        this.codigo = codigo;
        this.hora_ingreso = hora_ingreso;
        this.hora_salida = hora_salida;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.total = total;
        this.turno = turno;
        this.fdescuento = fdescuento;
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Timestamp getHora_ingreso() {
        return hora_ingreso;
    }

 
    public Timestamp getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(Timestamp hora_salida) {
        this.hora_salida = hora_salida;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getFdescuento() {
        return fdescuento;
    }

    public void setFdescuento(int fdescuento) {
        this.fdescuento = fdescuento;
    }

    public void setHora_ingreso(Timestamp timestamp) {
        this.hora_ingreso = timestamp;
    }

    public void setDescuento(float descuento) {
        this.descuento = (double)descuento;
    }

  
    
    
    
}
