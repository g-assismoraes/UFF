package uff.ic.lleme.tcc00328.s20202.exercicio.tutorialOOCont.GabrielAssis;

public class Aluno extends Pessoa {
    private int matricula;
    private String unidade;
    private Inscricao[] inscricoes;
    
    public Aluno(){
        
    }
    
    public Aluno(long cpf, int matricula, String unidade, String nome){
        super(nome, cpf);
        this.matricula = matricula;
        this.unidade = unidade;
    }
    
    public int getMatricula(){
        return matricula;
    }
    
    public String getUnidade(){
        return unidade;
    }
    
    public Inscricao[] getInscricoes(){
        return inscricoes;
    }
    
    public void setMatricula(int matricula){
        this.matricula = matricula;
    }
    
    public void setUnidade(String unidade){
        this.unidade = unidade;
    }
    
    public void setInscricoes(Inscricao[] inscricoes){
        this.inscricoes = inscricoes;
    }
}
