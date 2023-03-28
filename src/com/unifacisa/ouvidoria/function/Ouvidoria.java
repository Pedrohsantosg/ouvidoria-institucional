package com.unifacisa.ouvidoria.function;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.unifacisa.ouvidoria.entities.*;
import com.unifacisa.ouvidoria.entities.Manifestacao2;

/**
 * Classe responsável pelos métodos das manifestações
 * 
 * @author Pedro
 *
 */
public class Ouvidoria {
    private ArrayList<Pessoa> Pessoas;

    public Ouvidoria() {
        Pessoas = new ArrayList<>();
    }

    public void cadastrarManifestacao(Aluno user, int id) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Qual o tipo da manifestação? (1 - Reclamação, 2 - Sugestão, 3 - Elogio)");
            int tipo = scanner.nextInt();

            System.out.println("Qual o assunto da manifestação?");
            String assunto = scanner.next();

            System.out.println("Descreva a manifestação:");
            String descricao = scanner.next();

            Manifestacao2 novaManifestacao = new Manifestacao2(id, tipo, assunto, descricao);
            user.cadastrarManifestacao(novaManifestacao);

            System.out.println("Manifestação cadastrada com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Tipo de manifestação inválido!");
        }
        
    }

    public void exibirManifestacoes(Aluno user) {
        user.exibirManifestacoes();
    }

    public void cadastrarPessoa() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Qual o tipo de usuário? (1 - Aluno, 2 - Funcionário)");
            int tipo = scanner.nextInt();

            System.out.println("Digite o nome de usuário:");
            String nomePessoa = scanner.next();

            System.out.println("Digite a senha:");
            String senha = scanner.next();

            Pessoa novoPessoa = null;

            if (tipo == 1) {
                novoPessoa = new Aluno(nomePessoa, senha);
            } else if (tipo == 2) {
                novoPessoa = new Administracao(nomePessoa, senha);
            } else {
                throw new InputMismatchException("Tipo de usuário inválido!");
            }
            
            Pessoas.add(novoPessoa);
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        
    }

    public Pessoa fazerLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome de usuário:");
        String nomePessoa = scanner.next();

        System.out.println("Digite a senha:");
        String senha = scanner.next();

        for (Pessoa Pessoa : Pessoas) {
            if (Pessoa.autenticar(nomePessoa, senha)) {
                System.out.println("Login realizado com sucesso!");
                return Pessoa;
            }
        }

        System.out.println("Usuário e/ou senha inválidos!");
        return null;
    }
    
    /**
     * Deletar manifestações especificas
     * 
     * @throws Exception
     * @param id
     */

    public void deletarManifestacaoEspecifica(int id) {
        ArrayList<Aluno> alunos = new ArrayList<>();

        for (Pessoa Pessoa : Pessoas) {
            if (Pessoa instanceof Aluno) {
                alunos.add((Aluno) Pessoa);
            }
        }

        boolean saida = false;
        for (Aluno aluno : alunos) {
            try {
                saida = aluno.deletarManifestacao(id);
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
            if (saida) {
                break;
            }
        }

    }
    /**
     * 
     * @throws Exception
     */
	    
    public void deletarTodasManifestacoes() throws Exception {
        ArrayList<Aluno> alunos = new ArrayList<>();

        for (Pessoa Pessoa : Pessoas) {
            if (Pessoa instanceof Aluno) {
                alunos.add((Aluno) Pessoa);
            }
        }

        if (alunos.isEmpty()) {
            throw new Exception("Não há alunos cadastrados na ouvidoria!");
        }

        for (Aluno aluno : alunos) {
            try {
                aluno.resetManifestacoes();
            } catch (Exception e) {
                System.out.println("Erro ao deletar manifestações do aluno " + aluno.getNome() + ": " + e.getMessage());
            }
        }
    }
    /**
     * 
     * @throws Exception
     */

    public void exibirTodasManifestacoes() throws Exception {
        ArrayList<Aluno> alunos = new ArrayList<>();

        for (Pessoa Pessoa : Pessoas) {
            if (Pessoa instanceof Aluno) {
                alunos.add((Aluno) Pessoa);
            }
        }

        if (alunos.isEmpty()) {
            throw new Exception("Não há alunos cadastrados na ouvidoria!");
        }

        for (Aluno aluno : alunos) {
            try {
                aluno.exibirManifestacoes();
            } catch (Exception e) {
                System.out.println("Erro ao exibir manifestações do aluno " + aluno.getNome() + ": " + e.getMessage());
            }
        }
    }


}
