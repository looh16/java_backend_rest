package com.backend.api.models.enums;

public enum TipoCliente {

	PESSOAJURIDIA(1, "Pessoa Juridica"),
	PESSOAFISICA(1, "Pessoa Fisica");
	
	private int codigo;
	private String descricao;
	
	private TipoCliente(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		
		if(cod == null) {
			
			return null;
		}
		
		for (TipoCliente x : TipoCliente.values()) {
			
			if(cod.equals(x.getCodigo())) {
				
				return x;
			}	
		}
		
		throw new IllegalArgumentException("Codigo invalido " + cod);
	}
	
}
