package org.com.bens;

/**
 *
 * @author Jherson
 */
public class reporte_turno_detallado {
    String nombre_descuento;
    String codigo;
    String hora_ingreso;
    String hora_salida;
    String descuento;
    String factura;
    String total;

    public reporte_turno_detallado(String nombre_descuento, String codigo, String hora_ingreso, String hora_salida, String descuento, String factura, String total) {
        this.nombre_descuento = nombre_descuento;
        this.codigo = codigo;
        this.hora_ingreso = hora_ingreso;
        this.hora_salida = hora_salida;
        this.descuento = descuento;
        this.factura = factura;
        this.total = total;
    }

    public String getNombre_descuento() {
        return nombre_descuento;
    }

    public void setNombre_descuento(String nombre_descuento) {
        this.nombre_descuento = nombre_descuento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getHora_ingreso() {
        return hora_ingreso;
    }

    public void setHora_ingreso(String hora_ingreso) {
        this.hora_ingreso = hora_ingreso;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

   
}
