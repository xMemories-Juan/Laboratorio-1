/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas;


import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.HashSet;
import java.util.List;

import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import data.MateriaData;

import modelo.Alumno;
import modelo.Colegio;
import modelo.Materia;

import control.Conexion;
import java.util.ArrayList;
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
    // DefaultTableModel model = new DefaultTableModel();
    private DefaultTableModel modelo;
            
    public Form_Inscripcion(HashSet<Alumno> todosLosAlumnos, HashSet<Materia> todasLasMaterias) {
        
        initComponents();
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        initComponents();
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                
        modelo = new DefaultTableModel();
        
        armarCabecera();
        llenarTabla();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        
        try {
           // PreparedStatement pst = gt.prepareStatement("select idAlumno, nombre, apellido, materia");
           // ResultSet rs = pst.executeQuery();
           
            Conexion conexion = new Conexion(); 
            Connection cn = conexion.getConexion();
            MateriaData md = new MateriaData(conexion);
            List<Materia> lista_materias = md.obtenerMaterias();
            
            
            JTable table  = new JTable(data, columnNames);
            // jTable_alumnos.setValueAt(lista_materias,1,1);
            System.out.println("2222" + data);
           
            
        } catch (Exception e) {
            System.out.println("3333333333" + e);
        }
        */
        
    }

    
    
    
    
    
    @Override
    public String toString() {
        return "Form_Inscripcion{" + "jTab_alumno=" +  table + '}';
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
        table = new javax.swing.JTable();
        jL_Alumno = new javax.swing.JLabel();
        jCbox_dato = new javax.swing.JComboBox<>();
        jBut_inscribir = new javax.swing.JButton();
        jBut_Anular = new javax.swing.JButton();
        jBut_salir = new javax.swing.JButton();
        jL_listadoMaterias = new javax.swing.JLabel();
        jRadBut_inscripas = new javax.swing.JRadioButton();
        jRadBut_No_Inscscripta = new javax.swing.JRadioButton();
        jLabelfondo = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(715, 780));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL_Inscripcion.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        jL_Inscripcion.setText("Formulario de Inscripción");
        getContentPane().add(jL_Inscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 500, 29));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código Id", "Materia", "Año"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setHeaderValue("Código Id");
            table.getColumnModel().getColumn(1).setHeaderValue("Materia");
            table.getColumnModel().getColumn(2).setHeaderValue("Año");
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 630, 280));

        jL_Alumno.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        jL_Alumno.setText("Alumno");
        getContentPane().add(jL_Alumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 90, 25));

        jCbox_dato.setToolTipText("");
        getContentPane().add(jCbox_dato, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 157, 25));

        jBut_inscribir.setText("Inscribir");
        getContentPane().add(jBut_inscribir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 130, 60));

        jBut_Anular.setText("Anular Inscripción ");
        getContentPane().add(jBut_Anular, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 610, 130, 60));

        jBut_salir.setText("Salir");
        getContentPane().add(jBut_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 610, 130, 60));

        jL_listadoMaterias.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        jL_listadoMaterias.setText("Listado de Materias");
        getContentPane().add(jL_listadoMaterias, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, -1, 27));

        jRadBut_inscripas.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        jRadBut_inscripas.setText("Inscriptas");
        jRadBut_inscripas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadBut_inscripasActionPerformed(evt);
            }
        });
        getContentPane().add(jRadBut_inscripas, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 180, -1));

        jRadBut_No_Inscscripta.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        jRadBut_No_Inscscripta.setText("No Inscriptas");
        getContentPane().add(jRadBut_No_Inscscripta, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, -1, -1));
        getContentPane().add(jLabelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 699, 606));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadBut_inscripasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadBut_inscripasActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jRadBut_inscripasActionPerformed

    
    
    
    
    
    
    
    private void armarCabecera() {                 
    
    
        ArrayList<Object> columnas = new ArrayList<Object>();
        columnas.add("Código Id");
        columnas.add("Materiass");
        columnas.add("Año");
       
        
        for(Object it : columnas) {
        modelo.addColumn(it);
        
        }
        table.setModel(modelo);
        
    }         
        








    
private void llenarTabla() {                 
    
            Conexion conexion = new Conexion(); 
            Connection cn = conexion.getConexion();
            MateriaData md = new MateriaData(conexion);
            List<Materia> lista_materias = md.obtenerMaterias();
            
            lista_materias.forEach((it) -> {
                modelo.addRow(new Object [] {it.getIdMateria(), it.getNombre(), it.getAnio()});
        });
 
    }    









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
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
