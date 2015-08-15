package br.edu.ifba.plugin.horario.enumeradores;

public enum Turno {

	DIURNO ("DIURNO"), MATUTINO ("MATUTINO"), VESPERTINO("VESPERTINO"), NOTURNO("NOTURNO");

	private String nome;

	private Turno(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}

}
