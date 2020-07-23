package com.training.common.service.excp;

public class BaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BaseException () {
		
		super();
	}
	
	
	public BaseException(String errorMessage) {
		
		super(errorMessage);
	}
	
	

}
