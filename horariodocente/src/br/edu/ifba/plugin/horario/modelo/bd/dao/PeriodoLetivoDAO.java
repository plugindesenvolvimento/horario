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
			System.out.println("Iniciou a transaçao para exlcuir...");
			PeriodoLetivo m = em.merge(cadastro.getPeriodoLetivo());
			System.out.println(m);
			em.remove(m);
			System.out.println("Excluiu da lista...");
			commitTransacao();
		} catch (Exception e) {
			System.out.println("Não excluiu da lista...");
			e.printStackTrace();
			rollbackTransacao();
		}

	}

	public void gravar() {
		PeriodoLetivo periodoletivo = cadastro.getPeriodoLetivo();

		System.out.println(periodoletivo);
		System.out.println("... ... ...");

		try {
			iniciarTransacao();
			// if(periodoletivo.getId() == -1)
			// {
			em.persist(periodoletivo);
			System.out.println("Iseriu na tabela...");
			// }else{
			em.merge(periodoletivo);
			// System.out.println("Atualizou: ");
			// System.out.println(periodoletivo);
			// }
			commitTransacao();

			cadastro.notificarSucesso();
		} catch (Exception e) {
			rollbackTransacao();

			cadastro.notificarFalha();
		}

	}

}
