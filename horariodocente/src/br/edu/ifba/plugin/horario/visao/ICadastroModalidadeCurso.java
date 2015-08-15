package br.edu.ifba.plugin.horario.visao;

import java.util.List;

import br.edu.ifba.plugin.horario.enumeradores.RegimeLetivo;
import br.edu.ifba.plugin.horario.modelo.bd.beans.ModalidadeCurso;

public interface ICadastroModalidadeCurso {

	public ModalidadeCurso getModalidadeCurso();

	public RegimeLetivo getRegimeLetivo();
	
	public void setListaModalidadesCurso(List<ModalidadeCurso> modalidadesCurso);

	public void notificarSucesso();

	public void notificarFalha();


}
