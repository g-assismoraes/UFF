package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio3;

import java.util.Scanner;

public class GabrielAssis {

    public static void main(String[] args) {
        System.out.println("Digite 2 inteiros para se calcular o seu MDC: ");

        Scanner ler = new Scanner(System.in);
        int num1 = ler.nextInt();
        int num2 = ler.nextInt();

        int mdc = calculaMDC(num1, num2);
        System.out.println("O MDC entre " + num1 + " e " + num2 + " é: " + mdc);
    }

    public static int calculaMDC(int n1, int n2) {
        int resto;

        while (n2 != 0) {
            resto = n1 % n2;
            n1 = n2;
            n2 = resto;
        }
        return n1;
    }
}
