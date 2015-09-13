package br.edu.ifba.plugin.horario.visao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifba.plugin.horario.controle.ControleDisciplinasMatriz;
import br.edu.ifba.plugin.horario.enumeradores.GrupoCurricular;
import br.edu.ifba.plugin.horario.modelo.bd.beans.Disciplina;
import br.edu.ifba.plugin.horario.modelo.bd.beans.DisciplinasMatriz;
import br.edu.ifba.plugin.horario.visao.ICadastroDisciplinasMatriz;

@ManagedBean(name = "cadastroDisciplinasMatriz", eager = true)
@ViewScoped
public class CadastroDisciplinasMatriz implements ICadastroDisciplinasMatriz {

	private DisciplinasMatriz disciplinasMatriz;

	private List<DisciplinasMatriz> disciplinasMatrizes = new ArrayList<DisciplinasMatriz>();
	private GrupoCurricular grupoCurricular;
	//public GrupoCurricular listaGrupoCurricular;
	private Disciplina disciplina = new Disciplina();
	private Integer periodo;
	private List<DisciplinasMatriz> listaDisciplinasMatriz = new ArrayList<DisciplinasMatriz>();

	private ControleDisciplinasMatriz controle;

	// @PostConstruct
	// public void init() {
	// disciplinasMatriz = new DisciplinasMatriz();
	// }

	public CadastroDisciplinasMatriz() {
		controle = new ControleDisciplinasMatriz(this);
		this.disciplinasMatriz = new DisciplinasMatriz();
	}

	// public void prepararAdicao() {
	// System.out.println("PREPARANDO ADI��O");
	// this.disciplinasMatriz = new DisciplinasMatriz();
	// }

	@Override
	public DisciplinasMatriz getDisciplinasMatriz() {
		return disciplinasMatriz;
	}

	@Override
	public void setListaDisciplinasMatrizes(
			List<DisciplinasMatriz> disciplinasMatrizes) {
		this.disciplinasMatrizes = disciplinasMatrizes;
	}

	/*
	 * @Override public void notificarSucesso() {
	 * 
	 * }
	 * 
	 * @Override public void notificarFalha() {
	 * 
	 * }
	 */

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

		// this.disciplinasMatriz = new DisciplinasMatriz();

		System.out.println(disciplinasMatriz.getIddisciplina());
		
		controle.gravar();
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
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
}
