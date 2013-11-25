package chessjava;

import java.util.List;

public class Empty extends ChessPiece {
	
	// Constructor
        public Empty()
        {
            this.pieceType = PieceType.EMPTY;
            this.side = Side.NEUTRAL;
            this.alive = false;            
        }	
	
	// method
	public List<Point> getPossibleMoves(Point point) {
		return null;
	}
}
