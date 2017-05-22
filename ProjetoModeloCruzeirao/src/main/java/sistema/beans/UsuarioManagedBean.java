package sistema.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.modelos.Campeonato;
import sistema.modelos.Usuario;
import sistema.service.UsuarioService;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import sistema.primefaces.util.AlertaUtil;


@ManagedBean
@SessionScoped
public class UsuarioManagedBean implements Serializable {
	
	private AlertaUtil msg = new AlertaUtil();
	private Usuario usuario = new Usuario();
	private Usuario usuarioRecuperarSenha = new Usuario();
	private Usuario usuarioEntrar = new Usuario();
	private Usuario usuarioAtual;
	private UsuarioService service = new UsuarioService();

	
	public String salvar()
	{
		usuario.setId(getId());
		service.salvar(usuario);
		usuario = new Usuario();
		return "login";
	}
	
	public int getId() {
		List<Usuario> lista = service.getUsuarios();

		Usuario u = new Usuario();
		if (!(lista.isEmpty())) {
			u = lista.get(lista.size() - 1);
			return u.getId() +1;
		}

		else
			return 1;
	}
	public String entrar()
	{
		
		usuario =service.entrar(usuarioEntrar);
	if(usuario.equals(null))
		return "login";
		else
		return "paginaInicial";
		
	}
	
	public String voltar()
	{
		return "login";
	}
	
	public String recuperarSenha()
	{
		usuario=service.recuperarSenha(usuarioRecuperarSenha);
		if(usuario.equals(null))
			return "login";
		else
			return "mostrarSenha";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Usuario> getUsuarios() {
		return service.getUsuarios();
	}
	public Usuario getUsuarioAtual() {
		return usuarioAtual;
	}
	public void setUsuarioAtual(Usuario usuarioAtual) {
		this.usuarioAtual = usuarioAtual;
	}

	public Usuario getUsuarioRecuperarSenha() {
		return usuarioRecuperarSenha;
	}

	public void setUsuarioRecuperarSenha(Usuario usuarioRecuperarSenha) {
		this.usuarioRecuperarSenha = usuarioRecuperarSenha;
	}

	public Usuario getUsuarioEntrar() {
		return usuarioEntrar;
	}

	public void setUsuarioEntrar(Usuario usuarioEntrar) {
		this.usuarioEntrar = usuarioEntrar;
	}
public void preRender(){
		
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		if ("true".equals(request.getParameter("error"))) {
			msg.exibirErroGrowl("Usuário ou senha inválidos");
		}
		
	}
	

}
