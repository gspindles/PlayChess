package models;

public class ChessBoard {

	private final int ROWS = 8;
	private final int COLUMNS = 8;

	private Tile[][] board;

	public ChessBoard() {
    	board = new Tile[ROWS][COLUMNS];
        board[0][0] = new Tile(new Rook(Side.WHITE), Color.BLACK, new Point(0, 0));
        board[0][1] = new Tile(new Knight(Side.WHITE), Color.WHITE, new Point(0, 1));
        board[0][2] = new Tile(new Bishop(Side.WHITE), Color.BLACK, new Point(0, 2));
        board[0][3] = new Tile(new Queen(Side.WHITE), Color.WHITE, new Point(0, 3));
        board[0][4] = new Tile(new King(Side.WHITE), Color.BLACK, new Point(0, 4));
        board[0][5] = new Tile(new Bishop(Side.WHITE), Color.WHITE, new Point(0, 5));
        board[0][6] = new Tile(new Knight(Side.WHITE), Color.BLACK, new Point(0, 6));
        board[0][7] = new Tile(new Rook(Side.WHITE), Color.WHITE, new Point(0, 7));

        board[1][0] = new Tile(new Pawn(Side.WHITE), Color.WHITE, new Point(1, 0));
        board[1][1] = new Tile(new Pawn(Side.WHITE), Color.BLACK, new Point(1, 1));
        board[1][2] = new Tile(new Pawn(Side.WHITE), Color.WHITE, new Point(1, 2));
        board[1][3] = new Tile(new Pawn(Side.WHITE), Color.BLACK, new Point(1, 3));
        board[1][4] = new Tile(new Pawn(Side.WHITE), Color.WHITE, new Point(1, 4));
        board[1][5] = new Tile(new Pawn(Side.WHITE), Color.BLACK, new Point(1, 5));
        board[1][6] = new Tile(new Pawn(Side.WHITE), Color.WHITE, new Point(1, 6));
        board[1][7] = new Tile(new Pawn(Side.WHITE), Color.BLACK, new Point(1, 7));

        for (int i = 2; i < 6; i += 2) {
                for (int j = 0; j < 8; j += 2) {
                        board[i][j] = new Tile(new Empty(Side.NEUTRAL), Color.BLACK, new Point(i, j));
                }
                for (int j = 1; j < 8; j += 2) {
                        board[i][j] = new Tile(new Empty(Side.NEUTRAL), Color.WHITE, new Point(i, j));
                }
        }
        for (int i = 3; i < 6; i += 2) {
                for (int j = 0; j < 8; j += 2) {
                        board[i][j] = new Tile(new Empty(Side.NEUTRAL), Color.WHITE, new Point(i, j));
                }
                for (int j = 1; j < 8; j += 2) {
                        board[i][j] = new Tile(new Empty(Side.NEUTRAL), Color.BLACK, new Point(i, j));
                }
        }

        board[6][0] = new Tile(new Pawn(Side.BLACK), Color.BLACK, new Point(6, 0));
        board[6][1] = new Tile(new Pawn(Side.BLACK), Color.WHITE, new Point(6, 1));
        board[6][2] = new Tile(new Pawn(Side.BLACK), Color.BLACK, new Point(6, 2));
        board[6][3] = new Tile(new Pawn(Side.BLACK), Color.WHITE, new Point(6, 3));
        board[6][4] = new Tile(new Pawn(Side.BLACK), Color.BLACK, new Point(6, 4));
        board[6][5] = new Tile(new Pawn(Side.BLACK), Color.WHITE, new Point(6, 5));
        board[6][6] = new Tile(new Pawn(Side.BLACK), Color.BLACK, new Point(6, 6));
        board[6][7] = new Tile(new Pawn(Side.BLACK), Color.WHITE, new Point(6, 7));

        board[7][0] = new Tile(new Rook(Side.BLACK), Color.WHITE, new Point(7, 0));
        board[7][1] = new Tile(new Knight(Side.BLACK), Color.BLACK, new Point(7, 1));
        board[7][2] = new Tile(new Bishop(Side.BLACK), Color.WHITE, new Point(7, 2));
        board[7][3] = new Tile(new Queen(Side.BLACK), Color.BLACK, new Point(7, 3));
        board[7][4] = new Tile(new King(Side.BLACK), Color.WHITE, new Point(7, 4));
        board[7][5] = new Tile(new Bishop(Side.BLACK), Color.BLACK, new Point(7, 5));
        board[7][6] = new Tile(new Knight(Side.BLACK), Color.WHITE, new Point(7, 6));
        board[7][7] = new Tile(new Rook(Side.BLACK), Color.BLACK, new Point(7, 7));
	}

}