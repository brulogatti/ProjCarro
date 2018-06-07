package br.com.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@NamedQuery (name=Carro.CONS_CARRO_ALL, query="Select c From Carro c")
/*
No select selecione todas as colunas da classe carro
Ele é usado pois no DB genérico é feito uma consulta
*/
@Entity
public class Carro {
	
	public static final String CONS_CARRO_ALL = "Carro.Consulta";
	
	@Id
	//Indica a chave primária
	@GeneratedValue
	//O id será autoincrementado
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
