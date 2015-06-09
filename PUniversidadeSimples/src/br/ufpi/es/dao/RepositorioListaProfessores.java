package br.ufpi.es.dao;

import java.util.LinkedList;
import java.util.List;

import br.ufpi.es.model.Professor;
import br.ufpi.es.system.exception.ProfessorNaoExistenteException;
import br.ufpi.es.system.exception.ProfessoresNaoCadastradosException;

public class RepositorioListaProfessores implements IRepositorioProfessores {
	private List<Professor> professores;

	/**
	 * Construtor do repositorio do tipo lista de professores. Intancia a lista
	 * para armazenar os professores.
	 */
	public RepositorioListaProfessores() {
		this.professores = new LinkedList<Professor>();
	}

	/**
	 * Metodo que insere um determinado professor na lista de professores.
	 * 
	 * @param professor
	 *            .
	 */
	public void insereProfessor(Professor professor) {
		this.professores.add(professor);
	}

	/**
	 * Metodo que busca um determinado professor na lista utilizando seu cpf
	 * como parametro da busca.
	 * 
	 * @param cpf
	 *            .
	 */
	public Professor buscarProfessor(String cpf)
			throws ProfessorNaoExistenteException {
		for (Professor p : this.professores) {
			if (p.getCpf().equals(cpf)) {
				return p;
			}
		}
		throw new ProfessorNaoExistenteException();
	}

	/**
	 * Metodo que verifica se um determinado professor esta na lista de
	 * professor. CPF do professor e usado como parametro da busca.
	 * 
	 * @param cpf
	 *            .
	 * @return true, se existe; false, se nao existe.
	 */
	public boolean verificaExistenciaProfessor(String cpf) {
		for (Professor p : this.professores) {
			if (p.getCpf().equals(cpf)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo que altera os dados de um determinado professor. A opcao do
	 * atributo a ser alterada, o cpf do professor e a nova informacao devem ser
	 * informados. As opcoes sao: 1 - CPF 2 - Nome 3 - Titulo 4 - Lotacao
	 * 
	 * @param op
	 *            , cpf, info.
	 */
	public void alterarProfessor(int op, String cpf, String info)
			throws ProfessorNaoExistenteException {
		Professor p = this.buscarProfessor(cpf);

		switch (op) {
		case 1: // CPF do professor.
			p.setCpf(info);
			break;
		case 2: // Nome do professor
			p.setNome(info);
			break;
		case 3: // Lotacao
			p.setLotacao(info);
			break;
		case 4:// Titulo do professor
			p.setTitulo(info);
			break;
		}
	}

	/**
	 * Remove um determinado professor da lista. O cpf do professor deve ser
	 * informado.
	 * 
	 * @param cpf
	 *            .
	 */
	public void removerProfessor(String cpf)
			throws ProfessorNaoExistenteException {
		Professor p = this.buscarProfessor(cpf);
		this.professores.remove(p);
	}

	/**
	 * Metodo que retorna todos os professores inseridos na lista.
	 * 
	 * @return professores.
	 */
	public List<Professor> listarProfessores()
			throws ProfessoresNaoCadastradosException {
		if (this.quantidadeProfessor() == 0) {
			throw new ProfessoresNaoCadastradosException();
		}
		return (this.professores);
	}

	/**
	 * Informa a quantidade de professores que estao inseridos na lista.
	 * 
	 * @return professores.size().
	 */
	public int quantidadeProfessor() {
		return this.professores.size();
	}
}
