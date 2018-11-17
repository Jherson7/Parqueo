
package org.com.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.com.bens.reporte_hora_fecha_beans;
import org.com.db.reportes_db;

/**
 *
 * @author Jherson
 */
public class reporte_por_fecha_model_table  extends AbstractTableModel{
    public List<reporte_hora_fecha_beans>lista;
    public String [] cabecera = {"No.","Total","Fecha"};
    private reportes_db reportedb;
    int contador;
    
    public reporte_por_fecha_model_table(Date desde,Date hasta) {
        reportedb =new reportes_db();
        lista=reportedb.retornar_por_fechas(desde,hasta);
        contador=1;
        
    }
    
    public reporte_hora_fecha_beans elementAt(int indice){
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
      reporte_hora_fecha_beans au = lista.get(a);
      String resultado=null;

      if(au.getNumero()<=0){
          au.setNumero(contador++);
      }
      
      switch(b){
          case 0:
              resultado = String.valueOf(au.getNumero());
              break;
          case 1:
              resultado = String.valueOf(au.getTotal());
              break;
          case 2: resultado = String.valueOf(new SimpleDateFormat("dd/MM/yyyy").format(au.getFecha()));
              break;
          
      }
      return resultado;
    }
    
     @Override
    public String getColumnName(int i) {
        return cabecera[i];
    }
}
