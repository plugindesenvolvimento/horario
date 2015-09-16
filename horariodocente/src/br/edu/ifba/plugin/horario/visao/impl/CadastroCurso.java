package br.edu.ifba.plugin.horario.visao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifba.plugin.horario.controle.ControleCurso;
import br.edu.ifba.plugin.horario.modelo.bd.beans.Curso;
import br.edu.ifba.plugin.horario.modelo.bd.beans.ModalidadeCurso;
import br.edu.ifba.plugin.horario.modelo.bd.dao.ModalidadeCursoDAO;
import br.edu.ifba.plugin.horario.visao.ICadastroCurso;

@ManagedBean(name = "cadastroCurso")
@ViewScoped
public class CadastroCurso implements ICadastroCurso {

	private List<Curso> cursos = new ArrayList<Curso>();
	private Curso curso;
	private List<ModalidadeCurso> modalidades = new ArrayList<ModalidadeCurso>();
	private ModalidadeCurso modalidade;
	private ModalidadeCursoDAO listaModalidades = new ModalidadeCursoDAO(null);
	
	boolean edicao = false;

	private ControleCurso controle;
	
	public CadastroCurso() {
		controle = new ControleCurso(this);
	}
	
	@Override
	public Curso getCurso() {

		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	@Override
	public void setListaCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	@Override
	public void notificarSucesso() {
		System.out.println("Operação Realizada com Sucesso!");
	}

	@Override
	public void notificarFalha() {
		System.out.println("Falhou!");
	}

	public void listarCursos() {
		controle.listar();
	}

	public void prepararAdicao() {
		this.curso = new Curso();

		edicao = true;
	}

	public void prepararEdicao(Curso curso) {
		this.curso = curso;
		edicao = true;
	}

	public boolean exibirEditor() {
		return edicao;
	}

	public void gravarCurso() {
		controle.gravar();
	}

	public void cancelarEdicao() {

		edicao = false;
	}

	public void excluirCurso() {
		controle.excluir();
	}

	public List<ModalidadeCurso> getModalidades() {
		return modalidades;
	}

	public void setModalidades(List<ModalidadeCurso> modalidades) {
		this.modalidades = modalidades;
	}

	@Override
	public ModalidadeCurso getModalidade() {
		return modalidade;
	}

	public void setModalidade(ModalidadeCurso modalidade) {
		this.modalidade = modalidade;
	}
	
	public List<ModalidadeCurso> getListaModalidadeCurso(){
		return listaModalidades.getModalidades();
	}
	
}
