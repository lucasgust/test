package com.fiveware.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa {

	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	 
	private String nome;
	
	private String sexo;
	
	@Column(name = "estado_civil")
	
	private String estadoCivil;
	
	private String empregado;

	public Pessoa() {
	}

	public Pessoa(int id, String nome, String sexo, String estadoCivil,
			String empregado) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.empregado = empregado;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEmpregado() {
		return empregado;
	}

	public void setEmpregado(String empregado) {
		this.empregado = empregado;
	}
}
