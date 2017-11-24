package game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import enums.Color;

public class Test_game {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test_game_init() {
		assertNotNull(new Game());
	}

	@Test
	public void test_white_player_starts_first() {
		Game game = new Game();
		Chess_controler cc = new Chess_controler();
		cc.initialize(null, null);
		assertEquals(Color.WHITE, cc.get_player());
	}
}
