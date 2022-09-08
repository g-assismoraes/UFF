package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio22.GabrielAssis;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Carnaval {
    private int ano;
    private List<Escola> escolas = new ArrayList<>();
    private Jurado[] jurados = new Jurado[5]; //como fala que cada quesito tem 5 notas, o carnaval tem 5 jurados;
    private int qtdQuesitos;
    private int quesitoDesempate;
    
    public Carnaval(int ano, int qtdQuesitos){
        Random random = new Random();
        this.ano = ano;
        this.qtdQuesitos = qtdQuesitos;
        this.quesitoDesempate = random.nextInt(qtdQuesitos) + 1;
    }
    
    public void setJurado(int index, Jurado jurado){
        this.jurados[index] = jurado;
    }
    
    public void setEscola(Escola escola){
        this.escolas.add(escola);
    }
    
    public Jurado pegaJurado(long registro){
        for(Jurado jurado:jurados)
            if(registro == jurado.getRegistro())
                return jurado;
        return null;
    }
    
    public int getQtdEscolas(){
        return this.escolas.size();
    }
    
    public Escola getEscola(int index){
        return this.escolas.get(index);
    }
    
    public int pegaIndexJurado(Jurado jurado){
        int i = -1;
        for(Jurado jur:jurados){
            i++;
            if(jur == jurado)
                return i;
        }
        return i;
    
    }
    
    public Escola pegaEscola(String nome){
        for(Escola escola:escolas)
            if(escola.getNome().equals(nome))
                return escola;
        return null;
    }
    
   public void adicionaEscola(Escola escola){
       this.escolas.add(escola);
   }
   
   public void inicializa(){
       for(Jurado jurado:this.jurados){
           for (Escola escola:this.escolas)
               jurado.inicializaNotas(escola, qtdQuesitos);
       }
       for (Escola escola:escolas)
           escola.inicializaNotas(qtdQuesitos);
   }
   
   private float achaMaior(float[] notas){
        float maior = -1;
        for(int i = 0; i < notas.length; i++)
            if(maior < notas[i])
                maior = notas[i];
        return maior;
   }
   
   private int contaQtdMaiorNota(float maiorNota, float[] notas){
       int qtd = 0;
       for(int i = 0; i < notas.length; i++)
           if(notas[i] == maiorNota)
               qtd++;
       return qtd;
   }
   
   private Escola achaEscolaComNota(float nota){
       for(Escola escola:this.escolas){
           if(escola.getMediaFinal() == nota)
               return escola;
       }
       return null;
   }
   
   private Escola[] pegaEscolasComMaiorNota(float maiorNota, int tam){
       Escola[] resposta = new Escola[tam];
       int i = 0;
       for(Escola escola:escolas){
           if(escola.getMediaFinal() == maiorNota){
               resposta[i] = escola;
               i++;
           }
       }
       return resposta;
   }
   
   public Escola escolaComMaiorNota(){
       float[] mediasEscolas = new float[escolas.size()];
       int i = 0;
       for (Escola escola:this.escolas) {
           escola.calculaMediaFinal();
           mediasEscolas[i] = escola.getMediaFinal();
           i++;
       }
       float maiorNota = achaMaior(mediasEscolas);
       int qtdComMaiorNota = contaQtdMaiorNota(maiorNota, mediasEscolas);
       
        if (qtdComMaiorNota == 1){
           return achaEscolaComNota(maiorNota);
       }
       else{
           Escola[] escolasComMaiorNota = pegaEscolasComMaiorNota(maiorNota, qtdComMaiorNota);
           float[] notasQuesitoDesempate = new float[escolasComMaiorNota.length];
           for (int k = 0; k < escolasComMaiorNota.length; k++) {
               notasQuesitoDesempate[k] = escolasComMaiorNota[k].mediaQuesito(this.quesitoDesempate);
           }
           float maiorNotaQuesitoDesempate = achaMaior(notasQuesitoDesempate);
           for (int k = 0; k < escolasComMaiorNota.length; k++) {
               if (escolasComMaiorNota[k].mediaQuesito(this.quesitoDesempate) == maiorNotaQuesitoDesempate)
                   return escolasComMaiorNota[k];
           }
       }
       return null;
   }
   
    public int getQtdQuesitos() {
        return qtdQuesitos;
    }
}
