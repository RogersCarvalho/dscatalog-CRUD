package com.devsuperior.dsCatalog.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.devsuperior.dsCatalog.repositories.CategoriaRepositorio;
import com.devsuperior.dsCatalog.entidade.Categoria;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaService {
	
	
	@Autowired
	private CategoriaRepositorio  rep;
		

	@Transactional(readOnly = true) 
	public List<Categoria> FindAll(){
			return rep.findAll();	
	}
	
}


