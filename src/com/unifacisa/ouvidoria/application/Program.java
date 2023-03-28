package com.unifacisa.ouvidoria.application;

import java.util.Scanner;

import com.unifacisa.ouvidoria.entities.*;
import com.unifacisa.ouvidoria.function.*;

public class Program {
    
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	Ouvidoria ouvidoria = new Ouvidoria();
	int id = 1;
	
	int option = 0;
	while(option != 3) {
		try {
			option = MostrarMenuLogin();
			if (option == 1) {
				 Pessoa usuarioLogado = ouvidoria.fazerLogin();
			        if (usuarioLogado instanceof Administracao) {
			            System.out.println("Usuário é um funcionário!");
			            int option2 = 0;
			            while(option2 != 4) {
			            	option2 = MostrarMenuAdministracao();
			            	if(option2 == 1) {
			            		ouvidoria.exibirTodasManifestacoes();
			            	} else if(option2 == 3) {
			            		ouvidoria.deletarTodasManifestacoes();
			            	} else if(option2 == 2) {
			            		System.out.print("Digite o Id: ");
			            		int index = sc.nextInt();
			            		ouvidoria.deletarManifestacaoEspecifica(index);
			            	} else if(option2 == 4) {
			            		break;
			            	}else {
			            		System.out.println("Alternativa inválida! Digite um valor entre 1 e 4.");
			            	}
			            }
			        } else if (usuarioLogado instanceof Aluno) {
			            System.out.println("Usuário é um aluno!");
			            int option2 = 0;
			            while(option2 != 3) {
			            	option2 = MostrarMenuAluno();
			            	if(option2 == 1) {
			            		ouvidoria.cadastrarManifestacao((Aluno) usuarioLogado, id);
			            		id++;
			            	} else if(option2 == 2) {
			            		ouvidoria.exibirManifestacoes((Aluno) usuarioLogado);
			            	} else if(option2 == 3) {
			            		break;
			            	}else {
			            		System.out.println("Alternativa inválida! Digite um valor entre 1 e 3.");
			            	}
			            }
			        }	
				} else if (option == 2) {
					ouvidoria.cadastrarPessoa();
				} else if (option == 3) {
					break;
				} else {
					System.out.println("Alternativa inválida! Digite um valor entre 1 e 3.");
				}
		} catch (NumberFormatException e) {
			System.out.println("Erro: valor digitado é negativo a um número válido!");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			sc.nextLine(); // Limpa o buffer do scanner
		}
	}
}
	
	private static int MostrarMenuLogin() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("|_________OUVIDORIA AIFOS___________|");
		System.out.println("|1) Entrar                          |");
		System.out.println("|2) Cadastrar                       |");
		System.out.println("|3) Sair                            |");
		System.out.println("|___________________________________|");
		
		return Integer.parseInt(sc.nextLine());

	}
    
    private static int MostrarMenuAluno() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("|_________OUVIDORIA AIFOS___________|");
		System.out.println("|1) Cadastrar Manifestação          |");
		System.out.println("|2) Listar Manifestação             |");
		System.out.println("|3) Sair                            |");
		System.out.println("|___________________________________|");
		
		return Integer.parseInt(sc.nextLine());
	}
    
    private static int MostrarMenuAdministracao() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("|_________OUVIDORIA AIFOS___________|");
		System.out.println("|1) Listar Manifestação             |");
		System.out.println("|2) Deletar Manifestação Específica |");
		System.out.println("|3) Deletar todas as Manifestações  |");
		System.out.println("|4) Sair                            |");
		System.out.println("|___________________________________|");
		
		return Integer.parseInt(sc.nextLine());
	}
}



