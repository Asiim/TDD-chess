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
		table.get_square()[3][2].set_figure(rook);
		assertTrue(rook.canMove(4, 2));
	}
	
	@Test
	public void test_move_one_field_diagonally() {
		rook.set_position_x(3);
		rook.set_position_y(2);
		table.get_square()[3][2].set_figure(rook);
		assertFalse(rook.canMove(4, 3));
	}
	
	@Test
	public void test_move_one_field_horizontally() {
		rook.set_position_x(3);
		rook.set_position_y(2);
		table.get_square()[3][2].set_figure(rook);
		assertTrue(rook.canMove(3, 3));
	}
}
