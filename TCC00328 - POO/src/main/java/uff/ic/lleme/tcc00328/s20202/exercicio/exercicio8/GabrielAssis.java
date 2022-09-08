package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio8;

import java.util.Scanner;

public class GabrielAssis {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.println("Digite um número para conferir se ele é primo: ");
        int num = ler.nextInt();
        boolean ehPrimo = confere(num);

        imprime(ehPrimo);
    }

    public static boolean confere(int num) {
        boolean flag = false;
        int qtd_divisores = 0;

        for (int i = 1; i <= num; i++)
            if (num % i == 0)
                qtd_divisores += 1;

        if (qtd_divisores == 2)
            flag = true;

        return flag;
    }

    public static void imprime(boolean flag) {
        if (flag)
            System.out.println("O número é primo!");
        else
            System.out.println("O número não é primo!!");
    }
}
