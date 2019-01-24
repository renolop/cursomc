package com.renolop.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renolop.cursomc.domain.Categoria;
import com.renolop.cursomc.repositories.CategoriaRepository;
import com.renolop.cursomc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscarPorId( Integer id ) {

		Optional<Categoria> categoria = categoriaRepository.findById( id );
		
		//return categoria.orElse( null );
		
		return categoria.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada: id="+id));
	}
	
}
