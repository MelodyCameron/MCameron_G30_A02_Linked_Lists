package linked_list;

import java.io.*;

public class TankBattle implements Serializable {

	private SinglyLinkedList<Character> word;
	private SinglyLinkedList<String> completedWords;
	private SinglyLinkedList<Character> answer;
	private int hpBlue;
	private int hpRed;
	private SinglyLinkedList<Character> hints;
	private SinglyLinkedList<Character> guesses;
	private String playerName;
	static TankBattle tank;

	public TankBattle() {
	}// TankBattle()

	public TankBattle(SinglyLinkedList<Character> wrd, SinglyLinkedList<Character> ans, String name) {
		word = wrd;
		answer = ans;
		completedWords = new SinglyLinkedList<String>();
		hints = new SinglyLinkedList<Character>();
		guesses = new SinglyLinkedList<Character>();
		playerName = name;
		hpBlue = 6;
		hpRed = wrd.getLength();
	}// TankBattle(SinglyLinkedList<Character>, SinglyLinkedList<Character>, String)

	public SinglyLinkedList<Character> getWord() {
		return word;
	}// getWord()

	public String getWordString() {
		String wordString = "";
		for (int i = 0; i < word.getLength(); i++)
			wordString = wordString + "" + word.getElementAt(i) + " ";
		return wordString;
	}// getWordString()

	public SinglyLinkedList<Character> getAnswer() {
		return answer;
	}// getAnswer()

	public String getAnswerString() {
		String answerString = "";
		for (int i = 0; i < answer.getLength(); i++)
			answerString = answerString + "" + answer.getElementAt(i);
		return answerString;
	}// getAnswerString()

	public String getPlayerName() {
		return playerName;
	}// getPlayerName()

	public int getHpBlue() {
		return hpBlue;
	}// getHpBlue()

	public int getHpRed() {
		return hpRed;
	}// getHpRed()

	public void hitBlue() {
		--hpBlue;
	}// hitBlue()

	public void hitRed() {
		--hpRed;
	}// hitRed()

	public char askForHint() {
		int idx = 0;
		for (int i = 0; i < word.getLength(); i++) {
			if (word.getElementAt(i) == '_')
				++idx;
		} // for loop
		int randomLetterIndex = (int) (Math.random() * answer.getLength());
		char letter = answer.getElementAt(randomLetterIndex);
		if (letter == word.getElementAt(randomLetterIndex))
			askForHint();
		hints.add(letter);
		SinglyLinkedList<Integer> indexesOfLetter = new SinglyLinkedList<Integer>();
		if (letter != word.getElementAt(randomLetterIndex)) {
			for (int i = 0; i < word.getLength(); i++) {
				if (letter == answer.getElementAt(i))
					indexesOfLetter.add(i);
			} // for loop
			for (int j = 0; j < indexesOfLetter.getLength(); j++) {
				word.remove(indexesOfLetter.getElementAt(j));
				word.add(answer.getElementAt(indexesOfLetter.getElementAt(j)), indexesOfLetter.getElementAt(j));
				hitRed();
			} // for loop
			hitBlue();
		} // if
		return letter;
	}// askForHint()

	public SinglyLinkedList<Character> getHints() {
		return hints;
	}// getHints()

	public int checkGuess(char guess) {
		System.out.println(guess);
		int inWord = -1;
		for (int i = 0; i < answer.getLength(); i++) {
			if (answer.getElementAt(i) == guess) {
				word.remove(i);
				word.add(guess, i);
				System.out.println("Word String: " + getWordString());
				hitRed();
				inWord = 0;
			} // if
		} // for loop
		if (inWord == -1) {
			hitBlue();
			addGuess(guess);
		} // if
		return inWord;
	}// checkGuess(char)

	public void addGuess(char guess) {
		guesses.add(guess);
	}// addGuess(char)

	public SinglyLinkedList<Character> getGuesses() {
		return guesses;
	}// getGuesses()

	public void resetGuesses() {
		for (int i = 0; i < guesses.getLength(); i++)
			guesses.remove(i);
	}// resetGuesses()

	public void addCompletedWord(String wrd) {
		completedWords.add(wrd);
	}// addCompletedWord(String)

	public SinglyLinkedList<String> getCompletedWords() {
		return completedWords;
	}// getCompleteWords()
}// TankBattle class