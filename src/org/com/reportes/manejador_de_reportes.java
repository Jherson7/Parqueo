package org.com.reportes;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.com.db.Conexion;

/**
 *
 * @author Jherson
 */
public class manejador_de_reportes {
    
    
    public static void reportePrestamosFecha(Date de, Date hasta){
        Conexion con;
         try {
            JasperReport  jr= (JasperReport) JRLoader.
                   loadObject(manejador_de_reportes.
                           class.getResourceAsStream("/org/com/reportes/estadistica_por_fecha.jasper"));
            
            con=Conexion.getInstancia();
            
            Map parametros = new HashMap();
            parametros.put("fecha_desde", de);
            parametros.put("fecha_hasta", hasta);
            
            JasperPrint jp;
            jp = JasperFillManager.fillReport(jr, parametros, con.getConn());
            JasperViewer visor = new JasperViewer(jp,false);
            visor.setTitle("Reporte de ganancias por fechas");
            visor.setVisible(true);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
       /* try {
            JasperReport  jr= (JasperReport) JRLoader.
                   loadObject(manejador_de_reportes.
                           class.getResourceAsStream("/org/com/reportes/reporte_por_fechas.jasper"));
            
            con=Conexion.getInstancia();
            
            Map parametros = new HashMap();
            parametros.put("fechainicio", de);
            parametros.put("fechafin", hasta);
            
            JasperPrint jp;
            jp = JasperFillManager.fillReport(jr, parametros, con.getConn());
            JasperViewer visor = new JasperViewer(jp,false);
            visor.setTitle("Reporte de ganancias por fechas");
            visor.setVisible(true);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }*/
    }
    
 public static void estadisticas_por_fecha(Date de, Date hasta){
        Conexion con;
        
        try {
            JasperReport  jr= (JasperReport) JRLoader.
                   loadObject(manejador_de_reportes.
                           class.getResourceAsStream("/org/com/reportes/estadistica_por_fecha.jasper"));
            
            con=Conexion.getInstancia();
            
            Map parametros = new HashMap();
            parametros.put("fecha_desde", de);
            parametros.put("fecha_hasta", hasta);
            
            JasperPrint jp;
            jp = JasperFillManager.fillReport(jr, parametros, con.getConn());
            JasperViewer visor = new JasperViewer(jp,false);
            visor.setTitle("Reporte de ingresos por fechas");
            visor.setVisible(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
 public static void reporte_por_fecha_hora(Date de){
        Conexion con;
        
        try {
            JasperReport  jr= (JasperReport) JRLoader.
                   loadObject(manejador_de_reportes.
                           class.getResourceAsStream("/org/com/reportes/reporte_hora_fecha.jasper"));
            
            con=Conexion.getInstancia();
            
            Map parametros = new HashMap();
            parametros.put("fecha", de);
            
            JasperPrint jp;
            jp = JasperFillManager.fillReport(jr, parametros, con.getConn());
            JasperViewer visor = new JasperViewer(jp,false);
            visor.setTitle("Reporte de ingresos por fecha y horas");
            visor.setVisible(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
     
}
