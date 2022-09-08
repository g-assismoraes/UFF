package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio15;

public class GabrielAssis {

    public static void main(String[] args) {
        //assumi que o vetor categoria sempre virá formatado corretamente, com pelo menos dois valores
        float categorias[] = {0f, 2f, 2.5f, 4.3f, 5.0f, 10f};
        float numeros[] = {-1f, 2f, 2.7f, 1f, 0.2f, 4.8f, 4.4f, 8f, 10f, 22f, 33f};

        float[] resposta = histograma(numeros, categorias);

        for (int i = 0; i < resposta.length; i++)
            if (i == 0)
                System.out.printf("%.2f%% dos números não pertencem a alguma categoria;\n", resposta[0]);
            else if (i == resposta.length - 1)
                System.out.printf("%.2f%% dos números pertencem a categoria %.1f <= x <= %.1f.\n", resposta[i],
                        categorias[i - 1], categorias[i]);
            else
                System.out.printf("%.2f%% dos números pertencem a categoria %.1f <= x < %.1f;\n", resposta[i],
                        categorias[i - 1], categorias[i]);
    }

    //retorna a porcentagem relacionada a categoria equivalente a sua posição, sendo a posicao 0 o nao enquadramento em categoria;
    public static float[] histograma(float[] numeros, float[] categorias) {
        float[] resp = new float[categorias.length];
        int categ;
        for (int i = 0; i < numeros.length; i++) {
            categ = categoria(numeros[i], categorias);

            if (categ == -1)
                resp[0] += 1;
            else
                resp[categ] += 1;
        }

        for (int j = 0; j < resp.length; j++)
            resp[j] = resp[j] / numeros.length * 100;

        return resp;
    }

    //retorna a posição da sua categoria, por ex 1 = primeira categoria;
    public static int categoria(float numero, float[] categs) {
        for (int i = 0; i < categs.length - 1; i++)
            if (i + 1 == categs.length - 1) {
                if ((categs[i] <= numero) && (categs[i + 1] >= numero))
                    return i + 1;
            } else if ((categs[i] <= numero) && (categs[i + 1] > numero))
                return i + 1;
        return -1;
    }
}
