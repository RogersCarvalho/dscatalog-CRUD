
package com.devsuperior.dsCatalog.resources;
import org.aspectj.weaver.patterns.TypeCategoryTypePattern;
import org.hibernate.annotations.OnDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.dsCatalog.Service.CategoriaService;
import com.devsuperior.dsCatalog.dto.CategoryDTO;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value= "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;
	
	
	@GetMapping
	public ResponseEntity<Page<CategoryDTO>> findAll(
				
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "2") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy
			
			) {
		
		PageRequest pageRequest= PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<CategoryDTO> listDTO = service.FindAllPaged(pageRequest);
		return ResponseEntity.ok().body(listDTO);
	}	
	
	
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {
		CategoryDTO dto = service.FindById(id);
		return ResponseEntity.ok().body(dto);}
	
	
	@PostMapping
	public ResponseEntity<CategoryDTO> insert(@RequestBody  CategoryDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);}
	
	@PutMapping(value= "/{id}")
	public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @RequestBody  CategoryDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}

