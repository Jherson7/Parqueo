package org.com.vistas;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import org.com.Serial.impresion_de_ticket;
import org.com.logica.Controlador;

/**
 *
 * @author Jherson
 */
public class Principal extends javax.swing.JFrame {
    
    ImageIcon img= new ImageIcon("src/org/com/pictures/aparcamiento.png");
    
    public Principal() {
        
            
    }

    Principal(Login aThis) {
        initComponents();
        this.setIconImage(img.getImage());
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        Controlador.iniciar_programa();
        impresion_de_ticket.obtener_parametros_del_parqueo();
       
        if (Controlador.getUsuarioActual().getfRol()!=1){
            menu_administrador.setVisible(false);
            menu_reporte.setVisible(false);
        }
        aThis.dispose();
    }

      public void mostrarVentanasInternas(JInternalFrame frame,String nombre){
        frame.setVisible(true);
        frame.setTitle(nombre);
        frame.setIconifiable(true);
        frame.setClosable(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        
        Controlador.setPrincipal(this);
        jDesktopPane1.add(frame);
        frame.moveToFront();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menu_usuairo = new javax.swing.JMenu();
        menu_apertura = new javax.swing.JMenuItem();
        menu_cierre = new javax.swing.JMenuItem();
        menu_cobro = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        menu_reporte = new javax.swing.JMenu();
        menu_fecha = new javax.swing.JMenuItem();
        menu_reporte_fecha_hora = new javax.swing.JMenuItem();
        menu_reporte_tiempo_promedio = new javax.swing.JMenuItem();
        ganancia_turno = new javax.swing.JMenuItem();
        tickets_pendientes = new javax.swing.JMenuItem();
        menu_administrador = new javax.swing.JMenu();
        menu_parqueo = new javax.swing.JMenuItem();
        menu_usuario = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        menu_descuentos = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 815, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/servidor.png"))); // NOI18N
        jMenu1.setText("Archivo");
        jMenu1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/logout.png"))); // NOI18N
        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/bloquear.png"))); // NOI18N
        jMenuItem2.setText("Cerrar Sesion");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        menu_usuairo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/usuarios.png"))); // NOI18N
        menu_usuairo.setText("Usuario");
        menu_usuairo.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N

        menu_apertura.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        menu_apertura.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        menu_apertura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/abrir_turno.png"))); // NOI18N
        menu_apertura.setText("Aperturar Turno");
        menu_apertura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_aperturaActionPerformed(evt);
            }
        });
        menu_usuairo.add(menu_apertura);

        menu_cierre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menu_cierre.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        menu_cierre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/cerrar_turno.png"))); // NOI18N
        menu_cierre.setText("Cerrar Turno");
        menu_cierre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_cierreActionPerformed(evt);
            }
        });
        menu_usuairo.add(menu_cierre);

        jMenuBar1.add(menu_usuairo);

        menu_cobro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/lucro.png"))); // NOI18N
        menu_cobro.setText("Cobro");
        menu_cobro.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/descuento.png"))); // NOI18N
        jMenuItem5.setText("Cobrar Ticket");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menu_cobro.add(jMenuItem5);

        jMenuBar1.add(menu_cobro);

        menu_reporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/diagrama.png"))); // NOI18N
        menu_reporte.setText("Reportes");
        menu_reporte.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N

        menu_fecha.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        menu_fecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/calendario.png"))); // NOI18N
        menu_fecha.setText("Ingresos por fecha");
        menu_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_fechaActionPerformed(evt);
            }
        });
        menu_reporte.add(menu_fecha);

        menu_reporte_fecha_hora.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        menu_reporte_fecha_hora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/reloj.png"))); // NOI18N
        menu_reporte_fecha_hora.setText("Ingresos por fecha y hora");
        menu_reporte_fecha_hora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_reporte_fecha_horaActionPerformed(evt);
            }
        });
        menu_reporte.add(menu_reporte_fecha_hora);

        menu_reporte_tiempo_promedio.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        menu_reporte_tiempo_promedio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/aparcamiento.png"))); // NOI18N
        menu_reporte_tiempo_promedio.setText("Tiempo promedio de vehiculos");
        menu_reporte_tiempo_promedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_reporte_tiempo_promedioActionPerformed(evt);
            }
        });
        menu_reporte.add(menu_reporte_tiempo_promedio);

        ganancia_turno.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        ganancia_turno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/analitica.png"))); // NOI18N
        ganancia_turno.setText("Ganancia por turnos");
        ganancia_turno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ganancia_turnoActionPerformed(evt);
            }
        });
        menu_reporte.add(ganancia_turno);

        tickets_pendientes.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        tickets_pendientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/pendiente.png"))); // NOI18N
        tickets_pendientes.setText("Tickets pendientes de cobro");
        tickets_pendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tickets_pendientesActionPerformed(evt);
            }
        });
        menu_reporte.add(tickets_pendientes);

        jMenuBar1.add(menu_reporte);

        menu_administrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/bloqueado.png"))); // NOI18N
        menu_administrador.setText("Administrador");
        menu_administrador.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N

        menu_parqueo.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        menu_parqueo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/garaje16.png"))); // NOI18N
        menu_parqueo.setText("Parqueos");
        menu_parqueo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_parqueoActionPerformed(evt);
            }
        });
        menu_administrador.add(menu_parqueo);

        menu_usuario.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        menu_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/editar_usuario.png"))); // NOI18N
        menu_usuario.setText("Usuarios");
        menu_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_usuarioActionPerformed(evt);
            }
        });
        menu_administrador.add(menu_usuario);

        jMenuItem10.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/tarifa.png"))); // NOI18N
        jMenuItem10.setText("Tarifas");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        menu_administrador.add(jMenuItem10);

        menu_descuentos.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        menu_descuentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/descuento16.png"))); // NOI18N
        menu_descuentos.setText("Descuentos");
        menu_descuentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_descuentosActionPerformed(evt);
            }
        });
        menu_administrador.add(menu_descuentos);

        jMenuBar1.add(menu_administrador);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/com/pictures/help.png"))); // NOI18N
        jMenu2.setText("Ayuda");
        jMenu2.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu_aperturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_aperturaActionPerformed
        // TODO add your handling code here:
        mostrarVentanasInternas(new apertura_turno(), "Aperturar Turno");
    }//GEN-LAST:event_menu_aperturaActionPerformed

    private void menu_cierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_cierreActionPerformed
        // TODO add your handling code here:
        mostrarVentanasInternas(new cerrar_turno(), "Cerrar Turno");
    }//GEN-LAST:event_menu_cierreActionPerformed

    private void menu_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_fechaActionPerformed
        // TODO add your handling code here:
        mostrarVentanasInternas(new reporte_por_fecha(), "Reporte por Fechas");
    }//GEN-LAST:event_menu_fechaActionPerformed

    private void menu_reporte_fecha_horaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_reporte_fecha_horaActionPerformed
        // TODO add your handling code here:
        mostrarVentanasInternas(new reporte_fecha_hora(), "Reporte Fecha y Hora");
    }//GEN-LAST:event_menu_reporte_fecha_horaActionPerformed

    private void menu_reporte_tiempo_promedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_reporte_tiempo_promedioActionPerformed
        // TODO add your handling code here:
        mostrarVentanasInternas(new reporte_promedio_vehiculos(), "Reporte Estadia de Vehiculos");
    }//GEN-LAST:event_menu_reporte_tiempo_promedioActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        //impresion_de_ticket.insertar_y_obtener_codigo();
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private static String centrar_texto(String mensaje) {
        String arreglo[]=mensaje.split("\n");
        String res="";
        for(String r:arreglo){
            int tam=r.length();
            int espacios = (48-tam)/2;
            String no_espacios="";
            for(;espacios>0;espacios--){
                no_espacios+=" ";
            }
            res+=no_espacios+r+"\n";
        }
        
        return res;
    }
    
    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        mostrarVentanasInternas(new tarifas(), "Panel de Administracion de Tarifas");
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void menu_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_usuarioActionPerformed
        // TODO add your handling code here:
        mostrarVentanasInternas(new usuarios(), "Panel de Administracion de Usuarios");
    }//GEN-LAST:event_menu_usuarioActionPerformed

    private void menu_parqueoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_parqueoActionPerformed
        // TODO add your handling code here:
        mostrarVentanasInternas(new parqueos(), "Panel de Administracion de Parqueos");
    }//GEN-LAST:event_menu_parqueoActionPerformed

    private void menu_descuentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_descuentosActionPerformed
        // TODO add your handling code here:
        mostrarVentanasInternas(new descuentos(), "Panel de Administracion de Descuentos");
        
    }//GEN-LAST:event_menu_descuentosActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if(Controlador.getTurno_actual()==null){
            JOptionPane.showMessageDialog(this, "No se a aperturado turno, porfavor aperture turno para continuar","ERROR",0);
            return;
        }
        // TODO add your handling code here:
        mostrarVentanasInternas(new cobrar_ticket(), "Panel de cobro del Descuento");
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void ganancia_turnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ganancia_turnoActionPerformed
        // TODO add your handling code here:
        mostrarVentanasInternas(new reporte_ganancia_por_turno(), "Reporte Ganancia por turno");
    }//GEN-LAST:event_ganancia_turnoActionPerformed

    private void tickets_pendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tickets_pendientesActionPerformed
        // TODO add your handling code here:
        mostrarVentanasInternas(new reporte_tickets_pendientes(), "Tickets Pendientes");
    }//GEN-LAST:event_tickets_pendientesActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Login lg = new Login();
        lg.setVisible(true);
        this.dispose();
                    // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        try {
            File path = new File("src/docs/manual.pdf");
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenu2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ganancia_turno;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenu menu_administrador;
    private javax.swing.JMenuItem menu_apertura;
    private javax.swing.JMenuItem menu_cierre;
    private javax.swing.JMenu menu_cobro;
    private javax.swing.JMenuItem menu_descuentos;
    private javax.swing.JMenuItem menu_fecha;
    private javax.swing.JMenuItem menu_parqueo;
    private javax.swing.JMenu menu_reporte;
    private javax.swing.JMenuItem menu_reporte_fecha_hora;
    private javax.swing.JMenuItem menu_reporte_tiempo_promedio;
    private javax.swing.JMenu menu_usuairo;
    private javax.swing.JMenuItem menu_usuario;
    private javax.swing.JMenuItem tickets_pendientes;
    // End of variables declaration//GEN-END:variables
}
