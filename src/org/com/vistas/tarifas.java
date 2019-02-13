package org.com.vistas;

import java.sql.Time;
import java.util.LinkedList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import org.com.bens.parqueo;
import org.com.bens.tarifa;
import org.com.controler.parqueo_controller;
import org.com.controler.tarifa_controller;
import org.com.models.tarifa_modelo_tabla;

/**
 *
 * @author Jherson
 */
public class tarifas extends javax.swing.JInternalFrame {

    public tarifas() {
        initComponents();
        estado(Estado.INICIO);
        combo_parqueo.setModel(parqueo_controller.getCombo());
        tabla_tarifa.setModel(tarifa_controller.getTabla());
    }

    private enum Estado {
        INICIO, CLICK, RELEASE, NUEVO, EDITAR, GUARDAR, BORRAR
    };
    private int nuevo = -1;
    private int indice = -1;
  

    public void estado(Estado valor){
        switch(valor){
            
            case INICIO:
                txt_precio.setText(null);
                txt_media.setText(null);
                txt_precio.setEnabled(false);
                txt_media.setEnabled(false);
                chk_unica.setSelected(false);

                chk_1.setEnabled(false);
                chk_2.setEnabled(false);
                chk_3.setEnabled(false);
                chk_4.setEnabled(false);
                chk_5.setEnabled(false);
                chk_6.setEnabled(false);
                chk_7.setEnabled(false);
                
                chk_1.setSelected(false);
                chk_2.setSelected(false);
                chk_3.setSelected(false);
                chk_4.setSelected(false);
                chk_5.setSelected(false);
                chk_6.setSelected(false);
                chk_7.setSelected(false);
                
                
                btnNuevo.setEnabled(true);
                btnEditar.setEnabled(false);
                btnGuardar.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnSalir.setEnabled(true);
                
                combo_min_inicio.setEnabled(false);
                combo_min_fin.setEnabled(false);
                combo_hora_fin.setEnabled(false);
                combo_hora_inicio.setEnabled(false);
                combo_parqueo.setEnabled(false);
                
                
                break;
            
            case RELEASE:
            case CLICK:
                                
                txt_precio.setEnabled(false);
                txt_media.setEnabled(false);
                chk_unica.setEnabled(false);
                
                btnNuevo.setEnabled(true);
                btnEditar.setEnabled(true);
                btnGuardar.setEnabled(false);
                btnEliminar.setEnabled(true);
                btnSalir.setEnabled(true);
                
                combo_min_inicio.setEnabled(false);
                combo_min_fin.setEnabled(false);
                combo_hora_fin.setEnabled(false);
                combo_hora_inicio.setEnabled(false);
                combo_parqueo.setEnabled(false);
              
                 chk_1.setEnabled(false);
                chk_2.setEnabled(false);
                chk_3.setEnabled(false);
                chk_4.setEnabled(false);
                chk_5.setEnabled(false);
                chk_6.setEnabled(false);
                chk_7.setEnabled(false);
                
                
                break;
            
            case NUEVO:
                txt_precio.setText(null);
                txt_precio.setEnabled(true);
                txt_media.setText(null);
                txt_media.setEnabled(true);
                chk_unica.setEnabled(true);
                                           
                btnNuevo.setEnabled(false);
                btnEditar.setEnabled(false);
                btnGuardar.setEnabled(true);
                btnEliminar.setEnabled(false);
                btnSalir.setEnabled(true);
                
                
                chk_1.setEnabled(true);
                chk_2.setEnabled(true);
                chk_3.setEnabled(true);
                chk_4.setEnabled(true);
                chk_5.setEnabled(true);
                chk_6.setEnabled(true);
                chk_7.setEnabled(true);
                
                chk_1.setSelected(false);
                chk_2.setSelected(false);
                chk_3.setSelected(false);
                chk_4.setSelected(false);
                chk_5.setSelected(false);
                chk_6.setSelected(false);
                chk_7.setSelected(false);
                
                
                combo_min_inicio.setEnabled(true);
                combo_min_fin.setEnabled(true);
                combo_hora_fin.setEnabled(true);
                combo_hora_inicio.setEnabled(true);
                combo_parqueo.setEnabled(true);
              
                break;
            
            case GUARDAR:
                txt_precio.setText(null);
                
                txt_precio.setEnabled(false);
                txt_media.setText(null);
                txt_media.setEnabled(false);
                chk_unica.setEnabled(false);
                chk_unica.setSelected(false);
                
                btnNuevo.setEnabled(true);
                btnEditar.setEnabled(false);
                btnGuardar.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnSalir.setEnabled(true);
                nuevo =-1;
                
                combo_min_inicio.setEnabled(false);
                combo_min_fin.setEnabled(false);
                combo_hora_fin.setEnabled(false);
                combo_hora_inicio.setEnabled(false);
                combo_parqueo.setEnabled(false);
                
                
                chk_1.setEnabled(false);
                chk_2.setEnabled(false);
                chk_3.setEnabled(false);
                chk_4.setEnabled(false);
                chk_5.setEnabled(false);
                chk_6.setEnabled(false);
                chk_7.setEnabled(false);
                
                
                chk_1.setSelected(false);
                chk_2.setSelected(false);
                chk_3.setSelected(false);
                chk_4.setSelected(false);
                chk_5.setSelected(false);
                chk_6.setSelected(false);
                chk_7.setSelected(false);
                
                
                break;
            
            case EDITAR:
                nuevo =0;               
                txt_precio.setEnabled(true);
                txt_media.setEnabled(true);
                 chk_unica.setEnabled(true);
                
                
                btnNuevo.setEnabled(false);
                btnEditar.setEnabled(false);
                btnGuardar.setEnabled(true);
                btnEliminar.setEnabled(true);
                btnSalir.setEnabled(true);
                
                
                combo_min_inicio.setEnabled(true);
                combo_min_fin.setEnabled(true);
                combo_hora_fin.setEnabled(true);
                combo_hora_inicio.setEnabled(true);
                combo_parqueo.setEnabled(true);
               
                
                 chk_1.setEnabled(true);
                chk_2.setEnabled(true);
                chk_3.setEnabled(true);
                chk_4.setEnabled(true);
                chk_5.setEnabled(true);
                chk_6.setEnabled(true);
                chk_7.setEnabled(true);
                break;    
            
            case BORRAR:
                txt_precio.setText(null);
                txt_precio.setEnabled(false);
                txt_media.setText(null);
                txt_media.setEnabled(false);
                chk_unica.setEnabled(false);
                chk_unica.setSelected(false);
                
                btnNuevo.setEnabled(true);
                btnEditar.setEnabled(false);
                btnGuardar.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnSalir.setEnabled(true);
                
                combo_min_inicio.setEnabled(false);
                combo_min_fin.setEnabled(false);
                combo_hora_fin.setEnabled(false);
                combo_hora_inicio.setEnabled(false);
                combo_parqueo.setEnabled(false);
                
                
                 chk_1.setEnabled(false);
                chk_2.setEnabled(false);
                chk_3.setEnabled(false);
                chk_4.setEnabled(false);
                chk_5.setEnabled(false);
                chk_6.setEnabled(false);
                chk_7.setEnabled(false);
                break;
                
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txt_precio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_tarifa = new javax.swing.JTable();
        combo_min_inicio = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        combo_hora_inicio = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        combo_hora_fin = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        combo_min_fin = new javax.swing.JComboBox<>();
        combo_parqueo = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        txt_media = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        chk_unica = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        chk_7 = new javax.swing.JCheckBox();
        chk_6 = new javax.swing.JCheckBox();
        chk_5 = new javax.swing.JCheckBox();
        chk_4 = new javax.swing.JCheckBox();
        chk_3 = new javax.swing.JCheckBox();
        chk_2 = new javax.swing.JCheckBox();
        chk_1 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel1.setText("Precio único/Precio hora:");

        jLabel2.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel2.setText("Inicio Tarifa:");

        jLabel3.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel3.setText("Fin Tarifa:");

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

        tabla_tarifa.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_tarifa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_tarifaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_tarifa);

        combo_min_inicio.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        combo_min_inicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));

        jLabel11.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel11.setText("Minuto:");

        combo_hora_inicio.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        combo_hora_inicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "23", "24" }));

        jLabel10.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel10.setText("Hora:");

        jLabel8.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel8.setText("Hora:");

        combo_hora_fin.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        combo_hora_fin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "23", "24" }));

        jLabel12.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel12.setText("Minuto:");

        combo_min_fin.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        combo_min_fin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));

        combo_parqueo.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        combo_parqueo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel13.setText("Parqueo:");

        jLabel4.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel4.setText("Precio 1/2 hora:");

        chk_unica.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 16)); // NOI18N
        chk_unica.setText("Tarifa Unica");
        chk_unica.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chk_unicaStateChanged(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        chk_7.setBackground(new java.awt.Color(0, 204, 204));
        chk_7.setText("Domingo");

        chk_6.setBackground(new java.awt.Color(0, 204, 204));
        chk_6.setText("Sabado");

        chk_5.setBackground(new java.awt.Color(0, 204, 204));
        chk_5.setText("Viernes");

        chk_4.setBackground(new java.awt.Color(0, 204, 204));
        chk_4.setText("Jueves");

        chk_3.setBackground(new java.awt.Color(0, 204, 204));
        chk_3.setText("Miercoles");

        chk_2.setBackground(new java.awt.Color(0, 204, 204));
        chk_2.setText("Martes");

        chk_1.setBackground(new java.awt.Color(0, 204, 204));
        chk_1.setText("Lunes");

        jLabel5.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel5.setText("Dias que aplica:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chk_3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chk_4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chk_7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(chk_1)
                    .addComponent(chk_2)
                    .addComponent(chk_3)
                    .addComponent(chk_4)
                    .addComponent(chk_5)
                    .addComponent(chk_6)
                    .addComponent(chk_7))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1)
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_hora_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combo_min_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(combo_hora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel11)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(combo_min_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(combo_parqueo, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(449, 449, 449)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txt_media, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(chk_unica, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(269, 269, 269))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_parqueo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(chk_unica)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_media, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel12)
                        .addComponent(combo_hora_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(combo_min_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11)
                        .addComponent(combo_hora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(combo_min_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevo=1;
        estado(Estado.NUEVO);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        nuevo=0;
        estado(Estado.EDITAR);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        tarifa_modelo_tabla modelo = (tarifa_modelo_tabla)tabla_tarifa.getModel();
        indice = tabla_tarifa.getSelectedRow();
        if(indice>-1){
            tarifa tar = modelo.elementAt(indice);
            modelo.eliminar_tarifa(tar);
        }
        estado(Estado.BORRAR);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        tarifa_modelo_tabla modelo = (tarifa_modelo_tabla)tabla_tarifa.getModel();
        
        int fparqueo = ((parqueo)combo_parqueo.getSelectedItem()).getId_parqueo();
        String parqueo = combo_parqueo.getSelectedItem().toString();
                
        try {
            Double precio = Double.parseDouble(txt_precio.getText());
            Double precio_media = 0.0;
            if (!txt_media.getText().isEmpty())
                precio_media=Double.parseDouble(txt_media.getText());
            int tarifa_unica =0;
            if(chk_unica.isSelected())
                tarifa_unica=1;
            
            LinkedList<Integer> lista = new LinkedList<>();
          
            if (chk_1.isSelected())
                lista.add(1);
            if (chk_2.isSelected()) {
                lista.add(2);
            }
            if (chk_3.isSelected()) {
                lista.add(3);
            }
            if (chk_4.isSelected()) {
                lista.add(4);
            }
            if (chk_5.isSelected()) {
                lista.add(5);
            }
            if (chk_6.isSelected()) {
                lista.add(6);
            }
            if (chk_7.isSelected()) {
                lista.add(7);
            }
                        
            if(lista.isEmpty()){
                JOptionPane.showMessageDialog(this, "Debe seleccionar los dias de vigencia de la tarifa","ERROR",0);
                return;
            }

            if (precio > 0) {
                if (nuevo == 1) {
                    tarifa nueva = new tarifa(0, precio,precio_media,tarifa_unica, get_time_inicio(), get_time_fin(), fparqueo, parqueo);
                    nueva.setDias(lista);
                    modelo.agregar_tarifa(nueva);
                } else {
                    indice = tabla_tarifa.getSelectedRow();
                    if (indice > -1) {
                        tarifa nueva = modelo.elementAt(indice);
                        nueva.setPrecio(precio);
                        nueva.setHora_inicio_tarifa(get_time_inicio());
                        nueva.setHora_fin_tarifa(get_time_fin());
                        nueva.setfPARQUEO(fparqueo);
                        nueva.setParqueo(parqueo);
                        nueva.setMedia_hora(precio_media);
                        
                        nueva.setDias(lista);
                        
                        modelo.modificar_tarifa(nueva);
                    }
                }
                
            }
            estado(Estado.GUARDAR);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "El precio debe ser numerico y mayor a 0 ", "Panel de Usuarios", 0);
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tabla_tarifaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_tarifaMouseClicked
        // TODO add your handling code here:
        tarifa_modelo_tabla modelo = (tarifa_modelo_tabla)tabla_tarifa.getModel();
        
        indice = tabla_tarifa.getSelectedRow();
        if (indice > -1) {
            tarifa tar = modelo.elementAt(indice);
            set_combo_parqueo(tar.getfPARQUEO());
            set_horario_inicio(tar.getHora_inicio_tarifa());
            set_horario_fin(tar.getHora_fin_tarifa());
            
            txt_precio.setText(String.valueOf(tar.getPrecio()));
            txt_media.setText(String.valueOf(tar.getMedia_hora()));
            
            if(tar.getTarifa_unica()==1){
                chk_unica.setSelected(true);
            }else
                chk_unica.setSelected(false);
            
            for (int x : tar.getDias()) {
                switch (x) {
                    case 1:
                        chk_1.setSelected(true);
                        break;
                    case 2:
                        chk_2.setSelected(true);
                        break;
                    case 3:
                        chk_3.setSelected(true);
                        break;
                    case 4:
                        chk_4.setSelected(true);
                        break;
                    case 5:
                        chk_5.setSelected(true);
                        break;
                    case 6:
                        chk_6.setSelected(true);
                        break;
                    case 7:
                        chk_7.setSelected(true);
                        break;
                }
            }
            
            estado(Estado.CLICK);
        }

    }//GEN-LAST:event_tabla_tarifaMouseClicked

    private void chk_unicaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chk_unicaStateChanged
        // TODO add your handling code here:
        if (nuevo == 0 || nuevo == 1) {
            if (chk_unica.isSelected()) {
                txt_media.setEnabled(false);
            } else {
                txt_media.setEnabled(true);
            }
        }
        
                    
    }//GEN-LAST:event_chk_unicaStateChanged

    
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
    
    
    private void set_combo_parqueo(Integer id) {
        for (int i = 0; i < combo_parqueo.getItemCount(); i++) {
            parqueo aux = ((parqueo) combo_parqueo.getItemAt(i));
            if (aux.getId_parqueo()== id) {
                combo_parqueo.setSelectedItem(aux);
            }
        }
    }
    
    
    private void set_horario_inicio(Time hora_inicio) {
        Integer hora = hora_inicio.getHours();
        Integer mins = hora_inicio.getMinutes();

        for (int i = 0; i < combo_hora_inicio.getItemCount(); i++) {
            Integer aux = Integer.parseInt(combo_hora_inicio.getItemAt(i));
            if (aux == hora) {
                combo_hora_inicio.setSelectedIndex(i);
            }
        }

        for (int i = 0; i < combo_min_inicio.getItemCount(); i++) {
            Integer aux = Integer.parseInt(combo_min_inicio.getItemAt(i));
            if (aux == mins) {
                combo_min_inicio.setSelectedIndex(i);
            }
        }
    }

    private void set_horario_fin(Time hora_fin) {
        Integer hora = hora_fin.getHours();
        Integer mins = hora_fin.getMinutes();

        for (int i = 0; i < combo_hora_fin.getItemCount(); i++) {
            Integer aux = Integer.parseInt(combo_hora_fin.getItemAt(i));
            if (aux == hora) {
                combo_hora_fin.setSelectedIndex(i);
            }
        }

        for (int i = 0; i < combo_min_fin.getItemCount(); i++) {
            Integer aux = Integer.parseInt(combo_min_fin.getItemAt(i));
            if (aux == mins) {
                combo_min_fin.setSelectedIndex(i);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox chk_1;
    private javax.swing.JCheckBox chk_2;
    private javax.swing.JCheckBox chk_3;
    private javax.swing.JCheckBox chk_4;
    private javax.swing.JCheckBox chk_5;
    private javax.swing.JCheckBox chk_6;
    private javax.swing.JCheckBox chk_7;
    private javax.swing.JCheckBox chk_unica;
    private javax.swing.JComboBox<String> combo_hora_fin;
    private javax.swing.JComboBox<String> combo_hora_inicio;
    private javax.swing.JComboBox<String> combo_min_fin;
    private javax.swing.JComboBox<String> combo_min_inicio;
    private javax.swing.JComboBox combo_parqueo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_tarifa;
    private javax.swing.JTextField txt_media;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}
