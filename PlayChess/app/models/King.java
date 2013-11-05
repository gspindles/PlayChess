package models;

import java.util.ArrayList;
import java.util.List;

public class King extends ChessPiece {
	
	// constructor
	public King(Side side) {
		this.pieceType = PieceType.KING;
		this.side = side;
		this.alive = true;
	}
	
	
	// method
	public List<Point> getPossibleMoves(Point point) {
		List<Point> availableMoves = new ArrayList<Point>();
		
		return super.filterBadLocation(availableMoves);
	}
}
