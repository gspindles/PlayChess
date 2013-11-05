package models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Bishop extends ChessPiece {

	public Bishop(Point location, Side side) {
		this.pieceType = PieceType.BISHOP;
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
