package com.renolop.cursomc.domain;

import java.util.Date;


import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.renolop.cursomc.domain.enums.EstadoPagamento;

@Entity 
public class PagamentoComBoleto extends Pagamento {  
	private static final long serialVersionUID = 1L;     
	
	public PagamentoComBoleto() {
	}
	
	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		
	}

	@JsonFormat(pattern="dd/MM/yyyy")  
	private Date dataVencimento; 

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataPagamento;

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
}
