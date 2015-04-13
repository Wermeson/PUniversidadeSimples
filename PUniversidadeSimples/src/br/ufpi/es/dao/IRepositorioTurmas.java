package br.ufpi.es.dao;

import java.util.List;

import br.ufpi.es.model.Turma;
import br.ufpi.es.system.exception.TurmaNaoExistenteException;
import br.ufpi.es.system.exception.TurmasNaoCadastradasException;

public interface IRepositorioTurmas {

	/**
	 * Insere uma turma.
	 * 
	 * @param turma
	 * @throws
	 */
	public void insereTurma(Turma turma);

	/**
	 * Dada a descrição da disciplina, retorna um turma.
	 * 
	 * @param descricao
	 *            .
	 * @return turma.
	 * @throws TurmaNaoExistenteException.
	 */
	public Turma buscarTurma(String disciplina)
			throws TurmaNaoExistenteException;

	/**
	 * Checa se existe turma dada a descrição.
	 * 
	 * @param descricao
	 *            .
	 * @return true se existe, false se não existe.
	 */
	public boolean verificaExistenciaTurma(String disciplina);

	/**
	 * Método que altera os dados de uma determinada turma. A opção do atributo
	 * a ser alterado, a disciplina e a nova informação devem ser informados. As
	 * opções são: 1 - Departamento. 2 - Disciplina 3 - Horário 4 - Quantidade
	 * de alunos.
	 * 
	 * @param op
	 *            , disciplina, info.
	 * @throws TurmaNaoExistenteException
	 */
	public void alterarTurma(int op, String disciplina, String info)
			throws TurmaNaoExistenteException;

	/**
	 * Dada a descrição da disciplina, remove a turma.
	 * 
	 * @param disciplina
	 *            .
	 * @throws TurmaNaoExistenteException.
	 */
	public void removerTurma(String disciplina)
			throws TurmaNaoExistenteException;

	/**
	 * Lista todos as turmas do repositorio de turmas.
	 * 
	 * @return Lista de turmas.
	 * @throws ProfessoresNaoCadastradosException.
	 */
	public List<Turma> listarTurmas() throws TurmasNaoCadastradasException;

	/**
	 * Quantidade de turmas no repositório
	 * 
	 * @return quantidade.
	 */
	public int quantidadeTurmas();
}
