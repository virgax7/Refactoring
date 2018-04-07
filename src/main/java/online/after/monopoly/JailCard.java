package online.after.monopoly;


public class JailCard extends Card {
    private final int type;
    
    public JailCard(int cardType) {
        type = cardType;
    }

    public void applyAction() {
        Player currentPlayer = GameMaster.instance().getCurrentPlayer();
		GameMaster.instance().sendToJail(currentPlayer);
    }

    public int getCardType() {
        return type;
    }

    public String getLabel() {
        return "Go to Jail immediately without collecting" +
        		" $200 when passing the GO cell";
    }
}
