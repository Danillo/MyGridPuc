/**
 * 
 */
package br.com.mygridpuc.web.util;

/**
 * Classe responsavel pelas exce��es.
 * 
 * @author DavidRodrigues
 *
 */
public class MyGridPucException extends Exception {
	private static final long serialVersionUID = 8479561261834501637L;
	private Exception ex;
	private String msg;

	/**
	 * M�todo com exce��o padr�o
	 * 
	 * @param e
	 */
	public MyGridPucException(Exception e){
		ex = e;
		msg = e.getMessage();
	}

	/**
	 * M�todo com exce��o e mensagem editavel
	 * 
	 * @param e
	 * @param mensagem
	 */
	public MyGridPucException(Exception e, String mensagem){
		e.printStackTrace();
		ex = e;
		msg = mensagem;
	}

	public Exception getEx() {
		return ex;
	}

	public String getMsg() {
		return msg;
	}
}
