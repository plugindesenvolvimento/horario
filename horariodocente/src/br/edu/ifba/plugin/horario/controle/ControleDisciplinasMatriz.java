package br.edu.ifba.plugin.horario.controle;

import java.util.List;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Disciplina;
import br.edu.ifba.plugin.horario.modelo.bd.dao.DisciplinasMatrizDAO;
import br.edu.ifba.plugin.horario.visao.ICadastroDisciplinasMatriz;

public class ControleDisciplinasMatriz {

private DisciplinasMatrizDAO dao;
	
	public ControleDisciplinasMatriz(ICadastroDisciplinasMatriz disciplinasMatriz)
	{
		dao = new DisciplinasMatrizDAO(disciplinasMatriz);
	}
	
	public List<Disciplina> completarDisciplina(String nome)
	{
		return dao.completarDisciplina(nome);	
	}	
	
	public void gravar() {
		dao.gravar();
		//dao.listar();
	}
	
	
	
}
