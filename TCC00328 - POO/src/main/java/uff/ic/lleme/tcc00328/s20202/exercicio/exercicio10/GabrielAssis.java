package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio10;

import java.util.Scanner;

public class GabrielAssis {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.println("Digite o número de termos da série para definir a precisão de PI:");

        int n = ler.nextInt();
        double somatorio = serie(n);
        double pi = 4 * somatorio;

        System.out.println("Com essa precisão, somatório = " + somatorio + ", acarretando em PI ~= " + pi);
    }

    public static double serie(int n) {
        double somatorio = 0.0;

        for (int i = 0; i <= n - 1; i++)
            somatorio += Math.pow(-1, i) / (2 * i + 1);

        return somatorio;
    }
}
