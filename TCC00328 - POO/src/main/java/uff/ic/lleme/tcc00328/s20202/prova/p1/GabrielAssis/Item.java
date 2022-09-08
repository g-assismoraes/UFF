package uff.ic.lleme.tcc00328.s20202.prova.p1.GabrielAssis;

public class Item {
    private Prato prato;
    private int quantidade;
    
    public Item() {
        
    }
    
    public Item(Prato prato, int quantidade) {
        this.prato = prato;
        this.quantidade = quantidade;
    }
    
    public Prato getPrato(){
        return prato;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public void setPrato(Prato prato){
        this.prato = prato;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
}
