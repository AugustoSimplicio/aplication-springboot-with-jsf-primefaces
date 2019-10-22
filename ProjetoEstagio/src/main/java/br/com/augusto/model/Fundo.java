package br.com.augusto.model;


public class Fundo {
	private Integer id;
	private Integer processoSusep;
	private String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProcessoSusep() {
		return processoSusep;
	}

	public void setProcessoSusep(Integer processoSusep) {
		this.processoSusep = processoSusep;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Fundo [id=" + id + ", processoSusep=" + processoSusep + ", nome=" + nome + "]";
	}

}
