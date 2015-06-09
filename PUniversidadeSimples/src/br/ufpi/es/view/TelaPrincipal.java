package br.ufpi.es.view;

//package org.ufpi.es.visao;
//
//
//import java.util.List;
//
//import javax.swing.JOptionPane;
//
//import org.ufpi.es.controle.Fachada;
//import org.ufpi.es.controle.IFachada;
//import org.ufpi.es.dados.Aluno;
//import org.ufpi.es.sistema.excecoes.AlunoNaoExistenteException;
//import org.ufpi.es.sistema.excecoes.AlunosNaoCadastradosException;
//import org.ufpi.es.sistema.excecoes.RepositorioException;
//
//public class TelaPrincipal {
//	private static IFachada fachada = new Fachada();
//	
//	public static void main(String args[]) throws RepositorioException{
//		while(true){
//			String op = JOptionPane.showInputDialog("1 - Inserir Aluno\n2 - Alterar Aluno\n3 - Remover Aluno\n4 - Buscar Aluno\n5 - Listar Alunos\n0 - Sair");
//			switch(Integer.parseInt(op)){
//				//Inserir aluno
//				case 1:
//					String mat = JOptionPane.showInputDialog("Informe a matricula do aluno: ");
//					String nome = JOptionPane.showInputDialog("Informe o nome do aluno: ");
//					String curso = JOptionPane.showInputDialog("Informe o curso do aluno: ");
//					Aluno a = new Aluno(mat, nome, curso);
//					fachada.inserirAluno(a);
//					break;
//				case 2:
//					JOptionPane.showMessageDialog(null, "Funcao sera implementada em breve!");
//					break;
//				case 3:
//					try{
//						mat = JOptionPane.showInputDialog("Informe a matricula do aluno: ");
//						fachada.removerAluno(mat);
//					}catch(AlunoNaoExistenteException e){
//						JOptionPane.showMessageDialog(null, e.getMessage());
//					}
//					break;
//				case 4:
//					try{
//						mat = JOptionPane.showInputDialog("Informe a matricula do aluno: ");
//						Aluno aluno = fachada.buscarAluno(mat);
//						JOptionPane.showMessageDialog(null, "Id: "+aluno.getIdAluno()+"\nMatricula: "+aluno.getMatricula()+"\nNome: "+aluno.getNome()+"\nCurso: "+aluno.getCurso());
//					}catch(AlunoNaoExistenteException e){
//						JOptionPane.showMessageDialog(null, e.getMessage());
//					}
//					break;
//				case 5:
//					try{
//						List<Aluno> list = fachada.listarAlunos();
//						for(Aluno aluno:list){
//							JOptionPane.showMessageDialog(null, "Id: "+aluno.getIdAluno()+"\nMatricula: "+aluno.getMatricula()+"\nNome: "+aluno.getNome()+"\nCurso: "+aluno.getCurso());
//						}
//					}catch(AlunosNaoCadastradosException e){
//						JOptionPane.showMessageDialog(null, e.getMessage());
//					}
//					break;
//				case 0:
//					JOptionPane.showMessageDialog(null, "BYE");
//					return;
//			}
//		}
//	}
// }
