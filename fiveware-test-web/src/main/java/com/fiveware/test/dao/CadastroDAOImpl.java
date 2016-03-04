package com.fiveware.test.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.fiveware.test.model.Pessoa;

public class CadastroDAOImpl implements CadastroDAO {

	EntityManagerFactory factory;

    public CadastroDAOImpl() {
        factory = Persistence.createEntityManagerFactory("test");
    }
    
	@Override
	public List<Pessoa> list() {
		EntityManager em = factory.createEntityManager();
		TypedQuery<Pessoa> query = em.createQuery("select p from Pessoa p", Pessoa.class);
		List<Pessoa> pessoas = query.getResultList();
        em.close();
        return pessoas;
	}
	
	@Override
	public void insert(Pessoa pessoa) {
		EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(pessoa);
        tx.commit();
        em.close();
	}

}
