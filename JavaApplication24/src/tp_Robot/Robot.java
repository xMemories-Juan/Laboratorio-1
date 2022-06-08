
package tp_Robot;

import javax.swing.JOptionPane;

public class Robot {
    
    private double bateria = 1000;
    private Boolean despierto = true;


    public void avanzar(int cantPaso){
        if ( despierto){
            if (bateria >= cantPaso /10){
                bateria -= cantPaso/10;
               // System.out.println("Avanzo " + cantPaso + "Pasos");
                JOptionPane.showMessageDialog(null, "Avanzó " + cantPaso + "Pasos");
                //System.out.println("Energia Restante "+ bateria);
                 JOptionPane.showMessageDialog(null, "Energia Restante "+ bateria);
            } else {
               // System.out.println( "Energia insuficiente");
                 JOptionPane.showMessageDialog(null,  "Energia insuficiente");
            }  
        }else {
            //System.out.println("No se puede Avanzar, esta dormido");
            JOptionPane.showMessageDialog(null, "No se puede Avanzar, esta dormido");
        }
    }
    
    public void retroceder (int cantPaso){
         JOptionPane.showMessageDialog(null, "Retrocediendo");//al usar Avanzar (retroceder no puede mostrar sus carteles)
        avanzar(cantPaso);
                
    }
    
    public void dormir(){
        if(despierto){
            despierto = false;
        }else {
            //System.out.println("Esta Dormido");
             JOptionPane.showMessageDialog(null, "Esta Dormido");
        }
    }
    
    public void despertar(){
        if( !despierto){
            despierto = true;
        } else{
            //System.out.println("Esta Despierto");
             JOptionPane.showMessageDialog(null, "Esta Despierto");
        }
    }
    
    public void recargar(){
        bateria=1000;//faltaba el llenado de la bateria
       // System.out.println("Bateria cargada");
         JOptionPane.showMessageDialog(null, "Bateria cargada");
    }
    
    public boolean bateriaLlena(){   
       
        return bateria == 1000;
        
       }
    
    public boolean bateriaVacia(){
        
        return bateria == 0;
    }
    
    public double enrgiaAcual(){
        return bateria;    
    }
    
    
    
}
