package uff.ic.lleme.tcc00328.s20202.prova.p1.GabrielAssis;

public class Prato {
    private String nome;
    private float preco;
    
    public Prato(){  
    }
    
    public Prato(String nome, float preco){
        this.nome = nome;
        this.preco = preco;
    }
    
    public String getNome(){
        return nome;
    }
    
    public float getPreco(){
        return preco;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setPreco(float preco){
        this.preco = preco;
    }
}
