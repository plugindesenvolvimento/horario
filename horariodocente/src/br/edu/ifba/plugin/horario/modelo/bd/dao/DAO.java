package br.edu.ifba.plugin.horario.modelo.bd.dao;

import javax.persistence.EntityManager;

import br.edu.ifba.plugin.horario.modelo.bd.conexao.ConexaoPlugin;

public abstract class DAO {

	protected EntityManager em;

	public DAO() {
		em = ConexaoPlugin.getInstancia().getEntityManager();
	}

	public void iniciarTransacao() {
		if (em.getTransaction().isActive() == false) {
			em.getTransaction().begin();
		}
	}

	public void rollbackTransacao() {
		em.getTransaction().rollback();
	}

	public void commitTransacao() {
		em.getTransaction().commit();
	}

}
