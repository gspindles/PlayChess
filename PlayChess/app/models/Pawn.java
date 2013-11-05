package models;

import java.awt.Point;
import java.util.List;
import java.util.ArrayList;

public class Pawn extends ChessPiece {
	
	public Pawn(Point location, Side side) {
		this.pieceType = PieceType.PAWN;
		this.location = location;
		this.side = side;
		this.alive = true;
	}
	
	public List<Point> getPossibleMoves() {
		List<Point> availableMoves = new ArrayList<Point>();
		if (this.side == Side.BLACK) {
			
		} else {
			
		}
		return super.filterBadLocation(availableMoves);
	}
}
