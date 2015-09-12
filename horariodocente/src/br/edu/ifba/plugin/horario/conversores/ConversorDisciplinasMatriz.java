package br.edu.ifba.plugin.horario.conversores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.edu.ifba.plugin.horario.modelo.bd.beans.DisciplinasMatriz;
import br.edu.ifba.plugin.horario.modelo.bd.dao.DisciplinasMatrizDAO;

@FacesConverter("conversorDisciplinasMatriz")
public class ConversorDisciplinasMatriz implements Converter {

	@Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		DisciplinasMatriz disciplinasMatriz = null;
    	
    	if(value != null && value.trim().length() > 0) {
            try {
            	DisciplinasMatrizDAO dao = new DisciplinasMatrizDAO(null);
                int id = Integer.parseInt(value);
                for (DisciplinasMatriz a : dao.getDisciplinasMatrizes()) {
                	if (a.getId() == id) {
                		disciplinasMatriz = a;
                		
                		break;
                	}
                }
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }

        return disciplinasMatriz;
    }
 
	@Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((DisciplinasMatriz) object).getId());
        }
        else {
            return null;
        }
    }   
}