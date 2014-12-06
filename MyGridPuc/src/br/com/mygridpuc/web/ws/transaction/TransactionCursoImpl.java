package br.com.mygridpuc.web.ws.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.mygridpuc.web.entidade.Curso;
import br.com.mygridpuc.web.negocio.CursoService;
import br.com.mygridpuc.web.util.MyGridPucException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TransactionCursoImpl implements TransactionCurso {


	@Autowired
	private CursoService cursoService;


	public CursoService getCursoService() {
		return cursoService;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}

	@Override
	public String allCursos(){
		List<Curso> listCursos = null;
		try {
			listCursos = getCursoService().listar();

		} catch (MyGridPucException e) {
			e.printStackTrace();
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

		String strJson = gson.toJson(listCursos);
		//System.out.println(strJson);

		return strJson;

	}

	@Override
	public String findByCodCurso(String codCurso) {
		Curso curso = null;
		try {
			curso = getCursoService().consultar(codCurso);
		} catch (MyGridPucException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

		String strJson = gson.toJson(curso);
		//System.out.println(strJson);

		return strJson;
	}


}
