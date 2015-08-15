package br.edu.ifba.plugin.horario.visao;

import java.util.List;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Curso;
import br.edu.ifba.plugin.horario.modelo.bd.beans.ModalidadeCurso;

public interface ICadastroCurso {

	public ModalidadeCurso getModalidade();
	
	public Curso getCurso();

	public void setListaCursos(List<Curso> cursos);

	public void notificarSucesso();

	public void notificarFalha();

}
