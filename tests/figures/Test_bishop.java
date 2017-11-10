package figures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sun.prism.paint.Color;

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
}
