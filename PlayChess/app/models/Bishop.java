package models;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends ChessPiece {

	// constructor
	public Bishop(Side side) {
		this.pieceType = PieceType.BISHOP;
		this.side = side;
		this.alive = true;
	}
	
	
	// method
	public List<Point> getPossibleMoves(Point point) {
		List<Point> availableMoves = new ArrayList<Point>();
		if (this.side == Side.BLACK) {
			
		} else {
			
		}
		return super.filterBadLocation(availableMoves);
	}
}
