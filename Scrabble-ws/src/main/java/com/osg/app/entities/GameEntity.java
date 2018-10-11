package com.osg.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="game")
public class GameEntity {
	
	public GameEntity(int id, int sizex, int sizey, String gamename) {
		this.id = id;
		this.sizex = sizex;
		this.sizey = sizey;
		this.gamename = gamename;
	}
	
	
	
	public GameEntity() {
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="sizex")
	private int sizex;
	
	@Column(name="sizey")
	private int sizey;
	
	@Column(name="gamename")
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
