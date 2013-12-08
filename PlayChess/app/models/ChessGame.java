package models;

import java.util.List;
import java.util.ArrayList;

public class ChessGame {

	// the board, the turn, the player, the list of acceptable moves
	// and functions that checks for things such as castling, stalemate, checkmate, etc should go here
	// and maybe even a history of moves

	private ChessBoard chessBoard;


	public ChessGame() {
		chessBoard = new ChessBoard();
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
