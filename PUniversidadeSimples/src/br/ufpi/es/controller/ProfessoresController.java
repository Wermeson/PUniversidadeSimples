package br.ufpi.es.controller;

import java.util.LinkedList;
import java.util.List;

import br.ufpi.es.dao.IRepositorioProfessores;
import br.ufpi.es.dao.RepositorioListaProfessores;
import br.ufpi.es.model.Professor;
import br.ufpi.es.model.Turma;
import br.ufpi.es.system.exception.ProfessorNaoExistenteException;
import br.ufpi.es.system.exception.ProfessorSemTurmaException;
import br.ufpi.es.system.exception.ProfessoresNaoCadastradosException;

public class ProfessoresController {
	private IRepositorioProfessores controleProfessores;

	/**
	 * Insancia o controlador de acordo com o tipo de repositorio.
	 * 
	 * @param tipo
	 */
	public ProfessoresController(IRepositorioProfessores tipo) {
		if (tipo instanceof RepositorioListaProfessores) {
			this.controleProfessores = new RepositorioListaProfessores();
			this.controleProfessores = tipo;
		}
	}

	/**
	 * Insere um professor no repositorio
	 * 
	 * @param professor
	 * @throws RepositorioException
	 */
	public void inserir(Professor professor) {
		this.controleProfessores.insereProfessor(professor);
	}

	/**
	 * Dado o cpf retorna o professor.
	 * 
	 * @param cpf
	 *            .
	 * @return professor.
	 * @throws RepositorioException
	 * @throws ProfessorNaoExistenteException
	 */
	public Professor buscar(String cpf) throws ProfessorNaoExistenteException {
		return this.controleProfessores.buscarProfessor(cpf);
	}

	/**
	 * Dada o cpf do professor, checa se ele existe
	 * 
	 * @param cpf
	 * @return true se existe; false se nao existe.
	 * @throws RepositorioException
	 */
	public boolean verificaSeProfessorExiste(String cpf) {
		return this.controleProfessores.verificaExistenciaProfessor(cpf);
	}

	/**
	 * Metodo que altera os dados de um determinado professor. A opcao do
	 * atributo a ser alterado, o cpf do professor e a nova informacao devem ser
	 * informados. As opcoes sao: 1 - CPF 2 - Nome 3 - Titulo 4 - Lotcacao
	 * 
	 * @param op
	 *            , cp, info.
	 * @param op
	 *            , cpf e info.
	 * @throws RepositorioException
	 * @throws ProfessorNaoExistenteException
	 */
	public void alterar(int op, String cpf, String info)
			throws ProfessorNaoExistenteException {
		this.controleProfessores.alterarProfessor(op, cpf, info);
	}

	/**
	 * Dado o cpf do professor, faz a remocao.
	 * 
	 * @param cpf
	 *            .
	 * @throws RepositorioException
	 * @throws ProfessorNaoExistenteException
	 */
	public void remover(String cpf) throws ProfessorNaoExistenteException {
		this.controleProfessores.removerProfessor(cpf);
	}

	/**
	 * Listar os professores do repositorio
	 * 
	 * @return listaProfessores.
	 * @throws RepositorioException
	 * @throws ProfessoresNaoCadastradosException
	 */
	public List<Professor> listar() throws ProfessoresNaoCadastradosException {
		return this.controleProfessores.listarProfessores();
	}

	/**
	 * Dado um professor, retorna todas as turmas em que ele leciona.
	 * 
	 * @param professor
	 *            .
	 * @return Lista de turmas.
	 * @throws ProfessorSemTurmaException
	 */
	public List<Turma> listarTurmaPorProfessor(Professor p)
			throws ProfessorSemTurmaException {
		if (p.getTurma().size() == 0) {
			throw new ProfessorSemTurmaException();
		}
		List<Turma> l = new LinkedList<Turma>();
		for (Turma t : p.getTurma()) {
			l.add(t);
		}

		return l;
	}

	/**
	 * Dados um professor e uma turma, relaciona a turma ao professor e
	 * vice-versa.
	 * 
	 * @param professor
	 *            , turma.
	 */
	public void associaProfessorTurma(Professor professor, Turma turma) {
		professor.getTurma().add(turma); // Adiciona uma turma ao professor.
		turma.setProfessor(professor); // relaciona o professo � turma.
	}

	/**
	 * Dados um professor e um turma, remove a turma do professor.
	 * 
	 * @param professor
	 *            , turma.
	 */
	public void removeProfessorTurma(Professor professor, Turma turma) {
		professor.getTurma().remove(turma);
		turma.setProfessor(null);
	}

	/**
	 * Retorna a quantidade de professores inseridos no repositorio.
	 * 
	 * @return quantidadeLivros.
	 */
	public int quantidadeProfessores() {
		return this.controleProfessores.quantidadeProfessor();
	}
}