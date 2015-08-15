package br.edu.ifba.plugin.horario.enumeradores;

public enum GrupoCurricular {

	OBRIGATORIA("OBRIGATÓRIA"), OPTATIVA("OPTATIVA");

	private String nome;

	private GrupoCurricular(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}

	
}
