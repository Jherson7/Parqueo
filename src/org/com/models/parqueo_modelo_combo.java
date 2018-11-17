package org.com.models;

import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import org.com.bens.parqueo;
import org.com.db.parqueo_db;

/**
 *
 * @author Jherson
 */
public class parqueo_modelo_combo {
    private DefaultComboBoxModel<parqueo> combo;
    private LinkedList<parqueo> lista;
    private parqueo_db parqueo;

    public parqueo_modelo_combo() {
        parqueo = new parqueo_db();
        combo = new DefaultComboBoxModel<>();
        lista=(LinkedList<parqueo>) parqueo.retornarLista();
        for(parqueo r : lista){
            combo.addElement(r);
        }
    }

    public DefaultComboBoxModel<parqueo> getCombo() {
        return combo;
    }
}
