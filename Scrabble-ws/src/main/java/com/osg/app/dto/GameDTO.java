package com.osg.app.dto;

import java.io.Serializable;

public class GameDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
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
