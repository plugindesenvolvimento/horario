package br.edu.ifba.plugin.horario.modelo.bd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Sala;
import br.edu.ifba.plugin.horario.visao.ICadastroSala;

public class SalaDAO extends DAO {

	private ICadastroSala cadastro;

	public SalaDAO(ICadastroSala sala) {
		super();
		this.cadastro = sala;
	}

	public void listar() {
		List<Sala> encontrados = new ArrayList<Sala>();

		TypedQuery<Sala> query = em.createQuery(
				"select u from Sala u order by u.id", Sala.class);
		try {
			encontrados = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		cadastro.setListaSalas(encontrados);
	}

	public void gravar() {
		Sala sala = cadastro.getSala();
		try {
			iniciarTransacao();
			em.persist(sala);
			commitTransacao();
			cadastro.notificarSucesso();
		} catch (Exception e) {
			rollbackTransacao();
			cadastro.notificarFalha();
		}
	}

	public void excluir() {
		try {
			iniciarTransacao();
			Sala m = em.merge(cadastro.getSala());
			em.remove(m);
			commitTransacao();
		} catch (Exception e) {
			e.printStackTrace();
			rollbackTransacao();
		}
	}

	public List<Sala> getSalas() {

		List<Sala> encontrados = new ArrayList<Sala>();

		TypedQuery<Sala> query = em.createQuery(
				"select u from Sala u order by u.id", Sala.class);
		try {
			encontrados = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		return encontrados;
	}

}
