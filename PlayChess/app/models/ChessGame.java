package models;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.*;

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
	public List<Move> aiMakeATurnParallel(Side side) throws InterruptedException, ExecutionException {
		//Tracks progress of 8 asynchronous threads.
		ExecutorService pool = Executors.newFixedThreadPool(8);
		//A set of Future objects, which manage returned values from the callable threads.
		Set<Future<Move>> set = new HashSet<Future<Move>>();
		
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
		for(Future<Integer> futureMoveList : set) {
			//List.addAll(collection) adds all the elments of a collection, in this case, all the elements of a List<Move>
			//contained within each future object.
			//Future.get() will block then return a List<Move> when it's thread is finished processing.
			availableMoves.addAll(futureMoveList.get());
		}
		
		return availableMoves;
	}
	
	public List<Move> aiMakeATurnSequential(Side side) {
		//Since ParallelProcessing as the necessary code to search for possible moves... Use that!
		ParallelProcessing sequentialMoveSearch = new ParallelProcessing();
		
		List<Move> availableMoves = new ArrayList<Move>();
		
		//Sequentially iterate through each collumn and tally a list of possible moves.
		for(int i = 0; i < 8; i++) {
			//Add all the elements from the returned collection of sequentialMoveSearch to the main list, availableMoves.
			availableMoves.addAll(sequentialMoveSearch.populate(i, this.chessBoard, side));
		}
	
		return availableMoves;
	}
}
