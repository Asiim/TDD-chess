package figures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sun.prism.paint.Color;

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
}
