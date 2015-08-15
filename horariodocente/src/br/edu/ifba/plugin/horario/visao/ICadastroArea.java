package br.edu.ifba.plugin.horario.visao;

import java.util.List;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Area;

public interface ICadastroArea {

	public Area getArea();

	public void setListaAreas(List<Area> areas);

	public void notificarSucesso();

	public void notificarFalha();

}
