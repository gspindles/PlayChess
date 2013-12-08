/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
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
    public ParallelProcessing(int column, ChessBoard board, Side s)
    {
        this.column = column;
        this.board = board;
        this.side = s;
    }
    public List<Move> populate()
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
    
     public List<Move> call()
    {
        return populate();
    }
     
}
