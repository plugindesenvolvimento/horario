package br.edu.ifba.plugin.horario.enumeradores;

public enum Categoria {

	SEMESTRAL(0,"SEMESTRAL"), ANUAL(1,"ANUAL");

	private String nome;
	private Integer id;
	
	private Categoria(Integer id, String nome) {
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
