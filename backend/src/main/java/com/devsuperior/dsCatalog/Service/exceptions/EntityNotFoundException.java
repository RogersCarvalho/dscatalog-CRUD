
package com.devsuperior.dsCatalog.Service.exceptions;

public class EntityNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	//Construtor
	public  EntityNotFoundException(String msg) {
		super(msg);
		
	}
}
