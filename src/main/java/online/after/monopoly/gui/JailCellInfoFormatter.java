package online.after.monopoly.gui;

import online.after.monopoly.Cell;

public class JailCellInfoFormatter implements CellInfoFormatter {

    private static final String JAIL_CELL_LABEL = "<html><b>Jail</b></html>";

    public String format(Cell cell) {
		return JAIL_CELL_LABEL;
	}

}
