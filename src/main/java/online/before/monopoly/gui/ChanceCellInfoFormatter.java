package online.before.monopoly.gui;

import online.before.monopoly.Cell;

public class ChanceCellInfoFormatter implements CellInfoFormatter {
    
    public static final String CHANCE_CELL_LABEL = "<html><font color='teal'><b>Chance</b></font></html>";
    
    public String format(Cell cell) {
        return CHANCE_CELL_LABEL;
    }
}
