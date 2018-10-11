package com.osg.app.ws.model.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GameResponseModel {
	
	private int id;
	private int sizex;
	private int sizey;
	private String gamename;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSizex() {
		return sizex;
	}
	public void setSizex(int sizex) {
		this.sizex = sizex;
	}
	public int getSizey() {
		return sizey;
	}
	public void setSizey(int sizey) {
		this.sizey = sizey;
	}
	public String getGamename() {
		return gamename;
	}
	public void setGamename(String gamename) {
		this.gamename = gamename;
	}
	

}
