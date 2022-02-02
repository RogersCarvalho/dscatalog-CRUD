package com.devsuperior.dsCatalog.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsCatalog.entidade.Categoria;

import java.util.List;
import java.util.ArrayList;


@RestController
@RequestMapping(value= "/categorias")
public class CategoriaResource {

	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
		
		List<Categoria> list = new ArrayList<>();
		
		list.add(new Categoria(1L, "Books"));
		list.add(new Categoria(2L, "Eletronicos"));
		
		return ResponseEntity.ok().body(list);
		
	}
	
	
}