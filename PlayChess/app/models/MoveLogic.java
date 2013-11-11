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
                    if(tile.getChessPiece().getHasMoved() == false  && tile.getLocation().south().isValidPoint() == true)
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
                    
                    //if the pawn has not moved
                    else
                    {
                        if(tile.getLocation().south().equals(new Empty()))
                        {
                            array.add(tile.getLocation().south());                            
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
                }
                else if(tile.getChessPiece().getPieceType() == PieceType.ROOK)
                {
                    Point temp = tile.getLocation();
                    while(temp.north().isValidPoint())
                    {
                        temp.y ++;
                        if(ChessBoard_1.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
                        {
                            if(ChessBoard_1.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                            {
                                break;
                            }
                            array.add(temp);
                            break;
                        }
                        else
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();
                    while(temp.south().isValidPoint())
                    {
                        temp.y --;
                        if(ChessBoard_1.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
                        {
                            if(ChessBoard_1.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                            {
                                break;
                            }
                            array.add(temp);
                            break;
                        }
                        else
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();
                    while(temp.east().isValidPoint())
                    {
                        temp.x ++;
                        if(ChessBoard_1.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
                        {
                            if(ChessBoard_1.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                            {
                                break;
                            }
                            array.add(temp);
                            break;
                        }
                        else
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();
                    while(temp.west().isValidPoint())
                    {
                        temp.x --;
                        if(ChessBoard_1.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
                        {
                            if(ChessBoard_1.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                            {
                                break;
                            }
                            array.add(temp);
                            break;
                        }
                        else
                        {
                            array.add(temp);
                        }
                    }
                }
                else if(tile.getChessPiece().getPieceType() == PieceType.BISHOP)
                {
                    Point temp = tile.getLocation();
                    while(temp.ne().isValidPoint())
                    {
                        temp.y ++;
                        temp.x ++;
                        if(ChessBoard_1.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
                        {
                            if(ChessBoard_1.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                            {
                                break;
                            }
                            array.add(temp);
                            break;
                        }
                        else
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();
                    while(temp.se().isValidPoint())
                    {
                        temp.y --;
                        temp.x ++;
                        if(ChessBoard_1.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
                        {
                            if(ChessBoard_1.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                            {
                                break;
                            }
                            array.add(temp);
                            break;
                        }
                        else
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();
                    while(temp.nw().isValidPoint())
                    {
                        temp.y ++;
                        temp.x --;
                        if(ChessBoard_1.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
                        {
                            if(ChessBoard_1.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                            {
                                break;
                            }
                            array.add(temp);
                            break;
                        }
                        else
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();
                    while(temp.sw().isValidPoint())
                    {
                        temp.y --;
                        temp.x --;
                        if(ChessBoard_1.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
                        {
                            if(ChessBoard_1.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                            {
                                break;
                            }
                            array.add(temp);
                            break;
                        }
                        else
                        {
                            array.add(temp);
                        }
                    }  
                }
                else if(tile.getChessPiece().getPieceType() == PieceType.KNIGHT)
                {
                    Point temp = tile.getLocation();
                    temp.x ++;
                    temp.y +=2;
                    if(temp.isValidPoint() == true)
                    {
                        if(ChessBoard_1.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();
                    temp.x --;
                    temp.y +=2;
                    if(temp.isValidPoint() == true)
                    {
                        if(ChessBoard_1.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();
                    temp.x +=2;
                    temp.y ++;
                    if(temp.isValidPoint() == true)
                    {
                        if(ChessBoard_1.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();
                    temp.x +=2;
                    temp.y --;
                    if(temp.isValidPoint() == true)
                    {
                        if(ChessBoard_1.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();
                    temp.x ++;
                    temp.y -=1;
                    if(temp.isValidPoint() == true)
                    {
                        if(ChessBoard_1.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();
                    temp.x --;
                    temp.y -=1;
                    if(temp.isValidPoint() == true)
                    {
                        if(ChessBoard_1.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();
                    temp.x +=2;
                    temp.y ++;
                    if(temp.isValidPoint() == true)
                    {
                        if(ChessBoard_1.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();
                    temp.x +=2;
                    temp.y --;
                    if(temp.isValidPoint() == true)
                    {
                        if(ChessBoard_1.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
                        {
                            array.add(temp);
                        }
                    }                    

                }
                //literally copy pasted code from Rook and Bishop
                else if(tile.getChessPiece().getPieceType() == PieceType.QUEEN)
                {
                    Point temp = tile.getLocation();
                    while(temp.north().isValidPoint())
                    {
                        temp.y ++;
                        if(ChessBoard_1.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
                        {
                            if(ChessBoard_1.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                            {
                                break;
                            }
                            array.add(temp);
                            break;
                        }
                        else
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();
                    while(temp.south().isValidPoint())
                    {
                        temp.y --;
                        if(ChessBoard_1.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
                        {
                            if(ChessBoard_1.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                            {
                                break;
                            }
                            array.add(temp);
                            break;
                        }
                        else
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();
                    while(temp.east().isValidPoint())
                    {
                        temp.x ++;
                        if(ChessBoard_1.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
                        {
                            if(ChessBoard_1.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                            {
                                break;
                            }
                            array.add(temp);
                            break;
                        }
                        else
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();
                    while(temp.west().isValidPoint())
                    {
                        temp.x --;
                        if(ChessBoard_1.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
                        {
                            if(ChessBoard_1.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                            {
                                break;
                            }
                            array.add(temp);
                            break;
                        }
                        else
                        {
                            array.add(temp);
                        }
                    }                                
                    
                    while(temp.ne().isValidPoint())
                    {
                        temp.y ++;
                        temp.x ++;
                        if(ChessBoard_1.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
                        {
                            if(ChessBoard_1.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                            {
                                break;
                            }
                            array.add(temp);
                            break;
                        }
                        else
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();
                    while(temp.se().isValidPoint())
                    {
                        temp.y --;
                        temp.x ++;
                        if(ChessBoard_1.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
                        {
                            if(ChessBoard_1.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                            {
                                break;
                            }
                            array.add(temp);
                            break;
                        }
                        else
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();
                    while(temp.nw().isValidPoint())
                    {
                        temp.y ++;
                        temp.x --;
                        if(ChessBoard_1.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
                        {
                            if(ChessBoard_1.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                            {
                                break;
                            }
                            array.add(temp);
                            break;
                        }
                        else
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();
                    while(temp.sw().isValidPoint())
                    {
                        temp.y --;
                        temp.x --;
                        if(ChessBoard_1.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
                        {
                            if(ChessBoard_1.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                            {
                                break;
                            }
                            array.add(temp);
                            break;
                        }
                        else
                        {
                            array.add(temp);
                        }
                    }
                }
                else if(tile.getChessPiece().getPieceType() == PieceType.KING)
                {
                    Point temp = tile.getLocation();                    
                    temp.y ++;
                    if(temp.isValidPoint() == true)
                    {
                        if(ChessBoard_1.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();
                    temp.x ++;
                    temp.y ++;
                    if(temp.isValidPoint() == true)
                    {
                        if(ChessBoard_1.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();
                    temp.x ++;                    
                    if(temp.isValidPoint() == true)
                    {
                        if(ChessBoard_1.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();
                    temp.x ++;
                    temp.y --;
                    if(temp.isValidPoint() == true)
                    {
                        if(ChessBoard_1.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();                    
                    temp.y --;
                    if(temp.isValidPoint() == true)
                    {
                        if(ChessBoard_1.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();
                    temp.x --;
                    temp.y --;
                    if(temp.isValidPoint() == true)
                    {
                        if(ChessBoard_1.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();
                    temp.x --;                    
                    if(temp.isValidPoint() == true)
                    {
                        if(ChessBoard_1.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
                        {
                            array.add(temp);
                        }
                    }
                    temp = tile.getLocation();
                    temp.x --;
                    temp.y ++;
                    if(temp.isValidPoint() == true)
                    {
                        if(ChessBoard_1.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
                        {
                            array.add(temp);
                        }
                    }
                }
            }
            //determines which way certain pieces can move pawns for example move different directions
            //based on which team they are on
            else if(tile.getChessPiece().getSide() == Side.WHITE)
            {
                if(tile.getChessPiece().getPieceType() == PieceType.PAWN)
                {
                    if(tile.getChessPiece().getHasMoved() == false  && tile.getLocation().north().isValidPoint() == true)
                    {
                        if(tile.getLocation().north().equals(new Empty()))
                        {
                            array.add(tile.getLocation().north());
                            if(tile.getLocation().north().north().equals(new Empty()))
                            {
                                array.add(tile.getLocation().north().north());
                            }
                        }
                        //check the se tile to see if there is a piece
                        if(tile.getLocation().ne().isValidPoint() == true)
                        {
                            if(ChessBoard_1.getBoardChessPiece(tile.getLocation().ne()).getPieceType() != PieceType.EMPTY)
                            {    
                                //check to see if that piece is the same color
                                if(tile.getChessPiece().getSide() != ChessBoard_1.getBoardChessPiece(tile.getLocation().ne()).getSide())
                                {
                                    array.add(tile.getLocation().ne());
                                }
                            }
                        }
                         
                        if(tile.getLocation().nw().isValidPoint() == true)
                        {
                            //check the sw tile to see if there is a piece
                            if(ChessBoard_1.getBoardChessPiece(tile.getLocation().nw()).getPieceType() != PieceType.EMPTY)
                            {
                                //check to see if that piece is the same color
                                if(tile.getChessPiece().getSide() != ChessBoard_1.getBoardChessPiece(tile.getLocation().nw()).getSide())
                                {
                                    array.add(tile.getLocation().nw());
                                }
                            }
                        }                        
                    }
                    
                    else
                    {
                        if(tile.getLocation().north().equals(new Empty()))
                        {
                            array.add(tile.getLocation().north());                            
                        }
                        //check the se tile to see if there is a piece
                        if(tile.getLocation().ne().isValidPoint() == true)
                        {
                            if(ChessBoard_1.getBoardChessPiece(tile.getLocation().ne()).getPieceType() != PieceType.EMPTY)
                            {    
                                //check to see if that piece is the same color
                                if(tile.getChessPiece().getSide() != ChessBoard_1.getBoardChessPiece(tile.getLocation().ne()).getSide())
                                {
                                    array.add(tile.getLocation().ne());
                                }
                            }
                        }
                         
                        if(tile.getLocation().nw().isValidPoint() == true)
                        {
                            //check the sw tile to see if there is a piece
                            if(ChessBoard_1.getBoardChessPiece(tile.getLocation().nw()).getPieceType() != PieceType.EMPTY)
                            {
                                //check to see if that piece is the same color
                                if(tile.getChessPiece().getSide() != ChessBoard_1.getBoardChessPiece(tile.getLocation().nw()).getSide())
                                {
                                    array.add(tile.getLocation().nw());
                                }
                            }
                        }                        
                    }
                }
                else if(tile.getChessPiece().getPieceType() == PieceType.ROOK)
                {
                                        
                }
                else if(tile.getChessPiece().getPieceType() == PieceType.BISHOP)
                {

                }
                else if(tile.getChessPiece().getPieceType() == PieceType.KNIGHT)
                {

                }
                else if(tile.getChessPiece().getPieceType() == PieceType.QUEEN)
                {

                }
                else if(tile.getChessPiece().getPieceType() == PieceType.KING)
                {

                }
            }
            
        }
        
        return array;
    }
}
