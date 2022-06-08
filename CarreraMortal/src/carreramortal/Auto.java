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
public class Auto {
    
   private String color, patente;
    private double combustible = 50;
    private Rueda[] ruedas = new Rueda[4];

    
    public Auto(String color, String patente, String marcaR1, String marcaR2, String marcaR3, String marcaR4){
        this.color = color;
        this.patente = patente;
        this.ruedas[0]= new Rueda(marcaR1);
        this.ruedas[1]= new Rueda(marcaR2);
        this.ruedas[2]= new Rueda(marcaR3);
        this.ruedas[3]= new Rueda(marcaR4);
        
    }

    public Auto() {
    }
        
    

    public Rueda[] getRuedas() {
        return ruedas;
    }
  
  
    public void avanzar(double distanciaM){
        if(combustible>= (distanciaM/10)){
            combustible -= distanciaM/10;
            System.out.println("Se avanzaron "+ distanciaM+ " metros");
            System.out.println("quedan "+ this.combustible + "litros");
        }
        else{
            System.out.println("No hay combustible");
        }
    }
     public void retroceder(double distanciaM){
        if(combustible>= (distanciaM/10)){
            combustible -= distanciaM/10;
             System.out.println("Se retrocedieron "+ distanciaM+ " metros");
             System.out.println("quedan "+ this.combustible + "litros");
        }
        else{
            System.out.println("No hay combustible");
        }
    }
     public void llenarTanque(){
         this.combustible=50;
         System.out.println("Tanque lleno");
     }
}
