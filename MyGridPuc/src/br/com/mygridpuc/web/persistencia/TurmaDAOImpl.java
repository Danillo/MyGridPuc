package br.com.mygridpuc.web.persistencia;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.mygridpuc.web.entidade.Turma;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Classe que define as operacoes da camada de persistencia de Turma
 * 
 * @author Wesley Reis
 *
 */
@Repository
public class TurmaDAOImpl extends GenericoDAOImpl<Turma, Integer> implements TurmaDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<Turma> consultarPorIdDisciplina(Integer idDisciplina)	throws MyGridPucException {
		List<Turma> turmas=null;
		try { 
			Query query = getEntityManager().createQuery("select turma from Turma as turma where turma.disciplina.idDisciplina =:idDisciplina");
			query.setParameter("idDisciplina", idDisciplina);

			turmas = query.getResultList();

		} catch (Exception e) {
			throw new MyGridPucException(e, "Problemas na localização dos objetos");  
		}
		if(turmas.size()>0){
			return turmas;
		}return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Turma consultarPorIdDisciplinaCodTurma(Integer idDisciplina, String codTurma) throws MyGridPucException {
		List<Turma> turmas=null;
		try { 
			Query query = getEntityManager().createQuery("select turma from Turma as turma where turma.disciplina.idDisciplina =:idDisciplina and turma.codTurma =:codTurma");
			query.setParameter("idDisciplina", idDisciplina);
			query.setParameter("codTurma", codTurma);

			turmas = query.getResultList();
			
		} catch (Exception e) {
			throw new MyGridPucException(e, "Problemas na localização dos objetos");  
		}
		if(turmas.size()>0){
			return turmas.get(0);
		}return null;
	}

}
