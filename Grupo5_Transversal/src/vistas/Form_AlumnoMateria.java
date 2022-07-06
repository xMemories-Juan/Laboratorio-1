/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import control.Conexion;
import data.AlumnoData;
import data.InscripcionData;
import data.MateriaData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.Cursada;
import modelo.Materia;

/**
 *
 * @author saimon
 */
public class Form_AlumnoMateria extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo;
    private AlumnoData alumnodata;
    private MateriaData materiaData;
    private ArrayList<Alumno> listaAlumnos;
    private ArrayList<Cursada> listaCursada;
    private ArrayList<Materia> listaMaterias;
    private InscripcionData cursadaData;
    private Conexion conexion;
    
    /**
     * Creates new form Form_Consultas
     */
    public Form_AlumnoMateria() {
        initComponents();
        conexion = new Conexion();
        modelo = new DefaultTableModel();
        
        cursadaData = new InscripcionData(conexion);
        listaCursada =(ArrayList)cursadaData.obtenerInscripciones();
        
        materiaData = new MateriaData(conexion);
        listaMaterias =(ArrayList)materiaData.obtenerMaterias();
        
        alumnodata = new AlumnoData(conexion);
        listaAlumnos = (ArrayList)alumnodata.obtenerAlumnos();
        
        cargarMateria();
        armarCabecera();
        cargaDatos();
        
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
        jLMateria = new javax.swing.JLabel();
        cbMateria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tAlumno = new javax.swing.JTable();
        jbsalir = new javax.swing.JButton();

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("                              Listado de Alumnos Por Materia");
        jLabel1.setToolTipText("");

        jLMateria.setText("Materia");

        cbMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMateriaActionPerformed(evt);
            }
        });

        tAlumno.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tAlumno);

        jbsalir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbsalir.setText("Salir");
        jbsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(cbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(jbsalir)
                .addGap(87, 87, 87))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMateriaActionPerformed
        // TODO add your handling code here:
        cargaDatos();
        
    }//GEN-LAST:event_cbMateriaActionPerformed

    private void jbsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsalirActionPerformed
        // TODO add your handling code here:
    dispose();
    }//GEN-LAST:event_jbsalirActionPerformed

    public void cargarMateria(){
    
        for(Materia item :listaMaterias){
        cbMateria.addItem(item);
        }
    }
    
     private void armarCabecera() {                
        
        ArrayList<Object> columnas = new ArrayList<Object>();
        columnas.add("Id");
        columnas.add("Nombre");       
        columnas.add("Notas");       
        
        for(Object it : columnas) {
        modelo.addColumn(it);        
        }
        tAlumno.setModel(modelo);
        
    }  
    
      private void borraFilasTabla(){
   if(modelo!=null){
       int a =modelo.getRowCount()-1;
           for(int i=a;i>=0;i--){   
                modelo.removeRow(i );
           }
    
}
}
 private void cargaDatos(){
   borraFilasTabla();
   
   Materia mat =(Materia)cbMateria.getSelectedItem();
   
   for(Cursada m : listaCursada){
   if(m.getMateria().getIdMateria()== mat.getIdMateria()){
     modelo.addRow(new Object[]{m.getAlumno().getIdAlumno(),m.getAlumno().getNombre(),m.getNota()});   
   }
   
   }
   }      
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Materia> cbMateria;
    private javax.swing.JLabel jLMateria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbsalir;
    private javax.swing.JTable tAlumno;
    // End of variables declaration//GEN-END:variables
}
