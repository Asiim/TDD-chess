package figures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import enums.Color;
import table.Table;


public class Test_queen {

	private Queen queen;
	private Table table;
	
	@Before
	public void setUp() throws Exception {
		table = new Table();
		queen = new Queen();
	}
	
	@Test
	public void test_init_queen() {
		assertNotNull(queen);
	}
	
	@Test
	public void test_position_queen() {
		queen.set_position_x(4);
		queen.set_position_y(6);
		assertEquals(4, queen.get_position_x());
		assertEquals(6, queen.get_position_y());
	}

	@Test
	public void test_init_white_position_queen() {
		queen = new Queen(Color.WHITE, 2, 4);
		assertEquals(Color.WHITE, queen.get_color());
		assertEquals(2, queen.get_position_x());
		assertEquals(4, queen.get_position_y());
	}
	
	@Test
	public void test_init_black_position_queen() {
		queen = new Queen(Color.BLACK, 4, 2);
		assertEquals(Color.BLACK, queen.get_color());
		assertEquals(4, queen.get_position_x());
		assertEquals(2, queen.get_position_y());
	}
	
	
	@Test
	public void test_move_one_field_vertically() {
		queen.set_position_x(1);
		queen.set_position_y(2);
		table.get_square_at_position(1, 2).set_figure(queen);
		assertTrue(queen.can_move(4, 2, table));
	}	
	
	@Test
	public void test_move_one_field_horizontally() {
		queen.set_position_x(2);
		queen.set_position_y(2);
		table.get_square_at_position(2, 2).set_figure(queen);
		assertTrue(queen.can_move(2, 3, table));
	}
	
	@Test
	public void test_move_n_fields_vertically() {
		queen.set_position_x(1);
		queen.set_position_y(2);
		table.get_square_at_position(1, 2).set_figure(queen);
		assertTrue(queen.can_move(7, 2, table));
	}

	@Test
	public void test_move_n_fields_horizontally() {
		queen.set_position_x(3);
		queen.set_position_y(2);
		table.get_square_at_position(3, 2).set_figure(queen);
		assertTrue(queen.can_move(3, 7, table));
	}

	@Test
	public void test_move_n_fields_vertically_figure_in_front_of_rook() {
		queen.set_position_x(4);
		queen.set_position_y(2);
		table.get_square_at_position(4, 2).set_figure(queen);
		table.get_square_at_position(5, 2).set_figure(new Pawn());
		assertFalse(queen.can_move(7, 2, table));
	}

	@Test
	public void test_move_n_fields_horizontally_figure_next_to_rook() {
		queen.set_position_x(5);
		queen.set_position_y(5);
		table.get_square_at_position(5, 5).set_figure(queen);
		table.get_square_at_position(5, 6).set_figure(new Pawn());
		assertFalse(queen.can_move(5, 7, table));
	}
	
	@Test
	public void test_move_n_fields_vertically_figures_on_the_way() {
		queen.set_position_x(3);
		queen.set_position_y(7);
		table.get_square_at_position(3, 7).set_figure(queen);
		table.get_square_at_position(6, 7).set_figure(new Pawn());
		table.get_square_at_position(5, 7).set_figure(new Knight());
		assertFalse(queen.can_move(7, 7, table));
	}
	
	@Test
	public void test_move_n_fields_horizontally_figures_on_the_way() {
		queen.set_position_x(7);
		queen.set_position_y(2);
		table.get_square_at_position(7, 2).set_figure(queen);
		table.get_square_at_position(7, 5).set_figure(new Queen());
		table.get_square_at_position(7, 4).set_figure(new Pawn());
		assertFalse(queen.can_move(7, 6, table));
	}
	
	@Test
	public void test_move_vertically_ally_on_destination() {
		queen = new Queen(Color.WHITE, 4, 2);
		table.get_square_at_position(4, 2).set_figure(queen);
		table.get_square_at_position(6, 2).set_figure(new Knight(Color.WHITE, 6, 2));
		assertFalse(queen.can_move(6, 2, table));
	}
	
	@Test
	public void test_move_horizontally_ally_on_destination() {
		queen = new Queen(Color.WHITE, 3, 4);
		table.get_square_at_position(3, 4).set_figure(queen);
		table.get_square_at_position(3, 6).set_figure(new Knight(Color.WHITE, 3, 6));
		assertFalse(queen.can_move(3, 6, table));
	}
	
	@Test
	public void test_move_vertically_enemy_on_destination() {
		queen = new Queen(Color.WHITE, 3, 2);
		table.get_square_at_position(3, 2).set_figure(queen);
		table.get_square_at_position(7, 2).set_figure(new Queen(Color.BLACK, 7, 2));
		assertTrue(queen.can_move(7, 2, table));
	}
	
	@Test
	public void test_move_horizontally_enemy_on_destination() {
		queen = new Queen(Color.WHITE, 3, 2);
		table.get_square_at_position(3, 2).set_figure(queen);
		table.get_square_at_position(3, 5).set_figure(new King(Color.BLACK, 3, 5));
		assertTrue(queen.can_move(3, 5, table));
	}
	
	@Test
	public void test_move_vertically_n_fields_backwards() {
		queen.set_position_x(5);
		queen.set_position_y(1);
		table.get_square_at_position(5, 1).set_figure(queen);
		assertTrue(queen.can_move(3, 1, table));
	}
	
	@Test
	public void test_move_n_fields_vertically_backwards_figure_in_back_of_rook() {
		queen.set_position_x(6);
		queen.set_position_y(4);
		table.get_square_at_position(6, 4).set_figure(queen);
		table.get_square_at_position(5, 4).set_figure(new Pawn());
		assertFalse(queen.can_move(3, 4, table));
	}
	
	@Test
	public void test_move_n_fields_vertically_backwards_figures_on_the_way() {
		queen.set_position_x(7);
		queen.set_position_y(2);
		table.get_square_at_position(7, 2).set_figure(queen);
		table.get_square_at_position(4, 2).set_figure(new Pawn());
		table.get_square_at_position(5, 2).set_figure(new Knight());
		assertFalse(queen.can_move(3, 2, table));
	}
	
	@Test
	public void test_move_vertically_backwards_ally_on_destination() {
		queen = new Queen(Color.WHITE, 7, 7);
		table.get_square_at_position(7, 7).set_figure(queen);
		table.get_square_at_position(3, 7).set_figure(new Knight(Color.WHITE, 3, 7));
		assertFalse(queen.can_move(3, 7, table));
	}
	
	@Test
	public void test_move_vertically_backwards_enemy_on_destination() {
		queen = new Queen(Color.WHITE, 7, 6);
		table.get_square_at_position(7, 6).set_figure(queen);
		table.get_square_at_position(3, 6).set_figure(new Knight(Color.BLACK, 3, 6));
		assertTrue(queen.can_move(3, 6, table));
	}
	
	@Test
	public void test_move_n_fields_horizontally_backwards() {
		queen.set_position_x(3);
		queen.set_position_y(7);
		table.get_square_at_position(3, 7).set_figure(queen);
		assertTrue(queen.can_move(3, 2, table));
	}

	@Test
	public void test_move_n_fields_horizontally_backwards_figure_next_to_rook() {
		queen.set_position_x(3);
		queen.set_position_y(5);
		table.get_square_at_position(3, 5).set_figure(queen);
		table.get_square_at_position(3, 4).set_figure(new Pawn());
		assertFalse(queen.can_move(3, 3, table));
	}
	
	@Test
	public void test_move_n_fields_horizontally_backwards_figures_on_the_way() {
		queen.set_position_x(3);
		queen.set_position_y(6);
		table.get_square_at_position(3, 6).set_figure(queen);
		table.get_square_at_position(3, 3).set_figure(new Queen());
		table.get_square_at_position(3, 4).set_figure(new Pawn());
		assertFalse(queen.can_move(3, 2, table));
	}
	
	@Test
	public void test_move_horizontally_backwards_ally_on_destination() {
		queen = new Queen(Color.WHITE, 3, 5);
		table.get_square_at_position(3, 5).set_figure(queen);
		table.get_square_at_position(3, 2).set_figure(new Knight(Color.WHITE, 3, 2));
		assertFalse(queen.can_move(3, 2, table));
	}
	
	@Test
	public void test_move_horizontally_backwards_enemy_on_destination() {
		queen = new Queen(Color.WHITE, 3, 5);
		table.get_square_at_position(3, 5).set_figure(queen);
		table.get_square_at_position(3, 2).set_figure(new Knight(Color.BLACK, 3, 2));
		assertTrue(queen.can_move(3, 2, table));
	}

}
