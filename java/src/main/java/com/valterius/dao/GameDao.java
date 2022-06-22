package com.valterius.dao;

import java.util.List;

import com.valterius.model.Game;
import com.valterius.model.GameWithKeywords;

public interface GameDao {
/*
 * get all (list)
 * get by id
 * add
 * edit
 * delete
 */
	List<Game> getAll();
	Game getGamesById(int gameId);
	Game addGame(GameWithKeywords gameWithKeywords);
	Game editGame(Game game);
	void deleteGame(Game game);
}
