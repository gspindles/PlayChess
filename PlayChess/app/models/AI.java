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
    private Side side;
    private List<Move> whiteMoves = new ArrayList<Move>();
    private List<Move> blackMoves = new ArrayList<Move>();
    private List<Move> bestOptions = new ArrayList<Move>();
    private List<Move> tempList = new ArrayList<Move>();
    
    public AI(Side s)
    {
        side = s;
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
    
    private void bestMove()
    {
        if(side == Side.WHITE)
        {
            for(int i = 0; i < whiteMoves.size(); i++)
            {
                if(whiteMoves.get(i).getTakenPiece().pieceType == PieceType.QUEEN)
                {
                    whiteMoves.get(i).setWeight(100);
                    bestOptions.add(whiteMoves.get(i));
                }
                else if(whiteMoves.get(i).getTakenPiece().pieceType == PieceType.ROOK)
                {
                    whiteMoves.get(i).setWeight(10);
                    bestOptions.add(whiteMoves.get(i));
                }
                else if(whiteMoves.get(i).getTakenPiece().pieceType == PieceType.KNIGHT)
                {
                    whiteMoves.get(i).setWeight(16);
                    bestOptions.add(whiteMoves.get(i));
                }
                else if(whiteMoves.get(i).getTakenPiece().pieceType == PieceType.BISHOP)
                {
                    whiteMoves.get(i).setWeight(14);
                    bestOptions.add(whiteMoves.get(i));
                }
                else if(whiteMoves.get(i).getTakenPiece().pieceType == PieceType.PAWN)
                {
                    whiteMoves.get(i).setWeight(5);
                    bestOptions.add(whiteMoves.get(i));
                }
            }
        }
        else if(side == Side.BLACK)
        {
            for(int i = 0; i < blackMoves.size(); i++)
            {
                if(blackMoves.get(i).getTakenPiece().pieceType == PieceType.QUEEN)
                {
                    blackMoves.get(i).setWeight(100);
                    bestOptions.add(blackMoves.get(i));
                }
                else if(blackMoves.get(i).getTakenPiece().pieceType == PieceType.ROOK)
                {
                    blackMoves.get(i).setWeight(10);
                    bestOptions.add(blackMoves.get(i));
                }
                else if(blackMoves.get(i).getTakenPiece().pieceType == PieceType.KNIGHT)
                {
                    blackMoves.get(i).setWeight(16);
                    bestOptions.add(blackMoves.get(i));
                }
                else if(whiteMoves.get(i).getTakenPiece().pieceType == PieceType.BISHOP)
                {
                    blackMoves.get(i).setWeight(14);
                    bestOptions.add(blackMoves.get(i));
                }
                else if(whiteMoves.get(i).getTakenPiece().pieceType == PieceType.PAWN)
                {
                    blackMoves.get(i).setWeight(5);
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
        List<Move> temp = new ArrayList<Move>();
        bestMove();
        if(bestOptions.size() > 0)
        {
            for(int i = 0; i < bestOptions.size();i++)
            {
                    //temp = MoveLogic.determineMoves()
            }
        }             
    }
}
