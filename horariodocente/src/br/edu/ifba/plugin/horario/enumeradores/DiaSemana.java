package br.edu.ifba.plugin.horario.enumeradores;



public enum DiaSemana{

    SEGUNDA("SEGUNDA"),
	TERÇA("TERÇA"),
	QUARTA("QUARTA"),
	QUINTA("QUINTA"),
	SEXTA("SEXTA"),
	SABADO("SABADO");
    
	private String dia;	
    
    private DiaSemana(String dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return dia;
    }
    
}
