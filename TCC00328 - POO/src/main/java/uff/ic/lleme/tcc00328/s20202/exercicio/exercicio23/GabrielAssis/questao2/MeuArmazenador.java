package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio23.GabrielAssis.questao2;

public class MeuArmazenador<T> {
    private Object[] vetor = new Object[100];
    private int qtdElementos = 0;
    
    public void incluir(T objeto){
        if (this.qtdElementos < this.vetor.length){
            this.vetor[qtdElementos] = objeto;
            this.qtdElementos++;
        }
        else{
            Object[] vetorNovo = new Object[this.vetor.length * 2];
            
            for (int i = 0; i < qtdElementos; i++)
                vetorNovo[i] = this.vetor[i];
            
            this.vetor = vetorNovo;
            this.vetor[qtdElementos] = objeto;
            this.qtdElementos++;
        }
    }
    
    public T recuperar(int index){
        if(index > this.qtdElementos - 1 || index < 0){
            System.out.println("O índice não é válido!");
            return null;
        }
        else return (T) this.vetor[index];
    }
    
    public void remover(int index){
        if(index > this.qtdElementos - 1 || index < 0){
            System.out.println("Não há informação a ser removida nesse índice!!");
            return;
        }
        
        
        Object[] vetorAux = new Object[this.vetor.length];
        
        int j = 0;
        for (int i = 0; i < this.vetor.length; i++)
            if(i != index){
                vetorAux[j] = this.vetor[i];
                j++;
            }
        this.vetor = vetorAux;
        this.qtdElementos--;
        
        
        if (this.qtdElementos <= this.vetor.length/2) {
            Object[] novoVetor = new Object[this.vetor.length / 2];
            for (int i = 0; i < qtdElementos; i++){
                novoVetor[i] = this.vetor[i];
            }
            this.vetor = novoVetor; 
        }
    }
    
}
