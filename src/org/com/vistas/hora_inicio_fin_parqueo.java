package org.com.vistas;

import java.sql.Time;
import org.com.bens.horario_parqueo;
import org.com.db.horario_db;
import org.com.logica.Controlador;

/**
 *
 * @author Jherson
 */
public class hora_inicio_fin_parqueo extends javax.swing.JInternalFrame {

    horario_parqueo horario;
    horario_db horariodb;
    
    
    public hora_inicio_fin_parqueo() {
        initComponents();
        horariodb = new horario_db();
        setear_horario();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        combo_min_inicio = new javax.swing.JComboBox();
        combo_min_fin = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        combo_hora_fin = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        combo_hora_inicio = new javax.swing.JComboBox();
        btn_guardar = new javax.swing.JButton();

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

        jLabel5.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel5.setText("Minuto:");

        combo_hora_inicio.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        combo_hora_inicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "23", "24" }));

        btn_guardar.setText("GUARDAR");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_hora_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(combo_min_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_hora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(combo_min_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(combo_hora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_min_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(combo_hora_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_min_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
        Time hora_inicio = get_time_inicio();
        Time hora_fin = get_time_fin();
        
        if(horario==null){
            horario = new horario_parqueo(1, hora_inicio, hora_fin, Controlador.getParqueo().getId_parqueo());
            horariodb.guardar_horario_parqueo(horario);
        }else{
            horario.setHora_inicio(hora_inicio);
            horario.setHora_fin(hora_inicio);
            horariodb.modificar_horario_parqueo(horario);
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void set_horario_inicio(Time hora_inicio) {
        Integer hora = hora_inicio.getHours();
        Integer mins = hora_inicio.getMinutes();

        for (int i = 0; i < combo_hora_inicio.getItemCount(); i++) {
            Integer aux = Integer.parseInt((String) combo_hora_inicio.getItemAt(i));
            if (aux == hora) {
                combo_hora_inicio.setSelectedIndex(i);
            }
        }

        for (int i = 0; i < combo_min_inicio.getItemCount(); i++) {
            Integer aux = Integer.parseInt((String) combo_min_inicio.getItemAt(i));
            if (aux == mins) {
                combo_min_inicio.setSelectedIndex(i);
            }
        }
    }

    private void set_horario_fin(Time hora_fin) {
        Integer hora = hora_fin.getHours();
        Integer mins = hora_fin.getMinutes();

        for (int i = 0; i < combo_hora_fin.getItemCount(); i++) {
            Integer aux = Integer.parseInt((String) combo_hora_fin.getItemAt(i));
            if (aux == hora) {
                combo_hora_fin.setSelectedIndex(i);
            }
        }

        for (int i = 0; i < combo_min_fin.getItemCount(); i++) {
            Integer aux = Integer.parseInt((String) combo_min_fin.getItemAt(i));
            if (aux == mins) {
                combo_min_fin.setSelectedIndex(i);
            }
        }
    }

    
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
    private javax.swing.JButton btn_guardar;
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
    // End of variables declaration//GEN-END:variables

    private void setear_horario() {
        horariodb = new horario_db();
        horario = horariodb.get_horario_parqueo();
        if(horario!=null){
            set_horario_inicio(horario.getHora_inicio());
            set_horario_fin(horario.getHora_fin());
        }
    }
}
