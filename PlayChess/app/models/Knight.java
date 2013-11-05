package models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Knight extends ChessPiece {

	public Knight(Point location, Side side) {
		this.pieceType = PieceType.KNIGHT;
		this.location = location;
		this.side = side;
		this.alive = true;
	}
	
	public List<Point> getPossibleMoves() {
		List<Point> availableMoves = new ArrayList<Point>();
		
		return super.filterBadLocation(availableMoves);
	}
}
