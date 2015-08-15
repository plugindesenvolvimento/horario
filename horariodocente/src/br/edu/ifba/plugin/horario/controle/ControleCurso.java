package br.edu.ifba.plugin.horario.controle;

import java.util.List;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Curso;
import br.edu.ifba.plugin.horario.modelo.bd.beans.ModalidadeCurso;
import br.edu.ifba.plugin.horario.modelo.bd.dao.CursoDAO;
import br.edu.ifba.plugin.horario.visao.ICadastroCurso;

public class ControleCurso {

	private CursoDAO dao;
	private ModalidadeCurso modalidade;
		
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
	
	public List<Curso> getByModalidade()
	{
		return dao.getByModalidade(modalidade.getId());
	}
	
}
