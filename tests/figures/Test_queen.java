package figures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import enums.Color;
import table.Table;


public class Test_queen {

	private Queen queen;
	private Table table;
	
	@Before
	public void setUp() throws Exception {
		table = new Table();
		queen = new Queen();
	}
	
	@Test
	public void test_init_queen() {
		assertNotNull(queen);
	}
	
	@Test
	public void test_position_queen() {
		queen.set_position_x(4);
		queen.set_position_y(6);
		assertEquals(4, queen.get_position_x());
		assertEquals(6, queen.get_position_y());
	}

	@Test
	public void test_init_white_position_queen() {
		queen = new Queen(Color.WHITE, 2, 4);
		assertEquals(Color.WHITE, queen.get_color());
		assertEquals(2, queen.get_position_x());
		assertEquals(4, queen.get_position_y());
	}
	
	@Test
	public void test_init_black_position_queen() {
		queen = new Queen(Color.BLACK, 4, 2);
		assertEquals(Color.BLACK, queen.get_color());
		assertEquals(4, queen.get_position_x());
		assertEquals(2, queen.get_position_y());
	}
	
	
	@Test
	public void test_move_one_field_vertically() {
		queen.set_position_x(1);
		queen.set_position_y(2);
		table.get_square_at_position(1, 2).set_figure(queen);
		assertTrue(queen.can_move(4, 2, table));
	}	
	
	@Test
	public void test_move_one_field_horizontally() {
		queen.set_position_x(2);
		queen.set_position_y(2);
		table.get_square_at_position(2, 2).set_figure(queen);
		assertTrue(queen.can_move(2, 3, table));
	}
	
	@Test
	public void test_move_n_fields_vertically() {
		queen.set_position_x(1);
		queen.set_position_y(2);
		table.get_square_at_position(1, 2).set_figure(queen);
		assertTrue(queen.can_move(7, 2, table));
	}

	@Test
	public void test_move_n_fields_horizontally() {
		queen.set_position_x(3);
		queen.set_position_y(2);
		table.get_square_at_position(3, 2).set_figure(queen);
		assertTrue(queen.can_move(3, 7, table));
	}

	@Test
	public void test_move_n_fields_vertically_figure_in_front_of_rook() {
		queen.set_position_x(4);
		queen.set_position_y(2);
		table.get_square_at_position(4, 2).set_figure(queen);
		table.get_square_at_position(5, 2).set_figure(new Pawn());
		assertFalse(queen.can_move(7, 2, table));
	}

	@Test
	public void test_move_n_fields_horizontally_figure_next_to_rook() {
		queen.set_position_x(5);
		queen.set_position_y(5);
		table.get_square_at_position(5, 5).set_figure(queen);
		table.get_square_at_position(5, 6).set_figure(new Pawn());
		assertFalse(queen.can_move(5, 7, table));
	}
	
	@Test
	public void test_move_n_fields_vertically_figures_on_the_way() {
		queen.set_position_x(3);
		queen.set_position_y(7);
		table.get_square_at_position(3, 7).set_figure(queen);
		table.get_square_at_position(6, 7).set_figure(new Pawn());
		table.get_square_at_position(5, 7).set_figure(new Knight());
		assertFalse(queen.can_move(7, 7, table));
	}
	
	@Test
	public void test_move_n_fields_horizontally_figures_on_the_way() {
		queen.set_position_x(7);
		queen.set_position_y(2);
		table.get_square_at_position(7, 2).set_figure(queen);
		table.get_square_at_position(7, 5).set_figure(new Queen());
		table.get_square_at_position(7, 4).set_figure(new Pawn());
		assertFalse(queen.can_move(7, 6, table));
	}
	
	@Test
	public void test_move_vertically_ally_on_destination() {
		queen = new Queen(Color.WHITE, 4, 2);
		table.get_square_at_position(4, 2).set_figure(queen);
		table.get_square_at_position(6, 2).set_figure(new Knight(Color.WHITE, 6, 2));
		assertFalse(queen.can_move(6, 2, table));
	}
	
	@Test
	public void test_move_horizontally_ally_on_destination() {
		queen = new Queen(Color.WHITE, 3, 4);
		table.get_square_at_position(3, 4).set_figure(queen);
		table.get_square_at_position(3, 6).set_figure(new Knight(Color.WHITE, 3, 6));
		assertFalse(queen.can_move(3, 6, table));
	}
	
	@Test
	public void test_move_vertically_enemy_on_destination() {
		queen = new Queen(Color.WHITE, 3, 2);
		table.get_square_at_position(3, 2).set_figure(queen);
		table.get_square_at_position(7, 2).set_figure(new Queen(Color.BLACK, 7, 2));
		assertTrue(queen.can_move(7, 2, table));
	}
	
	@Test
	public void test_move_horizontally_enemy_on_destination() {
		queen = new Queen(Color.WHITE, 3, 2);
		table.get_square_at_position(3, 2).set_figure(queen);
		table.get_square_at_position(3, 5).set_figure(new King(Color.BLACK, 3, 5));
		assertTrue(queen.can_move(3, 5, table));
	}
	
	@Test
	public void test_move_vertically_n_fields_backwards() {
		queen.set_position_x(5);
		queen.set_position_y(1);
		table.get_square_at_position(5, 1).set_figure(queen);
		assertTrue(queen.can_move(3, 1, table));
	}
	
	@Test
	public void test_move_n_fields_vertically_backwards_figure_in_back_of_rook() {
		queen.set_position_x(6);
		queen.set_position_y(4);
		table.get_square_at_position(6, 4).set_figure(queen);
		table.get_square_at_position(5, 4).set_figure(new Pawn());
		assertFalse(queen.can_move(3, 4, table));
	}
	
	@Test
	public void test_move_n_fields_vertically_backwards_figures_on_the_way() {
		queen.set_position_x(7);
		queen.set_position_y(2);
		table.get_square_at_position(7, 2).set_figure(queen);
		table.get_square_at_position(4, 2).set_figure(new Pawn());
		table.get_square_at_position(5, 2).set_figure(new Knight());
		assertFalse(queen.can_move(3, 2, table));
	}
	
	@Test
	public void test_move_vertically_backwards_ally_on_destination() {
		queen = new Queen(Color.WHITE, 7, 7);
		table.get_square_at_position(7, 7).set_figure(queen);
		table.get_square_at_position(3, 7).set_figure(new Knight(Color.WHITE, 3, 7));
		assertFalse(queen.can_move(3, 7, table));
	}
	
	@Test
	public void test_move_vertically_backwards_enemy_on_destination() {
		queen = new Queen(Color.WHITE, 7, 6);
		table.get_square_at_position(7, 6).set_figure(queen);
		table.get_square_at_position(3, 6).set_figure(new Knight(Color.BLACK, 3, 6));
		assertTrue(queen.can_move(3, 6, table));
	}
	
	@Test
	public void test_move_n_fields_horizontally_backwards() {
		queen.set_position_x(3);
		queen.set_position_y(7);
		table.get_square_at_position(3, 7).set_figure(queen);
		assertTrue(queen.can_move(3, 2, table));
	}

	@Test
	public void test_move_n_fields_horizontally_backwards_figure_next_to_rook() {
		queen.set_position_x(3);
		queen.set_position_y(5);
		table.get_square_at_position(3, 5).set_figure(queen);
		table.get_square_at_position(3, 4).set_figure(new Pawn());
		assertFalse(queen.can_move(3, 3, table));
	}
	
	@Test
	public void test_move_n_fields_horizontally_backwards_figures_on_the_way() {
		queen.set_position_x(3);
		queen.set_position_y(6);
		table.get_square_at_position(3, 6).set_figure(queen);
		table.get_square_at_position(3, 3).set_figure(new Queen());
		table.get_square_at_position(3, 4).set_figure(new Pawn());
		assertFalse(queen.can_move(3, 2, table));
	}
	
	@Test
	public void test_move_horizontally_backwards_ally_on_destination() {
		queen = new Queen(Color.WHITE, 3, 5);
		table.get_square_at_position(3, 5).set_figure(queen);
		table.get_square_at_position(3, 2).set_figure(new Knight(Color.WHITE, 3, 2));
		assertFalse(queen.can_move(3, 2, table));
	}
	
	@Test
	public void test_move_horizontally_backwards_enemy_on_destination() {
		queen = new Queen(Color.WHITE, 3, 5);
		table.get_square_at_position(3, 5).set_figure(queen);
		table.get_square_at_position(3, 2).set_figure(new Knight(Color.BLACK, 3, 2));
		assertTrue(queen.can_move(3, 2, table));
	}

	@Test
	public void test_move_one_field_diagonaly_y_increases_with_x_increased() {
		queen.set_position_x(2);
		queen.set_position_y(3);
		table.get_square_at_position(2, 3).set_figure(queen);
		assertTrue(queen.can_move(3, 4, table));
	}
	
	@Test
	public void test_move_one_field_diagonaly_y_decreased_with_x_decreased() {
		queen.set_position_x(2);
		queen.set_position_y(3);
		table.get_square_at_position(2, 3).set_figure(queen);
		assertTrue(queen.can_move(1, 2, table));
	}
	
	@Test
	public void test_move_one_field_diagonaly_y_increases_with_x_decreased() {
		queen.set_position_x(2);
		queen.set_position_y(3);
		table.get_square_at_position(2, 3).set_figure(queen);
		assertTrue(queen.can_move(1, 4, table));
	}
	
	@Test
	public void test_move_one_field_diagonaly_y_decreases_with_x_decreased() {
		queen.set_position_x(2);
		queen.set_position_y(3);
		table.get_square_at_position(2, 3).set_figure(queen);
		assertTrue(queen.can_move(3, 2, table));
	}
	
	@Test
	public void test_move_n_fields_diagonaly_y_increases_with_x_increased() {
		queen.set_position_x(2);
		queen.set_position_y(3);
		table.get_square_at_position(2, 3).set_figure(queen);
		assertTrue(queen.can_move(5, 6, table));
	}
	
	@Test
	public void test_move_n_fields_diagonaly_y_decreases_with_x_increased() {
		queen.set_position_x(2);
		queen.set_position_y(3);
		table.get_square_at_position(2, 3).set_figure(queen);
		assertTrue(queen.can_move(5, 0, table));
	}
	
	@Test
	public void test_move_n_fields_diagonaly_y_decreases_with_x_decreased() {
		queen.set_position_x(2);
		queen.set_position_y(3);
		table.get_square_at_position(2, 3).set_figure(queen);
		assertTrue(queen.can_move(0, 1, table));
	}
	
	@Test
	public void test_move_n_fields_diagonaly_y_increases_with_x_decreased() {
		queen.set_position_x(2);
		queen.set_position_y(3);
		table.get_square_at_position(2, 3).set_figure(queen);
		assertTrue(queen.can_move(0, 5, table));
	}
	
	@Test
	public void test_move_n_fields_with_figure_next_to_queen_y_increases_with_x_increased() {
		queen.set_position_x(1);
		queen.set_position_y(5);
		table.get_square_at_position(2, 6).set_figure(new Bishop());
		table.get_square_at_position(1, 5).set_figure(queen);
		assertFalse(queen.can_move(3, 7, table));
	}
	
	@Test
	public void test_move_n_fields_with_figure_next_to_queen_y_increases_with_x_decreased() {
		queen.set_position_x(2);
		queen.set_position_y(5);
		table.get_square_at_position(1, 6).set_figure(new Bishop());
		table.get_square_at_position(2, 5).set_figure(queen);
		assertFalse(queen.can_move(0, 7, table));
	}
	
	@Test
	public void test_move_n_fields_with_figure_next_to_queen_y_decreases_with_x_increased() {
		queen.set_position_x(4);
		queen.set_position_y(6);
		table.get_square_at_position(5, 5).set_figure(new Bishop());
		table.get_square_at_position(4, 6).set_figure(queen);
		assertFalse(queen.can_move(7, 3, table));
	}
	
	@Test
	public void test_move_n_fields_with_figure_next_to_queen_y_decreases_with_x_decreased() {
		queen.set_position_x(4);
		queen.set_position_y(6);
		table.get_square_at_position(3, 5).set_figure(new Bishop());
		table.get_square_at_position(4, 6).set_figure(queen);
		assertFalse(queen.can_move(1, 3, table));
	}
	
	@Test
	public void test_move_n_fields_figures_on_way_y_increases_with_x_increased() {
		queen.set_position_x(1);
		queen.set_position_y(2);
		table.get_square_at_position(3, 4).set_figure(new Bishop());
		table.get_square_at_position(5, 6).set_figure(new Bishop());
		table.get_square_at_position(1, 2).set_figure(queen);
		assertFalse(queen.can_move(6, 7, table));
	}
	
	@Test
	public void test_move_n_fields_figures_on_way_y_increases_with_x_decreased() {
		queen.set_position_x(5);
		queen.set_position_y(2);
		table.get_square_at_position(3, 4).set_figure(new Bishop());
		table.get_square_at_position(1, 6).set_figure(new Bishop());
		table.get_square_at_position(5, 2).set_figure(queen);
		assertFalse(queen.can_move(0, 7, table));
	}
	
	@Test
	public void test_move_n_fields_figures_on_way_y_decreases_with_x_increased() {
		queen.set_position_x(0);
		queen.set_position_y(7);
		table.get_square_at_position(2, 5).set_figure(new Bishop());
		table.get_square_at_position(4, 3).set_figure(new Bishop());
		table.get_square_at_position(0, 7).set_figure(queen);
		assertFalse(queen.can_move(7, 0, table));
	}
	
	@Test
	public void test_move_n_fields_figures_on_way_y_decreases_with_x_decreased() {
		queen.set_position_x(4);
		queen.set_position_y(7);
		table.get_square_at_position(1, 4).set_figure(new Bishop());
		table.get_square_at_position(2, 5).set_figure(new Bishop());
		table.get_square_at_position(4, 7).set_figure(queen);
		assertFalse(queen.can_move(0, 3, table));
	}


	@Test
	public void test_move_n_fields_ally_on_destination_y_increases_with_x_increased() {
		queen = new Queen(Color.WHITE, 2, 3);
		table.get_square_at_position(2, 3).set_figure(queen);
		table.get_square_at_position(5, 6).set_figure(new Pawn(Color.WHITE, 5, 6));
		assertFalse(queen.can_move(5, 6, table));
		table.get_square_at_position(3, 4).set_figure(new Pawn(Color.WHITE, 3, 4));
		assertFalse(queen.can_move(3, 4, table));
		queen = new Queen(Color.BLACK, 1, 2);
		table.get_square_at_position(1, 2).set_figure(queen);
		table.get_square_at_position(4, 5).set_figure(new Pawn(Color.BLACK, 4, 5));
		assertFalse(queen.can_move(4, 5, table));
		table.get_square_at_position(6, 7).set_figure(new Pawn(Color.BLACK, 6, 7));
		assertFalse(queen.can_move(6, 7, table));
	}
	
	@Test
	public void test_move_n_fields_ally_on_destination_y_increases_with_x_decreased() {
		queen = new Queen(Color.WHITE, 5, 3);
		table.get_square_at_position(5, 3).set_figure(queen);
		table.get_square_at_position(2, 6).set_figure(new Pawn(Color.WHITE, 2, 6));
		assertFalse(queen.can_move(2, 6, table));
		table.get_square_at_position(3, 5).set_figure(new Pawn(Color.WHITE, 3, 5));
		assertFalse(queen.can_move(3, 5, table));
		queen = new Queen(Color.BLACK, 7, 2);
		table.get_square_at_position(7, 2).set_figure(queen);
		table.get_square_at_position(6, 3).set_figure(new Pawn(Color.BLACK, 6, 3));
		assertFalse(queen.can_move(6, 3, table));
		table.get_square_at_position(2, 7).set_figure(new Pawn(Color.BLACK, 2, 7));
		assertFalse(queen.can_move(2, 7, table));
	}
	
	@Test
	public void test_move_n_fields_ally_on_destination_y_decreases_with_x_increased() {
		queen = new Queen(Color.WHITE, 1, 6);
		table.get_square_at_position(1, 6).set_figure(queen);
		table.get_square_at_position(2, 5).set_figure(new Pawn(Color.WHITE, 2, 5));
		assertFalse(queen.can_move(2, 5, table));
		table.get_square_at_position(6, 1).set_figure(new Pawn(Color.WHITE, 6, 1));
		assertFalse(queen.can_move(6, 1, table));
		queen = new Queen(Color.BLACK, 2, 4);
		table.get_square_at_position(2, 4).set_figure(queen);
		table.get_square_at_position(4, 2).set_figure(new Pawn(Color.BLACK, 4, 2));
		assertFalse(queen.can_move(4, 2, table));
		table.get_square_at_position(6, 0).set_figure(new Pawn(Color.BLACK, 6, 0));
		assertFalse(queen.can_move(6, 0, table));
	}
	
	
	@Test
	public void test_move_n_fields_ally_on_destination_y_decreases_with_x_decreased() {
		queen = new Queen(Color.WHITE, 6, 6);
		table.get_square_at_position(6, 6).set_figure(queen);
		table.get_square_at_position(1, 1).set_figure(new Pawn(Color.WHITE, 1, 1));
		assertFalse(queen.can_move(1, 1, table));
		table.get_square_at_position(5, 5).set_figure(new Pawn(Color.WHITE, 5, 5));
		assertFalse(queen.can_move(5, 5, table));
		queen = new Queen(Color.BLACK, 3, 5);
		table.get_square_at_position(3, 5).set_figure(queen);
		table.get_square_at_position(0, 2).set_figure(new Pawn(Color.BLACK, 0, 2));
		assertFalse(queen.can_move(0, 2, table));
		table.get_square_at_position(1, 3).set_figure(new Pawn(Color.BLACK, 1, 3));
		assertFalse(queen.can_move(1, 3, table));
	}
	
	@Test
	public void test_move_n_fields_enemy_on_destination_y_increases_with_x_increased() {
		queen = new Queen(Color.WHITE, 2, 3);
		table.get_square_at_position(2, 3).set_figure(queen);
		table.get_square_at_position(5, 6).set_figure(new Pawn(Color.BLACK, 5, 6));
		assertTrue(queen.can_move(5, 6, table));
		table.get_square_at_position(3, 4).set_figure(new Pawn(Color.BLACK, 3, 4));
		assertTrue(queen.can_move(3, 4, table));
		table = new Table();
		queen = new Queen(Color.BLACK, 1, 2);
		table.get_square_at_position(1, 2).set_figure(queen);
		table.get_square_at_position(6, 7).set_figure(new Pawn(Color.WHITE, 6, 7));
		assertTrue(queen.can_move(6, 7, table));
		table.get_square_at_position(4, 5).set_figure(new Pawn(Color.WHITE, 4, 5));
		assertTrue(queen.can_move(4, 5, table));
	}
	
	@Test
	public void test_move_n_fields_enemy_on_destination_y_increases_with_x_decreased() {
		queen = new Queen(Color.WHITE, 5, 3);
		table.get_square_at_position(5, 3).set_figure(queen);
		table.get_square_at_position(2, 6).set_figure(new Pawn(Color.BLACK, 2, 6));
		assertTrue(queen.can_move(2, 6, table));
		table.get_square_at_position(3, 5).set_figure(new Pawn(Color.BLACK, 3, 5));
		assertTrue(queen.can_move(3, 1, table));
		table = new Table();
		queen = new Queen(Color.BLACK, 7, 2);
		table.get_square_at_position(7, 2).set_figure(queen);
		table.get_square_at_position(2, 7).set_figure(new Pawn(Color.WHITE, 2, 7));
		assertTrue(queen.can_move(2, 7, table));
		table.get_square_at_position(4, 5).set_figure(new Pawn(Color.WHITE, 4, 5));
		assertTrue(queen.can_move(4, 5, table));
	}
	
	@Test
	public void test_move_n_fields_enemy_on_destination_y_decreases_with_x_increased() {
		queen = new Queen(Color.WHITE, 1, 6);
		table.get_square_at_position(1, 6).set_figure(queen);
		table.get_square_at_position(6, 1).set_figure(new Pawn(Color.BLACK, 6, 1));
		assertTrue(queen.can_move(6, 1, table));
		table.get_square_at_position(2, 5).set_figure(new Pawn(Color.BLACK, 2, 5));
		assertTrue(queen.can_move(2, 5, table));
		queen = new Queen(Color.BLACK, 2, 4);
		table.get_square_at_position(2, 4).set_figure(queen);
		table.get_square_at_position(6, 0).set_figure(new Pawn(Color.WHITE, 6, 0));
		assertTrue(queen.can_move(6, 0, table));
		table.get_square_at_position(4, 2).set_figure(new Pawn(Color.WHITE, 4, 2));
		assertTrue(queen.can_move(4, 2, table));
	}
	
	@Test
	public void test_move_n_fields_enemy_on_destination_y_decreases_with_x_decreased() {
		queen = new Queen(Color.WHITE, 5, 6);
		table.get_square_at_position(5, 6).set_figure(queen);
		table.get_square_at_position(0, 1).set_figure(new Pawn(Color.BLACK, 0, 1));
		assertTrue(queen.can_move(0, 1, table));
		table.get_square_at_position(4, 5).set_figure(new Pawn(Color.BLACK, 4, 5));
		assertTrue(queen.can_move(4, 5, table));
		queen = new Queen(Color.BLACK, 5, 4);
		table.get_square_at_position(5, 4).set_figure(queen);
		table.get_square_at_position(1, 0).set_figure(new Pawn(Color.WHITE, 1, 0));
		assertTrue(queen.can_move(1, 0, table));
		table.get_square_at_position(3, 2).set_figure(new Pawn(Color.WHITE, 3, 2));
		assertTrue(queen.can_move(3, 2, table));
	}
	
	@Test
	public void test_move_like_knight() {
		queen.set_position_x(2);
		queen.set_position_y(2);
		table.get_square_at_position(2, 2).set_figure(queen);
		assertFalse(queen.can_move(4, 3, table));
	}
	
	@Test
	public void test_move_4_horizontally_5_vertically() {
		queen.set_position_x(1);
		queen.set_position_y(3);
		table.get_square_at_position(1, 3).set_figure(queen);
		assertFalse(queen.can_move(6, 7, table));
	}
	
	@Test
	public void test_pawn_changes_position() {
		queen = new Queen(Color.BLACK, 3, 5);
		assertEquals(queen.get_position_x(), 3);
		assertEquals(queen.get_position_y(), 5);
		assertNotEquals(queen.get_position_x(), 4);
		queen.move(4, 5);
		assertNotEquals(queen.get_position_x(), 3);
		assertEquals(queen.get_position_x(), 4);
		assertEquals(queen.get_position_y(), 5);
	}
	
	
	@Test
	public void test_moving_queen_diagonally_will_left_king_atacked() {
		queen = new Queen(Color.BLACK, 3, 5);
		King king = new King(Color.BLACK, 2, 4);
		Bishop bishop = new Bishop(Color.WHITE, 5, 7);
		table.get_square_at_position(3, 5).set_figure(queen);
		table.get_square_at_position(2, 4).set_figure(king);
		table.get_square_at_position(5, 7).set_figure(bishop);
		assertFalse(queen.can_move(5, 3, table, king));
		table = new Table();
		queen = new Queen(Color.BLACK, 3, 3);
		king = new King(Color.BLACK, 3, 4);
		Rook rook = new Rook(Color.WHITE, 3, 0);
		table.get_square_at_position(3, 3).set_figure(queen);
		table.get_square_at_position(3, 4).set_figure(king);
		table.get_square_at_position(3, 0).set_figure(rook);
		assertFalse(queen.can_move(7, 7, table, king));
		table = new Table();
		Knight knight = new Knight(Color.WHITE, 5, 5);
		table.get_square_at_position(3, 3).set_figure(queen);
		table.get_square_at_position(3, 4).set_figure(king);
		table.get_square_at_position(5, 5).set_figure(knight);
		assertFalse(queen.can_move(0, 0, table, king));
	}
	
	@Test
	public void test_moving_queen_horizontally_will_left_king_atacked() {
		queen = new Queen(Color.BLACK, 3, 5);
		King king = new King(Color.BLACK, 2, 4);
		Bishop bishop = new Bishop(Color.WHITE, 5, 7);
		table.get_square_at_position(3, 5).set_figure(queen);
		table.get_square_at_position(2, 4).set_figure(king);
		table.get_square_at_position(5, 7).set_figure(bishop);
		assertFalse(queen.can_move(3, 0, table, king));
		table = new Table();
		queen = new Queen(Color.BLACK, 5, 4);
		king = new King(Color.BLACK, 3, 4);
		Rook rook = new Rook(Color.WHITE, 7, 4);
		table.get_square_at_position(5, 4).set_figure(queen);
		table.get_square_at_position(3, 4).set_figure(king);
		table.get_square_at_position(7, 4).set_figure(rook);
		assertFalse(queen.can_move(5, 5, table, king));
		table = new Table();
		Knight knight = new Knight(Color.WHITE, 5, 5);
		table.get_square_at_position(5, 4).set_figure(queen);
		table.get_square_at_position(3, 4).set_figure(king);
		table.get_square_at_position(5, 5).set_figure(knight);
		assertFalse(queen.can_move(5, 0, table, king));
	}
	
	@Test
	public void test_moving_queen_vertically_will_left_king_atacked() {
		queen = new Queen(Color.BLACK, 3, 5);
		King king = new King(Color.BLACK, 2, 4);
		Bishop bishop = new Bishop(Color.WHITE, 5, 7);
		table.get_square_at_position(3, 5).set_figure(queen);
		table.get_square_at_position(2, 4).set_figure(king);
		table.get_square_at_position(5, 7).set_figure(bishop);
		assertFalse(queen.can_move(0, 5, table, king));
		table = new Table();
		queen = new Queen(Color.BLACK, 3, 3);
		king = new King(Color.BLACK, 3, 4);
		Rook rook = new Rook(Color.WHITE, 3, 0);
		table.get_square_at_position(3, 3).set_figure(queen);
		table.get_square_at_position(3, 4).set_figure(king);
		table.get_square_at_position(3, 0).set_figure(rook);
		assertFalse(queen.can_move(0, 3, table, king));
		table = new Table();
		Knight knight = new Knight(Color.WHITE, 5, 5);
		table.get_square_at_position(3, 3).set_figure(queen);
		table.get_square_at_position(3, 4).set_figure(king);
		table.get_square_at_position(5, 5).set_figure(knight);
		assertFalse(queen.can_move(0, 3, table, king));
	}
}
