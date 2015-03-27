package br.ufpi.es.model;

import java.util.LinkedList;
import java.util.List;

public class Aluno {
	private int idAluno;
	private String matricula;
	private String nome;
	private String curso;
	private List<Turma> turma;
	
	/*
	 * Cria uma instancia passando os atributos diretamente na criacao do objeto
	 */
	public Aluno(String matricula, String nome, String curso){
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
		this.idAluno = 0;
		this.turma = new LinkedList<Turma>();
	}

	/*
	 * Metodos de acesso aos atributos do objeto
	 */
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}

	public List<Turma> getTurma() {
		return turma;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}
	
}