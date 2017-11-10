package figures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sun.prism.paint.Color;

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
}
