package table;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sun.glass.ui.Size;

public class Test_table {

	@Test
	public void test_init_table() {
		Table table = new Table();
		assertNotNull(table);
	}

	@Test
	public void test_table_size() {
		Table table = new Table();
		assertEquals(8, table.square.length);
		for(int i = 0; i < table.square.length; i++) {
			assertEquals(8, table.square[i].length);
		}
	}
	
}
