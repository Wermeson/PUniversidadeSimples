package br.ufpi.es.system.exception;

@SuppressWarnings("serial")
public class TurmaSemAlunoException extends Exception{
	public TurmaSemAlunoException() {
		super("Essa turma n�o cont�m alunos.");
	}
}
