/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreramortal;

/**
 *
 * @author mseba
 */
public class Rueda {
    private String marca;
    private double presion = 28;
    

    public Rueda(String marca) {
        this.marca = marca;
        
    }
    
    public void inflar(){
        this.presion=28;
        System.out.println("Rueda inflada, la presion actual es " + this.presion);
    }
    
    public void desinflar(){
        this.presion-= 0.5;
        System.out.println("Rueda desinflada, La presion actual es " + this.presion);
    }
    public void pinchar(){
        this.presion = 0;
        System.out.println("Rueda pichada, la presion actual es"+ this.presion);
    }
}
