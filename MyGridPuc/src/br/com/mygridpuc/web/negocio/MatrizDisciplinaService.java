package br.com.mygridpuc.web.negocio;

import java.util.List;

import br.com.mygridpuc.web.entidade.MatrizDisciplina;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Interface que define as operacoes da camada de negocio de matrizDisciplina
 * 
 * @author Wesley Reis
 *
 */
public interface MatrizDisciplinaService {

	/**
	 * Inclui uma matrizDisciplina
	 * @param matrizDisciplina
	 * @return
	 * @throws MyGridPucException
	 */
	public MatrizDisciplina incluir(MatrizDisciplina matrizDisciplina) throws MyGridPucException;
	
	/**
	 * Altera uma matrizDisciplina
	 * @param matrizDisciplina
	 * @return
	 * @throws MyGridPucException
	 */
	public MatrizDisciplina alterar(MatrizDisciplina matrizDisciplina) throws MyGridPucException;
	
	/**
	 * Exclui uma matrizDisciplina
	 * @param id
	 * @throws MyGridPucException
	 */
	public void excluir(Integer id) throws MyGridPucException;
	
	/**
	 * Consulta uma matrizDisciplina pelo identificador
	 * @param id
	 * @return
	 * @throws MyGridPucException
	 */
	public MatrizDisciplina consultar(Integer id) throws MyGridPucException;
	
	/**
	 * Lista todas as matrizDisciplina cadastradas
	 * @return
	 * @throws MyGridPucException
	 */
	public List<MatrizDisciplina> listar() throws MyGridPucException;
	
	/**
	 * Lista todas as matrizDisciplina cadastradas que pertencem a uma matriz
	 * @return
	 * @throws MyGridPucException
	 */
	public List<MatrizDisciplina> listarPorMatriz(Integer idMatriz) throws MyGridPucException;
	
	/**
	 * Lista todas as matrizDisciplina cadastradas que pertencem a uma disciplina
	 * @return
	 * @throws MyGridPucException
	 */
	public List<MatrizDisciplina> listarPorDisciplina(Integer idDisciplina) throws MyGridPucException;

	/**
	 * Lista todas as matrizDisciplina cadastradas que pertencem a uma disciplina e um Periodo Espec�fico
	 * @return
	 * @throws MyGridPucException
	 */
	public List<MatrizDisciplina> listarPorMatrizPeriodo(Integer idMatriz,	Integer periodo) throws MyGridPucException;
	
	/**
	 * Pesquisa para Determinar se Existe no Banco a Correla��o da Disciplina com a Matriz.
	 * @param idMatriz
	 * @param idDisciplina
	 * @return Boolean se Existe ou n�o a correla��o.
	 * @throws MyGridPucException
	 */
	public boolean existeMatrizDisciplina(Integer idMatriz, Integer idDisciplina) throws MyGridPucException;
	
	
}
