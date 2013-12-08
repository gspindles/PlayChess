package models;

public class Bishop extends ChessPiece {

	// constructor
	public Bishop(Side side) {
		this.pieceType = PieceType.BISHOP;
		this.side = side;
		this.alive = true;
	}
}
