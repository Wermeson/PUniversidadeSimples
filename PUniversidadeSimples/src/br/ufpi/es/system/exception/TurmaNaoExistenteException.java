package br.ufpi.es.system.exception;

@SuppressWarnings("serial")
public class TurmaNaoExistenteException extends Exception{
	
	public TurmaNaoExistenteException(){
		super("Essa turma n�o existe!");
	}
}
