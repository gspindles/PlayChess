/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 *
 * @author the0ldknighte
 */
public class ParallelProcessing implements Callable
{
    int column = 0;
    ChessBoard board;
    Side side;
    
    public ParallelProcessing(ChessBoard board, Side s)
    {
        this.board = board;
        this.side = s;
    }
    public ParallelProcessing(int column, ChessBoard board, Side s)
    {
        this.column = column;
        this.board = board;
        this.side = s;
    }    
    public List<Move> populateMoves()
    {
        List<Move> tempList = new ArrayList<Move>();
        List<Move> whiteMoves = new ArrayList<Move>();
        List<Move> blackMoves = new ArrayList<Move>();
        Point temp;
        
        for(int i = 0; i < 8; i++)
        {
            temp = new Point(column, i);
            if(board.getBoardTile(temp).getChessPiece().getPieceType() != PieceType.EMPTY)
            {
                if(board.getBoardTile(temp).getChessPiece().side == Side.WHITE)
                {
                    tempList = MoveLogic.determineMoves(board.getBoardTile(temp), board);
                    for(int j = 0; j < tempList.size();j++)
                    {
                        whiteMoves.add(tempList.get(j));
                    }
//                    int test = 0;
//                    for(int z = 0; z<10000; z++)
//                    {
//                        test ++;
//                    }
                }
                else if(board.getBoardTile(temp).getChessPiece().side == Side.BLACK)
                {
                    tempList = MoveLogic.determineMoves(board.getBoardTile(temp), board);
                    for(int j = 0; j < tempList.size(); j++)
                    {
                        blackMoves.add(tempList.get(j));
                    }
                }
            }
        }
        if(side == Side.WHITE)
        {
            return whiteMoves;
        }
        else if(side == Side.BLACK)
        {
            return blackMoves;
        }
        return tempList;
    }
    private List<Move> bestMove(ChessBoard board, List<Move> list)
    {
        List<Move> tempList = list;
        List<Move> bestOptions = new ArrayList<Move>();
        
        for(int i = 0; i < tempList.size(); i++)
        {
            if(tempList.get(i).getTakenPiece().pieceType == PieceType.QUEEN)
            {
                tempList.get(i).setWeight(100);
                bestOptions.add(tempList.get(i));
            }
            else if(tempList.get(i).getTakenPiece().pieceType == PieceType.ROOK)
            {
                tempList.get(i).setWeight(10);
                bestOptions.add(tempList.get(i));
            }
            else if(tempList.get(i).getTakenPiece().pieceType == PieceType.KNIGHT)
            {
                tempList.get(i).setWeight(16);
                bestOptions.add(tempList.get(i));
            }
            else if(tempList.get(i).getTakenPiece().pieceType == PieceType.BISHOP)
            {
                tempList.get(i).setWeight(14);
                bestOptions.add(tempList.get(i));
            }
            else if(tempList.get(i).getTakenPiece().pieceType == PieceType.PAWN)
            {
                tempList.get(i).setWeight(5);
                bestOptions.add(tempList.get(i));
            }
            else if(tempList.get(i).getTakenPiece().pieceType == PieceType.KING)
            {
                tempList.get(i).setWeight(90);
                bestOptions.add(tempList.get(i));
            }
        }
        return bestOptions;
    }
    /*
     *
     * 
     */
    public Move actualMove(Side side, ChessBoard board, List<Move> tempList)
    {
        //list is empty if can't "take" a piece
        List<Move> bestMoves = bestMove(board,tempList);
        
        Move send;
       //If list is populated, means piece is takeable.
	   if(!bestMoves.isEmpty())
        {
            send = bestMoves.get(0);
            for(int i = 1; i < bestMoves.size();i++)
            {
                    if(bestMoves.get(i).getWeight() > send.getWeight())
                    {
                        send = bestMoves.get(i);
                    }
            }
            System.out.println("Selected best move based on weight");
        }
        //List was empty, No takeable pieces. So randomly select a piece to move.
        else
        {
			//Since bestMove is empty, use original list of all possible moves. randomly select move
            Random rand = new Random();            
            send = tempList.get(rand.nextInt(tempList.size()));
            System.out.println("No takeable pieces, randomly selected a move");
        }
        System.out.println("Move chosen: " + send);
        return send;
    }
    
     public List<Move> call()
    {
        return populateMoves();
    }     
}
