package br.edu.ifba.plugin.horario.modelo.bd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Sala;
import br.edu.ifba.plugin.horario.visao.IElaboracaoHorarioTurma;

public class SalaDAO extends DAO{

	private IElaboracaoHorarioTurma cadastro;

	public SalaDAO(IElaboracaoHorarioTurma sala) {
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
