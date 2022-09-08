package uff.ic.lleme.tcc00328.s20202.exercicio.tutorialOOCont.GabrielAssis;

public class Disciplina {
    private String codigo;
    private String nome;
    private String sigla;
    
    public Disciplina(){
        
    }
    
    public Disciplina(String codigo, String nome, String sigla){
        this.codigo = codigo;
        this.nome = nome;
        this.sigla = sigla;
    }
    
    public String getCodigo(){
        return codigo;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getSigla(){
        return sigla;
    }
    
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setSigla(String sigla){
        this.sigla = sigla;
    }
}
