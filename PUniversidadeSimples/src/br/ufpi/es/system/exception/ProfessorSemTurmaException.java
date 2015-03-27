package br.ufpi.es.system.exception;

@SuppressWarnings("serial")
public class ProfessorSemTurmaException extends Exception{
	
	public ProfessorSemTurmaException(){
		super("Esse professor não leciona em nehuma turma!");
	}
}
