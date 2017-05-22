package sistema.dao;


import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;


/**
 * Classe que contem a implementacao pradrao em JPA 
 * 
 * 
 */

public abstract class GenericoDAO<T>  {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<T> classeEntidade;
	
	
	public GenericoDAO(){
		if(emf == null)
		    emf = Persistence.createEntityManagerFactory("ProjetoModeloCruzeirao");
		
		
		//Usar CDI!!!!
		em = emf.createEntityManager();
	}
	
	

	protected abstract Class<T> getClasseEntidade();
	
	@PostConstruct
	public void init() {
		classeEntidade = getClasseEntidade();
	}

	protected EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public Query criarNativeQuery(String sql) {
		return em.createNativeQuery(sql);
	}

	
	public void salvar(T entidade) {
		em.persist(entidade);
	}

	
	public void remover(Object id) {
		T entityToBeRemoved = em.getReference(classeEntidade, id);
		em.remove(entityToBeRemoved);
	}

	
	public T atualizar(T entidade) {
		return em.merge(entidade);
	}

	
	public T pesquisarPorId(Long id) {
		return em.find(classeEntidade, id);
	}

	
	public T pesquisarReferencia(Long id) {
		return em.getReference(classeEntidade, id);
	}

	
	public List<?> pesquisarTodos() {
		CriteriaQuery<Object> cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(classeEntidade));
		return em.createQuery(cq).getResultList();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected T pesquisarUm(String namedQuery, Map parametros) {
		T resultado = null;

		try {
			Query query = em.createNamedQuery(namedQuery);
			if (parametros != null && !parametros.isEmpty()) {
				popularParametrosQuery(query, parametros);
			}
			resultado = (T) query.setMaxResults(1).getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		return resultado;
	}


	protected void popularParametrosQuery(Query query,	Map<String, Object> parametros) {
		for (Map.Entry<String, Object> parametro : parametros.entrySet()) {
			query.setParameter(parametro.getKey(), parametro.getValue());
		}
	}
		



}
