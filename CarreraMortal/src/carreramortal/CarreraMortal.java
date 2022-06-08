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
public class CarreraMortal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Auto auto = new Auto("rojo", "fiat", "Bridgestone","Bridgestone","Bridgestone","Bridgestone" );
        
        auto.avanzar(15);
        auto.retroceder(10);
        auto.avanzar(20);
        auto.avanzar(30);
        auto.avanzar(20);
        auto.llenarTanque();
        auto.avanzar(30);
        auto.getRuedas()[0].pinchar();
        auto.getRuedas()[1].desinflar();
        auto.getRuedas()[0].inflar();
    }
    
}
