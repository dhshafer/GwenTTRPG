package com.valterius.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.valterius.model.Game;
import com.valterius.model.GameWithKeywords;
import com.valterius.model.Keyword;

@Component
public class JdbcGameDao implements GameDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Game> getAll() {
		String sql = "SELECT * FROM games";
		// finds rows in database from query
		SqlRowSet resultSet = jdbcTemplate.queryForRowSet(sql);
		List<Game> results = new ArrayList<>();
		
		while(resultSet.next()) {
		// takes data from rows and places into object
			results.add(mapRowToGames(resultSet));
		}
		// returns a list of objects
		return results;
	}

	@Override
	public Game getGamesById(int gameId) {
		String sql = "SELECT * FROM games WHERE id = ?";
		SqlRowSet resultSet = jdbcTemplate.queryForRowSet(sql, gameId);
		
		if(resultSet.next()) {
			return mapRowToGames(resultSet);
		}
//TODO - Should method return null if conditional does not work?
		return null;
	}

	@Override
	public Game addGame(GameWithKeywords gameWithKeywords) {
		String sql = "INSERT INTO games VALUES (default, ?, ?, ?, ?, ?) returning id";
		// takes data from parameter object and uses for sql, then queries for id and stores into new variable
		int returnedId = jdbcTemplate.queryForObject(sql, int.class, gameWithKeywords.getGame().getName(), gameWithKeywords.getGame().getSourceUrl(), gameWithKeywords.getGame().getPublisherId(),
						gameWithKeywords.getGame().getGenreId(), gameWithKeywords.getGame().getMechanicId());
				gameWithKeywords.getGame().setId(returnedId);
//TODO - When a game is created, it needs to be associated with the keywords table. The id should be added to the GamesKeywords table
		
			for(Keyword keyword: gameWithKeywords.getSelectedKeywords()) {
				String keywordSql = "INSERT INTO games_keywords VALUES (?, ?)";
				jdbcTemplate.update(keywordSql, gameWithKeywords.getGame().getId(), keyword.getId());
			}
		
		return gameWithKeywords.getGame();
	}

	@Override
	public Game editGame(Game game) {
		String sql = "UPDATE games " +
					"SET name = ?, source_url = ?, publisher_id = ?, genre_id = ?, mechanic_id = ? " +
					"WHERE id = ?";
		int numberUpdatedRows = jdbcTemplate.update(sql, game.getName(), game.getSourceUrl(), game.getPublisherId(),game.getGenreId(), game.getMechanicId(), game.getId());
		
//TODO - remove old keywords from game
		
//TODO - add new keywords to game
		
		//confirms updated game
		Game editedGame = new Game();
		if(numberUpdatedRows == 1) {
			editedGame = getGamesById(game.getId());
		}
		return editedGame;
	}

	@Override
	public void deleteGame(Game game) {
//TODO - delete foreign key locations
		
		String sql = "DELETE FROM games WHERE id = ?";
		jdbcTemplate.update(sql, game.getId());
		
	}
	
	private Game mapRowToGames(SqlRowSet resultSet) {
		Game games = new Game();
		games.setId(resultSet.getInt("id"));
		games.setName(resultSet.getString("name"));
		games.setSourceUrl(resultSet.getString("source_url"));
		games.setPublisherId(resultSet.getInt("publisher_id"));
		games.setGenreId(resultSet.getInt("genre_id"));
		games.setMechanicId(resultSet.getInt("mechanic_id"));
		return games;
	}

}
