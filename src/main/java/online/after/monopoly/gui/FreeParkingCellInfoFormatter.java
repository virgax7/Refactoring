package online.after.monopoly.gui;

import online.after.monopoly.Cell;

public class FreeParkingCellInfoFormatter implements CellInfoFormatter {
    public String format(Cell cell) {
        return "<html><b>Free Parking</b></html>";
    }
}
