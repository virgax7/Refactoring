package online.after.monopoly.gui;

import online.after.monopoly.GameBoard;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameBoardUtil {
    
	public static Dimension calculateDimension(int i) {
		i = i - 4;
		int shortSide = i / 4;
		int longSide = (i - shortSide * 2) / 2;
		return new Dimension(longSide, shortSide);
	}
	
	public static List getEastCells(GameBoard board) {
		int shortSide = calculateDimension(board.getCellNumber()).height;
		List cells = new ArrayList();
		for(int i = board.getCellNumber() - shortSide; i <= board.getCellNumber() - 1; i++) {
			cells.add(board.getCell(i));
		}
		return cells;
	}
	
	public static List getNorthCells(GameBoard board) {
		int longSide = calculateDimension(board.getCellNumber()).width;
		int shortSide = calculateDimension(board.getCellNumber()).height;
		List cells = new ArrayList();
		for(int i = longSide + 2 + shortSide; i <= longSide + 2 + shortSide + longSide + 1; i++) {
			cells.add(board.getCell(i));
		}
		return cells;
	}
	
	public static List getSouthCells(GameBoard board) {
		int longSide = calculateDimension(board.getCellNumber()).width;
		List cells = new ArrayList();
		for(int i = longSide + 1; i >= 0; i--) {
			cells.add(board.getCell(i));
		}
		return cells;
	}
	
	public static List getWestCells(GameBoard board) {
		int longSide = calculateDimension(board.getCellNumber()).width;
		int shortSide = calculateDimension(board.getCellNumber()).height;
		List cells = new ArrayList();
		for(int i = longSide + 1 + shortSide; i > longSide + 1; i--) {
			cells.add(board.getCell(i));
		}
		return cells;
	}
}
