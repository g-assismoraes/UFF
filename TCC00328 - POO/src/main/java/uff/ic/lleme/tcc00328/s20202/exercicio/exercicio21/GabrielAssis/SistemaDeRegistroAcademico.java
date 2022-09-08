package uff.ic.lleme.tcc00328.s20202.exercicio.exercicio21.GabrielAssis;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaDeRegistroAcademico {
    public static Map<String, Disciplina> disciplinasOfertadas = new HashMap<>();
    public static Map<Long, Aluno> alunos = new HashMap<>();
    public static Map<Long, Professor> professores = new HashMap<>();
    
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        carregaDados();
        
        //internamente as funcoes ja estao com os dados que seriam capturados por teclado preenchidos
        int decisao = 0;
        System.out.println("Bem vindo ao SRA da Universidade XYZ");
        do{
            System.out.println("Digite: \n[1]Fazer matrícula, caso aluno\n[2]Editar matrícula, caso aluno\n[3]Consultar lista de Alunos, caso professor\n[OUTRO]Sair");
            decisao = ler.nextInt();
            if(decisao == 1)
                matricula();
            else if(decisao == 2)
                alteraMatricula();
            else if(decisao == 3)
                consultaAlunos();
            System.out.println();
        }while(decisao == 1 || decisao == 2 || decisao == 3);

    }
    
    public static void carregaDados(){
        //Hard-coded
        
        Professor professor1 = new Professor("João Lacerda", 1999999, 40028922);
        Professor professor2 = new Professor("Maria Almeida", 18888888, 40028921);
        Professor professor3 = new Professor("Veronica Deborah", 17777777, 40028929);
        professores.put(professor1.getId(), professor1);
        professores.put(professor2.getId(), professor2);
        professores.put(professor3.getId(), professor3);
        
        Curso cienciaDaComputacao = new Curso("Ciencia da Computacao", "TCC");
        
        Disciplina disciplina1 = new Disciplina("Programacao I", "TCC-000");
        Disciplina disciplina2 = new Disciplina("Programacao OO", "TCC-001");
        Disciplina disciplina3 = new Disciplina("Estrutura de Dados", "TCC-002");
        Disciplina disciplina4 = new Disciplina("Arquitetura de Computadores", "TCC-003");
        Disciplina disciplina5 = new Disciplina("Inteligencia Artificial", "TCC-004");
        Disciplina disciplina6 = new Disciplina("Laboratorio de Prog", "TCC-100");
        disciplinasOfertadas.put("TCC-000", disciplina1);
        disciplinasOfertadas.put("TCC-001", disciplina2);
        disciplinasOfertadas.put("TCC-002", disciplina3);
        disciplinasOfertadas.put("TCC-003", disciplina4);
        disciplinasOfertadas.put("TCC-004", disciplina5);
        disciplinasOfertadas.put("TCC-100", disciplina6);
        
        Turma turma1 = new Turma("A1", professor2, 25, 20202, disciplina1, cienciaDaComputacao);
        Turma turma2 = new Turma("A2", professor1, 20, 20202, disciplina1, cienciaDaComputacao);
        Turma turma3 = new Turma("B0", professor2, 30, 20202, disciplina2, cienciaDaComputacao);
        Turma turma4 = new Turma("A1", professor3, 25, 20202, disciplina3, cienciaDaComputacao);
        Turma turma5 = new Turma("F1", professor2, 25, 20202, disciplina4, cienciaDaComputacao);
        Turma turma6 = new Turma("F2", professor1, 28, 20202, disciplina5, cienciaDaComputacao);
        Turma turma7 = new Turma("C2", professor3, 20, 20202, disciplina6, cienciaDaComputacao);
        
        Aluno aluno1 = new Aluno("João Caetano Nascimento", 299999, 999999, "TCC", 8);
        Aluno aluno2 = new Aluno("Clara Victoria Pinheiro", 288888, 888888, "TCC", 7);
        alunos.put(aluno1.getId(), aluno1);
        alunos.put(aluno2.getId(), aluno2);    
    }
    
    public static void matricula(){
        Scanner ler = new Scanner(System.in);
        int semestreAtual = 20202;
        System.out.println(" ");
        System.out.println("Olá, aluno! Digite o seu id: ");
        long id = 999999; //ler.nextLong();
        
        if (!alunos.containsKey(id)){
            System.out.println("Parece que não há nenhuma informação referente a você. Consulte a sua Coordenação se achar"
                    + "que isso for um erro!!");
            return;
        }
        
        if(alunos.get(id).getSemestreMatricula() == semestreAtual){
            System.out.println("Parece que você já possui uma matrícula para esse semestre. Use a opção de alteração!");
            return;
        }
        
        System.out.println("Certo, " + alunos.get(id).getNome() + ". Aqui estão as turmas oferecidas: ");
        
        for (Disciplina disciplina:disciplinasOfertadas.values()) {
            disciplina.mostraTurmas(semestreAtual); //mostra as turmas do periodo atual
        }
        System.out.println(" ");
        //System.out.println("Digite 4 pares (Código Disciplina x Código Turma) para cadastrar as suas disciplinas preferenciais: ");
        String codD1 = "TCC-000";//ler.next();
        String codT1 = "A1";//ler.next();
        String codD2 = "TCC-004";//ler.next();
        String codT2 = "F2";//ler.next();
        String codD3 = "TCC-100"; //ler.next();
        String codT3 = "C2";//ler.next();
        String codD4 = "TCC-002"; //ler.next();
        String codT4 = "A1";//ler.next();
        
        //System.out.println("Agora digite 2 pares (Código Disciplina x Código Turma) para cadastrar as suas disciplinas alternativas: ");
        String codD5 = "TCC-001";//ler.next();
        String codT5 = "B0";//ler.next();
        String codD6 = "TCC-003";//ler.next();
        String codT6 = "F1"; //ler.next();
        
        boolean r = alunos.get(id).cadastraMatricula(pegaTurma(codD1, codT1), pegaTurma(codD2, codT2),
                pegaTurma(codD3, codT3), pegaTurma(codD4, codT4),
                pegaTurma(codD5, codT5), pegaTurma(codD6, codT6), semestreAtual);
        
        if(!r)
            return;
        
        alunos.get(id).atualizaMatricula();
        
        System.out.println("");
        System.out.println("Aqui estão suas inscrições efetivas após processamento: ");
        alunos.get(id).mostraInscricoes();
        System.out.println();
        
        
    }
    
    public static Turma pegaTurma(String codDisc, String codTurma){
        for (Disciplina disciplina:disciplinasOfertadas.values())
            if(disciplina.getCodigo().equals(codDisc))
                return disciplina.getTurma(codTurma);
        
        return null;
    }
    
    public static void alteraMatricula(){
        Scanner ler = new Scanner(System.in);
        int semestreAtual = 20202;
        System.out.println(" ");
        System.out.println("Olá, aluno! Digite o seu id: ");
        long id = 999999; //ler.nextLong();
        
        if (!alunos.containsKey(id)){
            System.out.println("Parece que não há nenhuma informação referente a você. Consulte a sua Coordenação se achar"
                    + "que isso for um erro!!");
            return;
        }
        
        if(alunos.get(id).getSemestreMatricula() != semestreAtual){
            System.out.println("Parece que você ainda não possui uma matrícula para esse semestre. Faça-a primeiro antes de qualquer alteração!!");
            return;
        }
        
        System.out.println("Certo, " + alunos.get(id).getNome() + ". Aqui estão suas inscrições efetivas atuais: ");
        alunos.get(id).mostraInscricoes();
        System.out.println("");
        
        System.out.println("LEMBRE-SE DE TER EM MÃOS O CÓDIGO DA DISCIPLINA + TURMA QUE DESEJA ALTERAR");
        int decisao = 0;
        System.out.println("Digite:   [1]Adicionar Disciplina       [2]Remover Disciplina");
        decisao = ler.nextInt();
        
        if (decisao == 1){
            if(alunos.get(id).qtdInscricoes() == 6){
                System.out.println("Você deve remover uma disciplina primeiro pois possui o numero máximo de inscrições!");
                return;
            }
            if(alunos.get(id).qtdPreferenciaisCadastradas() < 4){
                System.out.println("O sistema aponta que você não possui todas as Disciplinas Preferenciais preenchidas, logo a inserção será nessa categoria. Digite o código da disciplina e o da turma, respectivamente: ");
                String codD = "TCC-004"; // ler.next();
                String codT = "F2"; //ler.next();
                Turma turma = pegaTurma(codD, codT);
                if(turma == null){
                    System.out.println("Parece que essa turma não existe ou houve um erro de digitação. Consulte a Coordenação se achar que isso é um erro.");
                    return;
                }
                alunos.get(id).inserePreferencial(turma);
            }
            else if(alunos.get(id).qtdAlternativasCadastradas() < 2){
                System.out.println("O sistema aponta que você não possui todas as Disciplinas Alternativas preenchidas, logo a inserção será nessa categoria. Digite o código da disciplina e o da turma, respectivamente: ");
                String codD = ler.next();
                String codT = ler.next();
                Turma turma = pegaTurma(codD, codT);
                if(turma == null){
                    System.out.println("Parece que essa turma não existe ou houve um erro de digitação. Consulte a Coordenação se achar que isso é um erro.");
                    return;
                }
                alunos.get(id).insereAlternativa(turma);
            }
            
        }else if(decisao == 2){
            System.out.println("Digite o código da Disciplina e Turma a ser removida: ");
            String codD = "TCC-004"; // ler.next();
            String codT = "F2"; //ler.next();
            Turma turma = pegaTurma(codD, codT);
            if(turma == null){
                System.out.println("Parece que essa turma não existe ou houve um erro de digitação. Consulte a Coordenação se achar que isso é um erro.");
                return;
                }
            alunos.get(id).removeTurma(turma);
        }else{
            System.out.println("Comando inválido!");
            return;
        }
        
        System.out.println(" ");
        System.out.println("Aqui estão as suas Inscrições Efetivas após a alteração: ");
        alunos.get(id).mostraInscricoes();
        System.out.println(" ");
    }
    
    public static void consultaAlunos(){
        Scanner ler = new Scanner(System.in);
        System.out.println();
        System.out.println("Olá professor, digite a sua id: ");
        long id = 40028922; //ler.nextLong();
        
        if(!professores.containsKey(id)){
            System.out.println("Parece que não há informação compatível com esse ID. Consulte a Direção");
            return;
        }
        
        int decisao = 0;
        System.out.println("Digite:\n[1]Ver todos alunos de uma disciplina\n[2]Ver alunos para uma turma que você leciona"
                + "\n[OUTRO]Sair");
        decisao = ler.nextInt();
        if(decisao == 1){
            System.out.println("Digite o código da disciplina: ");
            String codigo = "TCC-004"; //ler.next();
            
            Disciplina disciplina = disciplinasOfertadas.get(codigo);
            if (disciplina == null) {
                System.out.println("Disciplina não existe.");
                return;
            }
            System.out.println("Alunos matriculados nessa disciplina: ");
            disciplina.mostraAlunosMatriculados();
            System.out.println();
        }
        else if (decisao == 2){
            System.out.println("Digite agora o código da Disciplina e Turma que deseja consultar: ");
            String codD = "TCC-004"; //ler.next();
            String codT = "F2"; //ler.next();
        
            Turma turma = professores.get(id).pegaTurma(codD, codT);
        
            if(turma == null){
                System.out.println("Parece que essa turma não existe.");
                return;
            }
        
            System.out.println("Alunos de " + turma.getDisciplina().getNome() +"(" + turma.getDisciplina().getCodigo() +
                ") - " + turma.getCodigo());
            turma.mostraMatriculados();
            System.out.println();
        }
        else return;
    }
    
}
