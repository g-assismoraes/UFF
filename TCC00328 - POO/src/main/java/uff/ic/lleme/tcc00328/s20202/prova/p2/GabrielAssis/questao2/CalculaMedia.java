package uff.ic.lleme.tcc00328.s20202.prova.p2.GabrielAssis.questao2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class CalculaMedia {
    
    public static void main(String[] args){
        List<Double> valores = new ArrayList<>();
        
        for(int i = 0; i < 10000; i++){
            valores.add(Math.random() * 11);
        }
        
        Acumulador acumulador = new Acumulador();
        ForkMean fb = new ForkMean(valores, acumulador);
        ForkJoinPool pool = new ForkJoinPool();
        
        pool.invoke(fb);
        
        System.out.println("A média calculada é: " + acumulador.getSoma()/valores.size());
        
    }
}

