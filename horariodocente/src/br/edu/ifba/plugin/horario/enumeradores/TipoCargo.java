package br.edu.ifba.plugin.horario.enumeradores;

public enum TipoCargo {

	PROFESSOR(0,"PROFESSOR"), TECNICO(1,"TÉCNICO");

	private String nome;
	private Integer id;

	private TipoCargo(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
