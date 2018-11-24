
package org.com.models;

import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.com.bens.reporte_turno;
import org.com.db.reportes_db;

/**
 *
 * @author Jherson
 */
public class reporte_ganancia_turno  extends AbstractTableModel{
    public List<reporte_turno>lista;
    public String [] cabecera = {"Empelado","Apertura","Cierre","Total"};
    private reportes_db reportedb;

    public reporte_ganancia_turno(Date fecha,Date fin, int parqueo) {
        reportedb =new reportes_db();
        lista=reportedb.retornar_reporte_por_turno(fecha,fin,parqueo);
        
    }
    
    public reporte_turno elementAt(int indice){
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
      reporte_turno au = lista.get(a);
      String resultado=null;
      
      switch(b){
          case 0:
              resultado = au.getUsuario();
              break;
          case 1:
              resultado = au.getApertura();
              break;
          case 2: resultado = au.getCierre();
              break;
          case 3: resultado = String.valueOf(au.getTotal());
          
      }
      return resultado;
    }
    
     @Override
    public String getColumnName(int i) {
        return cabecera[i];
    }
}
