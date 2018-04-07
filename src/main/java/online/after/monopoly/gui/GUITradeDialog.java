package online.after.monopoly.gui;

import online.after.monopoly.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GUITradeDialog extends JDialog implements TradeDialog {
    private final JButton btnOK;
    private final JComboBox cboSellers;
    private final JComboBox cboProperties;

    private TradeDeal deal;
    private final JTextField txtAmount;
    
    public GUITradeDialog(Frame parent) {
        super(parent);
        
        setTitle("Trade Property");
        cboSellers = new JComboBox();
        cboProperties = new JComboBox();
        txtAmount = new JTextField();
        btnOK = new JButton("OK");
        final JButton btnCancel = new JButton("Cancel");
        
        btnOK.setEnabled(false);
        
        buildSellersCombo();
        setModal(true);
             
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(4, 2));
        contentPane.add(new JLabel("Sellers"));
        contentPane.add(cboSellers);
        contentPane.add(new JLabel("Properties"));
        contentPane.add(cboProperties);
        contentPane.add(new JLabel("Amount"));
        contentPane.add(txtAmount);
        contentPane.add(btnOK);
        contentPane.add(btnCancel);
        
        btnCancel.addActionListener(e -> GUITradeDialog.this.hide());
        
        cboSellers.addItemListener(e -> {
            Player player = (Player)e.getItem();
            updatePropertiesCombo(player);
        });
        
        btnOK.addActionListener(e -> {
            int amount;
            try{
                amount = Integer.parseInt(txtAmount.getText());
            } catch(NumberFormatException nfe) {
                JOptionPane.showMessageDialog(GUITradeDialog.this,
                        "Amount should be an integer", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Cell cell = (Cell)cboProperties.getSelectedItem();
            if(cell == null) return;
            Player player = (Player)cboSellers.getSelectedItem();
            Player currentPlayer = GameMaster.instance().getCurrentPlayer();
            if(currentPlayer.getMoney() > amount) {
                deal = new TradeDeal();
                deal.setAmount(amount);
                deal.setPropertyName(cell.getName());
                deal.setSellerIndex(GameMaster.instance().getPlayerIndex(player));
            }
            hide();
        });
        
        this.pack();
    }

    private void buildSellersCombo() {
        List sellers = GameMaster.instance().getSellerList();
        for (final Object seller : sellers) {
            cboSellers.addItem(seller);
        }
        if(sellers.size() > 0) {
            updatePropertiesCombo((Player)sellers.get(0));
        }
    }

    public TradeDeal getTradeDeal() {
        return deal;
    }

    private void updatePropertiesCombo(Player player) {
        cboProperties.removeAllItems();
        Cell[] cells = player.getAllProperties();
        btnOK.setEnabled(cells.length > 0);
        for (final Cell cell : cells) {
            cboProperties.addItem(cell);
        }
    }

}
