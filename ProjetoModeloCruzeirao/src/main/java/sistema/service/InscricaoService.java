package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.modelos.Inscricao;

public class InscricaoService extends Service{
	public InscricaoService()
	{
	}
	
	public void salvar(Inscricao inscricao)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(inscricao);
		em.getTransaction().commit();
		em.close();
	}

	public void alterarInscricao(Inscricao inscricao) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(inscricao);
		em.getTransaction().commit();
		em.close();
	}
	

	public void removerInscricao(Inscricao inscricao) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		inscricao= em.find(Inscricao.class, inscricao.getNumero());
		em.remove(inscricao);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Inscricao> getInscricoes() {

		List<Inscricao> inscricoes;

		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select c From Inscricao c");
		inscricoes = q.getResultList();
		em.close();

		return inscricoes;
	}

	public Inscricao getInscricaoByCodigo(int codigo) {

		List<Inscricao> lista = getInscricoes();
		Inscricao eq = new Inscricao();

		for (Inscricao e : lista) {
			if (codigo == e.getNumero())
				eq = e;
		}

		return eq;
	}

	
}