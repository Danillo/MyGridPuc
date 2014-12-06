/**
 * 
 */
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

/**
 * Classe que representa os dados persistentes
 * 
 * @author Wesley
 *
 */
@Entity
@Table(name="turma")
public class Turma implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2165804340976244103L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idTurma")
	private Integer idTurma;
	
	@Expose
	@Column(name="codTurma")
	private String codTurma;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idDisciplina", nullable=false, insertable=true, updatable=true)
	private Disciplina disciplina;
	
	@Expose
	@OneToMany(mappedBy="turma", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Local> listLocais;

	public Integer getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Integer idTurma) {
		this.idTurma = idTurma;
	}

	public String getCodTurma() {
		return codTurma;
	}

	public void setCodTurma(String codTurma) {
		this.codTurma = codTurma;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Local> getListLocais() {
		return listLocais;
	}

	public void setListLocais(List<Local> listLocais) {
		this.listLocais = listLocais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codTurma == null) ? 0 : codTurma.hashCode());
		result = prime * result
				+ ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result + ((idTurma == null) ? 0 : idTurma.hashCode());
		result = prime * result
				+ ((listLocais == null) ? 0 : listLocais.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Turma))
			return false;
		Turma other = (Turma) obj;
		if (codTurma == null) {
			if (other.codTurma != null)
				return false;
		} else if (!codTurma.equals(other.codTurma))
			return false;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (idTurma == null) {
			if (other.idTurma != null)
				return false;
		} else if (!idTurma.equals(other.idTurma))
			return false;
		if (listLocais == null) {
			if (other.listLocais != null)
				return false;
		} else if (!listLocais.equals(other.listLocais))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Turma [idTurma=" + idTurma + ", codTurma=" + codTurma
				+ ", disciplina=" + disciplina + ", listLocais=" + listLocais
				+ "]";
	}

}
