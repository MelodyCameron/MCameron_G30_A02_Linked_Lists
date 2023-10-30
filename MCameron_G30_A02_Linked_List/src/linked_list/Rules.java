package linked_list;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextArea;
import java.awt.Insets;
import java.awt.Font;

public class Rules extends JPanel {

	/**
	 * Create the panel.
	 */
	public Rules() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setSize(450,400);
		JLabel lblNewLabel = new JLabel("RULES");
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 40));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblIntro = new JLabel("Destroy The Red Tank Before It Destroys You In This Word Puzzle Game!");
		lblIntro.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblIntro = new GridBagConstraints();
		gbc_lblIntro.insets = new Insets(0, 0, 5, 0);
		gbc_lblIntro.gridx = 0;
		gbc_lblIntro.gridy = 1;
		add(lblIntro, gbc_lblIntro);
		
		JLabel lblNewLabel_1 = new JLabel("How To Play");
		lblNewLabel_1.setFont(new Font("Impact", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JTextArea txtrClickOnA = new JTextArea();
		txtrClickOnA.setEditable(false);
		txtrClickOnA.setFont(new Font("Arial", Font.PLAIN, 13));
		txtrClickOnA.setWrapStyleWord(true);
		txtrClickOnA.setLineWrap(true);
		txtrClickOnA.setText("Click on a letter you would like to guess.\r\n\r\n- If you guess correctly:\r\n The letter will turn green, and you will deal 1HP of damage to The Red Tank\r\n\r\n-If you guess incorrectly:\r\nThe letter will turn red, and The Red Tank will deal 1HP of damage to you!\r\n");
		GridBagConstraints gbc_txtrClickOnA = new GridBagConstraints();
		gbc_txtrClickOnA.insets = new Insets(0, 0, 5, 0);
		gbc_txtrClickOnA.fill = GridBagConstraints.BOTH;
		gbc_txtrClickOnA.gridx = 0;
		gbc_txtrClickOnA.gridy = 3;
		add(txtrClickOnA, gbc_txtrClickOnA);
		
		JLabel lblNewLabel_2 = new JLabel("The Hint Button");
		lblNewLabel_2.setFont(new Font("Impact", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JTextArea txtrPressingTheHint = new JTextArea();
		txtrPressingTheHint.setRows(10);
		txtrPressingTheHint.setEditable(false);
		txtrPressingTheHint.setWrapStyleWord(true);
		txtrPressingTheHint.setLineWrap(true);
		txtrPressingTheHint.setText("Pressing the hint button will display a random letter in the word on the screen. The letter will turn orange on the Keyboard.\r\n\r\nREMEMBER:\r\n\r\nWhenever you use a hint, both The Blue Tank AND The Red Tank will take damage! You also cannot use a hint when either tank is at 1HP, so use your hints wisely!");
		txtrPressingTheHint.setFont(new Font("Arial", Font.PLAIN, 13));
		GridBagConstraints gbc_txtrPressingTheHint = new GridBagConstraints();
		gbc_txtrPressingTheHint.fill = GridBagConstraints.BOTH;
		gbc_txtrPressingTheHint.gridx = 0;
		gbc_txtrPressingTheHint.gridy = 5;
		add(txtrPressingTheHint, gbc_txtrPressingTheHint);

	}

}
