package br.edu.ifba.plugin.horario.controle;

import br.edu.ifba.plugin.horario.modelo.bd.dao.ModalidadeCursoDAO;
import br.edu.ifba.plugin.horario.visao.ICadastroModalidadeCurso;

public class ControleModalidadeCurso {

	private ModalidadeCursoDAO dao;

	public ControleModalidadeCurso(ICadastroModalidadeCurso modalidadeCurso) {
		dao = new ModalidadeCursoDAO(modalidadeCurso);
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
