package figures;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_bishop {

	@Test
	public void test_init_bishop() {
		Bishop bishop = new Bishop();
		assertNotNull(bishop);
	}

}
