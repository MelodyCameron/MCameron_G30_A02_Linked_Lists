package linked_list;

import java.io.Serializable;

public class Player implements Serializable {

	private String name;
	private int gamesPlayed;
	private int gamesWon;

	public Player() {
		name = "Player";
		gamesPlayed = 0;
		gamesWon = 0;
	}// Player()

	public Player(String n) {
		name = n;
		gamesPlayed = 0;
		gamesWon = 0;
	}// Player(String)

	public void setName(String n) {
		name = n;
	}// setName(String)

	public void setGamesPlayed(int games) {
		gamesPlayed = games;
	}// setGamesPlayed(int)

	public void setGamesWon(int games) {
		gamesWon = games;
	}// setGamesWon(int)

	public String getName() {
		return name;
	}// getName()

	public int getGamesPlayed() {
		return gamesPlayed;
	}// getGamesPlayed()

	public int getGamesWon() {
		return gamesWon;
	}// getGamesWon()
}// Player class