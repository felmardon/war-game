package model.map;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for Board class.
 *
 * @author Test Suite
 */
public class BoardTest {

    private model.map.Board board;
    private static final int BOARD_WIDTH = 8;
    private static final int BOARD_HEIGHT = 8;

    @Before
    public void setUp() {
        board = new model.map.Board(BOARD_WIDTH, BOARD_HEIGHT);
    }

    @Test
    public void testBoardInitialization() {
        assertNotNull(board);
    }

    @Test
    public void testGetSquare() {
        model.map.Board.Square square = board.getSquare(0, 0);
        assertNotNull(square);
    }

    @Test
    public void testSquareValue() {
        model.map.Board.Square square = board.getSquare(0, 0);
        int value = square.getValue();

        // Square values should be between 0 and 9 (based on Board constructor)
        assertTrue("Square value should be between 0 and 9", value >= 0 && value < 10);
    }

    @Test
    public void testMultipleSquares() {
        // Test that different squares can have different values
        java.util.Set<Integer> uniqueValues = new java.util.HashSet<>();

        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                model.map.Board.Square square = board.getSquare(i, j);
                uniqueValues.add(square.getValue());
            }
        }

        // Should have some variation in values
        assertTrue("Board should have multiple different square values", uniqueValues.size() > 1);
    }

    @Test
    public void testSquarePieceInitialization() {
        model.map.Board.Square square = board.getSquare(0, 0);
        model.map.Board.Piece piece = square.getPiece();

        assertNull("Square should not have a piece initially", piece);
    }

    @Test
    public void testSetAndGetPiece() {
        model.map.Board.Square square = board.getSquare(0, 0);

        model.map.Board.Piece bluePiece = board.new Piece(model.map.Board.Color.BLUE);
        square.setPiece(bluePiece);

        assertEquals(bluePiece, square.getPiece());
    }

    @Test
    public void testPieceColor() {
        model.map.Board.Square square = board.getSquare(0, 0);

        model.map.Board.Piece bluePiece = board.new Piece(model.map.Board.Color.BLUE);
        square.setPiece(bluePiece);

        assertEquals(model.map.Board.Color.BLUE, bluePiece.getColor());
    }

    @Test
    public void testMultiplePieces() {
        model.map.Board.Square square1 = board.getSquare(0, 0);
        model.map.Board.Square square2 = board.getSquare(1, 1);

        model.map.Board.Piece bluePiece = board.new Piece(model.map.Board.Color.BLUE);
        model.map.Board.Piece greenPiece = board.new Piece(model.map.Board.Color.GREEN);

        square1.setPiece(bluePiece);
        square2.setPiece(greenPiece);

        assertEquals(model.map.Board.Color.BLUE, square1.getPiece().getColor());
        assertEquals(model.map.Board.Color.GREEN, square2.getPiece().getColor());
    }

    @Test
    public void testBoardWidth() {
        // Test that we can access all columns
        for (int i = 0; i < BOARD_WIDTH; i++) {
            model.map.Board.Square square = board.getSquare(i, 0);
            assertNotNull(square);
        }
    }

    @Test
    public void testBoardHeight() {
        // Test that we can access all rows
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            model.map.Board.Square square = board.getSquare(0, i);
            assertNotNull(square);
        }
    }

    @Test
    public void testColorEnum() {
        assertEquals(2, model.map.Board.Color.values().length);
        assertNotNull(model.map.Board.Color.BLUE);
        assertNotNull(model.map.Board.Color.GREEN);
    }

    @Test
    public void testReplacePiece() {
        model.map.Board.Square square = board.getSquare(0, 0);

        model.map.Board.Piece piece1 = board.new Piece(model.map.Board.Color.BLUE);
        model.map.Board.Piece piece2 = board.new Piece(model.map.Board.Color.GREEN);

        square.setPiece(piece1);
        assertEquals(model.map.Board.Color.BLUE, square.getPiece().getColor());

        square.setPiece(piece2);
        assertEquals(model.map.Board.Color.GREEN, square.getPiece().getColor());
    }
}

