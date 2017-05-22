package sistema.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

import sistema.modelos.Local;
import sistema.service.LocalService;


@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class LocalManagedBean implements Serializable{
	
	private int codigoLocal = 1;
	private Local local = new Local(codigoLocal);
	private Local localAtual;
	private LocalService service = new LocalService();
	
	public int getId() {
		List<Local> lista = service.getCategorias();

		Local l = new Local();
		if (!(lista.isEmpty())) {
			l = lista.get(lista.size() - 1);
			return l.getCodigo() + 1;
		}

		else
			return 1;
	}
	
	public void salvar() {
		
		codigoLocal = getId();
		local.setCodigo(codigoLocal);
		service.salvar(local);
		localAtual = local;
		
		local = new Local(codigoLocal);		
		
		RequestContext.getCurrentInstance().execute("PF('dlg').show();");
	}
	
	public void ir() {
		if(localAtual == null)
			no();
		else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Successful"));
		}
		localAtual = null;
   	}
	
	public void no() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Failed"));
		
		if(localAtual != null)
			removerLocal(localAtual); 
		localAtual = null;
	}
	
	public void removerLocal(Local local) {
		service.removerLocal(local);
	}

	public int getCodigoLocal() {
		return codigoLocal;
	}

	public void setCodigoLocal(int codigoLocal) {
		this.codigoLocal = codigoLocal;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Local getLocalAtual() {
		return localAtual;
	}

	public void setLocalAtual(Local localAtual) {
		this.localAtual = localAtual;
	}

	public LocalService getService() {
		return service;
	}

	public void setService(LocalService service) {
		this.service = service;
	}	
}