package org.com.controler;

import javax.swing.DefaultComboBoxModel;
import org.com.bens.descuento;
import org.com.models.descuento_modelo_combo;
import org.com.models.descuento_modelo_tabla;

/**
 *
 * @author Jherson
 */
public class descuento_controller {
    private static descuento_modelo_tabla tabla;
    private static descuento_modelo_combo combo;
    
    public static descuento_modelo_tabla getTabla(){
        tabla = new descuento_modelo_tabla();
        return tabla;
    }
    
    public static DefaultComboBoxModel<descuento> getCombo(){
        combo = new descuento_modelo_combo();
        return combo.getCombo();
    }
           
}
