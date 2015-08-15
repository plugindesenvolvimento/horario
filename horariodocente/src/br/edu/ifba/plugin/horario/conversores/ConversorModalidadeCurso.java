package br.edu.ifba.plugin.horario.conversores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.edu.ifba.plugin.horario.modelo.bd.beans.ModalidadeCurso;
import br.edu.ifba.plugin.horario.modelo.bd.dao.ModalidadeCursoDAO;

@FacesConverter("conversorModalidadeCurso")
public class ConversorModalidadeCurso implements Converter {

	@Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        ModalidadeCurso modalidadeCurso = null;
    	
    	if(value != null && value.trim().length() > 0) {
            try {
            	ModalidadeCursoDAO dao = new ModalidadeCursoDAO(null);
                int id = Integer.parseInt(value);
                for (ModalidadeCurso m : dao.getModalidades()) {
                	if (m.getId() == id) {
                		modalidadeCurso = m;
                		
                		break;
                	}
                }
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }

        return modalidadeCurso;
    }
 
	@Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((ModalidadeCurso) object).getId());
        }
        else {
            return null;
        }
    }
	
}
