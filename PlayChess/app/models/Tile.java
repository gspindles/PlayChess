package models;

import java.util.List;

public class Tile {

	// fields
	private ChessPiece chessPiece;
	private Color color;
	private Point location;
	
	
	// constructor
	public Tile(ChessPiece chessPiece, Color color, Point location) {
		this.chessPiece = chessPiece;
		this.color = color;
		this.location = location;
	}
	
	
	// accessor and mutator
	public ChessPiece getChessPiece() {
		return this.chessPiece;
	}
	
	public void setChessPiece(ChessPiece chessPiece) {
		this.chessPiece = chessPiece;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public Point getLocation() {
		return this.location;
	}
	
	
	// methods
	public List<Point> getPossibleMoves() {
		return this.chessPiece.getPossibleMoves(this.location);
	}
}
