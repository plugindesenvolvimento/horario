package br.edu.ifba.plugin.horario.controle;

import br.edu.ifba.plugin.horario.modelo.bd.dao.DisciplinasHorarioDAO;
import br.edu.ifba.plugin.horario.visao.IElaboracaoHorarioTurma;

public class ControleDisciplinasHorario {

	private DisciplinasHorarioDAO dao;

	public ControleDisciplinasHorario(IElaboracaoHorarioTurma disciplinasHorario) {
		dao = new DisciplinasHorarioDAO(disciplinasHorario);
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
