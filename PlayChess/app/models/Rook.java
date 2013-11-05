package models;

import java.util.ArrayList;
import java.util.List;

public class Rook extends ChessPiece {
	
	// constructor
	public Rook(Side side) {
		this.pieceType = PieceType.ROOK;
		this.side = side;
		this.alive = true;
	}
	
	
	// method
	public List<Point> getPossibleMoves(Point point) {
		List<Point> availableMoves = new ArrayList<Point>();
		
		return super.filterBadLocation(availableMoves);
	}
}
