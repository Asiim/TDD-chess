package table;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import enums.Color;
import figures.Bishop;
import figures.Figure;
import figures.King;
import figures.Knight;
import figures.Pawn;
import figures.Queen;
import figures.Rook;


public class Test_table {

	private Table table;
	private int table_width;
	private int table_length;
	
	@Before
	public void setUp() {
		table = new Table();
		table_width = 8;
		table_length = 8;
	}
	
	@Test
	public void test_init_table() {
		assertNotNull(table);
	}

	@Test
	public void test_table_size() {
		assertEquals(8, table_width);
		for(int i = 0; i < table_length; i++) {
			assertEquals(8, table.get_square()[i].length);
		}
	}
	
	@Test
	public void test_square_init_in_table() {
		for (int i = 0; i < table_width; i++) {
			for (int j = i % 2; j < table_length; j += 2) {
				assertNotNull(table.get_square()[i][j]);
			}
		}
	}
	
	@Test
	public void test_first_square_color_is_black() {
		assertEquals(Color.BLACK, table.get_square()[0][0].get_color());
	}
	
	@Test
	public void test_black_table_squares() {
		for (int i = 0; i < table_width; i++) {
			for (int j = i % 2; j < table_length; j += 2) {
				assertEquals(Color.BLACK, table.get_square()[i][j].get_color());
			}
		}
	}
	
	@Test
	public void test_white_table_squares() {
		for (int i = 0; i < table_width; i++) {
			for (int j = (i + 1) % 2; j < table_length; j += 2) {
				assertEquals(Color.WHITE, table.get_square()[i][j].get_color());
			}
		}
	}
	
	@Test
	public void test_place_one_figure_on_the_table() {
		Pawn pawn = new Pawn();
		table.get_square()[2][1].set_figure(pawn);
		assertEquals(pawn, table.get_square()[2][1].get_figure());
	}	
	
	@Test
	public void test_place_two_figure_on_different_places() {
		Pawn pawn = new Pawn();
		Rook rook = new Rook();
		table.get_square()[2][1].set_figure(pawn);
		table.get_square()[5][4].set_figure(rook);
		assertEquals(pawn, table.get_square()[2][1].get_figure());
		assertEquals(rook, table.get_square()[5][4].get_figure());
	}
	
	@Test
	public void test_place_two_figure_on_same_place() {
		Pawn pawn = new Pawn();
		Rook rook = new Rook();
		table.get_square()[2][1].set_figure(pawn);
		table.get_square()[2][1].set_figure(rook);
		assertNotEquals(rook, table.get_square()[2][1].get_figure());
		assertEquals(pawn, table.get_square()[2][1].get_figure());
	}
	
	@Test
	public void test_place_all_figures_of_one_player() {
		table.set_figures_on_table();
		assertEquals(new Rook().getClass(), table.get_square()[0][0].get_figure().getClass());
		assertEquals(new Rook().getClass(), table.get_square()[0][7].get_figure().getClass());
		assertEquals(new Knight().getClass(), table.get_square()[0][1].get_figure().getClass());
		assertEquals(new Knight().getClass(), table.get_square()[0][6].get_figure().getClass());
		assertEquals(new Bishop().getClass(), table.get_square()[0][2].get_figure().getClass());
		assertEquals(new Bishop().getClass(), table.get_square()[0][5].get_figure().getClass());
		assertEquals(new Queen().getClass(), table.get_square()[0][3].get_figure().getClass());
		assertEquals(new King().getClass(), table.get_square()[0][4].get_figure().getClass());
		for (int i = 0; i < table_length; i++) {
			assertEquals(new Pawn().getClass(), table.get_square()[1][i].get_figure().getClass());
		}
	}
	
	@Test
	public void test_place_all_figures_of_both_player() {
		table.set_figures_on_table();
		check_figure_on_square(new Rook(Color.WHITE, 0, 0), 0, 0);
		check_figure_on_square(new Rook(Color.WHITE, 0, 7), 0, 7);
		check_figure_on_square(new Knight(Color.WHITE, 0, 1), 0, 1);
		check_figure_on_square(new Knight(Color.WHITE, 0, 6), 0, 6);
		check_figure_on_square(new Bishop(Color.WHITE, 0, 2), 0, 2);
		check_figure_on_square(new Bishop(Color.WHITE, 0, 5), 0, 5);
		check_figure_on_square(new Queen(Color.WHITE, 0, 3), 0, 3);
		check_figure_on_square(new King(Color.WHITE, 0, 4), 0, 4);
		for (int i = 0; i < table_length; i++) {
			check_figure_on_square(new Pawn(Color.WHITE, 1, i), 1, i);
		}
		
		check_figure_on_square(new Rook(Color.BLACK, 7, 7), 7, 7);
		check_figure_on_square(new Rook(Color.BLACK, 7, 0), 7, 0);
		check_figure_on_square(new Knight(Color.BLACK, 7, 6), 7, 6);
		check_figure_on_square(new Knight(Color.BLACK, 7, 1), 7, 1);
		check_figure_on_square(new Bishop(Color.BLACK, 7, 5), 7, 5);
		check_figure_on_square(new Bishop(Color.BLACK, 7, 2), 7, 2);
		check_figure_on_square(new Queen(Color.BLACK, 7, 3), 7, 3);
		check_figure_on_square(new King(Color.BLACK, 7, 4), 7, 4);
		for (int i = 0; i < table_length; i++) {
			check_figure_on_square(new Pawn(Color.BLACK, 1, i), 6, i);
		}
	}
	
	@Test
	public void test_get_square_at_position() {
		assertEquals(table.get_square_at_position(1, 2), table.get_square()[1][2]);
		assertNotEquals(table.get_square_at_position(1, 2), table.get_square()[1][3]);
	}
	
	@Test
	public void test_is_square_empty() {
		table.set_figures_on_table();
		assertTrue(table.is_empty(2, 2));
		assertTrue(table.is_empty(3, 5));
		assertTrue(table.is_empty(4, 7));
		assertTrue(table.is_empty(5, 6));
		assertFalse(table.is_empty(0, 0));
		assertFalse(table.is_empty(7, 7));
		assertFalse(table.is_empty(0, 6));
		assertFalse(table.is_empty(7, 1));
		assertFalse(table.is_empty(0, 2));
		assertFalse(table.is_empty(7, 5));
		assertFalse(table.is_empty(0, 4));
		assertFalse(table.is_empty(7, 4));
		assertFalse(table.is_empty(0, 3));
		assertFalse(table.is_empty(7, 3));
		assertFalse(table.is_empty(1, 3));
		assertFalse(table.is_empty(1, 1));
	}
	
	@Test
	public void test_is_figure_on_square() {
		table.set_figures_on_table();
		assertFalse(table.has_figure(2, 2));
		assertFalse(table.has_figure(3, 5));
		assertFalse(table.has_figure(4, 7));
		assertFalse(table.has_figure(5, 6));
		assertTrue(table.has_figure(0, 0));
		assertTrue(table.has_figure(7, 7));
		assertTrue(table.has_figure(0, 6));
		assertTrue(table.has_figure(7, 1));
		assertTrue(table.has_figure(0, 2));
		assertTrue(table.has_figure(7, 5));
		assertTrue(table.has_figure(0, 4));
		assertTrue(table.has_figure(7, 4));
		assertTrue(table.has_figure(0, 3));
		assertTrue(table.has_figure(7, 3));
		assertTrue(table.has_figure(1, 3));
		assertTrue(table.has_figure(1, 1));
	}
	
	private void check_figure_on_square(Figure figure, int x, int y) {
		assertTrue((figure.getClass() == table.get_square()[x][y].get_figure().getClass()) &&
				(figure.get_color() == table.get_square()[x][y].get_figure().get_color()));
	}
	
}
