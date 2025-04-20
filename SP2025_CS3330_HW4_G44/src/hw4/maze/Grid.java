package hw4.maze;

import java.util.ArrayList;

/**
 * Grid Class for creating game grid
 * Stores rows that store cells for game grid
 */
public class Grid {
	//The stored rows within the grid
	private ArrayList<Row> rows;

	/**
	 * Parameterized constructor, creates grid and sets the rows to be the passed rows
	 * @param rows rows to be stored
	 */
	public Grid(ArrayList<Row> rows) {
		this.rows = rows;
	}

	/**
	 * Returns the rows stored in the grid
	 * @return rows stored in grid
	 */
	public ArrayList<Row> getRows() {
		return rows;
	}

	/**
	 * Sets rows in grid to be passed rows ArrayList
	 * @param rows rows to be set to
	 */
	public void setRows(ArrayList<Row> rows) {
		this.rows = rows;
	}

	@Override
	/**
	 * Formatted toString for Grid object. Returns a string containing all rows stored in the rows ArrayList
	 */
	public String toString() {
		//Beginning part of the formatted string
		String returnString = "Grid [rows=[";
		//For each row within the rows object, concatenate the rows's toString to the returnString
		for (int i = 0; i<rows.size(); i++) {
			returnString = returnString.concat(rows.get(i).toString());
			//If there are more rows left, add a comma and space for formatting
			if ((i+1) < rows.size()) {
				returnString = returnString.concat(", ");
			}
		}
		//Concatenate the ending part of formatted string
		returnString = returnString.concat("]]");
		return returnString;
	}
}
