package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio20.GabrielAssis;

import java.util.LinkedList;
import java.util.List;

public class SistemaDoHotel {
    public static Reserva[] reservas = new Reserva[100];
    public static int qtdReservas = 0;
    
    public static Apartamento[] apartamentosDoHotel = new Apartamento[7];
    
    public static List<Hospede> hospedes = new LinkedList<>();
    public static int qtdHospedados;
    
    public static void main(String[] args){
        carregaApartamentos();
        
        reserva(001, 2, 2, 0, 0, "Carlos Eduardo", 30000123, 229983848);
        reserva(002, 2, 0, 0, 1, "Maria Clara", 20000123, 229983448);
        
        //hospedagem também é uma funcao individual, ou seja, deve ser usada para cada hospede.
        hospedagem(1, 001, "Carlos Eduardo", 30000123, 229983848, "Rua Alcantara - Niteroi - RJ", "brasileiro", "Niteroi", "Sao Paulo");
        hospedagem(1, 001, "Gabriel Moraes", 20000123, 229983828, "Rua Alcantara - Niteroi - RJ", "brasileiro", "Niteroi", "Sao Paulo");
        hospedagem(1, 002, "Maria Clara", 20000321, 229982828, "Rua Basilisco - Sao Paulo - SP", "brasileiro", "Sao Paulo", "Niteroi");
        
        /*hospedagem teria que implementar entrada com o teclado para fazer outra hospedagem sem reserva pois eu inseri
        manualmente os dados(periodo e qual quarto) somente para teste, ou seja eles vao se repetir se tentar novamente;*/
        hospedagem(0, 000, "Fernanda Lima", 20000331, 219982828, "Rua Dementador - Londres - UK", "britanico", "Londres", "Sao Paulo");

        mostraHospedes();
        
        encerraEstadia(hospedes.get(1));
        
        mostraHospedes();
    }
    
    public static void carregaApartamentos(){
        apartamentosDoHotel[0] = new Apartamento(10, 1, 1);
        apartamentosDoHotel[1] = new Apartamento(12, 1, 1);
        apartamentosDoHotel[2] = new Apartamento(14, 1, 1);
        apartamentosDoHotel[3] = new Apartamento(16, 2, 2);
        apartamentosDoHotel[4] = new Apartamento(18, 2, 2);
        apartamentosDoHotel[5] = new Apartamento(20, 2, 3);
        apartamentosDoHotel[6] = new Apartamento(22, 2, 3);
    }
    
    public static void reserva(int id, int periodo, int qtdSimplesRequerida, int qtdDuplosRequerida, int qtdSuitesRequerida, String nome, long identidade, long telefone){
        //a id poderia vir de uma funcao que gera ids, mas penso que nao é o escopo da questao, por isso fiz direto;
        
        int qtdSimplesDisponivel = 0, qtdDuplosDisponivel = 0, qtdSuitesDisponivel = 0;
        for (int i = 0; i < apartamentosDoHotel.length; i++) {
            if (apartamentosDoHotel[i].getClassificacao() == TipoApartamento.SIMPLES && apartamentosDoHotel[i].isDisponivel())
                qtdSimplesDisponivel++;
            else if(apartamentosDoHotel[i].getClassificacao() == TipoApartamento.DUPLO && apartamentosDoHotel[i].isDisponivel())
                qtdDuplosDisponivel++;
            else if(apartamentosDoHotel[i].getClassificacao() == TipoApartamento.SUITE && apartamentosDoHotel[i].isDisponivel())
                qtdSuitesDisponivel++;
        }
        
        if (qtdSimplesRequerida > qtdSimplesDisponivel || qtdDuplosRequerida > qtdDuplosDisponivel || qtdSuitesRequerida >
                qtdSuitesDisponivel) 
            System.out.println("Infelizmente não há quartos disponíveis para atender à sua reserva. Mas espero te ver em breve!");
        else{
            int qtdApartamentosRequeridos = qtdSimplesRequerida + qtdDuplosRequerida + qtdSuitesRequerida;
            Apartamento[] apartamentosRequeridos = new Apartamento[qtdApartamentosRequeridos];
            
            int i = 0;
            while (i != qtdApartamentosRequeridos) {
                for (int j = 0; j < apartamentosDoHotel.length; j++) {
                    if (qtdSimplesRequerida > 0) {
                        if (apartamentosDoHotel[j].getClassificacao() == TipoApartamento.SIMPLES && apartamentosDoHotel[j].isDisponivel()) {
                            qtdSimplesRequerida--;
                            apartamentosDoHotel[j].setDisponivel(false);
                            apartamentosRequeridos[i] = apartamentosDoHotel[j];
                            break;
                        }
                    }
                   
                    else if (qtdDuplosRequerida > 0){ 
                        if (apartamentosDoHotel[j].getClassificacao() == TipoApartamento.DUPLO && apartamentosDoHotel[j].isDisponivel()) {
                            qtdDuplosRequerida--;
                            apartamentosDoHotel[j].setDisponivel(false);
                            apartamentosRequeridos[i] = apartamentosDoHotel[j];
                            break;
                        }
                    }
                    
                    else if (qtdSuitesRequerida > 0) {
                        if (apartamentosDoHotel[j].getClassificacao() == TipoApartamento.SUITE && apartamentosDoHotel[j].isDisponivel()) {
                            qtdSuitesRequerida--;
                            apartamentosDoHotel[j].setDisponivel(false);
                            apartamentosRequeridos[i] = apartamentosDoHotel[j];
                            break;
                        }
                    }
                }
                i++;
            }
            
            Cliente cliente = new Cliente(nome, identidade, telefone, periodo);
            reservas[qtdReservas] = new Reserva(id, apartamentosRequeridos, cliente, qtdApartamentosRequeridos);
            reservas[qtdReservas].getCliente().setReserva(reservas[qtdReservas]);
            System.out.println("Reserva feita com sucesso, senhor(a) " + reservas[qtdReservas].getCliente().getNome() + ".");
            qtdReservas++;
        }   
    }
        
    
    public static void hospedagem(int flag, int id, String nome, long identidade, long telefone, String endereco,
    String nacionalidade, String origem, String destino) {
        //nao conferi se outros dados da reserva batiam pois so foi pedido conferir o numero da reserva e respeitar a ocupacao
        
        if (flag == 1){ //o hospede forneceu reserva
            int i;
            
            //se informar a mesma reserva
            for (i = 0; i < reservas.length; i++) 
                if(reservas[i].getId() == id)
                    break;
            
            Hospede hospede = new Hospede(nome, identidade, telefone, endereco, nacionalidade, origem, destino);
            hospede.setPeriodoEstadia(reservas[i].getCliente().getPeriodoEstadia());
            hospede.setReserva(reservas[i]);
            for (int j = 0; j < reservas[i].getQtdApartamentos(); j++) {
                if (reservas[i].getApartamento(j).getOcupacaoMaxima() > reservas[i].getApartamento(j).getOcupacaoAtual()) {
                    reservas[i].getApartamento(j).setOcupacaoAtual(reservas[i].getApartamento(j).getOcupacaoAtual() + 1);
                    //o hotel registra o numero do quarto em que o hospede está
                    hospede.setNumeroQuarto(reservas[i].getApartamento(j).getNumeroDoQuarto());
                    break;
                }
            }
            
            hospedes.add(hospede);
            qtdHospedados++;    
        }
        else { //confere se dá para hospedar sem reserva
            
            //capturaria os dados que precisaria para tentar fazer a reserva, aqui irei acrescentar manualmente;
            int qtdSimplesRequerida = 0;
            int qtdDuplosRequerida = 0;
            int qtdSuitesRequerida = 1;
            int periodo = 1;
            
            //conforme ja dito, pensei a funcao hospedagem para sem reserva ser individual, ou seja, cada hospede pediria um quarto por vez
            int qtdSimplesDisponivel = 0, qtdDuplosDisponivel = 0, qtdSuitesDisponivel = 0;
            for (int i = 0; i < apartamentosDoHotel.length; i++) {
                if (apartamentosDoHotel[i].getClassificacao() == TipoApartamento.SIMPLES && apartamentosDoHotel[i].isDisponivel())
                    qtdSimplesDisponivel++;
                else if(apartamentosDoHotel[i].getClassificacao() == TipoApartamento.DUPLO && apartamentosDoHotel[i].isDisponivel())
                    qtdDuplosDisponivel++;
                else if(apartamentosDoHotel[i].getClassificacao() == TipoApartamento.SUITE && apartamentosDoHotel[i].isDisponivel())
                    qtdSuitesDisponivel++;
            }
        
            if (qtdSimplesRequerida > qtdSimplesDisponivel || qtdDuplosRequerida > qtdDuplosDisponivel || qtdSuitesRequerida >
                qtdSuitesDisponivel) 
                System.out.println("Infelizmente não há quartos disponíveis para atender à sua reserva. Mas espero te ver em breve!");
            else {
                int j;
                for (j = 0; j < apartamentosDoHotel.length; j++) {
                    if (qtdSimplesRequerida > 0) {
                        if (apartamentosDoHotel[j].getClassificacao() == TipoApartamento.SIMPLES && apartamentosDoHotel[j].isDisponivel()) {
                            qtdSimplesRequerida--;
                            apartamentosDoHotel[j].setDisponivel(false);
                            break;
                        }
                    }
                    else if (qtdDuplosRequerida > 0){ 
                        if (apartamentosDoHotel[j].getClassificacao() == TipoApartamento.DUPLO && apartamentosDoHotel[j].isDisponivel()) {
                            qtdDuplosRequerida--;
                            apartamentosDoHotel[j].setDisponivel(false);
                            break;
                        }
                    }
                    else if (qtdSuitesRequerida > 0) {
                        if (apartamentosDoHotel[j].getClassificacao() == TipoApartamento.SUITE && apartamentosDoHotel[j].isDisponivel()) {
                            qtdSuitesRequerida--;
                            apartamentosDoHotel[j].setDisponivel(false);
                            break;
                        }
                    }
                }
                
                Hospede hospede = new Hospede(nome, identidade, telefone, endereco, nacionalidade, origem, destino, periodo);
                hospede.setNumeroQuarto(apartamentosDoHotel[j].getNumeroDoQuarto());
                
                hospedes.add(hospede);
                qtdHospedados++;
            }
        }       
    }
    
    public static void encerraEstadia(Hospede hospede){
        for (int j = 0; j < apartamentosDoHotel.length; j++) {
            if (apartamentosDoHotel[j].getNumeroDoQuarto() == hospede.getNumeroQuarto()){
                apartamentosDoHotel[j].setOcupacaoAtual(apartamentosDoHotel[j].getOcupacaoAtual() - 1);
                if (apartamentosDoHotel[j].getOcupacaoAtual() == 0)
                    apartamentosDoHotel[j].setDisponivel(true);
            }
        }
        qtdHospedados--;
        hospedes.remove(hospede);
    }
    
    public static void mostraHospedes() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(" "); System.out.println(" ");
        for(int i = 0; i < qtdHospedados; i++) {
            System.out.println(hospedes.get(i).getNome() + " está hospedado no hotel no quarto de número " +
                    hospedes.get(i).getNumeroQuarto() + ".");
            
            if(hospedes.get(i).getReserva() == null)
                System.out.println("Esse hóspode não fez reserva previamente.");
            else{
                int j;
                for(j = 0; j < qtdReservas; j++) 
                    if (reservas[j].getId() == hospedes.get(i).getReserva().getId())
                        break;
                
                System.out.println("Esse hóspede teve reserva feita por " + reservas[j].getCliente().getNome() + ".");
            }
            
            System.out.println(" "); System.out.println(" ");
        }
        System.out.println("------------------------------------------------------------------------------");
    }
}