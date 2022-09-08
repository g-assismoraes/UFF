package uff.ic.lleme.tcc00328.s20202.prova.p2.GabrielAssis.questao2;

public class Acumulador {
    private double soma = 0f;
    
    public synchronized void acumula(double num){
        this.soma += num;
    }
    
    public synchronized double getSoma(){
        return this.soma;
    }

}
