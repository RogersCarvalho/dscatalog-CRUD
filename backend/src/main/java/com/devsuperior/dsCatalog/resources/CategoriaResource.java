package com.devsuperior.dsCatalog.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devsuperior.dsCatalog.Service.CategoriaService;
import com.devsuperior.dsCatalog.dto.CategoryDTO;
import java.util.List;



@RestController
@RequestMapping(value= "/categorias")
public class CategoriaResource {

	
	@Autowired
	private CategoriaService service;
	
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll() {
		
		List<CategoryDTO> listDTO = service.FindAll();
		return ResponseEntity.ok().body(listDTO);
	}
}

