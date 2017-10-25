package br.com.alan.boletos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alan.boletos.model.Administrador;
import br.com.alan.boletos.model.Pessoa;
import br.com.alan.boletos.servicos.BancoFacade;
import br.com.alan.boletos.servicos.CriterioSoPessoa;

@Controller
public class AdministradorController {
	
	@Autowired
	private BancoFacade banco;
	
	@Autowired
	private CriterioSoPessoa criterio;		
	
	@RequestMapping("administrador/usuarios")
	public String listu(Model model){
		model.addAttribute("lista", banco.pegarUsuarios());
		return "administrador/listu";
	}
	
	@RequestMapping("administrador/pessoas")
	public String listp(Model model){
		
		model.addAttribute("lista", criterio.pegueCriterio(banco.pegarPessoas()));
		return "administrador/listp";
	}
	
	@RequestMapping("administrador/pessoas/{id}")
	public String transformarAdm(@PathVariable("id") Integer id){
		
		Pessoa pessoa = banco.pegarPessoaComId(id);
		Administrador administrador = new Administrador();
		
		administrador.setLogin(pessoa.getLogin());
		administrador.setSenha(pessoa.getSenha());
		administrador.setCpf(pessoa.getCpf());
		
		banco.pessoaParaAdm(pessoa, administrador);
		
		return "redirect:/";
		
	}

}
