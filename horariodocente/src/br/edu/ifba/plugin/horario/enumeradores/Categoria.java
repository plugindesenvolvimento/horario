package br.edu.ifba.plugin.horario.enumeradores;

public enum Categoria {

	SEMESTRAL("SEMESTRAL"), ANUAL("ANUAL");

	private String nome;

	private Categoria(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}

	
}
