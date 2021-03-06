/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author saimon
 */
public class Cursada {
    
    
    
    
    
     private int idCursada;
     private Alumno alumno;
     private Materia materia;
     private double nota;

     
     
     
    public Cursada(int idCursada, Alumno alumno, Materia materia, double nota) {
        this.idCursada = idCursada;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    
    
    
    public Cursada(Alumno alumno, Materia materia, double nota) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    
    
    public Cursada() {
    }

   

    
    
    
    
    
    public int getIdCursada() {
        return idCursada;
    }

    public void setIdCursada(int idCursada) {
        this.idCursada = idCursada;
    }

    
    
    
    
    
    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    
    
    
    
    
    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    
    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    
    
    
    
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.idCursada;
        hash = 29 * hash + Objects.hashCode(this.materia);
        return hash;
    }

    
    
    
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cursada other = (Cursada) obj;
        if (this.idCursada != other.idCursada) {
            return false;
        }
        if (!Objects.equals(this.materia, other.materia)) {
            return false;
        }
        return true;
    }


    

    @Override
    public String toString() {
        return  alumno + ", materia = " + materia + ", nota = " + nota ;
    }
     
     
     
     
    
}
