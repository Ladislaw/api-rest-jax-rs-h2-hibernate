package com.desafio.jax.ibm.webservice.dao;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.desafio.jax.ibm.webservice.model.Pessoa;

public class PessoaDAO {

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
	
	public Optional<Pessoa> findByCpfOrName(String search) {
		Transaction transaction = null;
		Optional<Pessoa> pessoa = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            pessoa = session.createQuery("select p from Pessoa p where p.nome = :name OR p.cpf = :cpf", Pessoa.class)
            		.setParameter("name", search)
            		.setParameter("cpf", search)
            		.uniqueResultOptional();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return pessoa;
	}
}
