package br.edu.ifba.plugin.horario.modelo.bd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Disciplina;
import br.edu.ifba.plugin.horario.visao.IAgendamento;

public class AgendamentoDAO extends DAO {

	private IAgendamento disciplina;

	public AgendamentoDAO(IAgendamento agendamento) {
		super();
		this.disciplina = agendamento;
	}

	public void listar() {
		List<Disciplina> encontrados = new ArrayList<Disciplina>();

		TypedQuery<Disciplina> query = em.createQuery(
				"select u from Disciplina u order by u.id", Disciplina.class);
		try {
			encontrados = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		disciplina.setListaDisciplinas(encontrados);
	}

}
