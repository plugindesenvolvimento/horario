package br.edu.ifba.plugin.horario.controle;

import br.edu.ifba.plugin.horario.modelo.bd.dao.AgendamentoDAO;
import br.edu.ifba.plugin.horario.visao.IAgendamento;

public class ControleAgendamento {

	private AgendamentoDAO dao;
	
	public ControleAgendamento(IAgendamento agendamento)
	{
		dao = new AgendamentoDAO(agendamento);
	}
	
	public void listar()
	{
		dao.listar();
	}
	
}
