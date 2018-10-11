package com.osg.app.ws.entrypoint;

import java.util.ArrayList;
import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.BeanUtils;

import com.osg.app.dto.GameDTO;
import com.osg.app.dto.LetterDTO;
import com.osg.app.service.GameService;
import com.osg.app.service.GameServiceImpl;
import com.osg.app.service.LetterService;
import com.osg.app.service.LetterServiceImpl;
import com.osg.app.utils.GameUtils;
import com.osg.app.ws.model.request.GameLettersRequestModel;
import com.osg.app.ws.model.request.GameRequestModel;
import com.osg.app.ws.model.request.LettersRequestModel;
import com.osg.app.ws.model.response.GameResponseModel;
import com.osg.app.ws.model.response.LetterResponseModel;
import com.osg.app.ws.model.response.SimpleResponseModel;

@Path("/game")
public class GamesEntryPoint {
	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GameResponseModel createGame(GameRequestModel model) {
		GameDTO gameDto = new GameDTO();
		BeanUtils.copyProperties(model, gameDto);
		GameService gameService = new GameServiceImpl();
		int id = gameService.createGame(gameDto);
		GameResponseModel modelresp = new GameResponseModel();
		BeanUtils.copyProperties(gameDto, modelresp);
		modelresp.setId(id);
		return modelresp;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<GameResponseModel> getGames() {
		List<GameResponseModel> response = new ArrayList<GameResponseModel>();
		GameService service = new GameServiceImpl();
		List<GameDTO> res = service.getGames();
		for (GameDTO games : res) {
			GameResponseModel modelresp = new GameResponseModel();
			BeanUtils.copyProperties(games, modelresp);
			response.add(modelresp);
		}
		return response;
	}
	
	@GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_HTML)
    public String getUserProfile(@PathParam("id")int id){
		GameService service = new GameServiceImpl();
		String returnInfo = service.generateDashboard(id);
        return returnInfo;
    }
	
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GameResponseModel updateGame(@PathParam("id") int id,GameRequestModel model) {
		GameService service = new GameServiceImpl();
		GameDTO gameDto = service.getGame(id);
		gameDto.setGamename(model.getGamename());
		BeanUtils.copyProperties(model, gameDto);
		service.updateGame(gameDto);
		GameResponseModel returnValue = new GameResponseModel();
		BeanUtils.copyProperties(gameDto, returnValue);
		return returnValue;
	}
	
	@POST
	@Path("/{id}/letter")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GameResponseModel createGame(@PathParam("id")int gameid, GameLettersRequestModel model) {
		GameResponseModel modelresp = new GameResponseModel();
		LettersRequestModel[] letters = model.getLetters();
		LetterService service = new LetterServiceImpl();
		service.validateLetters(gameid,letters);
		for (LettersRequestModel lettersRequestModel : letters) {
			LetterDTO dto = new LetterDTO();
			BeanUtils.copyProperties(lettersRequestModel, dto);
			dto.setIdgame(gameid);
			service.saveLetter(dto);
		}
		return modelresp;
	}
	
	@DELETE
    @Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public SimpleResponseModel deleteGame(@PathParam("id") int id) {
		GameService service = new GameServiceImpl();
		SimpleResponseModel model = new SimpleResponseModel();
		service.deleteGame(id);
        return model;
    }

}
