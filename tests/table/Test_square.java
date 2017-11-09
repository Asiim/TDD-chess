package table;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_square {

	@Test
	public void test_init_square() {
		Square square = new Square();
		assertNotNull(square);
	}
	
	@Test
	public void test_set_color_black(){
		Square square = new Square();
		assertEquals(0, square.color);
	}
	

}
