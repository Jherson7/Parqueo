package org.com.bens;

import java.sql.Time;

/**
 *
 * @author Jherson
 */
public class tarifa {
   Integer idTARIFA  ;
   Double Precio  ;
   Time hora_inicio_tarifa;
   Time hora_fin_tarifa ;
   Integer fPARQUEO;
   String parqueo;

    public tarifa() {
    }

    public tarifa(Integer idTARIFA, Double Precio, Time hora_inicio_tarifa, Time hora_fin_tarifa, Integer fPARQUEO,String parqueo) {
        this.idTARIFA = idTARIFA;
        this.Precio = Precio;
        this.hora_inicio_tarifa = hora_inicio_tarifa;
        this.hora_fin_tarifa = hora_fin_tarifa;
        this.fPARQUEO = fPARQUEO;
        this.parqueo= parqueo;
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
}
