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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Classe que representa os dados persistentes da matriz
 * 
 * @author David Rodrigues
 *
 */

@Entity
@Table(name="matriz")
public class Matriz implements Serializable{

	private static final long serialVersionUID = 4314447931031362446L;
	@Expose
	//@SerializedName("im")//Serializar o idMatriz como im
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idMatriz")
	private Integer idMatriz;
	
	@Expose
	//@SerializedName("as")//Serializar o anoSemestreMatriz como as
	@Column(name="anoSemestreMatriz", nullable=false)
	private String anoSemestreMatriz;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCurso", nullable=false, insertable=true, updatable=true)
	private Curso curso;
		
	@OneToMany(mappedBy="matriz", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<MatrizDisciplina> listMatrizDisciplinas;
	
	public Integer getIdMatriz() {
		return idMatriz;
	}

	public void setIdMatriz(Integer idMatriz) {
		this.idMatriz = idMatriz;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<MatrizDisciplina> getListaMatrizDisciplinas() {
		return listMatrizDisciplinas;
	}

	public void setListaMatrizDisciplinas(List<MatrizDisciplina> listaMatrizDisciplinas) {
		this.listMatrizDisciplinas = listaMatrizDisciplinas;
	}	
	
	public String getAnoSemestreMatriz() {
		return anoSemestreMatriz;
	}

	public void setAnoSemestreMatriz(String anoSemestreMatriz) {
		this.anoSemestreMatriz = anoSemestreMatriz;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((anoSemestreMatriz == null) ? 0 : anoSemestreMatriz
						.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result
				+ ((idMatriz == null) ? 0 : idMatriz.hashCode());
		result = prime * result
				+ ((listMatrizDisciplinas == null) ? 0 : listMatrizDisciplinas.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Matriz [idMatriz=" + idMatriz + ", anoSemestreMatriz="
				+ anoSemestreMatriz + ", curso=" + curso
				+ ", listMatrizDisciplinas=" + listMatrizDisciplinas + "]";
	}
	
}