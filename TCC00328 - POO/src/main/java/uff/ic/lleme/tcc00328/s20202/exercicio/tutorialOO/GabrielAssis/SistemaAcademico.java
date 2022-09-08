package uff.ic.lleme.tcc00328.s20202.exercicio.tutorialOO.GabrielAssis;

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
    public static Inscricao[] inscricoes;

    public static void main(String[] args) throws IOException {
        carregarAlunos("src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/tutorialOO/GabrielAssis/InformacoesAlunos.txt");
        carregarDisciplinas("src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/tutorialOO/GabrielAssis/InformacoesDisciplinas.txt");
        carregarInscricoes("src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/tutorialOO/GabrielAssis/InformacoesInscricoes.txt");

        informarNotasDeAlunos();

        // adicionei essa funcao;
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

    private static void carregarInscricoes(String nomeArquivo) throws IOException {
        InputStream input = new FileInputStream(nomeArquivo);
        Scanner ler = new Scanner(input);
        int qtdLinhasArquivo = contaLinhas(nomeArquivo);

        inscricoes = new Inscricao[qtdLinhasArquivo];
        int i = 0;
        while (ler.hasNext()) {
            String codigoDisciplina = ler.next();
            Disciplina disciplina = new Disciplina();
            for (int j = 0; j < disciplinas.length; j++)
                if (codigoDisciplina.equals(disciplinas[j].codigo))
                    disciplina = disciplinas[j];

            int matricula = ler.nextInt();
            Aluno aluno = new Aluno();
            for (int j = 0; j < alunos.length; j++)
                if (matricula == alunos[j].matricula)
                    aluno = alunos[j];

            String data_matricula = ler.next();

            inscricoes[i] = new Inscricao(aluno, disciplina, data_matricula);

            i++;
        }

        for (int l = 0; l < alunos.length; l++) {
            int qtdInscricoesAluno = contaInscricoesAluno(alunos[l]);
            if (qtdInscricoesAluno > 0) {
                Inscricao[] inscricoesDoAluno = new Inscricao[qtdInscricoesAluno];
                int x = 0;
                for (int j = 0; j < inscricoes.length; j++)
                    if (alunos[l].matricula == inscricoes[j].aluno.matricula) {
                        inscricoesDoAluno[x] = inscricoes[j];
                        x++;
                    }

                alunos[l].inscricoes = inscricoesDoAluno;
            }
        }

        input.close();
    }

    private static void informarNotasDeAlunos() throws IOException {
        Scanner ler = new Scanner(System.in);

        InputStream alunosArq = new FileInputStream("src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/tutorialOO/GabrielAssis/InformacoesAlunos.txt");
        Scanner lerAlunos = new Scanner(alunosArq);
        int qtdLinhasAlunos = contaLinhas("src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/tutorialOO/GabrielAssis/InformacoesAlunos.txt");

        InputStream inscricoesArq = new FileInputStream("src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/tutorialOO/GabrielAssis/InformacoesInscricoes.txt");
        Scanner lerInscricoes = new Scanner(inscricoesArq);
        int qtdLinhasInscricoes = contaLinhas("src/main/java/uff/ic/lleme/tcc00328/s20202/exercicios/tutorialOO/GabrielAssis/InformacoesInscricoes.txt");

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
            for (int a = 0; a < alunos.length; a++)
                if (matriculas[m] == alunos[a].matricula) {
                    alunoDaVez = alunos[a];
                    break;
                }

            for (int cd = 0; cd < codigosDisciplinas.length; cd++)
                for (int i = 0; i < alunoDaVez.inscricoes.length; i++)
                    if (codigosDisciplinas[cd].equals(alunoDaVez.inscricoes[i].disciplina.codigo)) {
                        System.out.println("O aluno de matrícula " + alunoDaVez.matricula + " está"
                                + " inscrito em " + alunoDaVez.inscricoes[i].disciplina.nome + " - "
                                + alunoDaVez.inscricoes[i].disciplina.codigo + ".");

                        System.out.println("Digite quantas notas o aluno possui nessa disciplina: ");
                        int qtdNotas = ler.nextInt();
                        float[] notas = new float[qtdNotas];
                        System.out.println("Digite agora, usando virgulas para os decimais, as " + qtdNotas + " notas:");

                        for (int n = 0; n < qtdNotas; n++)
                            notas[n] = ler.nextFloat();

                        alunoDaVez.inscricoes[i].notas = notas;
                    }
        }

        alunosArq.close();
        inscricoesArq.close();
    }

    private static float[] calcularMedias(Aluno aluno) {
        float[] medias = new float[aluno.inscricoes.length];
        for (int i = 0; i < aluno.inscricoes.length; i++) {
            float acumulador = 0f;
            for (int j = 0; j < aluno.inscricoes[i].notas.length; j++)
                acumulador += aluno.inscricoes[i].notas[j];

            medias[i] = acumulador / aluno.inscricoes[i].notas.length;
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
            if (inscricoes[j].aluno.matricula == aluno.matricula)
                qtd++;
        return qtd;
    }

    private static boolean checaUnicidade(String x, String[] vetor) {
        for (int i = 0; i < vetor.length; i++)
            if (x.equals(vetor[i]))
                return false;
        return true;
    }

    private static void mostraInformacoes() {
        System.out.println("--------------------------- Informações dos Alunos ---------------------------");
        System.out.println("");
        System.out.println("");

        for (int i = 0; i < alunos.length; i++) {
            System.out.println("Informações de" + alunos[i].nome + ":");
            float[] medias = calcularMedias(alunos[i]);
            System.out.println("Matrícula: " + alunos[i].matricula);
            System.out.println("Disciplina x Média:");
            for (int j = 0; j < alunos[i].inscricoes.length; j++)
                System.out.println(alunos[i].inscricoes[j].disciplina.nome + " - " + medias[j]);

            System.out.println("");
            System.out.println("");
        }
        System.out.println("------------------------------------------------------------------------------");
    }

}
