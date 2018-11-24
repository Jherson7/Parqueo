package org.com.bens;

/**
 *
 * @author Jherson
 */
public class reporte_tickets {
    int no;
    String fecha;
    String codigo;

    public reporte_tickets() {
    }

    public reporte_tickets(int no, String fecha, String codigo) {
        this.no = no;
        this.fecha = fecha;
        this.codigo = codigo;
    }

    

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
    
    
}
