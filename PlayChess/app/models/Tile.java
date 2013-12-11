package models;

import java.util.List;


public class Tile {

	// fields
	private ChessPiece chessPiece;
	private Point location;

	// constructor
	public Tile(ChessPiece chessPiece, Point location) 
        {
		this.chessPiece = chessPiece;
		this.location = location;
	}


	// accessor and mutator
	public ChessPiece getChessPiece() 
        {
		return this.chessPiece;
	}

	public void setChessPiece(ChessPiece chessPiece) 
        {
		this.chessPiece = chessPiece;
	}

	public Point getLocation() 
        {
		return this.location;
	}
        @Override
        public String toString()
        {
            return "ChessPiece: " + chessPiece.toString() + " Location: " + location.toString();
        }
}
