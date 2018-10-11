package com.osg.app.dao;

import java.util.List;

import com.osg.app.dto.LetterDTO;

public interface LetterDAO {
	
	public List<LetterDTO> getGameLetters(int gameId);
	
	public int saveLetter(LetterDTO dto);

}
