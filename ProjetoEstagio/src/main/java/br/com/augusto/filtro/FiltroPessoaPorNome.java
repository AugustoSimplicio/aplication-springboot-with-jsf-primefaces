package br.com.augusto.filtro;

import br.com.augusto.model.Pessoa;

public class FiltroPessoaPorNome implements Filtro<Pessoa> {

	private String nome;

	public FiltroPessoaPorNome(String nome) {
		super();
		this.nome = nome;
	}
	
	@Override
	public boolean filtrar(Pessoa pessoa) {
		boolean filtrar = true;
		if(nome != null ) {
			filtrar = pessoa.getNome().toLowerCase().trim().contains(nome.toLowerCase().trim());
		}
		return filtrar;
	}
}
