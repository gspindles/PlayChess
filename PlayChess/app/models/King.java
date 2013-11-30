package chessjava;

import java.util.ArrayList;
import java.util.List;

public class King extends ChessPiece {
	
	// constructor
	public King(Side side) {
		this.pieceType = PieceType.KING;
		this.side = side;
		this.alive = true;
	}
}
