package br.edu.ifba.plugin.horario.visao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifba.plugin.horario.controle.ControleModalidadeCurso;
import br.edu.ifba.plugin.horario.enumeradores.RegimeLetivo;
import br.edu.ifba.plugin.horario.modelo.bd.beans.ModalidadeCurso;
import br.edu.ifba.plugin.horario.visao.ICadastroModalidadeCurso;

@ManagedBean(name = "cadastroModalidadeCurso")
@ViewScoped
public class CadastroModalidadeCurso implements ICadastroModalidadeCurso {

	private List<ModalidadeCurso> modalidadesCurso = new ArrayList<ModalidadeCurso>();
	private ModalidadeCurso modalidadeCurso;
	private RegimeLetivo regimeLetivo;
	boolean edicao = false;
	private ControleModalidadeCurso controle;
	
	public CadastroModalidadeCurso() {
		controle = new ControleModalidadeCurso(this);
	}

	public boolean exibirEditor() {
		return edicao;
	}

	public void prepararAdicao() {
		this.modalidadeCurso = new ModalidadeCurso();
		edicao = true;	
	}

	public void prepararEdicao(ModalidadeCurso modalidadeCurso) {
		this.modalidadeCurso = modalidadeCurso;
		edicao = true;
	}

	public void cancelarEdicao() {
		edicao = false;
	}

	@Override
	public ModalidadeCurso getModalidadeCurso() {
		return modalidadeCurso;
	}

	public void setModalidadeCurso(ModalidadeCurso modalidadeCurso) {
		this.modalidadeCurso = modalidadeCurso;
	}

	public void listarModalidadesCurso() {
		controle.listar();
	}

	public void excluirModalidadeCurso() {
		controle.excluir();
	}

	public void gravarModalidadeCurso() {
		controle.gravar();
	}

	@Override
	public void setListaModalidadesCurso(List<ModalidadeCurso> modalidadesCurso) {
		this.modalidadesCurso = modalidadesCurso;
	}

	public List<ModalidadeCurso> getModalidadesCurso() {
		return this.modalidadesCurso;
	}

	@Override
	public void notificarSucesso() {
		System.out.println("Operação Realizada com Sucesso!");
	}

	@Override
	public void notificarFalha() {
		System.out.println("Falhou!");
	}

	@Override
	public RegimeLetivo getRegimeLetivo() {
		return regimeLetivo;
	}

	public void setRegimeLetivo(RegimeLetivo regimeLetivo) {
		this.regimeLetivo = regimeLetivo;
	}
	
	public RegimeLetivo[] getListaRegimeLetivo()
	{
		return RegimeLetivo.values();
	}
}
