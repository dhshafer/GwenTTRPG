package com.valterius.model;

import java.util.List;

public class GameWithKeywords {
	private Game game;
	private List<Keyword> availableKeywords;
	private List<Keyword> selectedKeywords;
	
	
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public List<Keyword> getAvailableKeywords() {
		return availableKeywords;
	}
	public void setAvailableKeywords(List<Keyword> availableKeywords) {
		this.availableKeywords = availableKeywords;
	}
	public List<Keyword> getSelectedKeywords() {
		return selectedKeywords;
	}
	public void setSelectedKeywords(List<Keyword> selectedKeywords) {
		this.selectedKeywords = selectedKeywords;
	}
	
}
