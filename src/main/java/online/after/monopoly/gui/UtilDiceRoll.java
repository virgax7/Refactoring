package online.after.monopoly.gui;

import online.after.monopoly.GameMaster;

import javax.swing.*;
import java.awt.*;

class UtilDiceRoll extends JDialog {
	
	public static int showDialog() {
		UtilDiceRoll dialog = new UtilDiceRoll();
		dialog.show();
		return dialog.diceValue;
	}
	private final JButton btnDice = new JButton("Roll the Dice!");
	private final JButton btnOK = new JButton("OK");
	private int diceValue;
	private final JLabel lblPrompt = new JLabel();

	private UtilDiceRoll() {
		setModal(true);
		btnOK.setEnabled(false);
		lblPrompt.setText("Please roll the dice to determine your utility bill.");
		Container contentPane = getContentPane();
		JPanel pnlButtons = new JPanel();
		pnlButtons.add(btnDice);
		pnlButtons.add(btnOK);
		contentPane.setLayout(new BorderLayout());
		contentPane.add(lblPrompt, BorderLayout.CENTER);
		contentPane.add(pnlButtons, BorderLayout.SOUTH);
		btnDice.addActionListener(arg0 -> rollDice());
		btnOK.addActionListener(arg0 -> okClicked());
		this.pack();
	}
	
	private void okClicked(){
		this.dispose();
	}
	
	private void rollDice() {
		int[] diceRoll = GameMaster.instance().rollDice();
		this.diceValue = diceRoll[0] + diceRoll[1];
		lblPrompt.setText("You rolled " + diceValue);
		btnDice.setEnabled(false);
		btnOK.setEnabled(true);
	}
}
