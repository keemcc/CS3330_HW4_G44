package hw4.maze;

import java.util.ArrayList;

/**
 * Class that contains row information for the game grid
 * Contains an ArrayList of Cell objects
 */
public class Row {
	//List of cells
	private ArrayList<Cell> cells;

	/**
	 * Parameterized constructor for Row object
	 * Sets cells to passed value
	 * @param cells cells list to set row cells to be
	 */
	public Row(ArrayList<Cell> cells) {
		this.cells = cells;
	}

	/**
	 * Returns the cells stored by the Row as an ArrayList
	 * @return cells ArrayList
	 */
	public ArrayList<Cell> getCells() {
		return this.cells;
	}

	/**
	 * Sets the cells to be the passed cellList
	 * @param cellList passed list to set cells to be
	 */
	public void setCells(ArrayList<Cell> cellList) {
		this.cells = cellList;
	}
	
	@Override
	/**
	 * Formatted toString for Row object. Returns a string containing all cells stored in the cells ArrayList
	 */
	public String toString() {
		//Beginning part of the formatted string
		String returnString = "Row [cells=[";
		//For each cell within the cells object, concatenate the cell's toString to the returnString
		for (int i = 0; i<cells.size(); i++) {
			returnString = returnString.concat(cells.get(i).toString());
			//If there are more cells left, add a comma and space for formatting
			if ((i+1) < cells.size()) {
				returnString = returnString.concat(", ");
			}
		}
		//Concatenate the ending part of formatted string
		returnString = returnString.concat("]]");
		return returnString;
	}

}
