package br.edu.ifba.plugin.horario.modelo.bd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Matriz;
import br.edu.ifba.plugin.horario.visao.ICadastroMatriz;

public class MatrizDAO extends DAO {

	private ICadastroMatriz cadastro;

	public MatrizDAO(ICadastroMatriz matriz) {
		super();
		this.cadastro = matriz;
	}

	public void listar() {
		List<Matriz> encontrados = new ArrayList<Matriz>();

		TypedQuery<Matriz> query = em.createQuery(
				"select u from Matriz u order by u.id", Matriz.class);
		try {
			encontrados = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		cadastro.setListaMatrizes(encontrados);
	}

	public void excluir() {
		try {
			iniciarTransacao();
			Matriz m = em.merge(cadastro.getMatriz());
			em.remove(m);
			commitTransacao();
		} catch (Exception e) {
			e.printStackTrace();
			rollbackTransacao();
		}
	}

	public void gravar() {
		Matriz matriz = cadastro.getMatriz();

		try {
			iniciarTransacao();
			em.persist(matriz);
			em.merge(matriz);
			commitTransacao();
			cadastro.notificarSucesso();
		} catch (Exception e) {
			rollbackTransacao();
			cadastro.notificarFalha();
		}
	}
}
