package br.edu.ifba.plugin.horario.visao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifba.plugin.horario.controle.ControleSala;
import br.edu.ifba.plugin.horario.modelo.bd.beans.Sala;
import br.edu.ifba.plugin.horario.visao.ICadastroSala;

@ManagedBean(name = "cadastroSala")
@ViewScoped
public class CadastroSala implements ICadastroSala {

	private List<Sala> salas = new ArrayList<Sala>();
	private Sala sala;
	boolean edicao = false;
	private ControleSala controle;
	
	public CadastroSala() {
		controle = new ControleSala(this);
	}

	public boolean exibirEditor() {
		return edicao;
	}

	public void prepararAdicao() {
		this.sala = new Sala();
		edicao = true;	
	}

	public void prepararEdicao(Sala sala) {
		this.sala = sala;
		edicao = true;
	}

	public void cancelarEdicao() {
		edicao = false;
	}

	public void listarSalas() {
		controle.listar();
	}
	
	public void excluirSala() {
		controle.excluir();
	}

	public void gravarSala() {
		controle.gravar();
	}
	
	@Override
	public Sala getSala() {	
		return sala;
	}

	@Override
	public void setListaSalas(List<Sala> salas) {
		this.salas = salas;
	}

	@Override
	public void notificarSucesso() {
		System.out.println("Operação Realizada com Sucesso!");
	}

	@Override
	public void notificarFalha() {
		System.out.println("Falhou!");
	}

	public List<Sala> getSalas() {
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
}
