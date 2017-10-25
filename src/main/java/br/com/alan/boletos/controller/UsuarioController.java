package br.com.alan.boletos.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alan.boletos.model.Pessoa;
import br.com.alan.boletos.model.Usuario;
import br.com.alan.boletos.servicos.BancoFacade;

@Controller
public class UsuarioController {
	
	@Autowired
	private BancoFacade banco;
	
	@RequestMapping("usuario/editar")
	public String edita(Usuario usuario,  HttpSession sessao){
		
		Usuario usuarioLogado = (Usuario) sessao.getAttribute("conta");
		
		usuario.setLogin(usuarioLogado.getLogin());
		usuario.setSenha(usuarioLogado.getSenha());
		usuario.setCpf(usuarioLogado.getCpf());
		usuario.setNome(usuarioLogado.getNome());
		usuario.setEmail(usuarioLogado.getEmail());
		
		
		return "usuario/editar";
	}
	
	@PostMapping("usuario/editar")
	public String editar(@Valid Usuario novoUsuario, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("conta");
		novoUsuario.setId(usuario.getId());
		
		banco.mudarUsuario(usuario);
		session.setAttribute("conta", novoUsuario);
		
		return "redirect:editar";
	}
	

	@PostMapping("/usuario")
	public String completar(@RequestParam("nome") String nome, @RequestParam("email") String email, HttpSession sessao,
			RedirectAttributes redirectAttributes) {

		Pessoa pessoa = (Pessoa) sessao.getAttribute("conta");

		Usuario usuario = new Usuario();

		usuario.setCpf(pessoa.getCpf());
		usuario.setLogin(pessoa.getLogin());
		usuario.setSenha(pessoa.getSenha());

		usuario.setEmail(email);
		usuario.setNome(nome);

		sessao.removeAttribute("conta");
		
		banco.pessoaParaUsuario(pessoa, usuario);
		
		sessao.setAttribute("conta", usuario);

		return "redirect:login";
	}
	
}
