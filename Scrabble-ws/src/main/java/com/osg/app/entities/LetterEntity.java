package com.osg.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="letter")
public class LetterEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="idgame")
	private int idgame;
	@Column(name="letter")
	private String letter;
	@Column(name="positionx")
	private int positionx;
	@Column(name="positiony")
	private int positiony;

	public LetterEntity() {
	}

	public LetterEntity(int id, int idgame, String letter, int positionx, int positiony) {
		this.id = id;
		this.idgame = idgame;
		this.letter = letter;
		this.positionx = positionx;
		this.positiony = positiony;
	}
	
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
