package figures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import enums.Color;
import table.Table;


public class Test_knight {

	private Knight knight;
	private Table table;
	
	@Before
	public void setUp() throws Exception {
		table = new Table();
		knight = new Knight();
	}
	
	@Test
	public void test_init_knight() {
		assertNotNull(knight);
	}
	
	@Test
	public void test_position_knight() {
		knight.set_position_x(7);
		knight.set_position_y(7);
		assertEquals(7, knight.get_position_x());
		assertEquals(7, knight.get_position_y());
	}
	
	@Test
	public void test_init_white_position_knight() {
		knight = new Knight(Color.WHITE, 0, 2);
		assertEquals(Color.WHITE, knight.get_color());
		assertEquals(0, knight.get_position_x());
		assertEquals(2, knight.get_position_y());
	}

	@Test
	public void test_init_black_position_knight() {
		knight = new Knight(Color.BLACK, 2, 0);
		assertEquals(Color.BLACK, knight.get_color());
		assertEquals(2, knight.get_position_x());
		assertEquals(0, knight.get_position_y());
	}
	
	@Test
	public void test_move_two_fields_up_one_right() {
		knight.set_position_x(5);
		knight.set_position_y(5);
		table.get_square_at_position(5, 5).set_figure(knight);
		assertTrue(knight.can_move(7, 6, table));
	}
	
	@Test
	public void test_move_two_fields_up_one_left() {
		knight.set_position_x(3);
		knight.set_position_y(3);
		table.get_square_at_position(3, 3).set_figure(knight);
		assertTrue(knight.can_move(5, 2, table));
	}
	
	@Test
	public void test_move_two_fields_down_one_right() {
		knight.set_position_x(7);
		knight.set_position_y(0);
		table.get_square_at_position(7, 0).set_figure(knight);
		assertTrue(knight.can_move(5, 1, table));
	}
	
	@Test
	public void test_move_two_fields_down_one_left() {
		knight.set_position_x(7);
		knight.set_position_y(7);
		table.get_square_at_position(7, 7).set_figure(knight);
		assertTrue(knight.can_move(5, 6, table));
	}

	@Test
	public void test_move_two_fields_right_one_up() {
		knight.set_position_x(1);
		knight.set_position_y(5);
		table.get_square_at_position(1, 5).set_figure(knight);
		assertTrue(knight.can_move(2, 7, table));
	}
	
	@Test
	public void test_move_two_fields_right_one_down() {
		knight.set_position_x(4);
		knight.set_position_y(2);
		table.get_square_at_position(4, 2).set_figure(knight);
		assertTrue(knight.can_move(3, 4, table));
	}
	
	@Test
	public void test_move_two_fields_left_one_up() {
		knight.set_position_x(5);
		knight.set_position_y(4);
		table.get_square_at_position(5, 4).set_figure(knight);
		assertTrue(knight.can_move(6, 2, table));
	}
	
	@Test
	public void test_move_two_fields_left_one_down() {
		knight.set_position_x(7);
		knight.set_position_y(7);
		table.get_square_at_position(7, 7).set_figure(knight);
		assertTrue(knight.can_move(6, 5, table));
	}
	
	@Test
	public void test_make_unalowed_moves() {
		knight.set_position_x(4);
		knight.set_position_y(3);
		table.get_square_at_position(4, 3).set_figure(knight);
		assertFalse(knight.can_move(4, 4, table));
		assertFalse(knight.can_move(7, 7, table));
		assertFalse(knight.can_move(0, 0, table));
		assertFalse(knight.can_move(7, 1, table));
		assertFalse(knight.can_move(3, 3, table));
	}
	
	@Test
	public void test_move_on_ally_figure() {
		knight = new Knight(Color.WHITE, 2, 3);
		table.get_square_at_position(2, 3).set_figure(knight);
		table.get_square_at_position(3, 5).set_figure(new Pawn(Color.WHITE, 3, 5));
		assertFalse(knight.can_move(3, 5, table));
		table.get_square_at_position(0, 2).set_figure(new Pawn(Color.WHITE, 0, 2));
		assertFalse(knight.can_move(0, 2, table));
		knight = new Knight(Color.BLACK, 6, 7);
		table.get_square_at_position(7, 5).set_figure(new Pawn(Color.BLACK, 7, 5));
		assertFalse(knight.can_move(7, 5, table));
		table.get_square_at_position(5, 5).set_figure(new Pawn(Color.BLACK, 5, 5));
		assertFalse(knight.can_move(5, 5, table));
	}
	
	@Test
	public void test_move_on_enemy_figure() {
		knight = new Knight(Color.WHITE, 2, 3);
		table.get_square_at_position(2, 3).set_figure(knight);
		table.get_square_at_position(3, 5).set_figure(new Pawn(Color.BLACK, 3, 5));
		assertTrue(knight.can_move(3, 5, table));
		table.get_square_at_position(0, 2).set_figure(new Pawn(Color.BLACK, 0, 2));
		assertTrue(knight.can_move(0, 2, table));
		knight = new Knight(Color.BLACK, 6, 7);
		table.get_square_at_position(7, 5).set_figure(new Pawn(Color.WHITE, 7, 5));
		assertTrue(knight.can_move(7, 5, table));
		table.get_square_at_position(5, 5).set_figure(new Pawn(Color.WHITE, 5, 5));
		assertTrue(knight.can_move(5, 5, table));
	}
	
	@Test
	public void test_move_horizontally() {
		knight.set_position_x(2);
		knight.set_position_y(3);
		table.get_square_at_position(2, 3).set_figure(knight);
		assertFalse(knight.can_move(2, 5, table));
		assertFalse(knight.can_move(2, 0, table));
	}
	
	@Test
	public void test_move_vertically() {
		knight.set_position_x(2);
		knight.set_position_y(3);
		table.get_square_at_position(2, 3).set_figure(knight);
		assertFalse(knight.can_move(1, 3, table));
		assertFalse(knight.can_move(7, 3, table));
	}
	
	@Test
	public void test_move_diagonally() {
		knight.set_position_x(2);
		knight.set_position_y(3);
		table.get_square_at_position(2, 3).set_figure(knight);
		assertFalse(knight.can_move(5, 6, table));
		assertFalse(knight.can_move(0, 1, table));
		assertFalse(knight.can_move(5, 0, table));
		assertFalse(knight.can_move(1, 4, table));
	}
	
	@Test
	public void test_move_4_horizontally_5_vertically() {
		knight.set_position_x(1);
		knight.set_position_y(3);
		table.get_square_at_position(1, 3).set_figure(knight);
		assertFalse(knight.can_move(6, 7, table));
		knight.set_position_x(7);
		knight.set_position_y(7);
		table.get_square_at_position(7, 7).set_figure(knight);
		assertFalse(knight.can_move(3, 2, table));
		assertFalse(knight.can_move(2, 3, table));
		knight.set_position_x(3);
		knight.set_position_y(2);
		table.get_square_at_position(3, 2).set_figure(knight);
		assertFalse(knight.can_move(7, 7, table));
	}
	
	@Test
	public void test_pawn_changes_position() {
		knight = new Knight(Color.BLACK, 3, 5);
		assertEquals(knight.get_position_x(), 3);
		assertEquals(knight.get_position_y(), 5);
		assertNotEquals(knight.get_position_x(), 4);
		assertNotEquals(knight.get_position_y(), 7);
		knight.move(4, 7);
		assertNotEquals(knight.get_position_x(), 3);
		assertNotEquals(knight.get_position_y(), 5);
		assertEquals(knight.get_position_x(), 4);
		assertEquals(knight.get_position_y(), 7);
	}
}
