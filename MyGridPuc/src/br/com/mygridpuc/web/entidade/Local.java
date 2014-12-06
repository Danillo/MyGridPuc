/**
 * 
 */
package br.com.mygridpuc.web.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

/**
 * Classe que representa os dados persistentes do curso
 * 
 * @author David Rodrigues / Wesley
 *
 */

@Entity
@Table(name="local")
public class Local implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1260661504104352006L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idlocal")
	private Integer idLocal;

	@Expose
	@Column(name="area")
	private Integer area;
	
	@Expose
	@Column(name="bloco")
	private String bloco;
	
	@Expose
	@Column(name="sala")
	private Integer sala;
	
	@Expose
	@Column(name="dia_semana")
	private Integer dia_semana;
	
	@Expose
	@Column(name="hora_ini")
	private String hora_ini;
	
	@Expose
	@Column(name="hora_fim")
	private String hora_fim;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idTurma", nullable=false, insertable=true, updatable=true)
	private Turma turma;
	
	
	public Integer getIdLocal() {
		return idLocal;
	}
	public void setIdLocal(Integer idLocal) {
		this.idLocal = idLocal;
	}
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public String getBloco() {
		return bloco;
	}
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}
	public Integer getSala() {
		return sala;
	}
	public void setSala(Integer sala) {
		this.sala = sala;
	}
	public Integer getDia_semana() {
		return dia_semana;
	}
	public void setDia_semana(Integer dia_semana) {
		this.dia_semana = dia_semana;
	}
	public String getHora_ini() {
		return hora_ini;
	}
	public void setHora_ini(String hora_ini) {
		this.hora_ini = hora_ini;
	}
	public String getHora_fim() {
		return hora_fim;
	}
	public void setHora_fim(String hora_fim) {
		this.hora_fim = hora_fim;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((bloco == null) ? 0 : bloco.hashCode());
		result = prime * result
				+ ((dia_semana == null) ? 0 : dia_semana.hashCode());
		result = prime * result
				+ ((hora_fim == null) ? 0 : hora_fim.hashCode());
		result = prime * result
				+ ((hora_ini == null) ? 0 : hora_ini.hashCode());
		result = prime * result + ((idLocal == null) ? 0 : idLocal.hashCode());
		result = prime * result + ((sala == null) ? 0 : sala.hashCode());
		result = prime * result + ((turma == null) ? 0 : turma.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Local))
			return false;
		Local other = (Local) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (bloco == null) {
			if (other.bloco != null)
				return false;
		} else if (!bloco.equals(other.bloco))
			return false;
		if (dia_semana == null) {
			if (other.dia_semana != null)
				return false;
		} else if (!dia_semana.equals(other.dia_semana))
			return false;
		if (hora_fim == null) {
			if (other.hora_fim != null)
				return false;
		} else if (!hora_fim.equals(other.hora_fim))
			return false;
		if (hora_ini == null) {
			if (other.hora_ini != null)
				return false;
		} else if (!hora_ini.equals(other.hora_ini))
			return false;
		if (idLocal == null) {
			if (other.idLocal != null)
				return false;
		} else if (!idLocal.equals(other.idLocal))
			return false;
		if (sala == null) {
			if (other.sala != null)
				return false;
		} else if (!sala.equals(other.sala))
			return false;
		if (turma == null) {
			if (other.turma != null)
				return false;
		} else if (!turma.equals(other.turma))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Local [idLocal=" + idLocal + ", area=" + area + ", bloco="
				+ bloco + ", sala=" + sala + ", dia_semana=" + dia_semana
				+ ", hora_ini=" + hora_ini + ", hora_fim=" + hora_fim
				+ ", turma=" + turma + "]";
	}
		
}
