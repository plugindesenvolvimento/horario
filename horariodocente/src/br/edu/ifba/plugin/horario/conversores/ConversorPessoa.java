package br.edu.ifba.plugin.horario.conversores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.edu.ifba.plugin.horario.modelo.bd.beans.Pessoa;
import br.edu.ifba.plugin.horario.modelo.bd.dao.PessoaDAO;

@FacesConverter("conversorPessoa")
public class ConversorPessoa implements Converter{

	@Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Pessoa pessoa = null;
    	
    	if(value != null && value.trim().length() > 0) {
            try {
            	PessoaDAO dao = new PessoaDAO(null);
                int id = Integer.parseInt(value);
                for (Pessoa a : dao.getPessoas()) {
                	if (a.getId() == id) {
                		pessoa = a;
                		
                		break;
                	}
                }
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }

        return pessoa;
    }
 
	@Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Pessoa) object).getId());
        }
        else {
            return null;
        }
    }   
	
}
