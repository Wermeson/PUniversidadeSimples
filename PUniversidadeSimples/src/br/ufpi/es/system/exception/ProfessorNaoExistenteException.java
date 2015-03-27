package br.ufpi.es.system.exception;

@SuppressWarnings("serial")
public class ProfessorNaoExistenteException extends Exception{
	
	public ProfessorNaoExistenteException(){
		super("Não exite professor com esse dado.");
	}
}
