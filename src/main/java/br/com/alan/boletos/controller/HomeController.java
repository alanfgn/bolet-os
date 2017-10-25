package br.com.alan.boletos.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alan.boletos.model.Administrador;
import br.com.alan.boletos.model.Pessoa;
import br.com.alan.boletos.model.Usuario;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home(HttpSession sessao) {
		Pessoa pessoa = (Pessoa) sessao.getAttribute("conta");

		if (pessoa == null) {
			return "redirect:404";

		} else if (pessoa instanceof Administrador) {
			return "administrador/home";

		} else if (pessoa instanceof Usuario) {
			return "usuario/home";
		}

		return "home";
	}
}
