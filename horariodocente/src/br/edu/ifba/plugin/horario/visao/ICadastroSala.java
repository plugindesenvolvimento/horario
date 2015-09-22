package br.edu.ifba.plugin.horario.visao;

import java.util.List;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Sala;

public interface ICadastroSala {

	public Sala getSala();

	public void setListaSalas(List<Sala> salas);

	public void notificarSucesso();

	public void notificarFalha();
	
}
