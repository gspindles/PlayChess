/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chessjava;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author the0ldknighte
 */
public class AI 
{
    private Color color;
    private List<Move> whiteMoves = new ArrayList<Move>();
    private List<Move> blackMoves = new ArrayList<Move>();
    private List<Move> bestOptions = new ArrayList<Move>();
    private List<Move> tempList = new ArrayList<Move>();
    
    public AI(Color c)
    {
        color = c;
    }
    
    public void populateMoves()
    {
        for(int x = 0; x > 8; x++)
        {
            for(int y = 0; y > 8; y++)
            {
                Point temp = new Point(x,y);
                if(ChessBoard.getBoardTile(temp).getChessPiece().getPieceType() != PieceType.EMPTY)
                {
                    if(ChessBoard.getBoardTile(temp).getChessPiece().getSide() == Side.WHITE)
                    {                        
                        tempList = MoveLogic.determineMoves(ChessBoard.getBoardTile(temp));
                        for(int i = 0; i < tempList.size(); i ++)
                        {
                            whiteMoves.add(tempList.get(i));
                        }
                    }
                    else if(ChessBoard.getBoardTile(temp).getChessPiece().getSide() == Side.BLACK)
                    {
                        tempList = MoveLogic.determineMoves(ChessBoard.getBoardTile(temp));
                        for(int i = 0; i < tempList.size(); i ++)
                        {
                            blackMoves.add(tempList.get(i));
                        }
                    }
                }
            }
        }
    }
    private void determineCheck()
    {
        for(int i = 0; i < tempList.size(); i++)
        {
            
        }
    }
    private void bestMove()
    {
        if(color == Color.WHITE)
        {
            for(int i = 0; i < whiteMoves.size(); i++)
            {
                if(whiteMoves.get(i).getTakenPiece() != null)
                {
                    bestOptions.add(whiteMoves.get(i));
                }
            }
        }
        else if(color == Color.BLACK)
        {
            for(int i = 0; i < blackMoves.size(); i++)
            {
                if(blackMoves.get(i).getTakenPiece() != null)
                {
                    bestOptions.add(blackMoves.get(i));
                }
            }
        }
    }
    /*
     * change return statement to Move
     * 
     */
    public void actualMove()
    {
        bestMove();
        if(bestOptions.size() > 0)
        {
            for(int i = 0; i < bestOptions.size();i++)
            {
                            
            }
        }
        else
        {
            
        }        
    }
}
