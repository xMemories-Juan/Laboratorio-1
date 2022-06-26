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
import modelo.Alumno;
import java.util.List;
import modelo.Cursada;
import modelo.Materia;

/**
 *
 * @author saimon
 */
public class CursadaData {
    
    
    
    private Connection con = null;
    private AlumnoData alumData;
    private MateriaData materiaData;
  
    
    
    
    
  
    public CursadaData(Conexion conexion) {
      
            con = conexion.getConexion();
            this.alumData=new AlumnoData(conexion);
            this.materiaData=new MateriaData(conexion);
        
    }
    
    
    
    
    
    
    
    
    
    public boolean agregarCursada(Cursada cursada) {

        boolean insert = true;        
        String sql = "INSERT INTO cursada (alumno, materia, nota)  VALUES (?, ?, ?)";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);            
            ps.setString(1, cursada.getAlumno().getNombre());
            ps.setString(2, cursada.getMateria().getNombre());
            ps.setDouble(3, cursada.getNota());          
            ps.executeUpdate();            
            ResultSet rs = ps.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, " Se agregó la cursada " + cursada + " correctamente");
            
            if (rs.next()) {
                
                cursada.setIdCursada(rs.getInt(1));
            } else {
               JOptionPane.showMessageDialog(null, "Error al intentar agregar la cursada");
                insert = false;
            }

            ps.close();
            
            
            
        } catch (SQLException ex) {
            
            insert=false;
            
            if(ex instanceof java.sql.SQLIntegrityConstraintViolationException){
                JOptionPane.showMessageDialog(null, "Ya existe un alumno con ese dni " );
                
            }else {
            
                JOptionPane.showMessageDialog(null, "Error de sintaxis "+ex );
                
            }
            

        }
        return insert;
    }
    
    
    
    
    
    
    
    
    
  
    
    
    
    
    
     public List<Cursada> obtenerCursadas() {
         
        ArrayList<Cursada> cursadas = new ArrayList<Cursada>();

        try {
            
            String sql = "SELECT * FROM cursada;";
            PreparedStatement ps = con.prepareStatement(sql);        
            ResultSet resultSet = ps.executeQuery();            
            Cursada cursada = null;
            
            while (resultSet.next()) {
                
                cursada = new Cursada();
                cursada.setIdCursada(resultSet.getInt("id"));
                
                Alumno  alu = alumData.obtenerAlumnoXId(resultSet.getInt("idAlumno"));
                cursada.setAlumno(alu);
                
                Materia materia = new Materia();
                Materia m = materiaData.obtenerMateriaXId(resultSet.getInt("idMateria"));
                cursada.setMateria(m);
                cursada.setNota(resultSet.getDouble("nota"));
                
                cursadas.add(cursada);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al obtener cursada    ");
        }

        return cursadas;
    }
    
     
    
    
    
    
    
    
    
      /*
    
    
    
    
     
     
public List<Cursada> obtenerCursadasXAlumno() {
         

             return cursadas;
    }
     
     
     
     
    
    
    
    
    
    
    
    
    
    
    
    
    
public Alumno regenerarAlumno(String nombre) {
         

             return alumno;
    }
     
    
     
public Materia  regenerarMateria(String nombre){
         

             return materia;
    }
      
    
    
    
    
    
    
    
    
    
public List<Materia> obtenerMateriaCursadas(String nombre) {
    
         String sql = "SELECT materia FROM cursada WHERE activo = 1;";

             return materias;
    }
     
    
    
    
    
    
    
    
public List<Materia> obtenerMateriaNOCursadas(String nombre) {
         

             return materias;
    }  
    
    
    
    
    
    
    
    
    
    
    
 public boolean borrarCursadaDeUnaMateriaDeUnAlumno() {
         
            String sql= "DELETE FROM cursada WHERE alumno = ?";

             return borrada;
    }  
    
       
    
    
    
    
    
    
public boolean actualizarNotaCursada() {
         

             return actualizada;
    }  
    
    
    
    
    
    
    
     */
     
     /*   
     
     agregarCursada()
     obtenerCursada()
     obtenerCursadasXAlumno()
     regenerarAlumno()
     regenerarMateria()
     obtenerMateriaCursadas()
     obtenerMateriaNOCursadas()
     borrarCursadaDeUnaMateriaDeUnAlumno()
     actualizarNotaCursada()
     
     */
     
     
     
} // final
