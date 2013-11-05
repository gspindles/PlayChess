package models;

import java.awt.Point;
import java.util.List;
import java.util.ArrayList;

public abstract class ChessPiece {

	// fields
	protected PieceType pieceType;
	protected Point location;
	protected Side side;
	protected Boolean alive;
	
	
	// accessor and mutator
	public PieceType getPieceType() {
		return this.pieceType;
	}
	
	public Point getLocation() {
		return this.location;
	}
	
	public void setLocation(Point p) {
		this.location.x = p.x;
		this.location.y = p.y;
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
	
	/*public ChessPiece promote() {
		return new ChessPiece(PieceType.QUEEN, this.location, this.side);
	}*/
	
	
	// methods
	public abstract List<Point> getPossibleMoves();
	
	public static List<Point> filterBadLocation(List<Point> ptList) {
		List<Point> goodPoints = new ArrayList<Point>();
		for (Point p : ptList) {
			if ( isGoodLocation(p) ) {
				goodPoints.add(p);
			}
		}
		return goodPoints;
	}
	
	public static boolean isGoodLocation(Point p) {
		if (p.x >= 1 && p.x <= 8 && p.y >= 1 && p.y <= 8) {
			return true;
		}
		return false;
	}
}
