package figures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import enums.Color;


public class Test_king {

	private King king;
	
	@Before
	public void setUp() throws Exception {
		king = new King();
	}
	
	@Test
	public void test_init_king() {
		assertNotNull(king);
	}
	
	@Test
	public void test_init_black_king() {
		king = new King(Color.BLACK);
		assertEquals(Color.BLACK, king.get_color());
	}
	
	@Test
	public void test_init_white_king() {
		king = new King(Color.WHITE);
		assertEquals(Color.WHITE, king.get_color());
	}
		
	@Test
	public void test_position_king() {
		king.set_position_x(0);
		king.set_position_y(0);
		assertEquals(0, king.get_position_x());
		assertEquals(0, king.get_position_y());
	}
	
	@Test
	public void test_init_position_king() {
		king = new King(5, 2);
		assertEquals(5, king.get_position_x());
		assertEquals(2, king.get_position_y());
	}
	
	@Test
	public void test_init_white_position_king() {
		king = new King(Color.WHITE, 5, 2);
		assertEquals(Color.WHITE, king.get_color());
		assertEquals(5, king.get_position_x());
		assertEquals(2, king.get_position_y());
	}
}
