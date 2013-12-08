package models;

public class Queen extends ChessPiece {

	// constructor
	public Queen(Side side) {
		this.pieceType = PieceType.QUEEN;
		this.side = side;
		this.alive = true;
	}
}
