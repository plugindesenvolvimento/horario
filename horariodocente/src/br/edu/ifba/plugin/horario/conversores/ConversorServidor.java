package br.edu.ifba.plugin.horario.conversores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Servidor;
import br.edu.ifba.plugin.horario.modelo.bd.dao.ServidorDAO;

@FacesConverter("conversorServidor")
public class ConversorServidor implements Converter{

	@Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Servidor servidor = null;
    	
    	if(value != null && value.trim().length() > 0) {
            try {
            	ServidorDAO dao = new ServidorDAO(null);
                int id = Integer.parseInt(value);
                for (Servidor a : dao.getServidores()) {
                	if (a.getId() == id) {
                		servidor = a;
                		
                		break;
                	}
                }
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }

        return servidor;
    }
 
	@Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Servidor) object).getId());
        }
        else {
            return null;
        }
    }   
	
}
