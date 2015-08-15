package br.edu.ifba.plugin.horario.enumeradores;

public enum GrupoCurricular {

	OBRIGATORIA("OBRIGAT�RIA"), OPTATIVA("OPTATIVA");

	private String nome;

	private GrupoCurricular(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}

	
}
