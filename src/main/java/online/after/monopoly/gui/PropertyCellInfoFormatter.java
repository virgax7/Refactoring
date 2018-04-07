package online.after.monopoly.gui;

import online.after.monopoly.Cell;
import online.after.monopoly.Player;
import online.after.monopoly.PropertyCell;

public class PropertyCellInfoFormatter implements CellInfoFormatter {
    public String format(Cell cell) {
        PropertyCell c = (PropertyCell)cell;
        StringBuilder buf = new StringBuilder();
        Player owner = cell.getOwner();
        String ownerName = "";
        if(owner != null) {
        	ownerName = owner.getName();
        }
        buf.append("<html><b><font color='")
                .append(c.getColorGroup())
                .append("'>")
                .append(cell.getName())
                .append("</font></b><br>")
                .append("$").append(c.getPrice())
				.append("<br>Owner: ").append(ownerName)
				.append("<br>* ").append(c.getNumHouses())
                .append("</html>");
        return buf.toString();
    }
}
