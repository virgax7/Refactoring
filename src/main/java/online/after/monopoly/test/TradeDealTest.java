package online.after.monopoly.test;

import junit.framework.TestCase;
import online.after.monopoly.GameMaster;
import online.after.monopoly.TradeDeal;

public class TradeDealTest extends TestCase {
    
    public void setUp() {
        GameMaster gameMaster = GameMaster.instance();
        gameMaster.reset();
        gameMaster.setNumberOfPlayers(2);
        gameMaster.getPlayer(0).setName("Buyer");
        gameMaster.getPlayer(1).setName("Seller");
    }

    public void testMakeMessage() {
        TradeDeal deal = new TradeDeal();
        deal.setAmount(200);
        deal.setPropertyName("Blue 1");
        deal.setSellerIndex(1);
        String message = "Buyer wishes to purchase Blue 1 from Seller" +
        		" for 200.  Seller, do you wish to trade your property?";
        assertEquals(message, deal.makeMessage());
    }

}
