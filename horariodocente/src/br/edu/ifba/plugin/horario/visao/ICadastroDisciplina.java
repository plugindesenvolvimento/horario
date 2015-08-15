package br.edu.ifba.plugin.horario.visao;

import java.util.List;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Disciplina;

public interface ICadastroDisciplina {

	public Disciplina getDisciplina();

	public void setListaDisciplinas(List<Disciplina> disciplinas);

	public void notificarSucesso();

	public void notificarFalha();

}
