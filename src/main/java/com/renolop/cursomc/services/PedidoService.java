package com.renolop.cursomc.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renolop.cursomc.domain.Pedido;
import com.renolop.cursomc.repositories.PedidoRepository;
import com.renolop.cursomc.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido find( Integer id ) {

		Optional<Pedido> pedido= pedidoRepository.findById( id );
		
		//return cliente.orElse( null );
		
		return pedido.orElseThrow(() -> new ObjectNotFoundException("Pedido não encontrada: id="+id));
	}
	
}
