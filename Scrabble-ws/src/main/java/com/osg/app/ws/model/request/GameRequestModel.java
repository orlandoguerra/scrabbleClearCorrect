package com.osg.app.ws.model.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GameRequestModel {
	
	private int sizex;
	private int sizey;
	private String gamename;
	
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
