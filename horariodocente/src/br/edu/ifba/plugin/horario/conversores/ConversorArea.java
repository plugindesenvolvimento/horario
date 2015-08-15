package br.edu.ifba.plugin.horario.conversores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Area;
import br.edu.ifba.plugin.horario.modelo.bd.dao.AreaDAO;

@FacesConverter("conversorArea")
public class ConversorArea implements Converter {

	@Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Area area = null;
    	
    	if(value != null && value.trim().length() > 0) {
            try {
            	AreaDAO dao = new AreaDAO(null);
                int id = Integer.parseInt(value);
                for (Area a : dao.getAreas()) {
                	if (a.getId() == id) {
                		area = a;
                		
                		break;
                	}
                }
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }

        return area;
    }
 
	@Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Area) object).getId());
        }
        else {
            return null;
        }
    }   
}