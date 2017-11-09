package figures;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_king {

	@Test
	public void test_init_king() {
		King king = new King();
		assertNotNull(king);
	}

}
