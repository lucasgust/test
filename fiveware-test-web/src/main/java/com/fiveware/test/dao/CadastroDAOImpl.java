package com.fiveware.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.fiveware.test.model.Pessoa;

public class CadastroDAOImpl implements CadastroDAO {

	private JdbcTemplate jdbcTemplate;
	 
    public CadastroDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
	@Override
	public List<Pessoa> list() {
		String sql = "SELECT * FROM PESSOA";
		List<Pessoa> listPessoa = jdbcTemplate.query(sql, new RowMapper<Pessoa>() {
			@Override
			public Pessoa mapRow(ResultSet rs, int rowNum)
			throws SQLException {
				Pessoa pessoa = new Pessoa();
				
				pessoa.setId(rs.getInt("ID"));
				pessoa.setNome(rs.getString("NOME"));
				pessoa.setSexo(rs.getString("SEXO"));
				pessoa.setEstadoCivil(rs.getString("ESTADO_CIVIL"));
				pessoa.setEmpregado(rs.getString("EMPREGADO"));
				return pessoa;
			}
		});

		return listPessoa;
	}
	
	@Override
	public void insert(Pessoa pessoa) {
        String sql = " INSERT INTO PESSOA(NOME, SEXO, ESTADO_CIVIL, EMPREGADO) VALUES (?, ?, ?, ?) ";
        jdbcTemplate.update(sql, 
        		pessoa.getNome(), 
        		pessoa.getSexo(), 
        		pessoa.getEstadoCivil(), 
        		pessoa.getEmpregado() == null || pessoa.getEmpregado().trim().equals("") ? "NAO" : pessoa.getEmpregado());
	}

}
