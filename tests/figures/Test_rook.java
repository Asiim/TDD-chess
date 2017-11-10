package figures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import enums.Color;

public class Test_rook {

	private Rook rook;
	
	@Before
	public void setUp() throws Exception {
		rook = new Rook();
	}
	
	@Test
	public void test_init_rook() {
		assertNotNull(rook);
	}

	@Test
	public void test_init_black_rook() {
		rook = new Rook(Color.BLACK);
		assertEquals(Color.BLACK, rook.get_color());
	}

	@Test
	public void test_init_white_rook() {
		rook = new Rook(Color.WHITE);
		assertEquals(Color.WHITE, rook.get_color());
	}
	
	@Test
	public void test_position_rook() {
		rook.set_position_x(4);
		rook.set_position_y(3);
		assertEquals(4, rook.get_position_x());
		assertEquals(3, rook.get_position_y());
	}
	
	@Test
	public void test_init_position_rook() {
		rook = new Rook(6, 3);
		assertEquals(6, rook.get_position_x());
		assertEquals(3, rook.get_position_y());
	}
}
