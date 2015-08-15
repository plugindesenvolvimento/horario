package br.edu.ifba.plugin.horario.enumeradores;

public enum Horario {

	    //Turno Matutino
	    PRIMEIRO_HORARIO_M("07:10-08:00", Turno.MATUTINO),
	    SEGUNDOO_HORARIO_M("08:00-08:50", Turno.MATUTINO),
	    TERCEIRO_HORARIO_M("08:50-09:40", Turno.MATUTINO),
		QUARTO_HORARIO_M("09:40-10:30", Turno.MATUTINO),
		INTERVALO_M("10:30-10:50", Turno.MATUTINO),
		QUINTO_HORARIO_M("10:50-11:40", Turno.MATUTINO),
	    SEXTO_HORARIO_M("11:40-12:30", Turno.MATUTINO),
	    	    
	    //Turno Verspertino
	    PRIMEIRO_HORARIO_T("13:00-13:50", Turno.VESPERTINO),
	    SEGUNDOO_HORARIO_T("13:50-14:40", Turno.VESPERTINO),
	    TERCEIRO_HORARIO_T("14:40-15:30", Turno.VESPERTINO),
		QUARTO_HORARIO_T("15:30-16:20", Turno.VESPERTINO),
		INTERVALO_T("16:20-16:40", Turno.VESPERTINO),
		QUINTO_HORARIO_T("16:40-17:30", Turno.VESPERTINO),
	    SEXTO_HORARIO_T("17:30-18:20", Turno.VESPERTINO),
	    	    
	    //Turno Noturno
	    PRIMEIRO_HORARIO_N("18:30-19:20", Turno.NOTURNO),
	    SEGUNDOO_HORARIO_N("19:20-20:10", Turno.NOTURNO),
		INTERVALO_N("20:10-20:20", Turno.NOTURNO),
	    TERCEIRO_HORARIO_N("20:20-21:10", Turno.NOTURNO),
		QUARTO_HORARIO_N("21:10-22:00", Turno.NOTURNO);	
	    	    
	    private String horario;	
	    private Turno turno;
	   
	    private Horario(String horario, Turno turno) {
	        this.horario = horario;
	        this.turno = turno;
	    }

	    @Override
	    public String toString() {
	        return horario;
	    }

		public Turno getTurno() {
			return turno;
		}

		public void setTurno(Turno turno) {
			this.turno = turno;
		}
	
}
