package br.edu.ifba.plugin.horario.visao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifba.plugin.horario.controle.ControleDisciplina;
import br.edu.ifba.plugin.horario.modelo.bd.beans.Area;
import br.edu.ifba.plugin.horario.modelo.bd.beans.Disciplina;
import br.edu.ifba.plugin.horario.modelo.bd.dao.AreaDAO;
import br.edu.ifba.plugin.horario.visao.ICadastroDisciplina;

@ManagedBean(name = "cadastroDisciplina", eager = true)
@ViewScoped
public class CadastroDisciplina implements ICadastroDisciplina {

	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	private Disciplina disciplina;
	private Area area;
	private AreaDAO listaAreas = new AreaDAO(null);
	
	boolean edicao = false;

	private ControleDisciplina controle;

	public CadastroDisciplina() {
		controle = new ControleDisciplina(this);
	}

	public boolean exibirEditor() {
		return edicao;
	}

	public void prepararAdicao() {
		this.disciplina = new Disciplina();

		edicao = true;

	}

	public void prepararEdicao(Disciplina disciplina) {
		this.disciplina = disciplina;
		edicao = true;
	}

	public void cancelarEdicao() {

		edicao = false;
	}

	@Override
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public void listarDisciplinas() {
		controle.listar();
	}

	public void excluirDisciplina() {
		controle.excluir();
	}

	public void gravarDisciplina() {
		controle.gravar();
	}

	@Override
	public void setListaDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Disciplina> getDisciplinas() {
		return this.disciplinas;
	}

	@Override
	public void notificarSucesso() {
		System.out.println("Operação Realizada com Sucesso!");
	}

	@Override
	public void notificarFalha() {
		System.out.println("Falhou!");
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<Area> getListaArea() {
		return listaAreas.getAreas();
	}

}
