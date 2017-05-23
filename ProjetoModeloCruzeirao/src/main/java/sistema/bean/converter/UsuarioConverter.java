package sistema.bean.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


import sistema.modelos.Equipe;

import sistema.service.EquipeService;

@FacesConverter("usuarioConverter")
public class UsuarioConverter implements Converter{

	EquipeService service = new EquipeService();

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

		if (value != null && !value.isEmpty()) {
			for (Equipe e : service.getEquipes())
				if (e.getNome().equals(value))
					return e;
		}

		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object equipe) {

		if (equipe == null || equipe.equals(""))
			return null;

		else
			return ((Equipe) equipe).getNome();
	}
}
