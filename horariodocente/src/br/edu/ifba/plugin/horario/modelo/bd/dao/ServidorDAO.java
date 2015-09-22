package br.edu.ifba.plugin.horario.modelo.bd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Servidor;
import br.edu.ifba.plugin.horario.visao.IElaboracaoHorarioTurma;

public class ServidorDAO extends DAO{

	private IElaboracaoHorarioTurma cadastro;

	public ServidorDAO(IElaboracaoHorarioTurma servidor) {
		super();
		this.cadastro = servidor;
	}

	public void listar() {
		List<Servidor> encontrados = new ArrayList<Servidor>();

		TypedQuery<Servidor> query = em.createQuery(
				"select u from Servidor u order by u.id", Servidor.class);
		try {
			encontrados = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		cadastro.setListaServidores(encontrados);
	}

	public List<Servidor> getServidores() {

		List<Servidor> encontrados = new ArrayList<Servidor>();

		TypedQuery<Servidor> query = em.createQuery(
				"select u from Servidor u order by u.id", Servidor.class);
		try {
			encontrados = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		return encontrados;
	}
}
