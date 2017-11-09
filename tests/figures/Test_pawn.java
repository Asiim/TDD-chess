package figures;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_pawn {

	@Test
	public void test_init_pawn() {
		Pawn pawn = new Pawn();
		assertNotNull(pawn);
	}

}
