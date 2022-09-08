package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio21.GabrielAssis;

import java.util.LinkedList;
import java.util.List;

public class Professor {
    private String nome;
    private long cpf;
    private long id;
    private List<Turma> turmas = new LinkedList<>();
    
    public Professor(){
        
    }
    
    public Professor(String nome, long cpf, long id){
        this.nome = nome;
        this.cpf = cpf;
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addTurma(Turma turma){
        this.turmas.add(turma);
    }
    
    public Turma pegaTurma(String codDisc, String codTurma){
        for(Turma turma:this.turmas)
            if(turma.getCodigo().equals(codTurma) && turma.getDisciplina().getCodigo().equals(codDisc))
                return turma;
            
        return null;
    }
}
