package br.ufpi.es.dao;

import java.util.LinkedList;
import java.util.List;

import br.ufpi.es.model.Aluno;
import br.ufpi.es.system.exception.AlterarAlunoListaException;
import br.ufpi.es.system.exception.AlunoNaoExistenteException;
import br.ufpi.es.system.exception.AlunosNaoCadastradosException;
import br.ufpi.es.system.exception.BuscaListaException;
import br.ufpi.es.system.exception.InserirListaException;
import br.ufpi.es.system.exception.RemoverAlunoException;
import br.ufpi.es.system.exception.VerificarExistenciaAlunoListaException;

public class RepositorioListaAlunos implements IRepositorioAlunos{
	private List<Aluno> alunos;
	
	/**
	 * Instancia a lista para armazenar os alunos.
	 */
	public RepositorioListaAlunos(){
		this.alunos = new LinkedList<Aluno>();
		System.out.println("Instância de lista");
	}

	/**
	 * Método que insere um determinado aluno na lista.
	 * @param aluno.
	 */
	@Override
	public void insereAluno(Aluno aluno) throws InserirListaException{
		if((aluno.getMatricula()==null)||(aluno.getNome()==null)||(aluno.getCurso()==null)){
			throw new InserirListaException();
		}
		this.alunos.add(aluno);
	}

	/**
	 * Método que busca um aluno na lista pela maticula. A matricula do aluno deve ser informada.
	 * @param matricula.
	 * @return aluno.
	 */
	@Override
	public Aluno buscarAluno(String matricula) throws AlunoNaoExistenteException, BuscaListaException{
		if(matricula == null){
			throw new BuscaListaException();
		}
		for(Aluno a : alunos){
			if(a.getMatricula().equals(matricula)){
				return a;
			}
		}
		throw new AlunoNaoExistenteException();
	}

	/**
	 * Método que verifica se um determinado aluno está na lista. A matricula do aluno deve ser passada como parâmetro da pesquisa.
	 * @param matricula.
	 * @return boolean
	 * @throws VerificarExistenciaAlunoListaException 
	 */
	@Override
	public boolean verificaExistenciaAluno(String matricula) throws VerificarExistenciaAlunoListaException{
		if(matricula == null) {
			throw new VerificarExistenciaAlunoListaException();
		}
		for(Aluno a : alunos){
			if(a.getMatricula().equals(matricula)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Altera um aluno. A opção do atributo a ser alterado, a matricula do aluno e a nova informação devem ser passadas
	 * para o método.
	 * As opções são: 
	 * 1 - Matricula
	 * 2 - Nome
	 * 3 - Curso.
	 * @param op, matricula, info.
	 * @throws BuscaListaException 
	 */
	@Override
	public void alterarAluno(Aluno a) throws AlterarAlunoListaException{

		if((a.getNome().length() == 0) || (a.getNome().charAt(0) == ' ') || (a.getCurso().charAt(0) == ' ')|| (a.getCurso().charAt(0) == ' ') || (a.getCurso().length() == 0) || (a.getMatricula().length() == 0)){
			throw new AlterarAlunoListaException();
		}
		for(Aluno a2:this.alunos){
			if(a2.getIdAluno() == a.getIdAluno()){
				a2.setNome(a.getNome());
				a2.setCurso(a.getCurso());
				a2.setMatricula(a.getMatricula());
				break;
			}
		}
	}
	
//	@Override
//	public void alterarAluno(Aluno aluno) throws AlunoNaoExistenteException{
//		
//	}

	
	/**
	 * Remove um determinado aluno da lista. A matricula do aluno deve ser informada.
	 * @param matricula
	 * @throws BuscaListaException 
	 */
	@Override
	public void removerAluno(String matricula) throws AlunoNaoExistenteException, RemoverAlunoException, BuscaListaException{
		Aluno a = this.buscarAluno(matricula);
		this.alunos.remove(a);
	}

	/**
	 * Método que retorna todos os alunos inseridos na lista.
	 * @return alunos.
	 */
	@Override
	public List<Aluno> listarAlunos() throws AlunosNaoCadastradosException{
		if(this.quantidadeAlunos() == 0){
			throw new AlunosNaoCadastradosException();
		}
		return (this.alunos);
	}
	
	/**
	 * Informa a quantidade de alunos que estão inseridos na lista.
	 * @return alunos.size().
	 */
	@Override
	public int quantidadeAlunos(){
		return this.alunos.size();
	}


}
