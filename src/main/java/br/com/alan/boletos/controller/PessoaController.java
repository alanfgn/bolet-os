package br.com.alan.boletos.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alan.boletos.dao.AdministradorDAO;
import br.com.alan.boletos.model.Administrador;
import br.com.alan.boletos.model.Pessoa;
import br.com.alan.boletos.model.Usuario;
import br.com.alan.boletos.servicos.BancoFacade;

@Controller
@Transactional
public class PessoaController {

	@Autowired
	private AdministradorDAO administradorDAO;

	@Autowired
	private BancoFacade banco;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("estado", "Em Construção");
		return "index";
	}

	@RequestMapping("/cadastro")
	public String cadastro(Pessoa pessoa) {
		return "cadastro";
	}

	@PostMapping("/cadastro")
	public String cadastrar(@ModelAttribute @Valid Pessoa pessoa, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			return cadastro(pessoa);

		} else {
			// Implementar Validação de duplicidade algum dia :p

			banco.salvarPessoa(pessoa);
			redirectAttributes.addFlashAttribute("msg", "Cadastro feito com sucesso");

			return "redirect:/cadastro";
		}

	}

	@GetMapping("boleto/{id}")
	public void gerarBoleto(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) {

		Usuario usuario = banco.pegarUsuario(id);

		String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/resources/");
		Path file = Paths.get(dataDirectory, "boleto.pdf");

		if (Files.exists(file)) {

			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", "attachment; filename=" + "boleto.pdf");

			try {
				Files.copy(file, response.getOutputStream());
				response.getOutputStream().flush();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("Gerando Boleto de ... " + usuario.getNome());
	}

	@RequestMapping("/sair")
	public String sair(HttpSession sessao) {
		sessao.removeAttribute("conta");
		return "redirect:/";
	}

	@RequestMapping("/faz")
	public String poc() {

		Administrador administrador = new Administrador();
		administrador.setLogin("admin");
		administrador.setSenha("admin");
		administrador.setCpf("123456789");

		administradorDAO.persistir(administrador);

		return "redirect:/";

	}
}
