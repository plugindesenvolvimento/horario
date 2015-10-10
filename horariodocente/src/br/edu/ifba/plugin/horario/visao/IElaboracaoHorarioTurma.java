package br.edu.ifba.plugin.horario.visao;

import java.util.List;

import br.edu.ifba.plugin.horario.enumeradores.DiaSemana;
import br.edu.ifba.plugin.horario.enumeradores.Horario;
import br.edu.ifba.plugin.horario.enumeradores.Turno;
import br.edu.ifba.plugin.horario.modelo.bd.beans.Curso;
import br.edu.ifba.plugin.horario.modelo.bd.beans.Disciplina;
import br.edu.ifba.plugin.horario.modelo.bd.beans.DisciplinasHorario;
import br.edu.ifba.plugin.horario.modelo.bd.beans.HorarioDetalhe;
import br.edu.ifba.plugin.horario.modelo.bd.beans.HorarioTurma;
import br.edu.ifba.plugin.horario.modelo.bd.beans.PeriodoLetivo;
import br.edu.ifba.plugin.horario.modelo.bd.beans.Pessoa;
import br.edu.ifba.plugin.horario.modelo.bd.beans.Sala;
import br.edu.ifba.plugin.horario.modelo.bd.beans.Servidor;

public interface IElaboracaoHorarioTurma {

	public HorarioTurma getHorarioTurma();

	public PeriodoLetivo getPeriodoLetivo();

	public Curso getCurso();

	public Turno getTurno();

	public Integer getPeriodo();

	public void setListaHorariosTurmas(List<HorarioTurma> horariosTurmas);

	///////////////////////////////////////////////////////////////////////////////////////

	public DisciplinasHorario getDisciplinasHorario();

	public Disciplina getDisciplina();

	public Servidor getServidor();
	
	public Pessoa getPessoa();

	public Sala getSala();

	public void setListaDisciplinasHorarios(
			List<DisciplinasHorario> disciplinasHorarios);

	public void setListaSalas(List<Sala> salas);

	public void setListaServidores(List<Servidor> servidores);

	///////////////////////////////////////////////////////////////////////////////////////

	public HorarioDetalhe getHorarioDetalhe();

	public void setListaHorariosDetalhes(List<HorarioDetalhe> horariosDetalhes);
	
	public Horario getHorario();
	
	public DiaSemana getDiaSemana();
	
	///////////////////////////////////////////////////////////////////////////////////////

	public void notificarSucesso();

	public void notificarFalha();

}
