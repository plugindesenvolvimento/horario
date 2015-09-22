package br.edu.ifba.plugin.horario.controle;

import br.edu.ifba.plugin.horario.modelo.bd.dao.ElaboracaoHorarioTurmaDAO;
import br.edu.ifba.plugin.horario.visao.IElaboracaoHorarioTurma;

public class ControleElaboracaoHorarioTurma {

	private ElaboracaoHorarioTurmaDAO dao;

	public ControleElaboracaoHorarioTurma(IElaboracaoHorarioTurma horarioTurma) {
		dao = new ElaboracaoHorarioTurmaDAO(horarioTurma);
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
