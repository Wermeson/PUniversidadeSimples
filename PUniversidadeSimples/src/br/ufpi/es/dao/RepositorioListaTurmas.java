package br.ufpi.es.dao;

import java.util.LinkedList;
import java.util.List;

import br.ufpi.es.model.Turma;
import br.ufpi.es.system.exception.TurmaNaoExistenteException;
import br.ufpi.es.system.exception.TurmasNaoCadastradasException;

public class RepositorioListaTurmas implements IRepositorioTurmas {
	private List<Turma> turmas;

	/**
	 * Construtor padr�o da classe RepositorioLista Turmas. Instancia a lista
	 * para armazenar as turmas.
	 */
	public RepositorioListaTurmas() {
		this.turmas = new LinkedList<Turma>();
	}

	/**
	 * M�todo que insere uma determinada turma na lista.
	 * 
	 * @param turma
	 *            .
	 */
	public void insereTurma(Turma turma) {
		this.turmas.add(turma);
	}

	/**
	 * M�todo que busca uma turma na lista pela descri��o da disciplina.
	 * 
	 * @param disciplina
	 *            .
	 * @return turma.
	 */
	public Turma buscarTurma(String disciplina)
			throws TurmaNaoExistenteException {
		for (Turma t : turmas) {
			if (t.getDisciplina().equals(disciplina)) {
				return t;
			}
		}
		throw new TurmaNaoExistenteException();
	}

	/**
	 * M�todo que verifica se uma determinada turma est� na lista. A descri��o
	 * da disciplina deve ser passada como par�metro da pesquisa.
	 * 
	 * @param disciplina
	 *            .
	 * @return true, caso exista; false, caso n�o exista.
	 */
	public boolean verificaExistenciaTurma(String disciplina) {
		for (Turma t : turmas) {
			if (t.getDisciplina().equals(disciplina)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo que altera os dados de uma determinada turma. A opcao do atributo
	 * a ser alterado, a disciplina e a nova informacao devem ser informados. As
	 * opcoes sao: 1 - Departamento. 2 - Disciplina 3 - Horario
	 * 
	 * @param op
	 *            , disciplina, info.
	 * @throws RepositorioException
	 *             , TurmaNaoExistenteException
	 */
	public void alterarTurma(int op, String disciplina, String info)
			throws TurmaNaoExistenteException {
		Turma a = this.buscarTurma(disciplina);

		switch (op) {
		case 1: // Departamento.
			a.setDepartamento(info);
			break;
		case 2: // Disciplina
			a.setDisciplina(info);
			break;
		case 3: // Horario
			a.setCargaHoraria(Integer.parseInt(info));
			break;
		}
	}

	/**
	 * Dada a disciplina, remove a turma correspondente.
	 * 
	 * @param discplina
	 *            .
	 * @throws RepositorioException
	 *             , TurmaNaoExistenteException.
	 */
	public void removerTurma(String disciplina)
			throws TurmaNaoExistenteException {
		Turma t = this.buscarTurma(disciplina);
		this.turmas.remove(t);
	}

	/**
	 * Metodo que retorna todos a turmas inseridas na lista.
	 * 
	 * @return Lista de turmas.
	 * @throws RepositorioException
	 *             , TurmasNaoCadastradasException
	 */
	@Override
	public List<Turma> listarTurmas() throws TurmasNaoCadastradasException {
		if (this.quantidadeTurmas() == 0) {
			throw new TurmasNaoCadastradasException();
		}
		return (this.turmas);
	}

	/**
	 * Informa a quantidade de turmas que estao inseridas na lista.
	 * 
	 * @return turmas.size().
	 */
	@Override
	public int quantidadeTurmas() {
		return (this.turmas.size());
	}
}
