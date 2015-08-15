package br.edu.ifba.plugin.horario.visao;

import java.util.List;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Atividade;

public interface ICadastroAtividade {

	public Atividade getAtividade();
	
	public void setListaAtividades(List<Atividade> atividades);
	
	public void notificarSucesso();
	
	public void notificarFalha();
	
}
