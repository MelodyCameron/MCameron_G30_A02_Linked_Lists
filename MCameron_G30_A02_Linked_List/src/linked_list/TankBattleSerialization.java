package linked_list;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class TankBattleSerialization {

	private FileOutputStream fileOut;
	private ObjectOutputStream objOut;
	private static FileInputStream fileIn;
	private static ObjectInputStream objIn;

	public void saveState(TankBattle tank) {
		try {
			fileOut = new FileOutputStream("gameObjects/" + tank.getPlayerName() + "_game.txt");
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(tank);
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
	}// saveState(TankBattle)

	public TankBattle loadState(String name) {
		try {
			fileIn = new FileInputStream("gameObjects/" + name + "_game.txt");
			objIn = new ObjectInputStream(fileIn);
			TankBattle tank = (TankBattle) objIn.readObject();
			objIn.close();
			fileIn.close();
			return tank;
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
		return null;
	}// loadState(String)
}// TankBattleSerialization class