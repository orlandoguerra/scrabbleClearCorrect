package com.osg.app.ws.model.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessageResponseModel {
	
	private String errorMessage;
	private String errorMessageKey;
	private String href;
	
	public ErrorMessageResponseModel() { }

	public ErrorMessageResponseModel(String errorMessage, String errorMessageKey, String href) {
		this.errorMessage = errorMessage;
		this.errorMessageKey = errorMessageKey;
		this.href = href;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorMessageKey() {
		return errorMessageKey;
	}
	public void setErrorMessageKey(String errorMessageKey) {
		this.errorMessageKey = errorMessageKey;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
}
