package br.com.aposentadoria.exception;

import java.util.List;

public class RnException extends Exception {

	private static final long serialVersionUID = 8437427396818946098L;
	private List<String> erros;

	public RnException() {
	}
	
	public RnException(String mensagem) {
		super(mensagem);
	}

	public RnException(Throwable throwable) {
		super(throwable);
	}

	public RnException(String mensagem, Throwable throwable) {
		super(mensagem, throwable);
	}
	
	public RnException(List<String> erros) {
		this.erros = erros;
	}
	
	public List<String> getErros() {
		return erros;
	}
	public void setErros(List<String> erros) {
		this.erros = erros;
	}
}	