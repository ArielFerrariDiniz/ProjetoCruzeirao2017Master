package sistema.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.modelos.Campeonato;
import sistema.modelos.Equipe;
import sistema.modelos.Inscricao;
import sistema.modelos.Equipe;
import sistema.service.EquipeService;
import sistema.beans.InscricaoManagedBean;


@ManagedBean
@SessionScoped
public class EquipeManagedBean implements Serializable{
	
	private int codigoEquipe=1;
	private Equipe equipe = new Equipe();
	private EquipeService service = new EquipeService();
	private Equipe equipeAtual;
	
	public void salvar()
	{
		codigoEquipe=getId();
		equipe.setCodigoEquipe(codigoEquipe);
		service.salvar(equipe);
		equipe = new Equipe(codigoEquipe);	
	}
	
	
	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public List<Equipe> getEquipes() {
		return service.getEquipes();
	}
	
	public String descricaoEquipe(Equipe equipe)
	{
		this.equipeAtual = equipe;
		return "descricaoEquipe";
	}
	
	
	public String editarEquipe(Equipe equipe)
	{
		this.equipeAtual = equipe;
		return "editarEquipe";
	}
	public String voltar()
	{
		return "cadastroEquipe";
	}

	public EquipeService getService() {
		return service;
	}

	public void setService(EquipeService service) {
		this.service = service;
	}

	public Equipe getEquipeAtual() {
		return equipeAtual;
	}

	public void setEquipeAtual(Equipe equipeAtual) {
		this.equipeAtual = equipeAtual;
	}
	
	public void removerEquipe(Equipe equipe)
	{
		service.removerEquipe(equipe);
	}
	
	public int getId() {
		List<Equipe> lista = service.getEquipes();

		Equipe e = new Equipe();
		if (!(lista.isEmpty())) {
			e = lista.get(lista.size() - 1);
			return e.getCodigoEquipe() + 1;
		}

		else
			return 1;
	}
	
	public String salvarEditar() {
		service.alterarEquipe(equipeAtual);
		equipeAtual = null;
		return "cadastroEquipe";
	}
	
}