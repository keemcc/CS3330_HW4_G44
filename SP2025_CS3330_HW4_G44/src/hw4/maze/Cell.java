package hw4.maze;

/**
 * Cell class for creating a game grid.
 * The cell holds data for its left, right, up, and down components which represents what can be done at the cell
 */
public class Cell {
	private CellComponents left;
	private CellComponents right;
	private CellComponents up;
	private CellComponents down;

	/**
	 * Gets left component of cell
	 * @return left component
	 */
	public CellComponents getLeft() {
		return left;
	}

	/**
	 * Sets left component of cell to be passed value
	 * if passed value is null, sets component to be WALL
	 * @param left
	 */
	public void setLeft(CellComponents left) {
		if (left == null) {
			left = CellComponents.WALL;
		}
		this.left = left;
	}

	/**
	 * Gets right component of cell
	 * @return right component
	 */
	public CellComponents getRight() {
		return right;
	}

	/**
	 * Sets right component of cell to be passed value
	 * if passed value is null, sets component to be WALL
	 * @param right
	 */
	public void setRight(CellComponents right) {
		if (right == null) {
			right = CellComponents.WALL;
		}
		this.right = right;
	}

	/**
	 * Gets up component of cell
	 * @return up component
	 */
	public CellComponents getUp() {
		return up;
	}

	/**
	 * Sets up component of cell to be passed value
	 * if passed value is null, sets component to be WALL
	 * @param up
	 */
	public void setUp(CellComponents up) {
		if (up == null) {
			up = CellComponents.WALL;
		}
		this.up = up;
	}

	/**
	 * Gets down component of cell
	 * @return down component
	 */
	public CellComponents getDown() {
		return down;
	}

	/**
	 * Sets down component of cell to be passed value
	 * if passed value is null, sets component to be WALL
	 * @param down
	 */
	public void setDown(CellComponents down) {
		if (down == null) {
			down = CellComponents.WALL;
		}
		this.down = down;
	}
	
	@Override
	/**
	 * Returns string representation of cell
	 */
	public String toString() {
		return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
	}

	/**
	 * Parameterized constructor for cell, setting each component to passed values
	 * @param left left component
	 * @param right right component
	 * @param up up component
	 * @param down down component
	 */
	public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
		this.left = left;
		this.right = right;
		this.up = up;
		this.down = down;
	}

}
