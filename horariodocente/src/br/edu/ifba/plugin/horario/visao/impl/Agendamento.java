package br.edu.ifba.plugin.horario.visao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifba.plugin.horario.controle.ControleAgendamento;
import br.edu.ifba.plugin.horario.modelo.bd.beans.Disciplina;
import br.edu.ifba.plugin.horario.visao.IAgendamento;

@ManagedBean(name = "agendamento")
@ViewScoped
public class Agendamento implements IAgendamento {

	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
//	private Professor servidor;
	private Disciplina disciplina;

	private ControleAgendamento controle;

	public Agendamento() {
		controle = new ControleAgendamento(this);
	}

//	@Override
//	public Professor getServidor() {
//		return servidor;
//	}

//	public void setServidor(Professor servidor) {
//		this.servidor = servidor;
//	}

	@Override
	public void setListaDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;

	}

	public List<Disciplina> getDisciplinas() {
		return this.disciplinas;
	}

	@Override
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void listarDisciplinas() {
		controle.listar();
	}

}
