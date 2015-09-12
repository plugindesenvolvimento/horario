package br.edu.ifba.plugin.horario.visao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifba.plugin.horario.controle.ControleAtividade;
import br.edu.ifba.plugin.horario.modelo.bd.beans.Atividade;
import br.edu.ifba.plugin.horario.visao.ICadastroAtividade;

@ManagedBean(name = "cadastroAtividade")
@ViewScoped
public class CadastroAtividade implements ICadastroAtividade {

	private List<Atividade> atividades = new ArrayList<Atividade>();
	private Atividade atividade;

	boolean edicao = false;

	private ControleAtividade controle;

	public CadastroAtividade() {
		controle = new ControleAtividade(this);
	}

	public boolean exibirEditor() {
		return edicao;
	}

	public void prepararAdicao() {
		this.atividade = new Atividade();

		edicao = true;
	
	}

	public void prepararEdicao(Atividade atividade) {
		this.atividade = atividade;
		edicao = true;
	}

	public void cancelarEdicao() {
		
		edicao = false;
	}

	@Override
	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public void listarAtividades() {
		controle.listar();
	}

	public void excluirAtividade() {
		controle.excluir();
	}

	public void gravarAtividade() {
		controle.gravar();
	}

	@Override
	public void setListaAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public List<Atividade> getAtividades() {
		return this.atividades;
	}

	@Override
	public void notificarSucesso() {
		System.out.println("Operação Realizada com Sucesso!");
	}

	@Override
	public void notificarFalha() {
		System.out.println("Falhou!");
	}
	
	public List<String> completeText(String query) {
        List<String> results = new ArrayList<String>();
         
        return results;
    }
	
}
