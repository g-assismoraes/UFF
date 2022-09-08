package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio22.GabrielAssis;

import java.util.HashMap;
import java.util.Map;

public class Escola {
    private String nome;
    private int qtdMembros;
    private String nomePresidente;
    private String tema;
    private Map<Integer, float[]> notasPorQuesito = new HashMap<>();
    private float mediaFinal;
    
    public Escola(String nome, int qtdMembros, String nomePresidente, String tema){
        this.nome = nome;
        this.qtdMembros = qtdMembros;
        this.nomePresidente = nomePresidente;
        this.tema = tema;
    }
    
    public void mostraNotas(){
        for (int i = 0; i < notasPorQuesito.size(); i++) {
            float[] vetor = notasPorQuesito.get(i+1);
            for (float valor:vetor)
                System.out.println(valor);
            System.out.println();
        }
    }
    
    public void inicializaNotas(int qtdQuesitos){
        float[] vetor = new float[5];
        for (int i = 1; i <= qtdQuesitos; i++)
            this.notasPorQuesito.put(i, vetor.clone());
    }
    
    public void insereNota(int quesito, int indexJurado, float nota){
        this.notasPorQuesito.get(quesito)[indexJurado] = nota;
    }
    
    private float achaMenor(float[] notas){
        float menor = 11;
        for (int i = 0; i < notas.length; i++)
            if (menor > notas[i])
                menor = notas[i];
        return menor;
    }
    
    public float mediaQuesito(int quesito){
        float[] notas = this.notasPorQuesito.get(quesito);
        float menor = achaMenor(notas);
        float mediaQuesito = 0f;
        for (int j = 0; j < notas.length; j++){
            if (notas[j] != menor)
                mediaQuesito += notas[j];
       }
       mediaQuesito = mediaQuesito/(notas.length - 1);
       return mediaQuesito;
    }
    
    public void calculaMediaFinal(){
        float media = 0;
        for (int i = 0; i < notasPorQuesito.size(); i++) {
            float[] notas = this.notasPorQuesito.get(i + 1).clone();
            float menor = achaMenor(notas);
            float mediaQuesito = 0f;
            for(int j = 0; j < notas.length; j++){
                if(notas[j] != menor)
                    mediaQuesito += notas[j];
            }
            mediaQuesito = mediaQuesito/(notas.length - 1);
            media += mediaQuesito;
        }
        this.mediaFinal = media/notasPorQuesito.size();
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public float getMediaFinal(){
        return this.mediaFinal;
    }
}
