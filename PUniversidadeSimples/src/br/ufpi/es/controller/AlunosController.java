package br.ufpi.es.controller;

import java.sql.SQLException;
import java.util.List;

import br.ufpi.es.dao.IRepositorioAlunos;
import br.ufpi.es.model.Aluno;
import br.ufpi.es.model.Turma;
import br.ufpi.es.system.exception.AlunoNaoExistenteException;
import br.ufpi.es.system.exception.AlunosNaoCadastradosException;

public class AlunosController {
	private IRepositorioAlunos controleAlunos;

	/**
	 * Instancia o controlador de acordo com o tipo de repositorio
	 * 
	 * @param tipo
	 */
	public AlunosController(IRepositorioAlunos tipo) {
		this.controleAlunos = tipo;
	}

	/**
	 * Insere um aluno no repositorio
	 * 
	 * @param aluno
	 * @throws SQLException
	 * @throws RepositorioException
	 */
	public void inserir(Aluno aluno) throws Exception {
		this.controleAlunos.insereAluno(aluno);
	}

	/**
	 * Dada a matricula retorna o Aluno
	 * 
	 * @param matricula
	 * @return
	 * @throws SQLException
	 * @throws RepositorioException
	 */
	public Aluno buscar(String matricula) throws AlunoNaoExistenteException,
			Exception {
		return this.controleAlunos.buscarAluno(matricula);
	}

	/**
	 * Dada a matricula do aluno, checa se ele existe
	 * 
	 * @param matricula
	 * @return true se existe
	 * @throws SQLException
	 * @throws RepositorioException
	 */
	public boolean verificaSeAlunoExiste(String matricula) throws Exception {
		return this.controleAlunos.verificaExistenciaAluno(matricula);
	}

	/**
	 * Dado um aluno faz a atualizacao com os novos dados. Opção do dado campo a
	 * ser alterado, a matricula do aluno e a nova informação. As opções são: 1
	 * - Matricula 2 - Nome 3 - Curso.
	 * 
	 * @param op
	 *            , matricula e info.
	 * @throws RepositorioException
	 */

	public void alterarAluno(Aluno a) throws Exception {
		// TODO Auto-generated method stub
		this.controleAlunos.alterarAluno(a);
	}

	/**
	 * Dada a matricula do aluno, faz a remocao.
	 * 
	 * @param matricula
	 * @throws SQLException
	 * @throws RepositorioException
	 */
	public void remover(String matricula) throws AlunoNaoExistenteException,
			Exception {
		this.controleAlunos.removerAluno(matricula);
	}

	/**
	 * Listar os alunos do repositorio
	 * 
	 * @return
	 * @throws SQLException
	 * @throws RepositorioException
	 */
	public List<Aluno> listar() throws AlunosNaoCadastradosException, Exception {
		return this.controleAlunos.listarAlunos();
	}

	/**
	 * Realiza a matricula de aluno em uma determinada turma.
	 * 
	 * @param aluno
	 *            , turma.
	 */
	public void matricularAlunoTurma(Aluno a, Turma t) {
		t.getAluno().add(a); // Adicionando aluno na turma.
		a.getTurma().add(t);// Adicionando turma ao aluno.
	}

	/**
	 * Remove um determinado aluno de um turma.
	 * 
	 * @param aluno
	 *            , turma.
	 */
	public void trancarTurmaAluno(Aluno a, Turma t) {
		a.getTurma().remove(t); // Removendo a turma de um aluno.
		t.getAluno().remove(a); // Removendo um aluno da turma.
	}

	/**
	 * Retorna a quantidade de aluno inseridos no repositório.
	 * 
	 * @return quantidadeAlunos.
	 * @throws SQLException
	 */
	public int quantidadeAlunos() throws Exception {
		return this.controleAlunos.quantidadeAlunos();
	}

}