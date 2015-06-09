package br.ufpi.es.controller;

import java.util.LinkedList;
import java.util.List;

import br.ufpi.es.dao.IRepositorioTurmas;
import br.ufpi.es.dao.RepositorioListaTurmas;
import br.ufpi.es.model.Aluno;
import br.ufpi.es.model.Turma;
import br.ufpi.es.system.exception.DepartamentoNaoExisteException;
import br.ufpi.es.system.exception.TurmaNaoExistenteException;
import br.ufpi.es.system.exception.TurmaSemAlunoException;
import br.ufpi.es.system.exception.TurmasNaoCadastradasException;

public class TurmasController {
	private IRepositorioTurmas controleTurmas;

	/**
	 * Insancia o controlador de acordo com o tipo de repositorio.
	 * 
	 * @param tipo
	 *            .
	 */
	public TurmasController(IRepositorioTurmas tipo) {
		if (tipo instanceof RepositorioListaTurmas) {
			this.controleTurmas = new RepositorioListaTurmas();
			this.controleTurmas = tipo;
		}
	}

	/**
	 * Insere uma turma no repositorio
	 * 
	 * @param turma
	 *            .
	 * @throws RepositorioException
	 */
	public void inserir(Turma turma) {
		this.controleTurmas.insereTurma(turma);
	}

	/**
	 * Dada a disciplina, retorna a turma.
	 * 
	 * @param disciplina
	 * @return turma.
	 * @throws RepositorioException
	 */
	public Turma buscar(String disciplina) throws TurmaNaoExistenteException {
		return this.controleTurmas.buscarTurma(disciplina);
	}

	/**
	 * Dada a a disciplina, checa se a turma existe
	 * 
	 * @param disciplina
	 *            .
	 * @return true se existe; false, se n�o existe.
	 */
	public boolean verificaSeTurmaExiste(String disciplina) {
		return this.controleTurmas.verificaExistenciaTurma(disciplina);
	}

	/**
	 * Metodo que altera os dados de uma determinada turma. A opcao do atributo
	 * a ser alterado, a disciplina e a nova informacao devem ser informados. As
	 * opcoes sao: 1 - Departamento. 2 - Disciplina 3 - Horario 4 - Quantidade
	 * de alunos.
	 * 
	 * @param op
	 *            , disciplina, info.
	 * @throws RepositorioException
	 *             , TurmaNaoExistenteException
	 */
	public void alterar(int op, String disciplina, String info)
			throws TurmaNaoExistenteException {
		this.controleTurmas.alterarTurma(op, disciplina, info);
	}

	/**
	 * Dada a disciplina, faz a remocao da turma.
	 * 
	 * @param disciplina
	 *            .
	 * @throws RepositorioException
	 */
	public void remover(String disciplina) throws TurmaNaoExistenteException {
		this.controleTurmas.removerTurma(disciplina);
	}

	/**
	 * Listar as turmas do repositorio
	 * 
	 * @return Lista de turmas.
	 * @throws RepositorioException
	 *             , AlunosNaoCadastradosException.
	 */
	public List<Turma> listar() throws TurmasNaoCadastradasException {
		return this.controleTurmas.listarTurmas();
	}

	/**
	 * Retorna todas as turmas de um determinado departamento.
	 * 
	 * @param departamento
	 *            .
	 * @return Lista de turmas.
	 * @throws RepositorioException
	 *             , TurmasNaoCadastradasException,
	 *             DepartamentoSemTurmaException
	 */
	public List<Turma> listarTurmasPorDepartamento(String departamento)
			throws TurmasNaoCadastradasException,
			DepartamentoNaoExisteException {
		List<Turma> turmas = this.controleTurmas.listarTurmas();

		List<Turma> retorno = new LinkedList<Turma>();

		for (Turma t : turmas) {
			if (t.getDepartamento().equals(departamento)) {
				retorno.add(t);
			}
		}

		if (retorno.size() == 0) {
			throw new DepartamentoNaoExisteException();
		}
		return retorno;
	}

	/**
	 * Lista todos os alunos que estao em uma determinada turma.
	 * 
	 * @param turma
	 *            .
	 * @return Lista de alunos.
	 * @throws TurmaSemAlunoException
	 */
	public List<Aluno> listarAlunoPorTurma(Turma t)
			throws TurmaSemAlunoException {

		if (t.getAluno().size() == 0) {
			throw new TurmaSemAlunoException();
		}
		List<Aluno> retorno = new LinkedList<Aluno>();
		for (Aluno a : t.getAluno()) {
			retorno.add(a);
		}

		return retorno;
	}

	/**
	 * retorna a quantidade de turmas existentes no repositorio.
	 * 
	 * @return quantidade.
	 */
	public int quantidadeTurmas() {
		return this.controleTurmas.quantidadeTurmas();
	}
}