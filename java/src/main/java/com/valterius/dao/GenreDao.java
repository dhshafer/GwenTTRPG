package com.valterius.dao;

import java.util.List;

import com.valterius.model.Genre;

public interface GenreDao {
	/*
	 * get all (list)
	 * get by id
	 * add
	 * edit
	 * delete
	 */
	List<Genre> getAllGenres();
	Genre getGenreById(int genreId);
	Genre addGenre(Genre genre);
	Genre editGenre(Genre genre);
	void deleteGenre(Genre genre);
}
