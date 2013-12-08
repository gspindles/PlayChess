package models;

public class Pawn extends ChessPiece {
	
	// constructor
	public Pawn(Side side) {
		this.pieceType = PieceType.PAWN;
		this.side = side;
		this.alive = true;
	}
	
	
	// methods
	public void Promote(PieceType pieceType) {
		this.pieceType = pieceType;
	}
}
