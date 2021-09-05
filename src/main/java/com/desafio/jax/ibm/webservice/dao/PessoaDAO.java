package com.desafio.jax.ibm.webservice.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.desafio.jax.ibm.webservice.model.Pessoa;

public class PessoaDAO {

	/*  
	 * Método que faz a conexão com banco de dados e consulta.
	 * */
	public Pessoa save(Pessoa pessoa) {    
		EntityManager em = JPAUtil.getEntityManager();
        try {
			em.getTransaction().begin();
			em.persist(pessoa);
			em.getTransaction().commit();
        } catch (Exception e) {
        	em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
			em.close();
		}
        return pessoa;
	}
	
	/*  
	 * Método que faz a conexão com banco de dados e consulta por pessoas.
	 * */
	public List<Pessoa> findByCpfOrName(String search) {
		EntityManager em = JPAUtil.getEntityManager();
		List<Pessoa> pessoas = null;
        try {
            pessoas = em.createQuery("select p from Pessoa p where p.nome = :name OR p.cpf = :cpf", Pessoa.class)
            		.setParameter("name", search)
            		.setParameter("cpf", search)
            		.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
			em.close();
		}
        return pessoas;
	}
}
