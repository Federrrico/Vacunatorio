/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoADatos.LaboratorioData;
import Entidades.Laboratorio;
import javax.swing.JOptionPane;
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
            if (columnIndex == 0) {
                return false;
            } else {
                return true;
            }
        }
    };
    
    private String cuit;
    private String nombre;
    private String pais;
    private String domicilio;

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
        
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(180);
        
        jEditar.setEnabled(false);
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
        jPanel1.setPreferredSize(new java.awt.Dimension(420, 509));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("LABORATORIOS");

        jAgregar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/iconoGuardar.png"))); // NOI18N
        jAgregar.setText("Agregar");
        jAgregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAgregarActionPerformed(evt);
            }
        });

        jEditar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/iconoEditar.png"))); // NOI18N
        jEditar.setText("Editar");
        jEditar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditarActionPerformed(evt);
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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
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
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(62, 62, 62)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 450, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/laboratorios.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAgregarActionPerformed
        AgregarLaboratorio al = new AgregarLaboratorio();
        Menu.escritorio.add(al);
        al.setVisible(true);
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
                if (!cuit.equalsIgnoreCase(modelo.getValueAt(jTable1.getSelectedRow(), 0).toString()) || 
                        !nombre.equalsIgnoreCase(modelo.getValueAt(jTable1.getSelectedRow(), 1).toString()) ||
                        !pais.equalsIgnoreCase(modelo.getValueAt(jTable1.getSelectedRow(), 2).toString()) ||
                        !domicilio.equalsIgnoreCase(modelo.getValueAt(jTable1.getSelectedRow(), 3).toString())){
                    ld.modificarLaboratorio(lab);
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(this, "No se ha realizado ninguna modificacion");
                }
                jEditar.setText("Editar");
                jAgregar.setEnabled(true);
                jTable1.clearSelection();
                jEditar.setEnabled(false);
                edit = -1;
                modelo.isCellEditable(jTable1.getSelectedRow(), jTable1.getSelectedColumn());
            } else {
                edit = jTable1.getSelectedRow();
                modelo.isCellEditable(jTable1.getSelectedRow(), jTable1.getSelectedColumn());
                jEditar.setText("Guardar");
                jAgregar.setEnabled(false);
            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Revisar los datos ingresados!!");
            if (jEditar.getText().equals("Guardar")) {
                jEditar.setText("Editar");
                jAgregar.setEnabled(true);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Solo tenes que ingresar numeros" + ex.getMessage());
            if (jEditar.getText().equals("Guardar")) {
                jEditar.setText("Editar");
                jAgregar.setEnabled(true);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Selecione una opcion para Guardar");
            if (jEditar.getText().equals("Guardar")) {
                jEditar.setText("Editar");
                jAgregar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jEditarActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        jEditar.setEnabled(true);
        jAgregar.setEnabled(false);
        cuit = modelo.getValueAt(jTable1.getSelectedRow(), 0).toString();
        nombre = modelo.getValueAt(jTable1.getSelectedRow(), 1).toString();
        pais = modelo.getValueAt(jTable1.getSelectedRow(), 2).toString();
        domicilio = modelo.getValueAt(jTable1.getSelectedRow(), 3).toString();
    }//GEN-LAST:event_jTable1MousePressed


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
