package uff.ic.lleme.tcc00328.s20202.exercicio.tutorialOOCont.GabrielAssis;

public class Inscricao {
    private Aluno aluno;
    private Turma turma;
    private String data_matricula;
    private String data_cancelamento;
    private float[] notas;
    
    public Inscricao(){
        
    }
    
    public Inscricao(Aluno aluno, Turma turma, String data_matricula){
        this.aluno = aluno;
        this.turma = turma;
        this.data_matricula = data_matricula;
        data_cancelamento = "Não candelada!";
    }
    
    public Aluno getAluno(){
        return aluno;
    }
    
    public Turma getTurma(){
        return turma;
    }
    
    public String getDataMatricula(){
        return data_matricula;
    }
    
    public String getDataCancelamento(){
        return data_cancelamento;
    }
    
    public float[] getNotas(){
        return notas;
    }
    
    public void setAluno(Aluno aluno){
        this.aluno = aluno;
    }
    
    public void setTurma(Turma turma){
        this.turma = turma;
    }
    
    public void setDataMatricula(String data_matricula){
        this.data_matricula = data_matricula;
    }
    
    public void setDataCancelamento(String data_cancelamento){
        this.data_cancelamento = data_cancelamento;
    }
    
    public void setNotas(float[] notas){
        this.notas = notas;
    }
}
