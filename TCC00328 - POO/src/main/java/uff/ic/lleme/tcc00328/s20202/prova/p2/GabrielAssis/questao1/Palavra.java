package uff.ic.lleme.tcc00328.s20202.prova.p2.GabrielAssis.questao1;

import java.util.ArrayList;
import java.util.List;

public class Palavra {
    public String fonetica;
    public String grafia;
    private List<Sinonimos> sinonimos = new ArrayList<>();
    
    public Palavra(){
        
    }
    
    public Palavra(String grafia, String fonetica){
        this.fonetica = fonetica;
        this.grafia = grafia;
    }
    
    public String getGrafia(){
        return this.grafia;
    }
    
    public void setGrafia(String grafia){
        this.grafia = grafia;
    }
    
    //no escopo da questao nao faria diferença, mas decidi adicionar a divisao pois poderia necessitar de tratamentos diferentes.
    //Seria interessante um retorno diferenciado tambem caso o fosse necessario, mas fugiria do escopo da questao;
    public void criaSinonimos(String significado, int flag){
        if (flag == 0){
            Substantivo novo = new Substantivo(significado);
            novo.setPalavra(this);
            this.sinonimos.add(novo);
        }
        else if(flag == 1){
            Verbo novo = new Verbo(significado);
            novo.setPalavra(this);
            this.sinonimos.add(novo);
        }
    }
    
    public String getSignificado(int index){
        return this.sinonimos.get(index).getSignificado();
    }
    
    public Sinonimos getSinonimos(int index){
        return this.sinonimos.get(index);
    }
    
    public void setSinonimos(Sinonimos sinonimos){
        this.sinonimos.add(sinonimos);
    }
    
    public int getQtdSignificados(){
        return this.sinonimos.size();
    }
}
