package com.osg.app.service;

import java.util.List;

import com.osg.app.dto.LetterDTO;
import com.osg.app.ws.model.request.LettersRequestModel;

public interface LetterService {
	
	public List<LetterDTO> getGameLetters(int gameId);
	
	public int saveLetter(LetterDTO dto);
	
	public void validateLetters(int gameid, LettersRequestModel[] letters);

}
