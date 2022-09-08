package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio5;

import java.util.Scanner;

public class GabrielAssis {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.println("Digite a posição desejada da série de Fibonacci:");
        int pos = ler.nextInt();
        int fib = fibonacci(pos);

        System.out.println("O termo na posição " + pos + " é: " + fib);
    }

    public static int fibonacci(int pos) {
        if (pos == 0)
            return 0;
        else if (pos == 1)
            return 1;

        int aux1 = 1, aux2 = 1, aux3;
        while (pos - 2 > 0) {
            aux3 = aux1 + aux2;
            aux1 = aux2;
            aux2 = aux3;
            pos--;
        }
        return aux2;
    }
}
