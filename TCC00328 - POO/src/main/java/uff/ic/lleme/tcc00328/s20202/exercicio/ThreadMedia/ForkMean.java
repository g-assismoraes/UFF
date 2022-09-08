package uff.ic.lleme.tcc00328.s20202.exercicio.ThreadMedia;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class ForkMean extends RecursiveAction {

    private int inicio = 0;
    private int fim = 0;
    private Acumulador acumulador;
    private List<Float> valores = new ArrayList<>();
    protected static int tamanhoJob = 5;

    public ForkMean(List<Float> valores, Acumulador acumulador) {
        this.valores = valores;
        this.inicio = 0;
        this.fim = valores.size();
        this.acumulador = acumulador;
    }

    private ForkMean(List<Float> valores, int inicio, int fim, Acumulador acumulador) {
        this.valores = valores;
        this.inicio = inicio;
        this.fim = fim;
        this.acumulador = acumulador;
    }

    protected void computeDirectly() {
        float somaParcial = 0f;
        for (int i = inicio; i < fim; i++) {
            somaParcial += valores.get(i);
        }
        acumulador.acumula(somaParcial);
    }

    @Override
    protected void compute() {
        if (fim - inicio < tamanhoJob)
            computeDirectly();
        else {
            int meio = (inicio + fim) / 2;
            invokeAll(new ForkMean(valores, inicio, meio, acumulador),
                    new ForkMean(valores, meio, fim, acumulador));
        }
    }
}

