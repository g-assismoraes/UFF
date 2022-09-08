package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio11;

public class GabrielAssis {

    public static void main(String[] args) {
        produtoPrimosNoIntervalo(1, 50);
    }

    public static void produtoPrimosNoIntervalo(int inicio, int fim) {
        long acumulador = 1;
        for (int i = inicio; i <= fim; i++)
            if (ehPrimo(i))
                acumulador *= i;
        System.out.println("O produto dos inteiros primos de " + inicio + " a " + fim + " é: " + acumulador);
    }

    public static boolean ehPrimo(int num) {
        boolean flag = false;
        int qtd_divisores = 0;

        for (int i = 1; i <= num; i++)
            if (num % i == 0)
                qtd_divisores += 1;

        if (qtd_divisores == 2)
            flag = true;

        return flag;
    }
}
