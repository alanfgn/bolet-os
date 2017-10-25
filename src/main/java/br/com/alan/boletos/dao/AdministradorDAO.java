package br.com.alan.boletos.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.alan.boletos.model.Administrador;

@Repository
public class AdministradorDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void persistir(Administrador administrador){
		manager.persist(administrador);
	}
	
	@Transactional
	public Administrador pegar(Integer id){
		return manager.find(Administrador.class, id);
	}
}
