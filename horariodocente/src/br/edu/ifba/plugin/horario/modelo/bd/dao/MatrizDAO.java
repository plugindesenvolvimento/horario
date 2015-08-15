package br.edu.ifba.plugin.horario.modelo.bd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Matriz;
import br.edu.ifba.plugin.horario.visao.ICadastroMatriz;

public class MatrizDAO extends DAO{

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
			System.out.println("Iniciou a transaçao para exlcuir...");
			Matriz m = em.merge(cadastro.getMatriz());
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
		Matriz matriz = cadastro.getMatriz();
		
		System.out.println(matriz);
		System.out.println("... ... ...");
		
		try {
			iniciarTransacao();
			//if(matriz.getId() == -1)
			//{
				em.persist(matriz);
				System.out.println("Iseriu na tabela...");
			//}else{
				em.merge(matriz);
				System.out.println("Atualizou: ");
				System.out.println(matriz);
			//}
			commitTransacao();
			
			cadastro.notificarSucesso();
		} catch (Exception e) {
			rollbackTransacao();

			cadastro.notificarFalha();
		}

	}

	public String getHabilitado(){
		if(cadastro.getMatriz().getAtiva())
		{
			return "Sim";
		}else
		{
			return "Não";
		}
	}
	
	
}
