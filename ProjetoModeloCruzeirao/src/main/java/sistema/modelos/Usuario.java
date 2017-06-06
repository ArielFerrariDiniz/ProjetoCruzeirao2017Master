package sistema.modelos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
@SuppressWarnings("serial")
@Entity
@NamedQuery(name = "Usuario.pesquisarPorUserName", query = "select u from Usuario u where u.username = :username")
public class Usuario implements Serializable{
	
private static final long serialVersionUID = 6360850095345609468L;
	
	public static final String PESQUISAR_POR_USERNAME = "Usuario.pesquisarPorUserName";
	@Id
	private int id;
	private String username;
	private String password;
	private String email;
	private String rg;
	private String cpf;
	private Date dataNascimento;
	private String endereco;
	private String telefoneFixo;
	private String telefoneMovel;
	private List <Campeonato> campeonatos;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="usuario")
	private List <Inscrito> incricoes;
	private List <Equipe> equipes;
	private String foto;
	private String sexo ;
	private String cref;
	private String role= "COMUM";
	
	
	
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


public Usuario()
{
	
}

	
	public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefoneFixo() {
		return telefoneFixo;
	}
	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}
	public String getTelefoneMovel() {
		return telefoneMovel;
	}
	public void setTelefoneMovel(String telefoneMovel) {
		this.telefoneMovel = telefoneMovel;
	}
	public List<Campeonato> getCampeonatos() {
		return campeonatos;
	}
	public void setCampeonatos(List<Campeonato> campeonatos) {
		this.campeonatos = campeonatos;
	}
	public List<Inscrito> getIncricoes() {
		return incricoes;
	}
	public void setIncricoes(Inscrito inscrito) {
		this.incricoes.add(inscrito);
	}
	public List<Equipe> getEquipes() {
		return equipes;
	}
	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCref() {
		return cref;
	}
	public void setCref(String cref) {
		this.cref = cref;
	}
	
	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Usuario other = (Usuario) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}
