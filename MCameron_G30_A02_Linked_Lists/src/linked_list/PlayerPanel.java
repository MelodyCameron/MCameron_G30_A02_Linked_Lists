package linked_list;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;

public class PlayerPanel extends JPanel {

	public PlayerPanel(String name, int gamesPlayed, int gamesWon) {
		setLayout(new MigLayout("", "[125px][125px]", "[][5px][][]"));
		
		JLabel lblPlayerName = new JLabel(name);
		lblPlayerName.setFont(new Font("Arial", Font.BOLD, 24));
		add(lblPlayerName, "cell 0 0 2 1,alignx center");
		
		JLabel lblWon = new JLabel("Games Won:");
		lblWon.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblWon, "cell 0 2,alignx right");
		
		JLabel lblGamesWonValue = new JLabel("" + gamesWon);
		lblGamesWonValue.setFont(new Font("Arial", Font.BOLD, 14));
		add(lblGamesWonValue, "cell 1 2");
		
		JLabel lblPlayed = new JLabel("Games Played:");
		lblPlayed.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblPlayed, "cell 0 3,alignx right");
		
		JLabel lblGamesPlayedValue = new JLabel("" + gamesPlayed);
		lblGamesPlayedValue.setFont(new Font("Arial", Font.BOLD, 14));
		add(lblGamesPlayedValue, "cell 1 3");
	}
}
