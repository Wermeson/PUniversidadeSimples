package br.ufpi.es.system.exception;

@SuppressWarnings("serial")
public class DepartamentoNaoExisteException extends Exception{
	public DepartamentoNaoExisteException() {
		super("Esse departamento não existe.");
	}
}
