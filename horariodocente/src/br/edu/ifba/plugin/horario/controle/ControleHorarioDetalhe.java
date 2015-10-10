package br.edu.ifba.plugin.horario.controle;

import br.edu.ifba.plugin.horario.modelo.bd.dao.HorarioDetalheDAO;
import br.edu.ifba.plugin.horario.visao.IElaboracaoHorarioTurma;

public class ControleHorarioDetalhe {

	private HorarioDetalheDAO dao;

	public ControleHorarioDetalhe(IElaboracaoHorarioTurma horarioDetalhe) {
		dao = new HorarioDetalheDAO(horarioDetalhe);
	}

	public void listar() {
		dao.listar();
	}

	public void gravar() {
		dao.gravar();
		dao.listar();
	}
	
}
