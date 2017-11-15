package figures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import enums.Color;
import table.Table;


public class Test_king {

	private King king;
	private Table table;
	
	@Before
	public void setUp() throws Exception {
		king = new King();
		table = new Table();
	}
	
	@Test
	public void test_init_king() {
		assertNotNull(king);
	}
		
	@Test
	public void test_position_king() {
		king.set_position_x(0);
		king.set_position_y(0);
		assertEquals(0, king.get_position_x());
		assertEquals(0, king.get_position_y());
	}

	@Test
	public void test_init_white_position_king() {
		king = new King(Color.WHITE, 5, 2);
		assertEquals(Color.WHITE, king.get_color());
		assertEquals(5, king.get_position_x());
		assertEquals(2, king.get_position_y());
	}

	@Test
	public void test_init_black_position_king() {
		king = new King(Color.BLACK, 2, 5);
		assertEquals(Color.BLACK, king.get_color());
		assertEquals(2, king.get_position_x());
		assertEquals(5, king.get_position_y());
	}

	@Test
	public void test_move_one_field_right() {
		king.set_position_x(3);
		king.set_position_y(2);
		table.get_square_at_position(3, 2).set_figure(king);
		assertTrue(king.can_move(3, 3, table));
	}

	@Test
	public void test_move_one_field_left() {
		king.set_position_x(5);
		king.set_position_y(1);
		table.get_square_at_position(5, 1).set_figure(king);
		assertTrue(king.can_move(5, 0, table));
	}

	@Test
	public void test_move_one_field_forward() {
		king.set_position_x(5);
		king.set_position_y(1);
		table.get_square_at_position(5, 1).set_figure(king);
		assertTrue(king.can_move(6, 1, table));
	}

	@Test
	public void test_move_one_field_backward() {
		king.set_position_x(3);
		king.set_position_y(3);
		table.get_square_at_position(3, 3).set_figure(king);
		assertTrue(king.can_move(2, 3, table));
	}

	@Test
	public void test_move_one_field_diagonally_forward_right() {
		king.set_position_x(3);
		king.set_position_y(3);
		table.get_square_at_position(3, 3).set_figure(king);
		assertTrue(king.can_move(4, 4, table));
	}
	
	@Test
	public void test_move_one_field_diagonally_backward_right() {
		king.set_position_x(3);
		king.set_position_y(3);
		table.get_square_at_position(3, 3).set_figure(king);
		assertTrue(king.can_move(2, 4, table));
	}

	@Test
	public void test_move_one_field_diagonally_backward_left() {
		king.set_position_x(3);
		king.set_position_y(3);
		table.get_square_at_position(3, 3).set_figure(king);
		assertTrue(king.can_move(2, 2, table));
	}

	@Test
	public void test_move_one_field_diagonally_forward_left() {
		king.set_position_x(3);
		king.set_position_y(3);
		table.get_square_at_position(3, 3).set_figure(king);
		assertTrue(king.can_move(4, 2, table));
	}
}
