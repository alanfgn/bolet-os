package br.com.alan.boletos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.alan.boletos.model.Usuario;

@Repository
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void persistir(Usuario usuario) {
		manager.persist(usuario);
	}

	@Transactional
	public Usuario pegar(Integer id) {
		return manager.find(Usuario.class, id);
	}

	@Transactional
	public void mudar(Usuario usuario) {
		manager.merge(usuario);
	}

	@Transactional
	public void deletar(Usuario usuario) {
		manager.remove(usuario);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuario() {
		return manager.createQuery("from Usuario").getResultList();
	}
}