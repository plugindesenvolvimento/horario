package br.edu.ifba.plugin.horario.modelo.bd.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class ConexaoBD {

	private EntityManagerFactory managerFactory = null;

	public void iniciar(String bd) {
		managerFactory = Persistence.createEntityManagerFactory(bd);
	}

	public void fechar() {
		managerFactory.close();
	}

	public EntityManager getEntityManager() {
		return managerFactory.createEntityManager();
	}

}