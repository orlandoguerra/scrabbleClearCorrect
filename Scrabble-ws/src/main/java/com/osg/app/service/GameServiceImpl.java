package com.osg.app.service;

import java.util.List;

import com.osg.app.dao.GameDAO;
import com.osg.app.dao.GameMySqlDAOImpl;
import com.osg.app.dao.LetterDAO;
import com.osg.app.dao.LetterMySqlDAOImpl;
import com.osg.app.dto.GameDTO;
import com.osg.app.dto.LetterDTO;
import com.osg.app.utils.GameUtils;

public class GameServiceImpl implements GameService {

	@Override
	public int createGame(GameDTO game) {
		GameUtils utils = new GameUtils();
		utils.validateGame(game);
		
		game.setSizex(game.getSizex()==0?15:game.getSizex());
		game.setSizey(game.getSizex()==0?15:game.getSizey());

		GameDAO dao = new GameMySqlDAOImpl();
		return dao.createGame(game);
	}

	@Override
	public List<GameDTO> getGames() {
		GameDAO dao = new GameMySqlDAOImpl();
		return dao.getGames();
	}

	@Override
	public void updateGame(GameDTO game) {
		GameDAO dao = new GameMySqlDAOImpl();
		dao.updateGame(game);
	}

	@Override
	public GameDTO getGame(int id) {
		GameDAO dao = new GameMySqlDAOImpl();
		return dao.getGame(id);
	}
	
	public String generateDashboard(int id) {
		GameDAO daoGame = new GameMySqlDAOImpl();
		GameDTO dtog =  daoGame.getGame(id);
		
		String[][] array = GameUtils.createEmptyArray(dtog.getSizex(),dtog.getSizey());
		LetterDAO dao = new LetterMySqlDAOImpl();
		List<LetterDTO> letters = dao.getGameLetters(id);
		for (LetterDTO letterDTO : letters) {
			array[letterDTO.getPositiony()][letterDTO.getPositionx()] = letterDTO.getLetter();
		}
		String returnInfo  =  GameUtils.generateHTMLBoard(array);
		return returnInfo;
		
	}

	@Override
	public void deleteGame(int id) {
		GameDAO daoGame = new GameMySqlDAOImpl();
		daoGame.deleteGame(id); 
	}
}
