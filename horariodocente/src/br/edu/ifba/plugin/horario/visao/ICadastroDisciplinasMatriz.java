package br.edu.ifba.plugin.horario.visao;

import java.util.List;

import br.edu.ifba.plugin.horario.enumeradores.GrupoCurricular;
import br.edu.ifba.plugin.horario.modelo.bd.beans.DisciplinasMatriz;

public interface ICadastroDisciplinasMatriz {

	public DisciplinasMatriz getDisciplinasMatriz();
	
	public GrupoCurricular getGrupoCurricular();

	public void setListaDisciplinasMatrizes(List<DisciplinasMatriz> disciplinasMatrizes);

	//public void notificarSucesso();

	//public void notificarFalha();

}
