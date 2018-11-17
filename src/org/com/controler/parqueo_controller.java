/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.com.controler;

import javax.swing.DefaultComboBoxModel;
import org.com.bens.parqueo;
import org.com.models.parqueo_modelo_combo;
import org.com.models.parqueo_table_model;

/**
 *
 * @author Jherson
 */
public class parqueo_controller {
    private static parqueo_table_model tabla;
    private static parqueo_modelo_combo combo;
    
    public static parqueo_table_model getTabla() {
        tabla = new parqueo_table_model();
        return tabla;
    }
    
    public static DefaultComboBoxModel<parqueo>getCombo(){
        combo = new parqueo_modelo_combo();
        return combo.getCombo();
    }
}
