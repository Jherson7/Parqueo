
package org.com.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.com.bens.reporte_estadistica;
import org.com.bens.reporte_hora_fecha_beans;
import org.com.db.reportes_db;

/**
 *
 * @author Jherson
 */
public class reporte_vehiculos_promedio_model_table  extends AbstractTableModel{
    public List<reporte_estadistica>lista;
    public String [] cabecera = {"No.","Fecha","Total de Vehiculos","Promedio"};
    private reportes_db reportedb;

    public reporte_vehiculos_promedio_model_table(Date fecha,Date hasta) {
        reportedb =new reportes_db();
        lista=reportedb.retornar_reporte_estadistica_vehiculos(fecha,hasta);
        
    }
    
    public reporte_estadistica elementAt(int indice){
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
      reporte_estadistica au = lista.get(a);
      String resultado=null;
      
      switch(b){
          case 0:
              resultado = String.valueOf(au.getNumero());
              break;
          case 1:
              resultado = String.valueOf(new SimpleDateFormat("dd/MM/yyyy").format(au.getFecha()));
              break;
          case 2:
              resultado = String.valueOf(au.getTotal_vehiculos());
              break;
          case 3:
              resultado = String.valueOf(au.getPromedio());
              break;
         
      }
      return resultado;
    }
    
     @Override
    public String getColumnName(int i) {
        return cabecera[i];
    }
}
