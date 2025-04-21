package hw4.simulation;

import java.util.ArrayList;
import java.util.Random;

import hw4.game.Game;
import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;

public class Simulation {

	public static void main(String[] args) {
		Game game = new Game(3);
		Player player = new Player(null, null);
		Random random = new Random();
		System.out.println("=======================");
		System.out.println("Random Grid Generation");
		System.out.println("=======================");
		for (int i = 1; i <= 5; i++) {
			int size = random.nextInt(3, 8);
			System.out.println("Grid " + i + ": Size = " + size);
			game.setGrid(game.createRandomGrid(size));
			game.setAgentBeginning(player);
			game.printGame(player);
		}
		System.out.println("====================");
		System.out.println("Gameplay Simulation");
		System.out.println("====================");
		game = new Game(createGrid());
		game.setAgentBeginning(player);
		System.out.println("Start");
		game.printGame(player);
		playGame(game, player, Movement.UP);
		playGame(game, player, Movement.UP);
		playGame(game, player, Movement.UP);
		playGame(game, player, Movement.LEFT);
		playGame(game, player, Movement.DOWN);
		playGame(game, player, Movement.LEFT);
		playGame(game, player, Movement.UP);
		playGame(game, player, Movement.LEFT);
		playGame(game, player, Movement.LEFT);
	}
	
	private static boolean playGame(Game game, Player player, Movement direction) {
		switch (direction) {
		case DOWN:
			if (game.play(direction, player)) {
				System.out.println("Successfully moved down");
			} else {
				System.out.println("Ran into a wall trying to go down");
			}
			break;
		case LEFT:
			if (game.play(direction, player)) {
				System.out.println("Successfully moved left");
				if (player.getCurrentCell() == null) {
					System.out.println("You've escaped!");
					return true;
				}
			} else {
				System.out.println("Ran into a wall trying to go left");
			}
			break;
		case RIGHT:
			if (game.play(direction, player)) {
				System.out.println("Successfully moved right");
			} else {
				System.out.println("Ran into a wall trying to go right");
			}
			break;
		case UP:
			if (game.play(Movement.UP, player)) {
				System.out.println("Successfully moved up");
			} else {
				System.out.println("Ran into a wall trying to go up");
			}
			break;
		default:
			break;
		}
		game.printGame(player);
		return false;
	}
	
	private static Grid createGrid() {
		Cell cell00 = new Cell(CellComponents.EXIT, CellComponents.APERTURE,
				CellComponents.WALL, CellComponents.APERTURE);

		Cell cell01 = new Cell(CellComponents.APERTURE, CellComponents.WALL,
				CellComponents.WALL, CellComponents.APERTURE);

		Cell cell02 = new Cell(CellComponents.WALL, CellComponents.WALL,
				CellComponents.WALL, CellComponents.APERTURE);

		Cell cell10 = new Cell(CellComponents.WALL, CellComponents.WALL,
				CellComponents.APERTURE, CellComponents.APERTURE);

		Cell cell11 = new Cell(CellComponents.WALL, CellComponents.APERTURE,
				CellComponents.APERTURE, CellComponents.APERTURE);

		Cell cell12 = new Cell(CellComponents.APERTURE, CellComponents.WALL,
				CellComponents.APERTURE, CellComponents.APERTURE);

		Cell cell20 = new Cell(CellComponents.WALL, CellComponents.WALL,
				CellComponents.APERTURE, CellComponents.WALL);

		Cell cell21 = new Cell(CellComponents.WALL, CellComponents.WALL,
				CellComponents.APERTURE, CellComponents.WALL);

		Cell cell22 = new Cell(CellComponents.WALL, CellComponents.WALL,
				CellComponents.APERTURE, CellComponents.WALL);


		ArrayList<Cell> cells = new ArrayList<Cell>();
		cells.add(0, cell00);
		cells.add(1, cell01);
		cells.add(2, cell02);
		Row row0 = new Row(cells);

		cells = new ArrayList<Cell>();
		cells.add(0, cell10);
		cells.add(1, cell11);
		cells.add(2, cell12);
		Row row1 = new Row(cells);

		cells = new ArrayList<Cell>();
		cells.add(0, cell20);
		cells.add(1, cell21);
		cells.add(2, cell22);
		Row row2 = new Row(cells);

		ArrayList<Row> rows = new ArrayList<Row>();
		rows.add(0, row0);
		rows.add(1, row1);
		rows.add(2, row2);
		
		Grid grid = new Grid(rows);
		return grid;
	}
}
