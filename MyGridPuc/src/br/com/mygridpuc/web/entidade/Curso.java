package br.com.mygridpuc.web.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Classe que representa os dados persistentes do curso
 * 
 * @author David Rodrigues
 *
 */


@Entity
@Table(name="curso")
public class Curso implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6043261167029558061L;

	@Expose
	//@SerializedName("ic")//Serializar o idCurso como ic
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCurso")
	private Integer idCurso;
	
	@Expose
	//@SerializedName("cc")//Serializar o codigoCurso como cc
	@Column(name="codigocurso", unique=true, length=4)
	private String codigoCurso;
	
	@Expose
	//@SerializedName("nc")//Serializar o nomeCurso como nc
	@Column(name="nomeCurso")
	private String nomeCurso;
	
	@Expose
	//@SerializedName("lm")//Serializar o listMatriz como lm
	@OneToMany(mappedBy="curso", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Matriz> listMatriz;
	
	public List<Matriz> getListMatriz() {
		return listMatriz;
	}
	public void setListMatriz(List<Matriz> listMatriz) {
		this.listMatriz = listMatriz;
	}

	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	
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
	@Override
	public String toString() {
		return "Curso [idCurso=" + idCurso + ", codigoCurso=" + codigoCurso
				+ ", nomeCurso=" + nomeCurso + "]";
	}
}
