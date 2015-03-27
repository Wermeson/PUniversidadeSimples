package br.ufpi.es.system.exception;

@SuppressWarnings("serial")
public class AlunoNaoExistenteException extends Exception{
	
	public AlunoNaoExistenteException(){
		super("Esse aluno não existe");
	}
}
