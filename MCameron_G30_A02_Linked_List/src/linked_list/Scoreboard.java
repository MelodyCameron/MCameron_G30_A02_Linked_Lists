package linked_list;

import java.io.*;

public class Scoreboard {

	private DoublyLinkedList<Player> playerList;
	private FileOutputStream fileOut;
	private ObjectOutputStream objOut;
	private FileInputStream fileIn;
	private ObjectInputStream objIn;

	public Scoreboard() {
		playerList = new DoublyLinkedList<Player>();
		loadScoreboard();
		sortPlayerList();
	}// Scoreboard()

	public void sortPlayerList() {
		Player cursor = null;
		Player next = null;
		for (int i = 0; i < playerList.getLength(); i++) {
			try {
				cursor = playerList.getElementAt(i);
				next = playerList.getElementAt(i + 1);
			} // try
			catch (IndexOutOfBoundsException e) {
				return;
			} // catch(IndexOutOfBoundsException)
		} // for loop
	}// sortPlayerList()

	public void addPlayer(String name) {
		playerList.add(new Player(name));
		saveScoreboard(name, 0);
	}// addPlayer(String)

	public void gamePlayed(String name, boolean win) {
		for (int i = 0; i < playerList.getLength(); i++) {
			if (name.equals(playerList.getElementAt(i).getName())) {
				playerList.getElementAt(i).setGamesPlayed(playerList.getElementAt(i).getGamesPlayed() + 1);
				if (win)
					playerList.getElementAt(i).setGamesWon(playerList.getElementAt(i).getGamesWon() + 1);
				saveScoreboard(name, i);
			} // if
		} // for loop
	}// gamePlayed(String, boolean)

	public DoublyLinkedList<Player> getPlayerList() {
		return playerList;
	}// getPlayerList()

	public Player getPlayer(int index) {
		return playerList.getElementAt(index);
	}// getPlayer(int)

	public int getPlayerIndex(String name) {
		for (int i = 0; i < playerList.getLength(); i++)
			if (playerList.getElementAt(i).getName().equals(name))
				return i;
		return -1;
	}// getPlayerIndex(String)

	public int getNumPlayers() {
		return playerList.getLength();
	}// getNumPlayers()

	public void saveScoreboard(String name, int index) {
		try {
			fileOut = new FileOutputStream("playerObjects/" + name + ".txt");
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(playerList.getElementAt(index));
			objOut.close();
			fileOut.close();
		} // try
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // catch(FileNotFoundException)
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // catch(IOException)
	}// saveScoreboard(String, int)

	public void loadScoreboard() {
		SinglyLinkedList<File> files = new SinglyLinkedList<File>();
		File playerObjects = new File("playerObjects");
		if (playerObjects.exists() && playerObjects.isDirectory()) {
			File allFiles[] = playerObjects.listFiles();
			for (int i = 0; i < allFiles.length; i++) {
				if (!allFiles[i].getName().contains("_JUnit"))
					files.add(allFiles[i]);
			} // for loop
			System.out.println(files);
			for (int i = files.getLength() - 1; i >= 0; i--) {
				try {
					fileIn = new FileInputStream(files.getElementAt(i).getAbsolutePath());
					objIn = new ObjectInputStream(fileIn);
					playerList.add((Player) objIn.readObject());
					objIn.close();
					fileIn.close();
				} // try
				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // catch(FileNotFoundException)
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // catch(IOException)
				catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // catch(ClassNotFoundException)
			} // for loop
		} // if
	}// loadScoreboard()
}// Scoreboard class