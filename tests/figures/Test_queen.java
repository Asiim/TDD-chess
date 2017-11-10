package figures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import enums.Color;


public class Test_queen {

	private Queen queen;
	
	@Before
	public void setUp() throws Exception {
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
}
