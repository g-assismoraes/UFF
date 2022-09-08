package uff.ic.lleme.tcc00328.s20202.exercicio.ThreadMedia;


public class Acumulador {
    private float soma = 0f;
    
    public synchronized void acumula(float num){
        this.soma += num;
    }
    
    public float getSoma(){
        return this.soma;
    }
            
}
