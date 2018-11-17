package org.com.bens;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Jherson
 */
public class turno {
    int id_turno;
    Date hora_apertura;
    Date hora_cierre;
    int fparqueo;
    int usuario;

    public turno(int id_turno, Date hora_apertura, Date hora_cierre, int fparqueo, int usuario) {
        this.id_turno = id_turno;
        this.hora_apertura = hora_apertura;
        this.hora_cierre = hora_cierre;
        this.fparqueo = fparqueo;
        this.usuario = usuario;
    }

    
    
    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }

    public Date getHora_apertura() {
        return hora_apertura;
    }

    public void setHora_apertura(Date hora_apertura) {
        this.hora_apertura = hora_apertura;
    }

    public Date getHora_cierre() {
        return hora_cierre;
    }

    public void setHora_cierre(Date hora_cierre) {
        this.hora_cierre = hora_cierre;
    }

    public int getFparqueo() {
        return fparqueo;
    }

    public void setFparqueo(int fparqueo) {
        this.fparqueo = fparqueo;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

   
    
    
}
