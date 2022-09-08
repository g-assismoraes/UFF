package uff.ic.lleme.tcc00328.s20202.exercicio.tutorialOO.GabrielAssis;

public class Aluno extends Pessoa {
    protected int matricula;
    protected String unidade;
    protected Inscricao[] inscricoes;
    
    public Aluno(){
        
    }
    
    public Aluno(long cpf, int matricula, String unidade, String nome){
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.unidade = unidade;
    }
}
