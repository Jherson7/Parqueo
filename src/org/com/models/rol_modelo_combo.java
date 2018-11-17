/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.com.models;

import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import org.com.bens.rol;
import org.com.db.rol_db;

/**
 *
 * @author Jherson
 */
public class rol_modelo_combo {
    private DefaultComboBoxModel<rol> combo;
    private LinkedList<rol> lista;
    private rol_db roldb;

    public rol_modelo_combo() {
        roldb = new rol_db();
        combo = new DefaultComboBoxModel<>();
        lista=(LinkedList<rol>) roldb.retornarLista();
        for(rol r : lista){
            combo.addElement(r);
        }
    }

    public DefaultComboBoxModel<rol> getCombo() {
        return combo;
    }
}
