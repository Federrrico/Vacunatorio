/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoADatos.CentroVacunacionData;
import Entidades.CentroVacunacion;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Editor
 */
public class CentrosDeVacunacion extends javax.swing.JInternalFrame {

    /**
     * Creates new form CentrosDeVacunacion
     */
    public CentrosDeVacunacion() {
        initComponents();
        jDireccionInvalida.setVisible(false);
    }

    private void limpiarCampos() {
        jTNombre.setText("");
        jTLocalidad.setText("");
        jTProvincia.setText("");
        jTDireccion.setText("");
        jRBEstado.setSelected(false);       
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
        jTNombre = new javax.swing.JTextField();
        jTLocalidad = new javax.swing.JTextField();
        jTProvincia = new javax.swing.JTextField();
        jTDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jRBEstado = new javax.swing.JRadioButton();
        jBGuardar = new javax.swing.JButton();
        jDireccionInvalida = new javax.swing.JLabel();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(848, 470));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/vacunacion-covid-194.png.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 416, 440));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("CENTROS DE VACUNACION");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Localidad:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Provincia:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Dirección:");

        jTNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTNombreKeyTyped(evt);
            }
        });

        jTLocalidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTLocalidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTLocalidadKeyTyped(evt);
            }
        });

        jTProvincia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTProvincia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTProvinciaKeyTyped(evt);
            }
        });

        jTDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTDireccionKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Estado:");

        jRBEstado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jBGuardar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/iconoGuardar.png"))); // NOI18N
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

        jDireccionInvalida.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jDireccionInvalida.setForeground(new java.awt.Color(255, 0, 0));
        jDireccionInvalida.setText("Dirección Inválida(*)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jRBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTLocalidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                        .addComponent(jTProvincia, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTDireccion, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(29, 29, 29)
                                .addComponent(jDireccionInvalida))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDireccionInvalida))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 450, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        CentroVacunacion cv= new CentroVacunacion();
        CentroVacunacionData cvd = new CentroVacunacionData();

        try {
            if (!(jTNombre.getText().isEmpty() && jTLocalidad.getText().isEmpty()
                    && jTProvincia.getText().isEmpty() && jTDireccion.getText().isEmpty())&& jRBEstado.isSelected()) {
                cv.setNombre(jTNombre.getText());
                cv.setLocalidad(jTLocalidad.getText());
                cv.setProvincia(jTProvincia.getText());
                cv.setDireccion(jTDireccion.getText());
                cv.setEstado(true);
                cvd.guardarCentroVacunacion(cv);
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Verifique que los campos no esten vacios");
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Verifique los datos ingresados");
        } catch (NumberFormatException ex) {
            
        }              
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jTNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreKeyTyped
        int tecla = evt.getKeyChar();
        boolean may = tecla >= 65 && tecla <= 90;
        boolean min = tecla >= 97 && tecla <= 122;
        boolean esp = tecla == 32;
        if (!(may || min || esp)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTNombreKeyTyped

    private void jTLocalidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTLocalidadKeyTyped
        int tecla = evt.getKeyChar();
        boolean may = tecla >= 65 && tecla <= 90;
        boolean min = tecla >= 97 && tecla <= 122;
        boolean esp = tecla == 32;
        if (!(may || min || esp)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTLocalidadKeyTyped

    private void jTProvinciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProvinciaKeyTyped
        int tecla = evt.getKeyChar();
        boolean may = tecla >= 65 && tecla <= 90;
        boolean min = tecla >= 97 && tecla <= 122;
        boolean esp = tecla == 32;
        if (!(may || min || esp)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTProvinciaKeyTyped

    private void jTDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDireccionKeyReleased
        if (verificarDireccion(jTDireccion.getText())) {
            jDireccionInvalida.setVisible(false);
        } else {
            jDireccionInvalida.setVisible(true);
        }
    }//GEN-LAST:event_jTDireccionKeyReleased

    public boolean verificarDireccion (String direccion){
    // se compara con la expresion regular
        Pattern patron = Pattern.compile("^([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)+\\s+\\d");
        Matcher mat= patron.matcher(direccion);
        return mat.find();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGuardar;
    private javax.swing.JLabel jDireccionInvalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRBEstado;
    private javax.swing.JTextField jTDireccion;
    private javax.swing.JTextField jTLocalidad;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTProvincia;
    // End of variables declaration//GEN-END:variables
}
