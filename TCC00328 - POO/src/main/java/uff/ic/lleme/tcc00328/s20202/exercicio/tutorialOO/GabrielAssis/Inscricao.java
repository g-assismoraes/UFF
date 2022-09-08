package uff.ic.lleme.tcc00328.s20202.exercicio.tutorialOO.GabrielAssis;

public class Inscricao {
    protected Aluno aluno;
    protected Disciplina disciplina;
    protected String data_matricula;
    protected String data_cancelamento;
    protected float[] notas;
    
    public Inscricao(){
        
    }
    
    public Inscricao(Aluno aluno, Disciplina disciplina, String data_matricula){
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.data_matricula = data_matricula;
        data_cancelamento = "Não Cancelada!";
    }
}
