package br.com.alan.boletos.servicos;

import java.util.List;

import br.com.alan.boletos.model.Pessoa;

public interface Criterio {
	public List<Pessoa> pegueCriterio(List<Pessoa> pessoas);
}
