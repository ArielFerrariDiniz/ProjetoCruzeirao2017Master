package sistema.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.modelos.Campeonato;
import sistema.modelos.Usuario;

public class UsuarioService extends Service {
	
	
	public UsuarioService()
	{
		
		
		
	}
	
	
	public void salvar(Usuario usuario) 
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();
		
	}
	
	
	public Usuario recuperarSenha(Usuario usuario)
	{
		List<Usuario> usuarios;

		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select u From Usuario u ");
		usuarios = q.getResultList();
		em.close();

		for(Usuario aux : usuarios)
		{
			if(aux.getEmail().equals(usuario.getEmail())&& (aux.getCpf().equals(usuario.getCpf())))
			{
				
				return aux;
			}
		}
		return null;
		
	}

	
	@SuppressWarnings("unchecked")
	public List<Usuario> getUsuarios() {
		
		List<Usuario> usuarios;

		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select u From Usuario u ");
		usuarios = q.getResultList();
		em.close();

		return usuarios;
	}

	public Usuario entrar(Usuario usuarioEntrar) {
		
		List<Usuario> usuarios;

		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select u From Usuario u ");
		usuarios = q.getResultList();
		em.close();

		for(Usuario aux: usuarios)
		{
		
			if((aux.getUsername().equals(usuarioEntrar.getUsername()))&&(aux.getPassword().equals(usuarioEntrar.getPassword())))
			{
				return aux;
			}
			
		}
		return null;
		
	}


	public Usuario pesquisarPorUserName(String login) {
		
		return null;
	}
	
	public void alterarUsuario(Usuario usuario) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
		em.close();
	}
	
}
