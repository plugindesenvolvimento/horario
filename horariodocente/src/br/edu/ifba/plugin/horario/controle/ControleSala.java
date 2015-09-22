package br.edu.ifba.plugin.horario.controle;

import br.edu.ifba.plugin.horario.modelo.bd.dao.DAO;
import br.edu.ifba.plugin.horario.modelo.bd.dao.SalaDAO;
import br.edu.ifba.plugin.horario.visao.ICadastroSala;

public class ControleSala extends DAO {

	private SalaDAO dao;

	public ControleSala(ICadastroSala sala) {
		dao = new SalaDAO(sala);
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
