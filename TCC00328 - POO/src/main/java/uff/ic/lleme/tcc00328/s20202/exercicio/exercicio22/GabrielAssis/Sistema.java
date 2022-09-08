package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio22.GabrielAssis;

import java.util.Scanner;

public class Sistema {
    //imaginei processar somente um carnaval
    public static Carnaval carnaval;
    
    public static void main(String[] args){
      Scanner ler = new Scanner(System.in);
      registrarNovoCarnaval();
      
      int decisao = 0;
      do{
          System.out.println("Digite:\n[1]Registrar Nota\n[2]Computar Resultado\n[Outro]Sair");
          decisao = ler.nextInt();
          if(decisao == 1) registrarNota();
          if(decisao == 2) computarResultado();
      }while(decisao == 1 || decisao == 2);
      
  }
    
    public static void registrarNovoCarnaval(){
        //Teria a interface perguntando e capturando dados;
        int ano = 2020;
        int qtdQuesitos = 2;
        
        carnaval = new Carnaval(ano, qtdQuesitos);
        
        //registrar Jurados
        for(int i = 0; i < 5; i++)
            registrarNovoJurado(i);
        
        //perguntaria quantas escolas participantes irão ser cadastradas
        int qtdEscolas = 2;
        for(int i = 0; i < qtdEscolas; i++)
            registrarNovaEscola();
        
        //carnaval = new Carnaval(ano, qtdQuesitos, jurados, escolas);
        carnaval.inicializa();
            
    }
    
    public static void registrarNovoJurado(int index){
        Scanner ler = new Scanner(System.in);
        System.out.println("----- Registrar Jurado ----- ");
        System.out.println("Nome: ");
        String nome = ler.next();
        System.out.println("Registro: ");
        long registro = ler.nextLong();
        
        carnaval.setJurado(index, new Jurado(nome, registro));
        System.out.println();
    }
    
    public static void registrarNovaEscola(){
        Scanner ler = new Scanner(System.in);
        //coleta de dados
        System.out.println("----- Registro de Escola -----");
        System.out.println("Digite o nome da escola: ");
        String nome = ler.next();
        //String nome = "João de Barro";
        int qtdMembros = 250;
        String nomePresidente = "Barroso";
        String tema = "Mundo Pós-Pandemia";
        
        //estou registrando junto com o carnaval
        carnaval.setEscola(new Escola(nome, qtdMembros, nomePresidente, tema));
        System.out.println("---------------------------- ");
    }
    
    public static void registrarNota(){
        if(carnaval == null){
            System.out.println("Não há carnaval ativo!");
            return;
        }
        
        Scanner ler = new Scanner(System.in);
        System.out.println();
        System.out.println("-----   Registrar Nota   ----- ");
        //pergunta qual é o jurado
        System.out.println("Digite o seu registro de jurado: ");
        long registro = ler.nextLong();
        Jurado jurado = carnaval.pegaJurado(registro);
        if(jurado == null){
            System.out.println("Não há jurado com esse registro");
            return;
        }
        int indexJurado = carnaval.pegaIndexJurado(jurado);
        
        System.out.println("Digite o nome da escola para qual a nota será inserida: ");
        String nomeEscola = ler.next();
        //String nomeEscola = "João de Barro";
        Escola escola = carnaval.pegaEscola(nomeEscola);
        if(escola == null){
            System.out.println("Não foi encontrada uma escola correspondente.");
            return;
        }
        int decisao = 0;
        System.out.println("Digite [1]Cadastrar Única Nota   [2]Cadastrar Todas as Notas");
        decisao = ler.nextInt();
        
        if(decisao == 1){
            System.out.println("Para qual dos " + carnaval.getQtdQuesitos() + " quesistos é a sua nota?");
            int quesito = ler.nextInt();
            System.out.println("Qual é a nota a ser cadastrada?");
            float nota = ler.nextFloat();
        
            jurado.insereNota(escola, quesito, nota);
            escola.insereNota(quesito, indexJurado, nota);
        }
        
        if(decisao == 2){
            for (int i = 1; i <= carnaval.getQtdQuesitos(); i++){
                System.out.println("Digite a nota para o quesito " + i + ": ");
                int nota = ler.nextInt();
                jurado.insereNota(escola, i, nota);
                escola.insereNota(i, indexJurado, nota);
            }
        }
        
        if (decisao != 1 && decisao != 2){
            System.out.println("Não foi possível identificar o comando!");
            return;
        }
        System.out.println("------------------------------ ");
        System.out.println();
    }
    
    public static void computarResultado(){
        if(carnaval == null){
            System.out.println("Não há carnaval ativo!");
            return;
        }
        System.out.println("----------- RESULTADO -----------");
        Escola escola = carnaval.escolaComMaiorNota();
        
        if (escola == null) {
            System.out.println("Ocorreu um erro!");
            return;
        }
        System.out.println("A escola melhor colocada é " + escola.getNome() + " - " + escola.getMediaFinal());
        System.out.println();
        System.out.println("Notas das demais escolas: ");
        for (int i = 0; i < carnaval.getQtdEscolas(); i++)
            if(carnaval.getEscola(i) != escola)
                System.out.println(carnaval.getEscola(i).getNome() + " - " + carnaval.getEscola(i).getMediaFinal());
        System.out.println();
    }
}
