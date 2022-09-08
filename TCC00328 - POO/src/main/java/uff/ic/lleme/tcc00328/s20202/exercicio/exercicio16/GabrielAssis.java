package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio16;

// não considerei a possibilidade dos times terem numeros de jogos diferentes pois o problema nao falava;
// da mesma forma, nao considerei ir além se times continuassem empatados mesmo após todos os critérios (até porque, bastante dificil de ocorrer);
public class GabrielAssis {

    public static void main(String[] args) {
        //PG > V > SG > GP
        int[][] tabela = {
            //PG  J  V  SG  GP
            {10, 8, 3, -4, 12},
            {17, 8, 5, 10, 19},
            {10, 8, 3, -5, 11},
            {11, 8, 3, -1, 15},
            {19, 8, 6, 13, 23}};

        int qtdTimes = tabela.length;

        int timeLider = achaLider(qtdTimes, tabela);

        System.out.println("O time " + timeLider + " é o líder do campeonato!");

    }

    public static int pegaLider(int[] candidatos) {
        int lider = -1;
        for (int i = 0; i < candidatos.length; i++)
            if (candidatos[i] == 1) {
                lider = i;
                break;
            }
        return lider;
    }

    public static int[] inicializa(int[][] tab, int comp, int flag) {
        int[] resposta = new int[tab.length];

        for (int i = 0; i < tab.length; i++)
            if (tab[i][flag] == comp)
                resposta[i] = 1;

        return resposta;
    }

    public static int[] checa(int[][] tab, int comp, int flag, int[] vetor) {
        int[] resposta = new int[tab.length];

        for (int i = 0; i < tab.length; i++)
            if (vetor[i] == 1)
                if (tab[i][flag] == comp)
                    resposta[i] = 1;

        return resposta;
    }

    public static boolean unicidade(int[] vetor) {
        int qtd = 0;

        for (int i = 0; i < vetor.length; i++)
            if (vetor[i] == 1)
                qtd += 1;

        if (qtd > 1)
            return false;

        return true;

    }

    public static int achaLider(int tam, int[][] tab) {
        int lider = -1, criterio = -1;
        int[] pontosGanhos = new int[tam];
        int[] vitorias = new int[tam];
        int[] saldoGols = new int[tam];
        int[] golsProprios = new int[tam];

        int maior = -20000;
        for (int i = 0; i < tam; i++)
            if (tab[i][0] > maior)
                maior = tab[i][0];

        criterio = 0;
        pontosGanhos = inicializa(tab, maior, 0);

        if (!unicidade(pontosGanhos)) {
            maior = -20000;

            for (int i = 0; i < tam; i++)
                if (pontosGanhos[i] == 1)
                    if (tab[i][2] > maior)
                        maior = tab[i][2];

            criterio = 1;
            vitorias = checa(tab, maior, 2, pontosGanhos);
        }

        if (!unicidade(vitorias)) {
            maior = -20000;

            for (int i = 0; i < tam; i++)
                if (vitorias[i] == 1)
                    if (tab[i][3] > maior)
                        maior = tab[i][3];
            criterio = 2;
            saldoGols = checa(tab, maior, 3, vitorias);
        }

        if (!unicidade(saldoGols)) {
            maior = -20000;

            for (int i = 0; i < tam; i++)
                if (saldoGols[i] == 1)
                    if (tab[i][4] > maior)
                        maior = tab[i][4];

            criterio = 3;
            golsProprios = checa(tab, maior, 4, saldoGols);
        }

        if (criterio == 0)
            lider = pegaLider(pontosGanhos);
        else if (criterio == 1)
            lider = pegaLider(vitorias);
        else if (criterio == 2)
            lider = pegaLider(saldoGols);
        else if (criterio == 3)
            lider = pegaLider(golsProprios);

        return lider;
    }
}
