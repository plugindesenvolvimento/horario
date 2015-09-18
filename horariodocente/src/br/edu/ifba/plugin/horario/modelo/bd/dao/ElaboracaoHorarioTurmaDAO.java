package br.edu.ifba.plugin.horario.modelo.bd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.ifba.plugin.horario.modelo.bd.beans.HorarioTurma;
import br.edu.ifba.plugin.horario.visao.IElaboracaoHorarioTurma;

public class ElaboracaoHorarioTurmaDAO extends DAO{

	private IElaboracaoHorarioTurma cadastro;
	
	public ElaboracaoHorarioTurmaDAO(IElaboracaoHorarioTurma horarioTurma) {
		super();
		this.cadastro = horarioTurma;
	}
	
	public void listar() {
		List<HorarioTurma> encontrados = new ArrayList<HorarioTurma>();

		TypedQuery<HorarioTurma> query = em.createQuery(
				"select u from HorarioTurma u order by u.id",
				HorarioTurma.class);
		try {
			encontrados = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		cadastro.setListaHorariosTurmas(encontrados);
	}
	
	public void gravar() {

		HorarioTurma horarioTurma = cadastro.getHorarioTurma();
		horarioTurma.setIdperiodoletivo(cadastro.getPeriodoLetivo());
		horarioTurma.setIdcurso(cadastro.getCurso());
		horarioTurma.setIdturno(cadastro.getTurno());
		horarioTurma.setNrperiodo(cadastro.getPeriodo());
		try {
			iniciarTransacao();
			em.persist(horarioTurma);
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
			HorarioTurma m = em.merge(cadastro.getHorarioTurma());
			em.remove(m);
			commitTransacao();
			cadastro.notificarSucesso();
		} catch (Exception e) {
			e.printStackTrace();
			rollbackTransacao();
			cadastro.notificarFalha();
		}
	}
	
	public void editar() {

		HorarioTurma horarioTurma = cadastro.getHorarioTurma();
		horarioTurma.setIdperiodoletivo(cadastro.getPeriodoLetivo());
		horarioTurma.setIdcurso(cadastro.getCurso());
		horarioTurma.setIdturno(cadastro.getTurno());
		horarioTurma.setNrperiodo(cadastro.getPeriodo());
		try {
			iniciarTransacao();
			em.persist(horarioTurma);
			commitTransacao();
			cadastro.notificarSucesso();
		} catch (Exception e) {
			rollbackTransacao();
			cadastro.notificarFalha();
		}
	}
}
