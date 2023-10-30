package linked_list;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class ScoreboardPanel extends JPanel implements ActionListener {

	/**
	 * Create the panel.
	 */
	
	JComboBox cmbxPlayers;
	Scoreboard scoreboard;
	public ScoreboardPanel() {
		scoreboard = new Scoreboard();
		setLayout(new MigLayout("", "[grow]", "[][][]"));
		
		JLabel lblScoreboard = new JLabel("Scoreboard");
		lblScoreboard.setFont(new Font("Impact", Font.PLAIN, 48));
		add(lblScoreboard, "cell 0 0,alignx center");
		
		cmbxPlayers = new JComboBox();
		for (int i = 0; i < scoreboard.getNumPlayers(); i++)
			cmbxPlayers.addItem(scoreboard.getPlayer(i).getName());
		add(cmbxPlayers, "cell 0 2,alignx center");
		cmbxPlayers.addActionListener(this);
		cmbxPlayers.setFont(new Font("Arial", Font.PLAIN, 18));
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cmbxPlayers) {
			for (int i = 0; i < cmbxPlayers.getItemCount(); i++)
			{
				if (scoreboard.getPlayer(i).getName() == cmbxPlayers.getSelectedItem())
					JOptionPane.showMessageDialog(null, new PlayerPanel(scoreboard.getPlayer(i).getName(), scoreboard.getPlayer(i).getGamesPlayed(), scoreboard.getPlayer(i).getGamesWon()), "Player Information", JOptionPane.PLAIN_MESSAGE);
			}
		}
		
	}

}
