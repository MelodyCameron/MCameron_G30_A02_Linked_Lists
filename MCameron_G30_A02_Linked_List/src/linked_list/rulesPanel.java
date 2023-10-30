package linked_list;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;

import java.awt.*;

public class rulesPanel extends JPanel {
	JLabel lblRulesTitle;
	JLabel lblIntro;
	JLabel lblHowToPlay;
	JTextArea instructionsTextArea;
	JLabel lblHint;
	JTextArea hintTextArea;
	
	public rulesPanel() {
		setLayout(new MigLayout("", "[grow]", "[][][][][grow][][grow]"));
		setBackground(Color.white);
		lblRulesTitle = new JLabel("RULES");
		lblRulesTitle.setFont(new Font("Impact", Font.PLAIN, 40));
		lblRulesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblRulesTitle, "cell 0 0,alignx center");
		
		lblIntro = new JLabel("Destroy The Red Tank Before It Destroys You In This Word Puzzle Game!");
		lblIntro.setFont(new Font("Arial", Font.PLAIN, 12));
		add(lblIntro, "cell 0 1 1 2,alignx center");
		
		lblHowToPlay = new JLabel("How To Play");
		lblHowToPlay.setFont(new Font("Impact", Font.PLAIN, 16));
		add(lblHowToPlay, "cell 0 3,alignx center");
		
		instructionsTextArea = new JTextArea();
		instructionsTextArea.setEditable(false);
		instructionsTextArea.setFont(new Font("Arial", Font.PLAIN, 13));
		instructionsTextArea.setWrapStyleWord(true);
		instructionsTextArea.setLineWrap(true);
		instructionsTextArea.setText("Click on a letter you would like to guess.\r\n\r\n- If you guess correctly:\r\n The letter will turn green, and you will deal 1HP of damage to The Red Tank\r\n\r\n-If you guess incorrectly:\r\nThe letter will turn red, and The Red Tank will deal 1HP of damage to you!\r\n");
		add(instructionsTextArea, "cell 0 4,grow");
		
		lblHint = new JLabel("The Hint Button");
		lblHint.setFont(new Font("Impact", Font.PLAIN, 16));
		add(lblHint, "cell 0 5,alignx center");
		
		hintTextArea = new JTextArea();
		hintTextArea.setEditable(false);
		hintTextArea.setWrapStyleWord(true);
		hintTextArea.setFont(new Font("Arial", Font.PLAIN, 13));
		hintTextArea.setLineWrap(true);
		hintTextArea.setText("Pressing the hint button will display a random letter in the word on the screen. The letter displayed will turn orange on the keyboard. \r\n\r\n\r\nREMEMBER:\r\n\r\nWhenever you use a hint, both The Blue Tank AND The Red Tank will take damage! You also cannot use a hint when either tank is at 1HP, so use your hints wisely!");
		add(hintTextArea, "cell 0 6,grow");

	}

}

