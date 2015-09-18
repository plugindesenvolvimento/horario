package br.edu.ifba.plugin.horario.modelo.bd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Curso;
import br.edu.ifba.plugin.horario.visao.ICadastroCurso;

public class CursoDAO extends DAO {

	private ICadastroCurso cadastro;

	public CursoDAO(ICadastroCurso curso) {
		super();
		this.cadastro = curso;
	}

	public void listar() {

		List<Curso> encontrados = new ArrayList<Curso>();

		TypedQuery<Curso> query = em.createQuery(
				"select u from Curso u order by u.id", Curso.class);
		try {
			encontrados = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		cadastro.setListaCursos(encontrados);
	}

	public void excluir() {
		try {
			iniciarTransacao();
			Curso m = em.merge(cadastro.getCurso());
			em.remove(m);
			commitTransacao();
		} catch (Exception e) {
			e.printStackTrace();
			rollbackTransacao();
		}
	}

	public void gravar() {
		Curso curso = cadastro.getCurso();

		try {
			iniciarTransacao();
			em.persist(curso);
			commitTransacao();
			cadastro.notificarSucesso();
		} catch (Exception e) {
			rollbackTransacao();
			cadastro.notificarFalha();
		}

	}

	public List<Curso> getCursos() {

		List<Curso> encontrados = new ArrayList<Curso>();

		TypedQuery<Curso> query = em.createQuery(
				"select u from Curso u order by u.id", Curso.class);
		try {
			encontrados = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		return encontrados;
	}

	@SuppressWarnings("unchecked")
	public List<Curso> getByModalidade(Integer idModalidade) {

		iniciarTransacao();
		em.flush();
		Query query = em.createNamedQuery("findByModalidadeCurso");
		query.setParameter("idmodalidadecurso", idModalidade);
		List<Curso> modalidades = (List<Curso>) query.getResultList();
		em.clear();
		commitTransacao();

		return modalidades;
	}
}
