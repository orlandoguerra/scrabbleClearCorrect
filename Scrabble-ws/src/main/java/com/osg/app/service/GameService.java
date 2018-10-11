package com.osg.app.service;

import java.util.List;

import com.osg.app.dto.GameDTO;

public interface GameService {
	
	public int createGame(GameDTO game);
	
	public List<GameDTO> getGames();
	
	public void updateGame(GameDTO game);
	
	public GameDTO getGame(int id);

	public String generateDashboard(int id);
	
	public void deleteGame(int id);

}
