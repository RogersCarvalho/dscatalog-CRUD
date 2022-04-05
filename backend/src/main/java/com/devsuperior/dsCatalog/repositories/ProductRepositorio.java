package com.devsuperior.dsCatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.devsuperior.dsCatalog.entidade.Product;


@Repository
public interface ProductRepositorio extends JpaRepository<Product, Long>{


}
