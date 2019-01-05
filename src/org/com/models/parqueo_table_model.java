package org.com.models;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import org.com.bens.parqueo;
import org.com.db.parqueo_db;

/**
 *
 * @author Jherson
 */
public class parqueo_table_model extends AbstractTableModel {
    public List<parqueo>lista;
    public String [] cabecera = {"ID","NOMBRE PARQUEO","DIRECCION"};
    private parqueo_db parqueodb;
    private int maxid;

    public parqueo_table_model() {
        parqueodb =new parqueo_db();
        lista=parqueodb.retornarLista();
        maxid=-1;
    }
    
    public parqueo elementAt(int indice){
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
      parqueo au = lista.get(a);
      String resultado=null;
      
      switch(b){
          case 0:
              resultado = String.valueOf(au.getId_parqueo());
              break;
          case 1:
              resultado = au.getNombre_parqueo();
              break;
          case 2: resultado = au.getDireccion();
              break;
          
      }
      return resultado;
    }
    
     @Override
    public String getColumnName(int i) {
        return cabecera[i];
    }
    
    
    
    /**************METODOS PARA CRU
     * @param par******************/
    
    public void agregar_parqueo(parqueo par){
        
        int a = parqueodb.agregar_parqueo(par);
        
        if(a!=1){
            JOptionPane.showMessageDialog(null,  "Se guardo correctamente el parqueo: "+par.getNombre_parqueo(),"Panel de Parqueo", 1);  
            this.lista.add(par);
        }
        else
          JOptionPane.showMessageDialog(null,"ERROR al guardar el parqueo: "+par.getNombre_parqueo(), "Panel de Parqueo", 0);
      
        this.fireTableDataChanged();
    }
    
    public void modificar_parqueo(parqueo par){
        int a = parqueodb.editar_parqueo(par);
        if(a!=1)
          JOptionPane.showMessageDialog(null,  "Se modifico correctamente el parqueo: "+par.getNombre_parqueo(),"Panel de Parqueo", 1);
        else
          JOptionPane.showMessageDialog(null,"ERROR al modificar el parqueo: "+par.getNombre_parqueo(), "Panel de Parqueo", 0);
        this.fireTableDataChanged();
    }
    
    
    public void eliminar_parqueo(parqueo par){
        int a = parqueodb.eliminar_parqueo(par);
        lista.remove(par);
          if(a!=1)
          JOptionPane.showMessageDialog(null,  "Se elimino correctamente el parqueo: "+par.getNombre_parqueo(),"Panel de Parqueo", 1);
        else
          JOptionPane.showMessageDialog(null,"ERROR al eliminar el parqueo: "+par.getNombre_parqueo(), "Panel de Parqueo", 0);
        this.fireTableDataChanged();
    }
    
    
}

