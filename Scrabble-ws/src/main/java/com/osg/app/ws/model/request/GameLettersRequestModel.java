package com.osg.app.ws.model.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GameLettersRequestModel {

	private LettersRequestModel[] letters;
	
	public LettersRequestModel[] getLetters() {
		return letters;
	}
	public void setLetters(LettersRequestModel[] letters) {
		this.letters = letters;
	}
	

}
