package br.edu.ifba.plugin.horario.controle;

import br.edu.ifba.plugin.horario.modelo.bd.dao.AreaDAO;
import br.edu.ifba.plugin.horario.visao.ICadastroArea;

public class ControleArea {

	private AreaDAO dao;

	public ControleArea(ICadastroArea area) {
		dao = new AreaDAO(area);
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
