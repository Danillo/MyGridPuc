package br.com.mygridpuc.web.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Representa o Objeto de negocio 'Disciplina'.
 * 
 * @author davi
 *
 */
@Entity
@Table(name="disciplina")
public class Disciplina implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4730697536306531341L;

	@Expose
	//@SerializedName("id")//Serializar o idDisciplina como id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idDisciplina")
	private Integer idDisciplina;
	
	@Expose
	//@SerializedName("cd")//Serializar o codigo Disciplina como cd
	@Column(name="codigo", unique=true)
	private String codigo;
	
	@Expose
	//@SerializedName("cr")//Serializar o créditos Disciplina como cr
	@Column(name="creditoDisciplina")
	private Integer credito;
	
	@Expose
	//@SerializedName("nd")//Serializar o nome Disciplina como nd
	@Column(name="nomeDiciplina")
	private String nome;
	
	@OneToMany(mappedBy="disciplina", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<MatrizDisciplina> listMAtrizDisciplina;
	
	@Expose
	@OneToMany(mappedBy="disciplina", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Turma> listTurma;

	public Integer getIdDisciplina() {
		return idDisciplina;
	}
	
	public void setIdDisciplina(Integer idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getCredito() {
		return credito;
	}

	public void setCredito(Integer credito) {
		this.credito = credito;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<MatrizDisciplina> getListMAtrizDisciplina() {
		return listMAtrizDisciplina;
	}

	public void setListMAtrizDisciplina(List<MatrizDisciplina> listMAtrizDisciplina) {
		this.listMAtrizDisciplina = listMAtrizDisciplina;
	}

	public List<Turma> getListTurma() {
		return listTurma;
	}

	public void setListTurma(List<Turma> listTurma) {
		this.listTurma = listTurma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((credito == null) ? 0 : credito.hashCode());
		result = prime * result
				+ ((idDisciplina == null) ? 0 : idDisciplina.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Disciplina))
			return false;
		Disciplina other = (Disciplina) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (credito == null) {
			if (other.credito != null)
				return false;
		} else if (!credito.equals(other.credito))
			return false;
		if (idDisciplina == null) {
			if (other.idDisciplina != null)
				return false;
		} else if (!idDisciplina.equals(other.idDisciplina))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Disciplina [idDisciplina=" + idDisciplina + ", codigo="
				+ codigo + ", credito=" + credito + ", nome=" + nome + "]";
	}

}
