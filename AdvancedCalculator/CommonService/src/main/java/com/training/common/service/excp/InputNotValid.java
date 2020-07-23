package com.training.common.service.excp;

public class InputNotValid extends BaseException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InputNotValid() {
		
		super();
	}
	
	public InputNotValid (String errorMessage) {
		
		super(errorMessage);
	}
}
