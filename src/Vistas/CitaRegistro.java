/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoADatos.CentroVacunacionData;
import AccesoADatos.CitaData;
import AccesoADatos.CiudadanoData;
import AccesoADatos.VacunaData;
import Entidades.CentroVacunacion;
import Entidades.Cita;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Editor
 */
public class CitaRegistro extends javax.swing.JInternalFrame {
    
    /**
     * Creates new form Cita
     */
    public CitaRegistro() {
        initComponents();
        VacunaData vaglo = new VacunaData();
        llenarcombo();
        validarCantidades();
        if (vaglo.cantVacunasDisponibles() > 0) {

            numSTock.setText(" " + vaglo.cantVacunasDisponibles());
            numSTock.setForeground(Color.BLACK);

        } else {
            numSTock.setText(" " + 0);
            numSTock.setForeground(Color.red);
        }
    }
    public boolean validarCantidades(){
        //si Citas son mayores no se pueden dar mas citas
    CitaData cdglo= new CitaData();
    VacunaData vaglo= new VacunaData();
    int citasdisp= cdglo.cantCitasDisponibles();
    int vacudis= vaglo.cantVacunasDisponibles();
        return  citasdisp > vacudis ;
    }
    
    public void LimpiarCampos(){
    jtdni.setText("");
    jCBCentroVacunacion.setSelectedItem(null);
    jCBCodigoRefuerzo.setSelectedItem(null);
    jDCfechaCal.setCalendar(null);
    jSFMinutos.setValue(0);
    jSFhora.setValue(0);
    }

    public void llenarcombo() {
        jCBCodigoRefuerzo.addItem(null);
        jCBCodigoRefuerzo.addItem(1);
        jCBCodigoRefuerzo.addItem(2);
        jCBCodigoRefuerzo.addItem(3);
    }
    
    SimpleDateFormat formato = new SimpleDateFormat("yyyy, MM, dd");

    private String getFecha(JDateChooser jd) {
        if (jd.getDate() != null) {
            return formato.format(jd.getDate());
        } else {
            return null;
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

        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtdni = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jDCfechaCal = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jBGenerarCita = new javax.swing.JButton();
        jSFhora = new com.toedter.components.JSpinField();
        jSFMinutos = new com.toedter.components.JSpinField();
        jCBCentroVacunacion = new javax.swing.JComboBox<>();
        jCBCodigoRefuerzo = new javax.swing.JComboBox<>();
        stock = new javax.swing.JLabel();
        numSTock = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(848, 528));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(510, 528));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("REGISTRO DE CITA");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("DNI:");

        jtdni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtdniKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Fecha de Cita:");

        jDCfechaCal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Centro de Vacunación:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Código de refuerzo:");

        jBGenerarCita.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBGenerarCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/turno.png"))); // NOI18N
        jBGenerarCita.setText("Generar Cita");
        jBGenerarCita.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBGenerarCita.setMaximumSize(new java.awt.Dimension(73, 39));
        jBGenerarCita.setMinimumSize(new java.awt.Dimension(73, 39));
        jBGenerarCita.setPreferredSize(new java.awt.Dimension(111, 41));
        jBGenerarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGenerarCitaActionPerformed(evt);
            }
        });

        jSFhora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSFhora.setMaximum(17);
        jSFhora.setMinimum(8);

        jSFMinutos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSFMinutos.setMaximum(45);
        jSFMinutos.setMinimum(0);

        jCBCentroVacunacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jCBCentroVacunacion.setMaximumSize(new java.awt.Dimension(33, 26));
        jCBCentroVacunacion.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jCBCentroVacunacionPopupMenuWillBecomeVisible(evt);
            }
        });

        jCBCodigoRefuerzo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        stock.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        stock.setText("Stock Vacuna");

        numSTock.setEditable(false);
        numSTock.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        numSTock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        numSTock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        numSTock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numSTockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(139, 139, 139))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBCentroVacunacion, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jDCfechaCal, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSFhora, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSFMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCBCodigoRefuerzo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numSTock, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBGenerarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118)))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSFhora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSFMinutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDCfechaCal, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBCentroVacunacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBCodigoRefuerzo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numSTock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jBGenerarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 430, 498));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/vacunas-1920-5.jpg"))); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(420, 528));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 420, 498));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCBCentroVacunacionPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jCBCentroVacunacionPopupMenuWillBecomeVisible
        CentroVacunacionData cvd = new CentroVacunacionData();
        jCBCentroVacunacion.removeAllItems();
        jCBCentroVacunacion.addItem(null);
        CiudadanoData cd = new CiudadanoData();

        try {
            for (CentroVacunacion cv : cvd.listarCentroVacunacionsPorLocalidad(cd.buscarCiudadano(Integer.parseInt(jtdni.getText())).getLocalidad())) {
                jCBCentroVacunacion.addItem(cv);
            }

        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "No existen centros de vacunacion en la localidad ");
            LimpiarCampos();
        } catch (NumberFormatException ex) {
            LimpiarCampos();
        }
    }//GEN-LAST:event_jCBCentroVacunacionPopupMenuWillBecomeVisible


    private void jBGenerarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGenerarCitaActionPerformed
        CitaData cd = new CitaData();
        Entidades.Cita ct = new Cita();
        CiudadanoData ciuD = new CiudadanoData();
        String fecha = getFecha(jDCfechaCal);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy, MM, dd");
        CentroVacunacionData cvd = new CentroVacunacionData();
        CentroVacunacion cv = new CentroVacunacion();
        VacunaData vdt = new VacunaData();
        boolean verif = true;
        try {
            
            ct.setCiudadano(ciuD.buscarCiudadano(Integer.parseInt(jtdni.getText())));
            ct.setFecha_cita(LocalDateTime.of(LocalDate.parse(fecha, dtf), LocalTime.of(jSFhora.getValue(), jSFMinutos.getValue())));
            ct.setCentro_vacunacion(((CentroVacunacion) jCBCentroVacunacion.getSelectedItem()).getIdCV());
            ct.setCodigo_refuerzo((int) jCBCodigoRefuerzo.getSelectedItem());
            //ct.setVacuna(vac);
            if (validarCantidades()) {
                JOptionPane.showMessageDialog(this, "No se puede registrar una cita No hay Vacunas disponibles\n"
                        + "Para Generar una nueva Cita, debe cancelar una existente"
                        );
               int show= JOptionPane.showConfirmDialog(this, "¿Desea cancelar una cita?");
                if (show == 0){
                    VacunaRegistro al = new VacunaRegistro();
                     Menu.escritorio.add(al);
                       al.setVisible(true);               
                }
             LimpiarCampos();
                return;
            }
            for (Entidades.Cita cit : cd.listarCitasCiudadano(ciuD.buscarCiudadano(Integer.parseInt(jtdni.getText())))) {
                if (cit.getEstado() == 0){
                    JOptionPane.showMessageDialog(this, "El ciudadano tiene una cita en proceso");
                     verif=false;
                     LimpiarCampos();
                     break;
                     
                }
                else if (cit.getEstado() == 1 && cit.getCodigo_refuerzo() < 3) {
                    LocalDateTime fechaCita = cit.getFecha_cita();
                    LocalDateTime nuevaFechaCita = fechaCita.plusWeeks(4);
                    ct.setFecha_cita(nuevaFechaCita);
                    if (cit.getCodigo_refuerzo() == 1) {
                        ct.setCodigo_refuerzo(2);
                    } else if (cit.getCodigo_refuerzo() == 2) {
                        ct.setCodigo_refuerzo(3);
                    }
                    verif=true;
                    JOptionPane.showMessageDialog(this, "El ciudadano ya tiene una dosis aplicada, \n"
                            + "se genera cita automaticamente con fecha: " + nuevaFechaCita);
                } else if (cit.getCodigo_refuerzo() == 3) {
                    JOptionPane.showMessageDialog(this, "El Ciudadano ya tiene 3 dosis");
                    verif=false;
                    break;
                } 
            } if (verif) {
                    
                  ct.setEstado(0);
                  cd.guardarCita(ct);
                  LimpiarCampos();
                   }       
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Verifica los datos ingresados " + ex);       
        }
    }//GEN-LAST:event_jBGenerarCitaActionPerformed

    private void jtdniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtdniKeyTyped
        int tecla = evt.getKeyChar();
        boolean numeros = tecla >= 48 && tecla <= 57;
        if (!(numeros)) {
            evt.consume();
        }
        if ((jtdni.getText().length() >= 8)) {
            evt.consume();
        }
    }//GEN-LAST:event_jtdniKeyTyped

    private void numSTockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numSTockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numSTockActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGenerarCita;
    private javax.swing.JComboBox<CentroVacunacion> jCBCentroVacunacion;
    private javax.swing.JComboBox<Integer> jCBCodigoRefuerzo;
    private com.toedter.calendar.JDateChooser jDCfechaCal;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private com.toedter.components.JSpinField jSFMinutos;
    private com.toedter.components.JSpinField jSFhora;
    private javax.swing.JTextField jtdni;
    private javax.swing.JTextField numSTock;
    private javax.swing.JLabel stock;
    // End of variables declaration//GEN-END:variables
}
