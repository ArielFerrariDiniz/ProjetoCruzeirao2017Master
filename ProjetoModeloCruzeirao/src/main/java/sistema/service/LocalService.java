package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.modelos.Local;;


public class LocalService extends Service {
	
	public LocalService(){
		
	}
	
	public void salvar(Local local) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(local);
		em.getTransaction().commit();
		em.close();
	}

	public void removerLocal(Local local) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		local = em.find(Local.class, local.getCodigo());
		em.remove(local);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Local> getCategorias() {

		List<Local> locais;

		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select l From Local l");
		locais = q.getResultList();
		em.close();

		return locais;
	}
	
}