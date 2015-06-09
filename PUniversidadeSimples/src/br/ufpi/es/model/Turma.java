package br.ufpi.es.model;

import java.util.LinkedList;
import java.util.List;

public class Turma {
	private String departamento;
	private String disciplina;
	private int cargaHoraria;
	private int quantidadeAlunos;
	private Professor professor;
	private List<Aluno> aluno;
	
	/*
	 * Cria uma instancia passando alguns dos atributos diretamente na criacao do objeto.
	 */
	
	public Turma(String departamento, String disciplina, int horario) {
		this.departamento = departamento;
		this.disciplina = disciplina;
		this.cargaHoraria = horario;
		this.aluno = new LinkedList<Aluno>();
	}
	
	/*
	 * Metodos de acesso aos atributos do objeto.
	 */
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public List<Aluno> getAluno() {
		return aluno;
	}

	/**
	 * @return the quantidadeAlunos
	 */
	public int getQuantidadeAlunos() {
		return quantidadeAlunos;
	}

	/**
	 * @param quantidadeAlunos the quantidadeAlunos to set
	 */
	public void setQuantidadeAlunos(int quantidadeAlunos) {
		this.quantidadeAlunos = quantidadeAlunos;
	}
	
}
