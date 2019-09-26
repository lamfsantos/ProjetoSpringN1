package br.edu.ifms.ProjetoN1.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name="multa")
public class MultaModel implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String ano;
	private String cidade;
	
	
	@ManyToOne
	@JoinColumn(name = "carro_id")
	private CarroModel carro;
	
	
	@ManyToOne
	@JoinColumn(name = "infracao_id")
	private InfracaoModel infracao;
	
	
	
	public CarroModel getCarro() {
		return carro;
	}
	public void setCarro(CarroModel carro) {
		this.carro = carro;
	}
	public InfracaoModel getInfracao() {
		return infracao;
	}
	public void setInfracao(InfracaoModel infracao) {
		this.infracao = infracao;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
}
