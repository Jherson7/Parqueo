package org.com.bens;

/**
 *
 * @author Jherson
 */
public class reporte_turno_detallado {
    String usuario;
    String apertura;
    String apertura_d;
    String cierre;
    String hora_ingreso;
    String hora_salida;
    double total;

    public reporte_turno_detallado(String usuario, String apertura, String apertura_d, String cierre, String hora_ingreso, String hora_salida, double total) {
        this.usuario = usuario;
        this.apertura = apertura;
        this.apertura_d = apertura_d;
        this.cierre = cierre;
        this.hora_ingreso = hora_ingreso;
        this.hora_salida = hora_salida;
        this.total = total;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getApertura() {
        return apertura;
    }

    public void setApertura(String apertura) {
        this.apertura = apertura;
    }

    public String getApertura_d() {
        return apertura_d;
    }

    public void setApertura_d(String apertura_d) {
        this.apertura_d = apertura_d;
    }

    public String getCierre() {
        return cierre;
    }

    public void setCierre(String cierre) {
        this.cierre = cierre;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    

}
