package sistema.modelos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Inscrito implements Serializable{

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nomeUser;
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="idInscricao")
	private Inscricao inscricao;
	private boolean aceiteUsuario;
	private boolean suspensoJogos;
	private boolean inscricaoValidada;
	
	
	public Inscrito(Usuario usuario, Inscricao inscricao){
		this.usuario=usuario;
		this.inscricao=inscricao;
	}
	
	public Inscrito(){
		
	}
	
	public String getNomeUser() {
		return nomeUser;
	}

	public void setNomeUser(String nomeUser) {
		this.nomeUser = nomeUser;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Inscricao getInscricao() {
		return inscricao;
	}
	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}
	public boolean isAceiteUsuario() {
		return aceiteUsuario;
	}
	public void setAceiteUsuario(boolean aceiteUsuario) {
		this.aceiteUsuario = aceiteUsuario;
	}
	public boolean isSuspensoJogos() {
		return suspensoJogos;
	}
	public void setSuspensoJogos(boolean suspensoJogos) {
		this.suspensoJogos = suspensoJogos;
	}
	public boolean isInscricaoValidada() {
		return inscricaoValidada;
	}
	public void setInscricaoValidada(boolean inscricaoValidada) {
		this.inscricaoValidada = inscricaoValidada;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeUser == null) ? 0 : nomeUser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inscrito other = (Inscrito) obj;
		if (nomeUser == null) {
			if (other.nomeUser != null)
				return false;
		} else if (!nomeUser.equals(other.nomeUser))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Inscrito [nomeUser=" + nomeUser + ", usuario=" + usuario + ", inscricao=" + inscricao
				+ ", aceiteUsuario=" + aceiteUsuario + ", suspensoJogos=" + suspensoJogos + ", inscricaoValidada="
				+ inscricaoValidada + "]";
	}
	
}