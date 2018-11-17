package org.com.models;

import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import org.com.bens.descuento;
import org.com.db.descuento_db;

/**
 *
 * @author Jherson
 */
public class descuento_modelo_combo {
    DefaultComboBoxModel<descuento> modelo;
    private LinkedList<descuento> lista;
    private descuento_db descuento;

    public descuento_modelo_combo(){
        modelo = new DefaultComboBoxModel<>();
        descuento = new descuento_db();
        
       lista = (LinkedList<descuento>) descuento.retornarLista();
       descuento aux = new descuento();
       aux.setNombre_descuento("Seleccionar:");
       modelo.addElement(aux);
       for(descuento a : lista){
           modelo.addElement(a);
       }
    }
    
    
    public DefaultComboBoxModel<descuento> getCombo(){
        return modelo;
    }
}
