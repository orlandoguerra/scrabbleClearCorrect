package com.osg.app.dao;

import java.util.List;

import com.osg.app.dto.GameDTO;

public interface GameDAO {
	
	
	public List<GameDTO> getGames();
	
	public GameDTO getGame(int id);
	
	public void deleteGame(int id);
	
	public int createGame(GameDTO game);
	
	public void updateGame(GameDTO game);
	
}
