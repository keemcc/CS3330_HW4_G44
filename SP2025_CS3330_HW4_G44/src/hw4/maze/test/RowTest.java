package hw4.maze.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Row;

class RowTest {
	
	private static Cell cell0;
	private static Cell cell1;
	private static Cell cell2;
	
	private static Row row;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		cell0 = new Cell(CellComponents.EXIT, CellComponents.APERTURE,
				CellComponents.WALL, CellComponents.APERTURE);
		
		cell1 = new Cell(CellComponents.APERTURE, CellComponents.WALL,
				CellComponents.WALL, CellComponents.APERTURE);
		
		cell2 = new Cell(CellComponents.WALL, CellComponents.WALL,
				CellComponents.WALL, CellComponents.APERTURE);
		
		ArrayList<Cell> cells = new ArrayList<>();
		
		cells.add(cell0);
		cells.add(cell1);
		cells.add(cell2);
		
		row = new Row(cells);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	public void testGetCellsSize() {
		assertEquals(3, row.getCells().size());
	}
	
	@ParameterizedTest
	@MethodSource("getCellProvider")
	public void testGetCell(Cell expectedCell, Cell actualCell) {
		assertEquals(expectedCell, actualCell);
	}
	
	private static Stream<Arguments> getCellProvider() {
		return Stream.of(Arguments.of(cell0, row.getCells().get(0)),
							Arguments.of(cell1, row.getCells().get(1)),
							Arguments.of(cell2, row.getCells().get(2)));
	}
	
	@Test
	public void testSetCell() {
		Cell cell3 = new Cell(CellComponents.WALL, CellComponents.WALL,
				CellComponents.APERTURE, CellComponents.APERTURE);
		
		Cell cell4 = new Cell(CellComponents.WALL, CellComponents.APERTURE,
				CellComponents.APERTURE, CellComponents.APERTURE);
		
		Cell cell5 = new Cell(CellComponents.APERTURE, CellComponents.WALL,
				CellComponents.APERTURE, CellComponents.APERTURE);
		
		ArrayList<Cell> cellList = new ArrayList<>();
		cellList.add(cell3);
		cellList.add(cell4);
		cellList.add(cell5);
		row.setCells(cellList);
		
		assertEquals(cellList, row.getCells());
	}
	
	@Test
	void testSetCellsWithNull() {
		row.setCells(null);
		assertEquals(null, row.getCells());
	}

	@Test
	public void testToString() {
		assertEquals("Row [cells=["
							+ "Cell [left=EXIT, right=APERTURE, up=WALL, down=APERTURE], "
							+ "Cell [left=APERTURE, right=WALL, up=WALL, down=APERTURE], "
							+ "Cell [left=WALL, right=WALL, up=WALL, down=APERTURE]]]", row.toString());
	}

}
