
package tp_Robot;

import java.util.Scanner;
import javax.swing.JOptionPane;



public class Hombre {
    private String nombre;

    public Hombre(String nombre) {
        this.nombre = nombre;
    }
    
//    public void jugarConRobot(Robot robot){
//        robot.avanzar(500);
//        robot.retroceder(20);
//        robot.enrgiaAcual();
//        robot.dormir();
//    }
    
 public void jugarConRobot(Robot robot){
  //Scanner sc = new Scanner(System.in);
    int entrada;  
    
    do{                 
        try {
            entrada = Integer.parseInt(JOptionPane.showInputDialog( "Seleccione una opción:\n1. Avanzar\n2.Retroceder\n"
                + "3. Dormir\n4. Despertar\n5. Recargar\n6. Bateria LLena\n7. Bateria Vacia\n8. Energia Actual\n9. Salir del programa" ));
            
        } catch (NumberFormatException e) {           
            entrada = 9;
        }                 
              
        
        switch (entrada){
            case 1:         
                   
                    robot.avanzar(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de paso")));
            break;
            case 2:
                   robot.retroceder(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de paso")));
            break;
            case 3:  
                 robot.dormir();
            break;
            case 4:
                 robot.despertar();
            break;
            case 5:
                robot.recargar();
            break;
            case 6:  
                
                if (robot.bateriaLlena()){
                JOptionPane.showMessageDialog(null,"Bateria Llena");
                }
                else{JOptionPane.showMessageDialog(null,"La Bateria no esta Llena");}
            break;
            case 7:
                if(robot.bateriaVacia()){
                
                JOptionPane.showMessageDialog(null,"Bateria Vacia");
                }
                else{ JOptionPane.showMessageDialog(null,"La bateria aun tiene carga");}
            break;
             case 8:
                int e = (int) robot.enrgiaAcual();
                JOptionPane.showMessageDialog(null,"Energia Actual "+e);
            break;
            case 9:
                //System.out.println("Ejecución finalizada");
                JOptionPane.showMessageDialog(null, "Ejecución finalizada");
                System.exit(0);
             break;
             
                                    
        }
        }while(entrada <= 9 || entrada > 1 ); 
    }        
    
    
    
       
}
