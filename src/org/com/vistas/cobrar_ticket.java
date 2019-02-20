package org.com.vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.com.bens.descuento;
import org.com.bens.ticket;
import org.com.controler.descuento_controller;
import org.com.logica.Cobro;
import org.com.logica.Controlador;
import org.com.logica.monto_cobro;

/**
 *
 * @author Jherson
 */
public class cobrar_ticket extends javax.swing.JInternalFrame {

    private String codigo = "";
    monto_cobro temp;
    int abrir = 230;
    
    int[] PrintCm = {0x10, 0x04, 0x01, 0x10, 0x04, 0x01, 0x10, 0x04, 0x01, 0x10, 0x04, 0x01, 0x10, 0x04, 0x01};
    int[] PirntEnd = {0x0a, 0x0a};
    int[] CodeBar = {0x10, 0x04, 0x01, 0x10, 0x04, 0x01, 0x10, 0x04, 0x01, 0x10, 0x04, 0x01, 0x10, 0x04, 0x01, 0x1b, 0x40, 0x1b, 0x32, 0x1d};
    int[] CodeBar2 = {0x68, 0x50, 0x1d, 0x48, 0x02, 0x0a, 0x0a, 0x1d, 0x6b, 0x06};
    int[] CodeBarEnd = {0x00, 0x0a, 0x0a, 0x0a};
    int[] PrintCut = {0x1b, 0x40, 0x0d, 0x0a, 0x0a, 0x0a, 0x1b, 0x6d};

    public cobrar_ticket() {

        initComponents();
        combo_descuento.setModel(descuento_controller.getCombo());
        combo_descuento.setEnabled(false);
        txt_factura.setEnabled(false);
        iniciar_hilo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        combo_descuento = new javax.swing.JComboBox();
        chk_descuento = new javax.swing.JCheckBox();
        panel_cobro = new javax.swing.JPanel();
        btn_cobrar1 = new javax.swing.JButton();
        scroll_detalles = new javax.swing.JScrollPane();
        chk_extraviado = new javax.swing.JCheckBox();
        txt_codigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lbl_estado = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_factura = new javax.swing.JTextField();
        chk_factura = new javax.swing.JCheckBox();

        combo_descuento.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        combo_descuento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_descuento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_descuentoItemStateChanged(evt);
            }
        });

        chk_descuento.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        chk_descuento.setText("Aplicar Descuento?");
        chk_descuento.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chk_descuentoStateChanged(evt);
            }
        });
        chk_descuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_descuentoActionPerformed(evt);
            }
        });

        panel_cobro.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles del Cobro"));

        btn_cobrar1.setBackground(new java.awt.Color(0, 153, 153));
        btn_cobrar1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        btn_cobrar1.setForeground(new java.awt.Color(255, 255, 255));
        btn_cobrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/dinero.png"))); // NOI18N
        btn_cobrar1.setText("COBRAR");
        btn_cobrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cobrar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_cobroLayout = new javax.swing.GroupLayout(panel_cobro);
        panel_cobro.setLayout(panel_cobroLayout);
        panel_cobroLayout.setHorizontalGroup(
            panel_cobroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_cobrar1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
            .addComponent(scroll_detalles)
        );
        panel_cobroLayout.setVerticalGroup(
            panel_cobroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cobroLayout.createSequentialGroup()
                .addComponent(scroll_detalles, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cobrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        chk_extraviado.setFont(new java.awt.Font("MS Gothic", 2, 12)); // NOI18N
        chk_extraviado.setText("Ticket Extraviado");
        chk_extraviado.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chk_extraviadoStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel1.setText("Leyendo Ticket:");

        lbl_estado.setFont(new java.awt.Font("MS Reference Sans Serif", 3, 12)); // NOI18N
        lbl_estado.setText("Estado");

        jLabel2.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel2.setText("Factura:");

        txt_factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_facturaActionPerformed(evt);
            }
        });

        chk_factura.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chk_facturaStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(panel_cobro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(combo_descuento, 0, 309, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chk_descuento)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_factura, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(chk_factura)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_estado))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(chk_extraviado)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_estado))
                .addGap(18, 18, 18)
                .addComponent(chk_descuento)
                .addGap(7, 7, 7)
                .addComponent(combo_descuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chk_extraviado)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(chk_factura)
                    .addComponent(txt_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_cobro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chk_descuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_descuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_descuentoActionPerformed

    private void realizar_calculo() {
        int id_desc = 0;

        if (!"Listo!".equals(lbl_estado.getText())) {
            JOptionPane.showMessageDialog(this, "No se ha detectado codigo, por favor intente de nuevo!", "ERROR", 0);
            iniciar_hilo();
            return;
        }
        if (combo_descuento.getSelectedIndex() >= 0 && chk_descuento.isSelected()) {
            descuento desc = (descuento) combo_descuento.getSelectedItem();
            id_desc = desc.getId_descuento();
        }
        //temp = Cobro.calcular_costo("45", id_desc);//cambiar por el codigo escaneado
        temp = Cobro.calcular_costo(codigo, id_desc);//cambiar por el codigo escaneado
        mostrar_calculo();

    }

    private void mostrar_calculo() {

        JPanel panel_detalles = new JPanel();
        panel_detalles.setLayout(new GridLayout(temp.detalles.size() + 5, 1));

        for (String s : temp.detalles) {
            JLabel lable = new JLabel(s);
            panel_detalles.add(lable);
        }

        panel_detalles.add(new JLabel("------------------------------"));
        panel_detalles.add(new JLabel("Sub Total:      Q." + temp.getTicket().getSubtotal()));
        panel_detalles.add(new JLabel("Descuento:   Q." + temp.getTicket().getDescuento()));
        JLabel total = new JLabel("Total:      Q." + temp.getTicket().getTotal());
        total.setFont(new Font("Serif", Font.PLAIN, 20));
        total.setForeground(Color.red);
        panel_detalles.add(new JLabel("------------------------------"));
        panel_detalles.add(total);
        
        panel_detalles.repaint();
        scroll_detalles.setViewportView(panel_detalles);
        scroll_detalles.repaint();
    }

    private void chk_descuentoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chk_descuentoStateChanged
        // TODO add your handling code here:
        if (chk_descuento.isSelected()) {
            combo_descuento.setEnabled(true);
        } else {
            if (temp != null) {
                temp.getTicket().setDescuento(0);
                temp.getTicket().setTotal(temp.getTicket().getSubtotal());
                mostrar_calculo();
            }
            combo_descuento.setEnabled(false);
        }
    }//GEN-LAST:event_chk_descuentoStateChanged

    private void chk_extraviadoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chk_extraviadoStateChanged
        if (chk_extraviado.isSelected()) {
            setearTotalTicketExtraviado();
        }
    }//GEN-LAST:event_chk_extraviadoStateChanged

    private void btn_cobrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cobrar1ActionPerformed
        // TODO add your handling code here:
        if (chk_extraviado.isSelected()) {
            int a = Cobro.realizar_cobro_extraviado(temp.getTicket());
            if (a != 1) {
                //JOptionPane.showMessageDialog(null, "Se inserto correctamente el ticket extraviado:" + codigo, "Panel de Cobro", 1);
                //tendria que escribir abrir
                
                //this.dispose();
                Controlador.escribir_en_serial(abrir);
                inicializar();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR al insertar el ticket extraviado, pongase en contacto con el desarrollador de Software", "Panel de Cobro", 0);
            }
        } else {
            
            if (temp != null) {
                temp.getTicket().setFactura(txt_factura.getText());
                int a = Cobro.realizar_cobro(temp.getTicket());
                if (a != 1) {
                    /*JOptionPane.showMessageDialog(null, "Se cobro correctamente el ticket", "Panel de Cobro", 1);*/
                    
                    //this.dispose();
                    Controlador.escribir_en_serial(abrir);
                    inicializar(); //--esto limpiar la pantalla
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR al cobrar el ticket, pongase en contacto con el desarrollador de Software", "Panel de Cobro", 0);
                    //estado= "Fallido";
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se ha detectado ticket!", "ERROR", 0);
            }
        }
    }//GEN-LAST:event_btn_cobrar1ActionPerformed

    private void combo_descuentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_descuentoItemStateChanged
        // TODO add your handling code here:
        float descuento;
        if (combo_descuento.getSelectedIndex() > 0) {
            if (temp == null) {
                JOptionPane.showMessageDialog(this, "No se ha detectado ticket, por favor escanee ticket", "ERROR", 0);;
            } else {
                descuento desc = (descuento) combo_descuento.getSelectedItem();
                if (desc.getTipo()== 1) {
                    float res = (float) desc.getValor();
                    res = res / 100;
                    descuento = (float) (res * temp.getTicket().getSubtotal());//descuento por porcentaje
                } else if (desc.getTipo()== 2) { 
                    float calculo =(float) desc.getValor();
                    calculo = calculo / 60;
                    descuento = (float) (calculo * temp.getTarifa());//descuento por minutos
                } else {
                    descuento =(float) desc.getValor();
                }

                temp.getTicket().setDescuento(descuento);
                temp.getTicket().setTotal(temp.getTicket().getSubtotal() - descuento);
                temp.getTicket().setFdescuento(desc.getId_descuento());
                mostrar_calculo();
            }
        }


    }//GEN-LAST:event_combo_descuentoItemStateChanged

    private void txt_facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_facturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_facturaActionPerformed

    private void chk_facturaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chk_facturaStateChanged
        // TODO add your handling code here:
        if(chk_factura.isSelected()){
            txt_factura.setEnabled(true);
        }else{
            txt_factura.setText("");
            txt_factura.setEnabled(false);
        }
    }//GEN-LAST:event_chk_facturaStateChanged
    
    private void prueba_de_calculo(){
       /* inicializar();
 
        temp = Cobro.calcular_costo(jTextField1.getText(), 0);//cambiar por el codigo escanead
        mostrar_calculo();*/
    }
    
    private void pruebas_de_envio(){
               /* temp = Cobro.calcular_costo("0B6DB", 0);//cambiar por el codigo escaneado
        mostrar_calculo();
*/
        //cobro_db nuevo = new cobro_db();
        //nuevo.insertar_y_obtener_ticket(Controlador.getParqueo().getId_parqueo());
        String mensaje
                = "         TICKET DE CONTROL\n"
                + "             GAPRI S.A.\n"
                + "     4ta. Avenida 16-10 ZONA 10\n"
                + "          " + get_fecha_hora() + "\n"
                + "    ACCESO: B    CORRELATIVO: 123456\n";
    try {
            String toSerial = InitText()+
            mensaje+
            EndText()+
            InitCodebar()+
            ("A123456A")+
            EndCodebar()+
            PrinterCut();
            
            //EscritorSerial.escribir_en_serial(toSerial);
            String open = 230+"";
                    
            //Controlador.escribir_en_serial(toSerial);
            Controlador.escribir_en_serial(230);
        } catch (Exception e) {
        }
    }
    
    
    String InitText() {
        String txt = "";
        for (int i = 0; i <= 14; i++) {
            
            txt += (char)PrintCm[i];
        }
        return txt;
    }

    String EndText() {
        String txt = ""+(char)0x0a+(char)0x0a;        
        return txt;
    }

    String InitCodebar() {
        String txt = "";
        for (int i = 0; i <= 19; i++) {
            txt += (char)CodeBar[i];
        }
        for (int i = 0; i <= 9; i++) {
            txt += (char)CodeBar2[i];
        }
        return txt;
    }

    String EndCodebar() {
        String txt = "";
        for (int i = 0; i <= 3; i++) {
            txt += (char)CodeBarEnd[i];
        }
        return txt;
    }

    String PrinterCut() {
        String txt = "";
        for (int i = 0; i <= 7; i++) {
            txt += (char)PrintCut[i];
        }
        return txt;
    }

    private String get_fecha_hora() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(timestamp);
        String hora = new SimpleDateFormat("HH:mm:ss").format(timestamp);

        return "FECHA:" + fecha + " HORA:" + hora;

    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cobrar1;
    private javax.swing.JCheckBox chk_descuento;
    private javax.swing.JCheckBox chk_extraviado;
    private javax.swing.JCheckBox chk_factura;
    private javax.swing.JComboBox combo_descuento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbl_estado;
    private javax.swing.JPanel panel_cobro;
    private javax.swing.JScrollPane scroll_detalles;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_factura;
    // End of variables declaration//GEN-END:variables

    private void iniciar_hilo() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int numero = 0;
                for (int i = 0; i < 60; i++, numero++) {
                    //System.out.println("Cerdo " + i);
                    txt_codigo.requestFocus();
                    if (!"".equals(txt_codigo.getText())) {

                        codigo = txt_codigo.getText();
                        //JOptionPane.showMessageDialog(null, codigo);
                        lbl_estado.setText("Listo!");
                        chk_extraviado.setEnabled(false);

                        realizar_calculo();

                        return;
                    }

                    String esperando = "esperando";
                    for (int x = 0; x < numero; x++) {
                        esperando += ".";
                    }
                    lbl_estado.setText(esperando);

                    if (numero >= 4) {
                        numero = 0;
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
    }

    private void setearTotalTicketExtraviado() {
        ticket tick = new ticket();

        tick.setDescuento(0);
        tick.setSubtotal(100.0);
        tick.setTotal(100.0);
        tick.setTurno(Controlador.getTurno_actual().getId_turno());

        JLabel total = new JLabel("Total:     Q.100");
        JLabel sub = new JLabel("Subtotal:    Q.100");
        JLabel desc = new JLabel("Descuento:  Q.0");
        //JLabel estado = new JLabel("Estado:\t\tExitoso");
        JLabel line = new JLabel("-----------------------");

        JPanel panel_detalles = new JPanel();
        panel_detalles.setLayout(new GridLayout(5, 1));

        panel_detalles.add(total);
        panel_detalles.add(sub);
        panel_detalles.add(desc);
        panel_detalles.add(line);
        panel_detalles.repaint();

        if (temp == null) {
            temp = new monto_cobro();
        }

        temp.setTicket(tick);//ver como le hago con el id

        scroll_detalles.setViewportView(panel_detalles);
        scroll_detalles.repaint();

        chk_descuento.setSelected(false);

    }

    private void inicializar() {
        temp  = new monto_cobro();
        JPanel panel_detalles = new JPanel();
        panel_detalles.setLayout(new GridLayout(temp.detalles.size() + 5, 1));
        panel_detalles.repaint();
        scroll_detalles.setViewportView(panel_detalles);
        scroll_detalles.repaint();
        iniciar_hilo();
    }
}
