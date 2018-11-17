package org.com.bens;

import java.sql.Time;

/**
 *
 * @author Jherson
 */
public class horario {
    
    Integer id_horario;
    Time hora_inicio;
    Time hora_fin;
    Integer fusuario;

    public horario() {
    }

    public horario(Time hora_inicio, Time hora_fin) {
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
    }

    public horario(Integer id_horario, Time hora_inicio, Time hora_fin, Integer fusuario) {
        this.id_horario = id_horario;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.fusuario = fusuario;
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
    
    
    
}
