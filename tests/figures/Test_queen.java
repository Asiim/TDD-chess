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
	public void test_init_black_queen() {
		queen = new Queen(Color.BLACK);
		assertEquals(Color.BLACK, queen.get_color());
	}

	@Test
	public void test_init_white_queen() {
		queen = new Queen(Color.WHITE);
		assertEquals(Color.WHITE, queen.get_color());
	}
	
	@Test
	public void test_position_queen() {
		queen.set_position_x(4);
		queen.set_position_y(6);
		assertEquals(4, queen.get_position_x());
		assertEquals(6, queen.get_position_y());
	}
	
	@Test
	public void test_init_position_queen() {
		queen = new Queen(2, 4);
		assertEquals(2, queen.get_position_x());
		assertEquals(4, queen.get_position_y());
	}
}
