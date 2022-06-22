package com.valterius.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.valterius.dao.GameDao;
import com.valterius.model.Game;
import com.valterius.model.GameWithKeywords;
import com.valterius.model.Keyword;

@CrossOrigin
@RestController
public class GameController {

		@Autowired
		private GameDao gamesDao;
		
		public GameController(GameDao gamesDao) {
			this.gamesDao = gamesDao;
		}
		
		@RequestMapping(path = "/games", method = RequestMethod.GET)
		public List<Game> getAll(){
			
			GameWithKeywords myGameWithKeywords = new GameWithKeywords();
			Game myGame = new Game();
			
			myGame.setName("Game One");
			myGame.setSourceUrl("www.helloworld.com");
			myGame.setPublisherId(1);
			myGame.setGenreId(1);
			myGame.setMechanicId(1);
			
			List<Keyword> keywords = new ArrayList<>();
			Keyword keywordOne = new Keyword();
			keywordOne.setId(1);
			keywords.add(keywordOne);
			
			myGameWithKeywords.setGame(myGame);
			myGameWithKeywords.setSelectedKeywords(keywords);
			
			gamesDao.addGame(myGameWithKeywords);
			
			
			
			return gamesDao.getAll();
		}
		
}
