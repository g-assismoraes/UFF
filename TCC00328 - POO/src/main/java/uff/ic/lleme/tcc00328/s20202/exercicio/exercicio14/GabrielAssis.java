package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio14;

import java.util.Scanner;

public class GabrielAssis {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.println("Digite a dimensão da matriz quadrada e em seguida os seus elementos: ");
        int dimensao = ler.nextInt();
        float[][] matriz = new float[dimensao][dimensao];

        for (int lin = 0; lin < dimensao; lin++)
            for (int col = 0; col < dimensao; col++)
                matriz[lin][col] = ler.nextFloat();

        float det = determinante(matriz);

        System.out.println("O determinante dessa matriz é: " + det);
    }

    public static float determinante(float[][] orig) {
        if (orig.length == 1)
            return orig[0][0];
        else {
            float det = 0f;

            // fixar para fazer na primeira linha; ou seja fixar o i como 0 e tratar cada coluna;
            // corrigir a indexaçao representativa para a matematica (matematica o index começa do 1);
            for (int col = 0; col < orig.length; col++)
                det += Math.pow(-1, (1 + 1 + col)) * orig[0][col] * determinante(submatriz(orig, 0, col));

            return det;
        }
    }

    public static float[][] submatriz(float[][] orig, int i, int j) {
        int tam_menor = orig.length - 1;
        int[] auxX = new int[tam_menor];
        int[] auxY = new int[tam_menor];

        int x = 0, y = 0;
        for (int k = 0; k < orig.length; k++) {
            if (k != i) {
                auxX[x] = k;
                x++;
            }
            if (k != j) {
                auxY[y] = k;
                y++;
            }
        }

        float[][] sub = new float[tam_menor][tam_menor];

        for (int lin = 0; lin < tam_menor; lin++)
            for (int col = 0; col < tam_menor; col++)
                sub[lin][col] = orig[auxX[lin]][auxY[col]];

        return sub;
    }
}
