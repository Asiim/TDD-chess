package figures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sun.prism.paint.Color;

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
}
