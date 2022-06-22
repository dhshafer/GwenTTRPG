package com.valterius.dao;

import java.util.List;

import com.valterius.model.GameWithKeywords;

public interface GameWithKeywordsDao {
	
	/*
	 * get all (list)
	 * get by id
	 * add
	 * edit
	 * delete
	 */
	
	List<GameWithKeywords> getListByGameId(int gameId);
	void addGamesKeywords(GameWithKeywords gamesKeywords);
	void deleteGamesKeywords(GameWithKeywords gamesKeywords);
	void deleteByKeywordId(int keywordId);
	
}
