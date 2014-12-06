/**
 * 
 */
package br.com.mygridpuc.web.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mygridpuc.web.entidade.MatrizDisciplina;
import br.com.mygridpuc.web.persistencia.MatrizDisciplinaDAO;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Classe que define as operacoes da camada de negocio
 * 
 * @author Wesley
 */
@Service
@Transactional
public class MatrizDisciplinaServiceImpl implements MatrizDisciplinaService {

	private MatrizDisciplinaDAO<MatrizDisciplina> matrizDisciplinaDAO;

	public MatrizDisciplinaDAO<MatrizDisciplina> getMatrizDisciplinaDAO() {
		return matrizDisciplinaDAO;
	}

	@Autowired
	public void setMatrizDisciplinaDAO(MatrizDisciplinaDAO<MatrizDisciplina> matrizDisciplinaDAO) {
		this.matrizDisciplinaDAO = matrizDisciplinaDAO;
	}

	@Override
	public MatrizDisciplina incluir(MatrizDisciplina matrizDisciplina) throws MyGridPucException {
		return getMatrizDisciplinaDAO().incluir(matrizDisciplina);
	}

	@Override
	public MatrizDisciplina alterar(MatrizDisciplina matrizDisciplina) throws MyGridPucException {
		return null;
	}

	@Override
	public void excluir(Integer id) throws MyGridPucException {

	}

	@Override
	public MatrizDisciplina consultar(Integer id) throws MyGridPucException {
		return null;
	}

	@Override
	public List<MatrizDisciplina> listar() throws MyGridPucException {
		return null;
	}

	@Override
	public List<MatrizDisciplina> listarPorMatriz(Integer idMatriz)	throws MyGridPucException {
		return getMatrizDisciplinaDAO().listarPorMatriz(idMatriz);
	}

	@Override
	public List<MatrizDisciplina> listarPorDisciplina(Integer idDisciplina)	throws MyGridPucException {
		return getMatrizDisciplinaDAO().listarPorDisciplina(idDisciplina);
	}

	@Override
	public List<MatrizDisciplina> listarPorMatrizPeriodo(Integer idMatriz, Integer periodo)	throws MyGridPucException {
		return getMatrizDisciplinaDAO().listarPorMatrizPeriodo(idMatriz, periodo);
	}

	@Override
	public boolean existeMatrizDisciplina(Integer idMatriz,	Integer idDisciplina) throws MyGridPucException {
		if(getMatrizDisciplinaDAO().listarPorIdMatrizIdDisciplina(idMatriz, idDisciplina)==null){
			return false;
		}return true;
	}



}
