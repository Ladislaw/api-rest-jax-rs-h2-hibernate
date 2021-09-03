package com.desafio.jax.ibm.webservice.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.desafio.jax.ibm.webservice.model.Pessoa;

public class PessoaDAO {

	/*  
	 * Método que faz a conexão com banco de dados e consulta.
	 * */
	public Pessoa save(Pessoa pessoa) {    
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(pessoa);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return pessoa;
	}
	
	/*  
	 * Método que faz a conexão com banco de dados e consulta por pessoas.
	 * */
	public List<Pessoa> findByCpfOrName(String search) {
		Transaction transaction = null;
		List<Pessoa> pessoas = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            pessoas = session.createQuery("select p from Pessoa p where p.nome = :name OR p.cpf = :cpf", Pessoa.class)
            		.setParameter("name", search)
            		.setParameter("cpf", search)
            		.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return pessoas;
	}
}
