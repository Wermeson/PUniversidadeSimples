package br.ufpi.es.dao;

import java.util.List;

import br.ufpi.es.model.Aluno;
import br.ufpi.es.system.exception.AlunoNaoExistenteException;
import br.ufpi.es.system.exception.AlunosNaoCadastradosException;

public interface IRepositorioAlunos {

	/**
	 * Insere Aluno
	 * 
	 * @param aluno
	 * @throws Exception
	 */
	public void insereAluno(Aluno aluno) throws Exception;

	/**
	 * Faz a busca de aluno por matricula
	 * 
	 * @param matricula
	 *            tipo texto
	 * @return Aluno
	 * @throws AlunoNaoExistenteException
	 * @throws Exception
	 */
	public Aluno buscarAluno(String matricula)
			throws AlunoNaoExistenteException, Exception;

	/**
	 * Checa se existe o aluno dada a matricula
	 * 
	 * @param matricula
	 * @return true se existe, false se nao existe
	 * @throws Exception
	 */
	public boolean verificaExistenciaAluno(String matricula) throws Exception;

	/**
	 * Altera um aluno. A opção do atributo a ser alterado, a matricula do aluno
	 * e a nova inforção devem ser passadas para o método. As opções são: 1 -
	 * Matricula 2 - Nome 3 - Curso.
	 * 
	 * @param op
	 *            , matricula, info.
	 * @throws AlunoNaoExistenteException
	 * @throws Exception
	 */
	public void alterarAluno(Aluno a) throws Exception;

	/**
	 * Dada a matrícula remove o aluno do curso
	 * 
	 * @param matricula
	 * @throws Exception
	 */
	public void removerAluno(String matricula)
			throws AlunoNaoExistenteException, Exception;

	/**
	 * Lista todos os alunos do repositorio de alunos
	 * 
	 * @return Lista de Alunos
	 * @throws Exception
	 */
	public List<Aluno> listarAlunos() throws AlunosNaoCadastradosException,
			Exception;

	/**
	 * Quantidade de alunos do repositorio
	 * 
	 * @return inteiro
	 * @throws Exception
	 */
	public int quantidadeAlunos() throws Exception;

}