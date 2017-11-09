package figures;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_rock {

	@Test
	public void test_init_rock() {
		Rock rock = new Rock();
		assertNotNull(rock);
	}

}
