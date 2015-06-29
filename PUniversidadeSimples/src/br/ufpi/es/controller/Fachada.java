package br.ufpi.es.controller;

import java.sql.SQLException;
import java.util.List;

import br.ufpi.es.dao.IRepositorioAlunos;
import br.ufpi.es.dao.IRepositorioProfessores;
import br.ufpi.es.dao.IRepositorioTurmas;
import br.ufpi.es.dao.RepositorioListaAlunos;
import br.ufpi.es.dao.RepositorioListaProfessores;
import br.ufpi.es.dao.RepositorioListaTurmas;
import br.ufpi.es.model.Aluno;
import br.ufpi.es.model.Professor;
import br.ufpi.es.model.Turma;
import br.ufpi.es.system.exception.AlunoNaoExistenteException;
import br.ufpi.es.system.exception.AlunosNaoCadastradosException;
import br.ufpi.es.system.exception.DepartamentoNaoExisteException;
import br.ufpi.es.system.exception.ProfessorNaoExistenteException;
import br.ufpi.es.system.exception.ProfessorSemTurmaException;
import br.ufpi.es.system.exception.ProfessoresNaoCadastradosException;
import br.ufpi.es.system.exception.TurmaNaoExistenteException;
import br.ufpi.es.system.exception.TurmaSemAlunoException;
import br.ufpi.es.system.exception.TurmasNaoCadastradasException;

public class Fachada implements IFachada {
	private AlunosController meuControleAlunos;
	private ProfessoresController meuControleProfessor;
	private TurmasController meuControleTurmas;

	// private IRepositorioAlunos repositorioListaAlunos;
	private IRepositorioAlunos repositorioBancoAlunos;
	private IRepositorioProfessores repositorioProfessores;
	private IRepositorioTurmas repositorioTurmas;

	/**
	 * Construtor padrao da classe Fachada. Ao instanciar um objeto do tipo
	 * Fachada, e definido um tipo de repositorio para armazenar os dados.
	 */
	public Fachada() {
		// this.repositorioListaAlunos = new RepositorioListaAlunos();
		this.repositorioBancoAlunos = new RepositorioListaAlunos();

		this.repositorioProfessores = new RepositorioListaProfessores();
		this.repositorioTurmas = new RepositorioListaTurmas();

		// this.meuControleAlunos = new
		// AlunosController(repositorioListaAlunos);
		this.meuControleAlunos = new AlunosController(repositorioBancoAlunos);
		this.meuControleProfessor = new ProfessoresController(
				repositorioProfessores);
		this.meuControleTurmas = new TurmasController(repositorioTurmas);
	}

	/**
	 * Insere um aluno.
	 * 
	 * @throws SQLException
	 * @throws RepositorioException
	 */
	@Override
	public void inserirAluno(Aluno aluno) throws Exception {
		this.meuControleAlunos.inserir(aluno);
	}

	/**
	 * Metodo altera os dados de um determinado aluno. A opcao do atributo a ser
	 * alterado, a matricula do aluno e a nova informacao devem ser informados.
	 * * As opcoes sao: 1 - Matricula 2 - Nome 3 - Curso.
	 * 
	 * @param op
	 *            , matricula, info.
	 * @throws Exception
	 * @throws RepositorioException
	 *             , AlunoNaoExistenteException
	 */
	@Override
	public void alterarAluno(Aluno a) throws Exception {
		this.meuControleAlunos.alterarAluno(a);
	}

	/**
	 * Remove um determiando aluno.
	 * 
	 * @param matricula
	 *            .
	 * @throws SQLException
	 * @throws RepositorioException
	 *             , AlunoNaoExistenteException.
	 */
	@Override
	public void removerAluno(String matricula)
			throws AlunoNaoExistenteException, Exception {
		this.meuControleAlunos.remover(matricula);
	}

	/**
	 * Metodo que busca uma determinado aluno pela matricula.
	 * 
	 * @param matricula
	 *            .
	 * @throws SQLException
	 * @throws RepositorioException
	 *             , AlunoNaoExistenteException.
	 */
	@Override
	public Aluno buscarAluno(String matricula)
			throws AlunoNaoExistenteException, Exception {
		return this.meuControleAlunos.buscar(matricula);
	}

	/**
	 * Metodo que lista todos os alunos cadastrados.
	 * 
	 * @return Lista de alunos.
	 * @throws Exception
	 * @throws RepositorioException
	 *             , AlunosNaoCadastradosException.
	 */
	@Override
	public List<Aluno> listarAlunos() throws AlunosNaoCadastradosException,
			Exception {
		return this.meuControleAlunos.listar();
	}

	/**
	 * retorna a quantidade alunos inseridos no repositorio.
	 * 
	 * @throws SQLException
	 */
	public int quantidadeAlunos() throws Exception {
		return this.meuControleAlunos.quantidadeAlunos();
	}

	/**
	 * Dada a matricula do aluno, checa se ele existe
	 * 
	 * @param matricula
	 * @return true se existe
	 * @throws SQLException
	 * @throws RepositorioException
	 */
	public boolean verificaSeExisteAluno(String matricula) throws Exception {
		return this.meuControleAlunos.verificaSeAlunoExiste(matricula);
	}

	/* ###################### PROFESSORES ############################ */
	/**
	 * Insere um professor.
	 * 
	 * @param professor
	 *            .
	 * @throws RepositorioException.
	 */
	public void inserirProfessor(Professor professor) {
		this.meuControleProfessor.inserir(professor);
	}

	/**
	 * Metodo que altera os dados de um determinado professor. A opcao do
	 * atributo a ser alterado, o cpf do professor e a nova informacao devem ser
	 * passados para o metodo. * As opcoes sao: 1 - CPF 2 - Nome 3 - Titulo 4 -
	 * Lotacao
	 * 
	 * @param op , cpf, info.
	 */
	public void alterarProfessor(int op, String cpf, String info)
			throws ProfessorNaoExistenteException {
		this.meuControleProfessor.alterar(op, cpf, info);
	}

	/**
	 * Verifica se um determinado professor esta presente no repositorio.
	 * 
	 * @param cpf
	 *            .
	 * @return false, se nao existe; true, caso exista.
	 * @throws RepositorioException
	 */
	public boolean verificaExistenciaProfessor(String cpf) {
		return this.meuControleProfessor.verificaSeProfessorExiste(cpf);
	}

	/**
	 * Remove um determiando professor.
	 * 
	 * @param cpf
	 *            .
	 */
	public void removerProfessor(String cpf)
			throws ProfessorNaoExistenteException {
		this.meuControleProfessor.remover(cpf);
	}

	/**
	 * Metodo que busca uma determinado professor pelo cpf.
	 * 
	 * @param cpf
	 */
	@Override
	public Professor buscarProfessor(String cpf)
			throws ProfessorNaoExistenteException {
		return this.meuControleProfessor.buscar(cpf);
	}

	/**
	 * Metodo que lista todos os professores cadastrados.
	 */
	@Override
	public List<Professor> listarProfessores()
			throws ProfessoresNaoCadastradosException {
		return this.meuControleProfessor.listar();
	}

	/**
	 * Dado um professor, retorna todas as turmas em que ele leciona.
	 * 
	 * @param professor
	 *            .
	 * @return Lista de turmas.
	 * @throws ProfessorSemTurmaException
	 */
	public List<Turma> listarTurmaPorProfessor(Professor professor)
			throws ProfessorSemTurmaException {
		return this.meuControleProfessor.listarTurmaPorProfessor(professor);
	}

	/**
	 * Dados um professor e uma turma, relaciona a turma ao professor e
	 * vice-versa.
	 * 
	 * @param professor
	 *            , turma.
	 */
	public void associarProfessorTurma(Professor professor, Turma turma) {
		this.meuControleProfessor.associaProfessorTurma(professor, turma);
	}

	/**
	 * Dados um professor e um turma, remove a turma do professor.
	 * 
	 * @param professor
	 *            , turma.
	 */
	public void removerProfessorTurma(Professor professor, Turma turma) {
		this.meuControleProfessor.removeProfessorTurma(professor, turma);
	}

	/**
	 * retorna a quantidade de professores inseridas no repositorio
	 */
	public int quantidadeProfessores() {
		return this.meuControleProfessor.quantidadeProfessores();
	}

	/* ###################### TURMAS ############################ */

	/**
	 * Insere uma turma.
	 * 
	 * @param turma
	 *            .
	 * @throws RepositorioException.
	 */
	public void inserirTurma(Turma turma) {
		this.meuControleTurmas.inserir(turma);
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
	public void alterarTurma(int op, String disciplina, String info)
			throws TurmaNaoExistenteException {
		this.meuControleTurmas.alterar(op, disciplina, info);
	}

	/**
	 * Dada a descricao da disciplina, retorna um turma.
	 * 
	 * @param descricao
	 *            .
	 * @return turma.
	 * @throws RepositorioException
	 *             , TurmaNaoExistenteException.
	 */
	public Turma buscarTurma(String disciplina)
			throws TurmaNaoExistenteException {
		return this.meuControleTurmas.buscar(disciplina);
	}

	/**
	 * Dada a descricao da disciplina, remove a turma.
	 * 
	 * @param disciplina
	 *            .
	 * @throws RepositorioException
	 *             , TurmaNaoExistenteException.
	 */
	public void removerTurma(String disciplina)
			throws TurmaNaoExistenteException {
		this.meuControleTurmas.remover(disciplina);
	}

	/**
	 * Lista todos as turmas do repositorio de turmas.
	 * 
	 * @return Lista de turmas.
	 * @throws RepositorioException
	 *             , ProfessoresNaoCadastradosException.
	 */
	public List<Turma> listarTurmas() throws TurmasNaoCadastradasException {
		return this.meuControleTurmas.listar();
	}

	/**
	 * Matricula um aluno em determinada turma.
	 * 
	 * @param aluno
	 *            , turma.
	 */
	public void matricularAlunoTurma(Aluno a, Turma t) {
		this.meuControleAlunos.matricularAlunoTurma(a, t);
	}

	/**
	 * Remove um aluno de uma deterteminada turma.
	 * 
	 * @param aluno
	 *            , turma.
	 */
	public void trancarTurmaAluno(Aluno a, Turma t) {
		this.meuControleAlunos.trancarTurmaAluno(a, t);
	}

	/**
	 * Lista todas as turmas pertencentes a um determinado departamento.
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
		return this.meuControleTurmas.listarTurmasPorDepartamento(departamento);
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
		return this.meuControleTurmas.listarAlunoPorTurma(t);
	}

	/**
	 * Retorna a quantidade de turmas existentes no repositorio.
	 * 
	 * @return quantidade.
	 */
	public int quantidadeTurma() {
		return this.meuControleTurmas.quantidadeTurmas();
	}

	/**
	 * Dada a a disciplina, checa se a turma existe
	 * 
	 * @param disciplina
	 *            .
	 * @return true se existe; false, se nao existe.
	 */
	public boolean verificaExistenciaTurma(String disciplina) {
		return this.meuControleTurmas.verificaSeTurmaExiste(disciplina);
	}

	@Override
	public void removerAluno(Aluno aluno) throws AlunoNaoExistenteException {
		// TODO Auto-generated method stub

	}

}