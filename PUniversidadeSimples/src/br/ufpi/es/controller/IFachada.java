package br.ufpi.es.controller;

import java.util.List;

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

public interface IFachada {
	
	/*###################  ALUNOS ######################*/
	public void inserirAluno(Aluno aluno) throws Exception; 
	public void alterarAluno(Aluno a) throws Exception;
	public void removerAluno(Aluno aluno) throws AlunoNaoExistenteException;
	public void removerAluno(String matricula) throws AlunoNaoExistenteException, Exception;
	public Aluno buscarAluno(String matricula) throws AlunoNaoExistenteException, Exception;
	public List<Aluno> listarAlunos() throws  AlunosNaoCadastradosException, Exception;
	public void matricularAlunoTurma(Aluno a, Turma t);
	public void trancarTurmaAluno(Aluno a, Turma t);
	public boolean verificaSeExisteAluno(String matricula) throws Exception;
	public int quantidadeAlunos() throws Exception;
	
	/*################### PROFESSORES ######################*/
	public void inserirProfessor(Professor professor);
	public void alterarProfessor(int op, String cpf, String info) throws ProfessorNaoExistenteException;
	public void removerProfessor(String cpf) throws ProfessorNaoExistenteException;
	public Professor buscarProfessor(String cpf) throws ProfessorNaoExistenteException;
	public List<Professor> listarProfessores() throws ProfessoresNaoCadastradosException;
	public List<Turma> listarTurmaPorProfessor(Professor professor) throws ProfessorSemTurmaException;
	public void associarProfessorTurma(Professor professor, Turma turma);
	public void removerProfessorTurma(Professor professor, Turma turma);
	public int quantidadeProfessores();
	public boolean verificaExistenciaProfessor(String cpf);
	
	/*################### TURMAS ######################*/
	public void inserirTurma(Turma turma);
	public void alterarTurma(int op, String disciplina, String info) throws  TurmaNaoExistenteException;
	public void removerTurma(String discplina) throws TurmaNaoExistenteException;
	public Turma buscarTurma(String discplina) throws TurmaNaoExistenteException;
	public List<Turma> listarTurmas() throws TurmasNaoCadastradasException;
	public List<Aluno> listarAlunoPorTurma(Turma t) throws TurmaSemAlunoException;
	public int quantidadeTurma();
	public boolean verificaExistenciaTurma(String disciplina);
	public List<Turma> listarTurmasPorDepartamento(String departamento) throws TurmasNaoCadastradasException, DepartamentoNaoExisteException;
	
}
