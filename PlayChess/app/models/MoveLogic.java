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
    public static List<Move> movePawn(Tile tile)
    {
        List<Move> array = new ArrayList<Move>();
        //if the pawn has not moved yet
        if(tile.getChessPiece().getSide() == Side.BLACK)
        {
            if (tile.getChessPiece().getHasMoved() == false && tile.getLocation().south().isValidPoint() == true) 
            {
                if (tile.getLocation().south().equals(new Empty())) 
                {
                    array.add(new Move(tile.getLocation(),tile.getLocation().south(), tile.getChessPiece()));
                    if (tile.getLocation().south().south().equals(new Empty())) 
                    {
                        array.add(new Move(tile.getLocation(),tile.getLocation().south().south(),tile.getChessPiece()));
                    }
                }
                //check the se tile to see if there is a piece
                if (tile.getLocation().se().isValidPoint() == true) {
                    if (ChessBoard.getBoardChessPiece(tile.getLocation().se()).getPieceType() != PieceType.EMPTY) 
                    {
                        //check to see if that piece is the same color
                        if (tile.getChessPiece().getSide() != ChessBoard.getBoardChessPiece(tile.getLocation().se()).getSide()) 
                        {                            
                                array.add(new Move(tile.getLocation(),tile.getLocation().se(),tile.getChessPiece(),ChessBoard.getBoardChessPiece(tile.getLocation().se()) ));                            
                        }
                    }
                }

                if (tile.getLocation().sw().isValidPoint() == true) 
                {
                    //check the sw tile to see if there is a piece
                    if (ChessBoard.getBoardChessPiece(tile.getLocation().sw()).getPieceType() != PieceType.EMPTY) 
                    {
                        //check to see if that piece is the same color
                        if (tile.getChessPiece().getSide() != ChessBoard.getBoardChessPiece(tile.getLocation().sw()).getSide()) 
                        {
                            array.add(new Move(tile.getLocation(),tile.getLocation().sw(),tile.getChessPiece(),ChessBoard.getBoardChessPiece(tile.getLocation().sw())));
                        }
                    }
                }
            } //if the pawn has not moved
            else 
            {
                if (tile.getLocation().south().equals(new Empty())) 
                {
                    array.add(new Move(tile.getLocation(),tile.getLocation().south(),tile.getChessPiece()));
                }
                //check the se tile to see if there is a piece
                if (tile.getLocation().se().isValidPoint() == true) {
                    if (ChessBoard.getBoardChessPiece(tile.getLocation().se()).getPieceType() != PieceType.EMPTY) 
                    {
                        //check to see if that piece is the same color
                        if (tile.getChessPiece().getSide() != ChessBoard.getBoardChessPiece(tile.getLocation().se()).getSide()) 
                        {
                            array.add(new Move(tile.getLocation(),tile.getLocation().se(),tile.getChessPiece(),ChessBoard.getBoardChessPiece(tile.getLocation().se())));
                        }
                    }
                }

                if (tile.getLocation().sw().isValidPoint() == true) 
                {
                    //check the sw tile to see if there is a piece
                    if (ChessBoard.getBoardChessPiece(tile.getLocation().sw()).getPieceType() != PieceType.EMPTY) 
                    {
                        //check to see if that piece is the same color
                        if (tile.getChessPiece().getSide() != ChessBoard.getBoardChessPiece(tile.getLocation().sw()).getSide()) 
                        {
                            array.add(new Move(tile.getLocation(),tile.getLocation().sw(),tile.getChessPiece(),ChessBoard.getBoardChessPiece(tile.getLocation().sw())));
                        }
                    }
                }
            }            
        }
        else if(tile.getChessPiece().getSide() == Side.WHITE)
        {
            if(tile.getChessPiece().getPieceType() == PieceType.PAWN)
                {
                    if(tile.getChessPiece().getHasMoved() == false  && tile.getLocation().north().isValidPoint() == true)
                    {
                        if(tile.getLocation().north().equals(new Empty()))
                        {
                            array.add(new Move(tile.getLocation(),tile.getLocation().north(),tile.getChessPiece()));
                            if(tile.getLocation().north().north().equals(new Empty()))
                            {
                                array.add(new Move(tile.getLocation(),tile.getLocation().north().north(),tile.getChessPiece()));
                            }
                        }
                        //check the se tile to see if there is a piece
                        if(tile.getLocation().ne().isValidPoint() == true)
                        {
                            if(ChessBoard.getBoardChessPiece(tile.getLocation().ne()).getPieceType() != PieceType.EMPTY)
                            {    
                                //check to see if that piece is the same color
                                if(tile.getChessPiece().getSide() != ChessBoard.getBoardChessPiece(tile.getLocation().ne()).getSide())
                                {
                                    array.add(new Move(tile.getLocation(),tile.getLocation().ne(),tile.getChessPiece(),ChessBoard.getBoardChessPiece(tile.getLocation().ne())));
                                }
                            }
                        }
                         
                        if(tile.getLocation().nw().isValidPoint() == true)
                        {
                            //check the sw tile to see if there is a piece
                            if(ChessBoard.getBoardChessPiece(tile.getLocation().nw()).getPieceType() != PieceType.EMPTY)
                            {
                                //check to see if that piece is the same color
                                if(tile.getChessPiece().getSide() != ChessBoard.getBoardChessPiece(tile.getLocation().nw()).getSide())
                                {
                                    array.add(new Move(tile.getLocation(),tile.getLocation().nw(),tile.getChessPiece(),ChessBoard.getBoardChessPiece(tile.getLocation().nw())));
                                }
                            }
                        }                        
                    }
                    
                    else
                    {
                        if(tile.getLocation().north().equals(new Empty()))
                        {
                            array.add(new Move(tile.getLocation(),tile.getLocation().north(),tile.getChessPiece()));                            
                        }
                        //check the se tile to see if there is a piece
                        if(tile.getLocation().ne().isValidPoint() == true)
                        {
                            if(ChessBoard.getBoardChessPiece(tile.getLocation().ne()).getPieceType() != PieceType.EMPTY)
                            {    
                                //check to see if that piece is the same color
                                if(tile.getChessPiece().getSide() != ChessBoard.getBoardChessPiece(tile.getLocation().ne()).getSide())
                                {
                                    array.add(new Move(tile.getLocation(),tile.getLocation().ne(),tile.getChessPiece(),ChessBoard.getBoardChessPiece(tile.getLocation().ne())));
                                }
                            }
                        }
                         
                        if(tile.getLocation().nw().isValidPoint() == true)
                        {
                            //check the sw tile to see if there is a piece
                            if(ChessBoard.getBoardChessPiece(tile.getLocation().nw()).getPieceType() != PieceType.EMPTY)
                            {
                                //check to see if that piece is the same color
                                if(tile.getChessPiece().getSide() != ChessBoard.getBoardChessPiece(tile.getLocation().nw()).getSide())
                                {
                                    array.add(new Move(tile.getLocation(),tile.getLocation().nw(),tile.getChessPiece(),ChessBoard.getBoardChessPiece(tile.getLocation().nw())));
                                }
                            }
                        }                        
                    }
                }
        }
        return array;
        
    }
    public static List<Move> moveRook(Tile tile)
    {
        List<Move> array = new ArrayList<Move>();        
        Point temp = tile.getLocation();            
                while(temp.north().isValidPoint())
                {
                    temp.y ++;
                    if(ChessBoard.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
                    {
                        if(ChessBoard.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                        {
                            break;
                        }
                         array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                        break;
                    }
                    else
                    {
                        array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                    }
                }
                temp = tile.getLocation();
                while(temp.south().isValidPoint())
                {                     temp.y --;
                    if(ChessBoard.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
                    {
                        if(ChessBoard.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                        {
                            break;
                        }
                        array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                        break;
                    }
                    else
                    {
                        array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                    }
                }
                temp = tile.getLocation();
                while(temp.east().isValidPoint())
                {
                    temp.x ++;
                    if(ChessBoard.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
                    {
                        if(ChessBoard.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                        {
                            break;
                        }
                        array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                        break;
                    }
                    else
                    {
                        array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                    }
                }
                temp = tile.getLocation();
                while(temp.west().isValidPoint())
                {
                   temp.x --;
                    if(ChessBoard.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
                    {
                        if(ChessBoard.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                        {
                            break;
                        }
                        array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                        break;
                    }
                    else
                    {
                        array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                    }
                }        
        return array;
    }
    public static List<Move> moveKnight(Tile tile)
    {
        List<Move> array = new ArrayList<Move>();
        Point temp = tile.getLocation();
        temp.x ++;
        temp.y +=2;
        if(temp.isValidPoint() == true)
        {
            if(ChessBoard.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(ChessBoard.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp = tile.getLocation();
        temp.x --;
        temp.y +=2;
        if(temp.isValidPoint() == true)
        {
            if(ChessBoard.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(ChessBoard.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp = tile.getLocation();
        temp.x +=2;
        temp.y ++;
        if(temp.isValidPoint() == true)
        {
            if(ChessBoard.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(ChessBoard.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp = tile.getLocation();
        temp.x +=2;
        temp.y --;
        if(temp.isValidPoint() == true)
        {
            if(ChessBoard.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(ChessBoard.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp = tile.getLocation();
        temp.x ++;
        temp.y -=1;
        if(temp.isValidPoint() == true)
        {
            if(ChessBoard.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(ChessBoard.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp = tile.getLocation();
        temp.x --;
        temp.y -=1;
        if(temp.isValidPoint() == true)
        {
            if(ChessBoard.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(ChessBoard.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp = tile.getLocation();
        temp.x +=2;
        temp.y ++;
        if(temp.isValidPoint() == true)
        {
            if(ChessBoard.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(ChessBoard.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp = tile.getLocation();
        temp.x +=2;
        temp.y --;
        if(temp.isValidPoint() == true)
        {
            if(ChessBoard.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(ChessBoard.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        return array;
    }
    public static List<Move> moveBishop(Tile tile)
    {
        List<Move> array = new ArrayList<Move>();
        Point temp = tile.getLocation();
        while (temp.ne().isValidPoint()) 
        {
            temp.y++;
            temp.x++;
            if (ChessBoard.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY) 
            {
                if (ChessBoard.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide()) 
                {
                    break;
                }
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                break;
            } 
            else 
            {
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
            }
        }
        temp = tile.getLocation();
        while (temp.se().isValidPoint()) 
        {
            temp.y--;
            temp.x++;
            if (ChessBoard.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY) 
            {
                if (ChessBoard.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide()) 
                {
                    break;
                }
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                break;
            } 
            else 
            {
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
            }
        }
        temp = tile.getLocation();
        while (temp.nw().isValidPoint()) 
        {
            temp.y++;
            temp.x--;
            if (ChessBoard.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY) 
            {
                if (ChessBoard.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide()) 
                {
                    break;
                }
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                break;
            } 
            else 
            {
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
            }
        }
        temp = tile.getLocation();
        while (temp.sw().isValidPoint()) 
        {
            temp.y--;
            temp.x--;
            if (ChessBoard.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY) 
            {
                if (ChessBoard.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide()) 
                {
                    break;
                }
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                break;
            } 
            else 
            {
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
            }
        }
        return array;
    }
    public static List<Move> moveQueen(Tile tile)
    {
        List<Move> array = new ArrayList<Move>();
        Point temp = tile.getLocation();
        while(temp.north().isValidPoint())
        {
            temp.y ++;
            if(ChessBoard.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
            {
                if(ChessBoard.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                {
                    break;
                }
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                break;
            }
            else
            {
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
            }
        }
        temp = tile.getLocation();
        while(temp.south().isValidPoint())
        {
            temp.y --;
            if(ChessBoard.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
            {
                if(ChessBoard.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                {
                    break;
                }
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                break;
            }
            else
            {
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
            }
        }
        temp = tile.getLocation();
        while(temp.east().isValidPoint())
        {
            temp.x ++;
            if(ChessBoard.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
            {
                if(ChessBoard.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                {
                    break;
                }
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                break;
            }
            else
            {
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
            }
        }
        temp = tile.getLocation();
        while(temp.west().isValidPoint())
        {
            temp.x --;
            if(ChessBoard.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
            {
                if(ChessBoard.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                {
                    break;
                }
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                break;
            }
            else
            {
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
            }
        }                                

        while(temp.ne().isValidPoint())
        {
            temp.y ++;
            temp.x ++;
            if(ChessBoard.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
            {
                if(ChessBoard.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                {
                    break;
                }
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                break;
            }
            else
            {
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
            }
        }
        temp = tile.getLocation();
        while(temp.se().isValidPoint())
        {
            temp.y --;
            temp.x ++;
            if(ChessBoard.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
            {
                if(ChessBoard.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                {
                    break;
                }
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                break;
            }
            else
            {
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
            }
        }
        temp = tile.getLocation();
        while(temp.nw().isValidPoint())
        {
            temp.y ++;
            temp.x --;
            if(ChessBoard.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
            {
                if(ChessBoard.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                {
                    break;
                }
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                break;
            }
            else
            {
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
            }
        }
        temp = tile.getLocation();
        while(temp.sw().isValidPoint())
        {
            temp.y --;
            temp.x --;
            if(ChessBoard.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
            {
                if(ChessBoard.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                {
                    break;
                }
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                break;
            }
            else
            {
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
            }
        }
        return array;
    }
    public static List<Move> moveKing(Tile tile)
    {
        List<Move> array = new ArrayList<Move>();
        Point temp = tile.getLocation();                    
        temp.y ++;
        if(temp.isValidPoint() == true)
        {
            if(ChessBoard.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(ChessBoard.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }                
            }
        }
        temp = tile.getLocation();
        temp.x ++;
        temp.y ++;
        if(temp.isValidPoint() == true)
        {
            if(ChessBoard.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(ChessBoard.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp = tile.getLocation();
        temp.x ++;                    
        if(temp.isValidPoint() == true)
        {
            if(ChessBoard.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(ChessBoard.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp = tile.getLocation();
        temp.x ++;
        temp.y --;
        if(temp.isValidPoint() == true)
        {
            if(ChessBoard.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(ChessBoard.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp = tile.getLocation();                    
        temp.y --;
        if(temp.isValidPoint() == true)
        {
            if(ChessBoard.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(ChessBoard.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp = tile.getLocation();
        temp.x --;
        temp.y --;
        if(temp.isValidPoint() == true)
        {
            if(ChessBoard.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(ChessBoard.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp = tile.getLocation();
        temp.x --;                    
        if(temp.isValidPoint() == true)
        {
            if(ChessBoard.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(ChessBoard.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp = tile.getLocation();
        temp.x --;
        temp.y ++;
        if(temp.isValidPoint() == true)
        {
            if(ChessBoard.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(ChessBoard.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),ChessBoard.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        return array;    
    }
    public static List<Move> determineMoves(Tile tile)
    {
        List<Move> array = new ArrayList<Move>();
        Point pt = tile.getLocation();
        if(tile.getChessPiece().pieceType.name() == "EMPTY")
        {
            
        }
        else
        {
            //determines which way certain pieces can move pawns for example move different directions
            //based on which team they are on
                        
            if(tile.getChessPiece().getPieceType() == PieceType.PAWN)
            { 
                array = movePawn(tile);
            }
            else if(tile.getChessPiece().getPieceType() == PieceType.ROOK)
            {
                array = moveRook(tile);
            }
            else if(tile.getChessPiece().getPieceType() == PieceType.BISHOP)
            {
                array = moveBishop(tile);
            }
            else if(tile.getChessPiece().getPieceType() == PieceType.KNIGHT)
            {
                array = moveKnight(tile);
            }
            //literally copy pasted code from Rook and Bishop
            else if(tile.getChessPiece().getPieceType() == PieceType.QUEEN)
            {
                array = moveQueen(tile);
            }
            else if(tile.getChessPiece().getPieceType() == PieceType.KING)
            {
                array = moveKing(tile);
            }
        }
        
        return array;
    }
//    public static List<Move> determineMoves(Move initial, Move secondary)
//    {
//        List<Move> array = new ArrayList<Move>();
//        Point pt = tile.getLocation();
//    }
}
