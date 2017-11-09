package table;

import static org.junit.Assert.*;

import org.junit.Test;

import table.Square.Color;

public class Test_square {

	@Test
	public void test_init_square() {
		Square square = new Square();
		assertNotNull(square);
	}
	
	@Test
	public void test_set_color_black(){
		Square square = new Square();
		square.color = Color.BLACK;
		assertEquals(Color.BLACK, square.color);
	}
	
	@Test
	public void test_set_color_white() {
		Square square = new Square();
		square.color = Color.WHITE;
		assertEquals(Color.WHITE, square.color);
	}

}
