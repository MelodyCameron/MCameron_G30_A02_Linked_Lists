package linked_list_testing;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

	
	
	
	@Test
	void defaultConstructorTest() {
		linked_list.Player p1 = new linked_list.Player();
		assertEquals("Player", p1.getName(), "Default Constructor Test - getName()");
		assertEquals(0, p1.getGamesPlayed(), "Default Constructor Test - getGamesPlayed()");
		assertEquals(0, p1.getGamesWon(), "Default Constructor Test - getGamesWon()");
	}
	
	
	@Test
	void ConstructorWithNameTest() {
		linked_list.Player p2 = new linked_list.Player("Richard");
		assertEquals("Richard", p2.getName(), "Constructor with Name Test - getName()");
		assertEquals(0, p2.getGamesPlayed(), "Constructor with Name Test - getGamesPlayed()");
		assertEquals(0, p2.getGamesWon(), "Constructor with Name Test - getGamesWon()");
		
	}
	
	@Test
	void mutatorsTest() {
		linked_list.Player p3 = new linked_list.Player("Richard");
		p3.setGamesPlayed(p3.getGamesPlayed()+1);
		p3.setGamesWon(p3.getGamesWon()+1);
		assertEquals(1, p3.getGamesPlayed(), "Mutators Test - setGamesPlayed()");
		assertEquals(1, p3.getGamesWon(), "Mutators Test - setGamesWon()");
		
	}
}
