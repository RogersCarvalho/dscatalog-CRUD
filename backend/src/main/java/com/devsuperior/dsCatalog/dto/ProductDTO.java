package com.devsuperior.dsCatalog.dto;


import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.devsuperior.dsCatalog.entidade.Categoria;
import com.devsuperior.dsCatalog.entidade.Product;
public class ProductDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	   private Long id;
       private String name;
       private String description;
       private Double price;
       private String img_url;
       private Instant date;
	
	  private List<CategoryDTO> Categories = new ArrayList<>();

	  public ProductDTO() {}
	  public ProductDTO(Long id, String name, String description, Double price, String img_url, Instant date) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.img_url = img_url;
		this.date = date;}
	  
	  public ProductDTO(Product entity) {
		  this.id = entity.getId();
		  this.name = entity.getName();
		  this.description = entity.getDescription();
		  this.price = entity.getPrice();
		  this.img_url = entity.getImgURL();
		  this.date = entity.getDate();
	  }
	  
	  public ProductDTO(Product entity, Set<Categoria> categories) {
		this(entity);  
		categories.forEach(obj_cat -> this.Categories.add(new CategoryDTO(obj_cat)));
		}

	 //Getters e Setters
	public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public Double getPrice() {return price;}
    public void setPrice(Double price) {this.price = price;}
    public String getImg_url() {return img_url;}
    public void setImg_url(String img_url) {this.img_url = img_url;}
    public Instant getDate() {return date;}
    public void setDate(Instant date) {this.date = date;}
    public List<CategoryDTO> getCategories() {return Categories;}
    public void setCategories(List<CategoryDTO> categories) {Categories = categories;}
	  
	  
}
