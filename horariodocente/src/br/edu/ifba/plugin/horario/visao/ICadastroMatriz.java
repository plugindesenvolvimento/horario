package br.edu.ifba.plugin.horario.visao;

import java.util.List;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Matriz;
import br.edu.ifba.plugin.horario.modelo.bd.beans.ModalidadeCurso;

public interface ICadastroMatriz {

	public Matriz getMatriz();
	
	public ModalidadeCurso getSelectedModalidade();

	public void setListaMatrizes(List<Matriz> matrizes);

	public void notificarSucesso();

	public void notificarFalha();

}
