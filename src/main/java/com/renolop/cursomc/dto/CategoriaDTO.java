package com.renolop.cursomc.dto;

import java.io.Serializable;

import com.renolop.cursomc.domain.Categoria;

public class CategoriaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	public CategoriaDTO() {
	}
	
	public CategoriaDTO( Categoria c ) {
		setId( c.getId() );
		setNome( c.getNome() );
	}
	
	private Integer id;
	
	private String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
