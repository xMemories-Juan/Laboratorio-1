/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.Conexion;
import data.AlumnoData;
import java.util.List;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Colegio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        
     Conexion conexion = new Conexion(); 
         
        Connection cn = conexion.getConexion();
        
         AlumnoData ad=new AlumnoData(conexion);
        Alumno pepe=new Alumno("Leticia","Moreira",LocalDate.of(1973, Month.MARCH, 12),2344553,true);
        
        if(ad.agregarAlumno(pepe)){
        
            JOptionPane.showMessageDialog(null, "Alumno Agregado Exitosamente");
        }

        
        List<Alumno> lista=ad.obtenerAlumnos();
        
        for(Alumno alu:lista){
        
            System.out.println("dni "+alu.getDni());
            System.out.println("apellido "+alu.getApellido());
            System.out.println("nombre "+alu.getNombre());
        }
        /*System.out.println("-------------Buscamos por id----------------");
        Alumno aEncontrado=ad.obtenerAlumnoXId(3);
        if(aEncontrado!=null){
        System.out.println("Apellido "+aEncontrado.getApellido());
        }else {
        
            System.out.println("Alumno no existe");
        }
        
        System.out.println("-------------Modificamos apellido--------------");
        //aEncontrado.setApellido("Zarate");
        
        //ad.modificarAlumno(aEncontrado);
        System.out.println("-------------Borrar alumno--------------");
        //ad.borrarAlumno(3);
                    
    */
}

    
   
}