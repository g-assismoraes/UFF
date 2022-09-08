package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio22.GabrielAssis;

import java.util.HashMap;
import java.util.Map;

public class Jurado {
    private String nome;
    private long registro;
    //como os quesitos sao valores enumeraveis, a nota do primeiro quesito é a primeira nota e assim sucessivamente
    private Map<Escola, float[]> notas = new HashMap<>();

    
    public Jurado(String nome, long registro){
        this.notas = new HashMap<>();
        this.nome = nome;
        this.registro = registro;
    }
    
    public void inicializaNotas(Escola escola, int tam){
        float[] vetor = new float[tam];
        this.notas.put(escola, vetor.clone());
    }
    
    public void insereNota(Escola escola, int quesito, float nota){
        this.notas.get(escola)[quesito-1] = nota;
    }
    
    public long getRegistro(){
        return this.registro;
    }
    
}
