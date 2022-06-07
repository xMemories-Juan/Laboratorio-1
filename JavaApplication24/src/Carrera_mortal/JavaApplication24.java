
package Carrera_mortal;

import java.util.Scanner;

public class JavaApplication24 {

    public static void main(String[] args) {
        int dis;
        
        Scanner sc = new Scanner(System.in);
        
        Auto a1 = new Auto();
        
        a1.modAuto();
        
        System.out.println("Ingrese la distancia a avanzar");
        dis = sc.nextInt();
        a1.avanzar(dis);
        
        System.out.println("Cuanto desea retroceder");
        dis = sc.nextInt();
        
        a1.retroceder(dis);
    }
    
}
