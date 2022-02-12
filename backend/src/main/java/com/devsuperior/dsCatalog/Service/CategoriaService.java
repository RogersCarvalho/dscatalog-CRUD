package com.devsuperior.dsCatalog.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devsuperior.dsCatalog.repositories.CategoriaRepositorio;
import com.devsuperior.dsCatalog.Service.exceptions.EntityNotFoundException;
import com.devsuperior.dsCatalog.dto.CategoryDTO;
import com.devsuperior.dsCatalog.entidade.Categoria;

import org.springframework.transaction.annotation.Transactional;


@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepositorio  rep;
		
	
	@Transactional(readOnly = true) 
	public List<CategoryDTO> FindAll(){
	List<Categoria> list = rep.findAll();
    //List<CategoryDTO> listDTO =   list.stream().map(x->new CategoryDTO(x)).collect(Collectors.toList());
    List<CategoryDTO> listDTO = new ArrayList<>();
     for (Categoria cat: list) {
    	     listDTO.add(new CategoryDTO(cat));
    	 }    
     return listDTO;	
	}

		
	@Transactional(readOnly = true)
	public CategoryDTO FindById(Long id) {
		Optional<Categoria> obj = rep.findById(id);
	    //Categoria entity = obj.get();
		Categoria entity = obj.orElseThrow( () -> new EntityNotFoundException("Entidade não encontrada") );
		return new CategoryDTO(entity);
	}


	@Transactional
	public CategoryDTO insert(CategoryDTO dto) {
		Categoria entity = new Categoria();
		entity.setName(dto.getNome());
		entity = rep.save(entity);
		return new CategoryDTO(entity);
	
	}
	
}








