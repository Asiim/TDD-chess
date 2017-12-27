package figures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import enums.Color;
import table.Table;


public class Test_king {

	private King king;
	private Table table;
	
	@Before
	public void setUp() throws Exception {
		king = new King();
		table = new Table();
	}
	
	@Test
	public void test_init_king() {
		assertNotNull(king);
	}
		
	@Test
	public void test_position_king() {
		king.set_position_x(0);
		king.set_position_y(0);
		assertEquals(0, king.get_position_x());
		assertEquals(0, king.get_position_y());
	}

	@Test
	public void test_init_white_position_king() {
		king = new King(Color.WHITE, 5, 2);
		assertEquals(Color.WHITE, king.get_color());
		assertEquals(5, king.get_position_x());
		assertEquals(2, king.get_position_y());
	}

	@Test
	public void test_init_black_position_king() {
		king = new King(Color.BLACK, 2, 5);
		assertEquals(Color.BLACK, king.get_color());
		assertEquals(2, king.get_position_x());
		assertEquals(5, king.get_position_y());
	}

	@Test
	public void test_move_one_field_right() {
		king.set_position_x(3);
		king.set_position_y(2);
		table.get_square_at_position(3, 2).set_figure(king);
		assertTrue(king.can_move(3, 3, table));
	}

	@Test
	public void test_move_one_field_left() {
		king.set_position_x(5);
		king.set_position_y(1);
		table.get_square_at_position(5, 1).set_figure(king);
		assertTrue(king.can_move(5, 0, table));
	}

	@Test
	public void test_move_one_field_forward() {
		king.set_position_x(5);
		king.set_position_y(1);
		table.get_square_at_position(5, 1).set_figure(king);
		assertTrue(king.can_move(6, 1, table));
	}

	@Test
	public void test_move_one_field_backward() {
		king.set_position_x(3);
		king.set_position_y(3);
		table.get_square_at_position(3, 3).set_figure(king);
		assertTrue(king.can_move(2, 3, table));
	}

	@Test
	public void test_move_one_field_diagonally_forward_right() {
		king.set_position_x(3);
		king.set_position_y(3);
		table.get_square_at_position(3, 3).set_figure(king);
		assertTrue(king.can_move(4, 4, table));
	}
	
	@Test
	public void test_move_one_field_diagonally_backward_right() {
		king.set_position_x(3);
		king.set_position_y(3);
		table.get_square_at_position(3, 3).set_figure(king);
		assertTrue(king.can_move(2, 4, table));
	}

	@Test
	public void test_move_one_field_diagonally_backward_left() {
		king.set_position_x(3);
		king.set_position_y(3);
		table.get_square_at_position(3, 3).set_figure(king);
		assertTrue(king.can_move(2, 2, table));
	}

	@Test
	public void test_move_one_field_diagonally_forward_left() {
		king.set_position_x(3);
		king.set_position_y(3);
		table.get_square_at_position(3, 3).set_figure(king);
		assertTrue(king.can_move(4, 2, table));
	}

	@Test
	public void test_move_king_horizontally_ally_on_destination() {
		king = new King(Color.BLACK, 2, 6);
		table.get_square_at_position(2, 6).set_figure(king);
		table.get_square_at_position(2, 7).set_figure(new Pawn(Color.BLACK, 2, 7));
		table.get_square_at_position(2, 5).set_figure(new Queen(Color.BLACK, 2, 5));
		assertFalse(king.can_move(2, 7, table));
		assertFalse(king.can_move(2, 5, table));
		king = new King(Color.WHITE, 3, 3);
		table.get_square_at_position(3, 3).set_figure(king);
		table.get_square_at_position(4, 3).set_figure(new Pawn(Color.WHITE, 4, 3));
		table.get_square_at_position(2, 3).set_figure(new Queen(Color.WHITE, 2, 3));
		assertFalse(king.can_move(4, 3, table));
		assertFalse(king.can_move(2, 3, table));
	}

	@Test
	public void test_move_king_vertically_ally_on_destination() {
		king = new King(Color.BLACK, 3, 3);
		table.get_square_at_position(3, 3).set_figure(king);
		table.get_square_at_position(4, 3).set_figure(new Pawn(Color.BLACK, 4, 3));
		table.get_square_at_position(2, 3).set_figure(new Queen(Color.BLACK, 2, 3));
		assertFalse(king.can_move(4, 3, table));
		assertFalse(king.can_move(2, 3, table));
		king = new King(Color.WHITE, 2, 6);
		table.get_square_at_position(2, 6).set_figure(king);
		table.get_square_at_position(2, 7).set_figure(new Pawn(Color.WHITE, 2, 7));
		table.get_square_at_position(2, 5).set_figure(new Queen(Color.WHITE, 2, 5));
		assertFalse(king.can_move(2, 7, table));
		assertFalse(king.can_move(2, 5, table));
	}

	@Test
	public void test_move_king_diagonally_ally_on_destination() {
		king = new King(Color.BLACK, 5, 1);
		table.get_square_at_position(5, 1).set_figure(king);
		table.get_square_at_position(6, 2).set_figure(new Pawn(Color.BLACK, 6, 2));
		table.get_square_at_position(4, 0).set_figure(new Queen(Color.BLACK, 4, 0));
		table.get_square_at_position(4, 2).set_figure(new Pawn(Color.BLACK, 4, 2));
		table.get_square_at_position(6, 0).set_figure(new Queen(Color.BLACK, 6, 0));
		assertFalse(king.can_move(6, 2, table));
		assertFalse(king.can_move(4, 0, table));
		assertFalse(king.can_move(4, 2, table));
		assertFalse(king.can_move(6, 0, table));
		king = new King(Color.WHITE, 1, 4);
		table.get_square_at_position(1, 4).set_figure(king);
		table.get_square_at_position(2, 5).set_figure(new Pawn(Color.WHITE, 2, 5));
		table.get_square_at_position(0, 3).set_figure(new Queen(Color.WHITE, 0, 3));
		table.get_square_at_position(2, 3).set_figure(new Pawn(Color.WHITE, 2, 3));
		table.get_square_at_position(0, 5).set_figure(new Queen(Color.WHITE, 0, 5));
		assertFalse(king.can_move(2, 5, table));
		assertFalse(king.can_move(0, 3, table));
		assertFalse(king.can_move(2, 3, table));
		assertFalse(king.can_move(0, 5, table));
	}
	
	@Test
	public void test_move_king_one_field_enemy_on_destination() {
		king = new King(Color.WHITE, 5, 1);
		table.get_square_at_position(5, 1).set_figure(king);
		table.get_square_at_position(6, 2).set_figure(new Bishop(Color.BLACK, 6, 2));
		assertTrue(king.can_move(6, 2, table));
		table.get_square_at_position(5, 0).set_figure(new Pawn(Color.BLACK, 5, 0));
		assertTrue(king.can_move(5, 0, table));
		table.get_square_at_position(5, 2).set_figure(new Pawn(Color.BLACK, 5, 2));
		assertTrue(king.can_move(5, 2, table));
		table.get_square_at_position(6, 0).set_figure(new Rook(Color.BLACK, 6, 0));
		assertTrue(king.can_move(6, 0, table));
		table = new Table();
		king = new King(Color.BLACK, 1, 4);
		table.get_square_at_position(1, 4).set_figure(king);
		table.get_square_at_position(0, 5).set_figure(new Knight(Color.WHITE, 0, 5));
		assertTrue(king.can_move(0, 5, table));
		table.get_square_at_position(0, 3).set_figure(new Knight(Color.WHITE, 0, 3));
		assertTrue(king.can_move(0, 3, table));
		table.get_square_at_position(0, 4).set_figure(new Bishop(Color.WHITE, 2, 3));
		assertTrue(king.can_move(0, 4, table));
	}
	
	@Test
	public void test_move_king_like_rook() {
		king = new King(Color.BLACK, 3, 1);
		table.get_square_at_position(3, 1).set_figure(king);
		assertFalse(king.can_move(3, 4, table));
		assertFalse(king.can_move(6, 1, table));
		assertFalse(king.can_move(1, 1, table));
	}
	
	@Test
	public void test_move_king_like_bishop() {
		king = new King(Color.BLACK, 3, 1);
		table.get_square_at_position(3, 1).set_figure(king);
		assertFalse(king.can_move(6, 4, table));
		assertFalse(king.can_move(0, 4, table));
	}

	@Test
	public void test_move_king_like_knight() {
		king = new King(Color.BLACK, 3, 4);
		table.get_square_at_position(3, 1).set_figure(king);
		assertFalse(king.can_move(5, 5, table));
		assertFalse(king.can_move(1, 3, table));
	}
	
	@Test
	public void test_move_king_destination_occupied_by_rook() {
		king = new King(Color.WHITE, 4, 4);
		table.get_square_at_position(4, 4).set_figure(king);
		table.get_square_at_position(5, 7).set_figure(new Rook(Color.BLACK, 4, 7));
		assertFalse(king.can_move(5, 4, table));
		table = new Table();
		king = new King(Color.WHITE, 2, 4);
		table.get_square_at_position(2, 4).set_figure(king);
		table.get_square_at_position(1, 5).set_figure(new Rook(Color.BLACK, 1, 5));
		assertFalse(king.can_move(3, 5, table));
		table = new Table();
		table.get_square_at_position(4, 4).set_figure(king);
		table.get_square_at_position(7, 5).set_figure(new Rook(Color.BLACK, 7, 5));
		assertFalse(king.can_move(5, 5, table));
		table = new Table();
		table.get_square_at_position(4, 4).set_figure(king);
		table.get_square_at_position(3, 2).set_figure(new Rook(Color.BLACK, 3, 2));
		assertFalse(king.can_move(3, 5, table));
	}
	
	@Test
	public void test_move_king_destination_occupied_by_bishop() {
		king = new King(Color.WHITE, 4, 4);
		table.get_square_at_position(4, 4).set_figure(king);
		table.get_square_at_position(6, 5).set_figure(new Bishop(Color.BLACK, 6, 5));
		assertFalse(king.can_move(5, 4, table));
		table = new Table();
		king = new King(Color.WHITE, 2, 4);
		table.get_square_at_position(2, 4).set_figure(king);
		table.get_square_at_position(1, 3).set_figure(new Bishop(Color.BLACK, 1, 3));
		assertFalse(king.can_move(3, 5, table));
		table = new Table();
		king = new King(Color.WHITE, 4, 4);
		table.get_square_at_position(4, 4).set_figure(king);
		table.get_square_at_position(7, 3).set_figure(new Bishop(Color.BLACK, 7, 3));
		assertFalse(king.can_move(5, 5, table));
		table = new Table();
		king = new King(Color.WHITE, 4, 4);
		table.get_square_at_position(4, 4).set_figure(king);
		table.get_square_at_position(1, 7).set_figure(new Bishop(Color.BLACK, 1, 7));
		assertFalse(king.can_move(3, 5, table));
	}
	
	@Test
	public void test_move_king_destination_occupied_by_knight() {
		king = new King(Color.WHITE, 4, 4);
		table.get_square_at_position(4, 4).set_figure(king);
		table.get_square_at_position(7, 5).set_figure(new Knight(Color.BLACK, 7, 5));
		assertFalse(king.can_move(5, 4, table));
		table = new Table();
		king = new King(Color.WHITE, 2, 4);
		table.get_square_at_position(2, 4).set_figure(king);
		table.get_square_at_position(1, 6).set_figure(new Knight(Color.BLACK, 1, 6));
		assertFalse(king.can_move(3, 5, table));
		table = new Table();
		king = new King(Color.WHITE, 4, 4);
		table.get_square_at_position(4, 4).set_figure(king);
		table.get_square_at_position(3, 4).set_figure(new Knight(Color.BLACK, 3, 4));
		assertFalse(king.can_move(5, 5, table));
		table = new Table();
		king = new King(Color.WHITE, 4, 4);
		table.get_square_at_position(4, 4).set_figure(king);
		table.get_square_at_position(5, 4).set_figure(new Knight(Color.BLACK, 5, 4));
		assertFalse(king.can_move(3, 5, table));
	}
	
	@Test
	public void test_move_king_destination_occupied_by_pawn() {
		king = new King(Color.WHITE, 4, 4);
		table.get_square_at_position(4, 4).set_figure(king);
		table.get_square_at_position(6, 5).set_figure(new Pawn(Color.BLACK, 6, 5));
		assertFalse(king.can_move(5, 4, table));
		table = new Table();
		king = new King(Color.WHITE, 2, 4);
		table.get_square_at_position(2, 4).set_figure(king);
		table.get_square_at_position(4, 4).set_figure(new Pawn(Color.BLACK, 4, 4));
		assertFalse(king.can_move(3, 5, table));
	}	
	
	@Test
	public void test_move_king_destination_occupied_by_king() {
		king = new King(Color.WHITE, 4, 4);
		table.get_square_at_position(4, 4).set_figure(king);
		table.get_square_at_position(6, 5).set_figure(new King(Color.BLACK, 6, 5));
		assertFalse(king.can_move(5, 4, table));
		table = new Table();
		king = new King(Color.WHITE, 2, 4);
		table.get_square_at_position(2, 4).set_figure(king);
		table.get_square_at_position(4, 4).set_figure(new King(Color.BLACK, 4, 4));
		assertFalse(king.can_move(3, 5, table));
		table = new Table();
		king = new King(Color.WHITE, 4, 4);
		table.get_square_at_position(4, 4).set_figure(king);
		table.get_square_at_position(3, 2).set_figure(new King(Color.BLACK, 3, 2));
		assertFalse(king.can_move(3, 3, table));
		table = new Table();
		king = new King(Color.WHITE, 4, 4);
		table.get_square_at_position(4, 4).set_figure(king);
		table.get_square_at_position(3, 6).set_figure(new King(Color.BLACK, 3, 6));
		assertFalse(king.can_move(3, 5, table));
	}
		
	@Test
	public void test_move_king_destination_occupied_by_queen() {
		king = new King(Color.WHITE, 4, 4);
		table.get_square_at_position(4, 4).set_figure(king);
		table.get_square_at_position(7, 6).set_figure(new Queen(Color.BLACK, 7, 6));
		assertFalse(king.can_move(5, 4, table));
		table = new Table();
		king = new King(Color.WHITE, 2, 4);
		table.get_square_at_position(2, 4).set_figure(king);
		table.get_square_at_position(3, 0).set_figure(new Queen(Color.BLACK, 3, 0));
		assertFalse(king.can_move(3, 5, table));
		table = new Table();
		king = new King(Color.WHITE, 4, 4);
		table.get_square_at_position(4, 4).set_figure(king);
		table.get_square_at_position(7, 3).set_figure(new Queen(Color.BLACK, 7, 3));
		assertFalse(king.can_move(3, 3, table));
		table = new Table();
		king = new King(Color.WHITE, 4, 4);
		table.get_square_at_position(4, 4).set_figure(king);
		table.get_square_at_position(1, 3).set_figure(new Queen(Color.BLACK, 1, 3));
		assertFalse(king.can_move(3, 5, table));
	}
	
	@Test
	public void test_king_changes_position() {
		king = new King(Color.BLACK, 3, 5);
		assertEquals(king.get_position_x(), 3);
		assertEquals(king.get_position_y(), 5);
		assertNotEquals(king.get_position_x(), 5);
		assertNotEquals(king.get_position_y(), 7);
		king.move(5, 7, table);
		assertNotEquals(king.get_position_x(), 3);
		assertNotEquals(king.get_position_y(), 5);
		assertEquals(king.get_position_x(), 5);
		assertEquals(king.get_position_y(), 7);
	}
	
	@Test
	public void test_castling_king_and_right_rook_fields_beetwen_empty() {
		king = new King(Color.BLACK, 0, 4);
		table.get_square_at_position(0, 4).set_figure(king);
		assertFalse(king.can_move(0, 6, table));
		Rook rook = new Rook(Color.BLACK, 0, 7);
		table.get_square_at_position(0, 7).set_figure(rook);
		assertTrue(king.can_move(0, 6, table));
		Bishop bishop = new Bishop(Color.BLACK, 0, 5);
		table.get_square_at_position(0, 5).set_figure(bishop);
		assertFalse(king.can_move(0, 6, table));
	}
	
	@Test
	public void test_castling_king_and_left_rook_fields_beetwen_empty() {
		king = new King(Color.BLACK, 0, 4);
		table.get_square_at_position(0, 4).set_figure(king);
		assertFalse(king.can_move(0, 2, table));
		Rook rook = new Rook(Color.BLACK, 0, 0);
		table.get_square_at_position(0, 0).set_figure(rook);
		assertTrue(king.can_move(0, 2, table));
		Queen queen = new Queen(Color.BLACK, 0, 3);
		table.get_square_at_position(0, 3).set_figure(queen);
		assertFalse(king.can_move(0, 2, table));
	}
	
	@Test
	public void test_castling_king_and_rook_rook_has_not_moved_yet() {
		king = new King(Color.BLACK, 0, 4);
		table.get_square_at_position(0, 4).set_figure(king);
		Rook rook = new Rook(Color.BLACK, 0, 0);
		table.get_square_at_position(0, 0).set_figure(rook);
		assertTrue(king.can_move(0, 2, table));
		rook.move(0, 2, table);
		table.get_square_at_position(0, 2).set_figure(rook);
		table.get_square_at_position(0, 0).set_figure(null);
		rook.move(0, 0, table);
		table.get_square_at_position(0, 0).set_figure(rook);
		table.get_square_at_position(0, 2).set_figure(null);
		assertFalse(king.can_move(0, 2, table));
	}	
	
	@Test
	public void test_castling_king_and_rook_king_has_not_moved_yet() {
		king = new King(Color.BLACK, 0, 4);
		table.get_square_at_position(0, 4).set_figure(king);
		Rook rook = new Rook(Color.BLACK, 0, 0);
		table.get_square_at_position(0, 0).set_figure(rook);
		assertTrue(king.can_move(0, 2, table));
		king.move(0, 3, table);
		table.get_square_at_position(0, 3).set_figure(king);
		table.get_square_at_position(0, 4).set_figure(null);
		king.move(0, 4, table);
		table.get_square_at_position(0, 4).set_figure(king);
		table.get_square_at_position(0, 3).set_figure(null);
		assertFalse(king.can_move(0, 2, table));
	}
	
	@Test
	public void test_castling_king_and_rook_king_is_under_attack_before_castling() {
		king = new King(Color.BLACK, 0, 4);
		table.get_square_at_position(0, 4).set_figure(king);
		Rook rook = new Rook(Color.BLACK, 0, 0);
		table.get_square_at_position(0, 0).set_figure(rook);
		Rook rook1 = new Rook(Color.WHITE, 5, 4);
		table.get_square_at_position(5, 4).set_figure(rook1);
		assertFalse(king.can_move(0, 2, table));
	}
	
	@Test
	public void test_castling_king_and_rook_king_is_under_attack_after_castling() {
		king = new King(Color.BLACK, 0, 4);
		table.get_square_at_position(0, 4).set_figure(king);
		Rook rook = new Rook(Color.BLACK, 0, 0);
		table.get_square_at_position(0, 0).set_figure(rook);
		Rook rook1 = new Rook(Color.WHITE, 5, 2);
		table.get_square_at_position(5, 2).set_figure(rook1);
		assertFalse(king.can_move(0, 2, table));
	}
}
