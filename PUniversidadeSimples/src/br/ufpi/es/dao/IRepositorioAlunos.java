package br.ufpi.es.dao;

import java.sql.SQLException;
import java.util.List;

import br.ufpi.es.model.Aluno;
import br.ufpi.es.system.exception.AlunoNaoExistenteException;
import br.ufpi.es.system.exception.AlunosNaoCadastradosException;

public interface IRepositorioAlunos {
	
	/**
	 * Insere Aluno
	 * @param aluno
	 * @throws Exception 
	 */
	public void insereAluno(Aluno aluno) throws Exception;
	
	/**
	 * Dada a matricula retorna o aluno correspondente
	 * @param matricula
	 * @return Aluno
	 * @throws SQLException 
	 */
	public Aluno buscarAluno(String matricula) throws AlunoNaoExistenteException, Exception;
	
	/**
	 * Checa se existe o aluno dada a matricula 
	 * @param matricula
	 * @return true se existe, false se nao existe
	 * @throws SQLException 
	 */
	public boolean verificaExistenciaAluno(String matricula) throws Exception;
	
	/**
	 * Altera um aluno. A opção do atributo a ser alterado, a matricula do aluno e a nova informação devem ser passadas
	 * para o método.
	 * As opções são: 
	 * 1 - Matricula
	 * 2 - Nome
	 * 3 - Curso.
	 * @param op, matricula, info.
	 * @throws AlunoNaoExistenteException 
	 * @throws Exception 
	 */
	public void alterarAluno(Aluno a) throws  Exception;
//	public void alterarAluno(Aluno aluno) throws AlunoNaoExistenteException;
	/**
	 * Dada a matrícula remove o aluno do curso
	 * @param matricula
	 * @throws SQLException 
	 */
	public void removerAluno(String matricula) throws  AlunoNaoExistenteException, Exception;
	
	/**
	 * Lista todos os alunos do repositorio de alunos
	 * @return Lista de Alunos
	 * @throws SQLException 
	 */
	public List<Aluno> listarAlunos() throws AlunosNaoCadastradosException, Exception;
	
	/**
	 * Quantidade de alunos do repositorio
	 * @return inteiro
	 * @throws SQLException 
	 */
	public int quantidadeAlunos() throws Exception;

	
}