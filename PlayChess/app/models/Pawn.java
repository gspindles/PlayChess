package models;

import java.util.List;
import java.util.ArrayList;

public class Pawn extends ChessPiece {
	
	// constructor
	public Pawn(Side side) {
		this.pieceType = PieceType.PAWN;
		this.side = side;
		this.alive = true;
	}
	
	
	// methods
	public List<Point> getPossibleMoves(Point point) {
		List<Point> availableMoves = new ArrayList<Point>();
		if (this.side == Side.BLACK) {
			
		} else {
			
		}
		return super.filterBadLocation(availableMoves);
	}
	
	
	public void Promote(PieceType pieceType) {
		this.pieceType = pieceType;
	}
}
