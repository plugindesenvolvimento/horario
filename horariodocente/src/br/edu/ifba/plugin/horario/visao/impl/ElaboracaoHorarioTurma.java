package br.edu.ifba.plugin.horario.visao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifba.plugin.horario.controle.ControleElaboracaoHorarioTurma;
import br.edu.ifba.plugin.horario.enumeradores.Turno;
import br.edu.ifba.plugin.horario.modelo.bd.beans.Curso;
import br.edu.ifba.plugin.horario.modelo.bd.beans.HorarioTurma;
import br.edu.ifba.plugin.horario.modelo.bd.beans.PeriodoLetivo;
import br.edu.ifba.plugin.horario.modelo.bd.dao.CursoDAO;
import br.edu.ifba.plugin.horario.modelo.bd.dao.PeriodoLetivoDAO;
import br.edu.ifba.plugin.horario.visao.IElaboracaoHorarioTurma;

@ManagedBean(name = "elaboracaoHorarioTurma")
@ViewScoped
public class ElaboracaoHorarioTurma implements IElaboracaoHorarioTurma {

	private HorarioTurma horarioTurma;
	private List<HorarioTurma> horariosTurmas = new ArrayList<>();
	private PeriodoLetivo periodoLetivo;
	private Curso curso;
	private Turno turno;
	private Integer periodo;
	private ControleElaboracaoHorarioTurma controle;
	private PeriodoLetivoDAO listaPeriodosLetivos = new PeriodoLetivoDAO(null);
	private CursoDAO listaCursos = new CursoDAO(null);
	boolean edicao = false;

	public ElaboracaoHorarioTurma() {
		controle = new ControleElaboracaoHorarioTurma(this);
	}

	@Override
	public HorarioTurma getHorarioTurma() {
		return horarioTurma;
	}

	@Override
	public PeriodoLetivo getPeriodoLetivo() {
		return periodoLetivo;
	}

	@Override
	public Curso getCurso() {
		return curso;
	}

	@Override
	public Turno getTurno() {
		return turno;
	}

	@Override
	public Integer getPeriodo() {
		return periodo;
	}

	@Override
	public void setListaHorariosTurmas(List<HorarioTurma> horariosTurmas) {
		this.horariosTurmas = horariosTurmas;
	}

	@Override
	public void notificarSucesso() {
		System.out.println("Operação Realizada com Sucesso");
	}

	@Override
	public void notificarFalha() {
		System.out.println("Falhou!");
	}

	public List<HorarioTurma> getHorariosTurmas() {
		return horariosTurmas;
	}

	public void setHorariosTurmas(List<HorarioTurma> horariosTurmas) {
		this.horariosTurmas = horariosTurmas;
	}

	public void setHorarioTurma(HorarioTurma horarioTurma) {
		this.horarioTurma = horarioTurma;
	}

	public void setPeriodoLetivo(PeriodoLetivo periodoLetivo) {
		this.periodoLetivo = periodoLetivo;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Turno[] getListaTurno() {
		return Turno.values();
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public PeriodoLetivoDAO getListaPeriodosLetivos() {
		return listaPeriodosLetivos;
	}

	public void setListaPeriodosLetivos(PeriodoLetivoDAO listaPeriodosLetivos) {
		this.listaPeriodosLetivos = listaPeriodosLetivos;
	}

	public List<PeriodoLetivo> getListaPeriodoLetivo() {
		return listaPeriodosLetivos.getPeriodosLetivos();
	}

	public CursoDAO getListaCursos() {
		return listaCursos;
	}

	public void setListaCursos(CursoDAO listaCursos) {
		this.listaCursos = listaCursos;
	}

	public List<Curso> getListaCurso() {
		return listaCursos.getCursos();
	}

	public void gravarHorarioTurma() {
		this.horarioTurma = new HorarioTurma();
		controle.gravar();
	}
	
	public void editarHorarioTurma()
	{
		controle.editar();
	}

	public void excluirHorarioTurma() {
		controle.excluir();
	}

	public void listarHorariosTurmas() {
		controle.listar();
	}

	public void cancelarEdicao() {
		edicao = false;
	}
	
	public void prepararEdicao(HorarioTurma horarioTurma) {
		this.horarioTurma = horarioTurma;
		edicao = true;
	}
	
	public boolean exibirEditor() {
		return edicao;
	}
}
