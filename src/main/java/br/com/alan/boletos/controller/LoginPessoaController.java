package br.com.alan.boletos.controller;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alan.boletos.model.Pessoa;
import br.com.alan.boletos.servicos.BancoFacade;

@Controller
@Transactional
public class LoginPessoaController {
	
	@Autowired
	private BancoFacade banco;
	
	@RequestMapping("/login")
	public String login(Pessoa pessoa){
		return "login";
	}
	
	@PostMapping("/logar")
	public String logar(Pessoa pessoa, Model model, RedirectAttributes redirectAttributes, HttpSession sessao){
		
		pessoa = banco.autenticar(pessoa);
		if(pessoa == null){
			redirectAttributes.addFlashAttribute("msg", "Senha ou login errados");
			return "redirect:login";
		
		}else{
			sessao.setAttribute("conta", pessoa);
			return "redirect:home";				
		}
		
	}
	
}
