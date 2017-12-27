package figures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import enums.Color;
import table.Table;


public class Test_pawn {

	private Pawn pawn;
	private Table table;
	
	@Before
	public void setUp() throws Exception {
		pawn = new Pawn();
		table = new Table();
	}
	
	@Test
	public void test_init_pawn() {
		assertNotNull(pawn);
	}
	
	@Test
	public void test_position_rook() {
		pawn.set_position_x(4);
		pawn.set_position_y(3);
		assertEquals(4, pawn.get_position_x());
		assertEquals(3, pawn.get_position_y());
	}
	
	@Test
	public void test_init_white_position_pawn() {
		pawn = new Pawn(Color.WHITE, 2, 4);
		assertEquals(Color.WHITE, pawn.get_color());
		assertEquals(2, pawn.get_position_x());
		assertEquals(4, pawn.get_position_y());
	}
	
	@Test
	public void test_init_black_position_pawn() {
		pawn = new Pawn(Color.BLACK, 4, 2);
		assertEquals(Color.BLACK, pawn.get_color());
		assertEquals(4, pawn.get_position_x());
		assertEquals(2, pawn.get_position_y());
	}
	
	@Test
	public void test_move_pawn_one_field_forward() {
		pawn.set_position_x(1);
		pawn.set_position_y(1);
		table.get_square_at_position(1, 1).set_figure(pawn);
		assertTrue(pawn.can_move(2, 1, table));
	}
	
	@Test
	public void test_move_pawn_one_field_forward_figure_on_destination() {
		pawn.set_position_x(2);
		pawn.set_position_y(3);
		table.get_square_at_position(2, 3).set_figure(pawn);
		table.get_square_at_position(3, 3).set_figure(new Pawn());
		assertFalse(pawn.can_move(3, 3, table));
	}
	
	@Test
	public void test_move_pawn_two_fields_for_the_very_first_move() {
		pawn.set_position_x(1);
		pawn.set_position_y(3);
		table.get_square_at_position(1, 3).set_figure(pawn);
		assertTrue(pawn.can_move(3, 3, table));
	}
	
	@Test
	public void test_move_pawn_one_field_for_the_very_first_move() {
		pawn.set_position_x(1);
		pawn.set_position_y(3);
		table.get_square_at_position(1, 3).set_figure(pawn);
		assertTrue(pawn.can_move(2, 3, table));
	}
	
	@Test
	public void test_move_pawn_two_fields_not_the_very_first_move() {
		pawn.set_position_x(2);
		pawn.set_position_y(3);
		table.get_square_at_position(1, 3).set_figure(pawn);
		assertFalse(pawn.can_move(4, 3, table));
	}

	@Test
	public void test_move_pawn_two_fields_for_the_very_first_move_figure_on_destination() {
		pawn.set_position_x(1);
		pawn.set_position_y(3);
		table.get_square_at_position(3, 3).set_figure(new Knight());
		table.get_square_at_position(1, 3).set_figure(pawn);
		assertFalse(pawn.can_move(3, 3, table));
	}

	@Test
	public void test_move_pawn_one_fields_for_the_very_first_move_figure_on_destination() {
		pawn.set_position_x(1);
		pawn.set_position_y(3);
		table.get_square_at_position(2, 3).set_figure(new Knight());
		table.get_square_at_position(1, 3).set_figure(pawn);
		assertFalse(pawn.can_move(2, 3, table));
	}

	@Test
	public void test_move_pawn_one_field_diagonally_right_enemy_figure_on_destination() {
		pawn = new Pawn(Color.WHITE, 1, 3);
		table.get_square_at_position(2, 4).set_figure(new Knight(Color.BLACK, 2, 4));
		table.get_square_at_position(1, 3).set_figure(pawn);
		assertTrue(pawn.can_move(2, 4, table));
		pawn = new Pawn(Color.BLACK, 6, 3);
		table.get_square_at_position(7, 4).set_figure(new Knight(Color.WHITE, 7, 4));
		table.get_square_at_position(1, 3).set_figure(pawn);
		assertTrue(pawn.can_move(7, 4, table));
	}

	@Test
	public void test_move_pawn_one_field_diagonally_left_enemy_figure_on_destination() {
		pawn = new Pawn(Color.WHITE, 1, 3);
		table.get_square_at_position(2, 2).set_figure(new Knight(Color.BLACK, 2, 2));
		table.get_square_at_position(1, 3).set_figure(pawn);
		assertTrue(pawn.can_move(2, 2, table));
		pawn = new Pawn(Color.BLACK, 5, 3);
		table.get_square_at_position(6, 2).set_figure(new Knight(Color.WHITE, 6, 2));
		table.get_square_at_position(5, 3).set_figure(pawn);
		assertTrue(pawn.can_move(6, 2, table));
	}

	@Test
	public void test_move_pawn_one_field_diagonally_ally_figure_on_destination() {
		pawn = new Pawn(Color.WHITE, 1, 3);
		table.get_square_at_position(2, 2).set_figure(new Knight(Color.WHITE, 2, 2));
		table.get_square_at_position(1, 3).set_figure(pawn);
		assertFalse(pawn.can_move(2, 2, table));
		table.get_square_at_position(2, 4).set_figure(new Knight(Color.WHITE, 2, 4));
		assertFalse(pawn.can_move(2, 4, table));
		pawn = new Pawn(Color.BLACK, 3, 5);
		table.get_square_at_position(4, 4).set_figure(new Knight(Color.BLACK, 4, 4));
		table.get_square_at_position(3, 5).set_figure(pawn);
		assertFalse(pawn.can_move(4, 4, table));
		table.get_square_at_position(4, 6).set_figure(new Knight(Color.BLACK, 4, 6));
		assertFalse(pawn.can_move(4, 6, table));
	}

	@Test
	public void test_move_pawn_one_field_diagonally_destination_empty() {
		pawn = new Pawn(Color.WHITE, 1, 3);
		table.get_square_at_position(1, 3).set_figure(pawn);
		assertFalse(pawn.can_move(2, 2, table));
	}

	@Test
	public void test_pawn_changes_position() {
		pawn = new Pawn(Color.BLACK, 3, 5);
		assertEquals(pawn.get_position_x(), 3);
		assertEquals(pawn.get_position_y(), 5);
		assertNotEquals(pawn.get_position_x(), 4);
		pawn.move(4, 5, table);
		assertNotEquals(pawn.get_position_x(), 3);
		assertEquals(pawn.get_position_x(), 4);
		assertEquals(pawn.get_position_y(), 5);
	}

	@Test
	public void test_moving_pawn_will_left_king_atacked() {
		pawn = new Pawn(Color.BLACK, 3, 5);
		King king = new King(Color.BLACK, 2, 4);
		Bishop bishop = new Bishop(Color.WHITE, 5, 7);
		table.get_square_at_position(3, 5).set_figure(pawn);
		table.get_square_at_position(2, 4).set_figure(king);
		table.get_square_at_position(5, 7).set_figure(bishop);
		assertFalse(pawn.can_move(4, 5, table, king));
		table = new Table();
		king = new King(Color.BLACK, 3, 4);
		Rook rook = new Rook(Color.WHITE, 3, 7);
		table.get_square_at_position(3, 5).set_figure(pawn);
		table.get_square_at_position(3, 4).set_figure(king);
		table.get_square_at_position(3, 7).set_figure(rook);
		assertFalse(pawn.can_move(4, 5, table, king));
		table = new Table();
		Knight knight = new Knight(Color.WHITE, 5, 5);
		table.get_square_at_position(3, 5).set_figure(pawn);
		table.get_square_at_position(3, 4).set_figure(king);
		table.get_square_at_position(5, 5).set_figure(knight);
		assertFalse(pawn.can_move(4, 5, table, king));
	}

	@Test
	public void test_moving_pawn_for_the_very_first_time_will_left_king_atacked() {
		pawn = new Pawn(Color.BLACK, 1, 5);
		King king = new King(Color.BLACK, 0, 4);
		Bishop bishop = new Bishop(Color.WHITE, 3, 7);
		table.get_square_at_position(1, 5).set_figure(pawn);
		table.get_square_at_position(0, 4).set_figure(king);
		table.get_square_at_position(3, 7).set_figure(bishop);
		assertFalse(pawn.can_move(3, 5, table, king));
		table = new Table();
		Knight knight = new Knight(Color.WHITE, 2, 3);
		table.get_square_at_position(1, 5).set_figure(pawn);
		table.get_square_at_position(0, 4).set_figure(king);
		table.get_square_at_position(2, 3).set_figure(knight);
		assertFalse(pawn.can_move(3, 5, table, king));
	}

	@Test
	public void test_cause_en_passat_and_notify_enemy_about_that() {
		pawn = new Pawn(Color.BLACK, 1, 5);
		Pawn enemy_pawn1 = new Pawn(Color.WHITE, 3, 4);
		Pawn enemy_pawn2 = new Pawn(Color.WHITE, 3, 6);
		table.get_square_at_position(1, 5).set_figure(pawn);
		table.get_square_at_position(3, 4).set_figure(enemy_pawn1);
		table.get_square_at_position(3, 6).set_figure(enemy_pawn2);
		pawn.move(3, 5, table);
		assertTrue(enemy_pawn1.en_passat_possible());
		assertTrue(enemy_pawn2.en_passat_possible());
	}

	@Test
	public void test_make_en_passat() {
		pawn = new Pawn(Color.BLACK, 1, 5);
		Pawn enemy_pawn1 = new Pawn(Color.WHITE, 3, 4);
		table.get_square_at_position(1, 5).set_figure(pawn);
		table.get_square_at_position(3, 4).set_figure(enemy_pawn1);
		pawn.move(3, 5, table);
		assertTrue(enemy_pawn1.en_passat_possible());
		table.rotate();
		assertTrue(enemy_pawn1.can_move(5, 3, table));
		assertTrue(enemy_pawn1.can_move(5, 2, table));
	}
	
	@Test
	public void test_make_en_passat_and_disable_en_passat_on_that_pawn() {
		pawn = new Pawn(Color.BLACK, 1, 5);
		Pawn enemy_pawn1 = new Pawn(Color.WHITE, 3, 4);
		table.get_square_at_position(1, 5).set_figure(pawn);
		table.get_square_at_position(3, 4).set_figure(enemy_pawn1);
		pawn.move(3, 5, table);
		assertTrue(enemy_pawn1.en_passat_possible());
		table.rotate();
		assertTrue(enemy_pawn1.can_move(5, 3, table));
		assertTrue(enemy_pawn1.can_move(5, 2, table));
		enemy_pawn1.move(5, 2, table);
		assertFalse(enemy_pawn1.en_passat_possible());
	}

	@Test
	public void test_make_en_passat_and_remove_enemy_pawn() {
		pawn = new Pawn(Color.BLACK, 1, 5);
		Pawn enemy_pawn1 = new Pawn(Color.WHITE, 3, 4);
		table.get_square_at_position(1, 5).set_figure(pawn);
		table.get_square_at_position(3, 4).set_figure(enemy_pawn1);
		pawn.move(3, 5, table);
		assertTrue(enemy_pawn1.en_passat_possible());
		table.rotate();
		assertTrue(enemy_pawn1.can_move(5, 3, table));
		assertTrue(enemy_pawn1.can_move(5, 2, table));
		enemy_pawn1.move(5, 2, table);
		assertNull(table.get_square_at_position(4, 2).get_figure());
	}

	@Test
	public void test_make_any_move_and_disable_en_passat_on_that_all_ally_pawns() {
		pawn = new Pawn(Color.BLACK, 1, 5);
		Pawn enemy_pawn1 = new Pawn(Color.WHITE, 3, 4);
		table.get_square_at_position(1, 5).set_figure(pawn);
		table.get_square_at_position(3, 4).set_figure(enemy_pawn1);
		pawn.move(3, 5, table);
		assertTrue(enemy_pawn1.en_passat_possible());
		table.rotate();
		Knight knight = new Knight(Color.WHITE, 2, 5);
		knight.move(3, 7, table);
		for(int x = 0; x < table.get_width(); x++) {
			for(int y = 0; y < table.get_length(); y++) {
				if(table.get_square_at_position(x, y).get_figure() instanceof Pawn &&
						table.get_square_at_position(x, y).get_figure().get_color().equals(knight.get_color())) {
					((Pawn) table.get_square_at_position(x, y).get_figure()).disable_en_passat(knight.get_color());
				}
			}
		}
		assertFalse(enemy_pawn1.en_passat_possible());
	}
	
	@Test
	public void test_make_en_passat_and_remove_enemy_pawn_on_one_side() {
		pawn = new Pawn(Color.BLACK, 1, 5);
		Pawn enemy_pawn1 = new Pawn(Color.WHITE, 3, 4);
		Pawn pawn2 = new Pawn(Color.BLACK, 3, 3);
		table.get_square_at_position(1, 5).set_figure(pawn);
		table.get_square_at_position(3, 4).set_figure(enemy_pawn1);
		table.get_square_at_position(3, 3).set_figure(pawn2);
		pawn.move(3, 5, table);
		assertTrue(enemy_pawn1.en_passat_possible());
		table.rotate();
		assertTrue(enemy_pawn1.can_move(5, 3, table));
		assertTrue(enemy_pawn1.can_move(5, 2, table));
		assertFalse(enemy_pawn1.can_move(5, 4, table));
		enemy_pawn1.move(5, 2, table);
		assertNull(table.get_square_at_position(4, 2).get_figure());
		assertNotNull(table.get_square_at_position(4, 4).get_figure());
	}
}
