package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio19.GabrielAssis;

public class Partida {
   private Dado dado1 = new Dado();
   private Dado dado2 = new Dado();
   private Jogador jogador;
   private boolean jogadorSaiuVitorioso = false;
   private int objetivo; //ponto
   private int ultimaSomaObtida;
   private boolean status = true;
   private int rodada = 0;

    public Dado getDado1() {
        return dado1;
    }

    public Dado getDado2() {
        return dado2;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public int getObjetivo() {
        return objetivo;
    }
 
    public boolean getStatus() {
        return status;
    }

    public int getRodada() {
        return rodada;
    }
  
    public int getUltimaSomaObtida() {
        return ultimaSomaObtida;
    }

    
    public void novaRodada(){
        this.rodada++;
        this.ultimaSomaObtida = this.dado1.lancaDado() + this.dado2.lancaDado();
        
        if (this.rodada == 1) {
            if(this.ultimaSomaObtida == 7 || this.ultimaSomaObtida == 11){
                this.jogador.setPartida(this);
                this.jogadorSaiuVitorioso = true;
                this.status = false;
            }
                
            else if (this.ultimaSomaObtida == 2 || this.ultimaSomaObtida == 3 ||
                   this.ultimaSomaObtida == 12) {
                this.jogador.setPartida(this);
                this.jogadorSaiuVitorioso = false;
                this.status = false;
            }
            else
                this.objetivo = this.ultimaSomaObtida;
        }
        
        else{
            if(this.objetivo == this.ultimaSomaObtida){
                this.jogador.setPartida(this);
                this.jogadorSaiuVitorioso = true;
                this.status = false;
            }
            else if(this.ultimaSomaObtida == 7){
                this.jogador.setPartida(this);
                this.jogadorSaiuVitorioso = false;
                this.status = false;
            }
        }    
    }

    public boolean isJogadorSaiuVitorioso() {
        return jogadorSaiuVitorioso;
    }
}
