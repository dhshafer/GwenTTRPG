package com.valterius.dao;

import java.util.List;

import com.valterius.model.Keyword;

public interface KeywordDao {
	/*
	 * get all (list)
	 * get by id
	 * add
	 * edit
	 * delete
	 */
	List<Keyword> getAllKeywords();
	Keyword getKeywordById(int keywordId);
	Keyword addKeyword(Keyword keyword);
	Keyword editKeyword(Keyword keyword);
	void deleteKeyword(Keyword keyword);
}
