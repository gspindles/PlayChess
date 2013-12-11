/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
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
    public static List<Move> movePawn(Tile tile, ChessBoard board)
    {
        List<Move> array = new ArrayList<Move>();
        //if the pawn has not moved yet
        if(tile.getChessPiece().getSide() == Side.BLACK)
        {
            if (tile.getChessPiece().getHasMoved() == false && tile.getLocation().south().isValidPoint() == true) 
            {
                if (board.getBoardTile(tile.getLocation().south()).getChessPiece().getPieceType() == PieceType.EMPTY) 
                {
                    array.add(new Move(tile.getLocation(),tile.getLocation().south(), tile.getChessPiece()));
                    if (board.getBoardTile(tile.getLocation().south().south()).getChessPiece().getPieceType() == PieceType.EMPTY) 
                    {
                        array.add(new Move(tile.getLocation(),tile.getLocation().south().south(),tile.getChessPiece()));
                        tile.getChessPiece().setHasMoved();
                    }
                }
                //check the se tile to see if there is a piece
                if (tile.getLocation().se().isValidPoint() == true) 
                {
                    if (board.getBoardChessPiece(tile.getLocation().se()).getPieceType() != PieceType.EMPTY) 
                    {
                        //check to see if that piece is the same color
                        if (tile.getChessPiece().getSide() != board.getBoardChessPiece(tile.getLocation().se()).getSide()) 
                        {                            
                                array.add(new Move(tile.getLocation(),tile.getLocation().se(),tile.getChessPiece(),board.getBoardChessPiece(tile.getLocation().se())));
                                tile.getChessPiece().setHasMoved();
                        }
                    }
                }

                if (tile.getLocation().sw().isValidPoint() == true) 
                {
                    //check the sw tile to see if there is a piece
                    if (board.getBoardChessPiece(tile.getLocation().sw()).getPieceType() != PieceType.EMPTY) 
                    {
                        //check to see if that piece is the same color
                        if (tile.getChessPiece().getSide() != board.getBoardChessPiece(tile.getLocation().sw()).getSide()) 
                        {
                            array.add(new Move(tile.getLocation(),tile.getLocation().sw(),tile.getChessPiece(),board.getBoardChessPiece(tile.getLocation().sw())));
                        }
                    }
                }
            } //if the pawn has moved
            else 
            {
                if (tile.getLocation().south().isValidPoint() == true) 
                {
                    if(board.getBoardTile(tile.getLocation().south()).getChessPiece().getPieceType() == PieceType.EMPTY)
                    {
                        array.add(new Move(tile.getLocation(),tile.getLocation().south(),tile.getChessPiece()));
                    }                    
                }
                //check the se tile to see if there is a piece
                if (tile.getLocation().se().isValidPoint() == true) 
                {
                    if (board.getBoardChessPiece(tile.getLocation().se()).getPieceType() != PieceType.EMPTY) 
                    {
                        //check to see if that piece is the same color
                        if (tile.getChessPiece().getSide() != board.getBoardChessPiece(tile.getLocation().se()).getSide()) 
                        {
                            array.add(new Move(tile.getLocation(),tile.getLocation().se(),tile.getChessPiece(),board.getBoardChessPiece(tile.getLocation().se())));
                        }
                    }
                }

                if (tile.getLocation().sw().isValidPoint() == true) 
                {
                    //check the sw tile to see if there is a piece
                    if (board.getBoardChessPiece(tile.getLocation().sw()).getPieceType() != PieceType.EMPTY) 
                    {
                        //check to see if that piece is the same color
                        if (tile.getChessPiece().getSide() != board.getBoardChessPiece(tile.getLocation().sw()).getSide()) 
                        {
                            array.add(new Move(tile.getLocation(),tile.getLocation().sw(),tile.getChessPiece(),board.getBoardChessPiece(tile.getLocation().sw())));
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
                        if(board.getBoardTile(tile.getLocation().north()).getChessPiece().getPieceType() == PieceType.EMPTY )
                        {                            
                            array.add(new Move(tile.getLocation(),tile.getLocation().north(),tile.getChessPiece()));
                            if(board.getBoardTile(tile.getLocation().north().north()).getChessPiece().getPieceType() == PieceType.EMPTY)
                            {
                                array.add(new Move(tile.getLocation(),tile.getLocation().north().north(),tile.getChessPiece()));
                            }
                        }
                        //check the se tile to see if there is a piece
                        if(tile.getLocation().ne().isValidPoint() == true)
                        {
                            if(board.getBoardChessPiece(tile.getLocation().ne()).getPieceType() != PieceType.EMPTY)
                            {    
                                //check to see if that piece is the same color
                                if(tile.getChessPiece().getSide() != board.getBoardChessPiece(tile.getLocation().ne()).getSide())
                                {
                                    array.add(new Move(tile.getLocation(),tile.getLocation().ne(),tile.getChessPiece(),board.getBoardChessPiece(tile.getLocation().ne())));
                                }
                            }
                        }
                         
                        if(tile.getLocation().nw().isValidPoint() == true)
                        {
                            //check the sw tile to see if there is a piece
                            if(board.getBoardChessPiece(tile.getLocation().nw()).getPieceType() != PieceType.EMPTY)
                            {
                                //check to see if that piece is the same color
                                if(tile.getChessPiece().getSide() != board.getBoardChessPiece(tile.getLocation().nw()).getSide())
                                {
                                    array.add(new Move(tile.getLocation(),tile.getLocation().nw(),tile.getChessPiece(),board.getBoardChessPiece(tile.getLocation().nw())));
                                }
                            }
                        }                        
                    }
                    
                    else
                    {
                        if(tile.getLocation().north().isValidPoint() == true)
                        {
                            if(board.getBoardTile(tile.getLocation().north()).getChessPiece().getPieceType() == PieceType.EMPTY)
                            {
                                array.add(new Move(tile.getLocation(),tile.getLocation().north(),tile.getChessPiece()));
                            }
                        }
                        //check the se tile to see if there is a piece
                        if(tile.getLocation().ne().isValidPoint() == true)
                        {
                            if(board.getBoardChessPiece(tile.getLocation().ne()).getPieceType() != PieceType.EMPTY)
                            {    
                                //check to see if that piece is the same color
                                if(tile.getChessPiece().getSide() != board.getBoardChessPiece(tile.getLocation().ne()).getSide())
                                {
                                    array.add(new Move(tile.getLocation(),tile.getLocation().ne(),tile.getChessPiece(),board.getBoardChessPiece(tile.getLocation().ne())));
                                }
                            }
                        }
                         
                        if(tile.getLocation().nw().isValidPoint() == true)
                        {
                            //check the sw tile to see if there is a piece
                            if(board.getBoardChessPiece(tile.getLocation().nw()).getPieceType() != PieceType.EMPTY)
                            {
                                //check to see if that piece is the same color
                                if(tile.getChessPiece().getSide() != board.getBoardChessPiece(tile.getLocation().nw()).getSide())
                                {
                                    array.add(new Move(tile.getLocation(),tile.getLocation().nw(),tile.getChessPiece(),board.getBoardChessPiece(tile.getLocation().nw())));
                                }
                            }
                        }                        
                    }
                }
        }
        return array;
        
    }
    public static List<Move> moveRook(Tile tile, ChessBoard board)
    {
        List<Move> array = new ArrayList<Move>();
        Point temp = new Point(tile.getLocation().x,tile.getLocation().y);
                while(temp.north().isValidPoint())
                {
                    temp.y ++;
                    if(board.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
                    {
                        if(board.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                        {
                            break;
                        }
                         array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                        break;
                    }
                    else
                    {
                        array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                    }
                }
                temp.x = tile.getLocation().x;
                temp.y = tile.getLocation().y;                
                while(temp.isValidPoint(temp.south()))
                {                     
                    temp.y --;
                    if(board.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
                    {
                        if(board.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                        {
                            break;
                        }
                        array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                        break;
                    }
                    else
                    {
                        array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                    }
                }
                temp.x = tile.getLocation().x;
                temp.y = tile.getLocation().y;
                while(temp.isValidPoint(temp.east()))
                {
                    temp.x++;
                    if(board.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
                    {
                        if(board.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                        {
                            break;
                        }
                        array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                        break;
                    }
                    else
                    {
                        array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                    }
                }
                temp.x = tile.getLocation().x;
                temp.y = tile.getLocation().y;
                while(temp.isValidPoint(temp.west()))
                {
                   temp.x --;
                    if(board.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
                    {
                        if(board.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                        {
                            break;
                        }
                        array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                        break;
                    }
                    else
                    {
                        array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                    }
                }        
        return array;
    }
    public static List<Move> moveKnight(Tile tile, ChessBoard board)
    {
        List<Move> array = new ArrayList<Move>();
        Point temp = new Point();
        temp.x = tile.getLocation().x;
        temp.y = tile.getLocation().y;
        temp.x ++;
        temp.y +=2;
        if(temp.isValidPoint() == true)
        {
            if(board.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(board.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp.x = tile.getLocation().x;
        temp.y = tile.getLocation().y;
        temp.x --;
        temp.y +=2;
        if(temp.isValidPoint() == true)
        {
            if(board.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(board.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp.x = tile.getLocation().x;
        temp.y = tile.getLocation().y;        
        temp.x +=2;
        temp.y ++;
        if(temp.isValidPoint() == true)
        {
            if(board.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(board.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp.x = tile.getLocation().x;
        temp.y = tile.getLocation().y;
        temp.x +=2;
        temp.y --;
        if(temp.isValidPoint() == true)
        {
            if(board.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(board.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp.x = tile.getLocation().x;
        temp.y = tile.getLocation().y;
        temp.x ++;
        temp.y -=2;
        if(temp.isValidPoint() == true)
        {
            if(board.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(board.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp.x = tile.getLocation().x;
        temp.y = tile.getLocation().y;
        temp.x --;
        temp.y -=2;
        if(temp.isValidPoint() == true)
        {
            if(board.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(board.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp.x = tile.getLocation().x;
        temp.y = tile.getLocation().y;
        temp.x -=2;
        temp.y ++;
        if(temp.isValidPoint() == true)
        {
            if(board.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(board.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp.x = tile.getLocation().x;         
        temp.y = tile.getLocation().y;
        temp.x -=2;
        temp.y --;
        if(temp.isValidPoint() == true)
        {
            if(board.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(board.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        return array;
    }
    public static List<Move> moveBishop(Tile tile,ChessBoard board)
    {
        List<Move> array = new ArrayList<Move>();
        Point temp = new Point();
        temp.x = tile.getLocation().x;         
        temp.y = tile.getLocation().y;
        while (temp.ne().isValidPoint()) 
        {
            temp.y++;
            temp.x++;
            if (board.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY) 
            {
                if (board.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide()) 
                {
                    break;
                }
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                break;
            } 
            else 
            {
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
            }
        }
        temp.x = tile.getLocation().x;         
        temp.y = tile.getLocation().y;
        while (temp.se().isValidPoint()) 
        {
            temp.y--;
            temp.x++;
            if (board.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY) 
            {
                if (board.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide()) 
                {
                    break;
                }
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                break;
            } 
            else 
            {
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
            }
        }
        temp.x = tile.getLocation().x;         
        temp.y = tile.getLocation().y;
        while (temp.nw().isValidPoint()) 
        {
            temp.y++;
            temp.x--;
            if (board.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY) 
            {
                if (board.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide()) 
                {
                    break;
                }
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                break;
            } 
            else 
            {
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
            }
        }
        temp.x = tile.getLocation().x;         
        temp.y = tile.getLocation().y;
        while (temp.sw().isValidPoint()) 
        {
            temp.y--;
            temp.x--;
            if (board.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY) 
            {
                if (board.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide()) 
                {
                    break;
                }
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                break;
            } 
            else 
            {
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
            }
        }
        return array;
    }
    public static List<Move> moveQueen(Tile tile,ChessBoard board)
    {
        List<Move> array = new ArrayList<Move>();
        Point temp = new Point();
        temp.x = tile.getLocation().x;         
        temp.y = tile.getLocation().y;
        while(temp.north().isValidPoint())
        {
            temp.y ++;
            if(board.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
            {
                if(board.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                {
                    break;
                }
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                break;
            }
            else
            {
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
            }
        }
        temp.x = tile.getLocation().x;         
        temp.y = tile.getLocation().y;
        while(temp.south().isValidPoint())
        {
            temp.y --;
            if(board.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
            {
                if(board.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                {
                    break;
                }
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                break;
            }
            else
            {
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
            }
        }
        temp.x = tile.getLocation().x;         
        temp.y = tile.getLocation().y;
        while(temp.east().isValidPoint())
        {
            temp.x ++;
            if(board.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
            {
                if(board.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                {
                    break;
                }
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                break;
            }
            else
            {
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
            }
        }
        temp.x = tile.getLocation().x;         
        temp.y = tile.getLocation().y;
        while(temp.west().isValidPoint())
        {
            temp.x --;
            if(board.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
            {
                if(board.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                {
                    break;
                }
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
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
            if(board.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
            {
                if(board.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                {
                    break;
                }
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                break;
            }
            else
            {
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
            }
        }
        temp.x = tile.getLocation().x;         
        temp.y = tile.getLocation().y;
        while(temp.se().isValidPoint())
        {
            temp.y --;
            temp.x ++;
            if(board.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
            {
                if(board.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                {
                    break;
                }
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                break;
            }
            else
            {
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
            }
        }
        temp.x = tile.getLocation().x;         
        temp.y = tile.getLocation().y;
        while(temp.nw().isValidPoint())
        {
            temp.y ++;
            temp.x --;
            if(board.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
            {
                if(board.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                {
                    break;
                }
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                break;
            }
            else
            {
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
            }
        }
        temp.x = tile.getLocation().x;         
        temp.y = tile.getLocation().y;
        while(temp.sw().isValidPoint())
        {
            temp.y --;
            temp.x --;
            if(board.getBoardChessPiece(temp).getPieceType() != PieceType.EMPTY)
            {
                if(board.getBoardChessPiece(temp).getSide() == tile.getChessPiece().getSide())
                {
                    break;
                }
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                break;
            }
            else
            {
                array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
            }
        }
        return array;
    }
    public static List<Move> moveKing(Tile tile, ChessBoard board)
    {
        List<Move> array = new ArrayList<Move>();
        Point temp = new Point();
        temp.x = tile.getLocation().x;         
        temp.y = tile.getLocation().y;
        temp.y ++;
        if(temp.isValidPoint() == true)
        {
            if(board.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(board.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp.x = tile.getLocation().x;         
        temp.y = tile.getLocation().y;
        temp.x ++;
        temp.y ++;
        if(temp.isValidPoint() == true)
        {
            if(board.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(board.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp.x = tile.getLocation().x;         
        temp.y = tile.getLocation().y;
        temp.x ++;                    
        if(temp.isValidPoint() == true)
        {
            if(board.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(board.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp.x = tile.getLocation().x;         
        temp.y = tile.getLocation().y;
        temp.x ++;
        temp.y --;
        if(temp.isValidPoint() == true)
        {
            if(board.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(board.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp.x = tile.getLocation().x;         temp.y = tile.getLocation().y;                    
        temp.y --;
        if(temp.isValidPoint() == true)
        {
            if(board.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(board.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp.x = tile.getLocation().x;         
        temp.y = tile.getLocation().y;
        temp.x --;
        temp.y --;
        if(temp.isValidPoint() == true)
        {
            if(board.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(board.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp.x = tile.getLocation().x;         
        temp.y = tile.getLocation().y;
        temp.x --;                    
        if(temp.isValidPoint() == true)
        {
            if(board.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(board.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        temp.x = tile.getLocation().x;         
        temp.y = tile.getLocation().y;
        temp.x --;
        temp.y ++;
        if(temp.isValidPoint() == true)
        {
            if(board.getBoardChessPiece(temp).getSide() != tile.getChessPiece().getSide())
            {
                if(board.getBoardChessPiece(temp).pieceType != PieceType.EMPTY)
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece(),board.getBoardChessPiece(temp)));
                }
                else
                {
                    array.add(new Move(tile.getLocation(),temp, tile.getChessPiece()));
                }
            }
        }
        return array;    
    }
    public static List<Move> determineMoves(Tile tile, ChessBoard board)
    {
        List<Move> array = new ArrayList<Move>();
        Point pt = new Point();
        pt.x = tile.getLocation().x;
        pt.y = tile.getLocation().y;
        if(tile.getChessPiece().pieceType == PieceType.EMPTY)
        {
            
        }
        else
        {
            //determines which way certain pieces can move pawns for example move different directions
            //based on which team they are on
                        
            if(tile.getChessPiece().getPieceType() == PieceType.PAWN)
            { 
                array = movePawn(tile, board);
            }
            else if(tile.getChessPiece().getPieceType() == PieceType.ROOK)
            {
                array = moveRook(tile, board);
            }
            else if(tile.getChessPiece().getPieceType() == PieceType.BISHOP)
            {
                array = moveBishop(tile, board);
            }
            else if(tile.getChessPiece().getPieceType() == PieceType.KNIGHT)
            {
                array = moveKnight(tile, board);
            }
            //literally copy pasted code from Rook and Bishop
            else if(tile.getChessPiece().getPieceType() == PieceType.QUEEN)
            {
                array = moveQueen(tile, board);
            }
            else if(tile.getChessPiece().getPieceType() == PieceType.KING)
            {
                array = moveKing(tile, board);
            }
        }
        
        return array;
    }
    /**
     * 
     * @param s the color of the king you are checking
     * @return if it is checkmate or not
     */
    public static boolean checkmate(Side s,ChessBoard board)
    {
        List<Move> enemyMoves = AI.populateMoves(s, board);
        List<Move> kingMoves = MoveLogic.moveKing(board.getBoardTile(board.getKing(s)), board);
        if(s == Side.WHITE)
        {
            for(int i = 0; i < enemyMoves.size();i++)
            {
                for(int j = 0; j < kingMoves.size(); j++)
                {
                    if(enemyMoves.get(i).getEnd() == kingMoves.get(j).getEnd())
                    {
                        kingMoves.remove(j);
                        j--;
                    }
                }
            }            
        }
        else if (s == Side.BLACK)
        {
            
        }
        if(kingMoves.size() == 0)
        {
            return true;
        }
        return false;
    }
    public static boolean determineCheck(Side s,ChessBoard board)
    {
        List<Move> enemyMoves = AI.populateMoves(s, board);
        for(int i = 0; i < enemyMoves.size();i++)
        {
            if(enemyMoves.get(i).getEnd() == board.getKing(s))
            {
                return true;
            }
        }
        return false;
    }
}
