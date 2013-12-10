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
    
    private Point[] blackPawn = new Point[8];
    private Point[] whitePawn = new Point[8];

	private Tile[][] board;

	public ChessBoard() {
    	board = new Tile[ROWS][COLUMNS];
        board[0][0] = new Tile(new Rook(Side.WHITE), new Point(0, 0));        
        board[0][1] = new Tile(new Knight(Side.WHITE), new Point(0, 1));        
        board[0][2] = new Tile(new Bishop(Side.WHITE), new Point(0, 2));
        board[0][3] = new Tile(new Queen(Side.WHITE), new Point(0, 3));
        board[0][4] = new Tile(new King(Side.WHITE), new Point(0, 4));
        whiteKing = new Point(0,4);
        board[0][5] = new Tile(new Bishop(Side.WHITE), new Point(0, 5));
        board[0][6] = new Tile(new Knight(Side.WHITE), new Point(0, 6));
        board[0][7] = new Tile(new Rook(Side.WHITE), new Point(0, 7));
        

        board[1][0] = new Tile(new Pawn(Side.WHITE), new Point(1, 0));
        board[1][1] = new Tile(new Pawn(Side.WHITE), new Point(1, 1));
        board[1][2] = new Tile(new Pawn(Side.WHITE), new Point(1, 2));
        board[1][3] = new Tile(new Pawn(Side.WHITE), new Point(1, 3));
        board[1][4] = new Tile(new Pawn(Side.WHITE), new Point(1, 4));
        board[1][5] = new Tile(new Pawn(Side.WHITE), new Point(1, 5));
        board[1][6] = new Tile(new Pawn(Side.WHITE), new Point(1, 6));
        board[1][7] = new Tile(new Pawn(Side.WHITE), new Point(1, 7));

        for (int i = 2; i < 6; i += 2) {
                for (int j = 0; j < 8; j += 2) {
                        board[i][j] = new Tile(new Empty(), new Point(i, j));
                }
                for (int j = 1; j < 8; j += 2) {
                        board[i][j] = new Tile(new Empty(), new Point(i, j));
                }
        }
        for (int i = 3; i < 6; i += 2) {
                for (int j = 0; j < 8; j += 2) {
                        board[i][j] = new Tile(new Empty(), new Point(i, j));
                }
                for (int j = 1; j < 8; j += 2) {
                        board[i][j] = new Tile(new Empty(), new Point(i, j));
                }
        }

        board[6][0] = new Tile(new Pawn(Side.BLACK), new Point(6, 0));
        board[6][1] = new Tile(new Pawn(Side.BLACK), new Point(6, 1));
        board[6][2] = new Tile(new Pawn(Side.BLACK), new Point(6, 2));
        board[6][3] = new Tile(new Pawn(Side.BLACK), new Point(6, 3));
        board[6][4] = new Tile(new Pawn(Side.BLACK), new Point(6, 4));
        board[6][5] = new Tile(new Pawn(Side.BLACK), new Point(6, 5));
        board[6][6] = new Tile(new Pawn(Side.BLACK), new Point(6, 6));
        board[6][7] = new Tile(new Pawn(Side.BLACK), new Point(6, 7));

        board[7][0] = new Tile(new Rook(Side.BLACK), new Point(7, 0));
        board[7][1] = new Tile(new Knight(Side.BLACK), new Point(7, 1));
        board[7][2] = new Tile(new Bishop(Side.BLACK), new Point(7, 2));
        board[7][3] = new Tile(new Queen(Side.BLACK), new Point(7, 3));
        board[7][4] = new Tile(new King(Side.BLACK), new Point(7, 4));
        blackKing = new Point(7,4);
        board[7][5] = new Tile(new Bishop(Side.BLACK), new Point(7, 5));
        board[7][6] = new Tile(new Knight(Side.BLACK), new Point(7, 6));
        board[7][7] = new Tile(new Rook(Side.BLACK), new Point(7, 7));
	}
        
        /*returns the tile at a particular point
         * 
         *
         */
        public Tile getBoardTile(Point pt)
        {            
            if (pt.x >= 0 & pt.y >= 0)
            {            
                if(pt.x <= 7 & pt.y <= 7)
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
        public void makeMove(Move move)
        {
            if (move.getEnd().x >= 0 & move.getEnd().y >= 0)
            {            
                if(move.getEnd().x <= 7 & move.getEnd().y <= 7)
                {
                    if(move.getPiece().equals(null) == false)
                    {
                        if(move.getPiece().pieceType == PieceType.KING)
                        {
                            setKing(move.getPiece().getSide(), move.getEnd());
                        }
                        if(move.getTakenPiece() == null)
                        {
                            board[move.getEnd().x][move.getEnd().y].setChessPiece(move.getPiece()); 
                        }
                        else
                        {
                            board[move.getEnd().x][move.getEnd().y].setChessPiece(move.getPiece());
                        }
                    }
                }
            }  
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

}