package chessjava;

import java.util.ArrayList;
import java.util.List;

public class Knight extends ChessPiece {

	// constructor
	public Knight(Side side) {
		this.pieceType = PieceType.KNIGHT;
		this.side = side;
		this.alive = true;
	}
	
	
	// method
	public List<Point> getPossibleMoves(Point p) {
		List<Point> availableMoves = new ArrayList<Point>();
		
		return super.filterBadLocation(availableMoves);
	}
}
