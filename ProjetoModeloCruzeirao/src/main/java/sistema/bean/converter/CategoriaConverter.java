package sistema.bean.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


import sistema.modelos.Categoria;

import sistema.service.CategoriaService;

@FacesConverter("categoriaConverter")
public class CategoriaConverter implements Converter {

	CategoriaService service = new CategoriaService();

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

		if (value != null && !value.isEmpty()) {
			for (Categoria c : service.getCategorias())
				if (c.getNome().equals(value))
					return c;
		}

		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object categoria) {

		if (categoria == null || categoria.equals(""))
			return null;

		else
			return ((Categoria) categoria).getNome();
	}
}