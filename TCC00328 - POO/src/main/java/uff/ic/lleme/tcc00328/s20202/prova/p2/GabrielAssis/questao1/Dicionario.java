package uff.ic.lleme.tcc00328.s20202.prova.p2.GabrielAssis.questao1;

import java.util.ArrayList;
import java.util.List;

public class Dicionario {
    private List<Palavra> palavras = new ArrayList<>();
    
    public Dicionario(){
        
    }
    
    public int getTamanhoDicionario(){
        return this.palavras.size();
    }
    
    public Palavra getPalavra(int index){
        return this.palavras.get(index);
    }
    
    public void inserePalavra(String grafia, String[] significados, int aux){
        Palavra palavra = new Palavra();
        palavra.setGrafia(grafia);
        
        //teste se ja exista palavra com mesmo significado
        for (int j = 0; j < significados.length; j++) {
            int flag = 0;
            for (int i = 0; i < this.palavras.size(); i++) 
                for(int k = 0; k < this.palavras.get(i).getQtdSignificados(); k++)
                    if(this.palavras.get(i).getSignificado(k).equals(significados[j])){
                        Sinonimos sin = palavras.get(i).getSinonimos(k);
                        sin.setPalavra(palavra);
                        palavra.setSinonimos(sin);
                        flag = 1;
                        break;
                    }
            if(flag == 0) //não existia palavra com mesmo significado
                palavra.criaSinonimos(significados[j], aux);
        }
        
        this.palavras.add(palavra);
    }
}
