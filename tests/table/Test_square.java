package table;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import enums.Color;
import figures.Pawn;

public class Test_square {

	private Square square;
	
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
		square.set_figure(pawn);
		assertEquals(pawn, square.get_figure());
	}
	
	@Test
	public void test_init_black_square() {
		square = new Square(Color.BLACK);
		assertEquals(Color.BLACK, square.get_color());
	}

	@Test
	public void test_init_white_square() {
		square = new Square(Color.WHITE);
		assertEquals(Color.WHITE, square.get_color());
	}
}
