package models;


public class Rook extends ChessPiece {
	
	// constructor
	public Rook(Side side) {
		this.pieceType = PieceType.ROOK;
		this.side = side;
		this.alive = true;
	}
}
