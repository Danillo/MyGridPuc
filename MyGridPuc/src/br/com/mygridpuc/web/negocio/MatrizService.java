package br.com.mygridpuc.web.negocio;

import java.util.List;

import br.com.mygridpuc.web.entidade.Matriz;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Interface que define as operacoes da camada de negocio de matriz
 * 
 * @author David Rodrigues
 *
 */
public interface MatrizService {

	/**
	 * Inclui um matriz
	 * @param matriz
	 * @return
	 * @throws MyGridPucException
	 */
	public Matriz incluir(Matriz matriz) throws MyGridPucException;
	
	/**
	 * Altera um matriz
	 * @param matriz
	 * @return
	 * @throws MyGridPucException
	 */
	public Matriz alterar(Matriz matriz) throws MyGridPucException;
	
	/**
	 * Exclui um matriz
	 * @param id
	 * @throws MyGridPucException
	 */
	public void excluir(Integer id) throws MyGridPucException;
	
	/**
	 * Consulta um matriz pelo identificador
	 * @param id
	 * @return
	 * @throws MyGridPucException
	 */
	public Matriz consultar(Integer id) throws MyGridPucException;
	
	/**
	 * Lista todas as matriz cadastradas
	 * @return
	 * @throws MyGridPucException
	 */
	public List<Matriz> listar() throws MyGridPucException;
	
	/**
	 * Lista todas as matriz cadastradas que pertencem a um curso
	 * @return
	 * @throws MyGridPucException
	 */
	public List<Matriz> listar(Integer idCurso) throws MyGridPucException;

	
	/**
	 * Consulta uma matriz pelo identificador de Curso
	 * @param idCurso
	 * @return
	 * @throws MyGridPucException
	 */
	public Matriz consultarPorIdCurso(Integer idCurso) throws MyGridPucException;

	/**
	 * Consulta uma matriz pelo identificador de Curso e Pelo AnoSemestre
	 * @param Integer idCurso, String anoSemestre
	 * @return
	 * @throws MyGridPucException
	 */
	public Matriz consultarPorIdCursoAnoMatriz(Integer idCurso, String anoSemestre)throws MyGridPucException;

	/**
	 * Consulta se Exites uma matriz pelo identificador de Curso e Pelo AnoSemestre
	 * @param idCurso
	 * @param anoSemestre
	 * @return boolean
	 * @throws MyGridPucException
	 */
	public boolean existeMatriz(Integer idCurso, String anoSemestre)
			throws MyGridPucException;
}
