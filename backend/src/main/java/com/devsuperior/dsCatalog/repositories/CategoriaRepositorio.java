package com.devsuperior.dsCatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dsCatalog.entidade.Categoria;




@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long>{


}
