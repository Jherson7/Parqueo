package org.com.bens;
import java.sql.Time;

/**
 *
 * @author Jherson
 */

public class horario_parqueo {

    Integer id_horario;
    Time hora_inicio;
    Time hora_fin;
    Integer fparqueo;

    public horario_parqueo() {
    }

    public horario_parqueo(Integer id_horario, Time hora_inicio, Time hora_fin, Integer fparqueo) {
        this.id_horario = id_horario;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.fparqueo = fparqueo;
    }

    public Integer getId_horario() {
        return id_horario;
    }

    public void setId_horario(Integer id_horario) {
        this.id_horario = id_horario;
    }

    public Time getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Time getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(Time hora_fin) {
        this.hora_fin = hora_fin;
    }

    public Integer getFparqueo() {
        return fparqueo;
    }

    public void setFparqueo(Integer fparqueo) {
        this.fparqueo = fparqueo;
    }
    
}
