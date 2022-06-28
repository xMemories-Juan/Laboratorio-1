/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import control.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.Cursada;
import modelo.Materia;

/**
 *
 * @author saimon
 */
public class InscripcionData {
     private Connection con = null;     
    private AlumnoData alumData;
    private MateriaData materiaData;

    public InscripcionData(Conexion conexion) {
       
            this.con = conexion.getConexion();
            this.alumData=new AlumnoData(conexion);
            this.materiaData=new MateriaData(conexion);            
        
    }
    
   public boolean verificarCursada(int idMateria, int idAlumno) {        //con esto verifico qie un alumno no este inscripto en una materia dos veces
        boolean res = false;       
        String comprueba = "SELECT * FROM cursada WHERE idMateria =? AND idAlumno=?;";
        try{
            PreparedStatement pstm = con.prepareStatement(comprueba);  
            pstm.setInt(1,idMateria);
            pstm.setInt(2,idAlumno);
            ResultSet rs = pstm.executeQuery();        
            if(rs.next())
                res = true;
            pstm.close(); 
            
        } catch(Exception e){
            System.err.print("Ha ocurrido un error: ");
        }                
        return res;
    } 
     
        
    public boolean  guardarInscripcion(Cursada inscripcion) { // no debe dejar inscribir a un alumno en una misma materia 
        boolean insc=false;   
        
        try {        
            String sql = "INSERT INTO CURSADA (idAlumno, idMateria, nota) VALUES ( ? , ? , ? );";   
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);                     
            ps.setInt(1, inscripcion.getAlumno().getIdAlumno());
            ps.setInt(2, inscripcion.getMateria().getIdMateria());
            ps.setDouble(3, inscripcion.getNota());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                inscripcion.setIdCursada(rs.getInt("id"));
                JOptionPane.showMessageDialog(null, "Se inscribió al alumno correctamente");
               insc=true;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar Inscripción");
            }
            ps.close();
                              
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El alumno ya está inscripto en esta materia " + ex.getMessage());
        }
        return insc;
    }
    
    
    public List<Cursada> obtenerInscripciones() {
        ArrayList<Cursada> inscripciones = new ArrayList();
        try {
            String sql = "SELECT * FROM cursada;";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet resultSet = ps.executeQuery();
            Cursada inscripcion;
            while (resultSet.next()) {
                inscripcion = new Cursada();
                inscripcion.setIdCursada(resultSet.getInt("id"));
                Alumno a = alumData.obtenerAlumnoXId(resultSet.getInt("idAlumno"));
                inscripcion.setAlumno(a);
                Materia m = materiaData.obtenerMateriaXid(resultSet.getInt("idMateria"));               
                inscripcion.setMateria(m);
                inscripcion.setNota(resultSet.getDouble("nota"));
                inscripciones.add(inscripcion);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener las inscripciones: " + ex.getMessage());
        }

        return inscripciones;
    }
    
    public boolean actalizarNota(Alumno alumno, Materia materia, double nota){
         String sql="UPDATE cursada SET nota = ? WHERE idAlumno = ? AND idMateria=?";
         boolean modificado=false;
         
         try {
             PreparedStatement ps= con.prepareStatement(sql);
             ps.setDouble(1, nota);
             ps.setInt(2,alumno.getIdAlumno());
             ps.setInt(3,materia.getIdMateria()); 
             
             if(ps.executeUpdate()!=0){
             
                 modificado=true;
             }
             ps.close();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error de sintaxis ");
         }
     return modificado;      
       
    }
    /*Funcionalidades que faltarían:
Borrar una cursada (delete)
Dado un alumno nos devuelva las materias en las que está inscripto
Dado un alumno nos devuelva las materias en las que NO está inscripto
Dada una materia nos devuelva los alumnos inscriptos en ella.*/

public boolean borrarCursada(int idA, int idM){
     String sql="DELETE * FROM cursada WHERE idAlumno= ? AND idMateria=?";
     boolean borrada=false;
     
     try {
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setInt(1, idA);
        pstm.setInt(2,idM);
     
       
        if(pstm.executeUpdate()!=0){
            borrada= true;            
        }
        pstm.close();        
        
    } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, "Error con el id no se pudo eliminar el elemento ");
    }
     
     return borrada;
}  


public List<Materia> obtenerMateriasCursadas(int idA){
    List<Materia> materias = new ArrayList<Materia>();
    
    try        
    {
        String sql = "SELECT idMateria,nombre "
                + "FROM cursada, materia"
                + " WHERE cursada.idMateria = materia.idMateria"
                + " AND cursada.idAlumno ="+idA;
              
        PreparedStatement pstm = con.prepareStatement(sql);
          ResultSet resultSet = pstm.executeQuery();
        Materia materia;
        while(resultSet.next()){
           materia = new Materia();
           materia.setIdMateria(resultSet.getInt("idMateria"));
           materia.setNombre(resultSet.getString("nombre"));
           materia.setIdMateria(resultSet.getInt("idMateria"));
           materia.setAnio(resultSet.getInt("anio"));
           materia.setActivo(resultSet.getBoolean("activo"));
           materias.add(materia);       
         }
         pstm.close();        
        
    } catch (SQLException e) {
          JOptionPane.showMessageDialog(null,"Error al obtener listado de materias");
    }    
    
   return materias; 
}

    
   public List <Materia> obtenerMarteriasNoCursadas(int idA) {        
        
       ArrayList<Materia> noCursadas = new ArrayList<Materia>();                  
      
     //String comprueba = "SELECT * FROM cursada JOIN materia ON cursada.idMateria = materia.idMateria  WHERE cursada.idAlumno =?"+idA;
     
     String comprueba = "SELECT * FROM materia WHERE idMateria NOT IN (SELECT idMateria FROM cursada WHERE idAlumno =" +idA+")";    
             
       try {
           PreparedStatement pstm = con.prepareStatement(comprueba);             
            ResultSet rs = pstm.executeQuery();  
            Materia materia;
            while(rs.next()){
            materia = new Materia();  
            materia.setIdMateria(rs.getInt("idMateria"));
            materia.setNombre(rs.getString("nombre"));
            materia.setAnio(rs.getInt("anio"));
            materia.setActivo(rs.getBoolean("activo"));
            noCursadas.add(materia);               
            }
               pstm.close(); 
           
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"error al obtener la Lista");
       }
       
                  
       return noCursadas;
    } 
   /*Dada una materia nos devuelva los alumnos inscriptos en ella.*/
   
   public List <Alumno> obtenerAlumnoMateria(int idMateria){
      ArrayList<Alumno> alumnosMat = new ArrayList<Alumno>();
      
      String sql = "SELECT * FROM cursada JOIN alumno ON cursada.idAlumno = alumno.idAlumno WHERE cursada.idMateria ="+idMateria;
       
       try {
           PreparedStatement pstm = con.prepareStatement(sql);
           ResultSet rs = pstm.executeQuery();
           Alumno alumno;
           while(rs.next()){
           alumno = new Alumno();  
           alumno.setIdAlumno(rs.getInt("idAlumno"));
           alumno.setNombre(rs.getString("nombre"));
           alumno.setApellido(rs.getString("apellido"));
           alumno.setDni(rs.getLong("dni"));          
           alumno.setFechNac(rs.getDate("fechNac").toLocalDate());          
           alumnosMat.add(alumno);
           }          
           pstm.close();
           
       } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error al obtener la Lista de Alumnos");
       }
      
      return alumnosMat;   
   
   }   
   
    }
     
     
     

 
         
   