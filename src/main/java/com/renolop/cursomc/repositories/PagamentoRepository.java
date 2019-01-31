package com.renolop.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.renolop.cursomc.domain.Pagamento;
import com.renolop.cursomc.domain.Produto;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

	
	
}
