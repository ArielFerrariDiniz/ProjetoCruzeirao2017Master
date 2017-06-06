package sistema.modelos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Categoria implements Serializable {

	@Id
	private int codigoCategoria;
	private String nome;
	private int nascidosApartirDe;
	private List<Inscricao> inscricoes;

	

	@ManyToOne
	private Campeonato campeonato;
	private List<Fase> fases;
	private int minJogadores;
	private int maxJogadores;
	private String sexo;

	public Categoria() {

	}

	public Categoria(int codigoCategoria) {
		super();
		this.codigoCategoria = codigoCategoria;
	}

	public int getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(int codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNascidosApartirDe() {
		return nascidosApartirDe;
	}

	public void setNascidosApartirDe(int nascidosApartirDe) {
		this.nascidosApartirDe = nascidosApartirDe;
	}

	public List<Inscricao> getInscritos() {
		return inscricoes;
	}

	public void setInscritos(List<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public List<Fase> getFases() {
		return fases;
	}

	public void setFases(List<Fase> fases) {
		this.fases = fases;
	}

	public int getMinJogadores() {
		return minJogadores;
	}

	public void setMinJogadores(int minJogadores) {
		this.minJogadores = minJogadores;
	}

	public int getMaxJogadores() {
		return maxJogadores;
	}

	public void setMaxJogadores(int maxJogadores) {
		this.maxJogadores = maxJogadores;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Categoria other = (Categoria) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Categoria [codigoCategoria=" + codigoCategoria + ", nome=" + nome + ", nascidosApartirDe="
				+ nascidosApartirDe + ", inscricoes=" + inscricoes + ", campeonato=" + campeonato + ", fases=" + fases
				+ ", minJogadores=" + minJogadores + ", maxJogadores=" + maxJogadores + ", sexo=" + sexo + "]";
	}
}