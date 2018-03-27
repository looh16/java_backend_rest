package com.backend.api.models.enums;

public enum estadoPagamento {

	PENDENTE (1, "pendente"), QUITADO(2,"quitado"), CANCELADO(3, "cancelado");
	
	private int codigo;
	private String descricao;
	
	private estadoPagamento(int codigo, String descricao) {
		
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static estadoPagamento toEnum(Integer cod) {
		
		if(cod == null) {
			
			return null;
		}
		
		for (estadoPagamento x : estadoPagamento.values()) {
			
			if(cod.equals(x.getCodigo())) {
				
				return x;
			}	
		}
		
		throw new IllegalArgumentException("Codigo invalido " + cod);
	}
	
	
}
