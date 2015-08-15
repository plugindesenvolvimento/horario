package br.edu.ifba.plugin.horario.visao;

import java.util.List;

import br.edu.ifba.plugin.horario.modelo.bd.beans.PeriodoLetivo;

public interface ICadastroPeriodoLetivo {

	public PeriodoLetivo getPeriodoLetivo();

	public void setListaPeriodosLetivos(List<PeriodoLetivo> periodosletivos);

	public void notificarSucesso();

	public void notificarFalha();

}
