package br.edu.ifms.ProjetoN1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity (name="carro")
public class CarroModel implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String placa;
	

	@OneToMany(mappedBy = "carro", cascade = CascadeType.ALL)
	private List<MultaModel> multas = new ArrayList<>();
	
	

	public List<MultaModel> getMultas() {
		return multas;
	}
	public void setMultas(List<MultaModel> multas) {
		this.multas = multas;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
}
