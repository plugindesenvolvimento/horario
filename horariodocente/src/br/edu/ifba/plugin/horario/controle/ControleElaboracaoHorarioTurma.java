package br.edu.ifba.plugin.horario.controle;

import br.edu.ifba.plugin.horario.modelo.bd.dao.ElaboracaoHorarioTurmaDAO;
import br.edu.ifba.plugin.horario.visao.IElaboracaoHorarioTurma;

public class ControleElaboracaoHorarioTurma {

	private ElaboracaoHorarioTurmaDAO dao;

	public ControleElaboracaoHorarioTurma(IElaboracaoHorarioTurma horarioTurma) {
		dao = new ElaboracaoHorarioTurmaDAO(horarioTurma);
	}
	
	public void listar()
	{
		dao.listar();
	}

	public void gravar()
	{
		dao.gravar();
		dao.listar();
	}
	
	public void excluir()
	{
		dao.excluir();
		dao.listar();
	}
	
	/*public List<Horarios> getQuadroHorarios(HorarioTurma horario){
		HorarioDetalhe segunda, terca, quarta,quinta, sexta,sabado;
		List<HorarioDetalhe> listaHorarioDetalhe = new ArrayList<HorarioDetalhe>();
		List<HorarioDetalhe> filtroListaHorarioDetalhe = new ArrayList<HorarioDetalhe>();
		//carregar do banco todos os horariosDetalhe desse Horario
		List<Horarios> listaHorarios = new ArrayList<Horarios>();
		Horarios horarios;
		
		//buscar na lista todos as tuplas de horario 1 (7:30H)
		
		for (HorarioDetalhe h:listaHorarioDetalhe)
			if (h.getIdhorario().equals(Horario.PRIMEIRO_HORARIO_M))
				filtroListaHorarioDetalhe.add(h);
		
		for (HorarioDetalhe filtro:filtroListaHorarioDetalhe){
			  if (filtro.getIddiasemana().equals(DiaSemana.SEGUNDA))
					segunda= filtro;
				else if (filtro.getIddiasemana().equals(DiaSemana.TERÇA))
					terca= filtro;
				
				//...continua até sabado
				
				
				
			}
		//horarios=new Horarios(Horario.PRIMEIRO_HORARIO_M, segunda,terca,quarta,quinta,sexta,sabado);
		//listaHorarios.add(horarios);
		
		return listaHorarios;
	}*/
}
