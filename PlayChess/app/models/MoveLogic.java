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
public class MoveLogic 
{
    /*determines the moves that are available to a particular piece and then reurns an arraylist of points
     * 
     *
     */
    public static List<Point> determineMoves(Tile tile)
    {
        List<Point> array = new ArrayList<Point>();
        Point pt = tile.getLocation();
        if(tile.getChessPiece().pieceType.name() == "EMPTY")
        {
            
        }
        else
        {
            //determines which way certain pieces can move pawns for example move different directions
            //based on which team they are on
            if(tile.getChessPiece().getSide() == Side.BLACK)
            {                
                if(tile.getChessPiece().getPieceType().name() == "PAWN")
                {                    
                    //if the pawn has not moved yet
                    if(tile.getChessPiece().getHasMoved() == false)
                    {
                        if(tile.getLocation().south().equals(new Empty()))
                        {
                            array.add(tile.getLocation().south());
                            if(tile.getLocation().south().south().equals(new Empty()))
                            {                                
                                array.add(tile.getLocation().south().south());
                            }
                        }
                        //check the se tile to see if there is a piece
                        if(tile.getLocation().se().isValidPoint() == true)
                        {
                            if(ChessBoard_1.getBoardChessPiece(tile.getLocation().se()).getPieceType() != PieceType.EMPTY)
                            {    
                                //check to see if that piece is the same color
                                if(tile.getChessPiece().getSide() != ChessBoard_1.getBoardChessPiece(tile.getLocation().se()).getSide())
                                {
                                    array.add(tile.getLocation().se());
                                }
                            }
                        }
                         
                        if(tile.getLocation().sw().isValidPoint() == true)
                        {
                            //check the sw tile to see if there is a piece
                            if(ChessBoard_1.getBoardChessPiece(tile.getLocation().sw()).getPieceType() != PieceType.EMPTY)
                            {
                                //check to see if that piece is the same color
                                if(tile.getChessPiece().getSide() != ChessBoard_1.getBoardChessPiece(tile.getLocation().sw()).getSide())
                                {
                                    array.add(tile.getLocation().sw());
                                }
                            }
                        }                        
                    }
                    
                    //if the pawn has moved
                    else
                    {
                        
                    }
                }
                else if(tile.getChessPiece().getPieceType().name() == "ROOK")
                {

                }
                else if(tile.getChessPiece().getPieceType().name() == "BISHOP")
                {

                }
                else if(tile.getChessPiece().getPieceType().name() == "KNIGHT")
                {

                }
                else if(tile.getChessPiece().getPieceType().name() == "QUEEN")
                {

                }
                else if(tile.getChessPiece().getPieceType().name() == "KING")
                {

                }
            }
            //determines which way certain pieces can move pawns for example move different directions
            //based on which team they are on
            else if(tile.getChessPiece().getSide() == Side.WHITE)
            {
                if(tile.getChessPiece().getPieceType().name() == "PAWN")
                {
                    if(tile.getChessPiece().getHasMoved() == false)
                    {

                    }
                    else
                    {                

                    }
                }
                else if(tile.getChessPiece().getPieceType().name() == "ROOK")
                {

                }
                else if(tile.getChessPiece().getPieceType().name() == "BISHOP")
                {

                }
                else if(tile.getChessPiece().getPieceType().name() == "KNIGHT")
                {

                }
                else if(tile.getChessPiece().getPieceType().name() == "QUEEN")
                {

                }
                else if(tile.getChessPiece().getPieceType().name() == "KING")
                {

                }
            }
            
        }
        
        return array;
    }
}
