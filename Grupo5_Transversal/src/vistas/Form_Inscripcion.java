/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas;

import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import modelo.Colegio;

/**
 *
 * @author saimon
 */
public class Form_Inscripcion extends javax.swing.JInternalFrame {

    /**
     * Creates new form Form_Inscripcion
     * 
     */
    
    Colegio gt;
    DefaultTableModel model = new DefaultTableModel();
            
    public Form_Inscripcion() {
        initComponents();
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        try {
           // PreparedStatement pst = gt.prepareStatement("select idAlumno, nombre, apellido, materia");
           // ResultSet rs = pst.executeQuery();
            
            jTable_alumnos  = new JTable(model);
           
           
            
        } catch (Exception e) {
        }
        
    }

    @Override
    public String toString() {
        return "Form_Inscripcion{" + "jTab_alumno=" +  jTable_alumnos + '}';
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jL_Inscripcion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_alumnos = new javax.swing.JTable();
        jL_Alumno = new javax.swing.JLabel();
        jCbox_dato = new javax.swing.JComboBox<>();
        jBut_inscribir = new javax.swing.JButton();
        jBut_Anular = new javax.swing.JButton();
        jBut_salir = new javax.swing.JButton();
        jL_listadoMaterias = new javax.swing.JLabel();
        jRadBut_inscripas = new javax.swing.JRadioButton();
        jRadBut_No_Inscscripta = new javax.swing.JRadioButton();
        jLabelfondo = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL_Inscripcion.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        jL_Inscripcion.setText("Formulario de Inscripción");
        getContentPane().add(jL_Inscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 240, 29));

        jTable_alumnos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable_alumnos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 630, 340));

        jL_Alumno.setText("Alumno");
        getContentPane().add(jL_Alumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 80, 25));

        jCbox_dato.setToolTipText("");
        getContentPane().add(jCbox_dato, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 157, 25));

        jBut_inscribir.setText("Inscribir");
        getContentPane().add(jBut_inscribir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 600, -1, -1));

        jBut_Anular.setText("Anular Inscripción ");
        getContentPane().add(jBut_Anular, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 600, -1, -1));

        jBut_salir.setText("Salir");
        getContentPane().add(jBut_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 600, -1, -1));

        jL_listadoMaterias.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        jL_listadoMaterias.setText("Listado de Materias");
        getContentPane().add(jL_listadoMaterias, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, 27));

        jRadBut_inscripas.setText("Inscriptas");
        jRadBut_inscripas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadBut_inscripasActionPerformed(evt);
            }
        });
        getContentPane().add(jRadBut_inscripas, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 96, -1));

        jRadBut_No_Inscscripta.setText("No Inscriptas");
        getContentPane().add(jRadBut_No_Inscscripta, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, -1, -1));
        getContentPane().add(jLabelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 699, 606));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadBut_inscripasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadBut_inscripasActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jRadBut_inscripasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBut_Anular;
    private javax.swing.JButton jBut_inscribir;
    private javax.swing.JButton jBut_salir;
    private javax.swing.JComboBox<String> jCbox_dato;
    private javax.swing.JLabel jL_Alumno;
    private javax.swing.JLabel jL_Inscripcion;
    private javax.swing.JLabel jL_listadoMaterias;
    private javax.swing.JLabel jLabelfondo;
    private javax.swing.JRadioButton jRadBut_No_Inscscripta;
    private javax.swing.JRadioButton jRadBut_inscripas;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_alumnos;
    // End of variables declaration//GEN-END:variables
}
