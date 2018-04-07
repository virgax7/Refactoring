package online.after.monopoly.test;

import junit.framework.TestCase;
import online.after.monopoly.*;

public class CardsTest extends TestCase {
    private Card ccCard;
    private Card chanceCard;

    private GameMaster gameMaster;

    protected void setUp() {
        gameMaster = GameMaster.instance();
        gameMaster.setGameBoard(new GameBoardCCGainMoney());
        gameMaster.setNumberOfPlayers(1);
        gameMaster.reset();
        gameMaster.setGUI(new MockGUI());
        ccCard = new MoneyCard("Get 50 dollars", 50, Card.TYPE_CC);
        chanceCard = new MoneyCard("Lose 50 dollars", -50, Card.TYPE_CHANCE);
        gameMaster.getGameBoard().addCard(ccCard);
    }

    public void testCardType() {
        gameMaster.drawCCCard();
        assertEquals(Card.TYPE_CC, ccCard.getCardType());
        gameMaster.drawChanceCard();
        assertEquals(Card.TYPE_CHANCE, chanceCard.getCardType());
    }
}
