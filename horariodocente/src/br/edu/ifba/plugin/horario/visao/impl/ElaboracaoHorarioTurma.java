package br.edu.ifba.plugin.horario.visao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifba.plugin.horario.controle.ControleDisciplinasHorario;
import br.edu.ifba.plugin.horario.controle.ControleElaboracaoHorarioTurma;
import br.edu.ifba.plugin.horario.enumeradores.Turno;
import br.edu.ifba.plugin.horario.modelo.bd.beans.Curso;
import br.edu.ifba.plugin.horario.modelo.bd.beans.Disciplina;
import br.edu.ifba.plugin.horario.modelo.bd.beans.DisciplinasHorario;
import br.edu.ifba.plugin.horario.modelo.bd.beans.HorarioTurma;
import br.edu.ifba.plugin.horario.modelo.bd.beans.PeriodoLetivo;
import br.edu.ifba.plugin.horario.modelo.bd.beans.Sala;
import br.edu.ifba.plugin.horario.modelo.bd.beans.Servidor;
import br.edu.ifba.plugin.horario.modelo.bd.dao.CursoDAO;
import br.edu.ifba.plugin.horario.modelo.bd.dao.DisciplinaDAO;
import br.edu.ifba.plugin.horario.modelo.bd.dao.PeriodoLetivoDAO;
import br.edu.ifba.plugin.horario.modelo.bd.dao.SalaDAO;
import br.edu.ifba.plugin.horario.modelo.bd.dao.ServidorDAO;
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

	private DisciplinasHorario disciplinasHorario;
	private List<DisciplinasHorario> disciplinasHorarios = new ArrayList<>();
	private Disciplina disciplina;
	private DisciplinaDAO listaDisciplinas = new DisciplinaDAO(null);
	private SalaDAO listaSalas = new SalaDAO(null);
	private Servidor servidor;
	private ServidorDAO listaServidores = new ServidorDAO(null);
	private Sala sala;
	private ControleDisciplinasHorario controleDisciplinasHorario;
	boolean edicaoDisciplinasHorario = false;

	public ElaboracaoHorarioTurma() {
		controle = new ControleElaboracaoHorarioTurma(this);
		controleDisciplinasHorario = new ControleDisciplinasHorario(this);
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

	public void editarHorarioTurma() {
		controle.gravar();
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

	// /////////////////////////////////////////////////////////////////////////////////

	@Override
	public DisciplinasHorario getDisciplinasHorario() {
		return disciplinasHorario;
	}

	public void setDisciplinasHorario(DisciplinasHorario disciplinasHorario) {
		this.disciplinasHorario = disciplinasHorario;
	}

	public List<DisciplinasHorario> getDisciplinasHorarios() {
		return disciplinasHorarios;
	}

	public void setDisciplinasHorarios(
			List<DisciplinasHorario> disciplinasHorarios) {
		this.disciplinasHorarios = disciplinasHorarios;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	@Override
	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	@Override
	public void setListaDisciplinasHorarios(
			List<DisciplinasHorario> disciplinasHorarios) {
		this.disciplinasHorarios = disciplinasHorarios;
	}

	public void listarDisciplinasHorarios() {
		controleDisciplinasHorario.listar();
	}

	public void prepararEdicaoDisciplinasHorario(
			DisciplinasHorario disciplinasHorario) {
		this.disciplinasHorario = disciplinasHorario;
		edicaoDisciplinasHorario = true;
	}

	public boolean exibirEditorDisciplinasHorario() {
		return edicaoDisciplinasHorario;
	}

	public void gravarDisciplinasHorario() {
		controleDisciplinasHorario.gravar();
	}

	public void prepararAdicaoDisciplinasHorario() {
		this.disciplinasHorario = new DisciplinasHorario();
		edicaoDisciplinasHorario = true;	
	}

	
	public void excluirDisciplinasHorario() {
		controleDisciplinasHorario.excluir();
	}

	public DisciplinaDAO getListaDisciplinas() {
		return listaDisciplinas;
	}

	public void setListaDisciplinas(DisciplinaDAO listaDisciplinas) {
		this.listaDisciplinas = listaDisciplinas;
	}

	public List<Disciplina> getListaDisciplina() {
		return listaDisciplinas.getDisciplinas();
	}

	public SalaDAO getListaSalas() {
		return listaSalas;
	}

	public void setListaSalas(SalaDAO listaSalas) {
		this.listaSalas = listaSalas;
	}

	@Override
	public void setListaSalas(List<Sala> salas) {
		this.listaSalas.getSalas();
	}
	
	public List<Sala> getListaSala() {
		return listaSalas.getSalas();
	}
	
	public ServidorDAO getListaServidores() {
		return listaServidores;
	}

	public void setListaServidores(ServidorDAO listaServidores) {
		this.listaServidores = listaServidores;
	}

	@Override
	public void setListaServidores(List<Servidor> servidores) {
		this.listaServidores.getServidores();		
	}
	
	public List<Servidor> getListaServidor() {
		return listaServidores.getServidores();
	}

}
