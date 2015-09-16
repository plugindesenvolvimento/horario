package br.edu.ifba.plugin.horario.controle;

import br.edu.ifba.plugin.horario.modelo.bd.dao.MatrizDAO;
import br.edu.ifba.plugin.horario.visao.ICadastroMatriz;

public class ControleMatriz {

	private MatrizDAO dao;

	public ControleMatriz(ICadastroMatriz matriz) {
		dao = new MatrizDAO(matriz);
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
