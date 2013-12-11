package models;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

public class ChessGame {

	// the board, the turn, the player, the list of acceptable moves
	// and functions that checks for things such as castling, stalemate, checkmate, etc should go here
	// and maybe even a history of moves

	private ChessBoard chessBoard;


	public ChessGame() 
        {
		chessBoard = new ChessBoard();
	}

	/** This method receives an xy coordinates from the client and query the board
	 * then return a list of possible point on the board that the piece at this xy location
	 * can move to
	 */
	public List<Point> getPossibleMoves(int x, int y) 
        {
            Point pt = new Point(x,y);
            List<Move> moveList = MoveLogic.determineMoves(chessBoard.getBoardTile(pt), chessBoard);
            List<Point> ptList = new ArrayList<Point>();
            for(int i = 0; i < moveList.size(); i++)
            {
                ptList.add(moveList.get(i).getEnd());
                System.out.println(moveList.get(i).getEnd().toString());
            }
            return ptList;
	}
        public boolean MovePiece(int fromX, int fromY, int toX, int toY)
        {
            Point start = new Point(fromX,fromY);
            Point end = new Point(toX,toY);
            ChessPiece piece = chessBoard.getBoardTile(start).getChessPiece();
            ChessPiece pieceTaken = new Empty();
            Move move;
            if(chessBoard.getBoardTile(end).getChessPiece().getPieceType() == PieceType.EMPTY)
            {
                move = new Move(start,end,piece);
                chessBoard.makeMove(move);
                return true;
            }
            else if(chessBoard.getBoardTile(end).getChessPiece().getPieceType() != PieceType.EMPTY)
            {
                pieceTaken = chessBoard.getBoardTile(end).getChessPiece();
                move = new Move(start, end, piece, pieceTaken);
                chessBoard.makeMove(move);
                return true;
            }           
            
            return false;
        }

	// This method tells ai to make a turn and apply it to the board permanently
	public Move aiMakeATurnParallel(Side side) throws InterruptedException, ExecutionException 
        {                
		//Tracks progress of 8 asynchronous threads.
		ExecutorService pool = Executors.newFixedThreadPool(8);
		//A set of Future objects, which manage returned values from the callable threads.
		Set<Future<List<Move>>> set = new HashSet<Future<List<Move>>>();
		
		//Using threads, simultaniously scan through each column tallying a list of possible moves.
		for(int i = 0; i < 8; i++) {
			//Create threads of ParallelProcessing. Accepts a List<Move> object.
			Callable<List<Move>> myCallableThread = new ParallelProcessing(i, this.chessBoard, side);
			//pool.submit(thread) returns a "future" object containing a list of moves from that collumn.
			Future<List<Move>> future = pool.submit(myCallableThread);
			//Add future object (which contains List<Move> to our set of thread return values.
                        
			set.add(future);
		}
		
		//Transition Set to List
		List<Move> availableMoves = new ArrayList<Move>();
		//Iterate through all the future objects in our HashSet.
		for(Future<List<Move>> futureMoveList : set) 
                {
			//List.addAll(collection) adds all the elments of a collection, in this case, all the elements of a List<Move>
			//contained within each future object.
			//Future.get() will block then return a List<Move> when it's thread is finished processing.
			availableMoves.addAll(futureMoveList.get());
		}
		ParallelProcessing p = new ParallelProcessing(this.chessBoard,side);
                return p.actualMove(side, chessBoard,availableMoves);		
	}	
	public Move aiMakeATurnSequential(Side side) 
        {
                Side notSide = Side.BLACK;
                if(side == Side.BLACK)
                {
                    notSide = Side.WHITE;
                }
		AI ai = new AI();
                List<Move> validOutOfCheck = new ArrayList<Move>();
                if(MoveLogic.determineCheck(side, chessBoard) == true)
                {
                    System.out.println("Check from " + side);
                    List<Move> moves = ai.populateMoves(side, chessBoard);
                    for(int i = 0; i < moves.size();i++)
                    {
                        ChessBoard board = new ChessBoard(chessBoard);
                        board.makeMove(moves.get(i));
                        if(MoveLogic.determineCheck(side, board) == false)
                        {
                            validOutOfCheck.add(moves.get(i));
                        }
                    }
                    if(validOutOfCheck.size() > 0)
                    {
                        return ai.actualMove(side, chessBoard, validOutOfCheck);
                    }
                    else
                    {
                        //checkmate has happened
                    }
                }
                
		return ai.actualMove(side, this.chessBoard);			
	}
        public ChessBoard getBoard()
        {
            return chessBoard;
        }
}
