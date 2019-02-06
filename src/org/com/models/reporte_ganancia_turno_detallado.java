
package org.com.models;

import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.com.bens.reporte_turno;
import org.com.bens.reporte_turno_detallado;
import org.com.db.reportes_db;

/**
 *
 * @author Jherson
 */
public class reporte_ganancia_turno_detallado  extends AbstractTableModel{
    public List<reporte_turno_detallado>lista;
    public String [] cabecera = {"Empleado","Apertura","Cierre","Entrada Ticket","Salida Ticket","Total"};
    private reportes_db reportedb;

    public reporte_ganancia_turno_detallado(Date fecha,Date fin, int parqueo) {
        reportedb =new reportes_db();
        lista=reportedb.retornar_reporte_por_turno_detallado(fecha,fin,parqueo);
        
    }
    
    public reporte_turno_detallado elementAt(int indice){
        return this.lista.get(indice);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return cabecera.length;
    }

      @Override
    public Object getValueAt(int a, int b) {
      reporte_turno_detallado au = lista.get(a);
      String resultado=null;
      
          switch (b) {
              case 0:
                  resultado = au.getUsuario();
                  break;
              case 1:
                  resultado = au.getApertura();
                  break;
              case 2:
                  resultado = au.getCierre();
                  break;
              case 3:
                  resultado = au.getHora_ingreso();
                  break;
              case 4:
                  resultado = au.getHora_salida();
                  break;
              case 5:
                  resultado = String.valueOf(au.getTotal());

          }
          return resultado;
    }
    
     @Override
    public String getColumnName(int i) {
        return cabecera[i];
    }
}
