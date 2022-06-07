
package tp_Robot;

import java.util.Scanner;



public class Hombre {
    private String nombre;

    public Hombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void jugarConRobot(Robot robot){
        robot.avanzar(500);
        robot.retroceder(20);
        robot.enrgiaAcual();
        robot.dormir();
    }
    
//      public void jugarConRobot(Robot robot){
//          Scanner sc = new Scanner(System.in);
//          
//          switch (option) {
//              case 1:
//                  
//          }
//      }
}
