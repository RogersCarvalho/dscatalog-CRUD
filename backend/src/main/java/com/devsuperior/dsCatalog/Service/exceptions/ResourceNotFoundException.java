
package com.devsuperior.dsCatalog.Service.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	//Construtor
	public  ResourceNotFoundException(String msg) {
		super(msg);
		
	}
}
