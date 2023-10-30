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
		
	}
	
	public TankBattle(SinglyLinkedList<Character> wrd, SinglyLinkedList<Character> ans, String name) {
		word = wrd;
		answer = ans;
		completedWords = new SinglyLinkedList<String>();
		hints = new SinglyLinkedList<Character>();
		guesses = new SinglyLinkedList<Character>();
		playerName = name;
		hpBlue = 6;
		hpRed = wrd.getLength();
	}
	
	
	
	
//	public TankBattle (SinglyLinkedList<Character> wrd, SinglyLinkedList<Character> ans, String name, SinglyLinkedList<Character> g, SinglyLinkedList<String> completed, int blue, int red)
//	{
//		word = wrd;
//		answer = ans;
//		playerName = name;
//		guesses = g;
//		completedWords = completed;
//		hpBlue = blue;
//		hpRed = red;
//		
//	}
	
	public SinglyLinkedList<Character> getWord() {
		return word;
	}
	
	public String getWordString() {
		String wordString = "";
		
		for (int i = 0; i < word.getLength(); i++)
			wordString = wordString +  "" +  word.getElementAt(i)+ " ";
		return wordString;
	}
	
	public SinglyLinkedList<Character> getAnswer() {
		return answer;
	}
	
	
	public String getAnswerString() {
		String answerString = "";
		
		for (int i = 0; i < answer.getLength(); i++)
		{
			answerString = answerString + "" + answer.getElementAt(i);
		}
		return answerString;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	
	public int getHpBlue() {
		return hpBlue;
	}
	
	public int getHpRed() {
		return hpRed;
	}
	
	public void hitBlue() {
		--hpBlue;
	}
	
	public void hitRed() {
		--hpRed;
	}
	
	
	public char askForHint () {
		int idx = 0;
		for (int i = 0; i < word.getLength(); i++)
		{
			if (word.getElementAt(i) == '_')
				++idx;
		}
		
		
		int randomLetterIndex = (int) (Math.random()*answer.getLength());
		char letter = answer.getElementAt(randomLetterIndex);
		if (letter == word.getElementAt(randomLetterIndex))
		{
			askForHint();
		}
		hints.add(letter);
		SinglyLinkedList<Integer> indexesOfLetter = new SinglyLinkedList<Integer>();
		
		if (letter != word.getElementAt(randomLetterIndex)) {
		
		for (int i = 0; i < word.getLength(); i++)
		{
			if (letter == answer.getElementAt(i))
				indexesOfLetter.add(i);
		}
		
		for (int j = 0; j < indexesOfLetter.getLength(); j++)
		{
			word.remove(indexesOfLetter.getElementAt(j));
			word.add(answer.getElementAt(indexesOfLetter.getElementAt(j)), indexesOfLetter.getElementAt(j));
			hitRed();
		}
		
		hitBlue();
		}
		return letter;
		
	}
	
	public SinglyLinkedList<Character> getHints() {
		return hints;
	}
	
	
	public int checkGuess (char guess) {
		System.out.println (guess);
		int inWord = -1;
		for (int i = 0; i < answer.getLength(); i++)
		{
			if (answer.getElementAt(i) == guess)
			{
				word.remove(i);
				word.add(guess, i);
				System.out.println("Word String: " + getWordString());				
				hitRed();
				inWord = 0;
			}
		}
		 if (inWord == -1){
			hitBlue();
			addGuess(guess);
		}
		
		return inWord;
	}
	
	public void addGuess(char guess) {
		guesses.add(guess);
	}
	
	
	public SinglyLinkedList<Character> getGuesses() {
		return guesses;
	}
	
	public void resetGuesses() {
		for (int i = 0; i < guesses.getLength(); i++)
			guesses.remove(i);
	}
	
	public void addCompletedWord(String wrd) {
		completedWords.add(wrd);
	}
	
	public SinglyLinkedList<String> getCompletedWords() {
		return completedWords;
	}
	
	}