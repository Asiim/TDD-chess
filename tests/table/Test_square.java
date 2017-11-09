package table;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import figures.Pawn;
import table.Square.Color;

public class Test_square {

	Square square;
	@Before
	public void setUp() throws Exception {
		square = new Square();
	}

	
	@Test
	public void test_init_square() {
		assertNotNull(square);
	}
	
	@Test
	public void test_set_color_black(){
		square.set_color(Color.BLACK);
		assertEquals(Color.BLACK, square.get_color());
	}
	
	@Test
	public void test_set_color_white() {
		square.set_color(Color.WHITE);
		assertEquals(Color.WHITE, square.get_color());
	}
	
	@Test
	public void test_set_pawn_on_square() {
		Pawn pawn = new Pawn();
		square.set_pawn(pawn);
		assertEquals(pawn, square.get_pawn());
	}

}
