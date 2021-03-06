package br.edu.ifba.plugin.horario.modelo.bd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Disciplina;
import br.edu.ifba.plugin.horario.modelo.bd.beans.DisciplinasMatriz;
import br.edu.ifba.plugin.horario.visao.ICadastroDisciplinasMatriz;

public class DisciplinasMatrizDAO extends DAO {

	private ICadastroDisciplinasMatriz cadastro;

	public DisciplinasMatrizDAO(ICadastroDisciplinasMatriz disciplinasMatriz) {
		super();
		this.cadastro = disciplinasMatriz;
	}

	public void listar() {
		List<DisciplinasMatriz> encontrados = new ArrayList<DisciplinasMatriz>();

		TypedQuery<DisciplinasMatriz> query = em.createQuery(
				"select u from DisciplinasMatriz u order by u.id",
				DisciplinasMatriz.class);
		try {
			encontrados = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		cadastro.setListaDisciplinasMatrizes(encontrados);
	}

	public void gravar() {

		DisciplinasMatriz disciplinasMatriz = cadastro.getDisciplinasMatriz();
		disciplinasMatriz.setIdgrupocurricular(cadastro.getGrupoCurricular());
		disciplinasMatriz.setIddisciplina(cadastro.getDisciplina());
		disciplinasMatriz.setIdmatriz(cadastro.getMatriz());
		disciplinasMatriz.setNrperiodo(cadastro.getPeriodo());
		try {
			iniciarTransacao();
			em.persist(disciplinasMatriz);
			commitTransacao();
			cadastro.notificarSucesso();
		} catch (Exception e) {
			rollbackTransacao();
			cadastro.notificarFalha();
		}
	}

	public List<DisciplinasMatriz> getDisciplinasMatrizes() {

		List<DisciplinasMatriz> encontrados = new ArrayList<DisciplinasMatriz>();

		TypedQuery<DisciplinasMatriz> query = em.createQuery(
				"select u from DisciplinasMatriz u order by u.id",
				DisciplinasMatriz.class);
		try {
			encontrados = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		return encontrados;
	}

	public List<Disciplina> completarDisciplina(String nome) {

		List<Disciplina> encontrados = new ArrayList<Disciplina>();

		TypedQuery<Disciplina> query = em.createQuery(
				"select u from Disciplina u order by u.id", Disciplina.class);
		try {
			encontrados = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		List<Disciplina> filteredDisciplinas = new ArrayList<Disciplina>();

		for (int i = 0; i < encontrados.size(); i++) {
			Disciplina skin = encontrados.get(i);
			if (skin.getNome().toLowerCase().startsWith(nome)) {
				filteredDisciplinas.add(skin);
			}
		}
		return filteredDisciplinas;
	}

	public void excluir() {
		try {
			iniciarTransacao();
			DisciplinasMatriz m = em.merge(cadastro.getDisciplinasMatriz());
			em.remove(m);
			commitTransacao();
		} catch (Exception e) {
			e.printStackTrace();
			rollbackTransacao();
		}
	}
}
