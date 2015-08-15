package br.edu.ifba.plugin.horario.modelo.bd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Curso;
import br.edu.ifba.plugin.horario.visao.ICadastroCurso;

public class CursoDAO extends DAO  {

	private ICadastroCurso cadastro;

	public CursoDAO(ICadastroCurso curso) {
		super();
		this.cadastro = curso;
	}

	public void listar() {

		System.out.println("Está Listando AQUUUUUIIII");

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
			System.out.println("Iniciou a transaçao para exlcuir...");
			Curso m = em.merge(cadastro.getCurso());
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
		Curso curso = cadastro.getCurso();

		System.out.println(curso);
		System.out.println("... ... ...");

		try {
			iniciarTransacao();
			// if(curso.getId() == -1)
			// {
			em.persist(curso);
			System.out.println("Iseriu na tabela...");
			// }else{
			// em.merge(curso);
			// System.out.println("Atualizou: ");
			// System.out.println(curso);
			// }
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

		System.out.println("ENTREI NO LOCAL CERTO !");

		System.out.println(idModalidade);
		
		/*iniciarTransacao();

		List<Curso> modalidades = new ArrayList<Curso>();

		TypedQuery<Curso> query = em.createQuery(
				"select u from Curso u where u.id = :idmodalidadecurso", Curso.class);
		
		try {
			modalidades = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}	
		

		commitTransacao();

		return modalidades;*/
		
		
		iniciarTransacao(); 
		 em.flush();

		    Query query = em.createNamedQuery("findByModalidadeCurso");

		    query.setParameter("idmodalidadecurso", idModalidade);

		    List<Curso> modalidades = (List<Curso>) query.getResultList();

		    em.clear();
		   commitTransacao(); 

		    return modalidades;
		
		/*
		List<Curso> modalidades = new ArrayList<Curso>();

		TypedQuery<Curso> query = em.createQuery(
				"select u from Curso u where u.idmodalidadecurso = :id", Curso.class);
		
		//"SELECT e FROM Estado e WHERE e.pais.id=:idPais"
		
		//query.setParameter("id", idModalidade);
		
		try {
			modalidades = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		return modalidades;
		
		
		
		List<Curso> encontrados = new ArrayList<Curso>();

		TypedQuery<Curso> query = em.createQuery(
				"SELECT u FROM Curso u where u.idmodalidadecurso.id=:idmodalidadecurso", Curso.class);
		try {
			encontrados = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		return encontrados;*/
	}
		   
}
