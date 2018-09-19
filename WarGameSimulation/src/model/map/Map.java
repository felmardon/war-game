package model.map;

public class Map {
	
	private Square[][] squares;
	
	public Map(int x, int y) {
		squares = new Square[x][y];
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				squares[i][j] = new Square(i, j);
			}
		}
	}
	
	class Square {
		private int x;
		private int y;
		
		protected Square(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		protected int getX() {
			return x;
		}
		
		protected int getY() {
			return y;
		}
	}
}