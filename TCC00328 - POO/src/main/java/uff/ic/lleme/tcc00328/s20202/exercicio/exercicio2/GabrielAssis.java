package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio2;

import java.util.Scanner;

public class GabrielAssis {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite um número para que seja calculado o seu fatorial:");
        int num = ler.nextInt();
        long fat = fatorial(num);
        System.out.println(num + "! = " + fat);
    }

    public static long fatorial(int n) {
        long fat = 1; // fat basico de 0 e 1
        long aux = 2;

        while (aux <= n) {
            fat *= aux;
            aux++;
        }

        return fat;
    }
}
