package br.edu.ifba.plugin.horario.conversores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.edu.ifba.plugin.horario.modelo.bd.beans.PeriodoLetivo;
import br.edu.ifba.plugin.horario.modelo.bd.dao.PeriodoLetivoDAO;

@FacesConverter("conversorPeriodoLetivo")
public class ConversorPeriodoLetivo implements Converter{

	@Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        PeriodoLetivo periodoLetivo = null;
    	
    	if(value != null && value.trim().length() > 0) {
            try {
            	PeriodoLetivoDAO dao = new PeriodoLetivoDAO(null);
                int id = Integer.parseInt(value);
                for (PeriodoLetivo a : dao.getPeriodosLetivos()) {
                	if (a.getId() == id) {
                		periodoLetivo = a;
                		
                		break;
                	}
                }
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }

        return periodoLetivo;
    }
 
	@Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((PeriodoLetivo) object).getId());
        }
        else {
            return null;
        }
    }   
	
}
