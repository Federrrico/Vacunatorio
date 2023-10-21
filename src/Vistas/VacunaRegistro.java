/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoADatos.CitaData;
import AccesoADatos.CiudadanoData;
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

    private DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; //To change body of generated methods, choose Tools | Templates.
        }
        
    };
    private Cita citaV;
    
    /**
     * Creates new form Vacuna
     */
    public VacunaRegistro() {
        initComponents();
        modelo.addColumn("ID Cita");
        modelo.addColumn("Vacuna");
        modelo.addColumn("Dosis");
        modelo.addColumn("Estado");
        modelo.addColumn("Colocacion");
        //modelo.addColumn("Fecha y hora");

        jTable1.setModel(modelo);
        citaV = new Cita();
      jCentros.setEnabled(false);
       
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
    
    private void llenarTabla(){
        borrarFilas();
        CitaData cd = new CitaData();
        Ciudadano c1 = (Ciudadano) jcVacuna.getSelectedItem();
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
                    modelo.addRow(new Object[]{cita.getId_cita(), cita.getVacuna().getNombre_vacuna(),
                        cita.getVacuna().getDosis(), estadoString, fechaCol});
                  
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
        jcVacuna = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jCentros = new javax.swing.JButton();
        jDCFechaColocacion = new com.toedter.calendar.JDateChooser();
        jSFHoraColocacion = new com.toedter.components.JSpinField();
        jSFMinColocacion = new com.toedter.components.JSpinField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(860, 528));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("REGISTRO DE VACUNACIÓN");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Ciudadano");

        jcVacuna.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jcVacuna.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcVacunaItemStateChanged(evt);
            }
        });
        jcVacuna.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jcVacunaPopupMenuWillBecomeVisible(evt);
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
        jCentros.setPreferredSize(new java.awt.Dimension(87, 41));
        jCentros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCentrosActionPerformed(evt);
            }
        });

        jDCFechaColocacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSFHoraColocacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSFHoraColocacion.setMaximum(17);
        jSFHoraColocacion.setMinimum(10);

        jSFMinColocacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSFMinColocacion.setMaximum(45);
        jSFMinColocacion.setMinimum(0);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Fecha y Hora:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jDCFechaColocacion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSFHoraColocacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jSFMinColocacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jcVacuna, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jCentros, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcVacuna, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jCentros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(352, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 440, 747));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/vacunas-1920-5.jpg"))); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(420, 528));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 747));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCentrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCentrosActionPerformed
        String fecha = getFecha(jDCFechaColocacion);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy, MM, dd");
        CitaData cd = new CitaData();
        System.out.println("Fecha: " + getFecha(jDCFechaColocacion));
        System.out.println("Hora: " + jSFHoraColocacion.getValue());
        System.out.println("Minutos: " + jSFMinColocacion.getValue());
        System.out.println("ID Cita: " + Integer.parseInt(modelo.getValueAt(jTable1.getSelectedRow(), 0).toString()));
        Entidades.Cita cita = cd.buscarCita(Integer.parseInt(modelo.getValueAt(jTable1.getSelectedRow(), 0).toString()));
        cita.setFecha_colocacion(LocalDateTime.of(LocalDate.parse(fecha, dtf), LocalTime.of(jSFHoraColocacion.getValue(), jSFMinColocacion.getValue())));
        cita.setEstado(1);
        cd.modificarCita(cita);
        llenarTabla();
    }//GEN-LAST:event_jCentrosActionPerformed

    private void jcVacunaPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcVacunaPopupMenuWillBecomeVisible
        CiudadanoData cd = new CiudadanoData();
        jcVacuna.removeAllItems();
        jcVacuna.addItem(null);

        try {
            for (Ciudadano c1 : cd.listarCiudadanos()) {
                jcVacuna.addItem(c1);
            }

        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "No existen ciudadanos en la BD");

        }
    }//GEN-LAST:event_jcVacunaPopupMenuWillBecomeVisible

    private void jcVacunaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcVacunaItemStateChanged
        llenarTabla();
    }//GEN-LAST:event_jcVacunaItemStateChanged

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
       
        jCentros.setEnabled(true);
    }//GEN-LAST:event_jTable1MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jCentros;
    private com.toedter.calendar.JDateChooser jDCFechaColocacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private com.toedter.components.JSpinField jSFHoraColocacion;
    private com.toedter.components.JSpinField jSFMinColocacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<Ciudadano> jcVacuna;
    // End of variables declaration//GEN-END:variables
}
