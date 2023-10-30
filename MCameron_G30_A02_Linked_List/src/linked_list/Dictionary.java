package linked_list;
import java.io.*;
import java.util.Scanner;
public class Dictionary<E> {

	private File dictionary = new File("word_db.txt");
	private Scanner scanner;
	private SinglyLinkedList<String> wordsList = new SinglyLinkedList<String>();
	private SinglyLinkedList<Character> word = new SinglyLinkedList<Character>();
	private SinglyLinkedList<Character> answer = new SinglyLinkedList<Character>();
	
	
	public Dictionary() {
		try {
			readFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


private void readFile() throws FileNotFoundException {
	scanner = new Scanner (dictionary);
	
	while (scanner.hasNextLine()) {
		String word = scanner.nextLine();
		if (validateWord(word))
		{
			//word = filter(word);
			wordsList.add(word.toUpperCase());
		}
		
		}
	scanner.close();
	}








private boolean validateWord (String word) {
	//will do some stuff later
	
	return true;
}

public SinglyLinkedList<String> getWordsList() {
	return wordsList;
}

public void startRound() {
	int randomWordIndex = (int)(Math.random()*getWordsListLength());
	if (word.getLength() > 0)
	{
		for (int i = 0; i < word.getLength(); i++)
		{
			word.remove(i);
			answer.remove(i);
		}
	}
	setWord(wordsList.getElementAt(randomWordIndex));
	setAnswer(wordsList.getElementAt(randomWordIndex));
}

public void setWord(String wrd) {
	word = new SinglyLinkedList<Character>();
	for (int i = wrd.length() -1; i >= 0; i--)
	{
		if (Character.isLetter(wrd.charAt(i)))
			word.add('_');
		else
			word.add(wrd.charAt(i));
	}
}


public SinglyLinkedList<Character> getWord() {
	return word;
}

public void setAnswer(String ans) {
	answer = new SinglyLinkedList<Character>();
	for (int i = ans.length() -1; i >= 0; i--)
		answer.add(ans.charAt(i));
}

public SinglyLinkedList<Character> getAnswer() {
	return answer;
}

public int getWordsListLength() {
	return wordsList.getLength();
}


public void removeWord(String wrd) {
	for (int i = 0; i < wordsList.getLength(); i++)
	{
		if (wordsList.getElementAt(i).equals(wrd));
		wordsList.remove(i);
	}
}

}
