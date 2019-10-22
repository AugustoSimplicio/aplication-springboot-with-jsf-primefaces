package br.com.augusto.filtro;

import br.com.augusto.model.Fundo;

public class FiltroFundoPorNome implements Filtro<Fundo>{
	
	
	private final String nome;

	public FiltroFundoPorNome(String nome) {
		super();
		this.nome = nome;
	}
	
	@Override
	public boolean filtrar(Fundo fundo) {
		boolean filtrar = true;
		if(nome != null ) {
			filtrar = fundo.getNome().toLowerCase().trim().contains(nome.toLowerCase().trim());
		}
		return filtrar;
	}
}
