package uff.ic.lleme.tcc00328.s20202.exercicio.tutorialOOCont.GabrielAssis;

public class Turma {
    private String codigo;
    private Disciplina disciplina;
    private int semestre;
    private String horario;
    
    public Turma(){
        
    }
    
    public Turma(String codigo, Disciplina disciplina, int semestre, String horario){
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.semestre = semestre;
        this.horario = horario;
    }
    
    public String getCodigo(){
        return codigo;
    }
    
    public Disciplina getDisciplina(){
        return disciplina;
    }
    
    public int getSemestre(){
        return semestre;
    }
    
    public String getHorario(){
        return horario;
    }
    
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    
    public void setDisciplina(Disciplina disciplina){
        this.disciplina = disciplina;
    }
    
    public void setSemestre(int semestre){
        this.semestre = semestre;
    }
    
    public void setHorario(String horario){
        this.horario = horario;
    }
}
