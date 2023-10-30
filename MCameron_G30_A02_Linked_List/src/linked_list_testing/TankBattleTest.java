package linked_list_testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TankBattleTest {
	linked_list.SinglyLinkedList<Character> word = new linked_list.SinglyLinkedList<Character>();
	linked_list.SinglyLinkedList<Character> answer = new linked_list.SinglyLinkedList<Character>();

	@Test
	void constructorWithParametersTest() {
		word.add('!');
		word.add('_');
		word.add('_');
		word.add('_');
		word.add('_');
		word.add('_');
		word.add('_');
		answer.add('!');
		answer.add('l');
		answer.add('a');
		answer.add('i');
		answer.add('r');
		answer.add('e');
		answer.add('s');
		linked_list.TankBattle t1 = new linked_list.TankBattle(word, answer, "Richard");
		for (int i = 0; i < word.getLength(); i++) {
			assertEquals(word.getElementAt(i), t1.getWord().getElementAt(i), "");
			assertEquals(answer.getElementAt(i), t1.getAnswer().getElementAt(i), "");
			assertEquals("Richard", t1.getPlayerName(), "");
			assertEquals(6, t1.getHpBlue(), "");
			assertEquals(word.getLength(), t1.getHpRed(), "");
		}
	}

	@Test
	void hitBlueAndRedTest() {
		linked_list.TankBattle t2 = new linked_list.TankBattle(word, answer, "Richard");
		int testBlue = t2.getHpBlue() - 1;
		int testRed = t2.getHpRed() - 1;
		t2.hitBlue();
		t2.hitRed();
		assertEquals(testBlue, t2.getHpBlue(), "");
		assertEquals(testRed, t2.getHpRed(), "");
	}

	@Test
	void askForHintTest() {
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
		linked_list.TankBattle t3 = new linked_list.TankBattle(word, answer, "Richard");
		char result = t3.askForHint();
		assertTrue(result == 's' || result == 'e' || result == 'r' || result == 'i' || result == 'a' || result == 'l');
	}

	@Test
	void checkGuessTest() {
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
		linked_list.TankBattle t4 = new linked_list.TankBattle(word, answer, "Richard");
		assertEquals(0, t4.checkGuess('i'), "");
		assertEquals(-1, t4.checkGuess('Y'), "");
	}

	@Test
	void addGuessTest() {
		linked_list.TankBattle t5 = new linked_list.TankBattle(word, answer, "Richard");
		t5.addGuess('Z');
		assertThrows(IndexOutOfBoundsException.class, () -> {
			boolean found = false;
			for (int i = 0; i < t5.getGuesses().getLength() && !found; i++) {
				if (t5.getGuesses().getElementAt(i) == 'Y')
					found = true;
			}
			if (!found)
				throw new IndexOutOfBoundsException();
		});
	}

	@Test
	void resetGuessesTest() {
		linked_list.TankBattle t6 = new linked_list.TankBattle(word, answer, "Richard");
		t6.addGuess('p');
		t6.addGuess('y');
		t6.addGuess('z');
		linked_list.SinglyLinkedList<Character> testGuesses = t6.getGuesses();
		t6.resetGuesses();
		assertThrows(IndexOutOfBoundsException.class, () -> {
			try {
			t6.getGuesses().getElementAt(1);
			}
			catch (IndexOutOfBoundsException e)
			{
				throw new IndexOutOfBoundsException();
			}
		});
	}

	@Test
	void addCompletedWordTest() {
		linked_list.TankBattle t7 = new linked_list.TankBattle(word, answer, "Richard");
		t7.addCompletedWord("bottom");

		assertEquals("bottom", t7.getCompletedWords().getElementAt(0), "");
	}

}
