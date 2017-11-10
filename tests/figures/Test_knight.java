package figures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sun.prism.paint.Color;

public class Test_knight {

	private Knight knight;
	
	@Before
	public void setUp() throws Exception {
		knight = new Knight();
	}
	
	@Test
	public void test_init_knight() {
		assertNotNull(knight);
	}
	
	@Test
	public void test_init_black_knight() {
		knight = new Knight(Color.BLACK);
		assertEquals(Color.BLACK, knight.get_color());
	}
	
	@Test
	public void test_init_white_knight() {
		knight = new Knight(Color.WHITE);
		assertEquals(Color.WHITE, knight.get_color());
	}
}
