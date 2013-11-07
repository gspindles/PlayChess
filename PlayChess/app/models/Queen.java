package chessjava;

import java.util.ArrayList;
import java.util.List;

public class Queen extends ChessPiece {

	// constructor
	public Queen(Side side) {
		this.pieceType = PieceType.QUEEN;
		this.side = side;
		this.alive = true;
	}
	
	
	// method
	public List<Point> getPossibleMoves(Point point) {
		List<Point> availableMoves = new ArrayList<Point>();
		
		return super.filterBadLocation(availableMoves);
	}
}
