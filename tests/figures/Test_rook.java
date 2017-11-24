package figures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import enums.Color;
import table.Table;

public class Test_rook {

	private Rook rook;
	private Table table;
	
	@Before
	public void setUp() throws Exception {
		rook = new Rook();
		table = new Table();
	}
	
	@Test
	public void test_init_rook() {
		assertNotNull(rook);
	}
	
	@Test
	public void test_position_rook() {
		rook.set_position_x(4);
		rook.set_position_y(3);
		assertEquals(4, rook.get_position_x());
		assertEquals(3, rook.get_position_y());
	}

	@Test
	public void test_init_white_position_rook() {
		rook = new Rook(Color.WHITE, 6, 3);
		assertEquals(Color.WHITE, rook.get_color());
		assertEquals(6, rook.get_position_x());
		assertEquals(3, rook.get_position_y());
	}
	
	@Test
	public void test_init_black_position_rook() {
		rook = new Rook(Color.BLACK, 3, 6);
		assertEquals(Color.BLACK, rook.get_color());
		assertEquals(3, rook.get_position_x());
		assertEquals(6, rook.get_position_y());
	}
	
	@Test
	public void test_move_one_field_vertically() {
		rook.set_position_x(3);
		rook.set_position_y(2);
		table.get_square_at_position(3, 2).set_figure(rook);
		assertTrue(rook.can_move(4, 2, table));
	}
	
	@Test
	public void test_move_one_field_diagonally() {
		rook.set_position_x(3);
		rook.set_position_y(2);
		table.get_square_at_position(3, 2).set_figure(rook);
		assertFalse(rook.can_move(4, 3, table));
	}
	
	@Test
	public void test_move_one_field_horizontally() {
		rook.set_position_x(3);
		rook.set_position_y(2);
		table.get_square_at_position(3, 2).set_figure(rook);
		assertTrue(rook.can_move(3, 3, table));
	}
	
	@Test
	public void test_move_n_fields_vertically() {
		rook.set_position_x(3);
		rook.set_position_y(2);
		table.get_square_at_position(3, 2).set_figure(rook);
		assertTrue(rook.can_move(6, 2, table));
	}

	@Test
	public void test_move_n_fields_horizontally() {
		rook.set_position_x(3);
		rook.set_position_y(2);
		table.get_square_at_position(3, 2).set_figure(rook);
		assertTrue(rook.can_move(3, 7, table));
	}

	@Test
	public void test_move_n_fields_vertically_figure_in_front_of_rook() {
		rook.set_position_x(3);
		rook.set_position_y(2);
		table.get_square_at_position(3, 2).set_figure(rook);
		table.get_square_at_position(4, 2).set_figure(new Pawn());
		assertFalse(rook.can_move(6, 2, table));
	}

	@Test
	public void test_move_n_fields_horizontally_figure_next_to_rook() {
		rook.set_position_x(3);
		rook.set_position_y(2);
		table.get_square_at_position(3, 2).set_figure(rook);
		table.get_square_at_position(3, 3).set_figure(new Pawn());
		assertFalse(rook.can_move(3, 5, table));
	}
	
	@Test
	public void test_move_n_fields_vertically_figures_on_the_way() {
		rook.set_position_x(3);
		rook.set_position_y(2);
		table.get_square_at_position(3, 2).set_figure(rook);
		table.get_square_at_position(6, 2).set_figure(new Pawn());
		table.get_square_at_position(5, 2).set_figure(new Knight());
		assertFalse(rook.can_move(7, 2, table));
	}
	
	@Test
	public void test_move_n_fields_horizontally_figures_on_the_way() {
		rook.set_position_x(3);
		rook.set_position_y(2);
		table.get_square_at_position(3, 2).set_figure(rook);
		table.get_square_at_position(3, 5).set_figure(new Queen());
		table.get_square_at_position(3, 4).set_figure(new Pawn());
		assertFalse(rook.can_move(3, 6, table));
	}
	
	@Test
	public void test_move_vertically_ally_on_destination() {
		rook = new Rook(Color.WHITE, 3, 2);
		table.get_square_at_position(3, 2).set_figure(rook);
		table.get_square_at_position(7, 2).set_figure(new Knight(Color.WHITE, 7, 2));
		assertFalse(rook.can_move(7, 2, table));
	}
	
	@Test
	public void test_move_horizontally_ally_on_destination() {
		rook = new Rook(Color.WHITE, 3, 2);
		table.get_square_at_position(3, 2).set_figure(rook);
		table.get_square_at_position(3, 5).set_figure(new Knight(Color.WHITE, 3, 5));
		assertFalse(rook.can_move(3, 5, table));
	}
	
	@Test
	public void test_move_vertically_enemy_on_destination() {
		rook = new Rook(Color.WHITE, 3, 2);
		table.get_square_at_position(3, 2).set_figure(rook);
		table.get_square_at_position(7, 2).set_figure(new Knight(Color.BLACK, 7, 2));
		assertTrue(rook.can_move(7, 2, table));
	}
	
	@Test
	public void test_move_horizontally_enemy_on_destination() {
		rook = new Rook(Color.WHITE, 3, 2);
		table.get_square_at_position(3, 2).set_figure(rook);
		table.get_square_at_position(3, 5).set_figure(new Knight(Color.BLACK, 3, 5));
		assertTrue(rook.can_move(3, 5, table));
	}
	
	@Test
	public void test_move_vertically_n_fields_backwards() {
		rook.set_position_x(6);
		rook.set_position_y(2);
		table.get_square_at_position(6, 2).set_figure(rook);
		assertTrue(rook.can_move(3, 2, table));
	}
	
	@Test
	public void test_move_n_fields_vertically_backwards_figure_in_back_of_rook() {
		rook.set_position_x(6);
		rook.set_position_y(2);
		table.get_square_at_position(6, 2).set_figure(rook);
		table.get_square_at_position(5, 2).set_figure(new Pawn());
		assertFalse(rook.can_move(3, 2, table));
	}
	
	@Test
	public void test_move_n_fields_vertically_backwards_figures_on_the_way() {
		rook.set_position_x(7);
		rook.set_position_y(2);
		table.get_square_at_position(7, 2).set_figure(rook);
		table.get_square_at_position(4, 2).set_figure(new Pawn());
		table.get_square_at_position(5, 2).set_figure(new Knight());
		assertFalse(rook.can_move(3, 2, table));
	}
	
	@Test
	public void test_move_vertically_backwards_ally_on_destination() {
		rook = new Rook(Color.WHITE, 7, 2);
		table.get_square_at_position(7, 2).set_figure(rook);
		table.get_square_at_position(3, 2).set_figure(new Knight(Color.WHITE, 3, 2));
		assertFalse(rook.can_move(3, 2, table));
	}
	
	@Test
	public void test_move_vertically_backwards_enemy_on_destination() {
		rook = new Rook(Color.WHITE, 7, 2);
		table.get_square_at_position(7, 2).set_figure(rook);
		table.get_square_at_position(3, 2).set_figure(new Knight(Color.BLACK, 3, 2));
		assertTrue(rook.can_move(3, 2, table));
	}
	
	@Test
	public void test_move_n_fields_horizontally_backwards() {
		rook.set_position_x(3);
		rook.set_position_y(7);
		table.get_square_at_position(3, 7).set_figure(rook);
		assertTrue(rook.can_move(3, 2, table));
	}

	@Test
	public void test_move_n_fields_horizontally_backwards_figure_next_to_rook() {
		rook.set_position_x(3);
		rook.set_position_y(5);
		table.get_square_at_position(3, 5).set_figure(rook);
		table.get_square_at_position(3, 4).set_figure(new Pawn());
		assertFalse(rook.can_move(3, 3, table));
	}
	
	@Test
	public void test_move_n_fields_horizontally_backwards_figures_on_the_way() {
		rook.set_position_x(3);
		rook.set_position_y(6);
		table.get_square_at_position(3, 6).set_figure(rook);
		table.get_square_at_position(3, 3).set_figure(new Queen());
		table.get_square_at_position(3, 4).set_figure(new Pawn());
		assertFalse(rook.can_move(3, 2, table));
	}
	
	@Test
	public void test_move_horizontally_backwards_ally_on_destination() {
		rook = new Rook(Color.WHITE, 3, 5);
		table.get_square_at_position(3, 5).set_figure(rook);
		table.get_square_at_position(3, 2).set_figure(new Knight(Color.WHITE, 3, 2));
		assertFalse(rook.can_move(3, 2, table));
	}
	
	@Test
	public void test_move_horizontally_backwards_enemy_on_destination() {
		rook = new Rook(Color.WHITE, 3, 5);
		table.get_square_at_position(3, 5).set_figure(rook);
		table.get_square_at_position(3, 2).set_figure(new Knight(Color.BLACK, 3, 2));
		assertTrue(rook.can_move(3, 2, table));
	}
	
	@Test
	public void test_move_like_knight() {
		rook.set_position_x(2);
		rook.set_position_y(2);
		table.get_square_at_position(2, 2).set_figure(rook);
		assertFalse(rook.can_move(4, 3, table));
	}
	
	@Test
	public void test_move_4_horizontally_5_vertically() {
		rook.set_position_x(1);
		rook.set_position_y(3);
		table.get_square_at_position(1, 3).set_figure(rook);
		assertFalse(rook.can_move(6, 7, table));
		rook.set_position_x(7);
		rook.set_position_y(7);
		table.get_square_at_position(7, 7).set_figure(rook);
		assertFalse(rook.can_move(3, 2, table));
		assertFalse(rook.can_move(2, 3, table));
		rook.set_position_x(3);
		rook.set_position_y(2);
		table.get_square_at_position(3, 2).set_figure(rook);
		assertFalse(rook.can_move(7, 7, table));
	}
	
	@Test
	public void test_move_rook_diagonally() {
		rook.set_position_x(1);
		rook.set_position_y(3);
		table.get_square_at_position(1, 3).set_figure(rook);
		assertFalse(rook.can_move(4, 6, table));
		assertFalse(rook.can_move(2, 2, table));
		assertFalse(rook.can_move(0, 4, table));
		rook.set_position_x(7);
		rook.set_position_y(7);
		table.get_square_at_position(7, 7).set_figure(rook);
		assertFalse(rook.can_move(2, 2, table));
	}
	
	@Test
	public void test_rook_changes_position() {
		rook = new Rook(Color.BLACK, 3, 5);
		assertEquals(rook.get_position_x(), 3);
		assertEquals(rook.get_position_y(), 5);
		assertNotEquals(rook.get_position_x(), 7);
		rook.move(7, 5);
		assertNotEquals(rook.get_position_x(), 3);
		assertEquals(rook.get_position_x(), 7);
		assertEquals(rook.get_position_y(), 5);
	}
}
