package com.osg.app.ws.model.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LettersRequestModel {
	
	private String letter;
	private int positionx;
	private int positiony;
	
	public String getLetter() {
		return letter;
	}
	public void setLetter(String letter) {
		this.letter = letter;
	}
	public int getPositionx() {
		return positionx;
	}
	public void setPositionx(int positionx) {
		this.positionx = positionx;
	}
	public int getPositiony() {
		return positiony;
	}
	public void setPositiony(int positiony) {
		this.positiony = positiony;
	}

	
}
