package br.edu.ifba.plugin.horario.visao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifba.plugin.horario.controle.ControlePeriodoLetivo;
import br.edu.ifba.plugin.horario.modelo.bd.beans.PeriodoLetivo;
import br.edu.ifba.plugin.horario.visao.ICadastroPeriodoLetivo;

@ManagedBean(name = "cadastroPeriodoLetivo")
@ViewScoped
public class CadastroPeriodoLetivo implements ICadastroPeriodoLetivo {

	private List<PeriodoLetivo> periodosletivos = new ArrayList<PeriodoLetivo>();
	private PeriodoLetivo periodoletivo;
	boolean edicao = false;
	private ControlePeriodoLetivo controle;

	public CadastroPeriodoLetivo() {
		controle = new ControlePeriodoLetivo(this);
	}

	public boolean exibirEditor() {
		return edicao;
	}

	public void prepararAdicao() {
		this.periodoletivo = new PeriodoLetivo();

		edicao = true;

	}

	public void prepararEdicao(PeriodoLetivo periodoletivo) {
		this.periodoletivo = periodoletivo;
		edicao = true;
	}

	public void cancelarEdicao() {

		edicao = false;
	}

	@Override
	public PeriodoLetivo getPeriodoLetivo() {
		return periodoletivo;
	}

	public void setPeriodoLetivo(PeriodoLetivo periodoletivo) {
		this.periodoletivo = periodoletivo;
	}

	public void listarPeriodosLetivos() {
		controle.listar();
	}

	public void excluirPeriodoLetivo() {
		controle.excluir();
	}

	public void gravarPeriodoLetivo() {
		controle.gravar();
	}

	@Override
	public void setListaPeriodosLetivos(List<PeriodoLetivo> periodosletivos) {
		this.periodosletivos = periodosletivos;
	}

	public List<PeriodoLetivo> getPeriodosLetivos() {
		return this.periodosletivos;
	}

	@Override
	public void notificarSucesso() {
		System.out.println("Operação Realizada com Sucesso!");
	}

	@Override
	public void notificarFalha() {
		System.out.println("Falhou!");
	}

	public List<PeriodoLetivo> getPeriodosletivos() {
		return periodosletivos;
	}

	public void setPeriodosletivos(List<PeriodoLetivo> periodosletivos) {
		this.periodosletivos = periodosletivos;
	}

	public PeriodoLetivo getPeriodoletivo() {
		return periodoletivo;
	}

	public void setPeriodoletivo(PeriodoLetivo periodoletivo) {
		this.periodoletivo = periodoletivo;
	}

}
