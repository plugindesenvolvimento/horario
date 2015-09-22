package br.edu.ifba.plugin.horario.conversores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Sala;
import br.edu.ifba.plugin.horario.modelo.bd.dao.SalaDAO;

@FacesConverter("conversorSala")
public class ConversorSala implements Converter{

	@Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Sala sala = null;
    	
    	if(value != null && value.trim().length() > 0) {
            try {
            	SalaDAO dao = new SalaDAO(null);
                int id = Integer.parseInt(value);
                for (Sala a : dao.getSalas()) {
                	if (a.getId() == id) {
                		sala = a;
                		
                		break;
                	}
                }
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }

        return sala;
    }
 
	@Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Sala) object).getId());
        }
        else {
            return null;
        }
    }   
	
}
