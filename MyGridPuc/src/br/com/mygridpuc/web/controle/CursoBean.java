package br.com.mygridpuc.web.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

/**
 * Classe que representa o formulario web de Curso
 * @author DavidRodrigues
 *
 */
@ManagedBean
@Component
@SessionScoped
public class CursoBean extends AbstractBean {

	private static final long serialVersionUID = -268588916360933825L;
	//	private Integer idCurso;
	private String codigoCurso;
	private String nomeCurso;
	private List<MatrizBean> listMatriz;
	
	public List<MatrizBean> getListMatriz() {
		return listMatriz;
	}
	public void setListMatriz(List<MatrizBean> listMatriz) {
		this.listMatriz = listMatriz;
	}
//	public Integer getIdCurso() {
//		return idCurso;
//	}
//	public void setIdCurso(Integer idCurso) {
//		this.idCurso = idCurso;
//	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public String getCodigoCurso() {
		return codigoCurso;
	}
	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
}
