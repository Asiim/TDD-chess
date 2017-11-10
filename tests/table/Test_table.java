package table;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sun.prism.paint.Color;

import figures.Pawn;
import figures.Rock;


public class Test_table {

	private Table table;
	private int table_width;
	private int table_length;
	
	@Before
	public void setUp() {
		table = new Table();
		table_width = Table.get_TABLE_WIDHT();
		table_length = Table.get_TABLE_LENGTH();
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
		table.get_square()[0][0].set_figure(pawn);
		assertEquals(pawn, table.get_square()[0][0].get_figure());
	}	
	
	@Test
	public void test_place_two_figure_on_different_places() {
		Pawn pawn = new Pawn();
		Rock rock = new Rock();
		table.get_square()[0][0].set_figure(pawn);
		table.get_square()[6][5].set_figure(rock);
		assertEquals(pawn, table.get_square()[0][0].get_figure());
		assertEquals(rock, table.get_square()[6][5].get_figure());
	}
	
	@Test
	public void test_place_two_figure_on_same_place() {
		Pawn pawn = new Pawn();
		Rock rock = new Rock();
		table.get_square()[0][0].set_figure(pawn);
		table.get_square()[0][0].set_figure(rock);
		assertNotEquals(rock, table.get_square()[0][0].get_figure());
		assertEquals(pawn, table.get_square()[0][0].get_figure());
	}
	
}
