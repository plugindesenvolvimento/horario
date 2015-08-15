package br.edu.ifba.plugin.horario.controle;

import br.edu.ifba.plugin.horario.modelo.bd.dao.PeriodoLetivoDAO;
import br.edu.ifba.plugin.horario.visao.ICadastroPeriodoLetivo;

public class ControlePeriodoLetivo {

	private PeriodoLetivoDAO dao;

	public ControlePeriodoLetivo(ICadastroPeriodoLetivo periodoletivo) {
		dao = new PeriodoLetivoDAO(periodoletivo);
	}

	public void listar() {
		dao.listar();
	}

	public void gravar() {
		dao.gravar();
		dao.listar();
	}

	public void excluir() {
		dao.excluir();
		dao.listar();
	}

}
