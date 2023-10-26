/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoADatos.CitaData;
import AccesoADatos.CiudadanoData;
import AccesoADatos.VacunaData;
import Entidades.*;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Editor
 */
public class VacunaRegistro extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; //To change body of generated methods, choose Tools | Templates.
        }

    };
    
    //private SpinnerNumberModel spm = new SpinnerNumberModel();

    /**
     * Creates new form Vacuna
     */
    public VacunaRegistro() {
        initComponents();
        modelo.addColumn("ID Cita");
        modelo.addColumn("Dosis");
        modelo.addColumn("Estado");
        modelo.addColumn("Colocacion");
        jTable1.setModel(modelo);

        jCentros.setEnabled(false);
        jCPostergar.setEnabled(false);
        jCancelar.setEnabled(false);
        

    }

    private void borrarFilas() {
        int f = modelo.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }

    SimpleDateFormat formato = new SimpleDateFormat("yyyy, MM, dd");

    private String getFecha(JDateChooser jd) {
        if (jd.getDate() != null) {
            return formato.format(jd.getDate());
        } else {
            return null;
        }
    }

    private void llenarTabla() {
        borrarFilas();
        CitaData cd = new CitaData();
        Ciudadano c1 = (Ciudadano) jcCiudadano.getSelectedItem();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String fechaCol = "----";
        String estadoString = "";
        try {
            for (Entidades.Cita cita : cd.listarCitas()) {
                if (cita.getCiudadano().getDni() == c1.getDni()) {
                    switch (cita.getEstado()) {
                        case 0:
                            estadoString = "En proceso";
                            break;
                        case 1:
                            estadoString = "Colocada";
                            fechaCol = cita.getFecha_colocacion().format(formatter);
                            break;
                        case 2:
                            estadoString = "Cancelada";
                            break;
                        default:
                            estadoString = "Reprogramada";
                            break;
                    }
                    if (cita.getEstado() != 2) {
                        if (cita.getVacuna() != null) {
                            modelo.addRow(new Object[]{cita.getId_cita(),
                                cita.getVacuna().getDosis(),
                                estadoString,
                                fechaCol});
                        } else {
                            modelo.addRow(new Object[]{cita.getId_cita(),
                                "No Colocada",
                                "---",
                                estadoString,
                                fechaCol});
                        }
                    }

                }
            }
        } catch (NullPointerException ex) {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcCiudadano = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jCentros = new javax.swing.JButton();
        jDCFechaColocacion = new com.toedter.calendar.JDateChooser();
        jSFHoraColocacion = new com.toedter.components.JSpinField();
        jLabel4 = new javax.swing.JLabel();
        jCPostergar = new javax.swing.JButton();
        jCancelar = new javax.swing.JButton();
        jSFMinColocacion = new com.toedter.components.JSpinField();
        jCVacuna = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(890, 568));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("REGISTRO DE VACUNACIÓN");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Ciudadano:");

        jcCiudadano.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jcCiudadano.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcCiudadanoItemStateChanged(evt);
            }
        });
        jcCiudadano.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jcCiudadanoPopupMenuWillBecomeVisible(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jCentros.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCentros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/vacuna.png"))); // NOI18N
        jCentros.setText("Vacunar");
        jCentros.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jCentros.setMaximumSize(new java.awt.Dimension(73, 39));
        jCentros.setMinimumSize(new java.awt.Dimension(73, 39));
        jCentros.setPreferredSize(new java.awt.Dimension(111, 41));
        jCentros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCentrosActionPerformed(evt);
            }
        });

        jDCFechaColocacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSFHoraColocacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSFHoraColocacion.setMaximum(17);
        jSFHoraColocacion.setMinimum(10);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Fecha y Hora:");

        jCPostergar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCPostergar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/turno.png"))); // NOI18N
        jCPostergar.setText("Postergar");
        jCPostergar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jCPostergar.setMaximumSize(new java.awt.Dimension(73, 39));
        jCPostergar.setMinimumSize(new java.awt.Dimension(73, 39));
        jCPostergar.setPreferredSize(new java.awt.Dimension(111, 41));
        jCPostergar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCPostergarActionPerformed(evt);
            }
        });

        jCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/remove_91021.png"))); // NOI18N
        jCancelar.setText("Cancelar");
        jCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jCancelar.setMaximumSize(new java.awt.Dimension(73, 39));
        jCancelar.setMinimumSize(new java.awt.Dimension(73, 39));
        jCancelar.setPreferredSize(new java.awt.Dimension(111, 41));
        jCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelarActionPerformed(evt);
            }
        });

        jSFMinColocacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSFMinColocacion.setMaximum(59);
        jSFMinColocacion.setMinimum(0);

        jCVacuna.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jCVacuna.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jCVacunaPopupMenuWillBecomeVisible(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Vacuna:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(33, 33, 33)
                                .addComponent(jcCiudadano, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jDCFechaColocacion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(jSFHoraColocacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jSFMinColocacion, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jCVacuna, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(47, 47, 47))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jCPostergar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCentros, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(129, 129, 129))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcCiudadano, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jDCFechaColocacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSFMinColocacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSFHoraColocacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jCVacuna, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCPostergar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCentros, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(291, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 470, 747));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/vacunas-1920-5.jpg"))); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(420, 528));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 747));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCentrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCentrosActionPerformed
        VacunaData vd = new VacunaData();
        
        String fecha = getFecha(jDCFechaColocacion);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy, MM, dd");
        CitaData cd = new CitaData();
        Entidades.Cita cita = cd.buscarCita(Integer.parseInt(modelo.getValueAt(jTable1.getSelectedRow(), 0).toString()));
        cita.setFecha_colocacion(LocalDateTime.of(LocalDate.parse(fecha, dtf), LocalTime.of(jSFHoraColocacion.getValue(), jSFMinColocacion.getValue())));
        cita.setEstado(1);
        cita.setVacuna((Entidades.Vacuna)jCVacuna.getSelectedItem());
        cd.modificarCita(cita);
        Entidades.Vacuna vac = cita.getVacuna();
        vd.colocarVacuna(vac);
        llenarTabla();
        jCentros.setEnabled(false);
        jCPostergar.setEnabled(false);
        jCancelar.setEnabled(false);


    }//GEN-LAST:event_jCentrosActionPerformed

    private void jcCiudadanoPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcCiudadanoPopupMenuWillBecomeVisible
        CiudadanoData cd = new CiudadanoData();
        jcCiudadano.removeAllItems();
        jcCiudadano.addItem(null);

        try {
            for (Ciudadano c1 : cd.listarCiudadanos()) {
                jcCiudadano.addItem(c1);
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "No existen ciudadanos en la BD");

        }
    }//GEN-LAST:event_jcCiudadanoPopupMenuWillBecomeVisible

    private void jcCiudadanoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcCiudadanoItemStateChanged
        llenarTabla();
        jCentros.setEnabled(false);
        jCPostergar.setEnabled(false);
        jCancelar.setEnabled(false);
    }//GEN-LAST:event_jcCiudadanoItemStateChanged

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        if (!modelo.getValueAt(jTable1.getSelectedRow(), 2).equals("Colocada")) {
            jCentros.setEnabled(true);
            jCPostergar.setEnabled(true);
            jCancelar.setEnabled(true);
            
        }
        

    }//GEN-LAST:event_jTable1MousePressed

    private void jCPostergarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCPostergarActionPerformed
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy, MM, dd - hh:mm");
        CitaData cd = new CitaData();
        
        Entidades.Cita cita = cd.buscarCita(Integer.parseInt(modelo.getValueAt(jTable1.getSelectedRow(), 0).toString()));
        LocalDateTime fechaCita = cita.getFecha_cita();
        
        LocalDateTime nuevaFechaCita = fechaCita.plusWeeks(2);
        
        cita.setFecha_cita(nuevaFechaCita);
        cita.setEstado(0);
        cd.modificarCita(cita);

        llenarTabla();
        jCentros.setEnabled(false);
        jCPostergar.setEnabled(false);
        jCancelar.setEnabled(false);
        String fechaString = nuevaFechaCita.format(dtf);
        JOptionPane.showMessageDialog(this, "La nueva fecha del turno es: " + fechaString);
    }//GEN-LAST:event_jCPostergarActionPerformed

    private void jCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelarActionPerformed
        CitaData cd = new CitaData();
        cd.eliminarCita(Integer.parseInt(modelo.getValueAt(jTable1.getSelectedRow(), 0).toString()));
        llenarTabla();
        jCentros.setEnabled(false);
        jCPostergar.setEnabled(false);
        jCancelar.setEnabled(false);


    }//GEN-LAST:event_jCancelarActionPerformed

    private void jCVacunaPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jCVacunaPopupMenuWillBecomeVisible
        VacunaData vd = new VacunaData();
        jCVacuna.removeAllItems();
        jCVacuna.addItem(null);
        
        try {
            for (Entidades.Vacuna vacuna : vd.listarVacunasDisponibles()) {
                jCVacuna.addItem(vacuna);
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "No hay vacunas disponibles");

        }
    }//GEN-LAST:event_jCVacunaPopupMenuWillBecomeVisible


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jCPostergar;
    private javax.swing.JComboBox<Entidades.Vacuna> jCVacuna;
    private javax.swing.JButton jCancelar;
    private javax.swing.JButton jCentros;
    private com.toedter.calendar.JDateChooser jDCFechaColocacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private com.toedter.components.JSpinField jSFHoraColocacion;
    private com.toedter.components.JSpinField jSFMinColocacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<Ciudadano> jcCiudadano;
    // End of variables declaration//GEN-END:variables
}
