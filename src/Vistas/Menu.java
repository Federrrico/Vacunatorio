/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import javax.swing.JInternalFrame;

/**
 *
 * @author federico.acenjo
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void actualizarLab(){
        for (JInternalFrame iframe : escritorio.getAllFrames()) {
            escritorio.remove(iframe);
        }
        escritorio.repaint();
        LaboratorioV lab = new LaboratorioV();
        lab.setVisible(true);
        escritorio.add(lab);
        escritorio.moveToFront(lab);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jCiudadano = new javax.swing.JMenu();
        jFormularioCiudadano = new javax.swing.JMenuItem();
        jLaboratorio = new javax.swing.JMenu();
        jFormularioLaboratorio = new javax.swing.JMenuItem();
        jVacuna = new javax.swing.JMenu();
        jFormularioVacuna = new javax.swing.JMenuItem();
        jCargaVacuna = new javax.swing.JMenuItem();
        jCita = new javax.swing.JMenu();
        jtCita = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setPreferredSize(new java.awt.Dimension(1080, 507));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/covid.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        escritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jCiudadano.setText("Ciudadano");

        jFormularioCiudadano.setText("Formulario Ciudadano");
        jFormularioCiudadano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormularioCiudadanoActionPerformed(evt);
            }
        });
        jCiudadano.add(jFormularioCiudadano);

        jMenuBar1.add(jCiudadano);

        jLaboratorio.setText("Laboratorio");

        jFormularioLaboratorio.setText("Formulario Laboratorio");
        jFormularioLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormularioLaboratorioActionPerformed(evt);
            }
        });
        jLaboratorio.add(jFormularioLaboratorio);

        jMenuBar1.add(jLaboratorio);

        jVacuna.setText("Vacuna");

        jFormularioVacuna.setText("Formulario Vacuna");
        jFormularioVacuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormularioVacunaActionPerformed(evt);
            }
        });
        jVacuna.add(jFormularioVacuna);

        jCargaVacuna.setText("Carga de Vacuna");
        jCargaVacuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCargaVacunaActionPerformed(evt);
            }
        });
        jVacuna.add(jCargaVacuna);

        jMenuBar1.add(jVacuna);

        jCita.setText("Cita");

        jtCita.setText("Registro de Cita");
        jtCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCitaActionPerformed(evt);
            }
        });
        jCita.add(jtCita);

        jMenuBar1.add(jCita);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFormularioCiudadanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormularioCiudadanoActionPerformed
        // TODO add your handling code here:
        for (JInternalFrame iframe : escritorio.getAllFrames()) {
            escritorio.remove(iframe);
        }
        escritorio.repaint();
        FormularioCiudadano fc = new FormularioCiudadano();
        fc.setVisible(true);
        escritorio.add(fc);
        escritorio.moveToFront(fc);
    }//GEN-LAST:event_jFormularioCiudadanoActionPerformed

    private void jtCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCitaActionPerformed
       for (JInternalFrame iframe : escritorio.getAllFrames()) {
            escritorio.remove(iframe);
        }
        escritorio.repaint();
        CitaRegistro cita = new CitaRegistro();
        cita.setVisible(true);
        escritorio.add(cita);
        escritorio.moveToFront(cita);
    }//GEN-LAST:event_jtCitaActionPerformed

    private void jFormularioLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormularioLaboratorioActionPerformed
        for (JInternalFrame iframe : escritorio.getAllFrames()) {
            escritorio.remove(iframe);
        }
        escritorio.repaint();
        LaboratorioV lab = new LaboratorioV();
        lab.setVisible(true);
        escritorio.add(lab);
        escritorio.moveToFront(lab);
    }//GEN-LAST:event_jFormularioLaboratorioActionPerformed

    private void jFormularioVacunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormularioVacunaActionPerformed
        for (JInternalFrame iframe : escritorio.getAllFrames()) {
            escritorio.remove(iframe);
        }
        escritorio.repaint();
        VacunaRegistro vac = new VacunaRegistro();
        vac.setVisible(true);
        escritorio.add(vac);
        escritorio.moveToFront(vac);
    }//GEN-LAST:event_jFormularioVacunaActionPerformed

    private void jCargaVacunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCargaVacunaActionPerformed
        for (JInternalFrame iframe : escritorio.getAllFrames()) {
            escritorio.remove(iframe);
        }
        escritorio.repaint();
        CargaVacuna vac = new CargaVacuna();
        vac.setVisible(true);
        escritorio.add(vac);
        escritorio.moveToFront(vac);
    }//GEN-LAST:event_jCargaVacunaActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem jCargaVacuna;
    private javax.swing.JMenu jCita;
    private javax.swing.JMenu jCiudadano;
    private javax.swing.JMenuItem jFormularioCiudadano;
    private javax.swing.JMenuItem jFormularioLaboratorio;
    private javax.swing.JMenuItem jFormularioVacuna;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jLaboratorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jVacuna;
    private javax.swing.JMenuItem jtCita;
    // End of variables declaration//GEN-END:variables
}
