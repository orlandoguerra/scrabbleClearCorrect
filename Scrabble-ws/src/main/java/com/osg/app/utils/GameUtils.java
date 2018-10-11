package com.osg.app.utils;

import com.osg.app.dto.GameDTO;
import com.osg.app.ws.exception.MissingRequiredFieldException;

public class GameUtils {
	
	public void validateGame(GameDTO game) {
		
		if(game.getGamename() ==null || game.getGamename().isEmpty()) {
			throw new MissingRequiredFieldException(ErrorMessages.MISSING_REQUIRED_FILED);
		}
		
	}
	
	public static String generateHTMLBoard(String[][] multi) {
		StringBuilder sb = new StringBuilder();
		sb.append("<table border=1>");
		for(int i=0; i<multi.length; i++) {
			sb.append("<tr>");
	        for(int j=0; j<multi[i].length; j++) {
	        	sb.append("<td>&nbsp;&nbsp;");
	        	sb.append(multi[i][j]);
	        	sb.append("".equals(multi[i][j])?"&nbsp;&nbsp;":"&nbsp;");
	        	sb.append("</td>");
	        }
	        sb.append("<tr>");
	    }
		sb.append("</table>");
		return sb.toString();
	}
	
	public static String[][] createEmptyArray(int x, int y){
		String[][] multi = new String[y][x];
		 for(int i=0; i<multi.length; i++) {
	        for(int j=0; j<multi[i].length; j++) {
	        	multi[i][j] = "";
	        }
	    }
		return multi;
	}

}
