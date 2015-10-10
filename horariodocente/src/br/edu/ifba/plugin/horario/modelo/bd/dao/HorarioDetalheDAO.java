package br.edu.ifba.plugin.horario.modelo.bd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.ifba.plugin.horario.modelo.bd.beans.HorarioDetalhe;
import br.edu.ifba.plugin.horario.visao.IElaboracaoHorarioTurma;

public class HorarioDetalheDAO extends DAO {

	private IElaboracaoHorarioTurma cadastro;

	public HorarioDetalheDAO(IElaboracaoHorarioTurma horarioDetalhe) {
		super();
		this.cadastro = horarioDetalhe;
	}

	public void listar() {
		List<HorarioDetalhe> encontrados = new ArrayList<HorarioDetalhe>();

		TypedQuery<HorarioDetalhe> query = em.createQuery(
				"select u from HorarioDetalhe u order by u.id", HorarioDetalhe.class);
		try {
			encontrados = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		cadastro.setListaHorariosDetalhes(encontrados);
	}

	public void gravar() {
		HorarioDetalhe horarioDetalhe = cadastro.getHorarioDetalhe();
		horarioDetalhe.setIddisciplinashorario(cadastro.getDisciplinasHorario());
		horarioDetalhe.setIddiasemana(cadastro.getDiaSemana());
		horarioDetalhe.setIdhorario(cadastro.getHorario());
		try {
			iniciarTransacao();
			em.persist(horarioDetalhe);
			commitTransacao();
			cadastro.notificarSucesso();
		} catch (Exception e) {
			rollbackTransacao();
			cadastro.notificarFalha();
		}
	}

	
}
