package com.devsuperior.dsCatalog.dto;

import java.io.Serializable;

import com.devsuperior.dsCatalog.entidade.Categoria;



public class CategoryDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String nome;
	
	
	public CategoryDTO() {}
	
	
	public CategoryDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	
	public CategoryDTO(Categoria entity) {
		this.id = entity.getId();
		this.nome = entity.getName();
	}
	
	
	
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
	

}
