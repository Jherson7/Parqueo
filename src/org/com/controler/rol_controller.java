/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.com.controler;

import javax.swing.DefaultComboBoxModel;
import org.com.bens.rol;
import org.com.models.rol_modelo_combo;

/**
 *
 * @author Jherson
 */
public class rol_controller {
     private static rol_modelo_combo combo;
     
      public static DefaultComboBoxModel<rol> getComboRol(){
        combo = new rol_modelo_combo();
        return combo.getCombo();
    }
     
}
