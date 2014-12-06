package br.com.mygridpuc.web.persistencia;

import java.util.List;

import br.com.mygridpuc.web.entidade.Turma;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Interface que define as operacoes da camada de persistencia de Turma
 * 
 * @author Wesley Reis
 *
 */
public interface TurmaDAO extends GenericoDAO<Turma, Integer>{

	public List<Turma> consultarPorIdDisciplina(Integer idDisciplina) throws MyGridPucException;

	public Turma consultarPorIdDisciplinaCodTurma(Integer idDisciplina, String codTurma) throws MyGridPucException;

}
