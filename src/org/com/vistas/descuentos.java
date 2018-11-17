package org.com.vistas;

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
        chk_min.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chk_minMouseClicked(evt);
            }
        });

        chk_porcentaje.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        chk_porcentaje.setText("Porcentaje");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chk_min)
                    .addComponent(chk_porcentaje))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinner_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
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
                        .addComponent(chk_min))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinner_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
        int minutos =0;
        int porcentaje =0;
        if(chk_min.isSelected()){
            minutos=Integer.parseInt(spinner_cantidad.getValue().toString());
        }else{
             porcentaje=Integer.parseInt(spinner_cantidad.getValue().toString());
        }

        if(nuevo==1){
            descuento des = new descuento(0, nombre, porcentaje, new java.util.Date(), minutos);
            modelo.agregar_descuento(des);
            //Integer idUSUARIO, long DPI, String Nombre, String Apellidos, String Password, Integer fPARQUEO, Integer fRol, String parqueo, String rol
        } else {
            if (indice > -1) {
                descuento des = modelo.getElementAt(indice);
                des.setNombre_descuento(nombre);
                des.setPorcetaje(porcentaje);
                des.setMinutos_descuento(minutos);
                des.setFecha(new java.util.Date());

                modelo.modificar_descuento(des);
            }
        }
        estado(Estado.GUARDAR);

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        estado(Estado.INICIO);
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
            int valor = Integer.parseInt(spinner_cantidad.getValue().toString());
            if(valor<0 || valor >100){
                JOptionPane.showMessageDialog(this, "El valor debe ser entre 0 a 100","ERROR",0);
                spinner_cantidad.setValue(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "El valor debe ser numerico","ERROR",0);
        }
    }//GEN-LAST:event_spinner_cantidadStateChanged

    private void tabla_descuentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_descuentoMouseClicked
        // TODO add your handling code here:
        descuento_modelo_tabla modelo = (descuento_modelo_tabla) tabla_descuento.getModel();
        indice = tabla_descuento.getSelectedRow();
        if(indice>-1){
            descuento aux = modelo.getElementAt(indice);
            txt_descuento.setText(aux.getNombre_descuento());
            
            if(aux.getPorcetaje()!=0){
                spinner_cantidad.setValue(aux.getPorcetaje());
                chk_porcentaje.setSelected(true);
            }else{
                spinner_cantidad.setValue(aux.getMinutos_descuento());
                chk_min.setSelected(true);
            }
        }
        estado(Estado.CLICK);
    }//GEN-LAST:event_tabla_descuentoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
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
