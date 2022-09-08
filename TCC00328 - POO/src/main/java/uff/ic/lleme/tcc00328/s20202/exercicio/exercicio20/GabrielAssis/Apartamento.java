package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio20.GabrielAssis;

public class Apartamento {
    private int numeroDoQuarto;
    private TipoApartamento classificacao;
    private boolean disponivel = true;
    private int ocupacaoMaxima;  // capacidade maxima permitida pelo quarto
    private int ocupacaoAtual = 0; // qtd pessoas que estao no quarto
    
    public Apartamento(){
        
    }
    
    public Apartamento(int numeroDoQuarto, int ocupacaoMaxima, int classificacao){
        this.numeroDoQuarto = numeroDoQuarto;
        this.ocupacaoMaxima = ocupacaoMaxima;
        
        if (classificacao == 1)
            this.classificacao = TipoApartamento.SIMPLES;
        else if (classificacao == 2)
            this.classificacao = TipoApartamento.DUPLO;
        else if (classificacao == 3)
            this.classificacao = TipoApartamento.SUITE;
            
    }
    
    public int getNumeroDoQuarto() {
        return numeroDoQuarto;
    }

    public void setNumeroDoQuarto(int numeroDoQuarto) {
        this.numeroDoQuarto = numeroDoQuarto;
    }

    public int getOcupacaoAtual() {
        return ocupacaoAtual;
    }

    public void setOcupacaoAtual(int ocupacaoAtual) {
        this.ocupacaoAtual = ocupacaoAtual;
    }

    public int getOcupacaoMaxima() {
        return ocupacaoMaxima;
    }

    public void setOcupacaoMaxima(int ocupacaoMaxima) {
        this.ocupacaoMaxima = ocupacaoMaxima;
    }


    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean status) {
        this.disponivel = status;
    }

    public TipoApartamento getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(TipoApartamento classificacao) {
        this.classificacao = classificacao;
    }
}
