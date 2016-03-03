package com.fiveware.test.model;

public class Pessoa {
	
	private String nome;
	private String sexo;
	private String estadoCivil;
	private String empregado;
	
	public Pessoa() {
	}
	
	public Pessoa(String nome, String sexo, String estadoCivil, String empregado) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.empregado = empregado;
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
