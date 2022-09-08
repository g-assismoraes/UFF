package uff.ic.lleme.tcc00328.s20202.prova.p1.GabrielAssis;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SistemaGestor {
    private SistemaGestor(){
    
    }
    
    public static Prato[] pratos;
    public static Pedido[] pedidos;
    
    public static void main(String args[]) throws IOException {
        carregaPratos("src/main/java/uff/ic/lleme/tcc00328/s20202/provas/p1/GabrielAssis/Pratos.txt");
        //O arquivo pedidos tem formato QtdItensPedidos NomePrato[0] QtdPrato[0] ... NomePrato[QtdItensPedidos] QtdPrato[QtdItensPedidos]
        carregaPedidos("src/main/java/uff/ic/lleme/tcc00328/s20202/provas/p1/GabrielAssis/Pedidos.txt");
        
        //Adicionei essa para ver o valor de todas as contas
        //valoresContas();
        
        //os index dos pedidos começam em 0
        valorPedido(0);
        
        percentualPorPrato();
    }
    
    
    private static void carregaPratos(String nomeArquivo) throws IOException {
        InputStream input = new FileInputStream(nomeArquivo);
        Scanner ler = new Scanner(input);
        int qtdLinhasArquivo = contaLinhas(nomeArquivo);
        
        pratos = new Prato[qtdLinhasArquivo];
        int i = 0;
        while (ler.hasNext()) {
            String nome = ler.next();
            float preco = ler.nextFloat();

            pratos[i] = new Prato(nome, preco);

            i += 1;
        }
        input.close();
       
    }
    
    private static void carregaPedidos(String nomeArquivo) throws IOException {
        InputStream input = new FileInputStream(nomeArquivo);
        Scanner ler = new Scanner(input);
        int qtdLinhasArquivo = contaLinhas(nomeArquivo);
        
        pedidos = new Pedido[qtdLinhasArquivo];
        int i = 0;
        while (ler.hasNext()) {
            int qtdItens = ler.nextInt();
            Pedido pedido = new Pedido(qtdItens);
            
            Item[] itens = new Item[qtdItens];
            for (int j = 0; j < qtdItens; j++) {
                String nome = ler.next();
                Prato prato = new Prato();
                for (int k = 0; k < pratos.length; k++) 
                    if(nome.equals(pratos[k].getNome()))
                        prato = pratos[k]; 
                int qtdItem = ler.nextInt();
                
                itens[j] = new Item(prato, qtdItem);
            }
            
            pedido.setItens(itens);
            pedidos[i] = pedido;
            i += 1;
        }
        
        input.close();
        
    }
    
    private static int contaLinhas(String nomeArquivo) throws IOException {
        int qtd = 0;
        InputStream input = new FileInputStream(nomeArquivo);
        Scanner ler = new Scanner(input);

        while (ler.hasNext()) {
            ler.nextLine();
            qtd++;
        }

        input.close();
        return qtd;
    }
    
    private static void valorPedido(int numPedido) {
        float valor = 0f;
        for(int j = 0; j < pedidos[numPedido].getItens().length; j++) {
            valor += pedidos[numPedido].getItens()[j].getQuantidade() * pedidos[numPedido].getItens()[j].getPrato().getPreco();
        }
            
        int index = numPedido + 1;
        System.out.println("A conta do pedido "+ index +" deu R$ " + valor);
        
        System.out.println("-----------------------------------------------------------------");
        System.out.println(""); System.out.println("");
    
    }
    
    private static void valoresContas() {
        for(int i = 0; i < pedidos.length; i++) {
            float valor = 0f;
            for(int j = 0; j < pedidos[i].getItens().length; j++) {
                valor += pedidos[i].getItens()[j].getQuantidade() * pedidos[i].getItens()[j].getPrato().getPreco();
            }
            
            int index = i + 1;
            System.out.println("A conta do pedido "+ index +" deu R$ " + valor);
            
        }
        
        System.out.println("-----------------------------------------------------------------");
        System.out.println(""); System.out.println("");
    }
    
    private static void percentualPorPrato(){
        float qtdPratosTotal = 0;
        for(int l = 0; l < pedidos.length; l++) 
            for (Item item : pedidos[l].getItens())
                qtdPratosTotal += item.getQuantidade();
             
        for(int i = 0; i < pratos.length; i++){
            float qtdPrato = 0;
            for(int j = 0; j < pedidos.length; j++) 
                for (Item item : pedidos[j].getItens()) 
                    if(pratos[i].getNome().equals(item.getPrato().getNome())) 
                        qtdPrato += item.getQuantidade();
                    
            float percentualPratoDaVez = (qtdPrato/qtdPratosTotal) * 100;
            
            System.out.println("O prato " + pratos[i].getNome() + " equivale a " + percentualPratoDaVez + "% dos pratos pedidos.");
        }
    }

}

