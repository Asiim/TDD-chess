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
}
