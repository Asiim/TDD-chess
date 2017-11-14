package figures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import enums.Color;
import table.Table;

public class Test_bishop {

	private Bishop bishop;
	private Table table;
	
	@Before
	public void setUp() throws Exception {
		table = new Table();
		bishop = new Bishop();
	}
	
	@Test
	public void test_init_bishop() {
		assertNotNull(bishop);
	}
	
	@Test
	public void test_position_bishop() {
		bishop.set_position_x(0);
		bishop.set_position_y(7);
		assertEquals(0, bishop.get_position_x());
		assertEquals(7, bishop.get_position_y());
	}
	
	@Test
	public void test_init_white_position_bishop() {
		bishop = new Bishop(Color.WHITE, 7, 0);
		assertEquals(Color.WHITE, bishop.get_color());
		assertEquals(7, bishop.get_position_x());
		assertEquals(0, bishop.get_position_y());
	}	
	
	@Test
	public void test_init_black_position_bishop() {
		bishop = new Bishop(Color.BLACK, 0, 7);
		assertEquals(Color.BLACK, bishop.get_color());
		assertEquals(0, bishop.get_position_x());
		assertEquals(7, bishop.get_position_y());
	}
	
	@Test
	public void test_move_one_field_diagonaly_y_increases_with_x_increased() {
		bishop.set_position_x(2);
		bishop.set_position_y(3);
		table.get_square_at_position(2, 3).set_figure(bishop);
		assertTrue(bishop.can_move(3, 4, table));
	}
	
	@Test
	public void test_move_one_field_diagonaly_y_decreased_with_x_decreased() {
		bishop.set_position_x(2);
		bishop.set_position_y(3);
		table.get_square_at_position(2, 3).set_figure(bishop);
		assertTrue(bishop.can_move(1, 2, table));
	}
	
	@Test
	public void test_move_one_field_diagonaly_y_increases_with_x_decreased() {
		bishop.set_position_x(2);
		bishop.set_position_y(3);
		table.get_square_at_position(2, 3).set_figure(bishop);
		assertTrue(bishop.can_move(1, 4, table));
	}
	
	@Test
	public void test_move_one_field_diagonaly_y_decreases_with_x_decreased() {
		bishop.set_position_x(2);
		bishop.set_position_y(3);
		table.get_square_at_position(2, 3).set_figure(bishop);
		assertTrue(bishop.can_move(3, 2, table));
	}
	
	@Test
	public void test_move_n_fields_diagonaly_y_increases_with_x_increased() {
		bishop.set_position_x(2);
		bishop.set_position_y(3);
		table.get_square_at_position(2, 3).set_figure(bishop);
		assertTrue(bishop.can_move(5, 6, table));
	}
	
	@Test
	public void test_move_n_fields_diagonaly_y_decreases_with_x_increased() {
		bishop.set_position_x(2);
		bishop.set_position_y(3);
		table.get_square_at_position(2, 3).set_figure(bishop);
		assertTrue(bishop.can_move(5, 0, table));
	}
	
	@Test
	public void test_move_n_fields_diagonaly_y_decreases_with_x_decreased() {
		bishop.set_position_x(2);
		bishop.set_position_y(3);
		table.get_square_at_position(2, 3).set_figure(bishop);
		assertTrue(bishop.can_move(0, 1, table));
	}
	
	@Test
	public void test_move_n_fields_diagonaly_y_increases_with_x_decreased() {
		bishop.set_position_x(2);
		bishop.set_position_y(3);
		table.get_square_at_position(2, 3).set_figure(bishop);
		assertTrue(bishop.can_move(0, 5, table));
	}
	
	@Test
	public void test_move_bishop_n_fields_with_figure_next_to_bishop_y_increases_with_x_increased() {
		bishop.set_position_x(1);
		bishop.set_position_y(5);
		table.get_square_at_position(2, 6).set_figure(new Bishop());
		table.get_square_at_position(1, 5).set_figure(bishop);
		assertFalse(bishop.can_move(3, 7, table));
	}
	
	@Test
	public void test_move_bishop_n_fields_with_figure_next_to_bishop_y_increases_with_x_decreased() {
		bishop.set_position_x(2);
		bishop.set_position_y(5);
		table.get_square_at_position(1, 6).set_figure(new Bishop());
		table.get_square_at_position(2, 5).set_figure(bishop);
		assertFalse(bishop.can_move(0, 7, table));
	}
	
	@Test
	public void test_move_bishop_n_fields_with_figure_next_to_bishop_y_decreases_with_x_increased() {
		bishop.set_position_x(4);
		bishop.set_position_y(6);
		table.get_square_at_position(5, 5).set_figure(new Bishop());
		table.get_square_at_position(4, 6).set_figure(bishop);
		assertFalse(bishop.can_move(7, 3, table));
	}
	
	@Test
	public void test_move_bishop_n_fields_with_figure_next_to_bishop_y_decreases_with_x_decreased() {
		bishop.set_position_x(4);
		bishop.set_position_y(6);
		table.get_square_at_position(3, 5).set_figure(new Bishop());
		table.get_square_at_position(4, 6).set_figure(bishop);
		assertFalse(bishop.can_move(1, 3, table));
	}
	
	@Test
	public void test_move_bishop_n_fields_figures_on_way_y_increases_with_x_increased() {
		bishop.set_position_x(1);
		bishop.set_position_y(2);
		table.get_square_at_position(3, 4).set_figure(new Bishop());
		table.get_square_at_position(5, 6).set_figure(new Bishop());
		table.get_square_at_position(1, 2).set_figure(bishop);
		assertFalse(bishop.can_move(6, 7, table));
	}
	
	@Test
	public void test_move_bishop_n_fields_figures_on_way_y_increases_with_x_decreased() {
		bishop.set_position_x(5);
		bishop.set_position_y(2);
		table.get_square_at_position(3, 4).set_figure(new Bishop());
		table.get_square_at_position(1, 6).set_figure(new Bishop());
		table.get_square_at_position(5, 2).set_figure(bishop);
		assertFalse(bishop.can_move(0, 7, table));
	}
	
	@Test
	public void test_move_bishop_n_fields_figures_on_way_y_decreases_with_x_increased() {
		bishop.set_position_x(0);
		bishop.set_position_y(7);
		table.get_square_at_position(2, 5).set_figure(new Bishop());
		table.get_square_at_position(4, 3).set_figure(new Bishop());
		table.get_square_at_position(0, 7).set_figure(bishop);
		assertFalse(bishop.can_move(7, 0, table));
	}
	
	@Test
	public void test_move_bishop_n_fields_figures_on_way_y_decreases_with_x_decreased() {
		bishop.set_position_x(4);
		bishop.set_position_y(7);
		table.get_square_at_position(1, 4).set_figure(new Bishop());
		table.get_square_at_position(2, 5).set_figure(new Bishop());
		table.get_square_at_position(4, 7).set_figure(bishop);
		assertFalse(bishop.can_move(0, 3, table));
	}
	
	@Test
	public void test_move_vertically() {
		bishop.set_position_x(1);
		bishop.set_position_y(5);
		table.get_square_at_position(1, 5).set_figure(bishop);
		assertFalse(bishop.can_move(5, 5, table));
	}
	
	@Test
	public void test_move_horizontally() {
		bishop.set_position_x(4);
		bishop.set_position_y(5);
		table.get_square_at_position(4, 5).set_figure(bishop);
		assertFalse(bishop.can_move(4, 2, table));
	}

	@Test
	public void test_move_bishop_n_fields_ally_on_destination_y_increases_with_x_increased() {
		bishop = new Bishop(Color.WHITE, 2, 3);
		table.get_square_at_position(2, 3).set_figure(bishop);
		table.get_square_at_position(5, 6).set_figure(new Pawn(Color.WHITE, 5, 6));
		assertFalse(bishop.can_move(5, 6, table));
		table.get_square_at_position(3, 4).set_figure(new Pawn(Color.WHITE, 3, 4));
		assertFalse(bishop.can_move(3, 4, table));
		bishop = new Bishop(Color.BLACK, 1, 2);
		table.get_square_at_position(1, 2).set_figure(bishop);
		table.get_square_at_position(4, 5).set_figure(new Pawn(Color.BLACK, 4, 5));
		assertFalse(bishop.can_move(4, 5, table));
		table.get_square_at_position(6, 7).set_figure(new Pawn(Color.BLACK, 6, 7));
		assertFalse(bishop.can_move(6, 7, table));
	}
	
	@Test
	public void test_move_bishop_n_fields_ally_on_destination_y_increases_with_x_decreased() {
		bishop = new Bishop(Color.WHITE, 5, 3);
		table.get_square_at_position(5, 3).set_figure(bishop);
		table.get_square_at_position(2, 6).set_figure(new Pawn(Color.WHITE, 2, 6));
		assertFalse(bishop.can_move(2, 6, table));
		table.get_square_at_position(3, 5).set_figure(new Pawn(Color.WHITE, 3, 5));
		assertFalse(bishop.can_move(3, 5, table));
		bishop = new Bishop(Color.BLACK, 7, 2);
		table.get_square_at_position(7, 2).set_figure(bishop);
		table.get_square_at_position(6, 3).set_figure(new Pawn(Color.BLACK, 6, 3));
		assertFalse(bishop.can_move(6, 3, table));
		table.get_square_at_position(2, 7).set_figure(new Pawn(Color.BLACK, 2, 7));
		assertFalse(bishop.can_move(2, 7, table));
	}
	
	@Test
	public void test_move_bishop_n_fields_ally_on_destination_y_decreases_with_x_increased() {
		bishop = new Bishop(Color.WHITE, 1, 6);
		table.get_square_at_position(1, 6).set_figure(bishop);
		table.get_square_at_position(2, 5).set_figure(new Pawn(Color.WHITE, 2, 5));
		assertFalse(bishop.can_move(2, 5, table));
		table.get_square_at_position(6, 1).set_figure(new Pawn(Color.WHITE, 6, 1));
		assertFalse(bishop.can_move(6, 1, table));
		bishop = new Bishop(Color.BLACK, 2, 4);
		table.get_square_at_position(2, 4).set_figure(bishop);
		table.get_square_at_position(4, 2).set_figure(new Pawn(Color.BLACK, 4, 2));
		assertFalse(bishop.can_move(4, 2, table));
		table.get_square_at_position(6, 0).set_figure(new Pawn(Color.BLACK, 6, 0));
		assertFalse(bishop.can_move(6, 0, table));
	}
	
	
	@Test
	public void test_move_bishop_n_fields_ally_on_destination_y_decreases_with_x_decreased() {
		bishop = new Bishop(Color.WHITE, 6, 6);
		table.get_square_at_position(6, 6).set_figure(bishop);
		table.get_square_at_position(1, 1).set_figure(new Pawn(Color.WHITE, 1, 1));
		assertFalse(bishop.can_move(1, 1, table));
		table.get_square_at_position(5, 5).set_figure(new Pawn(Color.WHITE, 5, 5));
		assertFalse(bishop.can_move(5, 5, table));
		bishop = new Bishop(Color.BLACK, 3, 5);
		table.get_square_at_position(3, 5).set_figure(bishop);
		table.get_square_at_position(0, 2).set_figure(new Pawn(Color.BLACK, 0, 2));
		assertFalse(bishop.can_move(0, 2, table));
		table.get_square_at_position(1, 3).set_figure(new Pawn(Color.BLACK, 1, 3));
		assertFalse(bishop.can_move(1, 3, table));
	}
	
	@Test
	public void test_move_bishop_n_fields_enemy_on_destination_y_increases_with_x_increased() {
		bishop = new Bishop(Color.WHITE, 2, 3);
		table.get_square_at_position(2, 3).set_figure(bishop);
		table.get_square_at_position(5, 6).set_figure(new Pawn(Color.BLACK, 5, 6));
		assertTrue(bishop.can_move(5, 6, table));
		table.get_square_at_position(3, 4).set_figure(new Pawn(Color.BLACK, 3, 4));
		assertTrue(bishop.can_move(3, 4, table));
		table = new Table();
		bishop = new Bishop(Color.BLACK, 1, 2);
		table.get_square_at_position(1, 2).set_figure(bishop);
		table.get_square_at_position(6, 7).set_figure(new Pawn(Color.WHITE, 6, 7));
		assertTrue(bishop.can_move(6, 7, table));
		table.get_square_at_position(4, 5).set_figure(new Pawn(Color.WHITE, 4, 5));
		assertTrue(bishop.can_move(4, 5, table));
	}
	
	@Test
	public void test_move_bishop_n_fields_enemy_on_destination_y_increases_with_x_decreased() {
		bishop = new Bishop(Color.WHITE, 5, 3);
		table.get_square_at_position(5, 3).set_figure(bishop);
		table.get_square_at_position(2, 6).set_figure(new Pawn(Color.BLACK, 2, 6));
		assertTrue(bishop.can_move(2, 6, table));
		table.get_square_at_position(3, 5).set_figure(new Pawn(Color.BLACK, 3, 5));
		assertTrue(bishop.can_move(3, 1, table));
		table = new Table();
		bishop = new Bishop(Color.BLACK, 7, 2);
		table.get_square_at_position(7, 2).set_figure(bishop);
		table.get_square_at_position(2, 7).set_figure(new Pawn(Color.WHITE, 2, 7));
		assertTrue(bishop.can_move(2, 7, table));
		table.get_square_at_position(4, 5).set_figure(new Pawn(Color.WHITE, 4, 5));
		assertTrue(bishop.can_move(4, 5, table));
	}
	
	@Test
	public void test_move_bishop_n_fields_enemy_on_destination_y_decreases_with_x_increased() {
		bishop = new Bishop(Color.WHITE, 1, 6);
		table.get_square_at_position(1, 6).set_figure(bishop);
		table.get_square_at_position(6, 1).set_figure(new Pawn(Color.BLACK, 6, 1));
		assertTrue(bishop.can_move(6, 1, table));
		table.get_square_at_position(2, 5).set_figure(new Pawn(Color.BLACK, 2, 5));
		assertTrue(bishop.can_move(2, 5, table));
		bishop = new Bishop(Color.BLACK, 2, 4);
		table.get_square_at_position(2, 4).set_figure(bishop);
		table.get_square_at_position(6, 0).set_figure(new Pawn(Color.WHITE, 6, 0));
		assertTrue(bishop.can_move(6, 0, table));
		table.get_square_at_position(4, 2).set_figure(new Pawn(Color.WHITE, 4, 2));
		assertTrue(bishop.can_move(4, 2, table));
	}
	
	@Test
	public void test_move_bishop_n_fields_enemy_on_destination_y_decreases_with_x_decreased() {
		bishop = new Bishop(Color.WHITE, 5, 6);
		table.get_square_at_position(5, 6).set_figure(bishop);
		table.get_square_at_position(0, 1).set_figure(new Pawn(Color.BLACK, 0, 1));
		assertTrue(bishop.can_move(0, 1, table));
		table.get_square_at_position(4, 5).set_figure(new Pawn(Color.BLACK, 4, 5));
		assertTrue(bishop.can_move(4, 5, table));
		bishop = new Bishop(Color.BLACK, 5, 4);
		table.get_square_at_position(5, 4).set_figure(bishop);
		table.get_square_at_position(1, 0).set_figure(new Pawn(Color.WHITE, 1, 0));
		assertTrue(bishop.can_move(1, 0, table));
		table.get_square_at_position(3, 2).set_figure(new Pawn(Color.WHITE, 3, 2));
		assertTrue(bishop.can_move(3, 2, table));
	}
}
