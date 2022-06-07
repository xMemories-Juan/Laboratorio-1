
package tp_Robot;



public class Main {

    public static void main(String[] args) {
        
        Hombre h1 =new Hombre("Pepe");
        Robot r1 = new Robot();
        
        h1.jugarConRobot(r1);
        
        Hombre h2 = new Hombre("raul");
        
        h2.jugarConRobot(r1);
        
        
        
    }
    
}
