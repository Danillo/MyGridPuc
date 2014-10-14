package br.com.mygridpuc.web.controle;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

/**
 * 	Representa o bean Disciplina, que contem as informacoes que serao exibidas na view.
 * 
 * @author davi
 * 
 */
@ManagedBean
@Component
@SessionScoped
public class DisciplinaBean {
	
	public DisciplinaBean(){
		codigo = 0;
		credito = 0;
		id = 0;
		nome = ""; 
		turma = new TurmaBean();
		turmas = new ArrayList<TurmaBean>();
	}
	
	private int codigo;
	private int credito;
	private int id;
	private String nome;
	private TurmaBean turma;
	private ArrayList<TurmaBean> turmas;
		
	public TurmaBean getTurma() {
		return turma;
	}
	public void setTurma(TurmaBean turma) {
		this.turma = turma;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCredito() {
		return credito;
	}
	public void setCredito(int credito) {
		this.credito = credito;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<TurmaBean> getTurmas() {
		return turmas;
	}
	public void setTurmas(ArrayList<TurmaBean> turmas) {
		this.turmas = turmas;
	}
	
	public String toString(){
		return "Codigo: " + codigo + ", Credito: " + credito + ", id: " +id + ", nome: " + nome + ", turma: " + turma + "turmas: " + turmas;
	}
}
