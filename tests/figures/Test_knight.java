package figures;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_knight {

	@Test
	public void test_init_knight() {
		Knight knight = new Knight();
		assertNotNull(knight);
	}

}
