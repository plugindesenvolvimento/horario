package br.edu.ifba.plugin.horario.enumeradores;


public enum RegimeLetivo {
	
	SEMESTRAL(0,"SEMESTRAL"), ANUAL(1,"ANUAL");

	private String nome;
	private Integer id;
	
	private RegimeLetivo(Integer id, String nome) {
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
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}

