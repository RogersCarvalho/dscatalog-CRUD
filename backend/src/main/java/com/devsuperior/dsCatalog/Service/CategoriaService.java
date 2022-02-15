
package com.devsuperior.dsCatalog.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.devsuperior.dsCatalog.repositories.CategoriaRepositorio;
import com.devsuperior.dsCatalog.Service.exceptions.DatabaseException;
import com.devsuperior.dsCatalog.Service.exceptions.ResourceNotFoundException;
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
		Categoria entity = obj.orElseThrow( () -> new ResourceNotFoundException("Entidade não encontrada") );
		return new CategoryDTO(entity);
	}
	
	@Transactional
	public CategoryDTO insert(CategoryDTO dto) {
		Categoria entity = new Categoria();
		entity.setName(dto.getNome());
		entity = rep.save(entity);
		return new CategoryDTO(entity);
	}
	
	@Transactional
	public CategoryDTO update(Long id, CategoryDTO dto) {
    try {
			Categoria entity = rep.getOne(id);
			entity.setName(dto.getNome());
			entity = rep.save(entity);
			return new CategoryDTO(entity);
		}
		catch(EntityNotFoundException e) {
			throw new  ResourceNotFoundException("id não encontrado"+id);}
     }


	public void delete(Long id) {
		try
		{
		rep.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new  ResourceNotFoundException("id não encontrado"+id);
		}
		catch(DataIntegrityViolationException e) {
			
			throw new DatabaseException("Integrity violation");
			
		}
	}

}








