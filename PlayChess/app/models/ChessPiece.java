package models;

import java.util.List;
import java.util.ArrayList;

public abstract class ChessPiece {

	// fields
	protected PieceType pieceType;
	protected Side side;
	protected Boolean alive;


	// accessor and mutator
	public PieceType getPieceType() {
		return this.pieceType;
	}

	public Side getSide() {
		return this.side;
	}

	public boolean isAlive() {
		return this.alive;
	}

	public void setAsCaptured() {
		this.alive = false;
	}


	// methods
	public abstract List<Point> getPossibleMoves(Point point);

	public static List<Point> filterBadLocation(List<Point> ptList) {
		List<Point> goodPoints = new ArrayList<Point>();
		for (Point p : ptList) {
			if ( p.isValidPoint() ) {
				goodPoints.add(p);
			}
		}
		return goodPoints;
	}
}
