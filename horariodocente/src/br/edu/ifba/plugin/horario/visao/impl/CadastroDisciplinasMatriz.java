package br.edu.ifba.plugin.horario.visao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.ifba.plugin.horario.controle.ControleDisciplinasMatriz;
import br.edu.ifba.plugin.horario.enumeradores.GrupoCurricular;
import br.edu.ifba.plugin.horario.modelo.bd.beans.Disciplina;
import br.edu.ifba.plugin.horario.modelo.bd.beans.DisciplinasMatriz;
import br.edu.ifba.plugin.horario.modelo.bd.beans.Matriz;
import br.edu.ifba.plugin.horario.visao.ICadastroDisciplinasMatriz;

@ManagedBean(name = "cadastroDisciplinasMatriz", eager = true)
@SessionScoped
public class CadastroDisciplinasMatriz implements ICadastroDisciplinasMatriz {

	private DisciplinasMatriz disciplinasMatriz;

	private List<DisciplinasMatriz> disciplinasMatrizes = new ArrayList<DisciplinasMatriz>();
	private GrupoCurricular grupoCurricular;
	private Disciplina disciplina = new Disciplina();
	private List<DisciplinasMatriz> listaDisciplinasMatriz = new ArrayList<DisciplinasMatriz>();
	private Matriz matriz;
	private ControleDisciplinasMatriz controle;
	private Integer periodo;

	public CadastroDisciplinasMatriz() {
		controle = new ControleDisciplinasMatriz(this);
	}

	@Override
	public DisciplinasMatriz getDisciplinasMatriz() {
		return disciplinasMatriz;
	}

	@Override
	public void setListaDisciplinasMatrizes(
			List<DisciplinasMatriz> disciplinasMatrizes) {
		this.disciplinasMatrizes = disciplinasMatrizes;
	}

	@Override
	public void notificarSucesso() {
		System.out.println("Operação Realizada com Sucesso!");
	}

	@Override
	public void notificarFalha() {
		System.out.println("Falhou!");
	}

	public List<DisciplinasMatriz> getDisciplinasMatrizes() {
		return disciplinasMatrizes;
	}

	public void setDisciplinasMatrizes(
			List<DisciplinasMatriz> disciplinasMatrizes) {
		this.disciplinasMatrizes = disciplinasMatrizes;
	}

	public void setDisciplinasMatriz(DisciplinasMatriz disciplinasMatriz) {
		this.disciplinasMatriz = disciplinasMatriz;
	}

	public List<Disciplina> completarDisciplina(String nome) {
		return controle.completarDisciplina(nome);
	}

	public void gravarDisciplinasMatriz() {
		this.disciplinasMatriz = new DisciplinasMatriz();
		controle.gravar();
	}

	@Override
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<DisciplinasMatriz> getListaDisciplinasMatriz() {
		return listaDisciplinasMatriz;
	}

	public void setListaDisciplinasMatriz(
			List<DisciplinasMatriz> listaDisciplinasMatriz) {
		this.listaDisciplinasMatriz = listaDisciplinasMatriz;
	}

	@Override
	public GrupoCurricular getGrupoCurricular() {
		return grupoCurricular;
	}

	public void setGrupoCurricular(GrupoCurricular grupoCurricular) {
		this.grupoCurricular = grupoCurricular;
	}

	public GrupoCurricular[] getListaGrupoCurricular() {
		return GrupoCurricular.values();
	}

	@Override
	public Matriz getMatriz() {
		return matriz;
	}

	public void setMatriz(Matriz matriz) {
		this.matriz = matriz;
	}

	public void listarDisciplinasMatriz() {
		controle.listar();
	}

	public void excluirDisciplinaMatriz() {
		controle.excluir();
	}

	@Override
	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}
}
