package br.com.augusto.domain.enums;

public enum TipoPessoaEnum {
	FISICA("Fisica"), JURIDICA("Juridica");

	private String label;

	private TipoPessoaEnum(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
