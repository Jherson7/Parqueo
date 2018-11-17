package org.com.models;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import org.com.bens.descuento;
import org.com.db.descuento_db;

/**
 *
 * @author Jherson
 */
public class descuento_modelo_tabla  extends AbstractTableModel{
    public List<descuento>lista;
    public String [] cabecera = {"ID","NOMBRE DESCUENTO","FECHA CREACION","MINUTOS","PORCENTAJE"};
    private descuento_db descdb;
    private int maxid;

    public descuento_modelo_tabla() {
        descdb =new descuento_db();
        lista=descdb.retornarLista();
        maxid=descdb.get_max_id();
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
      descuento au = lista.get(a);
      String resultado=null;
      
      switch(b){
          case 0:
              resultado = String.valueOf(au.getId_descuento());
              break;
          case 1:
              resultado = au.getNombre_descuento();
              break;
          case 2: 
              SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

                String dateString = format.format( au.getFecha());
                resultado = dateString;
              break;
          case 3:
              resultado = String.valueOf(au.getMinutos_descuento());
              break;
          case 4:
              resultado = String.valueOf(au.getPorcetaje());
              break;
      }
      return resultado;
    }
    
     @Override
    public String getColumnName(int i) {
        return cabecera[i];
    }
    
     public void agregar_descuento(descuento par){
        par.setId_descuento(++maxid);
        int a = descdb.agregar_descuento(par);
        if(a!=1){
            JOptionPane.showMessageDialog(null,  "Se guardo correctamente el Descuento: "+par.getNombre_descuento(),"Panel de Descuento", 1);  
            this.lista.add(par);
        }
        else
          JOptionPane.showMessageDialog(null,"ERROR al guardar el Descuento: "+par.getNombre_descuento(), "Panel de Descuento", 0);
        this.fireTableDataChanged();
    }
 
    public void modificar_descuento(descuento par) {

        int a = descdb.editar_descuento(par);
        if (a != 1) {
            JOptionPane.showMessageDialog(null, "Se guardo modifico el Descuento: " + par.getNombre_descuento(), "Panel de Descuento", 1);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR al modificar el Descuento: " + par.getNombre_descuento(), "Panel de Descuento", 0);
        }
        this.fireTableDataChanged();
    }

    public void eliminar_descuento(descuento par) {

        int a = descdb.eliminar_descuento(par);
        if (a != 1) {
            JOptionPane.showMessageDialog(null, "Se guardo elimino el Descuento: " + par.getNombre_descuento(), "Panel de Descuento", 1);
            this.lista.remove(par);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR al modificar el Descuento: " + par.getNombre_descuento(), "Panel de Descuento", 0);
        }
        this.fireTableDataChanged();
    }
    
    public descuento getElementAt(int indice) {
       return this.lista.get(indice);
    }
}
