package util;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifba.plugin.horario.enumeradores.Horario;
import br.edu.ifba.plugin.horario.modelo.bd.beans.HorarioDetalhe;

@ManagedBean(name = "horarios")
@ViewScoped
public class Horarios {

	Horario horario;
	HorarioDetalhe segunda, terca, quarta, quinta, sexta, sabado;

	public Horarios() {

	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public HorarioDetalhe getSegunda() {
		return segunda;
	}

	public void setSegunda(HorarioDetalhe segunda) {
		this.segunda = segunda;
	}

	public HorarioDetalhe getTerca() {
		return terca;
	}

	public void setTerca(HorarioDetalhe terca) {
		this.terca = terca;
	}

	public HorarioDetalhe getQuarta() {
		return quarta;
	}

	public void setQuarta(HorarioDetalhe quarta) {
		this.quarta = quarta;
	}

	public HorarioDetalhe getQuinta() {
		return quinta;
	}

	public void setQuinta(HorarioDetalhe quinta) {
		this.quinta = quinta;
	}

	public HorarioDetalhe getSexta() {
		return sexta;
	}

	public void setSexta(HorarioDetalhe sexta) {
		this.sexta = sexta;
	}

	public HorarioDetalhe getSabado() {
		return sabado;
	}

	public void setSabado(HorarioDetalhe sabado) {
		this.sabado = sabado;
	}

}
