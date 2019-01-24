package com.renolop.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renolop.cursomc.domain.Cliente;
import com.renolop.cursomc.repositories.ClienteRepository;
import com.renolop.cursomc.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente buscarPorId( Integer id ) {

		Optional<Cliente> cliente = clienteRepository.findById( id );
		
		//return cliente.orElse( null );
		
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrada: id="+id));
	}
	
}
