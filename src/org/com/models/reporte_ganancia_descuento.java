/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.com.models;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.com.bens.reporte_turno_detallado;
import org.com.db.cobro_db;

/**
 *
 * @author jortiz
 */
public class reporte_ganancia_descuento extends AbstractTableModel{
    public List<reporte_turno_detallado>lista;
    public String [] cabecera = {"Descuento","Entrada Ticket","Salida Ticket","Factura","Cant Desc","Total"};
    private cobro_db reportedb;
    public int tickets_dia=0;
    public int tickets_noche=0;
    public int tickets_con_descuento=0;

    public Double ganancia_dia=0.0;
    public Double gananacia_noche=0.0;
    

    public reporte_ganancia_descuento(int turno) {
        lista = new LinkedList<>();
        reportedb =new cobro_db();
        
        reportedb.get_ticket_por_turno_dia_descuento(lista, ""+turno);
        setear_ganancia_dia();
        reportedb.get_ticket_por_turno_noche_descuento(lista, ""+turno);
        setear_ganancia_noche();
    }
    
    public reporte_turno_detallado elementAt(int indice){
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
      reporte_turno_detallado au = lista.get(a);
      String resultado=null;
      
          switch (b) {
              case 0: 
                  resultado = au.getNombre_descuento();
                  break;
              case 1:
                  resultado = au.getHora_ingreso();
                  break;
              case 2:
                  resultado = au.getHora_salida();
                  break;
              case 3:
                  resultado = au.getFactura();
                  break;
              case 4:
                  resultado = au.getDescuento();
                  break;
              case 5:
                  resultado = au.getTotal();
                  break;
          }
          return resultado;
    }
    
     @Override
    public String getColumnName(int i) {
        return cabecera[i];
    }
    
    private void setear_ganancia_dia() {
        tickets_dia= lista.size();
        for(reporte_turno_detallado t:lista){
            ganancia_dia+=Double.parseDouble(t.getTotal());
        }
    }

    private void setear_ganancia_noche() {
        tickets_noche= lista.size()-tickets_dia;
        for(reporte_turno_detallado t:lista){
            gananacia_noche+=Double.parseDouble(t.getTotal());
        }
        gananacia_noche= gananacia_noche- ganancia_dia;
    }
   
}
