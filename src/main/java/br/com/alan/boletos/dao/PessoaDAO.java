package br.com.alan.boletos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.alan.boletos.model.Pessoa;

@Repository
public class PessoaDAO {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	public void persistir(Pessoa pessoa) {
		manager.persist(pessoa);
	}
	
	@Transactional
	public void deletar(Pessoa pessoa) {
		manager.remove(manager.merge(pessoa));
	}

	@Transactional
	public Pessoa pegar(Integer id) {
		return manager.find(Pessoa.class, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Pessoa> listarPessoas() {
		return manager.createQuery("from Pessoa").getResultList();
	}

	@Transactional
	public boolean isExists(Pessoa pessoa) {
		return manager.contains(pessoa);
	}

	@Transactional
	public Pessoa autenticar(Pessoa pessoa) throws NoResultException{
		String hql = "SELECT pes FROM Pessoa As pes WHERE pes.login=:login AND pes.senha=:senha";
		pessoa = (Pessoa) manager.createQuery(hql).setParameter("login", pessoa.getLogin())
				.setParameter("senha", pessoa.getSenha()).getSingleResult();

		return pessoa;
	}

}
