
package com.devsuperior.dsCatalog.Service.exceptions;

public class DatabaseException extends RuntimeException{
    private static final long serialVersionUID = 1L;

	//Construtor
	public  DatabaseException(String msg) {
		super(msg);
		
	}
}
