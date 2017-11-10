package figures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import enums.Color;


public class Test_pawn {

	private Pawn pawn;
	
	@Before
	public void setUp() throws Exception {
		pawn = new Pawn();
	}
	
	@Test
	public void test_init_pawn() {
		assertNotNull(pawn);
	}
	
	@Test
	public void test_init_black_pawn() {
		pawn = new Pawn(Color.BLACK);
		assertEquals(Color.BLACK, pawn.get_color());
	}
	
	@Test
	public void test_init_white_pawn() {
		pawn = new Pawn(Color.WHITE);
		assertEquals(Color.WHITE, pawn.get_color());
	}
	
	@Test
	public void test_position_rook() {
		pawn.set_position_x(4);
		pawn.set_position_y(3);
		assertEquals(4, pawn.get_position_x());
		assertEquals(3, pawn.get_position_y());
	}
	
	@Test
	public void test_init_position_pawn() {
		pawn = new Pawn(2, 4);
		assertEquals(2, pawn.get_position_x());
		assertEquals(4, pawn.get_position_y());
	}
}
