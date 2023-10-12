/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoADatos.LaboratorioData;
import Entidades.Laboratorio;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Editor
 */
public class LaboratorioV extends javax.swing.JInternalFrame {

    private int edit = -1;

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            if (rowIndex == edit) {
                return true;
            } else {
                return false;
            }
        }

    };

    /**
     * Creates new form Laboratorio
     */
    public LaboratorioV() {
        initComponents();
        modelo.addColumn("Cuit");
        modelo.addColumn("Nombre");
        modelo.addColumn("Pais");
        modelo.addColumn("Domicilio");
        jTable1.setModel(modelo);

        llenarTabla();
    }

    public void llenarTabla() {
        LaboratorioData lD = new LaboratorioData();

        try {
            for (Laboratorio lab : lD.listarLaboratorios()) {
                modelo.addRow(new Object[]{lab.getCuit(), lab.getNombre(),
                    lab.getPais_origen(), lab.getDireccion_fiscal()});
            }
        } catch (NullPointerException ex) {
        }
    }

    private void borrarFilas() {
        int f = modelo.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
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
        jAgregar = new javax.swing.JButton();
        jEditar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(848, 528));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("LABORATORIO");

        jAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/iconoGuardar.png"))); // NOI18N
        jAgregar.setText("Agregar");
        jAgregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAgregarActionPerformed(evt);
            }
        });

        jEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/iconoEditar.png"))); // NOI18N
        jEditar.setText("Editar");
        jEditar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jEditar.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jEditarInputMethodTextChanged(evt);
            }
        });
        jEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditarActionPerformed(evt);
            }
        });

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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 504, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(157, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/laboratorios.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAgregarActionPerformed
        LaboratorioAgregar la = new LaboratorioAgregar();
        la.setVisible(true);
    }//GEN-LAST:event_jAgregarActionPerformed

    private void jEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditarActionPerformed

        try {
            if (jEditar.getText().equals("Guardar")) {
                LaboratorioData ld = new LaboratorioData();
                Laboratorio lab = new Laboratorio();

                lab.setCuit(Long.parseLong(modelo.getValueAt(jTable1.getSelectedRow(), 0).toString()));
                lab.setNombre(modelo.getValueAt(jTable1.getSelectedRow(), 1).toString());
                lab.setPais_origen(modelo.getValueAt(jTable1.getSelectedRow(), 2).toString());
                lab.setDireccion_fiscal(modelo.getValueAt(jTable1.getSelectedRow(), 3).toString());
                ld.modificarLaboratorio(lab);

                jEditar.setText("Editar");
                edit = -1;
                modelo.isCellEditable(jTable1.getSelectedRow(), jTable1.getSelectedColumn());
            } else {
                edit = jTable1.getSelectedRow();
                modelo.isCellEditable(jTable1.getSelectedRow(), jTable1.getSelectedColumn());
                jEditar.setText("Guardar");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Revisar los datos ingresados!!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Solo tenes que ingresar numeros" + ex.getMessage());
        }

    }//GEN-LAST:event_jEditarActionPerformed

    private void jEditarInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jEditarInputMethodTextChanged

    }//GEN-LAST:event_jEditarInputMethodTextChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAgregar;
    private javax.swing.JButton jEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
