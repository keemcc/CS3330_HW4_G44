package hw4.game;

import java.util.ArrayList;
import java.util.Random;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;

public class Game {
	private Grid grid;
	private int size;

	public void setGrid(Grid grid) {
		this.grid = grid;
		this.size = grid.getRows().size();
	}

	public Game(Grid grid) {
		this.grid = grid;
		this.size = grid.getRows().size();
	}

	public Game(int size) {
		this.size = size;
	}

	public Grid getGrid() {
		return grid;
	}

	public Grid createRandomGrid(int length) {
		if ((length < 3) || (length > 7)) {
			return null;
		}
		size = length;
		Random random = new Random();
		ArrayList<Row> rows = new ArrayList<Row>();
		boolean exitPlaced = false;
		for (int row = 0; row < length; row++) {
			ArrayList<Cell> cells = new ArrayList<Cell>();
			//Iterate through every column/index in the row (every cell)
			for (int column = 0; column < length; column++) {
				CellComponents left, right, up, down;
				boolean hasAperture = false;
				//Components will be generated randomly with the following algorithm
				//Right and down components will be randomly generated, as long as they are not an outer edge
				//Left and up components will be inherited from the corresponding neighbor's right and down components, unless they are on an outer edge
				//Left components have the added complexity of having a chance to be an exit if on the left edge
				//If an aperture was not generated after these procedures, one will be given based on random chance and placement on the grid
				
				//Left component generation
				
				//If column is 0, means we are on the left side of the board
				//If exit hasn't been generated
				if ((column == 0) && (exitPlaced == false)) {
					//If exit is chosen to be placed by random chance, or we are on the last row, generate exit to left
					if ((generateExit(length)) || (row == length-1)) {
						left = CellComponents.EXIT;
						exitPlaced = true;
					} else {
						//Exit was not chosen to be placed yet, generate a wall on left
						left = CellComponents.WALL;
					}
				//Else if we are still on the left side, generate a wall
				} else if (column == 0){
					left = CellComponents.WALL;
				//Else set left to be previous cell's right component for consistency
				} else {
					left = cells.get(column - 1).getRight();	
					if (left == CellComponents.APERTURE) {
						hasAperture = true;
					}
				}
								
				//Up component generation
				
				//If the row is 0, we are at the top of the grid, generate a wall for the up component of the cell
				if (row == 0) {
					up = CellComponents.WALL;
				//Else, set the up component of the cell to be the down component of the cell above it
				} else {
					up = rows.get(row - 1).getCells().get(column).getDown();
					if (up == CellComponents.APERTURE) {
						hasAperture = true;
					}
				}
				
				//Right component generation
				
				//If the column is length - 1, means we are at right side -> generate wall on right
				if (column == (length - 1)) {
					right = CellComponents.WALL;
				//Else, generate the right component by random chance
				} else {
					right = randomComponent();
					if (right == CellComponents.APERTURE) {
						hasAperture = true;
					}
				}
				
				//Down component generation
				
				//If the row is length - 1, it is the bottom row, the bottom component should be set to a wall
				if (row == (length - 1)) {
					down = CellComponents.WALL;
				//Else, generate a random component
				} else {
					down = randomComponent();
					if (down == CellComponents.APERTURE) {
						hasAperture = true;
					}
				}
				
				//In case an aperture was not created
				//These are special cases where the logic for randomization must be changed
				if (hasAperture == false) {
					int randomNumber = random.nextInt(2);
					//Case 1: we are in the bottom right corner, meaning a left or up component must be changed
					if ((column == (length - 1)) && (row == (length - 1))) {
						if (randomNumber == 0) {
							left = CellComponents.APERTURE;
							//Change neighbor for consistency
							cells.get(column-1).setRight(left);
						} else {
							up = CellComponents.APERTURE;
							//Change neighbor for consistency
							rows.get(row-1).getCells().get(column).setDown(up);
						}
					//Case 2: we are on the right side of the grid, meaning we must not change the right side
					//we will randomly choose a left or down component to be changed -> to keep it random
					} else if (column == (length - 1)) {
						if (randomNumber == 0) {
							left = CellComponents.APERTURE;
							//Change neighbor for consistency
							cells.get(column-1).setRight(left);
						} else {
							down = CellComponents.APERTURE;
						}
					//Case 3: we are on the bottom of the grid, meaning we must not change the down component
					//We will randomly choose a right or up component to be changed
					} else if (row == (length - 1)) {
						if (randomNumber == 0) {
							right = CellComponents.APERTURE;
						} else {
							up = CellComponents.APERTURE;
							//Change neighbor for consistency
							rows.get(row-1).getCells().get(column).setDown(up);
						}
					//Case 4: no special cases are met, therefore we can randomly set right or down to be an aperture
					} else {
						if (randomNumber == 0) {
							right = CellComponents.APERTURE;
						} else {
							down = CellComponents.APERTURE;
						}
					}
					hasAperture = true;
				}
				
				//Create a new cell with the found components and append it to the cells ArrayList
				Cell cell = new Cell(left, right, up, down);
				cells.add(cell);
			}
			//Append the cells ArrayList to the rows ArrayList as a new row
			Row newRow = new Row(cells);
			rows.add(newRow);
		}
		
		return new Grid(rows);
	}
	
	private boolean generateExit(int length) {
		Random random = new Random();
		int randomNumber = random.nextInt(length);
		if (randomNumber == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	private CellComponents randomComponent() {
		Random random = new Random();
		int randomNumber = random.nextInt(2);
		if (randomNumber == 0) {
			return CellComponents.WALL;
		} else {
			return CellComponents.APERTURE;
		}
	}

	public boolean play(Movement direction, Player player) {
		if ((direction == null) || (player == null) || (player.getCurrentCell() == null)) {
			return false;
		}
		Cell currentCell = player.getCurrentCell();
		switch (direction) {
		case DOWN:
			if (currentCell.getDown() == CellComponents.APERTURE) {
				movePlayer(Movement.DOWN, player);
				return true;
			}
			break;
		case LEFT:
			if (currentCell.getLeft() == CellComponents.APERTURE) {
				movePlayer(Movement.LEFT, player);
				return true;
			} else if (currentCell.getLeft() == CellComponents.EXIT) {
				player.setCurrentCell(null);
				player.setCurrentRow(null);
				return true;
			}
			break;
		case RIGHT:
			if (currentCell.getRight() == CellComponents.APERTURE) {
				movePlayer(Movement.RIGHT, player);
				return true;
			}
			break;
		case UP:
			if (currentCell.getUp() == CellComponents.APERTURE) {
				movePlayer(Movement.UP, player);
				return true;
			}
			break;
		default:
			break;
		}
		return false;
	}
	
	private void movePlayer(Movement direction, Player player) {
		int currentRowIndex = grid.getRows().indexOf(player.getCurrentRow());
		int currentCellIndex = player.getCurrentRow().getCells().indexOf(player.getCurrentCell());
		switch (direction) {
		case DOWN:
			player.setCurrentRow(grid.getRows().get(currentRowIndex+1));
			player.setCurrentCell(player.getCurrentRow().getCells().get(currentCellIndex));
			break;
		case LEFT:
			player.setCurrentCell(player.getCurrentRow().getCells().get(currentCellIndex-1));
			break;
		case RIGHT:
			player.setCurrentCell(player.getCurrentRow().getCells().get(currentCellIndex+1));
			break;
		case UP:
			player.setCurrentRow(grid.getRows().get(currentRowIndex-1));
			player.setCurrentCell(player.getCurrentRow().getCells().get(currentCellIndex));
			break;
		default:
			break;
		}
	}
	
	@Override
	public String toString() {
		return ("Game [grid=" + grid.toString() + "]");
	}
	
	public void printGame(Player player) {
		ArrayList<Row> rows = grid.getRows();
		String formattedBoard = new String();
		for (int currentRow = 0; currentRow < size; currentRow++) {
			ArrayList<Cell> currentCells = rows.get(currentRow).getCells();
			for (int currentColumn = 0; currentColumn < size; currentColumn++) {
				Cell currentCell = currentCells.get(currentColumn);
				if (containsExit(currentCell)) {
					formattedBoard = formattedBoard.concat("E");
				} else if (currentCell == player.getCurrentCell()) {
					formattedBoard = formattedBoard.concat("A");
				} else {
					formattedBoard = formattedBoard.concat("S");
				}
				if (currentColumn == (size - 1)) {
					formattedBoard = formattedBoard.concat("\n");
				} else {
					formattedBoard = formattedBoard.concat(" ");
				}
			}
		}
		System.out.println(formattedBoard);
	}
	
	private boolean containsExit(Cell cell) {
		if ((cell.getLeft() == CellComponents.EXIT)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void setAgentBeginning(Player player) {
		player.setCurrentRow(grid.getRows().get(size-1));
		player.setCurrentCell(grid.getRows().get(size-1).getCells().get(size-1));
	}


}
