package br.com.alan.boletos.servicos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.alan.boletos.model.Administrador;
import br.com.alan.boletos.model.Pessoa;
import br.com.alan.boletos.model.Usuario;

@Service
public class CriterioSoPessoa implements Criterio {
	
	@Override
	public List<Pessoa> pegueCriterio(List<Pessoa> pessoas){
		
		List<Pessoa> somentePessoas = new ArrayList<>();
	
		for (Pessoa pessoa : pessoas) {
			if( !(pessoa instanceof Administrador) && !(pessoa instanceof Usuario)){
				somentePessoas.add(pessoa);
			}
		}
		
		return somentePessoas;
		
	}
}
