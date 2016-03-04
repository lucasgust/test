package com.fiveware.test.model;

public class Pessoa {

	private int id;
	private String nome;
	private String sexo;
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
