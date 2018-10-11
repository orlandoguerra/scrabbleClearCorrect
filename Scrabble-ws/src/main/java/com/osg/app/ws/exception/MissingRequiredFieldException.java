package com.osg.app.ws.exception;

public class MissingRequiredFieldException extends RuntimeException{

	private static final long serialVersionUID = -4484995921868238454L;
	
	public MissingRequiredFieldException(String message) {
		super(message);
	}



}
