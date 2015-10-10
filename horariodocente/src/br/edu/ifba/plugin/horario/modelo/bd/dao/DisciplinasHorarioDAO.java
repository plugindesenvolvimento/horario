package br.edu.ifba.plugin.horario.modelo.bd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.ifba.plugin.horario.modelo.bd.beans.DisciplinasHorario;
import br.edu.ifba.plugin.horario.visao.IElaboracaoHorarioTurma;

public class DisciplinasHorarioDAO extends DAO {

	private IElaboracaoHorarioTurma cadastro;

	public DisciplinasHorarioDAO(IElaboracaoHorarioTurma disciplinasHorario) {
		super();
		this.cadastro = disciplinasHorario;
	}

	public void listar() {
		List<DisciplinasHorario> encontrados = new ArrayList<DisciplinasHorario>();

		TypedQuery<DisciplinasHorario> query = em.createQuery(
				"select u from DisciplinasHorario u order by u.id",
				DisciplinasHorario.class);
		try {
			encontrados = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		cadastro.setListaDisciplinasHorarios(encontrados);
	}

	public void gravar() {

		DisciplinasHorario disciplinasHorario = cadastro.getDisciplinasHorario();
		disciplinasHorario.setIdhorarioturma(cadastro.getHorarioTurma());
		disciplinasHorario.setIddisciplina(cadastro.getDisciplina());
		disciplinasHorario.setIdservidor(cadastro.getServidor());
		disciplinasHorario.setIdsala(cadastro.getSala());
		try {
			iniciarTransacao();
			em.persist(disciplinasHorario);
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
			DisciplinasHorario m = em.merge(cadastro.getDisciplinasHorario());
			em.remove(m);
			commitTransacao();
			cadastro.notificarSucesso();
		} catch (Exception e) {
			e.printStackTrace();
			rollbackTransacao();
			cadastro.notificarFalha();
		}
	}

}
