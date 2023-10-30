package linked_list_testing;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScoreboardTest {

	@Test
	void constructorTest() {
		linked_list.Scoreboard s1 = new linked_list.Scoreboard();
		assertEquals(0, s1.getNumPlayers(), "Constructor Test - Scoreboard()");
	}
	
	@Test
	void addPlayerTest() {
		linked_list.Scoreboard s2 = new linked_list.Scoreboard();
		s2.addPlayer("Richard");
		assertEquals("Richard", s2.getPlayer(0).getName(), "addPlayer Test in empty list - addPlayer()");
	}
	
	@Test
	void addPlayerTest_2() {
		linked_list.Scoreboard s3 = new linked_list.Scoreboard();
		s3.addPlayer("Richard");
		s3.addPlayer("Christine");
		s3.addPlayer("Katrina");
		s3.addPlayer("Adewole");
		//the player object with the name "Adewole" is added to the beginning of the list, therefore it's index in the list is 0
		assertEquals("Adewole", s3.getPlayer(0).getName(), "addPlayer Test in a list with more than 1 player - addPlayer()");
	}
	
	@Test
	void gamePlayedTest_win() {
		linked_list.Scoreboard s4 = new linked_list.Scoreboard();
		s4.addPlayer("Richard");
		s4.addPlayer("Christine");
		s4.addPlayer("Katrina");
		s4.addPlayer("Adewole");
		s4.gamePlayed("Katrina", true);
		//1 is the index for the player object with the name "Katrina"
		assertEquals(1, s4.getPlayer(1).getGamesPlayed(), "gamePlayed Test gamesPlayed [when player wins] - gamePlayed()");
		assertEquals(1, s4.getPlayer(1).getGamesWon(), "gamePlayed Test gamesWon [when player wins] - gamePlayed()");
	}
	
	@Test
	void gamePlayedTest_lose() {
		linked_list.Scoreboard s5 = new linked_list.Scoreboard();
		s5.addPlayer("Richard");
		s5.addPlayer("Christine");
		s5.addPlayer("Katrina");
		s5.addPlayer("Adewole");
		s5.gamePlayed("Katrina", false);
		//1 is the index for the player object with the name "Katrina"
		assertEquals(1, s5.getPlayer(1).getGamesPlayed(), "gamePlayed Test gamesPlayed [when player loses] - gamePlayed()");
		assertEquals(0, s5.getPlayer(1).getGamesWon(), "gamePlayed Test gamesWon [when player loses] - gamePlayed()");
	}
	
	@Test
	void gamePlayedTest_notFound() {
		linked_list.Scoreboard s6 = new linked_list.Scoreboard();
		s6.addPlayer("Richard");
		s6.addPlayer("Christine");
		s6.addPlayer("Katrina");
		s6.addPlayer("Adewole");
		assertThrows(IndexOutOfBoundsException.class, () -> {
			s6.getPlayer(4).getName();
		});
	}
	
	@Test
	void getPlayerTest_emptyList()
	{
		linked_list.Scoreboard s7 = new linked_list.Scoreboard();
		assertThrows(IndexOutOfBoundsException.class, () -> {
			s7.getPlayer(0);
		});
	}
	
	@Test 
	void getPlayerTest_listOf1() {
		linked_list.Scoreboard s8 = new linked_list.Scoreboard();
		s8.addPlayer("Richard");
		//since there's only 1 object in the list, the player is at index 0
		assertEquals("Richard", s8.getPlayer(0).getName(), "getPlayer Test [list of 1] - getPlayer()");	
	}
	
	@Test
	void getPlayerTest_listOf3() {
		linked_list.Scoreboard s9 = new linked_list.Scoreboard();
		s9.addPlayer("Richard");
		s9.addPlayer("Christine");
		s9.addPlayer("Katrina");
		
		//Testing with christine, so theindex of the player object with that name is 1
		assertEquals("Christine", s9.getPlayer(1).getName(), "getPlayer Test [list of 3] - getPlayer()");
	}
	
}
