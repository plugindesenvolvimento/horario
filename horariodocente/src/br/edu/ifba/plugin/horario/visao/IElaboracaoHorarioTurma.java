package br.edu.ifba.plugin.horario.visao;

import java.util.List;

import br.edu.ifba.plugin.horario.enumeradores.Turno;
import br.edu.ifba.plugin.horario.modelo.bd.beans.Curso;
import br.edu.ifba.plugin.horario.modelo.bd.beans.HorarioTurma;
import br.edu.ifba.plugin.horario.modelo.bd.beans.PeriodoLetivo;

public interface IElaboracaoHorarioTurma {

	public HorarioTurma getHorarioTurma();

	public PeriodoLetivo getPeriodoLetivo();

	public Curso getCurso();

	public Turno getTurno();

	public Integer getPeriodo();

	public void setListaHorariosTurmas(List<HorarioTurma> horariosTurmas);

	public void notificarSucesso();

	public void notificarFalha();

}
