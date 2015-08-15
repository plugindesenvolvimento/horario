package br.edu.ifba.plugin.horario.visao;

import java.util.List;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Disciplina;

public interface IAgendamento {
	
//	public Professor getServidor();
	
	public Disciplina getDisciplina();

	public void setListaDisciplinas(List<Disciplina> disciplinas);

	
}
