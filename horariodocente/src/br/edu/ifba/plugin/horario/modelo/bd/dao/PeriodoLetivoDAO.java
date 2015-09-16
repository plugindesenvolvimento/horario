package br.edu.ifba.plugin.horario.modelo.bd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.ifba.plugin.horario.modelo.bd.beans.PeriodoLetivo;
import br.edu.ifba.plugin.horario.visao.ICadastroPeriodoLetivo;

public class PeriodoLetivoDAO extends DAO {

	private ICadastroPeriodoLetivo cadastro;

	public PeriodoLetivoDAO(ICadastroPeriodoLetivo periodoletivo) {
		super();
		this.cadastro = periodoletivo;
	}

	public void listar() {
		List<PeriodoLetivo> encontrados = new ArrayList<PeriodoLetivo>();

		TypedQuery<PeriodoLetivo> query = em.createQuery(
				"select u from PeriodoLetivo u order by u.id",
				PeriodoLetivo.class);
		try {
			encontrados = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		cadastro.setListaPeriodosLetivos(encontrados);
	}

	public void excluir() {
		try {
			iniciarTransacao();
			PeriodoLetivo m = em.merge(cadastro.getPeriodoLetivo());
			em.remove(m);
			commitTransacao();
		} catch (Exception e) {
			e.printStackTrace();
			rollbackTransacao();
		}

	}

	public void gravar() {
		PeriodoLetivo periodoletivo = cadastro.getPeriodoLetivo();

		try {
			iniciarTransacao();
			em.persist(periodoletivo);
			em.merge(periodoletivo);
			commitTransacao();
			cadastro.notificarSucesso();
		} catch (Exception e) {
			rollbackTransacao();
			cadastro.notificarFalha();
		}
	}
}
