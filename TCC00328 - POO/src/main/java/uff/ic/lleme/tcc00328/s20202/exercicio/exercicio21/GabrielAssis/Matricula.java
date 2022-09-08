package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio21.GabrielAssis;

import java.util.HashSet;
import java.util.Set;

public class Matricula {
    private Aluno aluno;
    private int semestre = 0;
    private Set<Turma> turmasPreferenciais = new HashSet<>();
    private Set<Turma> turmasAlternativas = new HashSet<>();
    private Set<Turma> turmasInscritasEfetivamente = new HashSet<>();
    
    public void atualiza(){
        this.turmasInscritasEfetivamente.clear();
        for (Turma turmaCandidata:turmasPreferenciais){
            if (turmaCandidata.getLotacaoAtual() >= turmaCandidata.getLotacao()){
                if (turmaCandidata.getUltimaVaga().getCr() < aluno.getCr()){
                    turmaCandidata.getUltimaVaga().removeTurmaInscritaEfetivamente(turmaCandidata);
                    turmaCandidata.removerAluno(turmaCandidata.getUltimaVaga());
                    turmaCandidata.adicionarAluno(this.aluno);
                    this.turmasInscritasEfetivamente.add(turmaCandidata);
                }
            }else{
                turmaCandidata.adicionarAluno(this.aluno);
                this.turmasInscritasEfetivamente.add(turmaCandidata);
            } 
        }
        
        if (turmasInscritasEfetivamente.size() < 4)
            for (Turma turmaCandidata:turmasAlternativas)
                if (turmasInscritasEfetivamente.size() < 4){
                    if (turmaCandidata.getLotacaoAtual() >= turmaCandidata.getLotacao()){
                        if (turmaCandidata.getUltimaVaga().getCr() < aluno.getCr()){
                        turmaCandidata.getUltimaVaga().removeTurmaInscritaEfetivamente(turmaCandidata);
                        turmaCandidata.removerAluno(turmaCandidata.getUltimaVaga());
                        turmaCandidata.adicionarAluno(this.aluno);
                        this.turmasInscritasEfetivamente.add(turmaCandidata);
                        }
                    }else{
                        turmaCandidata.adicionarAluno(this.aluno);
                        this.turmasInscritasEfetivamente.add(turmaCandidata);
                    } 
                }else return;   
    }
    
    public void mostraTurmasInscritas(){
        for (Turma turma:turmasInscritasEfetivamente){
            System.out.println(turma.getDisciplina().getNome() + "(" + turma.getDisciplina().getCodigo() + ") - " +
                    turma.getCodigo());
        }
    }
    
    public void inserePreferencial(Turma turma){
        this.turmasPreferenciais.add(turma);
        
        for (Turma turmaEfetiva:turmasInscritasEfetivamente)
            for (Turma turmaAlternativa:turmasAlternativas)
                if(turmaEfetiva == turmaAlternativa)
                    turmaEfetiva.removerAluno(this.aluno);
    }
    
    public void insereAlternativa(Turma turma){
        this.turmasAlternativas.add(turma);
    }
    
    public void removeTurma(Turma turma){
        if (turmasInscritasEfetivamente.contains(turma)) {
            turma.removerAluno(aluno);
            turmasInscritasEfetivamente.remove(turma);
        }
        
        if (turmasPreferenciais.contains(turma)) {
            turmasPreferenciais.remove(turma);
            return;
        }
        if (turmasAlternativas.contains(turma)) 
            turmasAlternativas.remove(turma);
    }
    
    public void removeInscricao(Turma turma){
        this.turmasInscritasEfetivamente.remove(turma);
    }
    
    public int getTamanhoPreferenciais(){
        return this.turmasPreferenciais.size();
    }
    
    public int getTamanhoAlternativas(){
        return this.turmasAlternativas.size();
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    
    public void setTurmaPreferencial(Turma turma){
        this.turmasPreferenciais.add(turma);
    }
    
    public void setTurmaAlternativa(Turma turma){
        this.turmasAlternativas.add(turma);
    }
}
