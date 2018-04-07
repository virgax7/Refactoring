
package online.after.monopoly.gui;

import online.after.monopoly.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


class BuyHouseDialog extends JDialog {
    public BuyHouseDialog(Player player) {
        Container c = this.getContentPane();
        c.setLayout(new GridLayout(3, 2));
        c.add(new JLabel("Select monopoly"));

        final JComboBox cboMonopoly = new JComboBox(player.getMonopolies());
        c.add(cboMonopoly);
        c.add(new JLabel("Number of houses"));

        final JComboBox cboNumber = new JComboBox(new Integer[]{1, 2, 3, 4, 5});
        c.add(cboNumber);
        c.add(getButton(e -> {
            player.purchaseHouse((String) cboMonopoly.getSelectedItem(), cboNumber.getSelectedIndex() + 1);
            this.dispose();
        }, "OK"));

        c.add(getButton(e -> this.dispose(), "OK"));
        c.doLayout();
        this.pack();
    }

    private JButton getButton(final ActionListener actionListener, final String buttonValue) {
        final JButton button = new JButton(buttonValue);
        button.addActionListener(actionListener);
        return button;
    }
}
