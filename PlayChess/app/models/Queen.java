package models;

import java.util.ArrayList;
import java.util.List;

public class Queen extends ChessPiece {

	// constructor
	public Queen(Side side) {
		this.pieceType = PieceType.QUEEN;
		this.side = side;
		this.alive = true;
	}
}
