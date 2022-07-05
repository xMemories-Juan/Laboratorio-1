/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import control.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Materia;
import java.util.List;

/**
 *
 * @author saimon
 */
public class MateriaData {
    
    private Connection con = null;

  
  
    public MateriaData(Conexion conexion) {
      
            con = conexion.getConexion();
        
    }
    
    //////////////////////////////
    //////  crear en BD  ////// 
    //////////////////////////////
    
    // falta comprobación de duplicado, permite agregar 2 veces la misma Materia
    
    public boolean agregarMateria(Materia materia) {

        boolean insert = true;        
        String sql = "INSERT INTO Materia (nombre, anio, activo)  VALUES (?, ?, ?)";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);            
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isActivo());            
            ps.executeUpdate();            
            ResultSet rs = ps.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, " Se agregó la materia " + materia + " correctamente");
            
            if (rs.next()) {
                
                materia.setIdMateria(rs.getInt(1));
                
            } else {
                
               JOptionPane.showMessageDialog(null, "Error al intentar agregar la materia");
                insert = false;
            }

            ps.close();
            
        } catch (SQLException ex) {
            
            insert=false;
            
            if(ex instanceof java.sql.SQLIntegrityConstraintViolationException){
                JOptionPane.showMessageDialog(null, "Ya existe una materia con ese nombre " );
            }else {
            
                JOptionPane.showMessageDialog(null, "Error de sintaxis "+ex );
                
            }
            

        }
        return insert;
    }
    
    
    
    //////////////////////////////
    //////  leer de BD  ////// 
    //////////////////////////////
    
    
     public List<Materia> obtenerMaterias() {
         
        ArrayList<Materia> materias = new ArrayList<Materia>();

        try {
            
            String sql = "SELECT * FROM materia WHERE activo = 1;";
            PreparedStatement ps = con.prepareStatement(sql);        
            ResultSet resultSet = ps.executeQuery();            
            Materia  materia;
            
            while (resultSet.next()) {
                
                materia = new Materia();
                materia.setIdMateria(resultSet.getInt("idMateria"));

                materia.setNombre(resultSet.getString("nombre"));
                

                materia.setAnio(resultSet.getInt("anio"));
                materia.setActivo(resultSet.getBoolean("activo"));
                materias.add(materia);
            }
            ps.close();
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null,"Error al obtener alumnos");
            
        }

        return materias;
    }
    
    
   
     
     public Materia obtenerMateriaXId(int id){
     
        Materia materia = null;

        try {
            
            String sql = "SELECT * FROM materia WHERE idMateria = ? AND activo = 1;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                
                materia = new Materia();
                materia.setIdMateria(resultSet.getInt("idMateria"));
                materia.setNombre(resultSet.getString("nombre"));
                materia.setAnio(resultSet.getInt("anio"));
                materia.setActivo(resultSet.getBoolean("activo"));

            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al obtener alumnos");
        }

        return materia;
     }

    
    
      
     /*
    
    
     public Alumno obtenerMateriaXAnio(int dni){
     
        Alumno alumno=null;

        try {
            String sql = "SELECT * FROM alumno WHERE dni = ? AND activo = 1;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, dni);
            ResultSet resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(resultSet.getInt("idAlumno"));
                alumno.setApellido(resultSet.getString("apellido"));
                alumno.setNombre(resultSet.getString("nombre"));
                alumno.setFechNac(resultSet.getDate("fechNac").toLocalDate());
                alumno.setDni(resultSet.getLong("dni"));
                alumno.setActivo(resultSet.getBoolean("activo"));

            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al obtener alumnos");
        }

        return alumno;
     }
  
     
         
    //////////////////////////////
    //////  borrar en BD  ////// 
    //////////////////////////////
     
     public boolean borrarMateria(int id){
     
         boolean borrado=false;
         
         String sql= "UPDATE alumno SET activo = 0 WHERE idAlumno = ?";
         
         try {
             
             PreparedStatement ps= con.prepareStatement(sql);
             ps.setInt(1, id);
             
             if(ps.executeUpdate()!=0){
             
                 borrado=true;
             }
             ps.close();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error de sintaxis ");
         }
         
         
         return borrado;
     }
     
     */
     
     //////////////////////////////
    //////  modificar en BD  ////// 
    //////////////////////////////
     
     public boolean modificarMateria(Materia materia){     
       
         String sql = "UPDATE materia SET nombre = ?, anio= ?, activo=? WHERE idMateria = ?";
         boolean modificado=false;
     try {
             PreparedStatement ps= con.prepareStatement(sql);
             ps.setString(1, materia.getNombre());
             ps.setInt(2, materia.getAnio());
             ps.setBoolean(3, materia.isActivo());
             ps.setInt(4, materia.getIdMateria()); 
             
             if(ps.executeUpdate()!=0){
             
                 modificado=true;
             }
             ps.close();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error de sintaxis ");
         }
     return modificado;
     }   
    
     
     
     
     
     
     
} // final de class MateriaData
