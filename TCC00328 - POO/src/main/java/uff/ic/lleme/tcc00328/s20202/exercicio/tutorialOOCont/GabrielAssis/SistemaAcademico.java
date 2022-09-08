package uff.ic.lleme.tcc00328.s20202.exercicio.tutorialOOCont.GabrielAssis;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class SistemaAcademico {
    private SistemaAcademico() {
    }
    ;
    
    public static Aluno[] alunos;
    public static Disciplina[] disciplinas;
    public static Turma[] turmas;
    public static Inscricao[] inscricoes;
    
    public static void main(String[] args) throws IOException {
        carregarAlunos("src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/tutorialOOCont/GabrielAssis/InformacoesAlunos.txt");
        carregarDisciplinas("src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/tutorialOOCont/GabrielAssis/InformacoesDisciplinas.txt");
        carregarTurmas("src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/tutorialOOCont/GabrielAssis/InformacoesTurmas.txt");
        carregarInscricoes("src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/tutorialOOCont/GabrielAssis/InformacoesInscricoes.txt");
        
        informarNotasDeAlunos();
        
        //adicionei essa funcao;
        mostraInformacoes();
    }
    
    private static void carregarAlunos(String nomeArquivo) throws IOException {
        InputStream input = new FileInputStream(nomeArquivo);
        Scanner ler = new Scanner(input);
        int qtdLinhasArquivo = contaLinhas(nomeArquivo);
        
        alunos = new Aluno[qtdLinhasArquivo];
        int i = 0;
        while (ler.hasNext()) {
            long cpf = ler.nextLong();
            int matricula = ler.nextInt();
            String departamento = ler.next();
            String nome = ler.nextLine();
            
            alunos[i] = new Aluno(cpf, matricula, departamento, nome);
            
            i += 1;
       }
        input.close();      
    }
    
    private static void carregarDisciplinas(String nomeArquivo) throws IOException {
        InputStream input = new FileInputStream(nomeArquivo);
        Scanner ler = new Scanner(input);
        int qtdLinhasArquivo = contaLinhas(nomeArquivo);
        
        disciplinas = new Disciplina[qtdLinhasArquivo];
        int i = 0;
        while (ler.hasNext()) {
            String codigo = ler.next();
            String sigla = ler.next();
            String nome = ler.nextLine();
            
            disciplinas[i] = new Disciplina(codigo, nome, sigla);
            
            i += 1;
       }
       
        input.close();      
    }
    
    private static void carregarTurmas(String nomeArquivo) throws IOException {
        InputStream input = new FileInputStream(nomeArquivo);
        Scanner ler = new Scanner(input);
        int qtdLinhasArquivo = contaLinhas(nomeArquivo);
        
        turmas = new Turma[qtdLinhasArquivo];
        int i = 0;
        while (ler.hasNext()) {
            String codTurma = ler.next();
            Disciplina disciplina = new Disciplina();
            for (int j = 0; j < disciplinas.length; j++)
                if (codTurma.equals(disciplinas[j].getCodigo())) {
                    disciplina = disciplinas[j];
                    break;
                }
            String codigo = ler.next();
            String horario = ler.next();
            int semestre = ler.nextInt();
            
            turmas[i] = new Turma(codigo, disciplina, semestre, horario);
            
            i += 1;
       }
        
        input.close();
    }
    
    private static void carregarInscricoes(String nomeArquivo) throws IOException {
        InputStream input = new FileInputStream(nomeArquivo);
        Scanner ler = new Scanner(input);
        int qtdLinhasArquivo = contaLinhas(nomeArquivo);
        
        inscricoes = new Inscricao[qtdLinhasArquivo];
        int i = 0;
        while (ler.hasNext()) {
            String codigoDisciplina = ler.next();
            String codigoTurma = ler.next();
            Turma turma = new Turma();
            for (int j = 0; j < turmas.length; j++) {
                if (codigoDisciplina.equals(turmas[j].getDisciplina().getCodigo()) && codigoTurma.equals(turmas[j].getCodigo())) {
                    turma = turmas[j];
                }
            }
            
            ler.next();// lixo horario
            
            int matricula = ler.nextInt();
            Aluno aluno = new Aluno();
            for (int j = 0; j < alunos.length; j++)
                if (matricula == alunos[j].getMatricula()){
                    aluno = alunos[j];
                }
            
            ler.nextInt(); // lixo semestre
            
            String data_matricula = ler.next();
            
            inscricoes[i] = new Inscricao(aluno, turma, data_matricula);
            
            i++;
        }
        
        for(int l = 0; l < alunos.length; l++) {
            int qtdInscricoesAluno = contaInscricoesAluno(alunos[l]);
            if (qtdInscricoesAluno > 0) {
                Inscricao[] inscricoesDoAluno = new Inscricao[qtdInscricoesAluno];
                int x = 0;
                for (int j = 0; j < inscricoes.length; j++) {
                    if (alunos[l].getMatricula() == inscricoes[j].getAluno().getMatricula()) {
                        inscricoesDoAluno[x] = inscricoes[j];
                        x++;
                    }
                }
    
            alunos[l].setInscricoes(inscricoesDoAluno);
            }   
        }
        
        input.close();
    }
    
    private static void informarNotasDeAlunos() throws IOException{
        Scanner ler = new Scanner(System.in);
        
        InputStream alunosArq = new FileInputStream("src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/tutorialOOCont/GabrielAssis/InformacoesAlunos.txt");
        Scanner lerAlunos = new Scanner(alunosArq);
        int qtdLinhasAlunos = contaLinhas("src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/tutorialOOCont/GabrielAssis/InformacoesAlunos.txt");
    
        InputStream inscricoesArq = new FileInputStream("src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/tutorialOOCont/GabrielAssis/InformacoesInscricoes.txt");
        Scanner lerInscricoes = new Scanner(inscricoesArq);
        int qtdLinhasInscricoes = contaLinhas("src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/tutorialOOCont/GabrielAssis/InformacoesInscricoes.txt");
        
        int[] matriculas = new int[qtdLinhasAlunos];
        for (int i = 0; i < qtdLinhasAlunos; i++) {
            lerAlunos.nextLong(); // lixo cpf
            matriculas[i] = lerAlunos.nextInt();
            lerAlunos.nextLine(); // lixo resto da linha
        }
        
        String[] codigosDisciplinas = new String[disciplinas.length];
        for (int j = 0; j < qtdLinhasInscricoes; j++) {
            String codigo = lerInscricoes.next();
            if (j == 0 || checaUnicidade(codigo, codigosDisciplinas))
                codigosDisciplinas[j] = codigo;
            lerInscricoes.nextLine(); // lixo resto da linha
        }
        
        for (int m = 0; m < matriculas.length; m++) {
            Aluno alunoDaVez = new Aluno();
            for (int a = 0; a < alunos.length; a++) {
                if (matriculas[m] == alunos[a].getMatricula()) {
                    alunoDaVez = alunos[a];
                    break;
                }
                
            }
            
            for (int cd = 0; cd < codigosDisciplinas.length; cd++) {
                for (int i = 0; i < alunoDaVez.getInscricoes().length; i++) {
                    if (codigosDisciplinas[cd].equals(alunoDaVez.getInscricoes()[i].getTurma().getDisciplina().getCodigo())) {
                        System.out.println("O aluno de matrícula " + alunoDaVez.getMatricula() + " está"
                        + " inscrito em " + alunoDaVez.getInscricoes()[i].getTurma().getDisciplina().getNome() + " - " 
                        + alunoDaVez.getInscricoes()[i].getTurma().getDisciplina().getCodigo() + " na turma "
                        + alunoDaVez.getInscricoes()[i].getTurma().getCodigo() + ".");
                        
                        System.out.println("Digite quantas notas o aluno possui nessa disciplina: ");
                        int qtdNotas = ler.nextInt();
                        float[] notas = new float[qtdNotas];
                        System.out.println("Digite agora, usando virgulas para os decimais, as " + qtdNotas + " notas:");
                        
                        for (int n = 0; n < qtdNotas; n++) {
                            notas[n] = ler.nextFloat();
                        }
                        
                        alunoDaVez.getInscricoes()[i].setNotas(notas);
                    }
                }
            }
        }
        
        alunosArq.close();
        inscricoesArq.close();
    }
    
    private static float[] calcularMedias(Aluno aluno){
        float[] medias = new float[aluno.getInscricoes().length];
        for (int i = 0; i < aluno.getInscricoes().length; i++) {
            float acumulador = 0f;
            for (int j = 0; j < aluno.getInscricoes()[i].getNotas().length; j++)
                acumulador += aluno.getInscricoes()[i].getNotas()[j];
            
            medias[i] = acumulador / aluno.getInscricoes()[i].getNotas().length;
        }
        
        return medias;
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
    
    private static int contaInscricoesAluno(Aluno aluno) {
        int qtd = 0;
        for (int j = 0; j < inscricoes.length; j++)
            if (inscricoes[j].getAluno().getMatricula() == aluno.getMatricula())
                qtd++;
        return qtd;
    }
    
    private static boolean checaUnicidade(String x, String[] vetor) {
        for (int i = 0; i < vetor.length; i++)
            if (x.equals(vetor[i]))
                return false;
        return true;
    }
    
    private static void mostraInformacoes(){
        System.out.println("--------------------------- Informações dos Alunos ---------------------------");
        System.out.println(""); System.out.println("");
        
        for (int i = 0; i < alunos.length; i++) {
            System.out.println("Informações de" + alunos[i].getNome() + ":");
            float[] medias = calcularMedias(alunos[i]);
            System.out.println("Matrícula: " + alunos[i].getMatricula());
            System.out.println("Disciplina x Média:");
            for(int j = 0; j < alunos[i].getInscricoes().length; j++) 
                System.out.println(alunos[i].getInscricoes()[j].getTurma().getDisciplina().getNome() + " - " + medias[j]);
            
            System.out.println(""); System.out.println("");
        }
        System.out.println("------------------------------------------------------------------------------");
    }
    
}
