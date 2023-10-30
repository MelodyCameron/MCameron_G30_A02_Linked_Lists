package linked_list;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.plaf.basic.BasicButtonUI;
import net.miginfocom.swing.MigLayout;

public class TankBattleFrame extends JFrame implements ActionListener {

	private Image backgroundImage;
	private JPanel contentPanel;
	private JPanel titlePanel;
	private JPanel loadPanel;
	private JLabel lblTitle;
	private JLabel lblTankImage;
	private JButton btnStart;

	private JLabel lblInst;
	private JLabel lblInstBr;
	private JComboBox cmbxPlayers;
	private JTextField fldName;
	private JButton btnPlay;

	private JPanel gamePanel;
	private JPanel rowPanel1;
	private JPanel rowPanel2;
	private JPanel rowPanel3;
	private JLabel lblWord;
	private JButton[] btnLetters = new JButton[26];
	private JButton btnHint;
	private JLabel lblHPBlue;
	private JLabel lblHPRed;
	private JLabel lblHPBarBlue;
	private JLabel lblHPBarRed;
	private JLabel lblBlue;
	private JLabel lblRed;

	private JMenuBar menuBar = new JMenuBar();
	private JMenu gameMenu = new JMenu("Game");
	private JMenuItem newGameItem = new JMenuItem("New");
	private JMenuItem saveGameItem = new JMenuItem("Save");
	private JMenuItem exitItem = new JMenuItem("Exit");
	private JMenu helpMenu = new JMenu("Help");
	private JMenuItem rulesItem = new JMenuItem("Rules");
	private JMenuItem scoreboardItem = new JMenuItem("Scoreboard");
	private JLabel lblName;

	TankBattle tank = new TankBattle();
	TankBattleSerialization serializer = new TankBattleSerialization();
	Dictionary dictionary;
	Scoreboard scoreboard;

	private boolean saved = false;

	public static void main(String[] args) {
		TankBattleFrame frame = new TankBattleFrame();
		frame.setSize(1280, 720);
		frame.setVisible(true);
		frame.setTitle("Tank Battle!!");
		frame.setBounds(100, 100, 1280, 720);
		frame.setResizable(false);
	}

	/**
	 * Create the frame.
	 */
	public TankBattleFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		dictionary = new Dictionary();
		scoreboard = new Scoreboard();
		contentPanel = createTitlePanel();
		setContentPane(contentPanel);
	}

	private JPanel createTitlePanel() {
		backgroundImage = new ImageIcon("images/backgrounds/backgroundTitle.jpg").getImage();
		titlePanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backgroundImage, 0, 0, this);
			}
		};

		lblTitle = new JLabel("TANK BATTLE!!");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Impact", Font.PLAIN, 96));

		lblTankImage = new JLabel(new ImageIcon("images/tank.jpg"));

		btnStart = new JButton("Start");
		btnStart.setFont(new Font("Impact", Font.PLAIN, 20));
		btnStart.setOpaque(false);
		btnStart.setBackground(new Color(0, 0, 0, 0));
		btnStart.setForeground(new Color(255, 255, 255));
		btnStart.addActionListener(this);

		titlePanel.setLayout(new MigLayout("", "[1280.00,right]", "[][][][]"));
		titlePanel.add(lblTitle, "cell 0 0,alignx center,aligny center");
		titlePanel.add(lblTankImage, "cell 0 2,alignx center,aligny top");
		titlePanel.add(btnStart, "cell 0 3,alignx center,aligny center");
		return titlePanel;
	}

	private JPanel createLoadPanel() {

		contentPanel.removeAll();
		backgroundImage = new ImageIcon("images/backgrounds/backgroundLoad.jpg").getImage();
		loadPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backgroundImage, 0, 0, this);
			}
		};

		lblInst = new JLabel("Enter your name to load your save File");
		lblInst.setFont(new Font("Arial", Font.BOLD, 32));
		lblInst.setForeground(new Color(255, 255, 255));

		lblInstBr = new JLabel("(If your name is not found a new game will be created for you)");
		lblInstBr.setFont(new Font("Arial", Font.PLAIN, 25));
		lblInstBr.setForeground(new Color(255, 255, 255));

		cmbxPlayers = new JComboBox();
		cmbxPlayers.addItem("New Player");
		cmbxPlayers.addActionListener(this);
		for (int i = 0; i < scoreboard.getNumPlayers(); i++)
			cmbxPlayers.addItem(scoreboard.getPlayer(i).getName());
		cmbxPlayers.setFont(new Font ("Arial", Font.PLAIN, 18));

		fldName = new JTextField();
		fldName.setOpaque(false);
		fldName.setBackground(new Color(0, 0, 0, 0));
		fldName.setForeground(new Color(255, 255, 255));
		fldName.setFont(new Font("Arial", Font.PLAIN, 32));
		fldName.setColumns(20);

		btnPlay = new JButton("Play Game");
		btnPlay.setOpaque(false);
		btnPlay.setBackground(new Color(0, 0, 0, 0));
		btnPlay.setForeground(new Color(255, 255, 255));
		btnPlay.setFont(new Font("Impact", Font.PLAIN, 25));
		btnPlay.addActionListener(this);

		loadPanel.setLayout(new MigLayout("", "[1280.00,grow,right]", "[][][][][][][][50][]"));
		loadPanel.add(lblTitle, "cell 0 0,alignx center");
		loadPanel.add(lblInst, "cell 0 2,alignx center,aligny bottom");
		loadPanel.add(lblInstBr, "cell 0 3,alignx center,aligny top");
		loadPanel.add(cmbxPlayers, "cell 0 5, alignx center");
		loadPanel.add(fldName, "cell 0 7,alignx center");
		loadPanel.add(btnPlay, "cell 0 9,alignx center");
		return loadPanel;
	}

	private JPanel createGamePanel() {

		setMenu();
		contentPanel.removeAll();
		backgroundImage = new ImageIcon("images/backgrounds/backgroundGame.jpg").getImage();
		gamePanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backgroundImage, 0, 0, this);
			}
		};

		lblWord = new JLabel();
		lblWord.setForeground(Color.white);
		lblWord.setFont(new Font("Arial", Font.PLAIN, 64));

		rowPanel1 = new JPanel();
		rowPanel1.setLayout(new MigLayout("", "[][][][][][][][][]"));
		rowPanel1.setOpaque(false);
		rowPanel1.setBackground(new Color(0, 0, 0, 0));

		rowPanel2 = new JPanel();
		rowPanel2.setLayout(new MigLayout("", "[][][][][][][][]"));
		rowPanel2.setOpaque(false);
		rowPanel2.setBackground(new Color(0, 0, 0, 0));

		rowPanel3 = new JPanel();
		rowPanel3.setLayout(new MigLayout("", "[][][][][][][][][]"));
		rowPanel3.setOpaque(false);
		rowPanel3.setBackground(new Color(0, 0, 0, 0));

		int idx1 = 0;
		int idx2 = 0;
		int idx3 = 0;
		int i = 0;
		for (char ltr = 'A'; ltr <= 'Z'; ltr++) {
			btnLetters[i] = new JButton("" + ltr);
			btnLetters[i].addActionListener(this);
			btnLetters[i].setForeground(Color.white);
			btnLetters[i].setFont(new Font("Arial", Font.PLAIN, 20));

			if (ltr <= 'I') {
				rowPanel1.add(btnLetters[i], "cell " + idx1 + " 0, alignx center");
				++idx1;
			} else if (ltr <= 'R') {
				rowPanel2.add(btnLetters[i], "cell " + idx2 + " 0, alignx center");
				++idx2;
			} else {
				rowPanel3.add(btnLetters[i], "cell " + idx3 + " 0, alignx center");
				++idx3;
			}
			++i;
		}

		btnHint = new JButton("Hint");
		btnHint.setOpaque(false);
		btnHint.setBackground(new Color(0, 0, 0, 0));
		btnHint.setForeground(Color.white);
		btnHint.setFont(new Font("Arial", Font.PLAIN, 20));
		btnHint.addActionListener(this);

		lblHPBlue = new JLabel("HP:");
		lblHPBlue.setForeground(Color.white);

		lblHPRed = new JLabel("HP:");
		lblHPRed.setForeground(Color.white);

		lblHPBarBlue = new JLabel();
		lblHPBarBlue.setIcon(new ImageIcon("images/hpBars/hpBar_6.png"));
		lblHPBarBlue.setForeground(Color.white);

		lblHPBarRed = new JLabel("");
		lblHPBarRed.setIcon(new ImageIcon("images/hpBars/hpBar_6.png"));
		lblHPBarRed.setForeground(Color.white);

		lblBlue = new JLabel(new ImageIcon("images/blue/blue_6HP.png"));

		lblRed = new JLabel(new ImageIcon("images/red/red_6HP.png"));

		gamePanel.setLayout(new MigLayout("", "[30][300][620][30][300]", "[200][][][][][][][][]"));
		gamePanel.add(lblWord, "cell 0 2 5 2, alignx center");
		gamePanel.add(rowPanel1, "cell 2 4, alignx center");
		gamePanel.add(rowPanel2, "cell 2 5, alignx center");
		gamePanel.add(rowPanel3, "cell 2 6, alignx center");
		gamePanel.add(btnHint, "cell 2 6, alignx center");
		gamePanel.add(lblTitle, "cell 0 0 5 1,alignx center,aligny center");
		gamePanel.add(lblHPBlue, "cell 0 7, alignx right");
		gamePanel.add(lblHPBarBlue, "cell 1 7, alignx center");
		gamePanel.add(lblBlue, "cell 0 8 2 1, alignx left, aligny bottom");
		gamePanel.add(lblHPRed, "cell 3 7, alignx right");
		gamePanel.add(lblHPBarRed, "cell 4 7, alignx center");
		gamePanel.add(lblRed, "cell 3 8 2 1, alignx right, aligny bottom");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				exitGame();
			}
		});
		return gamePanel;
	}

	private void setMenu() {

		setJMenuBar(menuBar);
		gameMenu.add(newGameItem);
		newGameItem.addActionListener(this);
		gameMenu.add(saveGameItem);
		saveGameItem.addActionListener(this);
		gameMenu.add(exitItem);
		exitItem.addActionListener(this);
		menuBar.add(gameMenu);
		helpMenu.add(rulesItem);
		rulesItem.addActionListener(this);
		helpMenu.add(scoreboardItem);
		scoreboardItem.addActionListener(this);
		menuBar.add(helpMenu);
	}

	private void changeButtonColor(int index, int result) {

		if (result == 1) {
			btnLetters[index].setOpaque(true);
			btnLetters[index].setBackground(Color.orange);
			btnLetters[index].setEnabled(false);
		}
		if (result == 0) {
			btnLetters[index].setOpaque(true);
			btnLetters[index].setBackground(Color.green);
			btnLetters[index].setEnabled(false);
		} else if (result == -1) {
			btnLetters[index].setOpaque(true);
			btnLetters[index].setBackground(Color.red);
			btnLetters[index].setEnabled(false);
		}
	}

	private void updateImages(int blue, int red) {

		ImageIcon HPBar = new ImageIcon("images/hpBars/hpBar_" + blue + ".png");
		ImageIcon tankImage = new ImageIcon("images/blue/blue_" + blue + "HP.png");
		lblHPBarBlue.setIcon(HPBar);
		lblBlue.setIcon(tankImage);
		if (red >= 6) {
			HPBar = new ImageIcon("images/hpBars/hpBar_6.png");
			tankImage = new ImageIcon("images/red/red_6HP.png");
		} else {
			HPBar = new ImageIcon("images/hpBars/hpBar_" + red + ".png");
			tankImage = new ImageIcon("images/red/red_" + red + "HP.png");
		}
		lblHPBarRed.setIcon(HPBar);
		lblRed.setIcon(tankImage);

	}

	private void startGame(boolean load) {
		remove(contentPanel);
		contentPanel = createGamePanel();
		lblWord.setText(tank.getWordString());
		lblHPBlue.setText("HP: " + tank.getHpBlue());
		lblHPRed.setText("HP: " + tank.getHpRed());
		updateImages(tank.getHpBlue(), tank.getHpRed());
		lblName = new JLabel(String.format("%350s", tank.getPlayerName()));
		menuBar.add(lblName);
		System.out.println(tank.getAnswerString());
		add(contentPanel);
		if (load) {
			for (int k = 0; k < tank.getWord().getLength(); k++) {
				for (int l = 0; l < btnLetters.length; l++) {
					if ((tank.getWord().getElementAt(k) == btnLetters[l].getText().charAt(0)))
						updateGame(l, 0);
				}
			}
			for (int i = 0; i < tank.getHints().getLength(); i++) {
				for (int j = 0; j < btnLetters.length; j++) {
					if (tank.getHints().getElementAt(i).equals(btnLetters[j].getText().charAt(0))) {
						btnLetters[j].setEnabled(true);
						updateGame(j, 1);
					}
				}
			}
			for (int m = 0; m < tank.getGuesses().getLength(); m++) {
				for (int n = 0; n < btnLetters.length; n++) {
					if (tank.getGuesses().getElementAt(m).equals(btnLetters[n].getText().charAt(0)))
						updateGame(n, -1);
				}
			}
			
		}
		
		for (int o = 0; o < btnLetters.length; o++) {
				if (btnLetters[o].isEnabled()) {
					btnLetters[o].setOpaque(false);
					btnLetters[o].setBackground(new Color(0, 0, 0, 0));
					btnLetters[o].setEnabled(true);
				}
			}
		btnHint.setEnabled(true);
		btnHint.setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		revalidate();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStart) {
			remove(contentPanel);
			contentPanel = createLoadPanel();
			add(contentPanel);
			revalidate();
			repaint();
		} else if (e.getSource() == cmbxPlayers) {
			if (!cmbxPlayers.getSelectedItem().equals("New Player")) {
				fldName.setEnabled(false);
				fldName.setVisible(false);
			} else {
				fldName.setEnabled(true);
				fldName.setVisible(true);
			}
		}
		if (e.getSource() == btnPlay) {
			btnPlay_actionPerformed();
		}
		if (e.getSource() == newGameItem) {
			int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to start a new game?");
			if (result == 0)
				newGame();
		} else if (e.getSource() == saveGameItem) {
			serializer.saveState(tank);
			JOptionPane.showMessageDialog(this, "The game has been saved", "SAVE GAME",
					JOptionPane.INFORMATION_MESSAGE);
			saved = true;
		} else if (e.getSource() == exitItem)
			exitGame();
		else if (e.getSource() == rulesItem) {

		} else if (e.getSource() == scoreboardItem) {
			JOptionPane.showMessageDialog(this, new ScoreboardPanel(), "Scoreboard", JOptionPane.PLAIN_MESSAGE);
		} else if (e.getSource() == btnHint) {
			btnHint_actionPerformed();
		}

		for (int i = 0; i < btnLetters.length; i++) {
			if (e.getSource() == btnLetters[i]) {
				updateGame(i, tank.checkGuess(btnLetters[i].getText().charAt(0)));
			}
		}
	}

	private boolean btnPlay_actionPerformed() {
		if (fldName.isEnabled()) {
			if (fldName.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "You must enter your name to register as a new player", "ERROR",
						JOptionPane.ERROR_MESSAGE);
				return false;
			} else {
				if (checkForExistingPlayer(fldName.getText())) {
					scoreboard.addPlayer(fldName.getText());
					dictionary.startRound();
					tank = new TankBattle(dictionary.getWord(), dictionary.getAnswer(), fldName.getText());
					startGame(false);
					serializer.saveState(tank);
					return true;
				} else {
					JOptionPane.showMessageDialog(this, fldName.getText() + " is already registered. Please try again",
							"ERROR", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
		} else {
			System.out.println((String) cmbxPlayers.getSelectedItem());
			tank = serializer.loadState((String) cmbxPlayers.getSelectedItem());
			startGame(true);
			return true;
		}
	}

	private void btnHint_actionPerformed() {

		char hintLetter = tank.askForHint();
		for (int i = 0; i < btnLetters.length; i++) {
			if (hintLetter == btnLetters[i].getText().charAt(0))

				updateGame(i, 1);
		}

	}

	private boolean checkForExistingPlayer(String name) {
		for (int i = 1; i < scoreboard.getNumPlayers(); i++)
			if (scoreboard.getPlayer(i).getName().equals(name))
				return false;
		return true;
	}

	private void newGame() {
		System.out.println("New Game");
		dictionary.removeWord(tank.getAnswerString());
		dictionary.startRound();
		tank.resetGuesses();
		tank.addCompletedWord(tank.getAnswerString());
		tank = new TankBattle(dictionary.getWord(), dictionary.getAnswer(), tank.getPlayerName());
		menuBar.remove(lblName);
		startGame(false);
	}

	private void updateGame(int i, int result) {
		scoreboard.saveScoreboard(tank.getPlayerName(), scoreboard.getPlayerIndex(tank.getPlayerName()));

		if (tank.getHpBlue() == 1 || tank.getHpRed() == 1)
		{
			btnHint.setEnabled(false);
			btnHint.setVisible(false);
		}

		lblHPBlue.setText("HP: " + tank.getHpBlue());
		lblHPRed.setText("HP: " + tank.getHpRed());
		updateImages(tank.getHpBlue(), tank.getHpRed());
		changeButtonColor(i, result);
		lblWord.setText(tank.getWordString());
		saved = false;

		if (tank.getHpBlue() == 0)
			winOrLose(false);
		else if (tank.getHpRed() == 0)
			winOrLose(true);
	}

	private void winOrLose(boolean result) {
		if (result)
			JOptionPane.showMessageDialog(this, "Congratulations! \nYou Win!!", "Game Results:",
					JOptionPane.PLAIN_MESSAGE);
		else
			JOptionPane.showMessageDialog(this, "Your Tank was Destroyed!!!\n The word was " + tank.getAnswerString(),
					"You Lose!", JOptionPane.PLAIN_MESSAGE);
		System.out.println(tank.getPlayerName());
		scoreboard.gamePlayed(tank.getPlayerName(), result);

		newGame();
	}

	private void exitGame() {
		if (saved)
			System.exit(-1);
		else {
			String[] options = { "Exit without Saving", "Save and Exit", "Cancel" };
			int result = JOptionPane.showOptionDialog(this, "Would to like to save before exiting?", "EXIT", 0, 3, null,
					options, options[0]);
			if (result == 0)
				System.exit(-1);
			else if (result == 1) {
				serializer.saveState(tank);
				JOptionPane.showMessageDialog(this, "The game has been saved", "SAVE GAME",
						JOptionPane.INFORMATION_MESSAGE);
				System.exit(-1);
			} else
				;
		}
	}

}