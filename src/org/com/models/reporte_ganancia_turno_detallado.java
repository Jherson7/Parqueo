
package org.com.models;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.com.bens.reporte_turno;
import org.com.bens.reporte_turno_detallado;
import org.com.bens.ticket;
import org.com.db.cobro_db;
import org.com.db.reportes_db;

/**
 *
 * @author Jherson
 */
public class reporte_ganancia_turno_detallado  extends AbstractTableModel{
    public List<ticket>lista;
    public String [] cabecera = {"Codigo","Entrada Ticket","Salida Ticket","Factura","Total"};
    private cobro_db reportedb;
    public int tickets_dia=0;
    public int tickets_noche=0;
    public int tickets_con_descuento=0;

    public Double ganancia_dia=0.0;
    public Double gananacia_noche=0.0;
    
    public reporte_ganancia_descuento tabla_descuento;
    /*public reporte_ganancia_turno_detallado(Date fecha,Date fin, int parqueo) {
        reportedb =new reportes_db();
        lista=reportedb.retornar_reporte_por_turno_detallado(fecha,fin,parqueo);
        
    }*/

    public reporte_ganancia_turno_detallado(int turno) {
        lista = new LinkedList<>();
        reportedb =new cobro_db();
        reportedb.get_tickets_por_turno_dia(lista, ""+turno);
        
        tabla_descuento = new reporte_ganancia_descuento(turno);
        
        
        tickets_dia = lista.size();
        setear_ganancia_dia();
        reportedb.get_ticket_por_turno_noche(lista, ""+turno);
        tickets_noche= lista.size()-tickets_dia;
        setear_ganancia_noche();
    }
    
    public ticket elementAt(int indice){
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
      ticket au = lista.get(a);
      String resultado=null;
      
          switch (b) {
              case 0: 
                  resultado = String.valueOf(au.getCodigo());
                  break;
              case 1:
                  resultado = String .valueOf(au.getHora_ingreso());
                  break;
              case 2:
                  resultado = String .valueOf(au.getHora_salida());
                  break;
              case 3:
                  resultado = (au.getFactura().equals(""))?"Vacio": au.getFactura();
                  break;
              case 4:
                  resultado = String.valueOf(au.getTotal());
                  break;
          }
          return resultado;
    }
    
     @Override
    public String getColumnName(int i) {
        return cabecera[i];
    }

    private void setear_ganancia_dia() {
        for(ticket t:lista){
            ganancia_dia+=t.getTotal();
        }
    }

    private void setear_ganancia_noche() {
         for(ticket t:lista){
            gananacia_noche+=t.getTotal();
        }
        gananacia_noche= gananacia_noche- ganancia_dia;
    }
}
