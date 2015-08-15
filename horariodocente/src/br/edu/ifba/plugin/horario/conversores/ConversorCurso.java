package br.edu.ifba.plugin.horario.conversores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Curso;
import br.edu.ifba.plugin.horario.modelo.bd.dao.CursoDAO;

@FacesConverter("conversorCurso")
public class ConversorCurso implements Converter{

	@Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Curso curso = null;
    	
    	if(value != null && value.trim().length() > 0) {
            try {
            	CursoDAO dao = new CursoDAO(null);
                int id = Integer.parseInt(value);
                for (Curso c : dao.getCursos()) {
                	if (c.getId() == id) {
                		curso = c;
                		
                		break;
                	}
                }
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }

        return curso;
    }
 
	@Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Curso) object).getId());
        }
        else {
            return null;
        }
    }   
	
}
