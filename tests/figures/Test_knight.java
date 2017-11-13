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
		assertTrue(knight.can_move(7, 6));
	}
	
	@Test
	public void test_move_two_fields_up_one_left() {
		knight.set_position_x(3);
		knight.set_position_y(3);
		table.get_square_at_position(3, 3).set_figure(knight);
		assertTrue(knight.can_move(5, 2));
	}
	
	@Test
	public void test_move_two_fields_down_one_right() {
		knight.set_position_x(7);
		knight.set_position_y(0);
		table.get_square_at_position(7, 0).set_figure(knight);
		assertTrue(knight.can_move(5, 1));
	}
	
	@Test
	public void test_move_two_fields_down_one_left() {
		knight.set_position_x(7);
		knight.set_position_y(7);
		table.get_square_at_position(7, 7).set_figure(knight);
		assertTrue(knight.can_move(5, 6));
	}
	
	@Test
	public void test_move_random() {
		knight.set_position_x(4);
		knight.set_position_y(3);
		table.get_square_at_position(4, 3).set_figure(knight);
		assertFalse(knight.can_move(4, 4));
		assertFalse(knight.can_move(7, 7));
		assertFalse(knight.can_move(0, 0));
		assertFalse(knight.can_move(7, 1));
		assertFalse(knight.can_move(3, 3));
	}
	
}
