package br.edu.ifba.plugin.horario.enumeradores;

public enum TipoCargo {

	PROFESSOR("PROFESSOR"), TECNICO("T�CNICO");

	private String nome;

	private TipoCargo(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}

	
}
