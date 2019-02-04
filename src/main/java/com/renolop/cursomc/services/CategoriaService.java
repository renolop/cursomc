package com.renolop.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.renolop.cursomc.domain.Categoria;
import com.renolop.cursomc.repositories.CategoriaRepository;
import com.renolop.cursomc.services.exception.DataIntegrityException;
import com.renolop.cursomc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria find( Integer id ) {

		Optional<Categoria> categoria = categoriaRepository.findById( id );
		
		//return categoria.orElse( null );
		
		return categoria.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada: id="+id));
	}

	public Categoria insert(Categoria c) {
		c.setId(null);
		return categoriaRepository.save( c );
	}
	
	public Categoria update(Categoria c) {
		find( c.getId() );
		return categoriaRepository.save( c );
	}
	
	public void delete( Integer id ) {
		try {
			categoriaRepository.deleteById(id);
		}catch( DataIntegrityViolationException dive ) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos.");
		}
	}
}
