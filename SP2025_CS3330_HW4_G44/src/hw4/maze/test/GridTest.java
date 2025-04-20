package hw4.maze.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;

class GridTest {

	private static Grid grid;

	private static ArrayList<Row> rowList;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
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
		rowList = new ArrayList<>();
		rowList = rows;
		grid = new Grid(rows);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetGrid() {
		assertEquals(rowList, grid.getRows());
	}
	
	@Test
	void testSetGrid() {
		grid.setRows(null);
		assertEquals(null, grid.getRows());
	}
	
	@Test 
	void testToString() {
		
		assertEquals("Grid [rows=["
				+ "Row [cells=["
					+ "Cell [left=EXIT, right=APERTURE, up=WALL, down=APERTURE], "
					+ "Cell [left=APERTURE, right=WALL, up=WALL, down=APERTURE], "
					+ "Cell [left=WALL, right=WALL, up=WALL, down=APERTURE]]], "
				+ "Row [cells=["
					+ "Cell [left=WALL, right=WALL, up=APERTURE, down=APERTURE], "
					+ "Cell [left=WALL, right=APERTURE, up=APERTURE, down=APERTURE], "
					+ "Cell [left=APERTURE, right=WALL, up=APERTURE, down=APERTURE]]], "
				+ "Row [cells=["
					+ "Cell [left=WALL, right=WALL, up=APERTURE, down=WALL], "
					+ "Cell [left=WALL, right=WALL, up=APERTURE, down=WALL], "
					+ "Cell [left=WALL, right=WALL, up=APERTURE, down=WALL]]]]]", grid.toString());
		
	}

}
