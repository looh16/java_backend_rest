package com.backend.api.models.enums;

public enum EstadoPagamento {

	PENDENTE (1, "pendente"), QUITADO(2,"quitado"), CANCELADO(3, "cancelado");
	
	private int codigo;
	private String descricao;
	
	private EstadoPagamento(int codigo, String descricao) {
		
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoPagamento toEnum(Integer cod) {
		
		if(cod == null) {
			
			return null;
		}
		
		for (EstadoPagamento x : EstadoPagamento.values()) {
			
			if(cod.equals(x.getCodigo())) {
				
				return x;
			}	
		}
		
		throw new IllegalArgumentException("Codigo invalido " + cod);
	}
	
	
}
