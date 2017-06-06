package sistema.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.modelos.Inscricao;
import sistema.modelos.Inscrito;
import sistema.modelos.Usuario;
import sistema.service.InscricaoService;
import sistema.service.InscritoService;
import sistema.service.UsuarioService;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class InscritoManagedBean implements Serializable{
	

	private Inscrito inscrito= new Inscrito();
	private InscritoService service = new InscritoService();
	private Inscrito inscritoAtual;
	private UsuarioService uService=new UsuarioService();
	
	public Inscrito salvarInscrito(Usuario usuario, Inscricao inscricao){
		
		inscrito.setUsuario(usuario);
		
		//inscrito.setInscricao(inscricao);
		inscrito.setNomeUser(usuario.getUsername());
		service.salvar(inscrito);
		usuario.setIncricoes(inscrito);	
		uService.alterarUsuario(usuario);		
		inscritoAtual=inscrito;
		inscrito=new Inscrito();
		
		return inscritoAtual;
				
		
	}
	
	public void setInscricao(Inscrito inscrito, Inscricao inscricao){
		inscrito.setInscricao(inscricao);
		service.alterarInscrito(inscrito);		
		
	}


	public Inscrito getInscritoAtual() {
		return inscritoAtual;
	}

	public void setInscritoAtual(Inscrito inscritoAtual) {
		this.inscritoAtual = inscritoAtual;
	}
	public Inscrito getInscrito() {
		return inscrito;
	}

	public void setInscrito(Inscrito inscrito) {
		this.inscrito = inscrito;
	}

	public InscritoService getService() {
		return service;
	}

	public void setService(InscritoService service) {
		this.service = service;
	}
}