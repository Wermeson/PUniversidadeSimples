package br.ufpi.es.view;

import java.util.Scanner;

import br.ufpi.es.controller.Fachada;

public class TelaPrincipalConsole {

	public static void main(String args[]) {
		Fachada fachada = new Fachada();
		int opcao;
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("============== Menu Principal =============");
			System.out.println("1 - Aluno");
			System.out.println("2 - Professor");
			System.out.println("3 - Turma");
			System.out.println("4 - Sair");
			System.out.println("===========================================");
			opcao = s.nextInt();
			if (opcao == 4) {
				break;
			}
			switch (opcao) {
			case 1:
				TelaAluno telaAluno = new TelaAluno();
				telaAluno.mostrarTela(opcao, s, fachada);
				break;

			default:
				System.out.println("Opção inválida! Tente novamente!");
				break;
			}
		}

	}

}
