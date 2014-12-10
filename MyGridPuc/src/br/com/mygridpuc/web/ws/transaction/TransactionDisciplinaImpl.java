package br.com.mygridpuc.web.ws.transaction;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.mygridpuc.web.entidade.Disciplina;
import br.com.mygridpuc.web.entidade.MatrizDisciplina;
import br.com.mygridpuc.web.entidade.Turma;
import br.com.mygridpuc.web.negocio.DisciplinaService;
import br.com.mygridpuc.web.negocio.LocalService;
import br.com.mygridpuc.web.negocio.MatrizDisciplinaService;
import br.com.mygridpuc.web.negocio.TurmaService;
import br.com.mygridpuc.web.util.MyGridPucException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TransactionDisciplinaImpl implements TransactionDisciplina{

	@Autowired
	private DisciplinaService disciplinaService;
	@Autowired
	private MatrizDisciplinaService matDiscService;
	@Autowired
	private TurmaService turmaService;
	@Autowired
	private LocalService localService;

	public DisciplinaService getDisciplinaService() {
		return disciplinaService;
	}

	public void setDisciplinaService(DisciplinaService disciplinaService) {
		this.disciplinaService = disciplinaService;
	}

	public MatrizDisciplinaService getMatDiscService() {
		return matDiscService;
	}

	public void setMatDiscService(MatrizDisciplinaService matDiscService) {
		this.matDiscService = matDiscService;
	}


	public TurmaService getTurmaService() {
		return turmaService;
	}

	public void setTurmaService(TurmaService turmaService) {
		this.turmaService = turmaService;
	}

	public LocalService getLocalService() {
		return localService;
	}

	public void setLocalService(LocalService localService) {
		this.localService = localService;
	}


	public String getByIdMatriz(int idMatriz){
		List<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();
		List<MatrizDisciplina> listaMatrizDisciplina = null;

		try {
			listaMatrizDisciplina = getMatDiscService().listarPorMatriz(idMatriz);
		} catch (MyGridPucException e) {
			return "[]";
		}

		for(MatrizDisciplina matDisciplina : listaMatrizDisciplina){
			try {
				Disciplina disciplina = getDisciplinaService().consultar(matDisciplina.getDisciplina().getIdDisciplina());
				disciplina.setListTurma(getTurmaService().consultarPorIdDisciplina(disciplina.getIdDisciplina()));
				for(Turma t: disciplina.getListTurma()){
					t.setListLocais(getLocalService().listar(t.getIdTurma()));
				}
				listaDisciplinas.add(disciplina);
			} catch (MyGridPucException e) {
				return "[]";
			}

		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String strJson="";
		if(!listaDisciplinas.isEmpty()){
			strJson = gson.toJson(listaDisciplinas);
		}else{
			strJson = "[]";
		}

		return strJson;
	}

	@Override
	public String getByIdMatrizPeriodo(int idMatriz, int periodo) {

		List<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();
		List<MatrizDisciplina> listaMatrizDisciplina = null;

		try {
			listaMatrizDisciplina = getMatDiscService().listarPorMatrizPeriodo(idMatriz, periodo);

		} catch (MyGridPucException e) {
			return "[]";
		}

		for(MatrizDisciplina matDisciplina : listaMatrizDisciplina){
			try {
				Disciplina disciplina = getDisciplinaService().consultar(matDisciplina.getDisciplina().getIdDisciplina());
				disciplina.setListTurma(getTurmaService().consultarPorIdDisciplina(disciplina.getIdDisciplina()));
				for(Turma t: disciplina.getListTurma()){
					t.setListLocais(getLocalService().listar(t.getIdTurma()));
				}
				listaDisciplinas.add(disciplina);
			} catch (MyGridPucException e) {
				return "[]";
			}

		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String strJson="";
		if(!listaDisciplinas.isEmpty()){
			strJson = gson.toJson(listaDisciplinas);
		}else{
			strJson = "[]";
		}
		
		return strJson;
	}



}
