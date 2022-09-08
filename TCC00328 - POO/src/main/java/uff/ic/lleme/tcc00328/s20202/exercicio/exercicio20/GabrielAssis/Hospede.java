package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio20.GabrielAssis;

public class Hospede extends Cliente{
    private String endereco;
    private String nacionalidade;
    private String origem;
    private String destino;
    private int numeroQuarto;
    
    //para guardar o hospede que se hospedou e tinha reserva
    public Hospede(String nome, long identidade, long telefone, String endereco, String nacionalidade, String origem, String destino){
        super(nome, identidade, telefone);
        this.endereco = endereco;
        this.nacionalidade = nacionalidade;
        this.origem = origem;
        this.destino = destino;
    }
    
    //para guardar o hospode que se hospedou sem reserva
    public Hospede(String nome, long identidade, long telefone, String endereco, String nacionalidade, String origem, String destino, int periodo) {
        super(nome, identidade, telefone, periodo);
        this.endereco = endereco;
        this.nacionalidade = nacionalidade;
        this.origem = origem;
        this.destino = destino;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }
}
