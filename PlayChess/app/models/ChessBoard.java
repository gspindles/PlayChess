package models;

public class ChessBoard {

	private final int ROWS = 8;
	private final int COLUMNS = 8;

    //these keep track of where the pieces are on the board or if there are any left
    //not really necessary except for king
    private Point[] blackRook = new Point[8];
    private Point[] whiteRook = new Point[8];

    private Point[] blackKnight = new Point[8];
    private Point[] whiteKnight = new Point[8];

    private Point[] blackBishop = new Point[8];
    private Point[] whiteBishop = new Point[8];

    private Point[] blackQueen = new Point[8];
    private Point[] whiteQueen = new Point[8];

    private Point blackKing;
    private Point whiteKing;
    private Side gameOver = Side.NEUTRAL;

    private Point[] blackPawn = new Point[8];
    private Point[] whitePawn = new Point[8];

	private Tile[][] board;

	public ChessBoard()
    {
        board = new Tile[ROWS][COLUMNS];
        board[0][0] = new Tile(new Rook(Side.WHITE), new Point(0, 0));
        board[1][0] = new Tile(new Knight(Side.WHITE), new Point(1, 0));
        board[2][0] = new Tile(new Bishop(Side.WHITE), new Point(2, 0));
        board[3][0] = new Tile(new Queen(Side.WHITE), new Point(3, 0));
        board[4][0] = new Tile(new King(Side.WHITE), new Point(4, 0));
        whiteKing = new Point(4,0);
        board[5][0] = new Tile(new Bishop(Side.WHITE), new Point(5, 0));
        board[6][0] = new Tile(new Knight(Side.WHITE), new Point(6, 0));
        board[7][0] = new Tile(new Rook(Side.WHITE), new Point(7, 0));


        board[0][1] = new Tile(new Pawn(Side.WHITE), new Point(0, 1));
        board[1][1] = new Tile(new Pawn(Side.WHITE), new Point(1, 1));
        board[2][1] = new Tile(new Pawn(Side.WHITE), new Point(2, 1));
        board[3][1] = new Tile(new Pawn(Side.WHITE), new Point(3, 1));
        board[4][1] = new Tile(new Pawn(Side.WHITE), new Point(4, 1));
        board[5][1] = new Tile(new Pawn(Side.WHITE), new Point(5, 1));
        board[6][1] = new Tile(new Pawn(Side.WHITE), new Point(6, 1));
        board[7][1] = new Tile(new Pawn(Side.WHITE), new Point(7, 1));

        for(int x = 0; x < 8; x++)
        {
            for(int y = 2; y < 6; y++)
            {
                board[x][y] = new Tile(new Empty(), new Point(x,y));
            }
        }
    //        for (int x = 0; x < 8; x += 2) {
    //                for (int y = 2; y < 6; y += 2) {
    //                        board[x][y] = new Tile(new Empty(), new Point(x, y));
    //                }
    //                for (int y = 1; y < 8; y += 2) {
    //                        board[x][y] = new Tile(new Empty(), new Point(x, y));
    //                }
    //        }
    //        for (int x = 0; x < 8; x += 2) {
    //                for (int y = 3; y < 6; y += 2) {
    //                        board[x][y] = new Tile(new Empty(), new Point(x, y));
    //                }
    //                for (int y = 1; y < 8; y += 2) {
    //                        board[x][y] = new Tile(new Empty(), new Point(x, y));
    //                }
    //        }

        board[0][6] = new Tile(new Pawn(Side.BLACK), new Point(0, 6));
        board[1][6] = new Tile(new Pawn(Side.BLACK), new Point(1, 6));
        board[2][6] = new Tile(new Pawn(Side.BLACK), new Point(2, 6));
        board[3][6] = new Tile(new Pawn(Side.BLACK), new Point(3, 6));
        board[4][6] = new Tile(new Pawn(Side.BLACK), new Point(4, 6));
        board[5][6] = new Tile(new Pawn(Side.BLACK), new Point(5, 6));
        board[6][6] = new Tile(new Pawn(Side.BLACK), new Point(6, 6));
        board[7][6] = new Tile(new Pawn(Side.BLACK), new Point(7, 6));

        board[0][7] = new Tile(new Rook(Side.BLACK), new Point(0, 7));
        board[1][7] = new Tile(new Knight(Side.BLACK), new Point(1, 7));
        board[2][7] = new Tile(new Bishop(Side.BLACK), new Point(2, 7));
        board[3][7] = new Tile(new Queen(Side.BLACK), new Point(3, 7));
        board[4][7] = new Tile(new King(Side.BLACK), new Point(4, 7));
        blackKing = new Point(4,7);
        board[5][7] = new Tile(new Bishop(Side.BLACK), new Point(5, 7));
        board[6][7] = new Tile(new Knight(Side.BLACK), new Point(6, 7));
        board[7][7] = new Tile(new Rook(Side.BLACK), new Point(7, 7));
	}


    public ChessBoard(ChessBoard b)
    {
        for(int x = 0; x < 7; x++)
        {
            for(int y = 0; y < 7; y++)
            {
                board[x][y] = b.getBoardTile(new Point(x,y));
            }
        }
    }

    /*returns the tile at a particular point
     *
     *
     */
    public Tile getBoardTile(Point pt)
    {
        if (pt.x >= 0 && pt.y >= 0)
        {
            if(pt.x <= 7 && pt.y <= 7)
            {
                return board[pt.x][pt.y];
            }
        }
        return null;
    }

    /**
     *
     * @param pt
     * @return
     */
    public ChessPiece getBoardChessPiece(Point pt)
    {
        if (pt.x >= 0 & pt.y >= 0)
        {
            if(pt.x <= 7 & pt.y <= 7)
            {
                return board[pt.x][pt.y].getChessPiece();
            }
        }
        return null;
    }

    /*sets a particular tile at pt to piece assuming both are valid
     *
     *
     */
//        public void setBoardChessPiece(Point pt, ChessPiece piece)
//        {
//            if (pt.x >= 0 & pt.y >= 0)
//            {
//                if(pt.x <= 7 & pt.y <= 7)
//                {
//                    if(piece.equals(null) == false)
//                    {
//                        if(piece.pieceType == PieceType.KING)
//                        {
//                            setKing(piece.getSide(), pt);
//                        }
//                        board[pt.x][pt.y].setChessPiece(piece);
//                    }
//                }
//            }
//        }
    /**this does not do any error checking but does the moving
     *
     * @param move the move that is going to be made
     */
    public boolean makeMove(Move move)
    {
        if (move.getEnd().x >= 0 & move.getEnd().y >= 0)
        {
            if(move.getEnd().x <= 7 & move.getEnd().y <= 7)
            {
                if(move.getPiece() != null)
                {
                    if(move.getPiece().getPieceType() == PieceType.KING)
                    {
                        setKing(move.getPiece().getSide(), move.getEnd());
                    }
                    else if(move.getPiece().getPieceType() == PieceType.PAWN)
                    {
                        move.getPiece().setHasMoved();
                    }
                    if(move.getTakenPiece() == null)
                    {
                        board[move.getEnd().x][move.getEnd().y].setChessPiece(move.getPiece());
                        board[move.getStart().x][move.getStart().y].setChessPiece(new Empty());
                        return true;
                    }
                    else
                    {
                        if(getBoardTile(move.getEnd()).getChessPiece().pieceType == PieceType.KING)
                        {
                            gameOver = getBoardTile(move.getEnd()).getChessPiece().getSide();
                        }
                        board[move.getEnd().x][move.getEnd().y].setChessPiece(move.getPiece());
                        board[move.getStart().x][move.getStart().y].setChessPiece(new Empty());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*returns the entire board array board[7][7]
     *
     */
    public Tile[][] getBoard()
    {
        return board;
    }

    /*assigns the parameter to the board
     *
     */
    public void setBoard(Tile[][] newBoard)
    {
        board = newBoard;
    }

    public Point getKing(Side side)
    {
        if(side == Side.WHITE)
        {
            return whiteKing;
        }
        return blackKing;
    }
    /*no error checking implemented here do it elsewhere
     *
     */
    private void setKing(Side side, Point p)
    {
        if(side == Side.WHITE)
        {
            whiteKing = p;
        }
        else
        {
            blackKing = p;
        }
    }
    public Side getGameOver()
    {
        return gameOver;
    }
}