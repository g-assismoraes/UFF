package uff.ic.lleme.tcc00328.s20202.prova.p2.GabrielAssis.questao1;

import java.util.ArrayList;
import java.util.List;

public class Sinonimos {
    public String significado;
    private List<Palavra> palavras = new ArrayList<>();
    
    public Sinonimos(){
        
    }
    
    public Sinonimos(String significado){
        this.significado = significado;
    }
    
    public String getSignificado(){
        return this.significado;
    }
    
    public void setPalavra(Palavra palavra){
        this.palavras.add(palavra);
    }
    
    public Palavra getPalavra(int index){
        return palavras.get(index);
    }
}
