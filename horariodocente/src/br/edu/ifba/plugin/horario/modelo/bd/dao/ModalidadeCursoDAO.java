package br.edu.ifba.plugin.horario.modelo.bd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.ifba.plugin.horario.modelo.bd.beans.ModalidadeCurso;
import br.edu.ifba.plugin.horario.visao.ICadastroModalidadeCurso;

public class ModalidadeCursoDAO extends DAO{

	private ICadastroModalidadeCurso cadastro;

	public ModalidadeCursoDAO(ICadastroModalidadeCurso modalidadeCurso) {
		super();
		this.cadastro = modalidadeCurso;
	}

	public void listar() {
		List<ModalidadeCurso> encontrados = new ArrayList<ModalidadeCurso>();

		TypedQuery<ModalidadeCurso> query = em.createQuery(
				"select u from ModalidadeCurso u order by u.id", ModalidadeCurso.class);
		try {
			encontrados = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		cadastro.setListaModalidadesCurso(encontrados);
	}

	public void excluir() {
		try {
			iniciarTransacao();
			ModalidadeCurso m = em.merge(cadastro.getModalidadeCurso());
			em.remove(m);
			commitTransacao();
		} catch (Exception e) {
			e.printStackTrace();
			rollbackTransacao();
		}
	}

	public void gravar() {
		ModalidadeCurso modalidadeCurso = cadastro.getModalidadeCurso();
		modalidadeCurso.setIdregimeletivo(cadastro.getRegimeLetivo());
		
		try {
			iniciarTransacao();
			em.persist(modalidadeCurso);
			commitTransacao();		
			cadastro.notificarSucesso();
		} catch (Exception e) {
			rollbackTransacao();
			cadastro.notificarFalha();
		}
	}
		
	public List<ModalidadeCurso> getModalidades() {

		List<ModalidadeCurso> encontrados = new ArrayList<ModalidadeCurso>();

		TypedQuery<ModalidadeCurso> query = em.createQuery(
				"select u from ModalidadeCurso u order by u.id", ModalidadeCurso.class);
		try {
			encontrados = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		return encontrados;
	}	
}
