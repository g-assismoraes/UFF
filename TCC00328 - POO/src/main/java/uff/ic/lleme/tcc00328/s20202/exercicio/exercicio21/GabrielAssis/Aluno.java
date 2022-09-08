package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio21.GabrielAssis;

public class Aluno {
    private String nome;
    private long cpf;
    private long id;
    private String codCurso;
    private Matricula matricula = new Matricula();
    private float cr;
    
    public Aluno(){
        
    }
    
    public Aluno(String nome, long cpf, long id, String codCurso, int cr){
        this.nome = nome;
        this.cpf = cpf;
        this.id = id;
        this.codCurso = codCurso;
        this.cr = cr;
    }
    
    public boolean cadastraMatricula(Turma pref1, Turma pref2, Turma pref3, Turma pref4, Turma alt1, Turma alt2, int semestre){
        if( pref1 == null || pref2 == null || pref3 == null || pref4 == null || alt1 == null || alt2 == null){
            System.out.println("Parece que pelo menos uma das disciplinas não existe ou foi digitada incorretamente. Tente novamente"
                    + "ou consulte a sua Coordenação.");
            return false;
        }
        this.matricula.setTurmaPreferencial(pref1);
        this.matricula.setTurmaPreferencial(pref2);
        this.matricula.setTurmaPreferencial(pref3);
        this.matricula.setTurmaPreferencial(pref4);
        this.matricula.setTurmaAlternativa(alt1);
        this.matricula.setTurmaAlternativa(alt2);
        this.matricula.setSemestre(semestre);
        this.matricula.setAluno(this);
        return true;
    }
    
    public void inserePreferencial(Turma turma){
        this.matricula.inserePreferencial(turma);
        this.matricula.atualiza();
    }
    
    public void insereAlternativa(Turma turma){
        this.matricula.insereAlternativa(turma);
    }
    
    public void removeTurma(Turma turma){
        this.matricula.removeTurma(turma);
        this.matricula.atualiza();
    }
    
    public int qtdInscricoes(){
        return this.matricula.getTamanhoAlternativas() + matricula.getTamanhoPreferenciais();
    }
    
    public int qtdPreferenciaisCadastradas(){
        return this.matricula.getTamanhoPreferenciais();
    }
    
    public int qtdAlternativasCadastradas(){
        return this.matricula.getTamanhoAlternativas();
    }
    
    public void atualizaMatricula(){
        this.matricula.atualiza();
    }
    
    public void removeTurmaInscritaEfetivamente(Turma turma){
        this.matricula.removeInscricao(turma);
    }
    
    public void mostraInscricoes(){
        this.matricula.mostraTurmasInscritas();
    }
    
    public int getSemestreMatricula(){
        return this.matricula.getSemestre();
    }
    
    public String getNome() {
        return nome;
    }

    public long getCpf() {
        return cpf;
    }


    public long getId() {
        return id;
    }

    public float getCr() {
        return cr;
    }


    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }


}
