package br.edu.ifba.plugin.horario.conversores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Disciplina;
import br.edu.ifba.plugin.horario.modelo.bd.dao.DisciplinaDAO;

@FacesConverter("conversorDisciplina")
public class ConversorDisciplina implements Converter {

	@Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		Disciplina disciplina = null;
    	
    	if(value != null && value.trim().length() > 0) {
            try {
            	DisciplinaDAO dao = new DisciplinaDAO(null);
                int id = Integer.parseInt(value);
                for (Disciplina a : dao.getDisciplinas()) {
                	if (a.getId() == id) {
                		disciplina = a;
                		
                		break;
                	}
                }
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }

        return disciplina;
    }
 
	@Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Disciplina) object).getId());
        }
        else {
            return null;
        }
    }   
}