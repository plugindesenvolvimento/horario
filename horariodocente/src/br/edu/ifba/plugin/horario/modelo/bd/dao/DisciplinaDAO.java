package br.edu.ifba.plugin.horario.modelo.bd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Disciplina;
import br.edu.ifba.plugin.horario.visao.ICadastroDisciplina;

public class DisciplinaDAO extends DAO {

	private ICadastroDisciplina cadastro;

	public DisciplinaDAO(ICadastroDisciplina disciplina) {
		super();
		this.cadastro = disciplina;
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

		cadastro.setListaDisciplinas(encontrados);
	}

	public void excluir() {
		try {
			iniciarTransacao();
			Disciplina m = em.merge(cadastro.getDisciplina());
			em.remove(m);
			commitTransacao();
		} catch (Exception e) {
			e.printStackTrace();
			rollbackTransacao();
		}

	}

	public void gravar() {
		Disciplina disciplina = cadastro.getDisciplina();

		try {
			iniciarTransacao();
			em.persist(disciplina);
			System.out.println("Iseriu na tabela...");
			em.merge(disciplina);
			commitTransacao();
			cadastro.notificarSucesso();
		} catch (Exception e) {
			rollbackTransacao();
			cadastro.notificarFalha();
		}

	}

	public List<Disciplina> getDisciplinas() {

		List<Disciplina> encontrados = new ArrayList<Disciplina>();

		TypedQuery<Disciplina> query = em.createQuery(
				"select u from Disciplina u order by u.id", Disciplina.class);
		try {
			encontrados = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		return encontrados;
	}
}
