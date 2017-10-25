package br.com.alan.boletos.servicos;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alan.boletos.dao.AdministradorDAO;
import br.com.alan.boletos.dao.PessoaDAO;
import br.com.alan.boletos.dao.UsuarioDAO;
import br.com.alan.boletos.model.Administrador;
import br.com.alan.boletos.model.Pessoa;
import br.com.alan.boletos.model.Usuario;

@Service
public class BancoFacade {

	@Autowired
	private AdministradorDAO administradorDAO;

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private PessoaDAO pessoaDAO;

	public List<Pessoa> pegarPessoas() {
		return pessoaDAO.listarPessoas();
	}

	public Pessoa pegarPessoaComId(Integer id) {
		return pessoaDAO.pegar(id);
	}

	public void salvarPessoa(Pessoa pessoa) {
		pessoaDAO.persistir(pessoa);
	}

	private void deletarPessoa(Pessoa pessoa) {
		pessoaDAO.deletar(pessoa);
	}

	private void salvarUsuario(Usuario usuario) {
		usuarioDAO.persistir(usuario);
	}

	public List<Usuario> pegarUsuarios() {
		return usuarioDAO.listarUsuario();
	}

	public void mudarUsuario(Usuario usuario) {
		usuarioDAO.mudar(usuario);
	}

	public Usuario pegarUsuario(Integer id) {
		return usuarioDAO.pegar(id);
	}

	public Pessoa autenticar(Pessoa pessoa) {

		try {
			pessoa = pessoaDAO.autenticar(pessoa);
		} catch (NoResultException noResult) {
			pessoa = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pessoa;
	}

	private void salvarAdministrador(Administrador administrador) {
		administradorDAO.persistir(administrador);
	}

	public void pessoaParaAdm(Pessoa pessoa, Administrador administrador) {

		deletarPessoa(pessoa);
		salvarAdministrador(administrador);
	}

	public void pessoaParaUsuario(Pessoa pessoa, Usuario usuario) {
		deletarPessoa(pessoa);
		salvarUsuario(usuario);
	}

}
