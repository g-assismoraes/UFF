package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio20.GabrielAssis;

public class Cliente {
    private String nome;
    private long identidade;
    private long telefone;
    private int periodoEstadia; // em dias
    private Reserva reserva = null;
    
    public Cliente(String nome, long identidade, long telefone){
        this.nome = nome;
        this.identidade = identidade;
        this.telefone = telefone;
    }
    
    public Cliente(String nome, long identidade, long telefone, int periodo){
        this.nome = nome;
        this.identidade = identidade;
        this.telefone = telefone;
        this.periodoEstadia = periodo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getIdentidade() {
        return identidade;
    }

    public void setIdentidade(long identidade) {
        this.identidade = identidade;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public int getPeriodoEstadia() {
        return periodoEstadia;
    }

    public void setPeriodoEstadia(int periodoEstadia) {
        this.periodoEstadia = periodoEstadia;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
