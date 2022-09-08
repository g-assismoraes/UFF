package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio12;

import java.util.Scanner;

public class GabrielAssis {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.println("Digite um número para saber os seus divisores:");
        int num = ler.nextInt();

        imprime_divisores(num);
    }

    public static void imprime_divisores(int n) {
        System.out.print("Os divisores de " + n + " são: ");
        int i;
        for (i = 1; i < n; i++)
            if (n % i == 0)
                System.out.print(i + ", ");
        System.out.println(i);
    }
}
