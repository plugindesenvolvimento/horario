package br.edu.ifba.plugin.horario.modelo.bd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Pessoa;
import br.edu.ifba.plugin.horario.visao.IElaboracaoHorarioTurma;

public class PessoaDAO extends DAO{

	private IElaboracaoHorarioTurma cadastro;
	
	public PessoaDAO(IElaboracaoHorarioTurma pessoa) {
		super();
		this.cadastro = pessoa;
	}
	
	public List<Pessoa> getPessoas() {

		List<Pessoa> encontrados = new ArrayList<Pessoa>();

		TypedQuery<Pessoa> query = em.createQuery(
				"select u from Pessoa u order by u.id", Pessoa.class);
		try {
			encontrados = query.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		return encontrados;
	}
	
}
