package models;

import java.util.ArrayList;
import java.util.List;

public class Knight extends ChessPiece {

	// constructor
	public Knight(Side side) {
		this.pieceType = PieceType.KNIGHT;
		this.side = side;
		this.alive = true;
	}
        
        @Override
        public String toString()
        {
            return "PieceType: Knight Side: " + side;
        }
}
