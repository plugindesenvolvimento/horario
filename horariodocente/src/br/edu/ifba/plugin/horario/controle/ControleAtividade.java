package br.edu.ifba.plugin.horario.controle;

import br.edu.ifba.plugin.horario.modelo.bd.dao.AtividadeDAO;
import br.edu.ifba.plugin.horario.visao.ICadastroAtividade;

public class ControleAtividade {
	
	private AtividadeDAO dao;
	
	public ControleAtividade(ICadastroAtividade atividade)
	{
		dao = new AtividadeDAO(atividade);
	}
		
	public void listar()
	{
		dao.listar();
	}
	

	public void gravar()
	{
		dao.gravar();
		dao.listar();
	}
	
	public void excluir()
	{
		dao.excluir();
		dao.listar();
	}
	
	
}
