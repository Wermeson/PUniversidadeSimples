/**
 * 
 */
package br.ufpi.es.view;

import java.util.List;
import java.util.Scanner;

import br.ufpi.es.controller.Fachada;
import br.ufpi.es.model.Professor;

/**
 * @author WermesonReis
 *
 */
public class TelaProfessor {

	public void mostrarTela(int opcao, Scanner s, Fachada fachada) {
		while (true) {
			System.out
					.println("======================== Menu - Professor ======================");
			System.out.println("1 - Inserir");
			System.out.println("2 - Listar");
			System.out.println("3 - Buscar");
			System.out.println("4 - Remover");
			System.out.println("5 - Alterar");
			System.out.println("6 - Quantidade de Professores");
			System.out.println("7 - Voltar para o menu principal");
			System.out
					.println("=============================================================");
			opcao = s.nextInt();
			if (opcao == 7) {
				break;
			}
			switch (opcao) {
			case 1:
				Scanner s1 = new Scanner(System.in);
				System.out.println("Informe o CPF do Professor:");
				String cpf = s1.nextLine();
				System.out.println("Informe o nome do Professor:");
				String nome = s.next();
				System.out.println("Informe a lotacao do Professor:");
				String lotacao = s.next();
				System.out.println("Informe o titulo do Professor:");
				String titulo = s.next();
				Professor p = new Professor(cpf, nome, lotacao, titulo);
				try {
					fachada.inserirProfessor(p);
					System.out.println("\n\nProfessor inserido com sucesso");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					List<Professor> listaProfessores = fachada
							.listarProfessores();
					for (Professor p2 : listaProfessores) {
						System.out
								.println("-----------------------------------");
						System.out.println("CPF:" + p2.getCpf() + "\nNome:"
								+ p2.getNome() + "\nLotacao:" + p2.getLotacao()
								+ "\nTitulo:" + p2.getTitulo());
						System.out
								.println("-----------------------------------");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					System.out.println("Informe o CPF do Professor: ");
					String cpf2 = s.next();
					Professor p3 = fachada.buscarProfessor(cpf2);
					System.out.println("-----------------------------------");
					System.out.println("CPF:" + p3.getCpf() + "\nNome:"
							+ p3.getNome() + "\nLotacao:" + p3.getLotacao()
							+ "\nTitulo:" + p3.getTitulo());
					System.out.println("-----------------------------------");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				try {
					System.out.println("Informe o CPF do Professor: ");
					String cpf3 = s.next();
					fachada.removerProfessor(cpf3);
					System.out.println("Professor removido com sucesso.");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				break;
			case 6:
				try {
					int quant = fachada.quantidadeProfessores();
					System.out.println("Quantidade de professores: " + quant);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				System.out.println("Op��o inv�lida! Tente novamente!");
				break;
			}
		}
	}
}
