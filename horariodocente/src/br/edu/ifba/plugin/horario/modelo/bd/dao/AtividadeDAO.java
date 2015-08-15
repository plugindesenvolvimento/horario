package br.edu.ifba.plugin.horario.modelo.bd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Atividade;
import br.edu.ifba.plugin.horario.visao.ICadastroAtividade;

public class AtividadeDAO extends DAO {

	private ICadastroAtividade cadastro;

	public AtividadeDAO(ICadastroAtividade atividade) {
		super();
		this.cadastro = atividade;
	}

	public void listar() {
		List<Atividade> encontrados = new ArrayList<Atividade>();

		TypedQuery<Atividade> query = em.createQuery(
				"select u from Atividade u order by u.id", Atividade.class);
		try {
			encontrados = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		cadastro.setListaAtividades(encontrados);
	}

	public void excluir() {
		try {
			iniciarTransacao();
			System.out.println("Iniciou a transaçao para exlcuir...");
			Atividade m = em.merge(cadastro.getAtividade());
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
		Atividade atividade = cadastro.getAtividade();
		
		System.out.println(atividade);
		System.out.println("... ... ...");
		
		try {
			iniciarTransacao();
			if(atividade.getId() == -1)
			{
				em.persist(atividade);
				System.out.println("Iseriu na tabela...");
			}else{
				em.merge(atividade);
				System.out.println("Atualizou: ");
				System.out.println(atividade);
			}
			commitTransacao();
			
			cadastro.notificarSucesso();
		} catch (Exception e) {
			rollbackTransacao();

			cadastro.notificarFalha();
		}

	}

}
