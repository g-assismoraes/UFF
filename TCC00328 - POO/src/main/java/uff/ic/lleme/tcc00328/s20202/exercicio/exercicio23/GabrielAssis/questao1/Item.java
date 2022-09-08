package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio23.GabrielAssis.questao1;

public class Item {
    private Produto produto;
    private int quantidade;
    
    public Item(){
        
    }
    
    public Produto getProduto(){
        return this.produto;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    public void setProduto(Produto produto){
        this.produto = produto;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    
}
