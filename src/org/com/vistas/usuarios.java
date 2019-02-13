package org.com.vistas;

import java.sql.Time;
import org.com.bens.horario;
import org.com.bens.parqueo;
import org.com.bens.rol;
import org.com.bens.usuario;
import org.com.controler.parqueo_controller;
import org.com.controler.rol_controller;
import org.com.controler.usuario_controller;
import org.com.models.usuario_modelo_tabla;

/**
 *
 * @author Jherson
 */
public class usuarios extends javax.swing.JInternalFrame {

    
    public usuarios() {
        initComponents();
        tabla_usuarios.setModel(usuario_controller.getTabla());
        combo_rol.setModel(rol_controller.getComboRol());
        combo_parqueo.setModel(parqueo_controller.getCombo());
        estado(Estado.INICIO);
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

    private enum Estado {
        INICIO, CLICK, RELEASE, NUEVO, EDITAR, GUARDAR, BORRAR
    };
    private int nuevo = 0;
    private int indice = -1;
  

    public void estado(Estado valor){
        switch(valor){
            
            case INICIO:
                txt_dpi.setText(null);
                txt_nombre.setText(null);
                txt_apellidos.setText(null);
                txt_password.setText(null);
                txt_usuario.setText(null);
                
                txt_dpi.setEnabled(false);
                txt_nombre.setEnabled(false);
                txt_apellidos.setEnabled(false);
                txt_password.setEnabled(false);
                txt_usuario.setEnabled(false);
                                
                btnNuevo.setEnabled(true);
                btnEditar.setEnabled(false);
                btnGuardar.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnSalir.setEnabled(true);
                
                combo_hora_fin.setEnabled(false);
                combo_min_fin.setEnabled(false);
                combo_min_inicio.setEnabled(false);
                combo_hora_inicio.setEnabled(false);
                
                combo_parqueo.setEnabled(false);
                combo_rol.setEnabled(false);
                
                
                break;
            
            case RELEASE:
            case CLICK:
                                
                txt_dpi.setEnabled(false);
                txt_nombre.setEnabled(false);
                txt_apellidos.setEnabled(false);
                txt_password.setEnabled(false);
                txt_usuario.setEnabled(false);      
                
                
                btnNuevo.setEnabled(true);
                btnEditar.setEnabled(true);
                btnGuardar.setEnabled(false);
                btnEliminar.setEnabled(true);
                btnSalir.setEnabled(true);
                
                combo_hora_fin.setEnabled(false);
                combo_min_fin.setEnabled(false);
                combo_min_inicio.setEnabled(false);
                combo_hora_inicio.setEnabled(false);
                
                combo_parqueo.setEnabled(false);
                combo_rol.setEnabled(false);
                
                break;
            
            case NUEVO:
                txt_dpi.setText(null);
                txt_nombre.setText(null);
                txt_apellidos.setText(null);
                txt_password.setText(null);
                txt_usuario.setText(null);
                                
                txt_dpi.setEnabled(true);
                txt_nombre.setEnabled(true);
                txt_apellidos.setEnabled(true);
                txt_password.setEnabled(true);
                txt_usuario.setEnabled(true);
                
                btnNuevo.setEnabled(false);
                btnEditar.setEnabled(false);
                btnGuardar.setEnabled(true);
                btnEliminar.setEnabled(false);
                btnSalir.setEnabled(true);
                
                
                combo_hora_fin.setEnabled(true);
                combo_min_fin.setEnabled(true);
                combo_min_inicio.setEnabled(true);
                combo_hora_inicio.setEnabled(true);
                
                combo_parqueo.setEnabled(true);
                combo_rol.setEnabled(true);
                
                break;
            
            case GUARDAR:
                txt_dpi.setText(null);
                txt_nombre.setText(null);
                txt_apellidos.setText(null);
                txt_password.setText(null);
                txt_usuario.setText(null);
                
                txt_dpi.setEnabled(false);
                txt_nombre.setEnabled(false);
                txt_apellidos.setEnabled(false);
                txt_password.setEnabled(false);
                txt_usuario.setEnabled(false);
                
                btnNuevo.setEnabled(true);
                btnEditar.setEnabled(false);
                btnGuardar.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnSalir.setEnabled(true);
                nuevo =0;
                
                combo_hora_fin.setEnabled(false);
                combo_min_fin.setEnabled(false);
                combo_min_inicio.setEnabled(false);
                combo_hora_inicio.setEnabled(false);
                
                combo_parqueo.setEnabled(false);
                combo_rol.setEnabled(false);
                
                
                break;
            
            case EDITAR:
                nuevo =0;               
                txt_dpi.setEnabled(true);
                txt_nombre.setEnabled(true);
                txt_apellidos.setEnabled(true);
                txt_password.setEnabled(true);
                txt_usuario.setEnabled(true);
                
                btnNuevo.setEnabled(false);
                btnEditar.setEnabled(false);
                btnGuardar.setEnabled(true);
                btnEliminar.setEnabled(true);
                btnSalir.setEnabled(true);
                
                
                combo_hora_fin.setEnabled(true);
                combo_min_fin.setEnabled(true);
                combo_min_inicio.setEnabled(true);
                combo_hora_inicio.setEnabled(true);
                
                combo_parqueo.setEnabled(true);
                combo_rol.setEnabled(true);
                
                
                break;    
            
            case BORRAR:
                txt_dpi.setText(null);
                txt_nombre.setText(null);
                txt_apellidos.setText(null);
                txt_password.setText(null);
                txt_usuario.setText(null);
                
                txt_dpi.setEnabled(false);
                txt_nombre.setEnabled(false);
                txt_apellidos.setEnabled(false);
                txt_password.setEnabled(false);
                txt_usuario.setEnabled(true);
                
                btnNuevo.setEnabled(true);
                btnEditar.setEnabled(false);
                btnGuardar.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnSalir.setEnabled(true);
                
                combo_hora_fin.setEnabled(false);
                combo_min_fin.setEnabled(false);
                combo_min_inicio.setEnabled(false);
                combo_hora_inicio.setEnabled(false);
                
                combo_parqueo.setEnabled(false);
                combo_rol.setEnabled(false);
                
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        combo_hora_fin = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        combo_hora_inicio = new javax.swing.JComboBox<>();
        combo_min_inicio = new javax.swing.JComboBox<>();
        combo_min_fin = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_usuarios = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        combo_rol = new javax.swing.JComboBox();
        txt_apellidos = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_dpi = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        combo_parqueo = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Horario Laboral", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("MS Reference Sans Serif", 0, 12))); // NOI18N

        combo_hora_fin.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        combo_hora_fin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "23", "00" }));

        jLabel8.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel8.setText("Hora:");

        jLabel3.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel3.setText("Horario de Inicio:");

        jLabel9.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel9.setText("Horario de Finalizacion:");

        jLabel10.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel10.setText("Hora:");

        jLabel11.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel11.setText("Minuto:");

        combo_hora_inicio.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        combo_hora_inicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "23", "00" }));

        combo_min_inicio.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        combo_min_inicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));

        combo_min_fin.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        combo_min_fin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));

        jLabel12.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel12.setText("Minuto:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_hora_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combo_min_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(combo_hora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(combo_min_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(combo_hora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_min_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(combo_hora_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_min_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuarios Registrados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("MS Reference Sans Serif", 0, 12))); // NOI18N

        tabla_usuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_usuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_usuarios);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Campos Requeridos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("MS Reference Sans Serif", 0, 12))); // NOI18N

        combo_rol.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        combo_rol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txt_password.setText("jPasswordField1");

        jLabel1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel1.setText("Nombres:");

        jLabel2.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel2.setText("Apellidos:");

        jLabel4.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel4.setText("DPI:");

        jLabel5.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel5.setText("Contraseña:");

        jLabel6.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel6.setText("Rol:");

        jLabel13.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel13.setText("Parqueo:");

        combo_parqueo.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        combo_parqueo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel14.setText("Usuario:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel13))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(combo_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 187, Short.MAX_VALUE))
                            .addComponent(combo_parqueo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                            .addComponent(txt_dpi, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                            .addComponent(txt_password)
                            .addComponent(txt_apellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                            .addComponent(txt_usuario)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_dpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(txt_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combo_rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(combo_parqueo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(235, 235, 235))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
       usuario_modelo_tabla modelo = (usuario_modelo_tabla) tabla_usuarios.getModel();
        indice = tabla_usuarios.getSelectedRow();
        if(indice>-1){
            usuario user = modelo.elementAt(indice);
            modelo.eliminar_usuario(user);
        }
        estado(Estado.BORRAR);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        usuario_modelo_tabla modelo = (usuario_modelo_tabla) tabla_usuarios.getModel();

        long dpi            = Long.parseLong(txt_dpi.getText());
        String usuario      = txt_usuario.getText();
        String nombre       = txt_nombre.getText();
        String apellidos    = txt_apellidos.getText();
        String pass         = txt_password.getText();
        Integer id_rol      = ((rol)combo_rol.getSelectedItem()).getId_rol();
        Integer id_parqueo  = ((parqueo)combo_parqueo.getSelectedItem()).getId_parqueo();
        
        if(nuevo==1){
            usuario nuevo = new usuario(0, usuario,dpi, nombre, apellidos, pass, id_parqueo, id_rol,combo_parqueo.getSelectedItem().toString() , combo_rol.getSelectedItem().toString());//
            horario horario_lab = new horario(get_time_inicio(), get_time_fin());
            nuevo.setHorario_laboral(horario_lab);
            modelo.agregar_usuario(nuevo);
            //Integer idUSUARIO, long DPI, String Nombre, String Apellidos, String Password, Integer fPARQUEO, Integer fRol, String parqueo, String rol
        } else {
            if (indice > -1) {
                usuario user = modelo.elementAt(indice);
                user.setDPI(dpi);
                user.setUsuario(usuario);
                user.setNombre(nombre);
                user. setApellidos(apellidos);
                user.setPassword(pass);
                user.setfRol(id_rol);
                user.setfPARQUEO(id_parqueo);
                
                user.setRol(combo_rol.getSelectedItem().toString());
                user.setParqueo(combo_parqueo.getSelectedItem().toString());

                
                //seteando el horario laboral
                user.getHorario_laboral().setHora_inicio(get_time_inicio());
                user.getHorario_laboral().setHora_fin(get_time_fin());
                
                modelo.modificar_usuario(user);
            }
        }
        estado(Estado.GUARDAR);
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    
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
    
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed
    
    private void set_combo_rol(Integer id) {
        for (int i = 0; i < combo_rol.getItemCount(); i++) {
            rol aux = ((rol) combo_rol.getItemAt(i));
            if (aux.getId_rol() == id) {
                combo_rol.setSelectedItem(aux);
            }
        }
    }
    
     private void set_combo_parqueo(Integer id) {
        for (int i = 0; i < combo_parqueo.getItemCount(); i++) {
            parqueo aux = ((parqueo) combo_parqueo.getItemAt(i));
            if (aux.getId_parqueo()== id) {
                combo_parqueo.setSelectedItem(aux);
            }
        }
    }
    
    private void tabla_usuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_usuariosMouseClicked
        // TODO add your handling code here:
        usuario_modelo_tabla modelo = (usuario_modelo_tabla)tabla_usuarios.getModel();
        indice = tabla_usuarios.getSelectedRow();
        if(indice!=-1){
            usuario usu = modelo.elementAt(indice);
            
            txt_dpi.setText(String.valueOf(usu.getDPI()));
            txt_nombre.setText(usu.getNombre());
            txt_apellidos.setText(usu.getApellidos());
            txt_password.setText(usu.getPassword());
            txt_usuario.setText(usu.getUsuario());
            
            set_combo_rol(usu.getfRol());
            set_combo_parqueo(usu.getfPARQUEO());
            
            set_horario_inicio(usu.getHorario_laboral().getHora_inicio());
            set_horario_fin(usu.getHorario_laboral().getHora_fin());
            estado(Estado.CLICK);
        }
    }//GEN-LAST:event_tabla_usuariosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> combo_hora_fin;
    private javax.swing.JComboBox<String> combo_hora_inicio;
    private javax.swing.JComboBox<String> combo_min_fin;
    private javax.swing.JComboBox<String> combo_min_inicio;
    private javax.swing.JComboBox combo_parqueo;
    private javax.swing.JComboBox combo_rol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_usuarios;
    private javax.swing.JTextField txt_apellidos;
    private javax.swing.JTextField txt_dpi;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
