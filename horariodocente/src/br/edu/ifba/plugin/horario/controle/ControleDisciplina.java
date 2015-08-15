package br.edu.ifba.plugin.horario.controle;

import java.util.List;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Area;
import br.edu.ifba.plugin.horario.modelo.bd.dao.DisciplinaDAO;
import br.edu.ifba.plugin.horario.visao.ICadastroDisciplina;

public class ControleDisciplina {

	private DisciplinaDAO dao;

	public ControleDisciplina(ICadastroDisciplina disciplina) {
		dao = new DisciplinaDAO(disciplina);
	}

	public void listar() {
		dao.listar();
	}

	public void gravar() {
		dao.gravar();
		dao.listar();
	}

	public void excluir() {
		dao.excluir();
		dao.listar();
	}

	public List<Area> getAreas()
	{
		return dao.getAreas();	
	}
	
}
