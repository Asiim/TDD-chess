package figures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import enums.Color;
import table.Table;


public class Test_pawn {

	private Pawn pawn;
	private Table table;
	
	@Before
	public void setUp() throws Exception {
		pawn = new Pawn();
		table = new Table();
	}
	
	@Test
	public void test_init_pawn() {
		assertNotNull(pawn);
	}
	
	@Test
	public void test_position_rook() {
		pawn.set_position_x(4);
		pawn.set_position_y(3);
		assertEquals(4, pawn.get_position_x());
		assertEquals(3, pawn.get_position_y());
	}
	
	@Test
	public void test_init_white_position_pawn() {
		pawn = new Pawn(Color.WHITE, 2, 4);
		assertEquals(Color.WHITE, pawn.get_color());
		assertEquals(2, pawn.get_position_x());
		assertEquals(4, pawn.get_position_y());
	}
	
	@Test
	public void test_init_black_position_pawn() {
		pawn = new Pawn(Color.BLACK, 4, 2);
		assertEquals(Color.BLACK, pawn.get_color());
		assertEquals(4, pawn.get_position_x());
		assertEquals(2, pawn.get_position_y());
	}
	
	@Test
	public void test_move_pawn_one_field_forward() {
		pawn.set_position_x(1);
		pawn.set_position_y(1);
		table.get_square_at_position(1, 1).set_figure(pawn);
		assertTrue(pawn.can_move(2, 1, table));
	}
	
	@Test
	public void test_move_pawn_one_field_forward_figure_on_destination() {
		pawn.set_position_x(2);
		pawn.set_position_y(3);
		table.get_square_at_position(2, 3).set_figure(pawn);
		table.get_square_at_position(3, 3).set_figure(new Pawn());
		assertFalse(pawn.can_move(3, 3, table));
	}
	
	@Test
	public void test_move_pawn_two_fields_for_the_very_first_move() {
		pawn.set_position_x(1);
		pawn.set_position_y(3);
		table.get_square_at_position(1, 3).set_figure(pawn);
		assertTrue(pawn.can_move(3, 3, table));
	}
	
	@Test
	public void test_move_pawn_one_field_for_the_very_first_move() {
		pawn.set_position_x(1);
		pawn.set_position_y(3);
		table.get_square_at_position(1, 3).set_figure(pawn);
		assertTrue(pawn.can_move(2, 3, table));
	}
	
	@Test
	public void test_move_pawn_two_fields_not_the_very_first_move() {
		pawn.set_position_x(2);
		pawn.set_position_y(3);
		table.get_square_at_position(1, 3).set_figure(pawn);
		assertFalse(pawn.can_move(4, 3, table));
	}
	
	@Test
	public void test_move_pawn_two_fields_for_the_very_first_move_figure_on_destination() {
		pawn.set_position_x(1);
		pawn.set_position_y(3);
		table.get_square_at_position(3, 3).set_figure(new Knight());
		table.get_square_at_position(1, 3).set_figure(pawn);
		assertFalse(pawn.can_move(3, 3, table));
	}
	
	@Test
	public void test_move_pawn_one_fields_for_the_very_first_move_figure_on_destination() {
		pawn.set_position_x(1);
		pawn.set_position_y(3);
		table.get_square_at_position(2, 3).set_figure(new Knight());
		table.get_square_at_position(1, 3).set_figure(pawn);
		assertFalse(pawn.can_move(2, 3, table));
	}
	
	@Test
	public void test_move_pawn_one_field_diagonally_right_enemy_figure_on_destination() {
		pawn = new Pawn(Color.WHITE, 1, 3);
		table.get_square_at_position(2, 4).set_figure(new Knight(Color.BLACK, 2, 4));
		table.get_square_at_position(1, 3).set_figure(pawn);
		assertTrue(pawn.can_move(2, 4, table));
		pawn = new Pawn(Color.BLACK, 6, 3);
		table.get_square_at_position(7, 4).set_figure(new Knight(Color.WHITE, 7, 4));
		table.get_square_at_position(1, 3).set_figure(pawn);
		assertTrue(pawn.can_move(7, 4, table));
	}
	
	@Test
	public void test_move_pawn_one_field_diagonally_left_enemy_figure_on_destination() {
		pawn = new Pawn(Color.WHITE, 1, 3);
		table.get_square_at_position(2, 2).set_figure(new Knight(Color.BLACK, 2, 2));
		table.get_square_at_position(1, 3).set_figure(pawn);
		assertTrue(pawn.can_move(2, 2, table));
		pawn = new Pawn(Color.BLACK, 5, 3);
		table.get_square_at_position(6, 2).set_figure(new Knight(Color.WHITE, 6, 2));
		table.get_square_at_position(5, 3).set_figure(pawn);
		assertTrue(pawn.can_move(6, 2, table));
	}

	@Test
	public void test_move_pawn_one_field_diagonally_ally_figure_on_destination() {
		pawn = new Pawn(Color.WHITE, 1, 3);
		table.get_square_at_position(2, 2).set_figure(new Knight(Color.WHITE, 2, 2));
		table.get_square_at_position(1, 3).set_figure(pawn);
		assertFalse(pawn.can_move(2, 2, table));
		table.get_square_at_position(2, 4).set_figure(new Knight(Color.WHITE, 2, 4));
		assertFalse(pawn.can_move(2, 4, table));
		pawn = new Pawn(Color.BLACK, 3, 5);
		table.get_square_at_position(4, 4).set_figure(new Knight(Color.BLACK, 4, 4));
		table.get_square_at_position(3, 5).set_figure(pawn);
		assertFalse(pawn.can_move(4, 4, table));
		table.get_square_at_position(4, 6).set_figure(new Knight(Color.BLACK, 4, 6));
		assertFalse(pawn.can_move(4, 6, table));
	}
	
	@Test
	public void test_move_pawn_one_field_diagonally_destination_empty() {
		pawn = new Pawn(Color.WHITE, 1, 3);
		table.get_square_at_position(1, 3).set_figure(pawn);
		assertFalse(pawn.can_move(2, 2, table));
	}
}
