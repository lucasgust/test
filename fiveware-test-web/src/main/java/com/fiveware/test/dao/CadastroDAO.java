package com.fiveware.test.dao;

import java.util.List;

import com.fiveware.test.model.Pessoa;

public interface CadastroDAO {

	public List<Pessoa> list();
	
	public void insert(Pessoa pessoa);
}
