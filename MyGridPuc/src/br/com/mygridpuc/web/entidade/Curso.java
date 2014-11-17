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

/**
 * Classe que representa os dados persistentes do curso
 * @author David Rodrigues
 *
 */

@Entity
@Table(name="curso")
public class Curso implements Serializable{
	
	private static final long serialVersionUID = 2757727363377720051L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcurso")
	private Integer idCurso;
	
	@Column(name="codigocurso", length=4)
	private String codigoCurso;
	
	@Column(name="nomecurso")
	private String nomeCurso;
	
	@OneToMany(mappedBy = "curso", targetEntity = Matriz.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
}
