package org.com.controler;

import java.util.Date;
import org.com.models.reporte_hora_fecha_model_table;
import org.com.models.reporte_por_fecha_model_table;
import org.com.models.reporte_vehiculos_promedio_model_table;
import org.com.vistas.reporte_promedio_vehiculos;

/**
 *
 * @author Jherson
 */
public class reportes_controller {
    private static reporte_hora_fecha_model_table tabla_hora_fecha;
    private static reporte_por_fecha_model_table tabla_por_fechas;
    private static reporte_vehiculos_promedio_model_table tabla_vehiculos;
    
    public static reporte_hora_fecha_model_table get_reporte_hora_fecha(Date fecha){
        tabla_hora_fecha = new reporte_hora_fecha_model_table(fecha);
        return tabla_hora_fecha;
    }
    
    public static reporte_por_fecha_model_table get_reporte_por_fechas(Date desde,Date hasta){
        tabla_por_fechas = new reporte_por_fecha_model_table(desde,hasta);
        return tabla_por_fechas;
    }
    
    public static reporte_vehiculos_promedio_model_table get_estadistica_vehiculos(Date desde,Date hasta){
        tabla_vehiculos = new reporte_vehiculos_promedio_model_table(desde,hasta);
        return tabla_vehiculos;
    }
}
