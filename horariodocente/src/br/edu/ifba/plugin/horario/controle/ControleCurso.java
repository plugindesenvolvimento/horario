package br.edu.ifba.plugin.horario.controle;

import br.edu.ifba.plugin.horario.modelo.bd.dao.CursoDAO;
import br.edu.ifba.plugin.horario.visao.ICadastroCurso;

public class ControleCurso {

	private CursoDAO dao;
	
	public ControleCurso(ICadastroCurso curso)
	{
		dao = new CursoDAO(curso);
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
