package uff.ic.lleme.tcc00328.s20202.prova.p1.GabrielAssis;

public class Pedido {
    private Item[] itens;
    
    public Pedido(){
        
    }
    
    public Pedido(int qtd){
        this.itens = new Item[qtd];
    }
    
    public Item[] getItens() {
        return itens;
    }
    
    public void setItens(Item[] itens) {
        this.itens = itens;
    }
}
