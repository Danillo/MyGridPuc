/**
 * 
 */
package br.com.mygridpuc.web.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.mygridpuc.web.entidade.Curso;
import br.com.mygridpuc.web.entidade.Matriz;
import br.com.mygridpuc.web.negocio.CursoService;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Classe que controla as requisicoes do cliente web
 * @author DavidRodrigues
 *
 */
@ManagedBean(name="cursoController")
@RequestScoped
@Controller
public class CursoController {

	@Autowired
	private CursoBean cursoBean;
	@Autowired
	private List<CursoBean> listCursoBean;
	@Autowired
	private CursoService cursoService;	
	@Autowired
	private MatrizBean matrizBean;	


	
	@SuppressWarnings("unchecked")
	public CursoController(){
		cursoBean = new CursoBean();
		if(this.getFacesContext().getExternalContext().getSessionMap().get("matriz") != null){
			cursoBean.setListMatriz((List<MatrizBean>) getSession("matriz"));
		}else{
			cursoBean.setListMatriz(new ArrayList<MatrizBean>());
		}
		
		matrizBean = new MatrizBean();
		removeBean("formulario");
	}
	
	/**
	 * Incluir um curso na base de dados
	 * @return
	 */
	public String incluir(){
		try{
			Curso curso = new Curso();
			
			//Preenche os dados da tela no objeto persistente
			curso.setIdCurso(cursoBean.getIdCurso());
			curso.setCodigoCurso(cursoBean.getCodigoCurso());
			curso.setNomeCurso(cursoBean.getNomeCurso());
			
			curso.setListMatriz(new ArrayList<Matriz>());
			
			if(cursoBean.getListMatriz() == null || cursoBean.getListMatriz().equals(null)){
				cursoBean.setListMatriz(new ArrayList<MatrizBean>());
			}
			
			for(MatrizBean bean : cursoBean.getListMatriz()){
				Matriz matriz = new Matriz();
				matriz.setAnoSemestreMatriz(bean.getAnoSemestreMatriz());
				matriz.setCurso(curso);
				curso.getListMatriz().add(matriz);
			}
			
			getCursoService().incluir(curso);
			
			return "sucesso";
		}catch(Exception e){
			String msg = "Inclusão não realizada. Movito: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			e.printStackTrace();
			return "falha";
		}finally{
			removeBean("formulario");
		}
	}
	
	/**
	 * Lista cursos cadastrados
	 * @return
	 */
	public String listar(){
		try{
			List<Curso> listCursos = getCursoService().listar();
			if(listCursos == null || listCursos.size() == 0){
				FacesMessage facesMessage = new FacesMessage("Nenhum registro encontrado");
				getFacesContext().addMessage("formulario", facesMessage);
				return "listar curso";
			}
			
			//preenche a lista de cursos na tela
			listCursoBean = new ArrayList<CursoBean>();
			
			for(Curso curso: listCursos){
				CursoBean cursoBean = new CursoBean();
				cursoBean.setIdCurso(curso.getIdCurso());
				cursoBean.setCodigoCurso(curso.getCodigoCurso());
				cursoBean.setNomeCurso(curso.getNomeCurso());
				listCursoBean.add(cursoBean);
			}
			return "listar curso";
		}catch(Exception e){
			String msg = "Inclusão não realizada. Movito: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			e.printStackTrace();
			return "falha";
		}
	}
	
	public String consultar(){
		try{
			String idCurso = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idCurso");
			Curso curso = getCursoService().consultar(Integer.parseInt(idCurso));
			
			if(curso == null || curso.getIdCurso() == 0){
				FacesMessage facesMessage = new FacesMessage("Nenhum registro encontrado");
				getFacesContext().addMessage("formulario", facesMessage);
				return "listar curso";
			}
			
			cursoBean.setIdCurso(curso.getIdCurso());
			cursoBean.setCodigoCurso(curso.getCodigoCurso());
			cursoBean.setNomeCurso(curso.getNomeCurso());
			
			return "editar curso";
		}catch(Exception e){
			String msg = "Consulta não realizada. Movito: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			e.printStackTrace();
			return "falha";
		}
	}
	
	public String criar(){
		try{
			cursoBean = new CursoBean();
			return "criar curso";
		}catch(Exception e){
			String msg = "Criação não realizada. Movito: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			e.printStackTrace();
			return "falha";
		}
	}
	
	public String excluir(){
		try{
			String idCurso = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idCurso");
			Curso curso = getCursoService().consultar(Integer.parseInt(idCurso));
			
			if(curso == null || curso.getIdCurso() == 0){
				FacesMessage facesMessage = new FacesMessage("Nenhum registro encontrado");
				getFacesContext().addMessage("formulario", facesMessage);
				return "listar curso";
			}
			
			getCursoService().excluir(curso.getIdCurso());
			return "sucesso";
		}catch(Exception e){
			String msg = "Exclusão não realizada. Movito: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			e.printStackTrace();
			return "falha";
		}finally{
			removeBean("formulario");
		}
	}
	
	public String alterar(){
		try{
			Curso curso = getCursoService().consultar(cursoBean.getIdCurso());
			
			if(curso == null || curso.getIdCurso() == 0){
				FacesMessage facesMessage = new FacesMessage("Nenhum registro encontrado");
				getFacesContext().addMessage("formulario", facesMessage);
				return "listar curso";
			}
			
			curso.setNomeCurso(cursoBean.getNomeCurso());
			curso.setCodigoCurso(cursoBean.getCodigoCurso());
			
			getCursoService().alterar(curso);
			return "sucesso";
		}catch(Exception e){
			String msg = "Alteração não realizada. Movito: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			e.printStackTrace();
			return "falha";
		}
	}
	
	
	
	
	public String addAnoSemestre(){
		
		try{
			
			if(cursoBean.getListMatriz() == null || cursoBean.getListMatriz().equals(null)){
				cursoBean.setListMatriz(new ArrayList<MatrizBean>());
			}
			
			
			MatrizBean novo = new MatrizBean();
			novo.setAnoSemestreMatriz(matrizBean.getAnoSemestreMatriz());
			
			cursoBean.getListMatriz().add(novo);
			
			matrizBean = new MatrizBean();
			
			this.setSession("anoSemestres", cursoBean.getListMatriz());
			
			return "criar curso";
			
		}catch(Exception e ){
			String msg = "Criação não realizada. Movito: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			e.printStackTrace();
			return "falha";
		}
	}
	
	public String rmvAnoSemestre(){
		try{
			HtmlDataTable anosemestres = (HtmlDataTable) this.getFacesContext().getViewRoot().findComponent("formulario:matriz");
			cursoBean.getListMatriz().remove(cursoBean.getListMatriz().indexOf(anosemestres.getRowData()));
			
			return null;
		}catch(Exception e){
			String msg = "Exclusão não realizada. Movito: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			e.printStackTrace();
			return "falha";
		}
	}
	
	public void removeBean(String bean){
		getFacesContext().getExternalContext().getSessionMap().remove(bean);
    }

	public CursoBean getCursoBean() {
		return cursoBean;
	}

	public void setCursoBean(CursoBean cursoBean) {
		this.cursoBean = cursoBean;
	}

	public List<CursoBean> getListCursoBean() {
		return listCursoBean;
	}

	public void setListCursoBean(List<CursoBean> listCursoBean) {
		this.listCursoBean = listCursoBean;
	}

	public MatrizBean getMatrizBean() {
		return matrizBean;
	}

	public void setMatrizBean(MatrizBean matrizBean) {
		this.matrizBean = matrizBean;
	}
	
	public CursoService getCursoService() {
		return cursoService;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}
	
	private FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}
	
	private Object getSession(String variavel){
		return this.getFacesContext().getExternalContext().getSessionMap().get(variavel);
	}
	
	private void setSession(String variavel, Object objeto){
		this.getFacesContext().getExternalContext().getSessionMap().put(variavel, objeto);
	}
}
