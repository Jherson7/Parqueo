package org.com.models;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.com.bens.reporte_tickets;
import org.com.db.reportes_db;

/**
 *
 * @author Jherson
 */
public class reporte_ticket_pendient_table extends AbstractTableModel{
    public List<reporte_tickets>lista;
    public String [] cabecera = {"No.","Codigo","Fecha Hora"};
    private reportes_db reportedb;
    
    public reporte_ticket_pendient_table(int parqueo) {
        reportedb =new reportes_db();
        lista=reportedb.reporte_tickets_pendientes(parqueo);
    }
    
    public reporte_tickets elementAt(int indice){
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
      reporte_tickets au = lista.get(a);
      String resultado=null;

      switch(b){
          case 0:
              resultado = String.valueOf(au.getNo());
              break;
          case 1:
              resultado = au.getCodigo();
              break;
          case 2: resultado = au.getFecha();
              break;
          
      }
      return resultado;
    }
    
     @Override
    public String getColumnName(int i) {
        return cabecera[i];
    }
}
