package com.renolop.cursomc.domain;

import javax.persistence.Entity;

import com.renolop.cursomc.domain.enums.EstadoPagamento;

@Entity 
public class PagamentoComCartao extends Pagamento {  
	private static final long serialVersionUID = 1L;     
	
	public PagamentoComCartao() {
	}
	
	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroParcelas) {
		super(id, estado, pedido);
		this.numeroParcelas = numeroParcelas;
	}

	private Integer numeroParcelas;

	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}
}
