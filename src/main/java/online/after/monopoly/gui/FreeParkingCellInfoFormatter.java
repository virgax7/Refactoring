package online.after.monopoly.gui;

import online.after.monopoly.Cell;

public class FreeParkingCellInfoFormatter implements CellInfoFormatter {
    
    private static final String FP_CELL_LABEL = "<html><b>Free Parking</b></html>";
    
    public String format(Cell cell) {
        return FP_CELL_LABEL;
    }
}
