package com.osg.app.ws.model.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LetterResponseModel {
	
	private int id;
	private int idgame;
	private String letter;
	private int positionx;
	private int positiony;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdgame() {
		return idgame;
	}
	public void setIdgame(int idgame) {
		this.idgame = idgame;
	}
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
