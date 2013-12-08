package chessjava;

public class ChessGame {

	// the board, the turn, the player, the list of acceptable moves
	// and functions that checks for things such as castling, stalemate, checkmate, etc should go here
	// and maybe even a history of moves

	private ChessBoard chessBoard;


	public ChessGame() {
		chessBoard = new ChessBoard();
	}


	// this method apply a move to the board
	public void applyMoveToBoard(Move move) {

	}


	// query the board given xy coordinates and return relevant information
	public static Tile queryBoard(int x, int y) {
		return null;
	}


	/* This method receives an xy coordinates from the client and query the board
	 * then return a list of possible point on the board that the piece at this xy location
	 * can move to
	 */
	public List<Point> getPossibleMoves(int x, int y) {
		return null;
	}


	// This method tells ai to make a turn and apply it to the board permanently
	public static void aiMakeATurn() {

	}
}
