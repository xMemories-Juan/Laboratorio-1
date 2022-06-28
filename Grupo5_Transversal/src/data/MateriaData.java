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
import modelo.Materia;

/**
 *
 * @author saimon
 */
public class MateriaData {
 
private Connection con = null;

    public MateriaData(Conexion conexion) {
      con = conexion.getConexion();
    }
    
public boolean agregarMateria(Materia materia){    
boolean insert= true;

String sql ="INSERT INTO MATERIA( nombre, anio, activo) VALUES (?, ?, ?)";

    try {        
          PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
       
       ps.setString(1, materia.getNombre());
       ps.setInt(2,materia.getAnio());
       ps.setBoolean(3,materia.isActivo());       
       ps.executeUpdate();
       
        ResultSet rs = ps.getGeneratedKeys();
        
       JOptionPane.showMessageDialog(null, " Se agregó la materia " + materia + " correctamente");  
        if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
            } else {
               JOptionPane.showMessageDialog(null, "Error al intentar agregar una materia");
                insert = false;
            }
      ps.close();     
       
       
    } catch (SQLException e) {
         insert=false;
            if(e instanceof java.sql.SQLIntegrityConstraintViolationException){
                JOptionPane.showMessageDialog(null, "Ya existe una materia con esos datos" );
            }else {
            
                JOptionPane.showMessageDialog(null, "Error de sintaxis "+e );
                
            }            
        
        
    }
    return insert;  
  }

public List<Materia> obtenerMaterias(){
        ArrayList<Materia> materias = new ArrayList<Materia>();
        try {
            String sql = "SELECT * FROM materia WHERE activo = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet resultSet = ps.executeQuery();
            Materia materia;
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


public Materia obtenerMateriaXid(int id){
Materia materia = null;

    try {        
        String sql = "SELECT * FROM materia WHERE idMateria = ? AND activo = 1";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet resultSet = ps.executeQuery();
        
        while (resultSet.next()){
        materia = new Materia();
        materia.setIdMateria(resultSet.getInt("idMateria"));
        materia.setNombre(resultSet.getString("nombre"));
        materia.setAnio(resultSet.getInt("anio"));
        materia.setActivo(resultSet.getBoolean("activo"));      
        }
       ps.close();  
      } catch (SQLException ex) {
    JOptionPane.showMessageDialog(null,"Error al obtener materia");
    }      

 return materia;
    
}

public boolean borrarMateria(int id){
 boolean borrada=false;
 
 String sql = "UPDATE alumno SET activo = 0 WHERE idMateria = ?";
 
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
    if(ps.executeUpdate()!=0){        
        borrada = true;        
    }    
    ps.close();
        
    } catch (SQLException e) {
    JOptionPane.showMessageDialog(null,"Error de sintaxis ");
    }
     return borrada;
}

public boolean modificarMateria(Materia materia){
  boolean modificado = false;
String sql = "UPDATE MATERIA SET nombre=?, anio = ?, activo =? WHERE idMateria= ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,materia.getNombre());
        ps.setInt(2, materia.getAnio());
        ps.setBoolean(3, materia.isActivo());
        ps.setInt(4, materia.getIdMateria());
        
     if(ps.executeUpdate()!= 0){
         modificado= true;         
     }   
      ps.close();       
        
    } catch (Exception e) {
     JOptionPane.showMessageDialog(null,"Error de sintaxis");
    }
return modificado;  
}

}