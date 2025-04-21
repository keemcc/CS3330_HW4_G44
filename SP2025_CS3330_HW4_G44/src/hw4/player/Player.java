package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Row;

/**
 * Player Class contains information and methods relating to player for the game
 * Contains currentRow and currentCell information
 */
public class Player {
	private Row currentRow;
	private Cell currentCell;

	/**
	 * Parameterized constructor to create a player at currentRow row and currentCell cell
	 * @param row current row player is at when created
	 * @param cell current cell player is at when created
	 */
	public Player(Row row, Cell cell) {
		currentRow = row;
		currentCell = cell;
	}

	/**
	 * Sets the player's row to be the passed row
	 * @param currentRow
	 */
	public void setCurrentRow(Row currentRow) {
		this.currentRow = currentRow;
	}

	/**
	 * Sets the player's current cell to be the passed cell
	 * @param currentCell
	 */
	public void setCurrentCell(Cell currentCell) {
		this.currentCell = currentCell;
	}

	/**
	 * Returns the player's current row
	 * @return current row
	 */
	public Row getCurrentRow() {
		return currentRow;
	}
	
	/**
	 * Returns the player's current cell
	 * @return current cell
	 */
	public Cell getCurrentCell() {
		return currentCell;
	}
	
	@Override
	/**
	 * Formatted string representation on player
	 */
	public String toString() {
		return ("Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]");
	}

}
