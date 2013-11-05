package models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Queen extends ChessPiece {

	public Queen(Point location, Side side) {
		this.pieceType = PieceType.QUEEN;
		this.location = location;
		this.side = side;
		this.alive = true;
	}
	
	public List<Point> getPossibleMoves() {
		List<Point> availableMoves = new ArrayList<Point>();
		
		return super.filterBadLocation(availableMoves);
	}
}
