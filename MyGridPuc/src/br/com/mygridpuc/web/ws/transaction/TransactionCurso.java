package br.com.mygridpuc.web.ws.transaction;

public interface TransactionCurso {

	public abstract String allCursos();
	
	public abstract String findByCodCurso(String codCurso);
	

}