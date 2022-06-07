/***
 *  Avanzar: Al que le indicaremos la cantidad de metros que deseamos
    avance y deberemos tener en cuenta que por cada 10 mts consume 1lt
    de combustible y solo podrá avanzar si hay combustible suficiente.
 */
package Carrera_mortal;

import java.util.Scanner;

public class Auto {
    private int id;
    private String patente;
    private String color;
    private int distancia;
    private int combustible = 50;
    
    public void modAuto(){
        Scanner sc =new Scanner(System.in);
        Scanner ss = new Scanner (System.in);
        System.out.println("Ingrese el ID del Auto");
        id= sc.nextInt();
        System.out.println("Ingrese la patente");
        patente = sc.next();
        System.out.println("Ingrese Color");
        color = ss.next();
        
    }
    
    public int avanzar(int distancia){        
        if (combustible >= distancia /10){
            combustible-= distancia/10;
            System.out.println("Avanzo " + distancia + "Mts");
        } else {
            System.out.println( "Combustible insuficiente");
        }
        
       return combustible;        
    }
    
    public void retroceder (int distancia){
        avanzar(distancia);
    }
    
    
}
