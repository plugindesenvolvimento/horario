package br.edu.ifba.plugin.horario.enumeradores;



public enum DiaSemana{

    SEGUNDA(0,"SEGUNDA"),
	TERÇA(1,"TERÇA"),
	QUARTA(2,"QUARTA"),
	QUINTA(3,"QUINTA"),
	SEXTA(4,"SEXTA"),
	SABADO(5,"SABADO");
    
	private String dia;
	private Integer id;
    
    private DiaSemana(Integer id, String dia) {
        this.id = id;
    	this.dia = dia;
    }

    @Override
    public String toString() {
        return dia;
    }

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
