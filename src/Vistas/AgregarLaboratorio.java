/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoADatos.LaboratorioData;
import Entidades.Laboratorio;
import static Vistas.Menu.escritorio;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Editor
 */
public class AgregarLaboratorio extends javax.swing.JInternalFrame {

    /**
     * Creates new form AgregarLaboratorio
     */
    public AgregarLaboratorio() {
        initComponents();
        jDomicilioInvalido.setVisible(false);
    }

    private void limpiarCampos() {
        jTCuit.setText("");
        jTNombre.setText("");
        jTPais.setText("");
        jTDomicilio.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTCuit = new javax.swing.JTextField();
        jTNombre = new javax.swing.JTextField();
        jTPais = new javax.swing.JTextField();
        jTDomicilio = new javax.swing.JTextField();
        jBGuardar = new javax.swing.JButton();
        jBVolver = new javax.swing.JButton();
        jDomicilioInvalido = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(850, 528));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/laboratorios.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("AGREGAR LABORATORIO");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("CUIT:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("País de origen:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Domicilio:");

        jTCuit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTCuit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTCuitKeyTyped(evt);
            }
        });

        jTNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTNombreKeyTyped(evt);
            }
        });

        jTPais.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTPais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTPaisKeyTyped(evt);
            }
        });

        jTDomicilio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTDomicilio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTDomicilioKeyReleased(evt);
            }
        });

        jBGuardar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/microscope.png"))); // NOI18N
        jBGuardar.setText("Guardar");
        jBGuardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBGuardar.setMaximumSize(new java.awt.Dimension(73, 39));
        jBGuardar.setMinimumSize(new java.awt.Dimension(73, 39));
        jBGuardar.setPreferredSize(new java.awt.Dimension(111, 41));
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBVolver.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/volver.png"))); // NOI18N
        jBVolver.setText("Volver");
        jBVolver.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBVolver.setMaximumSize(new java.awt.Dimension(73, 39));
        jBVolver.setMinimumSize(new java.awt.Dimension(73, 39));
        jBVolver.setPreferredSize(new java.awt.Dimension(111, 41));
        jBVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVolverActionPerformed(evt);
            }
        });

        jDomicilioInvalido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jDomicilioInvalido.setForeground(new java.awt.Color(255, 0, 0));
        jDomicilioInvalido.setText("Domicilio Inválido(*)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTPais, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDomicilioInvalido))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel2)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTPais, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDomicilioInvalido))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(136, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 0, 430, 509));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        Laboratorio la = new Laboratorio();
        LaboratorioData lD = new LaboratorioData();

        try {
            if (!jTCuit.getText().isEmpty() && !jTDomicilio.getText().isEmpty()
                    && !jTNombre.getText().isEmpty() && !jTPais.getText().isEmpty() && jTCuit.getText().length() >= 10) {
                la.setCuit(Long.parseLong(jTCuit.getText()));
                la.setNombre(jTNombre.getText());
                la.setDireccion_fiscal(jTDomicilio.getText());
                la.setPais_origen(jTPais.getText());
                lD.guardarLaboratorio(la);
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Verifique los datos ingresados");
                System.out.println("CUIT: " + jTCuit.getText() + "Length: " + jTCuit.getText().length());
            }
        } catch (NullPointerException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Verifique los datos ingresados");
        }
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVolverActionPerformed
        for (JInternalFrame iframe : escritorio.getAllFrames()) {
            escritorio.remove(iframe);
        }
        LaboratorioV lv = new LaboratorioV();
        escritorio.repaint();
        lv.setVisible(true);
        escritorio.add(lv);
        escritorio.moveToFront(lv);
    }//GEN-LAST:event_jBVolverActionPerformed

    private void jTCuitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCuitKeyTyped
         int tecla = evt.getKeyChar();
        boolean numeros = tecla >= 48 && tecla <= 57;
        if (!(numeros)) {
            evt.consume();
        }
        if ((jTCuit.getText().length() >= 11)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTCuitKeyTyped

    private void jTNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreKeyTyped
        int tecla = evt.getKeyChar();
        boolean may = tecla >= 65 && tecla <= 90;
        boolean min = tecla >= 97 && tecla <= 122;
        boolean esp = tecla == 32;
        if (!(may || min || esp)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTNombreKeyTyped

    private void jTPaisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPaisKeyTyped
        int tecla = evt.getKeyChar();
        boolean may = tecla >= 65 && tecla <= 90;
        boolean min = tecla >= 97 && tecla <= 122;
        boolean esp = tecla == 32;
        if (!(may || min || esp)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTPaisKeyTyped

    private void jTDomicilioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDomicilioKeyReleased
         if (verificarDomicilio(jTDomicilio.getText())) {
            jDomicilioInvalido.setVisible(false);
        } else {
            jDomicilioInvalido.setVisible(true);
        }
    }//GEN-LAST:event_jTDomicilioKeyReleased

    public boolean verificarDomicilio (String domicilio){
    // se compara con la expresion regular
        Pattern patron = Pattern.compile("^([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)+\\s+\\d");
        Matcher mat= patron.matcher(domicilio);
        return mat.find();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBVolver;
    private javax.swing.JLabel jDomicilioInvalido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTCuit;
    private javax.swing.JTextField jTDomicilio;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTPais;
    // End of variables declaration//GEN-END:variables
}
