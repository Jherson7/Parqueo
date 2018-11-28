package org.com.vistas;

import java.awt.event.KeyEvent;
import java.sql.Time;
import org.com.bens.parqueo;
import org.com.controler.parqueo_controller;
import org.com.models.parqueo_table_model;

/**
 *
 * @author Jherson
 */
public class parqueos extends javax.swing.JInternalFrame {
    private enum Estado {INICIO, CLICK, RELEASE, NUEVO, EDITAR, GUARDAR, BORRAR};
    private int nuevo=0;
    private int indice = -1;
    
    
    public parqueos() {
        initComponents();
        tabla_parqueos.setModel(parqueo_controller.getTabla());
        estado(Estado.INICIO);
    }

    public void estado(Estado valor){
        switch(valor){
            
            case INICIO:
                txt_parqueo.setText(null);
                txt_direccion.setText(null);
               
                                
                txt_parqueo.setEnabled(false);
                txt_direccion.setEnabled(false);
               
                                
                btnNuevo.setEnabled(true);
                btnEditar.setEnabled(false);
                btnGuardar.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnSalir.setEnabled(true);
                
                break;
            
            case RELEASE:
            case CLICK:
                                
                txt_parqueo.setEnabled(false);
                txt_direccion.setEnabled(false);
               
                                
                btnNuevo.setEnabled(true);
                btnEditar.setEnabled(true);
                btnGuardar.setEnabled(false);
                btnEliminar.setEnabled(true);
                btnSalir.setEnabled(true);
                
                break;
            
            case NUEVO:
                txt_parqueo.setText(null);
                txt_direccion.setText(null);
               
                txt_parqueo.setEnabled(true);
                txt_direccion.setEnabled(true);
               
                                           
                btnNuevo.setEnabled(false);
                btnEditar.setEnabled(false);
                btnGuardar.setEnabled(true);
                btnEliminar.setEnabled(false);
                btnSalir.setEnabled(true);
                
                break;
            
            case GUARDAR:
                txt_parqueo.setText(null);
                txt_direccion.setText(null);
               
                
                txt_parqueo.setEnabled(false);
                txt_direccion.setEnabled(false);
                
                
                btnNuevo.setEnabled(true);
                btnEditar.setEnabled(false);
                btnGuardar.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnSalir.setEnabled(true);
                nuevo =0;
                break;
            
            case EDITAR:
                nuevo =0;               
                txt_parqueo.setEnabled(true);
                txt_direccion.setEnabled(true);
                
                
                btnNuevo.setEnabled(false);
                btnEditar.setEnabled(false);
                btnGuardar.setEnabled(true);
                btnEliminar.setEnabled(true);
                btnSalir.setEnabled(true);
                
                break;    
            
            case BORRAR:
                txt_parqueo.setText(null);
                txt_direccion.setText(null);
               
                
                txt_parqueo.setEnabled(false);
                txt_direccion.setEnabled(false);
                
                
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

        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        txt_parqueo = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_parqueos = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        combo_hora_inicio = new javax.swing.JComboBox();
        combo_min_inicio = new javax.swing.JComboBox();
        combo_min_fin = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        combo_hora_fin = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        label1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        label1.setText("Nombre Parqueo");

        label2.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        label2.setText("Direccion:");

        tabla_parqueos.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_parqueos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_parqueosMouseClicked(evt);
            }
        });
        tabla_parqueos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabla_parqueosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_parqueos);

        btnNuevo.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 16)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 16)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 16)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/borrar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 16)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 16)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/exit.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel5.setText("Minuto:");

        combo_hora_inicio.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        combo_hora_inicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "23", "24" }));

        combo_min_inicio.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        combo_min_inicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));

        combo_min_fin.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        combo_min_fin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));

        jLabel6.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel6.setText("Minuto:");

        combo_hora_fin.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        combo_hora_fin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "23", "24" }));

        jLabel7.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel7.setText("Hora:");

        jLabel1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel1.setText("Horario de Inicio del Parqueo:");

        jLabel2.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel2.setText("Horario de Finalizacion:");

        jLabel3.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel3.setText("Hora:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_parqueo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(txt_direccion))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(combo_hora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(combo_min_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabel2)
                                .addGap(67, 67, 67))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_hora_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(combo_min_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_parqueo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(combo_hora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_min_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(combo_hora_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_min_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        label1.getAccessibleContext().setAccessibleName("Nombre Parqueo:");

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
        parqueo_table_model modelo = (parqueo_table_model)tabla_parqueos.getModel();
        indice = tabla_parqueos.getSelectedRow();
        if(indice>-1){
            parqueo par = modelo.elementAt(indice);
            modelo.eliminar_parqueo(par);
           // actualizarTabla();
        }
        estado(Estado.BORRAR);
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
     parqueo_table_model modelo = (parqueo_table_model)tabla_parqueos.getModel();
     indice = tabla_parqueos.getSelectedRow();
     
     String parqueo = txt_parqueo.getText();
     String dir     = txt_direccion.getText();
         
         if(!dir.isEmpty()&&!parqueo.isEmpty()){
             if(nuevo==1){
                 parqueo par = new parqueo(0, parqueo, dir);
                 //horario
                 modelo.agregar_parqueo(par);
             }else{
                 if(indice>-1){
                    parqueo par =modelo.elementAt(indice);
                    par.setNombre_parqueo(parqueo);
                    par.setDireccion(dir);
                    
                    modelo.modificar_parqueo(par);
                 }
             }
             estado(Estado.GUARDAR);
         }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tabla_parqueosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_parqueosMouseClicked
        // TODO add your handling code here:
        parqueo_table_model modelo = (parqueo_table_model)tabla_parqueos.getModel();
        indice = tabla_parqueos.getSelectedRow();
        if(indice!=-1){
            parqueo par = modelo.elementAt(indice);
            txt_parqueo.setText(par.getNombre_parqueo());
            txt_direccion.setText(par.getDireccion());
            estado(Estado.CLICK);
        }
    }//GEN-LAST:event_tabla_parqueosMouseClicked

    private void tabla_parqueosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla_parqueosKeyReleased
        // TODO add your handling code here:
         parqueo_table_model modelo = (parqueo_table_model)tabla_parqueos.getModel();

        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            indice = tabla_parqueos.getSelectedRow();
            if (indice != -1) {
                parqueo par = modelo.elementAt(indice);
                txt_parqueo.setText(par.getNombre_parqueo());
                txt_direccion.setText(par.getDireccion());
                estado(Estado.RELEASE);
            }
        }
    }//GEN-LAST:event_tabla_parqueosKeyReleased

    private Time get_time_inicio(){
        Integer hora_inicio = Integer.parseInt(combo_hora_inicio.getSelectedItem().toString());
        Integer minutos_ini = Integer.parseInt(combo_min_inicio.getSelectedItem().toString());
        
        Time time = new Time(hora_inicio, minutos_ini, 0);
        System.out.println(time);
        
        return time;
    }
    
    private Time get_time_fin(){
        Integer hora_fin = Integer.parseInt(combo_hora_fin.getSelectedItem().toString());
        Integer minutos_fin = Integer.parseInt(combo_min_fin.getSelectedItem().toString());
        
        Time time = new Time(hora_fin, minutos_fin, 0);
        System.out.println(time);
        
        return time;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox combo_hora_fin;
    private javax.swing.JComboBox combo_hora_inicio;
    private javax.swing.JComboBox combo_min_fin;
    private javax.swing.JComboBox combo_min_inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JTable tabla_parqueos;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_parqueo;
    // End of variables declaration//GEN-END:variables
}
