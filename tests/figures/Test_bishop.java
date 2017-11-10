package figures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import enums.Color;

public class Test_bishop {

	private Bishop bishop;
	
	@Before
	public void setUp() throws Exception {
		bishop = new Bishop();
	}
	
	@Test
	public void test_init_bishop() {
		assertNotNull(bishop);
	}

	@Test
	public void test_init_black_bishop() {
		bishop = new Bishop(Color.BLACK);
		assertEquals(Color.BLACK, bishop.get_color());
	}
	
	@Test
	public void test_init_white_bishop() {
		bishop = new Bishop(Color.WHITE);
		assertEquals(Color.WHITE, bishop.get_color());
	}
	
	@Test
	public void test_position_bishop() {
		bishop.set_position_x(0);
		bishop.set_position_y(7);
		assertEquals(0, bishop.get_position_x());
		assertEquals(7, bishop.get_position_y());
	}
	
	@Test
	public void test_init_position_bishop() {
		bishop = new Bishop(7, 0);
		assertEquals(7, bishop.get_position_x());
		assertEquals(0, bishop.get_position_y());
	}
}
