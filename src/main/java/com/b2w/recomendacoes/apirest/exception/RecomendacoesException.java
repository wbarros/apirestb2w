package com.b2w.recomendacoes.apirest.exception;


public class RecomendacoesException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private Integer codigoErro;
	private String mensagem;

	public RecomendacoesException() {
		super();
	}

	public RecomendacoesException(String mensagem) {
		super(mensagem);
		this.mensagem = mensagem;
	}
	
	public RecomendacoesException(Integer codigo, String mensagem, Throwable cause) {
		super(mensagem, cause);
		this.codigoErro = codigo;
		this.mensagem = mensagem;
	}
	
	public RecomendacoesException(String mensagem, Throwable cause) {
		super(mensagem, cause);
	}

	public RecomendacoesException(Throwable cause) {
		super(cause);
	}
	
	public Integer getCodigoErro() {
		return codigoErro;
	}

	public void setCodigoErro(Integer codigoErro) {
		this.codigoErro = codigoErro;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}

