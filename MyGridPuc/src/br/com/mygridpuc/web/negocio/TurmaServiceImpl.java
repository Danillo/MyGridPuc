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

import br.com.mygridpuc.web.entidade.Turma;
import br.com.mygridpuc.web.persistencia.TurmaDAO;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Classe que define as operacoes da camada de negocio de turma
 * 
 * @author David Rodrigues / Wesley Reis
 *
 */

@Service
@Transactional
public class TurmaServiceImpl implements TurmaService{
	private TurmaDAO turmaDAO;

	public TurmaDAO getTurmaDAO() {
		return turmaDAO;
	}

	@Autowired
	public void setTurmaDAO(TurmaDAO turmaDAO) {
		this.turmaDAO = turmaDAO;
	}

	/**
	 * Inclui um turma
	 * @param turma
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Turma incluir(Turma turma) throws MyGridPucException {
		return turmaDAO.incluir(turma);
	}

	/**
	 * Altera um turma
	 * @param turma
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Turma alterar(Turma turma) throws MyGridPucException {
		return getTurmaDAO().alterar(turma);
	}

	/**
	 * Exclui um turma
	 * @param turma
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void excluir(Integer id) throws MyGridPucException {
		getTurmaDAO().excluir(id);

	}

	/**
	 * Consulta um turma
	 * @param turma
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public Turma consultar(Integer id) throws MyGridPucException {
		Turma turma = getTurmaDAO().consultar(id);
		if(turma!=null){
			Hibernate.initialize(turma.getListLocais());
		}
		return turma;
	}


	/**
	 * Consulta a Turma pelo Id da Disciplina
	 * @param Turma
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public Turma consultarPorIdDisciplinaECodTurma(Integer idDisciplina, String codTurma) throws MyGridPucException {
		Turma turma = getTurmaDAO().consultarPorIdDisciplinaCodTurma(idDisciplina, codTurma);
		if(turma!=null){
			Hibernate.initialize(turma.getListLocais());
		}
		
		return turma;
	}

	/**
	 * Consulta a Turma pelo Id da Disciplina
	 * @param Turma
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public List<Turma> consultarPorIdDisciplina(Integer idDisciplina) throws MyGridPucException {
		List<Turma> turmas = getTurmaDAO().consultarPorIdDisciplina(idDisciplina);
		if(turmas.size()>0){
			for(Turma t: turmas){
				Hibernate.initialize(t.getListLocais());
			}
		}
		return turmas;
	}

	/**
	 * Lista um turma
	 * @param turma
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public List<Turma> listar() throws MyGridPucException {
		List<Turma> listaTurmas = getTurmaDAO().listar();
		if(listaTurmas.size()>0){
			for(Turma t: listaTurmas){
				Hibernate.initialize(t.getListLocais());
			}
		}
		return listaTurmas;
	}

	/**
	 * Consulta a Turma pelo Id da Disciplina e Código da Turma
	 * @param Turma
	 * @return boolean
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public boolean existeTurmaNaDisciplina(Integer idDisciplina, String codTurma) throws MyGridPucException {
		if(getTurmaDAO().consultarPorIdDisciplina(idDisciplina)==null){
			return false;
		}return true;
	}

}
