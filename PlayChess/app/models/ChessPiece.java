package models;

import java.awt.Point;
import java.util.List;
import java.util.ArrayList;

public abstract class ChessPiece {

	// fields
	private PieceType pieceType;
	private Point location;
	private Side side;
	
	
	// constructor
	public ChessPiece(PieceType pieceType, Point location, Side side) {
		this.pieceType = pieceType;
		this.location = location;
		this.side = side;
	}
	
	
	// accessor and mutator
	public PieceType getPieceType() {
		return this.pieceType;
	}
	
	public Point getLocation() {
		return this.location;
	}
	
	public void setLocation(Point p) {
		this.location = p;
	}
	
	public Side getSide() {
		return this.side;
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
