package models;

import java.awt.Point;

public class ChessBoard {

	private final int ROWS = 8;
	private final int COLUMNS = 8;
	
	private ChessPiece[][] board;
	
	public ChessBoard() {
		 board = new ChessPiece[ROWS][COLUMNS];
		 board[0][0] = new Rook(new Point(0,0), Side.WHITE);
	}
}