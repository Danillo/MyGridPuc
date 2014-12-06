/**
 * 
 */
package br.com.mygridpuc.web.negocio;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.mygridpuc.web.entidade.Curso;
import br.com.mygridpuc.web.entidade.Matriz;
import br.com.mygridpuc.web.persistencia.CursoDAO;
import br.com.mygridpuc.web.persistencia.MatrizDAO;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Classe que define as operacoes da camada de negocio de curso
 * 
 * @author David Rodrigues
 *
 */

@Service
@Transactional
public class CursoServiceImpl implements CursoService{
	
	private CursoDAO cursoDAO;
	private MatrizDAO matrizDAO;

	public CursoDAO getCursoDAO() {
		return cursoDAO;
	}

	@Autowired
	public void setCursoDAO(CursoDAO cursoDAO) {
		this.cursoDAO = cursoDAO;
	}
	
	public MatrizDAO getMatrizDAO() {
		return matrizDAO;
	}
	
	@Autowired
	public void setMatrizDAO(MatrizDAO matrizDAO) {
		this.matrizDAO = matrizDAO;
	}

	/**
	 * Inclui um curso
	 * @param curso
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Curso incluir(Curso curso) throws MyGridPucException {
		return cursoDAO.incluir(curso);
	}

	/**
	 * Altera um curso
	 * @param curso
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Curso alterar(Curso curso) throws MyGridPucException {
		
		//exclui os itens da base que foram removidos da tela
		Curso cursoExistente = this.consultar(curso.getIdCurso());
		for (Matriz matriz : cursoExistente.getListMatriz()) {
			if(!cursoExistente.getListMatriz().contains(matriz)){
				getMatrizDAO().excluir(matriz.getIdMatriz());
			}
		}
		
		return getCursoDAO().alterar(curso);
	}

	/**
	 * Exclui um curso
	 * @param curso
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void excluir(Integer id) throws MyGridPucException {
		
		//exclui todos os itens da base antes de Excluir o Curso
		Curso cursoExistente = this.consultar(id);
		for (Matriz matriz : cursoExistente.getListMatriz()) {
				getMatrizDAO().excluir(matriz.getIdMatriz());
		}
		
		getCursoDAO().excluir(id);
		
	}

	/**
	 * Consulta um curso
	 * @param curso
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public Curso consultar(Integer id) throws MyGridPucException {
		Curso curso = getCursoDAO().consultar(id);
		
		Hibernate.initialize(curso.getListMatriz());
		
		return curso;
	}

	/**
	 * Lista um curso
	 * @param curso
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public List<Curso> listar() throws MyGridPucException {
		List<Curso> listaCursos = getCursoDAO().listar();
				for(Curso c: listaCursos){
					Hibernate.initialize(c.getListMatriz());
				}
				
		return listaCursos;
	}

	/**
	 * Consulta um curso pelo Codigo do Curso
	 * @param codCurso
	 * @return Curso
	 * @throws MyGridPucException
	 */
	@Override
	public Curso consultar(String codCurso) throws MyGridPucException {
		Curso curso = getCursoDAO().consultarPorCodCurso(codCurso);
		if(curso!=null){
			Hibernate.initialize(curso.getListMatriz());
		}
		return curso;
	}
	
}
