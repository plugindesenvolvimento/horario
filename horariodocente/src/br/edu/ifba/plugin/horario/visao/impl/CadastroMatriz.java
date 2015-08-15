package br.edu.ifba.plugin.horario.visao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.ifba.plugin.horario.controle.ControleMatriz;
import br.edu.ifba.plugin.horario.enumeradores.GrupoCurricular;
import br.edu.ifba.plugin.horario.modelo.bd.beans.Curso;
import br.edu.ifba.plugin.horario.modelo.bd.beans.Matriz;
import br.edu.ifba.plugin.horario.modelo.bd.beans.ModalidadeCurso;
import br.edu.ifba.plugin.horario.modelo.bd.dao.CursoDAO;
import br.edu.ifba.plugin.horario.modelo.bd.dao.ModalidadeCursoDAO;
import br.edu.ifba.plugin.horario.visao.ICadastroMatriz;

@ManagedBean(name = "cadastroMatriz")
@SessionScoped
public class CadastroMatriz implements ICadastroMatriz {

	private List<Matriz> matrizes = new ArrayList<Matriz>();
	private Matriz matriz;
	private ModalidadeCursoDAO listaModalidades = new ModalidadeCursoDAO(null);
	private CursoDAO listaCursoDAO = new CursoDAO(null);
	private ModalidadeCurso modalidade;
	private List<Curso> listaCursos = new ArrayList<Curso>(); 
	//private ControleCurso controleCurso = new ControleCurso(null);
	private GrupoCurricular grupoCurricular;
	public GrupoCurricular listaGrupoCurricular;

	
	
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
	
	public List<Curso> getListaCursos() {
		return listaCursos;
	}

	public void setListaCursos(List<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}

	public void atualizarCursos(){
		listaCursos = listaCursoDAO.getByModalidade(modalidade.getId());
	}
	
	public ModalidadeCursoDAO getListaModalidades() {
		return listaModalidades;
	}

	public void setListaModalidades(ModalidadeCursoDAO listaModalidades) {
		this.listaModalidades = listaModalidades;
	}
		
	
	public GrupoCurricular getGrupoCurricular() {
		return grupoCurricular;
	}

	public void setGrupoCurricular(GrupoCurricular grupoCurricular) {
		this.grupoCurricular = grupoCurricular;
	}
	
	public GrupoCurricular[] getListaGrupoCurricular()
	{
		return GrupoCurricular.values();
	}
	
}
