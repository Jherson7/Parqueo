/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.com.controler;

import javax.swing.DefaultComboBoxModel;
import org.com.models.usuario_modelo_tabla;

/**
 *
 * @author Jherson
 */
public class usuario_controller {
    private static usuario_modelo_tabla tabla;

    
    public static usuario_modelo_tabla getTabla(){
        tabla = new usuario_modelo_tabla();
        return tabla;
    }
    
   
}
