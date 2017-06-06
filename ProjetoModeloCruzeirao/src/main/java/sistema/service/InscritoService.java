package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.modelos.Inscricao;
import sistema.modelos.Inscrito;

public class InscritoService extends Service{

	
	public List<Inscrito> getInscritos() {

		List<Inscrito> inscritos;

		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select c From Inscrito c");
		inscritos = q.getResultList();
		em.close();

		return inscritos;
	}
	
	public InscritoService()
	{
	}
	
	public void salvar(Inscrito inscrito)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(inscrito);
		em.getTransaction().commit();
		em.close();
	}
	
	public void alterarInscrito(Inscrito inscrito) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(inscrito);
		em.getTransaction().commit();
		em.close();
	}
	
	public Inscrito getInscritoByNome(String nomeInscrito) {

		List<Inscrito> lista = getInscritos();
		Inscrito ins = new Inscrito();

		for (Inscrito i : lista) {
			if (i.getNomeUser().equals(nomeInscrito))
				ins = i;
		}

		return ins;
	}
}