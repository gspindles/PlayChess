package models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class King extends ChessPiece {
	public King(Point location, Side side) {
		this.pieceType = PieceType.KING;
		this.location = location;
		this.side = side;
		this.alive = true;
	}
	
	public List<Point> getPossibleMoves() {
		List<Point> availableMoves = new ArrayList<Point>();
		
		return super.filterBadLocation(availableMoves);
	}
}
