package org.com.vistas;

import java.awt.event.KeyEvent;
import java.sql.Date;
import javax.swing.JOptionPane;
import org.com.bens.descuento;
import org.com.controler.descuento_controller;
import org.com.models.descuento_modelo_tabla;

/**
 *
 * @author Jherson
 */
public class descuentos extends javax.swing.JInternalFrame {

    private void mostrar_registro() {
        limpiar_registros();
        
        descuento_modelo_tabla modelo = (descuento_modelo_tabla) tabla_descuento.getModel();
        indice = tabla_descuento.getSelectedRow();
        if(indice>-1){
            descuento aux = modelo.getElementAt(indice);
            txt_descuento.setText(aux.getNombre_descuento());
            spinner_cantidad.setValue(aux.getValor());
            
            if(aux.getTipo()==1){
                chk_porcentaje.setSelected(true);
            }else if(aux.getTipo()==2){
                chk_min.setSelected(true);
            }else
                chk_dinero.setSelected(true);
            
        }
    }

    private void limpiar_registros() {
        chk_porcentaje.setSelected(false);
        chk_min.setSelected(false);
        chk_dinero.setSelected(false);
        txt_descuento.setText(null);
        spinner_cantidad.setValue(0);
    }
    
    private enum Estado {INICIO, CLICK, RELEASE, NUEVO, EDITAR, GUARDAR, BORRAR};
    private int nuevo=0;
    private int indice = -1;
    
    
    public descuentos() {
        initComponents();
        tabla_descuento.setModel(descuento_controller.getTabla());
        estado(Estado.INICIO);
        
    }

   public void estado(Estado valor){
        switch(valor){
            
            case INICIO:
                txt_descuento.setText(null);
                                
                txt_descuento.setEnabled(false);
                chk_min.setEnabled(false);
                chk_porcentaje.setEnabled(false);
                chk_dinero.setEnabled(false);
                spinner_cantidad.setEnabled(false);
                                
                btnNuevo.setEnabled(true);
                btnEditar.setEnabled(false);
                btnGuardar.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnSalir.setEnabled(true);
                
                break;
            
            case RELEASE:
            case CLICK:
                                
                txt_descuento.setEnabled(false);
                
                txt_descuento.setEnabled(false);
                chk_min.setEnabled(false);
                chk_porcentaje.setEnabled(false);
                chk_dinero.setEnabled(false);
                spinner_cantidad.setEnabled(false);
                
                                
                btnNuevo.setEnabled(true);
                btnEditar.setEnabled(true);
                btnGuardar.setEnabled(false);
                btnEliminar.setEnabled(true);
                btnSalir.setEnabled(true);
                
                break;
            
            case NUEVO:
                txt_descuento.setText(null);
                
               
                txt_descuento.setEnabled(true);
                txt_descuento.setEnabled(true);
                chk_min.setEnabled(true);
                chk_porcentaje.setEnabled(true);
                chk_dinero.setEnabled(true);
                spinner_cantidad.setEnabled(true);
               
                                           
                btnNuevo.setEnabled(false);
                btnEditar.setEnabled(false);
                btnGuardar.setEnabled(true);
                btnEliminar.setEnabled(false);
                btnSalir.setEnabled(true);
                
                break;
            
            case GUARDAR:
                txt_descuento.setText(null);
             
                txt_descuento.setEnabled(false);
                txt_descuento.setEnabled(false);
                chk_min.setEnabled(false);
                chk_porcentaje.setEnabled(false);
                chk_dinero.setEnabled(false);
                spinner_cantidad.setEnabled(false);
                
                
                btnNuevo.setEnabled(true);
                btnEditar.setEnabled(false);
                btnGuardar.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnSalir.setEnabled(true);
                nuevo =0;
                break;
            
            case EDITAR:
                nuevo =0;               
                txt_descuento.setEnabled(true);
                
                txt_descuento.setEnabled(true);
                chk_min.setEnabled(true);
                chk_porcentaje.setEnabled(true);
                chk_dinero.setEnabled(true);
                spinner_cantidad.setEnabled(true);
                
                btnNuevo.setEnabled(false);
                btnEditar.setEnabled(false);
                btnGuardar.setEnabled(true);
                btnEliminar.setEnabled(true);
                btnSalir.setEnabled(true);
                
                break;    
            
            case BORRAR:
                txt_descuento.setText(null);
                
               
                
                txt_descuento.setEnabled(false);
                txt_descuento.setEnabled(false);
                chk_min.setEnabled(false);
                chk_porcentaje.setEnabled(false);
                chk_dinero.setEnabled(false);
                spinner_cantidad.setEnabled(false);
                
                
                btnNuevo.setEnabled(true);
                btnEditar.setEnabled(false);
                btnGuardar.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnSalir.setEnabled(true);
                
                break;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_descuento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        chk_min = new javax.swing.JCheckBox();
        chk_porcentaje = new javax.swing.JCheckBox();
        spinner_cantidad = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        chk_dinero = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_descuento = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        jLabel1.setText("Empresa y/o nombre del descuento:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione tipo de descuento"));

        chk_min.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        chk_min.setText("Minutos");
        chk_min.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chk_minStateChanged(evt);
            }
        });
        chk_min.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chk_minMouseClicked(evt);
            }
        });

        chk_porcentaje.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        chk_porcentaje.setText("Porcentaje");
        chk_porcentaje.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chk_porcentajeStateChanged(evt);
            }
        });
        chk_porcentaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chk_porcentajeMouseClicked(evt);
            }
        });

        spinner_cantidad.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        spinner_cantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinner_cantidadStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        jLabel2.setText("Cantidad:");

        chk_dinero.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        chk_dinero.setText("Dinero");
        chk_dinero.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chk_dineroStateChanged(evt);
            }
        });
        chk_dinero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chk_dineroMouseClicked(evt);
            }
        });
        chk_dinero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_dineroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chk_dinero)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chk_min)
                            .addComponent(chk_porcentaje))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinner_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(chk_porcentaje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chk_min)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chk_dinero))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinner_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Descuentos existentes"));

        tabla_descuento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_descuento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_descuentoMouseClicked(evt);
            }
        });
        tabla_descuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabla_descuentoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_descuento);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnNuevo.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/borrar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/exit.png"))); // NOI18N
        btnSalir.setText("Cancel");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnNuevo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalir))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_descuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
      nuevo=1;
      spinner_cantidad.setValue(0);
      estado(Estado.NUEVO);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        estado(Estado.EDITAR);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        descuento_modelo_tabla modelo = (descuento_modelo_tabla) tabla_descuento.getModel();
        indice = tabla_descuento.getSelectedRow();
        if(indice>-1){
            descuento user = modelo.getElementAt(indice);
            modelo.eliminar_descuento(user);
        }
        estado(Estado.BORRAR);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        descuento_modelo_tabla modelo = (descuento_modelo_tabla) tabla_descuento.getModel();

        String nombre = txt_descuento.getText();
        double valor =0;
        int tipo =0;
        if(chk_porcentaje.isSelected()){
            tipo=1;
        }else if (chk_min.isSelected()){
             tipo=2;
        }else{
            tipo =3;
        }
        
        valor = (double)((int) spinner_cantidad.getValue());
            
        if(nuevo==1){
            descuento des = new descuento(0, nombre, tipo,  valor ,new java.util.Date());
            modelo.agregar_descuento(des);
            //Integer idUSUARIO, long DPI, String Nombre, String Apellidos, String Password, Integer fPARQUEO, Integer fRol, String parqueo, String rol
        } else {
            if (indice > -1) {
                descuento des = modelo.getElementAt(indice);
                des.setNombre_descuento(nombre);
                des.setTipo(tipo);
                des.setValor(valor);
                des.setFecha(new java.util.Date());

                modelo.modificar_descuento(des);
            }
        }
        estado(Estado.GUARDAR);

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        estado(Estado.INICIO);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void chk_porcentajeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chk_porcentajeMouseClicked
        // TODO add your handling code here:
        if(chk_porcentaje.isSelected()){
            chk_min.setSelected(false);
        }
    }//GEN-LAST:event_chk_porcentajeMouseClicked

    private void chk_minMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chk_minMouseClicked
        // TODO add your handling code here:
        if(chk_min.isSelected()){
            chk_porcentaje.setSelected(false);
        }
    }//GEN-LAST:event_chk_minMouseClicked

    private void spinner_cantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinner_cantidadStateChanged
        // TODO add your handling code here:
        try {
            double valor = Double.parseDouble(String.valueOf(spinner_cantidad.getValue()));
            if(valor<0){
                JOptionPane.showMessageDialog(this, "El valor debe ser mayor a 0","ERROR",0);
                spinner_cantidad.setValue(0);
            }else if ((valor >100&&chk_porcentaje.isSelected())) {
                JOptionPane.showMessageDialog(this, "El valor debe ser entre 0 a 100","ERROR",0);
                spinner_cantidad.setValue(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "El valor debe ser numerico","ERROR",0);
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_spinner_cantidadStateChanged

    private void tabla_descuentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_descuentoMouseClicked
        // TODO add your handling code here:
        mostrar_registro();
        estado(Estado.CLICK);
    }//GEN-LAST:event_tabla_descuentoMouseClicked

    private void chk_dineroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chk_dineroMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_dineroMouseClicked

    private void chk_dineroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_dineroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_dineroActionPerformed

    private void chk_porcentajeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chk_porcentajeStateChanged
        // TODO add your handling code here:
        if(chk_porcentaje.isSelected()){
            chk_dinero.setSelected(false);
            chk_min.setSelected(false);
        }
    }//GEN-LAST:event_chk_porcentajeStateChanged

    private void chk_minStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chk_minStateChanged
        // TODO add your handling code here:
        if(chk_min.isSelected()){
            chk_dinero.setSelected(false);
            chk_porcentaje.setSelected(false);
        }
    }//GEN-LAST:event_chk_minStateChanged

    private void chk_dineroStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chk_dineroStateChanged
        // TODO add your handling code here:
         if(chk_dinero.isSelected()){
            chk_min.setSelected(false);
            chk_porcentaje.setSelected(false);
        }
    }//GEN-LAST:event_chk_dineroStateChanged

    private void tabla_descuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla_descuentoKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_UP||evt.getKeyCode()== KeyEvent.VK_DOWN){
            mostrar_registro();
        }
    }//GEN-LAST:event_tabla_descuentoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox chk_dinero;
    private javax.swing.JCheckBox chk_min;
    private javax.swing.JCheckBox chk_porcentaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinner_cantidad;
    private javax.swing.JTable tabla_descuento;
    private javax.swing.JTextField txt_descuento;
    // End of variables declaration//GEN-END:variables
}
