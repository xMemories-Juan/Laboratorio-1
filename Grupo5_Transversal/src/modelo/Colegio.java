/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.Conexion;
import data.AlumnoData;
import data.InscripcionData;
import data.MateriaData;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.JOptionPane;
import vistas.Inscripcion;

/**
 *
 * @author Usuario
 */
public class Colegio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here        
     Conexion conexion = new Conexion(); 
         
        Connection cn = conexion.getConexion();
       MateriaData ad = new MateriaData(conexion);
        
       /*Materia ingles = new Materia("Ingles",1,true);
       if(ad.agregarMateria(ingles)){
           JOptionPane.showMessageDialog(null,"Materia agreada con exito");
       }*/
       AlumnoData add= new AlumnoData(conexion);
       
       //Alumno juan = new Alumno("Juan","Pardo",LocalDate.of(1988, Month.MARCH, 10),3344553,true);
      // if(add.agregarAlumno(juan)){
       //    JOptionPane.showMessageDialog(null,"Alumno agreado con exito");
      // }
       
         
     
      
      InscripcionData ins = new InscripcionData(conexion);  /*
       //   ins.borrarCursada(1);   //borrado de materia
       int numMat =1;
       int numAlum =4;
       if(ins.verificarCursada(numMat,numAlum)){            //idMateria y luego IdAlumno
         JOptionPane.showMessageDialog(null," El alumno ya esta inscripto");  
       }else{
            JOptionPane.showMessageDialog(null," inscribiendo alumno "); 
              Alumno alum = add.obtenerAlumnoXId(numAlum);   //debe coincidir con el alumno a cosultar           
              Materia mat = ad.obtenerMateriaXid(numMat);   //debe coincidir con la materia 
              Cursada cr= new Cursada(alum,mat,7);                  //modifica nota
              ins.guardarInscripcion(cr);
       };*/

           
      
        
        //List<Cursada> listado = ins.obtenerInscripciones();
        
        //for(Cursada curs : listado){
        
         //   System.out.println("nombre "+curs.getAlumno());
        //    System.out.println("materia "+curs.getMateria());
       //     System.out.println("nota "+curs.getNota());
       // }
        
         /*List<Cursada> listado = ins.cursadaXAlumno(3);//le paso el ID del alumno y me devuelve el id de las materias
       
         for(Cursada cr : listado){
             System.out.println("Id Materia "+cr.getIdCursada());
             
         }*/
       
       
        
        /* AlumnoData ad=new AlumnoData(conexion);
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
         
      /*List<Materia> lista= ins.obtenerMarteriasNoCursadas(1);
        
        for(Materia cur: lista){
        
            System.out.println("id "+cur.getIdMateria());
            System.out.println("id "+cur.getNombre());
            System.out.println("id "+cur.getAnio());
        } */
     
      List<Alumno> listas= ins.obtenerAlumnoMateria(2);
        
        for(Alumno cur: listas){
        
            System.out.println("Apellido:"+cur.getApellido()+" Nombre: "+cur.getNombre()+" DNI: "+cur.getDni());
            
        } 
       
        
      
        
}

    
   
}