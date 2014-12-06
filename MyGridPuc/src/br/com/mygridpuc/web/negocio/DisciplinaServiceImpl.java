package br.com.mygridpuc.web.negocio;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.mygridpuc.web.entidade.Disciplina;
import br.com.mygridpuc.web.persistencia.DisciplinaDao;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Classe que define as operacoes da camada de negocio
 * 
 * @author David Rodrigues
 *
 */
@Service
@Transactional
public class DisciplinaServiceImpl implements DisciplinaService {

	private DisciplinaDao disciplinaDao;

	/**
	 * Inclui uma disciplina no BD.
	 * @param Objeto com os dados da disciplina.
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Disciplina incluir(Disciplina disciplina) throws MyGridPucException {
		getDisciplinaDao().incluir(disciplina);
		
		Disciplina disciplinaSalva = disciplinaDao.consultarPorCodigo(disciplina.getCodigo());
		return disciplinaSalva;
	}

	/**
	 * Altera uma Disciplina
	 * @param Dados da Disciplina
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Disciplina alterar(Disciplina disciplina) throws MyGridPucException {
		return getDisciplinaDao().alterar(disciplina);
	}

	/**
	 * Exclui uma Disciplina
	 * @param Dados da Disciplina
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void excluir(Integer id) throws MyGridPucException {
		getDisciplinaDao().excluir(id);
		
	}

	/**
	 * Consulta uma Disciplina
	 * @param Dados da Disciplina
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public Disciplina consultar(Integer id) throws MyGridPucException {
		Disciplina disciplina = getDisciplinaDao().consultar(id);
		return disciplina;
	}
	
	/**
	 * Consulta uma Disciplina
	 * @param Dados da Disciplina
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public Disciplina consultar(String codDisc) throws MyGridPucException {
		Disciplina disciplina = getDisciplinaDao().consultarPorCodigo(codDisc);
		return disciplina;
	}

	/**
	 * Lista uma Disciplina
	 * @param Dados da Disciplina
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public List<Disciplina> listar() throws MyGridPucException {
		return getDisciplinaDao().listar();
	}
	
	
	public DisciplinaDao getDisciplinaDao() {
		return disciplinaDao;
	}

	@Autowired
	public void setDisciplinaDao(DisciplinaDao disciplinaDao) {
		this.disciplinaDao = disciplinaDao;
	}
	
}
