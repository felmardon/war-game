package model.map;

/**
 * Board where game is played.
 * 
 * @author Felipe Mardones
 *
 */
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Board {
	
	private static final Logger logger = LoggerFactory.getLogger(Board.class);
	private Square[][] squares;

	/**
	 * 
	 * 
	 * @param x length of board
	 * @param y width of board
	 */
	public Board(int x, int y) {
		logger.debug("Initializing Board with dimensions: {} x {}", x, y);

		Random rand = new Random();
		
		squares = new Square[x][y];
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				squares[i][j] = new Square(rand.nextInt(10));
			}
		}
		
		logger.info("Board initialized successfully with {} squares", (x * y));
		rand = null;
	}
	
	/**
	 * 
	 * 
	 * @param x coordinate
	 * @param y coordinate
	 * @return square with corresponding x and y coordinates
	 */
	public Square getSquare(int x, int y) {
		logger.debug("Retrieving square at coordinates: ({}, {})", x, y);
		return squares[x][y];
	}
	
	/**
	 * Container class for piece objects.
	 *  
	 * @author Felipe Mardones
	 *
	 */
	public class Square {
		private int value;
		private Piece piece;
		
		/**
		 * 
		 * @param value
		 */
		public Square(int value) {
			this.value = value;
			piece = null;
		}

		/**
		 * 
		 * 
		 * @return
		 */
		public int getValue() {
			return value;
		}

		/**
		 * Sets a new piece in the square.
		 * 
		 * @param newPiece
		 */
		public void setPiece(Piece newPiece) {
			logger.debug("Setting piece with color {} on square", newPiece.getColor());
			piece = newPiece;
		}

		/**
		 * Returns piece in square, or null if piece is not set.
		 * 
		 * @return
		 */
		public Piece getPiece() {
			return piece;
		}
	}
	
	public class Piece {
		private Color color;
		
		protected Piece(Color color) {
			this.color = color;
		}
		
		protected Color getColor() {
			return color;
		}
	}
	
	public enum Color {
		BLUE, GREEN
	}
}