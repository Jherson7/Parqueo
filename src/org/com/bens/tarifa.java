package org.com.bens;

import java.sql.Time;

/**
 *
 * @author Jherson
 */
public class tarifa {
   Integer idTARIFA  ;
   Double Precio  ;
   Double media_hora;
   int tarifa_unica;
   Time hora_inicio_tarifa;
   Time hora_fin_tarifa ;
   Integer fPARQUEO;
   String parqueo;

    public tarifa() {
    }

    public tarifa(Integer idTARIFA, Double Precio, Double media_hora, int tarifa_unica, Time hora_inicio_tarifa, Time hora_fin_tarifa, Integer fPARQUEO, String parqueo) {
        this.idTARIFA = idTARIFA;
        this.Precio = Precio;
        this.media_hora = media_hora;
        this.tarifa_unica = tarifa_unica;
        this.hora_inicio_tarifa = hora_inicio_tarifa;
        this.hora_fin_tarifa = hora_fin_tarifa;
        this.fPARQUEO = fPARQUEO;
        this.parqueo = parqueo;
    }

    
    public Integer getIdTARIFA() {
        return idTARIFA;
    }

    public void setIdTARIFA(Integer idTARIFA) {
        this.idTARIFA = idTARIFA;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public Time getHora_inicio_tarifa() {
        return hora_inicio_tarifa;
    }

    public void setHora_inicio_tarifa(Time hora_inicio_tarifa) {
        this.hora_inicio_tarifa = hora_inicio_tarifa;
    }

    public Time getHora_fin_tarifa() {
        return hora_fin_tarifa;
    }

    public void setHora_fin_tarifa(Time hora_fin_tarifa) {
        this.hora_fin_tarifa = hora_fin_tarifa;
    }

    public Integer getfPARQUEO() {
        return fPARQUEO;
    }

    public void setfPARQUEO(Integer fPARQUEO) {
        this.fPARQUEO = fPARQUEO;
    }

    public String getParqueo() {
        return parqueo;
    }

    public void setParqueo(String parqueo) {
        this.parqueo = parqueo;
    }

    public Double getMedia_hora() {
        return media_hora;
    }

    public void setMedia_hora(Double media_hora) {
        this.media_hora = media_hora;
    }

    public int getTarifa_unica() {
        return tarifa_unica;
    }

    public void setTarifa_unica(int tarifa_unica) {
        this.tarifa_unica = tarifa_unica;
    }
    
    
}
