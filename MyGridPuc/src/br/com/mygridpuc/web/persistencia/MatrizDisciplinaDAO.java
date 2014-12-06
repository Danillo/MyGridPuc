package br.com.mygridpuc.web.persistencia;

import java.util.List;

import br.com.mygridpuc.web.entidade.MatrizDisciplina;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Interface que define as operacoes da camada de persistencia de MatrizDisciplina
 * 
 * @author Wesley Reis
 *
 */
public interface MatrizDisciplinaDAO <MatrizDisciplina>{
	/**
	 * Retorna a classe a ser persistida
	 * @return
	 */
	public Class<MatrizDisciplina> getObjectClass();
	
	/**
	 * Inclui um objeto MatrizDisciplina na base de dados
	 * @param matrizDisciplina
	 * @return
	 * @throws MyGridPucException
	 */
	public MatrizDisciplina incluir(MatrizDisciplina matrizDisciplina) throws MyGridPucException;
	
	/**
	 * Altera um objeto MatrizDisciplina na base de dados
	 * @param matrizDisciplina
	 * @return
	 * @throws MyGridPucException
	 */
	public MatrizDisciplina alterar(MatrizDisciplina matrizDisciplina) throws MyGridPucException;
	
	/**
	 * Consulta um objeto MatrizDisciplina da base de dados
	 * @param id
	 * @return
	 * @throws MyGridPucException
	 */
	public MatrizDisciplina consultar(Integer id) throws MyGridPucException;
	
	/**
	 * Exclui um objeto MatrizDisciplina  da base de dados
	 * @param id
	 * @throws MyGridPucException
	 */
	public void excluir(Integer id) throws MyGridPucException;
	
	/**
	 * Lista os objetos MatrizDisciplina da base de dados
	 * @return
	 * @throws MyGridPucException
	 */
	public List<MatrizDisciplina> listar() throws MyGridPucException;
	
	/**
	 * Lista os objetos MatrizDisciplina da base de dados pelo Id da Matriz
	 * @return
	 * @throws MyGridPucException
	 */
	public List<MatrizDisciplina> listarPorMatriz(Integer idMatriz) throws MyGridPucException;

	/**
	 * Lista os objetos MatrizDisciplina da base de dados pelo Id da Disciplina
	 * @return
	 * @throws MyGridPucException
	 */
	public List<MatrizDisciplina> listarPorDisciplina(Integer idDisciplina) throws MyGridPucException;
	
	/**
	 * Lista os objetos MatrizDisciplina da base de dados pelo Id da Matriz
	 * @return
	 * @throws MyGridPucException
	 */
	public List<MatrizDisciplina> listarPorMatrizPeriodo(Integer idMatriz,Integer periodo) throws MyGridPucException;

	/**
	 * Lista os objetos  MatrizDisciplina da base de dados pelo Id da Matriz e pelo Id da Disciplina
	 * @param idMatriz
	 * @param idDisciplina
	 * @return
	 * @throws MyGridPucException
	 */
	public List<MatrizDisciplina> listarPorIdMatrizIdDisciplina(Integer idMatriz,	Integer idDisciplina) throws MyGridPucException;

}
