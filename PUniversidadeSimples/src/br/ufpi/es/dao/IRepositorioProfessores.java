package br.ufpi.es.dao;

import java.util.List;

import br.ufpi.es.model.Professor;
import br.ufpi.es.system.exception.ProfessorNaoExistenteException;
import br.ufpi.es.system.exception.ProfessoresNaoCadastradosException;

public interface IRepositorioProfessores {

	/**
	 * Insere um professor.
	 * 
	 * @param professor
	 *            .
	 */
	public void insereProfessor(Professor professor);

	/**
	 * Dado um cpf, retorna o professor correspondente.
	 * 
	 * @param cpf
	 *            .
	 * @return professor.
	 */
	public Professor buscarProfessor(String cpf)
			throws ProfessorNaoExistenteException;

	/**
	 * Checa se existe professor dado o cpf.
	 * 
	 * @param cpf
	 *            .
	 * @return true se existe, false se n�o existe.
	 */
	public boolean verificaExistenciaProfessor(String cpf);

	/**
	 * Metodo que altera os dados de um determinado professor. A opcao do
	 * atributo a ser alterado, o cpf do professor e a nova informacao devem ser
	 * informados. As opcoes sao: 1 - CPF 2 - Nome 3 - Titulo 4 - Lotacao
	 * 
	 * @param op
	 *            , cp, info.
	 */
	public void alterarProfessor(int op, String cpf, String info)
			throws ProfessorNaoExistenteException;

	/**
	 * Dada o cpf remove o professor.
	 * 
	 * @param cpf
	 *            .
	 */
	public void removerProfessor(String cpf)
			throws ProfessorNaoExistenteException;

	/**
	 * Lista todos os professores do repositorio de professores.
	 * 
	 * @return Lista de professores
	 */
	public List<Professor> listarProfessores()
			throws ProfessoresNaoCadastradosException;

	/**
	 * Quantidade de professores do repositorio
	 * 
	 * @return quantidade.
	 */
	public int quantidadeProfessor();

}
