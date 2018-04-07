package online.after.monopoly.gui;

import javax.swing.*;
import java.awt.*;


class TestDiceRollDialog extends JDialog {
    private final JTextField txtDiceRoll;
    private int[] diceRoll;
    
    public TestDiceRollDialog(Frame parent) {
        super(parent);
        
        setTitle("Dice Roll Dialog");
        txtDiceRoll = new JTextField(2);
        final JButton btnOK = new JButton("OK");
        final JButton btnCancel = new JButton("Cancel");
        
        setModal(true);
             
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(2, 2));
        contentPane.add(new JLabel("Amount"));
        contentPane.add(txtDiceRoll);
        contentPane.add(btnOK);
        contentPane.add(btnCancel);
        
        btnCancel.addActionListener(e -> {
            TestDiceRollDialog.this.hide();
            diceRoll = new int[2];
            diceRoll[0] = 0;
            diceRoll[1] = 0;
        });
        
        btnOK.addActionListener(e -> {
            int amount;
            try{
                amount = Integer.parseInt(txtDiceRoll.getText());
            } catch(NumberFormatException nfe) {
                JOptionPane.showMessageDialog(TestDiceRollDialog.this,
                        "Amount should be an integer", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(amount > 0) {
                diceRoll = new int[2];
                if((amount % 2) == 0) {
                    diceRoll[0] = amount / 2;
                    diceRoll[1] = amount / 2;
                }
                else {
                    diceRoll[0] = amount / 2;
                    diceRoll[1] = (amount / 2) + 1;
                }
            }
            hide();
        });
        
        this.pack();
    }

    public int[] getDiceRoll() {
        return diceRoll;
    }
}
