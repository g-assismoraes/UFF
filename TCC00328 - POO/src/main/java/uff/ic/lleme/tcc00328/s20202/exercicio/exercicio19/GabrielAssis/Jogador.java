package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio19.GabrielAssis;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private List<Partida> partidas = new ArrayList<>();
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setPartida(Partida partida){
        this.partidas.add(partida);
    }
    
    public void mostraVitorias(){
        int qtdVitorias = 0;
        for (Partida partida:partidas) {
            if (partida.isJogadorSaiuVitorioso())
                qtdVitorias += 1;
        }
        
        System.out.println("Obrigado por jogar!");
        System.out.println(this.nome + ", você ganhou " + qtdVitorias + " dentre"
                + " as " + this.partidas.size() + " partidas que jogou!!");
    }
    
}
