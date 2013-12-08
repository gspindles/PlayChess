package models;

public class Knight extends ChessPiece {

	// constructor
	public Knight(Side side) {
		this.pieceType = PieceType.KNIGHT;
		this.side = side;
		this.alive = true;
	}
}
