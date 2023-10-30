package linked_list_testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class DictionaryTest {

	@Test
	void validateWordTest() {
		linked_list.Dictionary d1 = new linked_list.Dictionary();
		assertEquals(true, d1.validateWord("bottom"), "validateWord test - valid word");
		assertEquals(false, d1.validateWord("deadmau5"), "validateWord test - word contains a digit");
		assertEquals(false, d1.validateWord("is"), "validateWord test - word's length is less than 3");
		assertEquals(false, d1.validateWord("good appreciation!"),
				"validateWord test - word's length is greater than 16");
	}

	@Test
	void setWordTest() {
		linked_list.Dictionary d2 = new linked_list.Dictionary();
		linked_list.SinglyLinkedList<Character> testWord = new linked_list.SinglyLinkedList<Character>();
		testWord.add('!');
		testWord.add('_');
		testWord.add('_');
		testWord.add('_');
		testWord.add('_');
		testWord.add('_');
		testWord.add('_');

		d2.setWord("serial!");
		for (int i = 0; i < d2.getWord().getLength(); i++) {
			assertEquals(testWord.getElementAt(i), d2.getWord().getElementAt(i), "setWord test");
		}
	}

	@Test
	void setAnswerTest() {
		linked_list.Dictionary d3 = new linked_list.Dictionary();
		linked_list.SinglyLinkedList<Character> testWord = new linked_list.SinglyLinkedList<Character>();
		testWord.add('!');
		testWord.add('a');
		testWord.add('g');
		testWord.add('n');
		testWord.add('i');
		testWord.add('z');
		testWord.add('a');
		testWord.add('b');
		d3.setAnswer("bazinga!");
		for (int i = 0; i < d3.getAnswer().getLength(); i++) {
			assertEquals(testWord.getElementAt(i), d3.getAnswer().getElementAt(i), "setAnswer test");
		}
	}

	@Test
	void removeWord() {
		linked_list.Dictionary d4 = new linked_list.Dictionary();
		linked_list.SinglyLinkedList<String> testList = d4.getWordsList();
		d4.removeWord("crisp");
		System.out.println(testList.getLength());
		System.out.println(d4.getWordsListLength());

		assertThrows(NullPointerException.class, () -> {
			boolean found = false;
			for (int i = 0; i < d4.getWordsListLength() && !found; i++) {
				if (d4.getWordsList().getElementAt(i).equals("crisp"))
					found = true;
			}
			if (!found)
				throw new NullPointerException();
		});
	}
}