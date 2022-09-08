package uff.ic.lleme.tcc00328.s20202.exercicio.ThreadMedia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Main {
    
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        List<Float> valores = new ArrayList<>();
        
        for(int i = 0; i < 20; i++){
            valores.add(ler.nextFloat());
        }
        
        Acumulador acumulador = new Acumulador();
        ForkMean fb = new ForkMean(valores, acumulador);
        ForkJoinPool pool = new ForkJoinPool();
        
        pool.invoke(fb);
        
        System.out.println(">>> " + acumulador.getSoma()/valores.size());
    }
}
