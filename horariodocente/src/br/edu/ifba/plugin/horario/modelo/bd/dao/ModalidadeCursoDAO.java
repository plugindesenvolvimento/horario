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
			System.out.println("Iniciou a transaçao para exlcuir...");
			ModalidadeCurso m = em.merge(cadastro.getModalidadeCurso());
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
		ModalidadeCurso modalidadeCurso = cadastro.getModalidadeCurso();
		modalidadeCurso.setIdregimeletivo(cadastro.getRegimeLetivo());
		System.out.println(modalidadeCurso);
		System.out.println("... ... ...");
		
		try {
			iniciarTransacao();
			em.persist(modalidadeCurso);
			System.out.println("Inseriu na tabela...");
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
