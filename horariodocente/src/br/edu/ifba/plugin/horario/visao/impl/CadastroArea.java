package br.edu.ifba.plugin.horario.visao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifba.plugin.horario.controle.ControleArea;
import br.edu.ifba.plugin.horario.modelo.bd.beans.Area;
import br.edu.ifba.plugin.horario.visao.ICadastroArea;

@ManagedBean(name = "cadastroArea")
@ViewScoped
public class CadastroArea implements ICadastroArea {

	private List<Area> areas = new ArrayList<Area>();
	private Area area;
	boolean edicao = false;
	private ControleArea controle;
	
	public CadastroArea() {
		controle = new ControleArea(this);
	}

	public boolean exibirEditor() {
		return edicao;
	}

	public void prepararAdicao() {
		this.area = new Area();
		edicao = true;	
	}

	public void prepararEdicao(Area area) {
		this.area = area;
		edicao = true;
	}

	public void cancelarEdicao() {
		edicao = false;
	}

	@Override
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public void listarAreas() {
		controle.listar();
	}
	
	public void excluirArea() {
		controle.excluir();
	}

	public void gravarArea() {
		controle.gravar();
	}

	@Override
	public void setListaAreas(List<Area> areas) {
		this.areas = areas;
	}

	public List<Area> getAreas() {
		return this.areas;
	}

	@Override
	public void notificarSucesso() {
		System.out.println("Operação Realizada com Sucesso!");
	}

	@Override
	public void notificarFalha() {
		System.out.println("Falhou!");
	}
}
