package linked_list;

import java.io.*;
import java.util.Scanner;

public class Dictionary {

	private File dictionary = new File("word_db.txt");
	private Scanner scanner;
	private SinglyLinkedList<String> wordsList = new SinglyLinkedList<String>();
	private SinglyLinkedList<Character> word = new SinglyLinkedList<Character>();
	private SinglyLinkedList<Character> answer = new SinglyLinkedList<Character>();

	public Dictionary() {
		try {
			readFile();
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		}
	}// Dictionary()

	private void readFile() throws FileNotFoundException {
		scanner = new Scanner(dictionary);
		while (scanner.hasNextLine()) {
			String wrd = scanner.nextLine();
			if (validateWord(wrd)) {
				wordsList.add(wrd.toUpperCase());
			} // if
		} // while loop
		scanner.close();
	}// readFile()

	public boolean validateWord(String wrd) {
		for (int i = 0; i < wrd.length(); i++) {
			if (Character.isDigit(wrd.charAt(i)) || wrd.length() < 3 || wrd.length() > 16)
				return false;
		} // for loop
		return true;
	}// validateWord(String)

	public SinglyLinkedList<String> getWordsList() {
		return wordsList;
	}// getWordsList()

	public void startRound() {
		int randomWordIndex = (int) (Math.random() * getWordsListLength());
		if (word.getLength() > 0) {
			for (int i = 0; i < word.getLength(); i++) {
				word.remove(i);
				answer.remove(i);
			} // for loop
		} // if
		setWord(wordsList.getElementAt(randomWordIndex));
		setAnswer(wordsList.getElementAt(randomWordIndex));
	}// startRound()

	public void setWord(String wrd) {
		word = new SinglyLinkedList<Character>();
		for (int i = wrd.length() - 1; i >= 0; i--) {
			if (Character.isLetter(wrd.charAt(i)))
				word.add('_');
			else
				word.add(wrd.charAt(i));
		} // for loop
	}// setWord(String)

	public SinglyLinkedList<Character> getWord() {
		return word;
	}// getWord()

	public void setAnswer(String ans) {
		answer = new SinglyLinkedList<Character>();
		for (int i = ans.length() - 1; i >= 0; i--)
			answer.add(ans.charAt(i));
	}// setAnswer(String)

	public SinglyLinkedList<Character> getAnswer() {
		return answer;
	}// getAnswer()

	public int getWordsListLength() {
		return wordsList.getLength();
	}// getWordsListLength()

	public void removeWord(String wrd) {
		for (int i = 0; i < wordsList.getLength(); i++) {
			if (wordsList.getElementAt(i).equals(wrd))
				wordsList.remove(i);
		} // for loop
	}// removedWord(String)
}// Dictionary class