package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio21.GabrielAssis;

import java.util.HashSet;
import java.util.Set;

public class Curso {
    private String nome;
    private String codigo;
    private Set<Turma> disciplinasOfertadas = new HashSet<>();
    
    public Curso(){

    }
    
    public Curso(String nome, String codigo){
        this.nome = nome;
        this.codigo = codigo;
    }
    
    public void adicionaTurma(Turma turma){
        this.disciplinasOfertadas.add(turma);
    }
    
    public Turma getTurma(String codTurma){
        for (Turma turma:this.disciplinasOfertadas) 
            if(turma.getCodigo().equals(codTurma))
                return turma;
        
        return null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
