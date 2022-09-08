package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio13;

import java.util.Scanner;

public class GabrielAssis {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.println("Digite a quantidade de números que serão computados: ");
        int qtd_valores = ler.nextInt();

        float acumulador = 0f;
        for (int i = 0; i < qtd_valores; i++)
            acumulador += ler.nextFloat();

        System.out.println("A média calculada é: " + acumulador / qtd_valores);
    }
}
