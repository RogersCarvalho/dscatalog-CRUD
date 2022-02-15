package com.devsuperior.dsCatalog.entidade;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;



@Entity
@Table(name= "tb_category")
public class Categoria implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updatedAt;
	
	public Categoria() {}
	public Categoria(Long id, String name) {this.id = id;this.name = name;}

	public Long getId() {return id;}
    public void setId(int i) {this.id = (long) i;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}


    public Instant getCreatedAt() {return createdAt;}
    public Instant getUpdatedAt() {return updatedAt;}

    @PrePersist
    public void prePersist() {createdAt = Instant.now();}
	@PreUpdate
    public void preUpdate() {updatedAt = Instant.now();}

	
	
	
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
