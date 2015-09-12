package br.edu.ifba.plugin.horario.enumeradores;

public enum Turno {

	DIURNO (0,"DIURNO"), MATUTINO (1,"MATUTINO"), VESPERTINO(2,"VESPERTINO"), NOTURNO(3,"NOTURNO");

	private String nome;
	private Integer id;
	
	private Turno(Integer id, String nome) {
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
