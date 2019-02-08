package org.com.bens;

/**
 *
 * @author Jherson
 */
public class reporte_turno {
    String usuario;
    String apertura;
    String cierre;
    double total;
    int turno;

    public reporte_turno() {
    }

    public reporte_turno(String usuario, String apertura, String cierre, double total,int turno) {
        this.usuario = usuario;
        this.apertura = apertura;
        this.cierre = cierre;
        this.total = total;
        this.turno = turno;
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

    public String getCierre() {
        return cierre;
    }

    public void setCierre(String cierre) {
        this.cierre = cierre;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
    
    
}
