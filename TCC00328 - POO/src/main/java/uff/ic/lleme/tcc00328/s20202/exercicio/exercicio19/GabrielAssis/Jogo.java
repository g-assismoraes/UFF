package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio19.GabrielAssis;

import java.util.Scanner;

public class Jogo {
    
    public static void main(String[] args) {
        apresentaIniciaJogo();  
    }
    
    private static void apresentaIniciaJogo() {
        Jogador jogador = new Jogador();
        Scanner ler = new Scanner(System.in);
        System.out.println("Olá, bem vindo ao Jogo de Dados!");
        System.out.println("Qual o seu nome? ");
        jogador.setNome(ler.nextLine());
        System.out.println("Ok, " + jogador.getNome() + "! Deixa eu te falar um pouco sobre o jogo:");
        System.out.println("2 dados serão lançados e a depender da soma de suas faces temos os seguintes casos:");
        System.out.println(" > Se a soma for 7 ou 11 logo de cara, você já é um vencedor!!! :D");
        System.out.println(" > Porém se for 2, 3 ou 12, você, infelizmente, já perdeu. :(");
        System.out.println("   Mas calma! Se você obtiver qualquer uma das outras somas ao jogar, você vai continuar"
                + " e marca o que chamamos de Ponto!!");
        System.out.println(" > Dessa forma, se você repetir esse Ponto antes de um 7, você GANHA!!");
        System.out.println(" > Por outro lado.... se um 7 vier antes de repetir o Ponto, "
                + "teremos um caso de DERROTA. :/");
        System.out.println(" "); System.out.println(" ");
        
        processa(jogador);
    }
    
    private static void processa(Jogador jogador) {
        Partida partida = new Partida();
        partida.setJogador(jogador);
        Scanner ler = new Scanner(System.in);
        int decisao;
        
        while (true) {
            System.out.println("Digite: ");
            System.out.println("[1] Jogar Dados");
            System.out.println("[2] Interromper o jogo.");
            decisao = ler.nextInt();
            
            if (decisao == 1) {
                System.out.println("Lançando dado para a próxima rodada......");
                System.out.println(" "); 
                partida.novaRodada();
                
                if (!partida.getStatus()){
                    if(partida.getRodada() == 1){
                        if (partida.isJogadorSaiuVitorioso()) {
                            System.out.println("Parabéns, " + partida.getJogador().getNome() + "! Você ganhou logo de cara!!!!!!!!!!");
                            System.out.println("Os dados somaram " + partida.getDado1().getUltimaFace() + " + " 
                            + partida.getDado2().getUltimaFace() + " = " + partida.getUltimaSomaObtida());
                        }
                        else if (!partida.isJogadorSaiuVitorioso()) {
                            System.out.println(partida.getJogador().getNome() + ", infelizmente você perdeu. :(");
                            System.out.println("Os dados somaram " + partida.getDado1().getUltimaFace() + " + " 
                            + partida.getDado2().getUltimaFace() + " = " + partida.getUltimaSomaObtida());
                        }
                    }
                    else{
                        if (partida.isJogadorSaiuVitorioso()) {
                            System.out.println("");
                            System.out.println("Parabéns, " + partida.getJogador().getNome() + "!!! Você GANHOU!!");
                            System.out.println("Os dados somaram " + partida.getDado1().getUltimaFace() + " + " +
                            partida.getDado2().getUltimaFace() + " = " + partida.getObjetivo() + " novamente!!");
                        }
                        else if (!partida.isJogadorSaiuVitorioso()) {
                            System.out.println("");
                            System.out.println(partida.getJogador().getNome() + ", infelizmente você perdeu!!");
                            System.out.println("Os dados somaram " + partida.getDado1().getUltimaFace() + " + " +
                            partida.getDado2().getUltimaFace() + " = 7 antes de você marcar Ponto novamente.");
                        }
                    }
                    break;
                }
                else{
                    if(partida.getRodada() == 1) 
                        System.out.println("Os dados somaram " + partida.getDado1().getUltimaFace() + " + " 
                        + partida.getDado2().getUltimaFace() + " = " + partida.getUltimaSomaObtida() +" e esse "
                        + "é o seu Ponto!");
                    else
                        System.out.println("Os dados somaram " + partida.getDado1().getUltimaFace() + " + "
                        + partida.getDado2().getUltimaFace() + " = " + partida.getUltimaSomaObtida());  
                }
            
            
            }
            else if (decisao == 2) {
                System.out.println("Até mais!");
                break;
            } 
            else
                System.out.println("Opa.. parece que você não digitou uma opção válida! Tente novamente...");
        }
        
        decisao = 0;
        
         System.out.println("O que deseja fazer? [1]JOGAR NOVAMENTE  [2]NOVO JOGADOR  [3]SAIR");
         decisao = ler.nextInt();
        
        
        
        if(decisao == 1)
            processa(jogador);
        else if(decisao == 2){
            jogador.mostraVitorias();
            System.out.println();
            apresentaIniciaJogo();
        }
        else if(decisao == 3)
            jogador.mostraVitorias();
    }
}