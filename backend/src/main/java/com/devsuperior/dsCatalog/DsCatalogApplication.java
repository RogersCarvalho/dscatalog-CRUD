package com.devsuperior.dsCatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.dsCatalog.entidade.Categoria;

@SpringBootApplication
public class DsCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsCatalogApplication.class, args);
		
		
		
		Categoria cat = new Categoria();
		
		cat.setId(1000);
		cat.setName("Eletro");
		
		
		System.out.println(cat);
		
		
	}

}
