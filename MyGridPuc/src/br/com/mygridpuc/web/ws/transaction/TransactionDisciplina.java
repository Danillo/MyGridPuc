package br.com.mygridpuc.web.ws.transaction;

public interface TransactionDisciplina {

	public abstract String getByIdMatriz(int idMatriz);
	
	public abstract String getByIdMatrizPeriodo(int idMatriz,int periodo);
	
}