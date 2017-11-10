package figures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import enums.Color;


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
	
	@Test
	public void test_position_knight() {
		knight.set_position_x(7);
		knight.set_position_y(7);
		assertEquals(7, knight.get_position_x());
		assertEquals(7, knight.get_position_y());
	}
	
	@Test
	public void test_init_position_knight() {
		knight = new Knight(0, 2);
		assertEquals(0, knight.get_position_x());
		assertEquals(2, knight.get_position_y());
	}
}
