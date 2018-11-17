package org.com.controler;

import org.com.models.tarifa_modelo_tabla;

/**
 *
 * @author Jherson
 */
public class tarifa_controller {
    private static tarifa_modelo_tabla tabla;
    
    public static tarifa_modelo_tabla getTabla(){
        tabla = new tarifa_modelo_tabla();
        return tabla;
    }
}
