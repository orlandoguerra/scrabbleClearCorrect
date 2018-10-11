package com.osg.app.service;

import java.util.List;

import com.osg.app.dao.GameDAO;
import com.osg.app.dao.GameMySqlDAOImpl;
import com.osg.app.dao.LetterDAO;
import com.osg.app.dao.LetterMySqlDAOImpl;
import com.osg.app.dto.GameDTO;
import com.osg.app.dto.LetterDTO;
import com.osg.app.utils.GameUtils;
import com.osg.app.utils.UtilsURL;
import com.osg.app.ws.exception.InvalidFieldLocationException;
import com.osg.app.ws.model.request.LettersRequestModel;

public class LetterServiceImpl implements LetterService {

	@Override
	public List<LetterDTO> getGameLetters(int gameId) {
		LetterDAO dao = new LetterMySqlDAOImpl();	
		return dao.getGameLetters(gameId);
	}

	@Override
	public int saveLetter(LetterDTO dto) {
		LetterDAO dao = new LetterMySqlDAOImpl();	
		return dao.saveLetter(dto);
	}

	@Override
	public void validateLetters(int gameid, LettersRequestModel[] letters) {
		GameDAO daoGame = new GameMySqlDAOImpl();
		GameDTO dtog =  daoGame.getGame(gameid);
		String[][] array = retrieveFilledDashboard(gameid,dtog);
		
		if(letters.length < 2) {
			throw new InvalidFieldLocationException("Provide at least 2 values");
		}
		
		int horizontal = -1;
		int vertical = -1;
		boolean horizontalDir = true;
		boolean verticalDir = true;
		int minHorizontal = -1;
		int minVertical = -1;
		
		for (LettersRequestModel lettersRequestModel : letters) {
			if(horizontal != -1 && horizontal != lettersRequestModel.getPositionx()) {
				horizontalDir = false;
			}
			if(vertical != -1 && vertical != lettersRequestModel.getPositiony()) {
				verticalDir = false;
			}
			
			if(minHorizontal == -1 || lettersRequestModel.getPositionx()  < minHorizontal ) {
				minHorizontal = lettersRequestModel.getPositionx();
			}
			
			if(minVertical == -1 || lettersRequestModel.getPositionx()  < minVertical ) {
				minVertical = lettersRequestModel.getPositionx();
			}
			
			horizontal = lettersRequestModel.getPositionx();
			vertical = lettersRequestModel.getPositiony();
			
			if(lettersRequestModel.getPositionx() >= dtog.getSizex() 
			|| lettersRequestModel.getPositiony() >= dtog.getSizey()
			|| lettersRequestModel.getPositionx() < 0
			|| lettersRequestModel.getPositiony() < 0) {
				throw new InvalidFieldLocationException("Incorrect location min or max dashboard size");
			}
			String value = array[lettersRequestModel.getPositiony()][lettersRequestModel.getPositionx()];
			if(!"".equals(value)) {
				throw new InvalidFieldLocationException("Space already used");
			}
			
			array[lettersRequestModel.getPositiony()][lettersRequestModel.getPositionx()] = 
					lettersRequestModel.getLetter();
			
		}
		
		if(!horizontalDir && !verticalDir) {
			throw new InvalidFieldLocationException("The values should be in the same line");
		}
		
		printArray(array);
		
		String word = createWord(array,minHorizontal,minVertical,horizontalDir,dtog.getSizex(),dtog.getSizey());
		
		boolean isWord = UtilsURL.validateWordBighugelabs(word);
		if(!isWord) {
			throw new InvalidFieldLocationException("This is not a valid word:"+word);
		}
	}
	
	private void printArray(String[][] multi) {
		 for(int i=0; i<multi.length; i++) {
		        for(int j=0; j<multi[i].length; j++) {
		        	System.out.print(multi[i][j]+ "|");
		        }
		        System.out.println("");
		    }
	}
	
	public String createWord(String[][] array, int minHorizontal,int minVertical, boolean isHorizontal,
			int maxX, int maxY) {
		
		System.out.println("--------------------------");
		printArray(array);
		StringBuilder sb = new StringBuilder();
		int x = minHorizontal;
		int y = minVertical;
		boolean searchnext = true;

		System.out.println(isHorizontal);
		
		while(searchnext) {
			System.out.println(array[x][y] + " X:"+x+" Y:"+y);
			sb.append(array[x][y]);
			if(isHorizontal) {
				x++;
			}else {
				y++;
			}
			if(x>= maxX || y >= maxY) {
				searchnext = false;
			}
			
		//	if("".equals(array[x][y])) {
		//		searchnext = false;
		//	}
		}
		return sb.toString();
	}
	
	public String[][] retrieveFilledDashboard(int gameid,GameDTO dtog){
		String[][] array = GameUtils.createEmptyArray(dtog.getSizex(),dtog.getSizey());
		LetterDAO dao = new LetterMySqlDAOImpl();
		List<LetterDTO> lettersLoaded = dao.getGameLetters(gameid);
		for (LetterDTO letterDTO : lettersLoaded) {
			array[letterDTO.getPositiony()][letterDTO.getPositionx()] = letterDTO.getLetter();
		}	
		return array;
	}
	
	

}
