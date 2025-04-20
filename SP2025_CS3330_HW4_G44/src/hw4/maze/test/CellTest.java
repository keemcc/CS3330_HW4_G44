package hw4.maze.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

class CellTest {
	
	private Cell cell = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		cell = new Cell(CellComponents.WALL, 
							CellComponents.EXIT, 
							CellComponents.APERTURE, 
							CellComponents.WALL);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testToString() {
		assertEquals("Cell [left=" + cell.getLeft() + ", right=" + cell.getRight() + ", up=" + cell.getUp() + ", down=" + cell.getDown() + "]", cell.toString());
	}
	
	@ParameterizedTest
	@MethodSource("providingGetterReturns")
	void testGetters(CellComponents actual, CellComponents expected) {
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> providingGetterReturns() {
		Cell cellGetterComponents = new Cell(CellComponents.WALL, 
				CellComponents.EXIT, 
				CellComponents.APERTURE, 
				CellComponents.WALL);
		return Stream.of(Arguments.of(cellGetterComponents.getLeft(), CellComponents.WALL),
							Arguments.of(cellGetterComponents.getRight(), CellComponents.EXIT),
							Arguments.of(cellGetterComponents.getUp(), CellComponents.APERTURE),
							Arguments.of(cellGetterComponents.getDown(), CellComponents.WALL));
	}
	

	@Test
	void testSetUpWithValidCellComponent() {
		Cell cell = new Cell(CellComponents.WALL, 
				CellComponents.EXIT, 
				CellComponents.APERTURE, 
				CellComponents.WALL);
		cell.setUp(CellComponents.WALL);
		assertEquals(CellComponents.WALL, cell.getUp());
	}
	
	@Test
	void testSetUpWithNullCellComponent() {
		Cell cell = new Cell(CellComponents.WALL, 
				CellComponents.EXIT, 
				CellComponents.APERTURE, 
				CellComponents.WALL);
		cell.setUp(null);
		assertEquals(CellComponents.WALL, cell.getUp());
	}
	
	@Test
	void testSetDownWithValidCellComponent() {
		Cell cell = new Cell(CellComponents.WALL, 
				CellComponents.EXIT, 
				CellComponents.APERTURE, 
				CellComponents.WALL);
		cell.setDown(CellComponents.APERTURE);
		assertEquals(CellComponents.APERTURE, cell.getDown());
	}
	
	@Test
	void testSetDownWithNullCellComponent() {
		Cell cell = new Cell(CellComponents.WALL, 
				CellComponents.EXIT, 
				CellComponents.WALL, 
				CellComponents.APERTURE);
		cell.setDown(null);
		assertEquals(CellComponents.WALL, cell.getDown());
	}
	
	@Test
	void testSetLeftWithValidCellComponent() {
		Cell cell = new Cell(CellComponents.WALL, 
				CellComponents.EXIT, 
				CellComponents.APERTURE, 
				CellComponents.WALL);
		cell.setLeft(CellComponents.APERTURE);
		assertEquals(CellComponents.APERTURE, cell.getLeft());
	}
	
	@Test
	void testSetLeftWithNullCellComponent() {
		Cell cell = new Cell(CellComponents.APERTURE, 
				CellComponents.EXIT, 
				CellComponents.APERTURE, 
				CellComponents.WALL);
		cell.setLeft(null);
		assertEquals(CellComponents.WALL, cell.getLeft());
	}
	
	@Test
	void testSetRightWithValidCellComponent() {
		Cell cell = new Cell(CellComponents.WALL, 
				CellComponents.WALL, 
				CellComponents.APERTURE, 
				CellComponents.WALL);
		cell.setRight(CellComponents.EXIT);
		assertEquals(CellComponents.EXIT, cell.getRight());
	}
	
	@Test
	void testSetRightWithNullCellComponent() {
		Cell cell = new Cell(CellComponents.APERTURE, 
				CellComponents.EXIT, 
				CellComponents.APERTURE, 
				CellComponents.WALL);
		cell.setRight(null);
		assertEquals(CellComponents.WALL, cell.getRight());
	}
	
	
}
