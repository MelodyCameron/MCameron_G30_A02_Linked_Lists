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
		//addPlayer("Paul");
		//addPlayer("Richard");
		//addPlayer("Adewole");
		//addPlayer("Your Mom 69");
		
		sortPlayerList();
		
		loadScoreboard();
	}
	
	
	public void sortPlayerList() {
		Player cursor = null;
		Player next = null;
		for (int i = 0; i < playerList.getLength(); i++)
		{
			try {
			cursor = playerList.getElementAt(i);
			next = playerList.getElementAt(i+1);
			if (cursor.getName().compareToIgnoreCase(next.getName()) > 1)
			{
				//playerList.remove(i);
				//playerList.remove(i);
				//playerList.add(cursor);
				//playerList.add(next);
			}
			}
			catch (IndexOutOfBoundsException e) {
				return;
			}
		}
	}
	
	
	
	
	public void addPlayer (String name) {
		playerList.add(new Player(name));
		saveScoreboard(name, 0);
	}
	
	public void gamePlayed(String name, boolean win) {
		for (int i = 0; i < playerList.getLength(); i++)
		{
			if (name.equals(playerList.getElementAt(i).getName()))
			{
				playerList.getElementAt(i).setGamesPlayed(playerList.getElementAt(i).getGamesPlayed()+1);
				if (win)
					playerList.getElementAt(i).setGamesWon(playerList.getElementAt(i).getGamesWon()+1);
				saveScoreboard(name, i);
			}
		}
	}
	
	public DoublyLinkedList<Player> getPlayerList() {
		return playerList;
	}
	
	public Player getPlayer(int index) {
		return playerList.getElementAt(index);
	}
	
	public int getPlayerIndex(String name) {
		for (int i = 0; i < playerList.getLength(); i++)
			if (playerList.getElementAt(i).getName().equals(name))
				return i;
		return -1;
	}
	
	public int getNumPlayers() {
		return playerList.getLength();
	}
	
	public void saveScoreboard(String name, int index) {
	try {
		fileOut = new FileOutputStream("playerObjects/" + name + ".txt");
		objOut = new ObjectOutputStream(fileOut);
		objOut.writeObject(playerList.getElementAt(index));
		objOut.close();
		fileOut.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void loadScoreboard() {
		//try {
			
			File playerObjects = new File("playerObjects");
			if (playerObjects.exists() && playerObjects.isDirectory())
			{
				File files[] = playerObjects.listFiles();
				for (int i = files.length -1; i >= 0; i--)
				{
				try {
					fileIn = new FileInputStream(files[i].getAbsolutePath());
					objIn = new ObjectInputStream(fileIn);
					
					
					playerList.add((Player) objIn.readObject());
					objIn.close();
					fileIn.close();
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
	}
}
