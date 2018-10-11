package com.osg.app.ws.model.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SimpleResponseModel {
	
	private String success;
	private String message;
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
}
