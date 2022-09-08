package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio20.GabrielAssis;

public class Reserva {
    private long id = 000;
    private Apartamento[] apartamentos;
    private Cliente cliente; // tem um cliente so na hora da reserva pelo fato de geralmente a reserva estar no nome de uma pessoa só; a discriminacao de ocupantes ocorre na hora da hospedagem
    private int qtdApartamentos;
    
    public Reserva(int id, Apartamento[] apartamentos, Cliente cliente, int qtdApartamentos){
        this.id = id;
        this.apartamentos = apartamentos;
        this.cliente = cliente;
        this.qtdApartamentos = qtdApartamentos;
    }
    
    public Apartamento getApartamento(int index){
        return apartamentos[index];
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getQtdApartamentos() {
        return qtdApartamentos;
    }

    public void setQtdApartamentos(int qtdApartamentos) {
        this.qtdApartamentos = qtdApartamentos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
