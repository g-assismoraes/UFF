package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio21.GabrielAssis;

import java.util.HashSet;
import java.util.Set;

public class Disciplina {
    private String nome;
    private String codigo;
    private Set<Turma> cursos = new HashSet<>();
    
    public Disciplina(){
        
    }
    
    public Disciplina(String nome, String codigo){
        this.nome = nome;
        this.codigo = codigo;
    }
    
    public void adicionaTurma(Turma turma){
        cursos.add(turma);
    }
    
    public Turma getTurma(String codTurma){
        for (Turma turma:this.cursos) 
            if(turma.getCodigo().equals(codTurma))
                return turma;
        
        return null;
    }
    
    public void mostraAlunosMatriculados() {
        for (Turma turma:this.cursos)
            turma.mostraMatriculados();
    }
    
    public void mostraTurmas(int semestre){
        for (Turma turma:this.cursos)
            if(turma.getSemestre() == semestre)
                System.out.println(turma.getDisciplina().getNome() + "(" + turma.getDisciplina().getCodigo() + ") - " +
                turma.getCodigo());
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

}
