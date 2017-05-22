package sistema.dao;

import java.util.HashMap;
import java.util.Map;

import sistema.modelos.Usuario;



public class UsuarioDAO extends GenericoDAO<Usuario>  {

		
	protected Class<Usuario> getClasseEntidade() {
		return Usuario.class;
	}

	public Usuario pesquisarPorUserName(String userName) {
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("username", userName);

			return super.pesquisarUm(Usuario.PESQUISAR_POR_USERNAME, parametros);
	}
}
  
