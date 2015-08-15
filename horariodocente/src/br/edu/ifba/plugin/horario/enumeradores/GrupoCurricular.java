package br.edu.ifba.plugin.horario.enumeradores;

public enum GrupoCurricular {

	OBRIGATORIA(0,"OBRIGATÓRIA"), OPTATIVA(1,"OPTATIVA");

	private String nome;
	private Integer id;
	
	private GrupoCurricular(Integer id, String nome) {
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
