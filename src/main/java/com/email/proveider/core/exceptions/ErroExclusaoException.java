package com.email.proveider.core.exceptions;

public class ErroExclusaoException  extends RuntimeException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErroExclusaoException() {
		super();
	}
	
	public ErroExclusaoException(String mesage) {
		super(mesage);
	}
	
	public ErroExclusaoException(String mesage, Throwable cause) {
		super(mesage, cause);
	}

	public ErroExclusaoException(Throwable cause) {
		// TODO Auto-generated constructor stub
	}
}
