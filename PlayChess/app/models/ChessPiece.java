package chessjava;

import java.util.List;
import java.util.ArrayList;

public abstract class ChessPiece {

	// fields
	protected PieceType pieceType;
	protected Side side;
	protected Boolean alive;
    protected Boolean hasMoved = false;


	// accessor and mutator
	public PieceType getPieceType() {
		return this.pieceType;
	}

	public Side getSide() {
		return this.side;
	}

	public boolean isAlive() {
		return this.alive;
	}

	public void setAsCaptured() {
		this.alive = false;
	}
    
    public Boolean getHasMoved()
    {            
        return hasMoved;
    }
    
    public void setHasMoved()
    {
        hasMoved = true;
    }


	// methods
	public static List<Point> filterBadLocation(List<Point> ptList) {
		List<Point> goodPoints = new ArrayList<Point>();
		for (Point p : ptList) {
			if ( p.isValidPoint() ) {
				goodPoints.add(p);
			}
		}
		return goodPoints;
	}
}
