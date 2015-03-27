package br.ufpi.es.system.exception;

@SuppressWarnings("serial")
public class TurmasNaoCadastradasException extends Exception{
	
	public TurmasNaoCadastradasException(){
		super("Nenhuma turma foi cadastrada ainda!");
	}
}
