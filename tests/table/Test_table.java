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
		table_width = table.get_width();
		table_length = table.get_length();
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
	
	@Test
	public void test_rotate_table() {
		table.set_figures_on_table();
		Table table2 = new Table();	
		for(int i = 0; i < table_width; i++) {
			for(int j=0; j < table_length; j++) {
				table2.get_square_at_position(i, j).set_color(table.get_square_at_position(i, j).get_color());
				table2.get_square_at_position(i, j).set_figure(table.get_square_at_position(i, j).get_figure());
			}
		}
		table2.rotate();
		for(int i = 0; i < table_width; i++) {
			for(int j=0; j < table_length; j++) {
				assertEquals(table.get_square_at_position(i, j), table2.get_square_at_position(table_width - i - 1, table_length - j -1));
			}
		}
	}
	
	@Test
	public void test_field_occupied_by_rook_same_column_higher_row() {
		table.get_square_at_position(5, 2).set_figure(new Rook(Color.WHITE, 5, 2));
		assertTrue(table.square_occupied(3, 2, Color.BLACK));
		table = new Table();
		table.get_square_at_position(7, 0).set_figure(new Rook(Color.WHITE, 7, 0));
		assertTrue(table.square_occupied(0, 0, Color.BLACK));
		table = new Table();
		table.get_square_at_position(7, 7).set_figure(new Rook(Color.WHITE, 7, 7));
		assertTrue(table.square_occupied(0, 7, Color.BLACK));
	}
	
	@Test
	public void test_field_occupied_by_rook_same_column_lower_row() {
		table.get_square_at_position(1, 2).set_figure(new Rook(Color.BLACK, 1, 2));
		assertTrue(table.square_occupied(7, 2, Color.WHITE));
		table = new Table();
		table.get_square_at_position(0, 0).set_figure(new Rook(Color.WHITE, 0, 0));
		assertTrue(table.square_occupied(7, 0, Color.BLACK));
		table = new Table();
		table.get_square_at_position(0, 7).set_figure(new Rook(Color.WHITE, 0, 7));
		assertTrue(table.square_occupied(7, 7, Color.BLACK));
	}
	
	@Test
	public void test_field_occupied_by_rook_higher_column_same_row() {
		table.get_square_at_position(1, 6).set_figure(new Rook(Color.BLACK, 1, 6));
		assertTrue(table.square_occupied(1, 2, Color.WHITE));
		table = new Table();
		table.get_square_at_position(0, 7).set_figure(new Rook(Color.WHITE, 0, 7));
		assertTrue(table.square_occupied(0, 0, Color.BLACK));
		table = new Table();
		table.get_square_at_position(7, 7).set_figure(new Rook(Color.WHITE, 7, 7));
		assertTrue(table.square_occupied(7, 0, Color.BLACK));
	}
	
	@Test
	public void test_field_occupied_by_rook_lower_column_same_row() {
		table.get_square_at_position(3, 3).set_figure(new Rook(Color.BLACK, 3, 3));
		assertTrue(table.square_occupied(3, 7, Color.WHITE));
		table = new Table();
		table.get_square_at_position(0, 0).set_figure(new Rook(Color.WHITE, 0, 0));
		assertTrue(table.square_occupied(0, 7, Color.BLACK));
		table = new Table();
		table.get_square_at_position(7, 0).set_figure(new Rook(Color.WHITE, 7, 0));
		assertTrue(table.square_occupied(7, 7, Color.BLACK));
	}

	@Test
	public void test_field_not_occupied_by_rook_on_same_row_higher_column_figuure_between_field_and_rook() {
		table.get_square_at_position(6, 7).set_figure(new Rook(Color.WHITE, 6, 7));
		table.get_square_at_position(6, 5).set_figure(new Pawn(Color.WHITE, 6, 5));
		assertFalse(table.square_occupied(6, 2, Color.BLACK));
	}

	@Test
	public void test_field_not_occupied_by_rook_on_same_row_lower_column_figuure_between_field_and_rook() {
		table.get_square_at_position(6, 1).set_figure(new Rook(Color.WHITE, 6, 1));
		table.get_square_at_position(6, 5).set_figure(new Pawn(Color.WHITE, 6, 5));
		assertFalse(table.square_occupied(6, 7, Color.BLACK));
	}

	@Test
	public void test_field_not_occupied_by_rook_on_higher_row_same_column_figuure_between_field_and_rook() {
		table.get_square_at_position(4, 4).set_figure(new Rook(Color.WHITE, 4, 4));
		table.get_square_at_position(3, 4).set_figure(new Pawn(Color.WHITE, 3, 4));
		assertFalse(table.square_occupied(0, 4, Color.BLACK));
	}

	@Test
	public void test_field_not_occupied_by_rook_on_lower_row_same_column_figuure_between_field_and_rook() {
		table.get_square_at_position(4, 4).set_figure(new Rook(Color.WHITE, 4, 4));
		table.get_square_at_position(6, 4).set_figure(new Pawn(Color.WHITE, 6, 4));
		assertFalse(table.square_occupied(7, 4, Color.BLACK));
	}
	
	@Test
	public void test_two_rooks_on_same_column_target_field_between_and_figuure_between_field_and_one_rook() {
		table.get_square_at_position(7, 6).set_figure(new Rook(Color.WHITE, 7, 6));
		table.get_square_at_position(1, 6).set_figure(new Rook(Color.WHITE, 1, 6));
		table.get_square_at_position(2, 6).set_figure(new Pawn(Color.WHITE, 2, 6));
		assertTrue(table.square_occupied(3, 6, Color.BLACK));
		table = new Table();
		table.get_square_at_position(7, 6).set_figure(new Rook(Color.WHITE, 7, 6));
		table.get_square_at_position(1, 6).set_figure(new Rook(Color.WHITE, 1, 6));
		table.get_square_at_position(5, 6).set_figure(new Pawn(Color.WHITE, 5, 6));
		assertTrue(table.square_occupied(3, 6, Color.BLACK));
	}
	
	@Test
	public void test_two_rooks_on_same_row_target_field_between_and_figuure_between_field_and_one_rook() {
		table.get_square_at_position(6, 7).set_figure(new Rook(Color.WHITE, 6, 7));
		table.get_square_at_position(6, 1).set_figure(new Rook(Color.WHITE, 6, 1));
		table.get_square_at_position(6, 2).set_figure(new Pawn(Color.WHITE, 6, 2));
		assertTrue(table.square_occupied(6, 3, Color.BLACK));
		table = new Table();
		table.get_square_at_position(6, 7).set_figure(new Rook(Color.WHITE, 6, 7));
		table.get_square_at_position(6, 1).set_figure(new Rook(Color.WHITE, 6, 1));
		table.get_square_at_position(6, 5).set_figure(new Pawn(Color.WHITE, 6, 5));
		assertTrue(table.square_occupied(6, 3, Color.BLACK));
	}
	
	@Test
	public void test_one_rook_on_lower_row_one_on_higher_column_like_target_field_and_figuure_between_field_and_one_rook() {
		table.get_square_at_position(6, 7).set_figure(new Rook(Color.WHITE, 6, 7));
		table.get_square_at_position(2, 3).set_figure(new Rook(Color.WHITE, 2, 3));
		table.get_square_at_position(6, 5).set_figure(new Pawn(Color.WHITE, 6, 5));
		assertTrue(table.square_occupied(6, 3, Color.BLACK));
		table = new Table();
		table.get_square_at_position(6, 7).set_figure(new Rook(Color.WHITE, 6, 7));
		table.get_square_at_position(2, 3).set_figure(new Rook(Color.WHITE, 2, 3));
		table.get_square_at_position(4, 3).set_figure(new Pawn(Color.WHITE, 4, 3));
		assertTrue(table.square_occupied(6, 3, Color.BLACK));
	}
	
	@Test
	public void test_one_rook_on_lower_row_one_on_lower_column_like_target_field_and_figuure_between_field_and_one_rook() {
		table.get_square_at_position(6, 1).set_figure(new Rook(Color.WHITE, 6, 1));
		table.get_square_at_position(2, 3).set_figure(new Rook(Color.WHITE, 2, 3));
		table.get_square_at_position(6, 2).set_figure(new Pawn(Color.WHITE, 6, 2));
		assertTrue(table.square_occupied(6, 3, Color.BLACK));
		table = new Table();
		table.get_square_at_position(6, 1).set_figure(new Rook(Color.WHITE, 6, 1));
		table.get_square_at_position(2, 3).set_figure(new Rook(Color.WHITE, 2, 3));
		table.get_square_at_position(4, 3).set_figure(new Pawn(Color.WHITE, 4, 3));
		assertTrue(table.square_occupied(6, 3, Color.BLACK));
	}
	
	@Test
	public void test_one_rook_on_higher_row_one_on_higher_column_like_target_field_and_figuure_between_field_and_one_rook() {
		table.get_square_at_position(5, 2).set_figure(new Rook(Color.WHITE, 5, 2));
		table.get_square_at_position(2, 4).set_figure(new Rook(Color.WHITE, 2, 4));
		table.get_square_at_position(4, 2).set_figure(new Pawn(Color.WHITE, 4, 2));
		assertTrue(table.square_occupied(2, 2, Color.BLACK));
		table = new Table();
		table.get_square_at_position(5, 2).set_figure(new Rook(Color.WHITE, 5, 2));
		table.get_square_at_position(2, 4).set_figure(new Rook(Color.WHITE, 2, 4));
		table.get_square_at_position(2, 3).set_figure(new Pawn(Color.WHITE, 2, 3));
		assertTrue(table.square_occupied(2, 2, Color.BLACK));
	}
	
	@Test
	public void test_one_rook_on_higher_row_one_on_lower_column_like_target_field_and_figuure_between_field_and_one_rook() {
		table.get_square_at_position(0, 2).set_figure(new Rook(Color.WHITE, 0, 2));
		table.get_square_at_position(2, 4).set_figure(new Rook(Color.WHITE, 2, 4));
		table.get_square_at_position(1, 2).set_figure(new Pawn(Color.WHITE, 1, 2));
		assertTrue(table.square_occupied(2, 2, Color.BLACK));
		table = new Table();
		table.get_square_at_position(5, 2).set_figure(new Rook(Color.WHITE, 5, 2));
		table.get_square_at_position(2, 4).set_figure(new Rook(Color.WHITE, 2, 4));
		table.get_square_at_position(2, 3).set_figure(new Pawn(Color.WHITE, 2, 3));
		assertTrue(table.square_occupied(2, 2, Color.BLACK));
	}
	
	@Test
	public void test_field_occupied_by_bishop_higher_row_higher_column() {
		table.get_square_at_position(6, 7).set_figure(new Bishop(Color.BLACK, 6, 7));
		assertTrue(table.square_occupied(3, 4, Color.WHITE));
		table = new Table();
		table.get_square_at_position(7, 7).set_figure(new Bishop(Color.BLACK, 7, 7));
		assertTrue(table.square_occupied(0, 0, Color.WHITE));
	}
	
	@Test
	public void test_field_occupied_by_bishop_higher_row_lower_column() {
		table.get_square_at_position(7, 1).set_figure(new Bishop(Color.BLACK, 6, 1));
		assertTrue(table.square_occupied(4, 4, Color.WHITE));
		table = new Table();
		table.get_square_at_position(7, 0).set_figure(new Bishop(Color.BLACK, 7, 0));
		assertTrue(table.square_occupied(0, 7, Color.WHITE));
	}

	@Test
	public void test_field_occupied_by_bishop_lower_row_lower_column() {
		table.get_square_at_position(1, 1).set_figure(new Bishop(Color.BLACK, 0, 1));
		assertTrue(table.square_occupied(4, 4, Color.WHITE));
		table = new Table();
		table.get_square_at_position(0, 0).set_figure(new Bishop(Color.BLACK, 0, 0));
		assertTrue(table.square_occupied(7, 7, Color.WHITE));
	}

	@Test
	public void test_field_occupied_by_bishop_lower_row_higher_column() {
		table.get_square_at_position(0, 7).set_figure(new Bishop(Color.BLACK, 0, 7));
		assertTrue(table.square_occupied(3, 4, Color.WHITE));
		table = new Table();
		table.get_square_at_position(0, 7).set_figure(new Bishop(Color.BLACK, 0, 7));
		assertTrue(table.square_occupied(7, 0, Color.WHITE));
	}
	
	@Test
	public void test_field_not_occupied_by_bishop_higher_row_higher_column_figure_between() {
		table.get_square_at_position(6, 7).set_figure(new Bishop(Color.BLACK, 6, 7));
		table.get_square_at_position(5, 6).set_figure(new Pawn(Color.WHITE, 5, 6));
		assertFalse(table.square_occupied(3, 4, Color.WHITE));
	}
	
	@Test
	public void test_field_not_occupied_by_bishop_higher_row_lower_column_figure_between() {
		table.get_square_at_position(6, 1).set_figure(new Bishop(Color.BLACK, 6, 1));
		table.get_square_at_position(5, 2).set_figure(new Bishop(Color.WHITE, 5, 2));
		assertFalse(table.square_occupied(3, 4, Color.WHITE));
	}

	@Test
	public void test_field_not_occupied_by_bishop_lower_row_lower_column_figure_between() {
		table.get_square_at_position(0, 1).set_figure(new Bishop(Color.BLACK, 0, 1));
		table.get_square_at_position(1, 2).set_figure(new Bishop(Color.WHITE, 1, 2));
		assertFalse(table.square_occupied(3, 4, Color.WHITE));	
	}

	@Test
	public void test_field_not_occupied_by_bishop_lower_row_higher_column_figure_between() {
		table.get_square_at_position(0, 7).set_figure(new Bishop(Color.BLACK, 0, 7));
		table.get_square_at_position(1, 6).set_figure(new Bishop(Color.WHITE, 1, 6));
		assertFalse(table.square_occupied(3, 4, Color.WHITE));
	}
	
	@Test
	public void test_one_bishop_higher_column_and_row_and_other_bishop_lower_column_and_row_one_bishop_blocked() {
		table.get_square_at_position(6, 7).set_figure(new Bishop(Color.BLACK, 6, 7));
		table.get_square_at_position(1, 2).set_figure(new Bishop(Color.BLACK, 1, 2));
		table.get_square_at_position(5, 6).set_figure(new Pawn(Color.WHITE, 5, 6));
		assertTrue(table.square_occupied(3, 4, Color.WHITE));
		table = new Table();
		table.get_square_at_position(6, 7).set_figure(new Bishop(Color.BLACK, 6, 7));
		table.get_square_at_position(1, 2).set_figure(new Bishop(Color.BLACK, 1, 2));
		table.get_square_at_position(2, 3).set_figure(new Pawn(Color.WHITE, 2, 3));
		assertTrue(table.square_occupied(3, 4, Color.WHITE));
	}
	
	@Test
	public void test_one_bishop_higher_column_and_lower_row_and_other_bishop_lower_column_and_row_one_bishop_blocked() {
	table.get_square_at_position(0, 7).set_figure(new Bishop(Color.BLACK, 0, 7));
	table.get_square_at_position(1, 2).set_figure(new Bishop(Color.BLACK, 1, 2));
	table.get_square_at_position(1, 6).set_figure(new Pawn(Color.WHITE, 1, 6));
	assertTrue(table.square_occupied(3, 4, Color.WHITE));
	table = new Table();
	table.get_square_at_position(0, 7).set_figure(new Bishop(Color.BLACK, 0, 7));
	table.get_square_at_position(1, 2).set_figure(new Bishop(Color.BLACK, 1, 2));
	table.get_square_at_position(2, 3).set_figure(new Pawn(Color.WHITE, 2, 3));
	assertTrue(table.square_occupied(3, 4, Color.WHITE));
	}

	@Test
	public void test_one_bishop_lower_column_and_higher_row_and_other_bishop_lower_column_and_row_one_bishop_blocked() {
		table.get_square_at_position(6, 7).set_figure(new Bishop(Color.BLACK, 6, 7));
		table.get_square_at_position(1, 6).set_figure(new Bishop(Color.BLACK, 1, 6));
		table.get_square_at_position(5, 6).set_figure(new Pawn(Color.WHITE, 5, 6));
		assertTrue(table.square_occupied(3, 4, Color.WHITE));
		table = new Table();
		table.get_square_at_position(6, 7).set_figure(new Bishop(Color.BLACK, 6, 7));
		table.get_square_at_position(1, 6).set_figure(new Bishop(Color.BLACK, 1, 6));
		table.get_square_at_position(2, 5).set_figure(new Pawn(Color.WHITE, 2, 5));
		assertTrue(table.square_occupied(3, 4, Color.WHITE));
	}

	@Test
	public void test_one_bishop_lower_column_and_higher_row_and_other_bishop_higher_column_and_higher_row_one_bishop_blocked() {
		table.get_square_at_position(6, 0).set_figure(new Bishop(Color.BLACK, 6, 0));
		table.get_square_at_position(6, 6).set_figure(new Bishop(Color.BLACK, 6, 6));
		table.get_square_at_position(5, 5).set_figure(new Pawn(Color.WHITE, 5, 5));
		assertTrue(table.square_occupied(3, 3, Color.WHITE));
		table = new Table();
		table.get_square_at_position(6, 0).set_figure(new Bishop(Color.BLACK, 6, 0));
		table.get_square_at_position(6, 6).set_figure(new Bishop(Color.BLACK, 6, 6));
		table.get_square_at_position(4, 2).set_figure(new Pawn(Color.WHITE, 4, 2));
		assertTrue(table.square_occupied(3, 3, Color.WHITE));
	}
	
	@Test
	public void test_one_bishop_higher_column_and_lower_row_and_other_bishop_higher_column_and_higher_row_one_bishop_blocked() {
		table.get_square_at_position(0, 6).set_figure(new Bishop(Color.BLACK, 0, 6));
		table.get_square_at_position(6, 6).set_figure(new Bishop(Color.BLACK, 6, 6));
		table.get_square_at_position(5, 5).set_figure(new Pawn(Color.WHITE, 5, 5));
		assertTrue(table.square_occupied(3, 3, Color.WHITE));
		table = new Table();
		table.get_square_at_position(0, 6).set_figure(new Bishop(Color.BLACK, 0, 6));
		table.get_square_at_position(6, 6).set_figure(new Bishop(Color.BLACK, 6, 6));
		table.get_square_at_position(2, 4).set_figure(new Pawn(Color.WHITE, 2, 4));
		assertTrue(table.square_occupied(3, 3, Color.WHITE));
	}

	@Test
	public void test_one_bishop_higher_column_and_lower_row_and_other_bishop_lower_column_and_higher_row_one_bishop_blocked() {
		table.get_square_at_position(0, 6).set_figure(new Bishop(Color.BLACK, 0, 6));
		table.get_square_at_position(6, 0).set_figure(new Bishop(Color.BLACK, 6, 0));
		table.get_square_at_position(4, 2).set_figure(new Pawn(Color.WHITE, 4, 2));
		assertTrue(table.square_occupied(3, 3, Color.WHITE));
		table = new Table();
		table.get_square_at_position(0, 6).set_figure(new Bishop(Color.BLACK, 0, 6));
		table.get_square_at_position(6, 0).set_figure(new Bishop(Color.BLACK, 6, 0));
		table.get_square_at_position(2, 4).set_figure(new Pawn(Color.WHITE, 2, 4));
		assertTrue(table.square_occupied(3, 3, Color.WHITE));
	}
	
	@Test
	public void test_field_occupied_by_knight_two_fields_up_one_field_right() {
		table.get_square_at_position(7, 7).set_figure(new Knight(Color.BLACK, 7, 7));
		assertTrue(table.square_occupied(5, 6, Color.WHITE));
		table = new Table();
		table.get_square_at_position(2, 1).set_figure(new Knight(Color.BLACK, 2, 1));
		assertTrue(table.square_occupied(0, 0, Color.WHITE));
	}
	
	@Test
	public void test_field_occupied_by_knight_two_fields_up_one_field_left() {
		table.get_square_at_position(2, 6).set_figure(new Knight(Color.BLACK, 2, 6));
		assertTrue(table.square_occupied(0, 7, Color.WHITE));
		table = new Table();
		table.get_square_at_position(7, 0).set_figure(new Knight(Color.BLACK, 7, 0));
		assertTrue(table.square_occupied(5, 1, Color.WHITE));
	}
	
	@Test
	public void test_field_occupied_by_knight_two_fields_down_one_field_right() {
		table.get_square_at_position(0, 7).set_figure(new Knight(Color.BLACK, 0, 7));
		assertTrue(table.square_occupied(2, 6, Color.WHITE));
		table = new Table();
		table.get_square_at_position(5, 1).set_figure(new Knight(Color.BLACK, 5, 1));
		assertTrue(table.square_occupied(7, 0, Color.WHITE));
	}
	
	@Test
	public void test_field_occupied_by_knight_two_fields_down_one_field_left() {
		table.get_square_at_position(0, 0).set_figure(new Knight(Color.BLACK, 0, 0));
		assertTrue(table.square_occupied(2, 1, Color.WHITE));
		table = new Table();
		table.get_square_at_position(5, 6).set_figure(new Knight(Color.BLACK, 5, 6));
		assertTrue(table.square_occupied(7, 7, Color.WHITE));
	}
	
	@Test
	public void test_field_occupied_by_knight_one_fields_up_two_field_right() {
		table.get_square_at_position(7, 7).set_figure(new Knight(Color.BLACK, 7, 7));
		assertTrue(table.square_occupied(6, 5, Color.WHITE));
		table = new Table();
		table.get_square_at_position(1, 2).set_figure(new Knight(Color.BLACK, 1, 2));
		assertTrue(table.square_occupied(0, 0, Color.WHITE));
	}
	
	@Test
	public void test_field_occupied_by_knight_one_fields_up_two_field_left() {
		table.get_square_at_position(1, 5).set_figure(new Knight(Color.BLACK, 1, 5));
		assertTrue(table.square_occupied(0, 7, Color.WHITE));
		table = new Table();
		table.get_square_at_position(7, 0).set_figure(new Knight(Color.BLACK, 7, 0));
		assertTrue(table.square_occupied(6, 2, Color.WHITE));
	}
	
	@Test
	public void test_field_occupied_by_knight_one_fields_down_two_field_right() {
		table.get_square_at_position(0, 7).set_figure(new Knight(Color.BLACK, 0, 7));
		assertTrue(table.square_occupied(1, 5, Color.WHITE));
		table = new Table();
		table.get_square_at_position(6, 2).set_figure(new Knight(Color.BLACK, 6, 2));
		assertTrue(table.square_occupied(7, 0, Color.WHITE));
	}
	
	@Test
	public void test_field_occupied_by_knight_one_fields_down_two_field_left() {
		table.get_square_at_position(0, 0).set_figure(new Knight(Color.BLACK, 0, 0));
		assertTrue(table.square_occupied(1, 2, Color.WHITE));
		table = new Table();
		table.get_square_at_position(6, 5).set_figure(new Knight(Color.BLACK, 6, 5));
		assertTrue(table.square_occupied(7, 7, Color.WHITE));
	}
	
	@Test
	public void test_field_occupied_by_pawn_forward_left() {
		table.get_square_at_position(7, 7).set_figure(new Pawn(Color.BLACK, 7, 7));
		assertTrue(table.square_occupied(6, 6, Color.WHITE));
		table = new Table();
		table.get_square_at_position(5, 6).set_figure(new Pawn(Color.BLACK, 5, 6));
		assertTrue(table.square_occupied(4, 5, Color.WHITE));
	}
	
	@Test
	public void test_field_occupied_by_pawn_forward_right() {
		table.get_square_at_position(7, 0).set_figure(new Pawn(Color.BLACK, 7, 0));
		assertTrue(table.square_occupied(6, 1, Color.WHITE));
		table = new Table();
		table.get_square_at_position(5, 6).set_figure(new Pawn(Color.BLACK, 5, 6));
		assertTrue(table.square_occupied(4, 7, Color.WHITE));
	}
	
	@Test
	public void test_field_occupied_by_king_one_field_up() {
		table.get_square_at_position(7, 7).set_figure(new King(Color.BLACK, 7, 7));
		assertTrue(table.square_occupied(6, 7, Color.WHITE));
		table = new Table();
		table.get_square_at_position(1, 0).set_figure(new King(Color.BLACK, 1, 0));
		assertTrue(table.square_occupied(0, 0, Color.WHITE));
	}
	
	@Test
	public void test_field_occupied_by_king_one_field_down() {
		table.get_square_at_position(0, 0).set_figure(new King(Color.BLACK, 0, 0));
		assertTrue(table.square_occupied(1, 0, Color.WHITE));
		table = new Table();
		table.get_square_at_position(6, 7).set_figure(new King(Color.BLACK, 6, 7));
		assertTrue(table.square_occupied(7, 7, Color.WHITE));
	}
	
	@Test
	public void test_field_occupied_by_king_one_field_left() {
		table.get_square_at_position(0, 0).set_figure(new King(Color.BLACK, 0, 0));
		assertTrue(table.square_occupied(0, 1, Color.WHITE));
		table = new Table();
		table.get_square_at_position(7, 6).set_figure(new King(Color.BLACK, 7, 6));
		assertTrue(table.square_occupied(7, 7, Color.WHITE));
	}

	@Test
	public void test_field_occupied_by_king_one_field_right() {
		table.get_square_at_position(0, 1).set_figure(new King(Color.BLACK, 0, 1));
		assertTrue(table.square_occupied(0, 0, Color.WHITE));
		table = new Table();
		table.get_square_at_position(7, 7).set_figure(new King(Color.BLACK, 7, 7));
		assertTrue(table.square_occupied(7, 6, Color.WHITE));
	}

	@Test
	public void test_field_occupied_by_king_one_field_right_up() {
		table.get_square_at_position(1, 1).set_figure(new King(Color.BLACK, 1, 1));
		assertTrue(table.square_occupied(0, 0, Color.WHITE));
		table = new Table();
		table.get_square_at_position(7, 7).set_figure(new King(Color.BLACK, 7, 7));
		assertTrue(table.square_occupied(6, 6, Color.WHITE));
	}

	@Test
	public void test_field_occupied_by_king_one_field_left_down() {
		table.get_square_at_position(0, 0).set_figure(new King(Color.BLACK, 0, 0));
		assertTrue(table.square_occupied(1, 1, Color.WHITE));
		table = new Table();
		table.get_square_at_position(6, 6).set_figure(new King(Color.BLACK, 6, 6));
		assertTrue(table.square_occupied(7, 7, Color.WHITE));
	}

	@Test
	public void test_field_occupied_by_king_one_field_left_up() {
		table.get_square_at_position(7, 0).set_figure(new King(Color.BLACK, 7, 0));
		assertTrue(table.square_occupied(6, 1, Color.WHITE));
		table = new Table();
		table.get_square_at_position(1, 6).set_figure(new King(Color.BLACK, 1, 6));
		assertTrue(table.square_occupied(0, 7, Color.WHITE));
	}

	@Test
	public void test_field_occupied_by_king_one_field_right_down() {
		table.get_square_at_position(0, 7).set_figure(new King(Color.BLACK, 0, 7));
		assertTrue(table.square_occupied(1, 6, Color.WHITE));
		table = new Table();
		table.get_square_at_position(6, 1).set_figure(new King(Color.BLACK, 6, 1));
		assertTrue(table.square_occupied(7, 0, Color.WHITE));
	}
	
	@Test
	public void test_field_occupied_by_queen_same_column_higher_row() {
		table.get_square_at_position(3, 3).set_figure(new Queen(Color.WHITE, 3, 3));
		assertTrue(table.square_occupied(1, 3, Color.BLACK));
		table = new Table();
		table.get_square_at_position(7, 0).set_figure(new Queen(Color.WHITE, 7, 0));
		assertTrue(table.square_occupied(0, 0, Color.BLACK));
		table = new Table();
		table.get_square_at_position(7, 7).set_figure(new Queen(Color.WHITE, 7, 7));
		assertTrue(table.square_occupied(0, 7, Color.BLACK));
	}
	
	@Test
	public void test_field_occupied_by_queen_same_column_lower_row() {
		table.get_square_at_position(1, 2).set_figure(new Queen(Color.BLACK, 1, 2));
		assertTrue(table.square_occupied(7, 2, Color.WHITE));
		table = new Table();
		table.get_square_at_position(0, 0).set_figure(new Queen(Color.WHITE, 0, 0));
		assertTrue(table.square_occupied(7, 0, Color.BLACK));
		table = new Table();
		table.get_square_at_position(0, 7).set_figure(new Queen(Color.WHITE, 0, 7));
		assertTrue(table.square_occupied(7, 7, Color.BLACK));
	}
	
	@Test
	public void test_field_occupied_by_queen_higher_column_same_row() {
		table.get_square_at_position(2, 6).set_figure(new Queen(Color.BLACK, 2, 6));
		assertTrue(table.square_occupied(2, 2, Color.WHITE));
		table = new Table();
		table.get_square_at_position(0, 7).set_figure(new Queen(Color.WHITE, 0, 7));
		assertTrue(table.square_occupied(0, 0, Color.BLACK));
		table = new Table();
		table.get_square_at_position(7, 7).set_figure(new Queen(Color.WHITE, 7, 7));
		assertTrue(table.square_occupied(7, 0, Color.BLACK));
	}
	
	@Test
	public void test_field_occupied_by_queen_lower_column_same_row() {
		table.get_square_at_position(5, 2).set_figure(new Queen(Color.BLACK, 5, 2));
		assertTrue(table.square_occupied(5, 6, Color.WHITE));
		table = new Table();
		table.get_square_at_position(0, 0).set_figure(new Queen(Color.WHITE, 0, 0));
		assertTrue(table.square_occupied(0, 7, Color.BLACK));
		table = new Table();
		table.get_square_at_position(7, 0).set_figure(new Queen(Color.WHITE, 7, 0));
		assertTrue(table.square_occupied(7, 7, Color.BLACK));
	}

	@Test
	public void test_field_not_occupied_by_queen_on_same_row_higher_column_figuure_between_field_and_queen() {
		table.get_square_at_position(6, 7).set_figure(new Queen(Color.WHITE, 6, 7));
		table.get_square_at_position(6, 5).set_figure(new Pawn(Color.WHITE, 6, 5));
		assertFalse(table.square_occupied(6, 2, Color.BLACK));
	}

	@Test
	public void test_field_not_occupied_by_queen_on_same_row_lower_column_figuure_between_field_and_queen() {
		table.get_square_at_position(4, 1).set_figure(new Queen(Color.WHITE, 4, 1));
		table.get_square_at_position(4, 5).set_figure(new Pawn(Color.WHITE, 4, 5));
		assertFalse(table.square_occupied(4, 7, Color.BLACK));
	}

	@Test
	public void test_field_not_occupied_by_queen_on_higher_row_same_column_figuure_between_field_and_queen() {
		table.get_square_at_position(6, 4).set_figure(new Queen(Color.WHITE, 6, 4));
		table.get_square_at_position(3, 4).set_figure(new Pawn(Color.WHITE, 3, 4));
		assertFalse(table.square_occupied(0, 4, Color.BLACK));
	}

	@Test
	public void test_field_not_occupied_by_queen_on_lower_row_same_column_figuure_between_field_and_queen() {
		table.get_square_at_position(4, 4).set_figure(new Queen(Color.WHITE, 4, 4));
		table.get_square_at_position(6, 4).set_figure(new Pawn(Color.WHITE, 6, 4));
		assertFalse(table.square_occupied(7, 4, Color.BLACK));
	}
	
	@Test
	public void test_two_queens_on_same_column_target_field_between_and_figuure_between_field_and_one_queen() {
		table.get_square_at_position(7, 6).set_figure(new Queen(Color.WHITE, 7, 6));
		table.get_square_at_position(1, 6).set_figure(new Queen(Color.WHITE, 1, 6));
		table.get_square_at_position(2, 6).set_figure(new Pawn(Color.WHITE, 2, 6));
		assertTrue(table.square_occupied(3, 6, Color.BLACK));
		table = new Table();
		table.get_square_at_position(7, 6).set_figure(new Queen(Color.WHITE, 7, 6));
		table.get_square_at_position(1, 6).set_figure(new Queen(Color.WHITE, 1, 6));
		table.get_square_at_position(5, 6).set_figure(new Pawn(Color.WHITE, 5, 6));
		assertTrue(table.square_occupied(3, 6, Color.BLACK));
	}
	
	@Test
	public void test_two_queens_on_same_row_target_field_between_and_figuure_between_field_and_one_queen() {
		table.get_square_at_position(6, 7).set_figure(new Queen(Color.WHITE, 6, 7));
		table.get_square_at_position(6, 1).set_figure(new Queen(Color.WHITE, 6, 1));
		table.get_square_at_position(6, 2).set_figure(new Pawn(Color.WHITE, 6, 2));
		assertTrue(table.square_occupied(6, 3, Color.BLACK));
		table = new Table();
		table.get_square_at_position(6, 7).set_figure(new Queen(Color.WHITE, 6, 7));
		table.get_square_at_position(6, 1).set_figure(new Queen(Color.WHITE, 6, 1));
		table.get_square_at_position(6, 5).set_figure(new Pawn(Color.WHITE, 6, 5));
		assertTrue(table.square_occupied(6, 3, Color.BLACK));
	}
	
	@Test
	public void test_one_queen_on_lower_row_one_on_higher_column_like_target_field_and_figuure_between_field_and_one_queen() {
		table.get_square_at_position(6, 7).set_figure(new Queen(Color.WHITE, 6, 7));
		table.get_square_at_position(2, 3).set_figure(new Queen(Color.WHITE, 2, 3));
		table.get_square_at_position(6, 5).set_figure(new Pawn(Color.WHITE, 6, 5));
		assertTrue(table.square_occupied(6, 3, Color.BLACK));
		table = new Table();
		table.get_square_at_position(6, 7).set_figure(new Queen(Color.WHITE, 6, 7));
		table.get_square_at_position(2, 3).set_figure(new Queen(Color.WHITE, 2, 3));
		table.get_square_at_position(4, 3).set_figure(new Pawn(Color.WHITE, 4, 3));
		assertTrue(table.square_occupied(6, 3, Color.BLACK));
	}
	
	@Test
	public void test_one_queen_on_lower_row_one_on_lower_column_like_target_field_and_figuure_between_field_and_one_queen() {
		table.get_square_at_position(6, 1).set_figure(new Queen(Color.WHITE, 6, 1));
		table.get_square_at_position(2, 3).set_figure(new Queen(Color.WHITE, 2, 3));
		table.get_square_at_position(6, 2).set_figure(new Pawn(Color.WHITE, 6, 2));
		assertTrue(table.square_occupied(6, 3, Color.BLACK));
		table = new Table();
		table.get_square_at_position(6, 1).set_figure(new Queen(Color.WHITE, 6, 1));
		table.get_square_at_position(2, 3).set_figure(new Queen(Color.WHITE, 2, 3));
		table.get_square_at_position(4, 3).set_figure(new Pawn(Color.WHITE, 4, 3));
		assertTrue(table.square_occupied(6, 3, Color.BLACK));
	}
	
	@Test
	public void test_one_queen_on_higher_row_one_on_higher_column_like_target_field_and_figuure_between_field_and_one_queen() {
		table.get_square_at_position(5, 2).set_figure(new Queen(Color.WHITE, 5, 2));
		table.get_square_at_position(2, 4).set_figure(new Queen(Color.WHITE, 2, 4));
		table.get_square_at_position(4, 2).set_figure(new Pawn(Color.WHITE, 4, 2));
		assertTrue(table.square_occupied(2, 2, Color.BLACK));
		table = new Table();
		table.get_square_at_position(5, 2).set_figure(new Queen(Color.WHITE, 5, 2));
		table.get_square_at_position(2, 4).set_figure(new Queen(Color.WHITE, 2, 4));
		table.get_square_at_position(2, 3).set_figure(new Pawn(Color.WHITE, 2, 3));
		assertTrue(table.square_occupied(2, 2, Color.BLACK));
	}
	
	@Test
	public void test_one_queen_on_higher_row_one_on_lower_column_like_target_field_and_figuure_between_field_and_one_queen() {
		table.get_square_at_position(0, 2).set_figure(new Queen(Color.WHITE, 0, 2));
		table.get_square_at_position(2, 4).set_figure(new Queen(Color.WHITE, 2, 4));
		table.get_square_at_position(1, 2).set_figure(new Pawn(Color.WHITE, 1, 2));
		assertTrue(table.square_occupied(2, 2, Color.BLACK));
		table = new Table();
		table.get_square_at_position(5, 2).set_figure(new Queen(Color.WHITE, 5, 2));
		table.get_square_at_position(2, 4).set_figure(new Queen(Color.WHITE, 2, 4));
		table.get_square_at_position(2, 3).set_figure(new Pawn(Color.WHITE, 2, 3));
		assertTrue(table.square_occupied(2, 2, Color.BLACK));
	}
	
	@Test
	public void test_field_occupied_by_queen_higher_row_higher_column() {
		table.get_square_at_position(6, 7).set_figure(new Queen(Color.BLACK, 6, 7));
		assertTrue(table.square_occupied(3, 4, Color.WHITE));
		table = new Table();
		table.get_square_at_position(7, 7).set_figure(new Queen(Color.BLACK, 7, 7));
		assertTrue(table.square_occupied(0, 0, Color.WHITE));
	}
	
	@Test
	public void test_field_occupied_by_queen_higher_row_lower_column() {
		table.get_square_at_position(7, 1).set_figure(new Queen(Color.BLACK, 6, 1));
		assertTrue(table.square_occupied(4, 4, Color.WHITE));
		table = new Table();
		table.get_square_at_position(7, 0).set_figure(new Queen(Color.BLACK, 7, 0));
		assertTrue(table.square_occupied(0, 7, Color.WHITE));
	}

	@Test
	public void test_field_occupied_by_queen_lower_row_lower_column() {
		table.get_square_at_position(1, 1).set_figure(new Queen(Color.BLACK, 0, 1));
		assertTrue(table.square_occupied(4, 4, Color.WHITE));
		table = new Table();
		table.get_square_at_position(0, 0).set_figure(new Queen(Color.BLACK, 0, 0));
		assertTrue(table.square_occupied(7, 7, Color.WHITE));
	}

	@Test
	public void test_field_occupied_by_queen_lower_row_higher_column() {
		table.get_square_at_position(0, 7).set_figure(new Queen(Color.BLACK, 0, 7));
		assertTrue(table.square_occupied(3, 4, Color.WHITE));
		table = new Table();
		table.get_square_at_position(0, 7).set_figure(new Queen(Color.BLACK, 0, 7));
		assertTrue(table.square_occupied(7, 0, Color.WHITE));
	}
	
	@Test
	public void test_field_not_occupied_by_queen_higher_row_higher_column_figure_between() {
		table.get_square_at_position(6, 7).set_figure(new Queen(Color.BLACK, 6, 7));
		table.get_square_at_position(5, 6).set_figure(new Pawn(Color.WHITE, 5, 6));
		assertFalse(table.square_occupied(3, 4, Color.WHITE));
	}
	
	@Test
	public void test_field_not_occupied_by_queen_higher_row_lower_column_figure_between() {
		table.get_square_at_position(6, 1).set_figure(new Queen(Color.BLACK, 6, 1));
		table.get_square_at_position(5, 2).set_figure(new Queen(Color.WHITE, 5, 2));
		assertFalse(table.square_occupied(3, 4, Color.WHITE));
	}

	@Test
	public void test_field_not_occupied_by_queen_lower_row_lower_column_figure_between() {
		table.get_square_at_position(0, 1).set_figure(new Queen(Color.BLACK, 0, 1));
		table.get_square_at_position(1, 2).set_figure(new Queen(Color.WHITE, 1, 2));
		assertFalse(table.square_occupied(3, 4, Color.WHITE));	
	}

	@Test
	public void test_field_not_occupied_by_queen_lower_row_higher_column_figure_between() {
		table.get_square_at_position(0, 7).set_figure(new Queen(Color.BLACK, 0, 7));
		table.get_square_at_position(1, 6).set_figure(new Queen(Color.WHITE, 1, 6));
		assertFalse(table.square_occupied(3, 4, Color.WHITE));
	}
	
	@Test
	public void test_one_queen_higher_column_and_row_and_other_queen_lower_column_and_row_one_queen_blocked() {
		table.get_square_at_position(6, 7).set_figure(new Queen(Color.BLACK, 6, 7));
		table.get_square_at_position(1, 2).set_figure(new Queen(Color.BLACK, 1, 2));
		table.get_square_at_position(5, 6).set_figure(new Pawn(Color.WHITE, 5, 6));
		assertTrue(table.square_occupied(3, 4, Color.WHITE));
		table = new Table();
		table.get_square_at_position(6, 7).set_figure(new Queen(Color.BLACK, 6, 7));
		table.get_square_at_position(1, 2).set_figure(new Queen(Color.BLACK, 1, 2));
		table.get_square_at_position(2, 3).set_figure(new Pawn(Color.WHITE, 2, 3));
		assertTrue(table.square_occupied(3, 4, Color.WHITE));
	}
	
	@Test
	public void test_one_queen_higher_column_and_lower_row_and_other_queen_lower_column_and_row_one_queen_blocked() {
	table.get_square_at_position(0, 7).set_figure(new Queen(Color.BLACK, 0, 7));
	table.get_square_at_position(1, 2).set_figure(new Queen(Color.BLACK, 1, 2));
	table.get_square_at_position(1, 6).set_figure(new Pawn(Color.WHITE, 1, 6));
	assertTrue(table.square_occupied(3, 4, Color.WHITE));
	table = new Table();
	table.get_square_at_position(0, 7).set_figure(new Queen(Color.BLACK, 0, 7));
	table.get_square_at_position(1, 2).set_figure(new Queen(Color.BLACK, 1, 2));
	table.get_square_at_position(2, 3).set_figure(new Pawn(Color.WHITE, 2, 3));
	assertTrue(table.square_occupied(3, 4, Color.WHITE));
	}

	@Test
	public void test_one_queen_lower_column_and_higher_row_and_other_queen_lower_column_and_row_one_queen_blocked() {
		table.get_square_at_position(6, 7).set_figure(new Queen(Color.BLACK, 6, 7));
		table.get_square_at_position(1, 6).set_figure(new Queen(Color.BLACK, 1, 6));
		table.get_square_at_position(5, 6).set_figure(new Pawn(Color.WHITE, 5, 6));
		assertTrue(table.square_occupied(3, 4, Color.WHITE));
		table = new Table();
		table.get_square_at_position(6, 7).set_figure(new Queen(Color.BLACK, 6, 7));
		table.get_square_at_position(1, 6).set_figure(new Queen(Color.BLACK, 1, 6));
		table.get_square_at_position(2, 5).set_figure(new Pawn(Color.WHITE, 2, 5));
		assertTrue(table.square_occupied(3, 4, Color.WHITE));
	}

	@Test
	public void test_one_queen_lower_column_and_higher_row_and_other_queen_higher_column_and_higher_row_one_queen_blocked() {
		table.get_square_at_position(6, 0).set_figure(new Queen(Color.BLACK, 6, 0));
		table.get_square_at_position(6, 6).set_figure(new Queen(Color.BLACK, 6, 6));
		table.get_square_at_position(5, 5).set_figure(new Pawn(Color.WHITE, 5, 5));
		assertTrue(table.square_occupied(3, 3, Color.WHITE));
		table = new Table();
		table.get_square_at_position(6, 0).set_figure(new Queen(Color.BLACK, 6, 0));
		table.get_square_at_position(6, 6).set_figure(new Queen(Color.BLACK, 6, 6));
		table.get_square_at_position(4, 2).set_figure(new Pawn(Color.WHITE, 4, 2));
		assertTrue(table.square_occupied(3, 3, Color.WHITE));
	}
	
	@Test
	public void test_one_queen_higher_column_and_lower_row_and_other_queen_higher_column_and_higher_row_one_queen_blocked() {
		table.get_square_at_position(0, 6).set_figure(new Queen(Color.BLACK, 0, 6));
		table.get_square_at_position(6, 6).set_figure(new Queen(Color.BLACK, 6, 6));
		table.get_square_at_position(5, 5).set_figure(new Pawn(Color.WHITE, 5, 5));
		assertTrue(table.square_occupied(3, 3, Color.WHITE));
		table = new Table();
		table.get_square_at_position(0, 6).set_figure(new Queen(Color.BLACK, 0, 6));
		table.get_square_at_position(6, 6).set_figure(new Queen(Color.BLACK, 6, 6));
		table.get_square_at_position(2, 4).set_figure(new Pawn(Color.WHITE, 2, 4));
		assertTrue(table.square_occupied(3, 3, Color.WHITE));
	}

	@Test
	public void test_one_queen_higher_column_and_lower_row_and_other_queen_lower_column_and_higher_row_one_queen_blocked() {
		table.get_square_at_position(0, 6).set_figure(new Queen(Color.BLACK, 0, 6));
		table.get_square_at_position(6, 0).set_figure(new Queen(Color.BLACK, 6, 0));
		table.get_square_at_position(4, 2).set_figure(new Pawn(Color.WHITE, 4, 2));
		assertTrue(table.square_occupied(3, 3, Color.WHITE));
		table = new Table();
		table.get_square_at_position(0, 6).set_figure(new Queen(Color.BLACK, 0, 6));
		table.get_square_at_position(6, 0).set_figure(new Queen(Color.BLACK, 6, 0));
		table.get_square_at_position(2, 4).set_figure(new Pawn(Color.WHITE, 2, 4));
		assertTrue(table.square_occupied(3, 3, Color.WHITE));
	}
	
	private void check_figure_on_square(Figure figure, int x, int y) {
		assertTrue((figure.getClass() == table.get_square()[x][y].get_figure().getClass()) &&
				(figure.get_color() == table.get_square()[x][y].get_figure().get_color()));
	}
}
