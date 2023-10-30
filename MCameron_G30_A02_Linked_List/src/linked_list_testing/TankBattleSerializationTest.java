package linked_list_testing;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class TankBattleSerializationTest {
 linked_list.SinglyLinkedList<Character> word = new linked_list.SinglyLinkedList<Character>();
 linked_list.SinglyLinkedList<Character> answer = new linked_list.SinglyLinkedList<Character>();	
	@Test
	void SaveAndLoadStateTest() {
		word.add('_');
		word.add('_');
		word.add('_');
		word.add('_');
		word.add('_');
		word.add('_');
		answer.add('l');
		answer.add('a');
		answer.add('i');
		answer.add('r');
		answer.add('e');
		answer.add('s');
		linked_list.TankBattle tb = new linked_list.TankBattle(word, answer, "Richard_JUnit");
		linked_list.TankBattleSerialization ts = new linked_list.TankBattleSerialization();
		ts.saveState(tb);
		tb = ts.loadState("Adewole_JUnit");
		
		assertEquals("Adewole", tb.getPlayerName(), "");
	}
	
	
}
