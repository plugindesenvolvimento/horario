package br.edu.ifba.plugin.horario.visao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import br.edu.ifba.plugin.horario.controle.ControleMatriz;
import br.edu.ifba.plugin.horario.modelo.bd.beans.Curso;
import br.edu.ifba.plugin.horario.modelo.bd.beans.Matriz;
import br.edu.ifba.plugin.horario.modelo.bd.beans.ModalidadeCurso;
import br.edu.ifba.plugin.horario.modelo.bd.dao.CursoDAO;
import br.edu.ifba.plugin.horario.modelo.bd.dao.ModalidadeCursoDAO;
import br.edu.ifba.plugin.horario.visao.ICadastroMatriz;

@ManagedBean(name = "cadastroMatriz")
@ViewScoped
public class CadastroMatriz implements ICadastroMatriz {

	private List<Matriz> matrizes = new ArrayList<Matriz>();
	private Matriz matriz;
	private ModalidadeCursoDAO listaModalidades = new ModalidadeCursoDAO(null);
	private CursoDAO listaCursos = new CursoDAO(null);
	private Curso selectedCurso = new Curso();
	private ModalidadeCurso selectedModalidade = new ModalidadeCurso();
	private ModalidadeCurso modalidade;
	
	public ModalidadeCurso getModalidade() {
		return modalidade;
	}

	public void setModalidade(ModalidadeCurso modalidade) {
		this.modalidade = modalidade;
	}


	boolean edicao = false;

	private ControleMatriz controle;

	public CadastroMatriz() {
		controle = new ControleMatriz(this);
	}

	public boolean exibirEditor() {
		return edicao;
	}

	public void prepararAdicao() {
		this.matriz = new Matriz();

		edicao = true;
	
	}

	public void prepararEdicao(Matriz matriz) {
		this.matriz = matriz;
		edicao = true;
	}

	public void cancelarEdicao() {
		
		edicao = false;
	}

	@Override
	public Matriz getMatriz() {
		return matriz;
	}

	public void setMatriz(Matriz matriz) {
		this.matriz = matriz;
	}

	public void listarMatrizes() {
		controle.listar();
	}

	public void excluirMatriz() {
		controle.excluir();
	}

	public void gravarMatriz() {
		controle.gravar();
	}

	@Override
	public void setListaMatrizes(List<Matriz> matrizes) {
		this.matrizes = matrizes;
	}

	public List<Matriz> getMatrizes() {
		return this.matrizes;
	}

	@Override
	public void notificarSucesso() {
		System.out.println("Operação Realizada com Sucesso!");
	}

	@Override
	public void notificarFalha() {
		System.out.println("Falhou!");
	}
	
	public List<ModalidadeCurso> getListaModalidadeCurso(){
		return listaModalidades.getModalidades();
	}
	
	
	public CursoDAO getListaCursos() {
		return listaCursos;
	}

	public void setListaCursos(CursoDAO listaCursos) {
		this.listaCursos = listaCursos;
	}

	public Curso getSelectedCurso() {
		return selectedCurso;
	}

	public void setSelectedCurso(Curso selectedCurso) {
		this.selectedCurso = selectedCurso;
	}

	
	
	public void atualizarCursos(AjaxBehaviorEvent event){
		  listaCursos.getByModalidade(selectedModalidade.getId());
	}

	public ModalidadeCursoDAO getListaModalidades() {
		return listaModalidades;
	}

	public void setListaModalidades(ModalidadeCursoDAO listaModalidades) {
		this.listaModalidades = listaModalidades;
	}

	@Override
	public ModalidadeCurso getSelectedModalidade() {
		return selectedModalidade;
	}

	public void setSelectedModalidade(ModalidadeCurso selectedModalidade) {
		this.selectedModalidade = selectedModalidade;
	}
	
	
	public void getHabilitado()
	{
		controle.getHabilitado();
	}
	
}
