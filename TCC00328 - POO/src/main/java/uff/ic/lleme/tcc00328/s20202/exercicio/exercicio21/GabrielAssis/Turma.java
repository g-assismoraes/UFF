package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio21.GabrielAssis;

import java.util.LinkedList;
import java.util.List;

public class Turma {
    private Disciplina disciplina;
    private Curso curso;
    private String codigo;
    private int semestre;
    private List<Aluno> alunos = new LinkedList<>();
    private Professor professor;
    private int lotacao;
    
    public Turma(){
        
    }
    
    public Turma(String codigo, Professor professor, int lotacao, int semestre, Disciplina disciplina, Curso curso){
        this.disciplina = disciplina;
        this.curso = curso;
        this.codigo = codigo;
        this.semestre = semestre;
        this.lotacao = lotacao;
        this.professor = professor;
        professor.addTurma(this);
        disciplina.adicionaTurma(this);
        curso.adicionaTurma(this);
        
    }
    
    public void adicionarAluno(Aluno aluno){
        if (!this.alunos.contains(aluno))
            this.alunos.add(aluno);
    }
    
    public void removerAluno(Aluno aluno){
        this.alunos.remove(aluno);
    }
    
    public int getLotacaoAtual(){
        return this.alunos.size();
    }
    
    public Aluno getUltimaVaga(){
        Aluno ultimo = this.alunos.get(0);
        for (Aluno aluno:this.alunos)
            if (aluno.getCr() < ultimo.getCr())
                ultimo = aluno;
        
        return ultimo;
    }
    
    public void mostraMatriculados(){
        for (Aluno aluno : this.alunos){
            System.out.println(aluno.getNome());
        }
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public String getCodigo() {
        return codigo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public int getLotacao() {
        return lotacao;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
   
}
