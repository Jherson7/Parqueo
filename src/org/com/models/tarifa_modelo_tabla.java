package org.com.models;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import org.com.bens.tarifa;
import org.com.db.tarifa_db;

public class tarifa_modelo_tabla extends AbstractTableModel{

    public List<tarifa>lista;
    public String [] cabecera = {"ID","PRECIO","MEDIA HORA","HORA INICIO","HORA FIN","PARQUEO","TARIFA UNICA"};
    private tarifa_db tarifadb;
    private int maxid=0;
    
    public tarifa_modelo_tabla() {
        tarifadb =new tarifa_db();
        lista=tarifadb.retornarLista();
        maxid=tarifadb.get_max_id()+1;
    }
    
    public tarifa elementAt(int indice){
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
      tarifa au = lista.get(a);
      String resultado=null;
      
          switch (b) {
              case 0:
                  resultado = String.valueOf(au.getIdTARIFA());
                  break;
              case 1:
                  resultado = String.valueOf(au.getPrecio());
                  break;
              case 2:
                  resultado = String.valueOf(au.getMedia_hora());
                  break;
              case 3:
                  resultado = String.valueOf(au.getHora_inicio_tarifa());
                  break;
              case 4:
                  resultado = String.valueOf(au.getHora_fin_tarifa());
                  break;
              case 5:
                  resultado = au.getParqueo();
                  break;
              case 6:
                  if (au.getTarifa_unica() == 1) {
                      resultado = "SI";
                  } else {
                      resultado = "NO";
                  }
                  break;
          }
      return resultado;
    }
    
     @Override
    public String getColumnName(int i) {
        return cabecera[i];
    }
    
    
    
    public void agregar_tarifa(tarifa tar){
        tar.setIdTARIFA(maxid++);
        int a = tarifadb.agregar_tarifa(tar);
        if (a != 1) {
            JOptionPane.showMessageDialog(null, "Se guardo correctamente la tarifa: "+tar.getPrecio(), "Panel de Tarifas", 1);
            this.lista.add(tar);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR al guardar la tarifa: " + tar.getPrecio(), "Panel de Tarifas", 0);
        }
        this.fireTableDataChanged();
    }
    
    public void modificar_tarifa(tarifa tar){
        int a = tarifadb.modificar_tarifa(tar);
        if (a != 1) {
            JOptionPane.showMessageDialog(null, "Se modifico correctamente la tarifa: "+tar.getPrecio(), "Panel de Tarifas", 1);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR al modificar la tarifa: " + tar.getPrecio(), "Panel de Tarifas", 0);
        }
        this.fireTableDataChanged();
    }
    
    public void eliminar_tarifa(tarifa tar){
        int a = tarifadb.eliminar_tarifa(tar);
        if (a != 1) {
            JOptionPane.showMessageDialog(null, "Se elimino correctamente la tarifa: "+tar.getPrecio(), "Panel de Tarifas", 1);
            this.lista.remove(tar);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR al elimino la tarifa: " + tar.getPrecio(), "Panel de Tarifas", 0);
        }
        this.fireTableDataChanged();
    }
}
