package br.com.augusto.filtro;

import br.com.augusto.model.Pessoa;

public class FiltroPessoaPorCpf implements Filtro<Pessoa> {

	private final String cpf;

	public FiltroPessoaPorCpf(String cpf) {
		super();
		this.cpf = cpf;
	}

	@Override
	public boolean filtrar(Pessoa pessoa) {
		boolean filtrar = true;
		if(cpf != null ) {
			filtrar =  pessoa.getCpfCnpj().toLowerCase().trim().contains(cpf.toLowerCase().trim());
		}
		return filtrar;
	}
}
