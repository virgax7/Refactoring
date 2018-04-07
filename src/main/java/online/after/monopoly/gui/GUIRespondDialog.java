package online.after.monopoly.gui;

import online.after.monopoly.RespondDialog;
import online.after.monopoly.TradeDeal;

import javax.swing.*;
import java.awt.*;


public class GUIRespondDialog extends JDialog implements RespondDialog {
    private boolean response;
    private final JTextArea txtMessage = new JTextArea();
    
    public GUIRespondDialog() {
        txtMessage.setPreferredSize(new Dimension(300, 200));
        txtMessage.setEditable(false);
        txtMessage.setLineWrap(true);
        
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(txtMessage, BorderLayout.CENTER);

        JPanel pnlButtons = new JPanel();
        JButton btnYes = new JButton("Yes");
        JButton btnNo = new JButton("No");
        pnlButtons.add(btnYes);
        pnlButtons.add(btnNo);
        contentPane.add(pnlButtons, BorderLayout.SOUTH);
        
        btnYes.addActionListener(e -> {
            response = true;
            hide();
        });

        btnNo.addActionListener(e -> {
            response = false;
            hide();
        });
    
        setModal(true);
        pack();
    }

    public boolean getResponse() {
        return response;
    }
    
    public void setDeal(TradeDeal deal) {
        txtMessage.setText(deal.makeMessage());
    }

}
