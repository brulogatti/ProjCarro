package br.com.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@NamedQuery (name=Carro.CONS_CARRO_ALL, query="Select c From Carro c")
@Entity
public class Carro {
	
	public static final String CONS_CARRO_ALL = "Carro.Consulta";
	
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private String modelo;
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
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	

}
