package br.ufpi.es.system.exception;

@SuppressWarnings("serial")
public class ProfessorNaoExistenteException extends Exception{
	
	public ProfessorNaoExistenteException(){
		super("N�o exite professor com esse dado.");
	}
}
