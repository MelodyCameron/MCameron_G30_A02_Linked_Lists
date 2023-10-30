package linked_list;

import java.io.Serializable;

public class Player implements Serializable {

	private String name;
	private int gamesPlayed;
	private int gamesWon;
	
	
	public Player() {
		gamesPlayed = 0;
		gamesWon = 0;
	}
	
	public Player (String n) {
		name = n;
		gamesPlayed = 0;
		gamesWon = 0;
	}
	
	public void setGamesPlayed(int games)
	{
		gamesPlayed = games;
	}
	
	public void setGamesWon (int games) {
		gamesWon = games;
	}
	
	
	public String getName() {
		return name;
	}
	
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	
	public int getGamesWon() {
		return gamesWon;
	}
}
