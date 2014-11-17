/**
 * 
 */
package br.com.mygridpuc.web.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe que representa os dados persistentes da matriz
 * @author David Rodrigues
 *
 */

@Entity
@Table(name="matriz")
public class Matriz implements Serializable{

	private static final long serialVersionUID = 4314447931031362446L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idMatriz")
	private Integer idMatriz;
	
	@Column(name="anoSemestreMatriz", nullable=false)
	private String anoSemestreMatriz;

//	@ManyToOne
//	@JoinColumn(name="idcurso", referencedColumnName="idcurso", nullable=false,  insertable = false, updatable = false)
//	private Curso curso;

	@ManyToOne
	@JoinColumn(name="idcurso")
	private Curso curso;
		
//	@OneToMany(mappedBy="matriz", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//	private List<MatrizDisciplina> listMatrizDisciplinas;
	
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

//	public List<MatrizDisciplina> getListaMatrizDisciplinas() {
//		return listMatrizDisciplinas;
//	}
//
//	public void setListaMatrizDisciplinas(List<MatrizDisciplina> listaMatrizDisciplinas) {
//		this.listMatrizDisciplinas = listaMatrizDisciplinas;
//	}	
	
	public String getAnoSemestreMatriz() {
		return anoSemestreMatriz;
	}

	public void setAnoSemestreMatriz(String anoSemestreMatriz) {
		this.anoSemestreMatriz = anoSemestreMatriz;
	}

	
	
}
