package br.com.augusto.filtro;

import br.com.augusto.model.Pessoa;

public class FiltroPessoaPorEmail implements Filtro<Pessoa> {
	private String email;
	
	public FiltroPessoaPorEmail(String email) {
		super();
		this.email = email;
	}

	@Override
	public boolean filtrar(Pessoa pessoa) {
		boolean filtrar = true;
		if(email != null) {
			filtrar = pessoa.getEmail().toLowerCase().trim().contains(email.toLowerCase().trim());
		}
	return filtrar;
	}
}
