
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.devsuperior.dsCatalog.repositories.CategoriaRepositorio;
import com.devsuperior.dsCatalog.repositories.ProductRepositorio;
import com.devsuperior.dsCatalog.Service.exceptions.DatabaseException;
import com.devsuperior.dsCatalog.Service.exceptions.ResourceNotFoundException;
import com.devsuperior.dsCatalog.dto.CategoryDTO;
import com.devsuperior.dsCatalog.dto.ProductDTO;
import com.devsuperior.dsCatalog.entidade.Categoria;
import com.devsuperior.dsCatalog.entidade.Product;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepositorio  rep;
    @Autowired
	private CategoriaRepositorio categoryRepository;
	
	
	@Transactional(readOnly = true) 
	public Page<ProductDTO> FindAllPaged(PageRequest pageRequest){
	    Page<Product> list = rep.findAll(pageRequest);
	    Page<ProductDTO> listDTO =   list.map(x->new ProductDTO(x));
	   	//List<ProductDTO> listDTO = new ArrayList<>();
	    //for (Product cat: list) {listDTO.add(new ProductDTO(cat));}    
	     return  listDTO;  }
	
	@Transactional(readOnly = true)
	public ProductDTO FindById(Long id) {
		
		Optional<Product> obj = rep.findById(id);
	    //Product entity = obj.get();
		Product entity = obj.orElseThrow(() -> new ResourceNotFoundException("Não encontrada"));
		return new ProductDTO(entity, entity.getCategories());
		//return new ProductDTO(entity);
	}
	
	
	//--------------------------------------------------------------------------//
	

	private void copydto_To_Entity(ProductDTO dto, Product entity) {
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setDate(dto.getDate());
		entity.setDate(dto.getDate());
		entity.setImgURL(dto.getImg_url());
		entity.setPrice(dto.getPrice());
		entity.getCategories().clear();
		for (CategoryDTO obj_cat : dto.getCategories()) {
			Categoria category = categoryRepository.getOne(obj_cat.getId());
			entity.getCategories().add(category);
		}
	}

	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		Product entity = new Product();
		copydto_To_Entity(dto,entity);
		entity = rep.save(entity);
		return new ProductDTO(entity,entity.getCategories());
	}
	
	//--------------------------------------------------------------------------//
	
	@Transactional
	public ProductDTO update(Long id, ProductDTO dto) {
    try {
			Product entity = rep.getOne(id);
			//entity.setName(dto.getName());
			copydto_To_Entity(dto,entity);
			entity = rep.save(entity);
			return new ProductDTO(entity,entity.getCategories());
		}
		catch(EntityNotFoundException e) {
			throw new  ResourceNotFoundException("id não encontrado"+id);}
     }


	public void delete(Long id) {
		try{
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








