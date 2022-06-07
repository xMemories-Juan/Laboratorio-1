
package tp_Robot;

public class Robot {
    
    private double bateria = 1000;
    private Boolean despierto = true;


    public void avanzar(int cantPaso){
        if ( despierto){
            if (bateria >= cantPaso /10){
                bateria -= cantPaso/10;
                System.out.println("Avanzo " + cantPaso + "Pasos");
                System.out.println("Energia Restante "+ bateria);
            } else {
                System.out.println( "Energia insuficiente");
            }  
        }else {
            System.out.println("No se puede Avanzar, esta dormido");
        }
    }
    
    public void retroceder (int cantPaso){
        avanzar(cantPaso);
        System.out.println("");
    }
    
    public void dormir(){
        if(despierto){
            despierto = false;
        }else {
            System.out.println("Esta Dormido");
        }
    }
    
    public void despertar(){
        if( !despierto){
            despierto = true;
        } else{
            System.out.println("Esta Despierto");
        }
    }
    
    public void recargar(){
        bateria=1000;
        System.out.println("Bateria cargada");
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
