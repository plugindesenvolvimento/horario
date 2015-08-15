package br.edu.ifba.plugin.horario.visao;

import java.util.List;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Matriz;

public interface ICadastroMatriz {

	public Matriz getMatriz();

	public void setListaMatrizes(List<Matriz> matrizes);

	public void notificarSucesso();

	public void notificarFalha();

}
