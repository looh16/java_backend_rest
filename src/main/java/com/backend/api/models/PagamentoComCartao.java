package com.backend.api.models;

import javax.persistence.Entity;

import com.backend.api.models.enums.estadoPagamento;

@Entity
public class PagamentoComCartao  extends Pagamento{

	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcelas;

	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Integer id, estadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		
		super(id, estado, pedido);
		this.numeroDeParcelas=numeroDeParcelas;
		
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
	
	
}
