package com.devsuperior.dsCatalog.entidade;

import java.io.Serializable;
import java.util.Objects;

public class Categoria implements Serializable{
	
	

	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String name;
	
	
	public Categoria() {}
	
	public Categoria(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(int i) {
		this.id = (long) i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", name=" + name + "]";
	}
	
	

	
	
	
	
}
