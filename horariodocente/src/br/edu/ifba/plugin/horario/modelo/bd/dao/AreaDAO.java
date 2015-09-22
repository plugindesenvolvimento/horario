package br.edu.ifba.plugin.horario.modelo.bd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Area;
import br.edu.ifba.plugin.horario.visao.ICadastroArea;

public class AreaDAO extends DAO {

	private ICadastroArea cadastro;

	public AreaDAO(ICadastroArea area) {
		super();
		this.cadastro = area;
	}

	public void listar() {
		List<Area> encontrados = new ArrayList<Area>();

		TypedQuery<Area> query = em.createQuery(
				"select u from Area u order by u.id", Area.class);
		try {
			encontrados = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		cadastro.setListaAreas(encontrados);
	}

	public void excluir() {
		try {
			iniciarTransacao();
			Area m = em.merge(cadastro.getArea());
			em.remove(m);
			commitTransacao();
		} catch (Exception e) {
			e.printStackTrace();
			rollbackTransacao();
		}

	}

	public void gravar() {
		Area area = cadastro.getArea();
		try {
			iniciarTransacao();
			em.persist(area);
			commitTransacao();
			cadastro.notificarSucesso();
		} catch (Exception e) {
			rollbackTransacao();
			cadastro.notificarFalha();
		}

	}

	public List<Area> getAreas() {

		List<Area> encontrados = new ArrayList<Area>();

		TypedQuery<Area> query = em.createQuery(
				"select u from Area u order by u.id", Area.class);
		try {
			encontrados = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		return encontrados;
	}

}
