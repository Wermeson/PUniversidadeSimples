/**
 * 
 */
package br.ufpi.es.view;

import java.util.List;
import java.util.Scanner;

import br.ufpi.es.controller.Fachada;
import br.ufpi.es.model.Turma;

/**
 * @author WermesonReis
 *
 */
public class TelaTurma {
	public void mostrarTela(int opcao, Scanner s, Fachada fachada) {
		while (true) {
			System.out
					.println("======================== Menu - Turma ======================");
			System.out.println("1 - Inserir");
			System.out.println("2 - Listar");
			System.out.println("3 - Listar por Departamento");
			System.out.println("4 - Buscar");
			System.out.println("5 - Remover");
			System.out.println("6 - Alterar");
			System.out.println("7 - Quantidade de Turmas");
			System.out.println("8 - Voltar para o menu principal");
			System.out
					.println("=============================================================");
			opcao = s.nextInt();
			if (opcao == 8) {
				break;
			}
			switch (opcao) {
			case 1:
				Scanner s1 = new Scanner(System.in);
				System.out
						.println("Informe o Departamento a qual a turma pertence:");
				String departamento = s1.nextLine();
				System.out.println("Informe o nome da disciplina:");
				String disciplina = s.next();
				System.out.println("Informe a carga hor�ria");
				String cargaHoraria = s.next();
				Turma t = new Turma(departamento, disciplina,
						Integer.parseInt(cargaHoraria));
				try {
					fachada.inserirTurma(t);
					System.out.println("\n\nTurma inserida com sucesso");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					List<Turma> listaTurmas = fachada.listarTurmas();
					for (Turma t2 : listaTurmas) {
						System.out
								.println("-----------------------------------");
						System.out.println("Departamento:"
								+ t2.getDepartamento() + "\nDisciplina:"
								+ t2.getDisciplina() + "\nCarga Horaria:"
								+ t2.getCargaHoraria());
						System.out
								.println("-----------------------------------");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				Scanner s11 = new Scanner(System.in);
				System.out.println("Informe o Departamento:");
				String departamento1 = s11.nextLine();
				try {
					List<Turma> listaTurmas = fachada
							.listarTurmasPorDepartamento(departamento1);
					for (Turma t2 : listaTurmas) {
						System.out
								.println("-----------------------------------");
						System.out.println("Departamento:"
								+ t2.getDepartamento() + "\nDisciplina:"
								+ t2.getDisciplina() + "\nCarga Horaria:"
								+ t2.getCargaHoraria());
						System.out
								.println("-----------------------------------");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				try {
					System.out.println("Informe o nome da Disciplina: ");
					String disciplina2 = s.next();
					Turma t3 = fachada.buscarTurma(disciplina2);
					System.out.println("-----------------------------------");
					System.out.println("-----------------------------------");
					System.out.println("Departamento:" + t3.getDepartamento()
							+ "\nDisciplina:" + t3.getDisciplina()
							+ "\nCarga Horaria:" + t3.getCargaHoraria());
					System.out.println("-----------------------------------");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				try {
					System.out.println("Informe o nome da disclipna: ");
					String disciplina3 = s.next();
					fachada.removerTurma(disciplina3);
					System.out.println("Turma removida com sucesso.");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				break;
			case 7:
				try {
					int quant = fachada.quantidadeTurma();
					System.out.println("Quantidade de turmas: " + quant);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				System.out.println("Opcao invalida! Tente novamente!");
				break;
			}
		}
	}
}
