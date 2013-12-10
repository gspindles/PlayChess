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
        }
        return bestOptions;
    }
    /*
     *
     * 
     */
    public Move actualMove(Side side, ChessBoard board, List<Move> tempList)
    {        
        tempList = bestMove(board,tempList);
        Move send = tempList.get(0);
       
        if(tempList.size() > 0)
        {
            send = tempList.get(0);
            for(int i = 1; i < tempList.size();i++)
            {
                    if(tempList.get(i).getWeight() > send.getWeight())
                    {
                        send = tempList.get(i);
                    }
            }
        }
        if(send.getWeight() == 0)
        {
            Random rand = new Random();            
            send = tempList.get(rand.nextInt(tempList.size()));
        }
        return send;
    }
    
     public List<Move> call()
    {
        return populateMoves();
    }     
}
