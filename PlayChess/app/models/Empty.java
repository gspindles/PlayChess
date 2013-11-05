package models;

import java.util.List;

public class Empty extends ChessPiece {
	
	// Constructor
	public Empty(Side side) {
		this.pieceType = PieceType.EMPTY;
		this.side = side;
		this.alive = true;
	}
	
	
	// method
	public List<Point> getPossibleMoves(Point point) {
		return null;
	}
}
