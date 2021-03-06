package models;

import java.util.ArrayList;
import java.util.List;

public class Rook extends ChessPiece {
	
	// constructor
	public Rook(Side side) {
		this.pieceType = PieceType.ROOK;
		this.side = side;
		this.alive = true;
	}
        
        @Override
        public String toString()
        {
            return "PieceType: Rook Side: " + side;
        }
}
